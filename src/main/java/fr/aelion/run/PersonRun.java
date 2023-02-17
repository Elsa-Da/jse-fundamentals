package fr.aelion.run;

import fr.aelion.models.Person;

public class PersonRun {
    public void run() {
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


    }
}
