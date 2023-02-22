package fr.aelion.repositories;

import fr.aelion.helpers.StudentBuilder;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public StudentRepository(){
        this.populate();
    }

    public Student findByLoginAndPassword(String login, String password) {
        for (Student student : this.students) {
            if (student.getUsername() == login && student.getPassword() == password) {
                return student;
            }
        }
        return null;
    }

    public int size() {
        return this.students.size();
    }
    private void populate(){
        //Make an instance of Student : student
        StudentBuilder student = StudentBuilder.getInstance();
        student
                .lastName("Bond")
                .firstName("James")
                .email("jbond@mail.com")
                .login("JBond")
                .password("007")
                .phoneNumber("06 58 98 74 28");

        //Add student to list
        try {
            this.students.add(student.build());
        } catch (NotEnoughArgsException e) {
            System.out.println(e.getMessage());
        }
    }
}
