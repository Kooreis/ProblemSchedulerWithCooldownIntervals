Here is a simple console application in Java that simulates a task scheduler with cooldown intervals. This application uses a queue to manage the tasks and a map to keep track of the cooldowns.

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("Task1", 1000);
        scheduler.addTask("Task2", 2000);
        scheduler.addTask("Task3", 3000);
        scheduler.run();
    }
}

class TaskScheduler {
    private Queue<Task> taskQueue;
    private Map<String, Long> cooldowns;

    public TaskScheduler() {
        this.taskQueue = new LinkedList<>();
        this.cooldowns = new HashMap<>();
    }

    public void addTask(String name, long cooldown) {
        taskQueue.add(new Task(name, cooldown));
    }

    public void run() {
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            long currentTime = System.currentTimeMillis();
            if (cooldowns.containsKey(task.name) && currentTime - cooldowns.get(task.name) < task.cooldown) {
                taskQueue.add(task);
            } else {
                task.execute();
                cooldowns.put(task.name, currentTime);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Task {
    String name;
    long cooldown;

    public Task(String name, long cooldown) {
        this.name = name;
        this.cooldown = cooldown;
    }

    public void execute() {
        System.out.println("Executing " + name);
    }
}
```

In this application, the `TaskScheduler` class is responsible for managing and executing tasks. It uses a queue to manage the tasks and a map to keep track of the cooldowns. The `addTask` method is used to add a new task to the queue. The `run` method is used to execute the tasks in the queue. If a task is still in its cooldown period, it is added back to the queue. Otherwise, it is executed and its cooldown is updated.

The `Task` class represents a task. It has a `name` and a `cooldown` period. The `execute` method is used to simulate the execution of the task.