package com.example.springboot.pojo;

/**
 * @author Jackasher
 * @version 1.0
 * @className Account
 * @since 1.0
 **/
public class Account {
    private String id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
