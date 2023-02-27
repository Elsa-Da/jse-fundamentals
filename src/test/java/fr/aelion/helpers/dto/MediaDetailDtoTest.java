package fr.aelion.helpers.dto;

import fr.aelion.models.courses.Author;
import fr.aelion.models.courses.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaDetailDtoTest {

    private MediaDetailDto dto;
    private Video video;

    @BeforeEach
    void setUp() {
        dto = new MediaDetailDto();

        video = new Video();
        video.setTitle("Test video");
        video.setDuration(5.35F);
        video.setSummary("Résumé de la vidéo");
        video.setAuthor(new Author());
    }

    @Test
    @DisplayName("Should return the video title, duration, summary and type")
    void deserialize() {
        dto.deserialize(video);
        assertAll(
                () -> assertEquals(video.getTitle(), dto.title),
                () -> assertEquals(video.getDuration(), dto.duration),
                () -> assertEquals(video.getSummary(), dto.summary),
                () -> assertEquals("V", dto.mediaType)
        );
    }
}