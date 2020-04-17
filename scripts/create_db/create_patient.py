from scripts.library.tinydb import TinyDB, Query
import argparse as ap
parser = ap.ArgumentParser()
parser.add_argument('--name', required=True, type=str)
parser.add_argument('--p_id', required=True, type=str)
parser.add_argument('--doc_id', required=True, type=str)
parser.add_argument('--vent', required=True, type=str)
args = parser.parse_args()
name = args.name
p_id = args.p_id
doc_id = args.doc_id
vent = args.vent

def create_patient(p_id: int, name: str, doc_id, vent: str):
    db = TinyDB('../DB/patient_data_base.json', default_table='patients')
    query = Query()

    # check if patient with this id exist
    info_for_given_patient = db.search(query.p_id == p_id)
    unit = {"p_id": p_id,
              "name": name,
              "doc_id": doc_id,
              "vent": vent
              }

    # insert only if no id match
    if len(info_for_given_patient) == 0:
        db.insert(unit)

create_patient(p_id, name, doc_id, vent)
