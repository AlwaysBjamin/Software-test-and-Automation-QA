import java.util.HashMap;
import java.util.Map;

public class TaskService {

    private final Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists");
        }

        tasks.put(task.getTaskID(), task);
    }

    public void deleteTask(String taskID) {
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task not found");
        }

        tasks.remove(taskID);
    }

    public void updateName(String taskID, String name) {
        Task task = getTask(taskID);
        task.setName(name);
    }

    public void updateDescription(String taskID, String description) {
        Task task = getTask(taskID);
        task.setDescription(description);
    }

    public Task getTask(String taskID) {
        Task task = tasks.get(taskID);

        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }

        return task;
    }
}