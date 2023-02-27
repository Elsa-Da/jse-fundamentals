package fr.aelion.helpers.dto;

import fr.aelion.helpers.dto.annotations.ClassInitial;

public class MediaDetailDto {
    public String title;
    public String summary;
    public Float duration;

    @ClassInitial
    public String mediaType;

}
