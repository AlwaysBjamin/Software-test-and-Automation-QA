import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("1234567890", "Task Name", "Task description");

        assertEquals("1234567890", task.getTaskID());
        assertEquals("Task Name", task.getName());
        assertEquals("Task description", task.getDescription());
    }

    @Test
    public void testTaskIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task Name", "Task description");
        });
    }

    @Test
    public void testTaskIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task Name", "Task description");
        });
    }

    @Test
    public void testNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "This name is way too long", "Task description");
        });
    }

    @Test
    public void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "Task description");
        });
    }

    @Test
    public void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Task Name",
                    "This description is definitely longer than fifty characters total.");
        });
    }

    @Test
    public void testDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Task Name", null);
        });
    }
}