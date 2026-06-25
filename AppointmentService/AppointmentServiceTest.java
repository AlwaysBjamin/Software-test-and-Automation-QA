import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 86400000);
    }

    @Test
    public void testAddAppointmentSuccessfully() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("12345", futureDate(), "Doctor appointment");

        service.addAppointment(appointment);

        assertEquals(appointment, service.getAppointment("12345"));
    }

    @Test
    public void testCannotAddDuplicateAppointmentID() {
        AppointmentService service = new AppointmentService();
        Appointment appointment1 = new Appointment("12345", futureDate(), "Doctor appointment");
        Appointment appointment2 = new Appointment("12345", futureDate(), "Dentist appointment");

        service.addAppointment(appointment1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
    }

    @Test
    public void testCannotAddNullAppointment() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(null);
        });
    }

    @Test
    public void testDeleteAppointmentSuccessfully() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("12345", futureDate(), "Doctor appointment");

        service.addAppointment(appointment);
        service.deleteAppointment("12345");

        assertNull(service.getAppointment("12345"));
    }

    @Test
    public void testDeleteAppointmentThatDoesNotExist() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("99999");
        });
    }
}