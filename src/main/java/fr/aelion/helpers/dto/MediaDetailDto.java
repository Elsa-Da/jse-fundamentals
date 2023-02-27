package fr.aelion.helpers.dto;

import fr.aelion.helpers.builders.MediaBuilder;
import fr.aelion.models.courses.Media;

public class MediaDetailDto {
    public String title;
    public String summary;
    public Float duration;

    public String mediaType;


    /**
     * Transform a Media Object to a MediaDetailDto object
     * @param media Media to deserialize to MediaDetailDto
     */
    public void deserialize(Media media) {

        this.title = media.getTitle();
        this.summary = media.getSummary();
        this.duration = media.getDuration();
        this.mediaType = media.getClass().getSimpleName().substring(0,1);
    }
}
