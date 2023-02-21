package fr.aelion.services.courses;

import fr.aelion.repositories.courses.Course;

public class DisplayCourse {
    private Course course;

    public void setCourse(Course course) {
        this.course = course;
    }

    public String displayBuilder() {
        final String[] output = new String[1];

        output[0]= "Course : " + course.getTitle() + "\n";
        course.getMedias().forEach(m -> {
            output[0] += m.getTitle() + "\n";
        });
        return output[0];
    }
}
