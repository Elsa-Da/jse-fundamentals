package fr.aelion.helpers;

import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.helpers.interfaces.Builder;
import fr.aelion.models.Student;

public class StudentBuilder implements Builder<Student> {

    private static StudentBuilder instance;

    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private String login;
    private String password;
    private Boolean isLoggedIn = false;

    public static StudentBuilder getInstance() {
        if (instance == null) {
            instance = new StudentBuilder();
        }
        return instance;
    }

    public StudentBuilder lastName(String string) {
        this.lastName = string;
        return this;
    }

    public StudentBuilder firstName(String string) {
        this.firstName = string;
        return this;
    }

    public StudentBuilder email(String string) {
        this.email = string;
        return this;
    }

    public StudentBuilder phoneNumber(String string) {
        this.phoneNumber = string;
        return this;
    }

    public StudentBuilder login(String string) {
        this.login = string;
        return this;
    }

    public StudentBuilder password(String string) {
        this.password = string;
        return this;
    }

    private StudentBuilder() {
    }

    @Override
    public Student build() throws NotEnoughArgsException {
        if (this.lastName == null || this.email == null || this.login == null || this.password == null) {
            throw new NotEnoughArgsException("Missing last name or email or login or password");
        }

        Student student = new Student(this.lastName, this.email, this.login, this.password);
        student.setPhoneNumber(this.phoneNumber);
        student.setFirstName(this.firstName);

        return student;
    }

    public void reset() {
        this.lastName = null;
        this.firstName = null;
        this.email = null;
        this.password = null;
        this.login = null;
        this.phoneNumber = null;
    }
}
