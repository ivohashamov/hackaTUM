from scripts.library.tinydb import TinyDB, Query
import argparse as ap
parser = ap.ArgumentParser()
parser.add_argument('--p_id', required=True, type=str)
args = parser.parse_args()
p_id = args.p_id

def load_data(p_id: str):
     db = TinyDB('../DB/patient_data_base.json', default_table='ventilators_data')
     query = Query()
     info_for_given_patient = db.search(query.data_id == p_id)
     d_with_nums = {}
     for unit in info_for_given_patient:
          for k, v in unit.items():
               if k in d_with_nums:
                    d_with_nums[k] = [*d_with_nums[k], v]
               else:
                    d_with_nums[k] = [v]
     return filter_dict(d_with_nums)

def filter_dict(d: dict):
     d['data_id'] = d['data_id'][-1]
     d['device_id'] = d['device_id'][-1]
     d['FiO2'] = d['FiO2'][-1]
     d['IE'] = d['IE'][-1]
     d['MVe'] = d['MVe'][-1]
     d['PEEP'] = d['PEEP'][-1]
     d['RR'] = d['RR'][-1]
     d['VT'] = d['VT'][-1]
     d['humidity'] = d['humidity'][-1]
     d['pressure_max'] = d['pressure_max'][-1]
     d['ventilationMode'] = d['ventilationMode'][-1]
     return d

print(load_data(p_id))