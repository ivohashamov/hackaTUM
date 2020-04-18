import ssl
from urllib.request import Request, urlopen
import json as js


def download_jsons(link: str = None):
    if link is None:
        link = 'http://api.theopenvent.com/exampledata/v2/data'
    # create request
    req = Request(link, headers={'User-Agent': 'Mozilla/5.0'})
    # send request
    context = ssl._create_unverified_context()
    webpage = urlopen(req, context=context).read()
    # utf-8
    webpage = webpage.decode('unicode_escape').encode('latin-1').decode('utf8')
    # create dictionaries
    ventilators = []
    d = {}
    for num, item in js.loads(webpage).items():
        d['data_id'] = num
        for key, values in item.items():
            if type(values) is dict:
                for key1, value in values.items():
                    if type(value) is dict:
                        for key2, v in value.items():
                            d[key2] = v
                    else:
                        d[key1] = value
            else:
                d[key] = values
        ventilators.append(d)
        d = {}
    return ventilators