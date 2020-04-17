from scripts.library.tinydb import TinyDB, Query
import argparse as ap
parser = ap.ArgumentParser()
parser.add_argument('--name', required=True, type=str)
parser.add_argument('--doc_id', required=True, type=str)
args = parser.parse_args()
name = args.name
doc_id = args.doc_id

def create_doctor(name: str, doc_id: str):
    db = TinyDB('../DB/doctor_data_base.json', default_table='patients')
    query = Query()
    
    # check if doctor with this id exist
    info_for_given_patient = db.search(query.p_id == doc_id)
    unit = {"name": name,
              "doc_id": doc_id,
              }

    # insert only if no id match
    if len(info_for_given_patient) == 0:
        db.insert(unit)

create_doctor(name, doc_id)