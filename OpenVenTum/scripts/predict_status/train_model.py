from tinydb import TinyDB
import random
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split
from joblib import dump
import os
def myhash(obj):
    try:
        return sum([ord(char) for char in obj])
    except:
        return float(obj)

def data_to_train():
    db = TinyDB(os.getcwd() + '/scripts/DB/api_data_base.json', default_table='ventilators_data')
    all_data = db.all()
    normal_status_X = all_data
    normal_status_y = [1 for i in range(len(normal_status_X))]
    false_data_X = []
    false_data_y = []
    for num, i in enumerate(normal_status_X):
        d = {}
        for key, value in i.items():
            d[key] = float(value) * random.choice([0.80,1.20]) if str(value).isdigit() else myhash(value)
            normal_status_X[num][key] = value if str(value).isdigit() else myhash(value)
        false_data_X.append(d)
        false_data_y.append(0)

    data = [list(i.values()) for i in [*normal_status_X, *false_data_X]]
    X_train, X_test, y_train, y_test = train_test_split(data, [*normal_status_y, *false_data_y], test_size = 0.10, random_state = 42)

    model = RandomForestClassifier()
    model.fit(X_train, y_train)
    """
    print(model.score(X_test, y_test))
    """
    dump(model, 'scripts/data/model_random_data.joblib')
    db.close()



data_to_train()