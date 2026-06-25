import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.Test;

public class AppointmentTest {

    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 86400000);
    }

    private Date pastDate() {
        return new Date(System.currentTimeMillis() - 86400000);
    }

    @Test
    public void testAppointmentCreatedSuccessfully() {
        Appointment appointment = new Appointment("12345", futureDate(), "Doctor appointment");

        assertEquals("12345", appointment.getAppointmentID());
        assertEquals("Doctor appointment", appointment.getDescription());
        assertNotNull(appointment.getAppointmentDate());
    }

    @Test
    public void testAppointmentIDCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate(), "Doctor appointment");
        });
    }

    @Test
    public void testAppointmentIDCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate(), "Doctor appointment");
        });
    }

    @Test
    public void testAppointmentDateCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Doctor appointment");
        });
    }

    @Test
    public void testAppointmentDateCannotBeInPast() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate(), "Doctor appointment");
        });
    }

    @Test
    public void testDescriptionCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate(), null);
        });
    }

    @Test
    public void testDescriptionCannotBeLongerThanFiftyCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate(),
                    "This description is definitely longer than fifty characters.");
        });
    }

    @Test
    public void testAppointmentDateCanBeUpdated() {
        Appointment appointment = new Appointment("12345", futureDate(), "Original appointment");
        Date newDate = new Date(System.currentTimeMillis() + 172800000);

        appointment.setAppointmentDate(newDate);

        assertEquals(newDate, appointment.getAppointmentDate());
    }

    @Test
    public void testDescriptionCanBeUpdated() {
        Appointment appointment = new Appointment("12345", futureDate(), "Original appointment");

        appointment.setDescription("Updated appointment");

        assertEquals("Updated appointment", appointment.getDescription());
    }
}