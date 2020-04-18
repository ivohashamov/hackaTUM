from sklearn.cluster import KMeans
from tinydb import TinyDB, Query
import argparse as ap
parser = ap.ArgumentParser()
parser.add_argument('--v', required=True, type=int)
args = parser.parse_args()
v = args.v


def cluster_reades(num_of_vent):
    db = TinyDB('scripts/DB/api_data_base.json', default_table='ventilators_data')
    last_data_for_all_patient = {}
    info_for_all_patients = db.all()

    for unit in info_for_all_patients:
        if unit['data_id'] in last_data_for_all_patient:
            if int(last_data_for_all_patient[unit['data_id']]['time']) < unit['time']:
                last_data_for_all_patient[unit['data_id']] = unit
        else:
            last_data_for_all_patient[unit['data_id']] = unit
    list_with_id = [k for k in last_data_for_all_patient.keys()]
    last_data_for_all_patient = [v for v in last_data_for_all_patient.values()]
    last_data_for_all_patient = [[v if type(v) == int else hash(v) for num, v in enumerate(
        unit.values()) if num > 2] for unit in last_data_for_all_patient]

    array_with_clusts = cluster(len(last_data_for_all_patient) - num_of_vent, last_data_for_all_patient)
    clusters = {}
    for i, num in enumerate(array_with_clusts):
        if num in clusters:
            clusters[num] = [*clusters[num], list_with_id[i]]
        else:
            clusters[num] = [list_with_id[i]]
    cl = [unit for unit in clusters.values() if len(unit) >= 2]
    db = TinyDB('scripts/DB/patient_data_base.json', default_table='patients')
    query = Query()
    final_pair_ids_of_patients = []
    final_ids_of_patients = []
    for pair in cl:
        for i in pair:
            final_ids_of_patients.append(db.search(query.vent == i)[0]['p_id'])
        final_pair_ids_of_patients.append(final_ids_of_patients)
        final_ids_of_patients = []
    db.close()
    return final_pair_ids_of_patients


def cluster(c: int, info):
    model = KMeans(n_clusters=c)
    prediction = model.fit_predict(info)
    return prediction

print(cluster_reades(v))
