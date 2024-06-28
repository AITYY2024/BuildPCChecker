import scraping_cpu
import scraping_gpu
import scraping_memory
import scraping_mb
import scraping_ssd
import scraping_psu
import scraping_os

# 取得するページ数
MAX_PAGE = 5

# スクレイピング実行間隔
REQUEST_INTERVAL = 5

def main():
  print("-- CPU Scraping Start --")
  scraping_cpu.main()
  print("-- GPU Scraping Start --")
  scraping_gpu.main()
  print("-- MEMORY Scraping Start --")
  scraping_memory.main()
  print("-- MB Scraping Start --")
  scraping_mb.main()
  print("-- SSD Scraping Start --")
  scraping_ssd.main()
  print("-- PSU Scraping Start --")
  scraping_psu.main()
  print("-- OS Scraping Start --")
  scraping_os.main()
  print("-- ALL Scraping Success --")

if __name__ == "__main__":
  main()