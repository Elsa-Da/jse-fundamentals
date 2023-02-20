import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;
import fr.aelion.user.LoginManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginManagerTest {
    LoginManager loginManager;

    @BeforeEach
    public void setup() {
        loginManager = new LoginManager("bond", "007");
    }

    @Test
    @DisplayName("Login & password should be 'bond' & '007' ")
    public void haveCredentials() {
        assertAll("Credentials",
                () -> assertEquals("bond", this.loginManager.getLogin()),
                () -> assertEquals("007", this.loginManager.getPassword())
        );
    }

    @Test
    @DisplayName("Should return 200 OK if credentials was good")
    public void goodCredentials() {
        assertEquals("200 OK", this.loginManager.login());
    }

    @Test
    @DisplayName("Should return 404 Not Found if credentials was bad")
    public void badCredentials() {
        LoginManager loginManager = new LoginManager("toto", "tata");
        assertEquals("404 Not Found", loginManager.login());
    }

    @Test
    @DisplayName("Student should be logged in")
    public void studentLogin() {

        StudentRepository studentRepository = this.loginManager.getStudentRepository();
        Student student = studentRepository.findByLoginAndPassword("bond", "007");

        assertEquals(false, student.isLoggedIn());
        this.loginManager.login();

        assertEquals(true, student.isLoggedIn());
    }

    @Test
    @DisplayName("Student should be logged out")
    public void studentLogout() {

        StudentRepository studentRepository = this.loginManager.getStudentRepository();
        Student student = studentRepository.findByLoginAndPassword("bond", "007");
        this.loginManager.login();
        assertEquals(true, student.isLoggedIn());

        this.loginManager.logout();
        assertEquals(false, student.isLoggedIn());

    }
}
