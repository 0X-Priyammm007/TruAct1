package com.truact.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role; // e.g., Admin or User
    private int fraudCount;

    // Constructor
    public User(int id, String username, String password, String email, String role, int fraudCount) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.fraudCount = fraudCount;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getFraudCount() {
        return fraudCount;
    }

    public void setFraudCount(int fraudCount) {
        this.fraudCount = fraudCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", fraudCount=" + fraudCount +
                '}';
    }
}