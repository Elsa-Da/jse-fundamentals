package fr.aelion.models;

public class Student {
    public String lastName;
    public String firstName;
    private String email;
    private String username;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private String password;
    private Boolean isLoggedIn = false;

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Student(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }


    public Boolean login(String username, String password) {
        if (username.equals(this.username) && password.equals(this.password)) {
            this.isLoggedIn = true;
            return true;
        }
        return false;
    }

    public void logout() {
        this.isLoggedIn = false;
    }

    public Boolean isLoggedIn() {
        return isLoggedIn;
    }




}

