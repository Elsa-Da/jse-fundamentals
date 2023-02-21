package fr.aelion.helpers;

import fr.aelion.models.courses.Author;
import fr.aelion.models.courses.Media;
import fr.aelion.models.courses.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

class MediaBuilderTest {
    private MediaBuilder mediaBuilder = new MediaBuilder();
    private MediaBuilder badBuilder = new MediaBuilder();

    @BeforeEach
    void setUp() {
        mediaBuilder.setMediaType("video");
        mediaBuilder
                .title("Test")
                .summary("Youplaboom trop cool")
                .author(new Author())
                .duration(5.35F);

        badBuilder.setMediaType("document");
        badBuilder
                .summary("Youplaboom trop cool")
                .author(new Author())
                .title("Test");
    }

    @Test
    @DisplayName("Should be an instanceof Video class")
    void build() {
        assertTrue(mediaBuilder.build().get() instanceof Video);
    }

    @Test
    @DisplayName("Should have correct attribute values")
    void attributesTest() {
        Media video = mediaBuilder.build().get();
        Float duration = 5.35F;
        assertAll(
                () -> assertEquals("Test", video.getTitle()),
                () -> assertEquals("Youplaboom trop cool", video.getSummary()),
                () -> assertEquals(duration, video.getDuration()),
                () -> assertTrue(video.getAuthor() instanceof Author)
        );
    }

    @Test
    @DisplayName("Should return empty optional")
    void notEnoughAttribute() {
        assertAll(
                () -> assertTrue(badBuilder.build() instanceof Optional),
                () -> assertTrue(badBuilder.build().isEmpty())
        );
    }
}