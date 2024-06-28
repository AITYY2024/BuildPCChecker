import psycopg2

# DB接続
HOST = "localhost"
DBNAME = "bpc_db"
USER = "testuser"
PASS = "test"

def connect():
  connection = psycopg2.connect("host=" + HOST + " dbname=" + DBNAME + " user=" + USER + " password=" + PASS)
  cursor = connection.cursor()
  # クライアントプログラムのエンコードを設定
  connection.set_client_encoding('utf-8')
  return connection, cursor