package fr.aelion.helpers.dto;

import fr.aelion.models.courses.Media;

public class MediaListDto {
    public String title;
    public Float duration;

    /**
     * Transform a Media Object to a MediaListDo object
     * @param media Media to deserialize to MediaListDto
     */
    public void deserialize(Media media) {
        this.title = media.getTitle();
        this.duration = media.getDuration();
    }
}
