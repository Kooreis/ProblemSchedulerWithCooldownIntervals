class TaskScheduler {
    private Queue<Task> taskQueue;
    private Map<String, Long> cooldowns;

    public TaskScheduler() {
        this.taskQueue = new LinkedList<>();
        this.cooldowns = new HashMap<>();
    }
}