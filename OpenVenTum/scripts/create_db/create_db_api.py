from tinydb import TinyDB
import time
import os
from download import download_jsons
import argparse as ap
import os
parser = ap.ArgumentParser()
parser.add_argument('--t', type=int)
args = parser.parse_args()
t = args.t

def create_table_api(timer: int=1):
    # check if table exist
    db = TinyDB(os.getcwd() + '/scripts/DB/api_data_base.json', default_table='ventilators_data')
    try:
        while True:
            # insert data
            for unit in download_jsons():
                db.insert(unit)
            # sleep for 5 min
            time.sleep(timer)
    except:
        db.close()

create_table_api(t)
