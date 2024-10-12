Here is a Python console application that designs a scheduler to execute tasks with cooldown intervals. This application uses the time module to implement the cooldown intervals.

```python
import time
import threading

class Task:
    def __init__(self, task_name, cooldown):
        self.task_name = task_name
        self.cooldown = cooldown

    def execute(self):
        print(f'Executing task: {self.task_name}')
        time.sleep(self.cooldown)
        print(f'Task {self.task_name} completed')

class Scheduler:
    def __init__(self):
        self.tasks = []

    def add_task(self, task):
        self.tasks.append(task)

    def execute_tasks(self):
        for task in self.tasks:
            task_thread = threading.Thread(target=task.execute)
            task_thread.start()
            task_thread.join()

if __name__ == "__main__":
    task1 = Task('Task 1', 2)
    task2 = Task('Task 2', 3)
    task3 = Task('Task 3', 1)

    scheduler = Scheduler()
    scheduler.add_task(task1)
    scheduler.add_task(task2)
    scheduler.add_task(task3)

    scheduler.execute_tasks()
```

In this application, a `Task` class is defined to represent a task with a name and a cooldown interval. The `execute` method of the `Task` class prints a message, waits for the cooldown interval, and then prints another message.

The `Scheduler` class is used to manage and execute tasks. The `add_task` method is used to add a task to the scheduler. The `execute_tasks` method is used to execute all tasks in the scheduler. Each task is executed in a separate thread, and the `execute_tasks` method waits for each task to complete before moving on to the next task.

In the main part of the application, three tasks are created with different cooldown intervals. These tasks are added to a scheduler, and then all tasks in the scheduler are executed.