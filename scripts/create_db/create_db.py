from scripts.load_data.download import download_jsons
from tinydb import TinyDB
import time

def create_tables():
    # check if table exist
    db = TinyDB('../DB/data_base.json', default_table='ventilators_data')
    i = 0
    while i < 5:
        for unit in download_jsons():
            db.insert(unit)
        #time.sleep(5)
        i += 1
create_tables()