import random
from locust import task, FastHttpUser, stats

stats.PERCENTILES_TO_CHART = [0.95, 0.99]


class CouponIssueV1(FastHttpUser):
    connection_timeout = 10.0
    network_timeout = 10.0

    @task
    def issue(self):
        payload = {
            "authorId" : random.randint(1, 10000),
            "content": "content",
            "title": "title"
        }
        with self.rest("POST", "/v1/article/tech", json=payload):
            pass