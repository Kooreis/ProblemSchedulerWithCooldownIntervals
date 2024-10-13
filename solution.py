import time
import threading

class Task:
    def __init__(self, task_name, cooldown):
        self.task_name = task_name
        self.cooldown = cooldown