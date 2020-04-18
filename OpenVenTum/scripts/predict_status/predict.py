from joblib import load
from loader_method import load_data
from loader_method import retrieve_patiens_for_gicen_doctor
from train import myhash
import argparse as ap
import os
parser = ap.ArgumentParser()
parser.add_argument('--doc_id', required=True, type=str)
args = parser.parse_args()
doc_id = args.doc_id

def predict(p_id):
    model = load(os.getcwd() + '/scripts/data/model_random_data.joblib')
    data = [i if str(i).isdigit() else myhash(i) for i in list(load_data(p_id)[-1].values())]
    return {'p_id': p_id,
            'status': model.predict([data])[0]
            }

def get_status_of_patients(doc_id: str):
    info = retrieve_patiens_for_gicen_doctor(doc_id=doc_id)
    status_of_patients = []

    for unit in info:
        status_of_patients.append(predict(unit['p_id']))
    print(status_of_patients)

get_status_of_patients(doc_id)
