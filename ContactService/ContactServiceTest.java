import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    void testAddDuplicateContactFails() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
        Contact contact2 = new Contact("12345", "Jane", "Doe", "0987654321", "456 Oak St");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    void testAddNullContactFails() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);
        service.deleteContact("12345");

        assertThrows(IllegalArgumentException.class, () -> service.getContact("12345"));
    }

    @Test
    void testDeleteMissingContactFails() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99999"));
    }

    @Test
    void testUpdateContactFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        service.updateFirstName("12345", "Jane");
        service.updateLastName("12345", "Doe");
        service.updatePhone("12345", "0987654321");
        service.updateAddress("12345", "456 Oak St");

        assertEquals("Jane", service.getContact("12345").getFirstName());
        assertEquals("Doe", service.getContact("12345").getLastName());
        assertEquals("0987654321", service.getContact("12345").getPhone());
        assertEquals("456 Oak St", service.getContact("12345").getAddress());
    }

    @Test
    void testUpdateContactWithInvalidValuesFails() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("12345", null));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("12345", null));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("12345", "12345"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("12345", null));
    }

    @Test
    void testUpdateMissingContactFails() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("99999", "Jane"));
    }
}