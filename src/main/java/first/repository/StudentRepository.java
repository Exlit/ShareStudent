package first.repository;

import first.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRepository {
    private static final String FULL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/feedback";
    private static final String LOGIN = "root";
    private static final String PASS = "NGhiphop020188!";
    private static final String TABLE = "insert into students values (default, ?, ?, ?, ?, ?)";
    private Connection connection;
    private PreparedStatement preparedStatement;

    public Connection getConnection() {
        try {
            Class.forName( FULL_DRIVER_NAME );
            System.out.println( "Драйвер подгружен" );
            connection = DriverManager
                    .getConnection( URL, LOGIN, PASS );
            System.out.println( "Подключение к базе успешно" );
        } catch (SQLException e) {
            System.out.println( "Неудалось загрузить класс драйвера" );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return connection;
    }
    public void insert(Student student) {
        try {
            preparedStatement = connection.prepareStatement( TABLE );
            preparedStatement.setString( 1, student.getName() );
            preparedStatement.setString( 2, student.getSurname() );
            preparedStatement.setInt( 3, student.getAge() );
            preparedStatement.setInt( 4, student.getMark() );
            preparedStatement.setInt( 5, student.getCourse() );
            preparedStatement.execute();
            System.out.println( "студент точно в базе" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}