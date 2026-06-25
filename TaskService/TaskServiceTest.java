import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    @Test
    void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Homework", "Complete project files");

        service.addTask(task);

        assertEquals(task, service.getTask("12345"));
    }

    @Test
    void testAddDuplicateTaskFails() {
        TaskService service = new TaskService();
        Task task1 = new Task("12345", "Homework", "Complete project files");
        Task task2 = new Task("12345", "Study", "Review notes");

        service.addTask(task1);

        assertThrows(IllegalArgumentException.class, () -> service.addTask(task2));
    }

    @Test
    void testAddNullTaskFails() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.addTask(null));
    }

    @Test
    void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Homework", "Complete project files");

        service.addTask(task);
        service.deleteTask("12345");

        assertThrows(IllegalArgumentException.class, () -> service.getTask("12345"));
    }

    @Test
    void testDeleteMissingTaskFails() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteTask("99999"));
    }

    @Test
    void testUpdateTaskFields() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Homework", "Complete project files");

        service.addTask(task);

        service.updateName("12345", "Study");
        service.updateDescription("12345", "Review Java unit tests");

        assertEquals("Study", service.getTask("12345").getName());
        assertEquals("Review Java unit tests", service.getTask("12345").getDescription());
    }

    @Test
    void testUpdateTaskWithInvalidValuesFails() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Homework", "Complete project files");

        service.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> service.updateName("12345", null));
        assertThrows(IllegalArgumentException.class, () -> service.updateDescription("12345", null));
    }

    @Test
    void testUpdateMissingTaskFails() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.updateName("99999", "Study"));
    }
}