def execute(self):
        print(f'Executing task: {self.task_name}')
        time.sleep(self.cooldown)
        print(f'Task {self.task_name} completed')