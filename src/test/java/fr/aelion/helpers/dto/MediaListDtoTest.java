package fr.aelion.helpers.dto;

import fr.aelion.helpers.builders.MediaBuilder;
import fr.aelion.models.courses.Author;
import fr.aelion.models.courses.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaListDtoTest {

    private MediaListDto dto;
    private Video video;

    @BeforeEach
    void setUp() {
        dto = new MediaListDto();

        video = new Video();
        video.setTitle("Test video");
        video.setDuration(5.35F);
        video.setSummary("Réumé de la vidéo");
        video.setAuthor(new Author());
    }

    @Test
    @DisplayName("Should return the video title")
    void deserialize() {
        dto.deserialize(video);
        assertEquals("Test video", dto.title);
    }
}