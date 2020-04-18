from tinydb import TinyDB, Query
from find_patient_vent import load_vent_id
import os
def load_data(p_id: str ,num_to_cut: str=10, cut: bool=False):
    db = TinyDB(os.getcwd() + 'scripts/DB/api_data_base.json', default_table='ventilators_data')
    query = Query()
    info_for_given_patient = db.search(query.data_id == load_vent_id(p_id))
    db.close()
    return info_for_given_patient
    """
    d_with_nums = {}
    for unit in info_for_given_patient:
        for k, v in unit.items():
            if k in d_with_nums:
                value = [*d_with_nums[k], v]
                d_with_nums[k] = cutter(value, num_to_cut, cut)
            else:
                value = [v]
                d_with_nums[k] = cutter(value, num_to_cut, cut)

    return filter_dict(d_with_nums)
    """


def cutter(elements, num: int, cut: bool):
    if cut:
        elements = elements[-num:]
    return elements


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

def retrieve_patiens_for_gicen_doctor(doc_id: str):
    db = TinyDB('scripts/DB/patient_data_base.json', default_table='patients')
    query = Query()
    info_for_patients_of_dictor = db.search(query.doc_id == doc_id)
    db.close()
    return info_for_patients_of_dictor