public class Contact {

    // Rubric Requirement:
    // Contact ID is required, cannot be null,
    // cannot be longer than 10 characters,
    // and cannot be updated because it is final.
    private final String contactID;

    // Rubric Requirement:
    // First name is required, cannot be null,
    // and cannot be longer than 10 characters.
    private String firstName;

    // Rubric Requirement:
    // Last name is required, cannot be null,
    // and cannot be longer than 10 characters.
    private String lastName;

    // Rubric Requirement:
    // Phone number is required, cannot be null,
    // and must be exactly 10 digits.
    private String phone;

    // Rubric Requirement:
    // Address is required, cannot be null,
    // and cannot be longer than 30 characters.
    private String address;

    public Contact(String contactID, String firstName,
                   String lastName, String phone, String address) {

        // Validates contact ID requirements
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        this.contactID = contactID;

        // Uses setters to validate remaining fields
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    // Validates first name requirements
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Validates last name requirements
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }

        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    // Validates phone number requirements
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    // Validates address requirements
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.address = address;
    }
}