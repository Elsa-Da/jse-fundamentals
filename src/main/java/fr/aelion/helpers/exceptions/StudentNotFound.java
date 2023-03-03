package fr.aelion.helpers.exceptions;

public class StudentNotFound extends Exception{

    public StudentNotFound() {
        super("No student was found");
    }
}
