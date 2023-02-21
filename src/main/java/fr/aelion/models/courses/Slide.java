package fr.aelion.models.courses;

public class Slide extends Media {
    @Override
    public void play() {
        System.out.println("Je charge un viewer");
    }
}
