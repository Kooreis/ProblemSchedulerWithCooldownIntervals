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