import argparse as ap
from loader_method import retrieve_patiens_for_gicen_doctor

parser = ap.ArgumentParser()
parser.add_argument('--doc_id', required=True, type=str)
args = parser.parse_args()
doc_id = args.doc_id


print(retrieve_patiens_for_gicen_doctor(doc_id))