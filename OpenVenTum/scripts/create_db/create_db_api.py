from download import download_jsons
from tinydb import TinyDB
import time
import os

def create_table_api():
    # check if table exist
    db = TinyDB(os.getcwd() + '/scripts/DB/api_data_base.json', default_table='ventilators_data')
    try:
        while True:
            # insert data
            for unit in download_jsons():
                db.insert(unit)
            # sleep for 5 min
            time.sleep(5)
    except:
        db.close()

create_table_api()
