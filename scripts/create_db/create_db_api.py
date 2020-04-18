from scripts.load_data.download import download_jsons
from scripts.library.tinydb import TinyDB
import time


def create_table_api():
    # check if table exist
    db = TinyDB('../DB/api_data_base.json', default_table='ventilators_data')
    while True:
        # insert data
        for unit in download_jsons():
            db.insert(unit)
        # sleep for 5 min
        time.sleep(5)


create_table_api()
