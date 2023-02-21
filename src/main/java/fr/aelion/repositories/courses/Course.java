package fr.aelion.repositories.courses;

import fr.aelion.models.courses.Media;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private Set<Media> medias = new HashSet<>();

    public Set<Media> getMedias() {
        return medias;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addMedia(Media media) {
        this.medias.add(media);
    }

    public void removeMedia(Media media) {
        this.medias.remove(media);
    }
}
