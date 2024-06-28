import requests
import time
import re
import datetime
from bs4 import BeautifulSoup
import sys
import dbconnect

# スクレイピングするURL
PAGE_URL_BASE = "https://kakaku.com/pc/videocard/itemlist.aspx?pdf_pg="

# 取得するページ数
MAX_PAGE = 10

# 取得するページの製品数
PAGE_CONTENT_COUNT = 40

# スクレイピング実行間隔
REQUEST_INTERVAL = 3

# 追加クエリ
INSERT_SQL = """
  INSERT INTO gpu
  (product_id, url, product_name, price, release_date, chip, vram)
  VALUES
  (%s, %s, %s, %s, %s, %s, %s)
"""

# 削除クエリ
DELETE_SQL = "DELETE FROM gpu"

def clear_table(cursor, connection):
  cursor.execute(DELETE_SQL)
  connection.commit()

def insert_data(cursor, connection, data):
  cursor.execute(INSERT_SQL, data)
  connection.commit()

def read_html_file(page_number):
  page_url = PAGE_URL_BASE + str(page_number)
  result = requests.get(page_url).text.encode("utf-8")
  return BeautifulSoup(result, "html.parser")

def extract_data_from_soup(soup):
  elems = soup.find_all(class_="tr-border")
  data_list = []
  for i in range(0, PAGE_CONTENT_COUNT):
    try:
      id = elems[3*i+3].select("td")[0].select("a")[0]["href"].replace('https://kakaku.com/item/', '').replace('/', '')
      link = elems[3*i+3].select("td")[0].select("a")[0]["href"]
      price = elems[3*i+3].select("td")[1].select("ul")[0].select("li")[0].select("a")[0].get_text().replace('¥', '').replace(',', '')
      release = elems[3*i+3].select(".swdate1")[0].get_text().replace(' ', '')
      name = elems[3*i+2].select("td")[1].select("a")[0].get_text().replace('　', ' ')
      elems[3*i+3].select("td")[9].find("br").replace_with(" ")
      chip = elems[3*i+3].select("td")[9].get_text()
      elems[3*i+3].select("td")[10].find("br").replace_with(" ")
      vram = elems[3*i+3].select("td")[10].get_text()
      data = {
        "product_id"  : id,
        "url"         : link,
        "product_name": re.sub('\\[.+?\\]', '', name),
        "price"       : int(price),
        "release_date": release.replace('/', '-'),
        "chip"        : chip,
        "vram"        : vram,
      }
    except:
      data = {
        "product_id"  : None,
        "url"         : None,
        "product_name": None,
        "price"       : None,
        "release_date": None,
        "chip"        : None,
        "vram"        : None
      }
    data_list.append(data)
  return data_list

def process_and_insert_data(result, cursor, connection):
  count = 0
  for i in range(MAX_PAGE * PAGE_CONTENT_COUNT):
    release_date = result[i]["release_date"]
    if release_date is not None:
      timeStr = re.search('[0-9]+-[0-9]+-[0-9]+', result[i]["release_date"]).group()
      release_date = datetime.datetime.strptime(timeStr, "%Y-%m-%d").strftime('%Y-%m-%d')
    data = (
      result[i]["product_id"],
      result[i]["url"],
      result[i]["product_name"],
      result[i]["price"],
      release_date,
      result[i]["chip"],
      result[i]["vram"],
    )
    insert_data(cursor, connection, data)
    count += 1
  return count

def print_progress_bar(progress, total, bar_length=10):
    percent = float(progress) / total
    num_bars = int(round(percent * bar_length))
    bar = '=' * num_bars + '-' * (bar_length - num_bars)
    sys.stdout.write(f"\r[{bar}] {percent:.2%}")
    sys.stdout.flush()

def main():
  connection, cursor = dbconnect.connect()
  result = []

  for page in range(1, MAX_PAGE + 1):
    soup = read_html_file(page)
    page_data = extract_data_from_soup(soup)
    result.extend(page_data)
    print_progress_bar(page, MAX_PAGE)
    time.sleep(REQUEST_INTERVAL)

  clear_table(cursor, connection)
  insert_result = process_and_insert_data(result, cursor, connection)
  print(" Success INSERT " + str(insert_result))

  cursor.close()
  connection.close()

# if __name__ == "__main__":
#   main()