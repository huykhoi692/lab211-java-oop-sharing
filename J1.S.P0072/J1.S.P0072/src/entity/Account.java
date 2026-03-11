package entity;

import util.Validation;

public class Account {

    private int id;
    private String username;
    private String passwordMd5;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dob;

    public Account() {
    }

    /**
     * Creates an Account with all fields set directly (used internally by BO after validation).
     *
     * @param id          the unique account ID
     * @param username    the account username
     * @param passwordMd5 the MD5-hashed password
     * @param name        the account holder's name
     * @param phone       the account holder's phone number
     * @param email       the account holder's email address
     * @param address     the account holder's address
     * @param dob         the account holder's date of birth (dd/MM/yyyy)
     */
    public Account(int id, String username, String passwordMd5,
                   String name, String phone, String email,
                   String address, String dob) {
        this.id          = id;
        this.username    = username;
        this.passwordMd5 = passwordMd5;
        this.name        = name;
        this.phone       = phone;
        this.email       = email;
        this.address     = address;
        this.dob         = dob;
    }

    /**
     * @return the account's unique ID
     */
    public int getId() {
        return id;
    }

    /**
     * @return the account's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the account's MD5-hashed password
     */
    public String getPasswordMd5() {
        return passwordMd5;
    }

    /**
     * @return the account holder's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the account holder's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return the account holder's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the account holder's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the account holder's date of birth
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param id the unique ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param username the username to set
     * @throws IllegalArgumentException if username is null or blank
     */
    public void setUsername(String username) {
        if (!Validation.isValidUsername(username)) {
            throw new IllegalArgumentException("Username must not be blank.");
        }
        this.username = username.trim();
    }

    /**
     * @param passwordMd5 the MD5-hashed password to set
     * @throws IllegalArgumentException if passwordMd5 is null or empty
     */
    public void setPasswordMd5(String passwordMd5) {
        if (passwordMd5 == null || passwordMd5.isEmpty()) {
            throw new IllegalArgumentException("Password must not be blank.");
        }
        this.passwordMd5 = passwordMd5;
    }

    /**
     * @param name the name to set
     * @throws IllegalArgumentException if name is null or blank
     */
    public void setName(String name) {
        if (!Validation.isValidName(name)) {
            throw new IllegalArgumentException("Name must not be blank.");
        }
        this.name = name.trim();
    }

    /**
     * @param phone the phone number to set (must be 10 or 11 digits)
     * @throws IllegalArgumentException if phone format is invalid
     */
    public void setPhone(String phone) {
        if (!Validation.isValidPhone(phone)) {
            throw new IllegalArgumentException("Phone must be 10 or 11 digits.");
        }
        this.phone = phone.trim();
    }

    /**
     * @param email the email address to set
     * @throws IllegalArgumentException if email format is invalid
     */
    public void setEmail(String email) {
        if (!Validation.isValidEmail(email)) {
            throw new IllegalArgumentException("Email format is invalid.");
        }
        this.email = email.trim();
    }

    /**
     * @param address the address to set
     * @throws IllegalArgumentException if address is null or blank
     */
    public void setAddress(String address) {
        if (!Validation.isValidAddress(address)) {
            throw new IllegalArgumentException("Address must not be blank.");
        }
        this.address = address.trim();
    }

    /**
     * @param dob the date of birth to set (must be in dd/MM/yyyy format)
     * @throws IllegalArgumentException if dob format is invalid
     */
    public void setDob(String dob) {
        if (!Validation.isValidDOB(dob)) {
            throw new IllegalArgumentException("Date of birth must be in dd/MM/yyyy format.");
        }
        this.dob = dob.trim();
    }
}
