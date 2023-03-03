import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.helpers.exceptions.StudentNotFound;
import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    StudentRepository studentRepository;

    @BeforeEach
    public void setup() throws StudentException {
        studentRepository = new StudentRepository(Student.class);
    }

    @Test
    @DisplayName("Studentlist should have 100 elements")
    public void studentInstanciationTest() throws SQLException {

        List<Student> students = studentRepository.findAll();
        assertEquals(100, students.size());
    }

    @Test
    @DisplayName("Should have Arnaud Dieudonnée 96 as first result")
    public void firstStudentMustMatch() throws SQLException {
        List<Student> students = studentRepository.findAll();
        Student student = students.get(0);
        assertAll (
                () -> assertEquals("Arnaud", student.getLastName()),
                () -> assertEquals("Dieudonnée", student.getFirstName()),
                () -> assertEquals(96, student.getId())
        );
    }

    @Test
    @DisplayName("Should find Armelle Blanchard by its login and password")
    public void findByLoginAndPassword() throws SQLException, StudentNotFound {
        Student student = studentRepository.findByLoginAndPassword("Blanchard76", "_9SmrK_v77RuwMSblmLq");
        assertAll (
                () -> assertEquals("Blanchard", student.getLastName()),
                () -> assertEquals("Armelle", student.getFirstName()),
                () -> assertTrue(student instanceof Student)
        );
    }

    @Test
    @DisplayName("Should throw an exception")
    public void DoesntFindByLoginAndPassword() throws SQLException {
        assertThrows(Exception.class, () -> studentRepository.findByLoginAndPassword("Blanchard2276", "_9SmrK_v77RuwMSblmLq"));
    }

    @Test
    @DisplayName("Should find Armelle Blanchard by its id")
    public void findById() throws SQLException, StudentNotFound {
        Student student = studentRepository.findById(11);
        assertAll (
                () -> assertEquals("Blanchard", student.getLastName()),
                () -> assertEquals("Armelle", student.getFirstName()),
                () -> assertTrue(student instanceof Student)
        );
    }

    @Test
    @DisplayName("Should throw an exception ID")
    public void DoesntFindById() throws SQLException {
        assertThrows(Exception.class, () -> studentRepository.findById(120));
    }

    @Test
    @DisplayName("Should return 'student' from Student class")
    void shouldReturnTableName() {
        assertEquals("student", studentRepository.getTableName());
    }

    @Test
    @DisplayName("Should give 'student s' from Student class")
    void shouldGiveAliasedTableName() {
        assertEquals("student s", studentRepository.getAliasedTableName());
    }

    @Test
    @DisplayName("Should get all attributes from model")
    void shouldListAllAttributes() {
        String[] expectedFields = {"email", "firstName", "id", "lastName", "login", "password", "phoneNumber"};
        String[] classFields = studentRepository.getFields();
        Arrays.sort(classFields);

        assertTrue(Arrays.equals(expectedFields, classFields));
    }

    @Test
    @DisplayName("Should return a comma separate list of column names")
    void shouldReturnCommaSeparatedList() {
        String expected = "s.email,s.first_name,s.id,s.last_name,s.login,s.password,s.phone_number";
        assertEquals(expected, studentRepository.getCommaSeparatedColumns());
    }

    @Test
    @DisplayName("Should return a full SELECT query")
    void shouldReturnFullSelectQuery() {
        String expected = "SELECT s.email,s.first_name,s.id,s.last_name,s.login,s.password,s.phone_number FROM student s;";
        assertEquals(expected, studentRepository.getSelectQuery());
    }
}
