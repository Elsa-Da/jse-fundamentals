package fr.aelion.helpers.factory;

import fr.aelion.models.courses.Document;
import fr.aelion.models.courses.Media;
import fr.aelion.models.courses.Slide;
import fr.aelion.models.courses.Video;

import java.util.HashMap;

public class MediaFactory {
    private HashMap<String, Media> mediaTypes = new HashMap<>();

    public MediaFactory() {
        mediaTypes.put("VIDEO", new Video());
        mediaTypes.put("SLIDE", new Slide());
        mediaTypes.put("DOCUMENT", new Document());
    }

    public Media getMedia(String mediaType) {
        return mediaTypes.get(mediaType.toUpperCase());
    }
}
