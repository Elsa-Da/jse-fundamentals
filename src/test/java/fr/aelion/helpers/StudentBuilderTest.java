package fr.aelion.helpers;

import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentBuilderTest {
    private StudentBuilder studentBuilder = StudentBuilder.getInstance();
//    private StudentBuilder badBuilder = StudentBuilder.getInstance();

    @BeforeEach
    void setUp() {

        studentBuilder
                .lastName("Bond")
                .firstName("James")
                .email("jbond@mail.com")
                .login("JBond")
                .password("007")
                .phoneNumber("06 58 98 74 28");

//        badBuilder
//                .lastName("Stark")
//                .firstName("Tony");
    }

    @Test
    @DisplayName("Should be a Student")
    void build() {
        try {
            Student student = studentBuilder.build();
            assertTrue(student instanceof Student);
        } catch (NotEnoughArgsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Should have correct attribute values")
    void attributesTest() {
        try {
            Student student = studentBuilder.build();
            assertAll(
                    () -> assertEquals("Bond", student.getLastName()),
                    () -> assertEquals("James", student.getFirstName()),
                    () -> assertEquals("jbond@mail.com", student.getEmail()),
                    () -> assertEquals("JBond", student.getUsername()),
                    () -> assertEquals("007", student.getPassword()),
                    () -> assertEquals("06 58 98 74 28", student.getPhoneNumber())
            );

        } catch (NotEnoughArgsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw an exception")
    void badBuild() {
        studentBuilder.reset();
        studentBuilder
                .lastName("Bond")
                .firstName("James");


        assertThrows(NotEnoughArgsException.class, () -> studentBuilder.build());
    }
}