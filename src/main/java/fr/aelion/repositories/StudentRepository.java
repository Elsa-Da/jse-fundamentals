package fr.aelion.repositories;

import fr.aelion.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public List<Student> students = new ArrayList<>();

    public StudentRepository() {
        this.populate();
    }

    private void populate() {
        //Make an instance of Student : student
        Student student = new Student("Bond", "James", "jamesbond@lemail.com");
        student.setUsername("jbond");
        student.setPassword("mdp");

        //Add student to list
        this.students.add(student);
    }
}
