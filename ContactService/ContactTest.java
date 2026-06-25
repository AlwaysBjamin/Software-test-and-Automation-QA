import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

    // Rubric Requirement:
    // Verifies a valid contact can be created successfully.
    @Test
    void testContactCreatedSuccessfully() {

        Contact contact = new Contact(
                "12345",
                "Ben",
                "Smith",
                "1234567890",
                "123 Main Street");

        assertEquals("12345", contact.getContactID());
        assertEquals("Ben", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    // Verifies contact ID cannot be null
    @Test
    void testContactIDCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Ben", "Smith",
                    "1234567890", "123 Main Street");
        });
    }

    // Verifies contact ID cannot exceed 10 characters
    @Test
    void testContactIDCannotBeTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Ben", "Smith",
                    "1234567890", "123 Main Street");
        });
    }

    // Verifies first name cannot be null
    @Test
    void testFirstNameCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Smith",
                    "1234567890", "123 Main Street");
        });
    }

    // Verifies first name cannot exceed 10 characters
    @Test
    void testFirstNameCannotBeTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Benjaminxxx", "Smith",
                    "1234567890", "123 Main Street");
        });
    }

    // Verifies last name cannot be null
    @Test
    void testLastNameCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ben", null,
                    "1234567890", "123 Main Street");
        });
    }

    // Verifies last name cannot exceed 10 characters
    @Test
    void testLastNameCannotBeTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ben", "Smithington",
                    "1234567890", "123 Main Street");
        });
    }

    // Verifies phone number cannot be null
    @Test
    void testPhoneCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ben", "Smith",
                    null, "123 Main Street");
        });
    }

    // Verifies phone number must be exactly 10 digits
    @Test
    void testPhoneMustBeExactlyTenDigits() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ben", "Smith",
                    "123456789", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ben", "Smith",
                    "12345678901", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ben", "Smith",
                    "12345abc90", "123 Main Street");
        });
    }

    // Verifies address cannot be null
    @Test
    void testAddressCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ben", "Smith",
                    "1234567890", null);
        });
    }

    // Verifies address cannot exceed 30 characters
    @Test
    void testAddressCannotBeTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ben", "Smith",
                    "1234567890",
                    "1234567890123456789012345678901");
        });
    }
}