package fr.aelion.services.courses;

import fr.aelion.models.courses.Media;
import fr.aelion.models.courses.Video;
import fr.aelion.repositories.courses.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayCourseTest {

    private DisplayCourse displayCourse;
    private StringBuilder expected = new StringBuilder();
    @BeforeEach
    void setUp() {
        Course course = new Course();
        Media video = new Video();
        video.setTitle("Video test");

        course.setTitle("Test");
        course.addMedia(video);

        expected
                .append("Course : Test")
                .append("\n")
                .append("Video test")
                .append("\n");

        displayCourse = new DisplayCourse();
        displayCourse.setCourse(course);
    }

    @Test
    @DisplayName("Should display the whole course")
    void displayBuilder() {
        assertEquals(expected.toString(), displayCourse.displayBuilder());
    }
}