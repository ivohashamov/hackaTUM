from scripts.library.tinydb import TinyDB, Query
import argparse as ap
from scripts.read_info.loader_method import load_data

parser = ap.ArgumentParser()
parser.add_argument('--p_id', required=True, type=str)
args = parser.parse_args()
p_id = args.p_id


print(load_data(p_id, cut=True))
