package fr.aelion;

import fr.aelion.models.Person;
import fr.aelion.models.Student;

import java.sql.SQLOutput;

public class Main {
    private static Main app;
    public static void main(String[] args) {
        app = new Main();
        if (app instanceof Main) {
            System.out.println("You are a Main object");
        } else {
            System.out.println("You're not a Main object");
        }
        System.out.println("I'm the main method");
    }

    public Main() {
        Person jl = new Person();
        jl.setLastName("Aubert");
        jl.setFirstName("Jean-Louis");
        jl.setPhoneNumber("06 52 35 98 00");
        jl.setEmail("jeanloulou@lemail.com");

        System.out.println("Bjr, je m'appelle " + jl.greetings());

        Person jt = new Person();
        jt.setLastName("Toupie");
        jt.setFirstName("Jacques");
        jt.setPhoneNumber("06 24 35 88 01");
        jt.setEmail("jactoupie@lemail.com");

        System.out.println("Bjr, je m'appelle " + jt.greetings());

        Person ml = new Person("Loupe", "Marie", "06 25 25 25 25", "maloupe@lemail.com");
        System.out.println("Yo, je suis " + ml.greetings());

        Person fp = new Person("Papuche", "papuchy@lemail.com");
        System.out.println("Yo, je suis " + fp.greetings());

        Student one = new Student("Bond", "James", "jamesbond@lemail.com");
        one.setUsername("jbond");
        one.setPassword("mdp");

        if (one.isLoggedIn() == false) {
            if (one.login("jbond", "mdp")) {
            System.out.println("Bonjour " + one.firstName + " " + one.lastName);
          } else {
            System.out.println("Désolé blablibu ça marche po");
          }
    }

        if (one.isLoggedIn() == true) {
            one.logout();
        }
        if (!one.login("bond", "md")) {
            System.out.println("Désolé blabla");
        }


}}