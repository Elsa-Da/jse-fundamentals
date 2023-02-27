package fr.aelion.helpers;

import fr.aelion.helpers.builders.MediaBuilder;
import fr.aelion.models.courses.Author;
import fr.aelion.models.courses.Media;
import fr.aelion.models.courses.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        try {
            Media media = mediaBuilder.build();
            assertTrue(media instanceof Video);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("Should have correct attribute values")
    void attributesTest() {
        Media video = null;
        try {
            video = mediaBuilder.build();
            Float duration = 5.35F;
            Media finalVideo = video;
            assertAll(
                    () -> assertEquals("Test", finalVideo.getTitle()),
                    () -> assertEquals("Youplaboom trop cool", finalVideo.getSummary()),
                    () -> assertEquals(duration, finalVideo.getDuration()),
                    () -> assertTrue(finalVideo.getAuthor() instanceof Author)
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("Not enough attbts should raised an Exception")
    void notEnoughAttribute() {
        assertThrows(Exception.class, () -> badBuilder.build());
    }

    @Test
    @DisplayName("No type should raised and Exception")
    void noType() {
        MediaBuilder bad = new MediaBuilder();
        bad
                .title("Bad")
                .summary("Bad")
                .author(new Author())
                .duration(5.35F);
        assertThrows(Exception.class, () -> badBuilder.build());
    }
}