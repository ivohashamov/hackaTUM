from tinydb import TinyDB, Query

def load_vent_id(p_id: str):
    db = TinyDB('scripts/DB/patient_data_base.json', default_table='patients')
    query = Query()
    info_for_given_patient = db.search(query.p_id == p_id)[0]
    db.close()
    return info_for_given_patient['vent']