package fr.aelion.repositories;

import fr.aelion.dbal.DbConnect;
import fr.aelion.dbal.postgres.PgConnect;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.helpers.exceptions.StudentNotFound;
import fr.aelion.models.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends Repository<Student> {

    private DbConnect dbConnect;

    public StudentRepository(Class<Student> className) throws StudentException {
        super(className);
        this.dbConnect = PgConnect.getInstance();
    }

    /**
     * @return List of Students of our DB
     */
    public List<Student> findAll() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();

        // need an SQL query
        String sqlQuery = getSelectQuery().substring(0, getSelectQuery().length()-1) + " ORDER BY last_name, first_name;";

        // send sqlQuery to RDBMS => need to create a Statement object
        Connection connection = this.dbConnect.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // exploit the ResultSet obejct => loop over a cursor
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setLastName(resultSet.getString("last_name"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setLogin(resultSet.getString("login"));
            student.setPassword(resultSet.getString("password"));

            students.add(student);
        }

        // free resources
        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();

        return students;
    }

    public Student findByLoginAndPassword(String login, String password) throws SQLException, StudentNotFound {
        Student student = new Student();

        String sqlQuery = getSelectQuery().substring(0, getSelectQuery().length()-1);
        sqlQuery += " WHERE login = '" + login.replace("'", "''") + "' AND password = '" + password + "' ;";

        Connection connection = this.dbConnect.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        if (resultSet.next() == false) {
            throw new StudentNotFound();
        } else {
               student.setId(resultSet.getInt("id"));
                student.setLastName(resultSet.getString("last_name"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
                student.setLogin(resultSet.getString("login"));
                student.setPassword(resultSet.getString("password"));
        }

        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();

        return student;
    }

    public Student findById(int id) throws StudentNotFound, SQLException {
        Student student = new Student();

        String sqlQuery = getSelectQuery().substring(0, getSelectQuery().length()-1);
        sqlQuery += " WHERE id = " + id + ";";

        Connection connection = this.dbConnect.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        if (resultSet.next() == false) {
            throw new StudentNotFound();
        } else {
                student.setId(resultSet.getInt("id"));
                student.setLastName(resultSet.getString("last_name"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
                student.setLogin(resultSet.getString("login"));
                student.setPassword(resultSet.getString("password"));
        }

        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();

        return student;
    }



}
