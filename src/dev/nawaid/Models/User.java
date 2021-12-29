package dev.nawaid.Models;

public class User {
    private String email;
    private String name;
    private int id;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
