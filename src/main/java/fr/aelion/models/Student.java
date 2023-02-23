package fr.aelion.models;

import fr.aelion.helpers.strategies.student.FirstNameLastNameStrategy;
import fr.aelion.helpers.strategies.student.IHelloStrategy;

public class Student extends Person {

    private String username;
    private String password;
    private Boolean isLoggedIn = false;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private IHelloStrategy strategy= new FirstNameLastNameStrategy();


    public Student(String lastName, String email, String login, String password) {
        this.lastName = lastName;
        this.email = email;
        this.username = login;
        this.password = password;
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

    public void isLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public void setStrategy(IHelloStrategy strategy) {
        this.strategy = strategy;
    }

    public String toString() {
        return this.strategy.greetings(this);
    }


}

