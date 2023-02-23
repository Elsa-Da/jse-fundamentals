package fr.aelion.helpers.factory;

import fr.aelion.models.courses.Media;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaFactoryTest {
    private MediaFactory mediaFactory;
    @BeforeEach
    void setUp() {
        mediaFactory = new MediaFactory();
    }

    @Test
    @DisplayName("Should get a Media instance")
    void getMedia() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        assertTrue(mediaFactory.getMedia("video") instanceof Media);
    }

    @Test
    @DisplayName("Should raise an ClassNotFoundException")
    void noClassFound() {
        assertThrows(
                ClassNotFoundException.class,
                () -> mediaFactory.getMedia("pdf")
        );
    }

    @Test
    @DisplayName("Should raise an exception if a class is not a Media descendant")
    void notAMediaDescendant() {
        assertThrows(
                Exception.class,
                () -> mediaFactory.getMedia("author")
        );
    }
}