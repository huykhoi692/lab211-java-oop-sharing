package bo;

import entity.Account;
import util.Validation;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {

    private final List<Account> accounts = new ArrayList<>();
    private int lastId = 0;

    /**
     * Validates all fields and adds a new account to the list.
     *
     * @param username the desired username (must not be blank or duplicate)
     * @param password the plain-text password (will be stored as MD5 hash)
     * @param name     the account holder's full name
     * @param phone    the account holder's phone number (10 or 11 digits)
     * @param email    the account holder's email address
     * @param address  the account holder's address
     * @param dob      the account holder's date of birth in dd/MM/yyyy format
     * @return the auto-generated ID of the newly created account
     * @throws Exception if any field is invalid or username already exists
     */
    public int addAccount(String username, String password, String name,
                          String phone, String email, String address, String dob)
            throws Exception {

        if (!Validation.isValidUsername(username)) {
            throw new Exception("Username must not be blank.");
        }
        if (!Validation.isValidPassword(password)) {
            throw new Exception("Password must not be blank.");
        }
        if (!Validation.isValidName(name)) {
            throw new Exception("Name must not be blank.");
        }
        if (!Validation.isValidPhone(phone)) {
            throw new Exception("Phone must be 10 or 11 digits.");
        }
        if (!Validation.isValidEmail(email)) {
            throw new Exception("Email format is invalid.");
        }
        if (!Validation.isValidAddress(address)) {
            throw new Exception("Address must not be blank.");
        }
        if (!Validation.isValidDOB(dob)) {
            throw new Exception("Date of birth must be in dd/MM/yyyy format.");
        }
        for (Account a : accounts) {
            if (a.getUsername().equalsIgnoreCase(username.trim())) {
                throw new Exception("Username [" + username + "] already exists.");
            }
        }
        String passwordMd5 = Validation.md5(password);
        int newId = ++lastId;
        Account account = new Account(newId, username.trim(), passwordMd5,
                name.trim(), phone.trim(), email.trim(), address.trim(), dob.trim());
        accounts.add(account);
        return newId;
    }

    /**
     * Authenticates a user by comparing the MD5 hash of the entered password
     * with the stored hash.
     *
     * @param username the username to look up
     * @param password the plain-text password to verify
     * @return true if the credentials match an existing account, false otherwise
     */
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        String hash = Validation.md5(password);
        for (Account a : accounts) {
            if (a.getUsername().equalsIgnoreCase(username.trim())
                    && a.getPasswordMd5().equals(hash)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds an account by username using case-insensitive comparison.
     *
     * @param username the username to search for
     * @return the matching Account, or null if not found
     */
    public Account findByUsername(String username) {
        for (Account a : accounts) {
            if (a.getUsername().equalsIgnoreCase(username.trim())) {
                return a;
            }
        }
        return null;
    }

    /**
     * Checks whether an account with the given username already exists.
     *
     * @param username the username to check
     * @return true if the username exists, false otherwise
     */
    public boolean existsByUsername(String username) {
        return findByUsername(username) != null;
    }
}
