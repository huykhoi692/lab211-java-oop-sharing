/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ResourceBundle;

/**
 *
 * @author khois
 */
public class Account {
    private String accountName;
    private String password;

    public Account() {
    }

    public Account(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        if (accountName == null || accountName.isEmpty()) {
            throw new IllegalArgumentException(ResourceBundle.getBundle("vi").getString("error.account"));
        }
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException(ResourceBundle.getBundle("vi").getString("error.password"));
        }
        this.password = password;
    }
    
    
}
