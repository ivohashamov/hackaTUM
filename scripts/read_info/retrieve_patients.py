import argparse as ap
from scripts.read_info.loader_method import load_data
from scripts.library.tinydb import TinyDB, Query
parser = ap.ArgumentParser()
parser.add_argument('--doc_id', required=True, type=str)
args = parser.parse_args()
doc_id = args.doc_id

def retrieve_patiens_for_gicen_doctor(doc_id: str):
    db = TinyDB('../DB/patient_data_base.json', default_table='patients')
    query = Query()
    info_for_patients_of_dictor = db.search(query.doc_id == doc_id)
