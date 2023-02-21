package fr.aelion.models.courses;

public class Document extends Media {
    @Override
    public void play() {
        System.out.println("J'ouvre un nouvel onglet");
    }
}
