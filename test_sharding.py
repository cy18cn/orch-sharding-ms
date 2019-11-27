# -*- coding: utf-8 -*-

from locust import HttpLocust, TaskSet
import hmac
import time
import json
import random


token = ''
app_id = b'ap2PC0CZ8YoA8iEkHY'
secret_key = b'6fcf04c42926b6bc3111ad549d17428b'
account = {}


def login(l):
    params = {"username": "", "password": "",
              "timestamp": int(time.time() * 1000), "appId": app_id}
    params["sign"] = sign(secret_key, params).upper()
    resp = l.client.post("/merchant/account/login", {})
    if resp.status_code == 200:
        data = json.loads(resp.content)["data"]
        token = data["token"]
        account = data["account"]
        print("log success(token=%s)" % (token))


def add(l):
    content = ("value is %s") % (random.random())
    l.client.post("/test/add",
                  json={"content": content})


def get(l):
    l.client.get("/test/get?id=" + str(random.randint(1, 10)))


def create_link_str(parameters):
    paramKeys = list(parameters.keys())
    sKeys = sorted(paramKeys)
    link_str = ""
    for i in range(len(sKeys)):
        if sKeys[i] == "sign":
            continue
        link_str += sKeys[i]
        link_str += "="
        link_str += str(parameters[sKeys[i]])
        if (i < len(paramKeys) - 1):
            link_str += "&"
    return link_str


def sign(api_secret_key, parameters):
    # print(self.api_secret_key)
    # myhmac = hmac.new(self.api_secret_key, str(self.create_link_str()).encode("'utf-8'"), 'MD5').hexdigest()
    # print(self.create_link_str())
    # myhmac.update(str(self.create_link_str()))
    # print(myhmac.hexdigest())
    return hmac.new(api_secret_key, str(create_link_str(parameters)).encode("'utf-8'"), 'MD5').hexdigest()


class ShardingTestBehavior(TaskSet):
    tasks = {get: 2, add: 1}

    def on_start(self):
        # login(self)
        pass

    def on_stop(self):
        pass


class ShardingTest(HttpLocust):
    task_set = ShardingTestBehavior
    min_wait = 5000
    max_wait = 9000
