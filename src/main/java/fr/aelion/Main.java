package fr.aelion;


import fr.aelion.run.PersonRun;
import fr.aelion.run.StudentRun;

public class Main {

    public static void main(String[] args) {
        PersonRun personRun = new PersonRun();
        personRun.run();

        StudentRun studentRun = new StudentRun();
        studentRun.run();
    }

}