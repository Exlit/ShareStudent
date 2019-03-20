package first.repository;

import first.model.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StudentRepository {
    private static final String FULL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/feedback";
    private static final String LOGIN = "root";
    private static final String PASS = "NGhiphop020188!";
    private static final String TABLE = "insert into students values (default, ?, ?, ?, ?, ?)";
    private static final String UPDTABLE = "update students set name=?, surname=?, age=?, mark=?, course=? WHERE id =?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public Connection getConnection() {
        try {
            Class.forName( FULL_DRIVER_NAME );
            System.out.println( "Драйвер подгружен" );
            connection = DriverManager.getConnection( URL, LOGIN, PASS );
            System.out.println( "Подключение к базе успешно" );
        } catch (SQLException e) {
            System.err.println( e );
        } catch (ClassNotFoundException e) {
            System.err.println( e );
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
            System.err.println( e );
        }
    }

    public List<Student> show() {
        LinkedList<Student> StudentList = new LinkedList<Student>();
        try {
            preparedStatement = connection.prepareStatement( "SELECT * FROM Students" );
            ResultSet result = preparedStatement.executeQuery();
            System.out.println( "Выводим PreparedStatement" );
            while (result.next()) {
                StudentList.add( new Student( result.getInt( "id" ), result.getString( "name" ), result.getString( "surname" ), result.getInt( "age" ), result.getInt( "mark" ), result.getInt( "Course" ) ) );
                System.out.println( "\t Студент: " + result.getInt( "id" ) + "\t" + result.getString( "name" ) + "\t" + result.getString( "surname" ) + "\t" + result.getInt( "age" ) + "\t" + result.getInt( "mark" ) + "\t" + result.getInt( "course" ) );
            }
        } catch (SQLException e) {
            System.err.println( e );
        }
        return StudentList;
    }

    public void update(Student student) {
        try {
            preparedStatement = connection.prepareStatement( UPDTABLE );
            preparedStatement.setString( 1, student.getName() );
            preparedStatement.setString( 2, student.getSurname() );
            preparedStatement.setInt( 3, student.getAge() );
            preparedStatement.setInt( 4, student.getMark() );
            preparedStatement.setInt( 5, student.getCourse() );
            preparedStatement.setInt( 6, student.getId() );
            preparedStatement.execute();
            System.out.println( "студент обновлен в базе" );
        } catch (SQLException e) {
            System.err.println( e );
        }
    }

    public Student getStudentById(int id) {
        try {
            preparedStatement = connection.prepareStatement( "SELECT * FROM Students where id=" + id );
            ResultSet result = preparedStatement.executeQuery();
            System.out.println( "Выводим PreparedStatement" );
            while (result.next()) {
                Student stud = new Student( result.getInt( "id" ), result.getString( "name" ), result.getString( "surname" ), result.getInt( "age" ), result.getInt( "mark" ), result.getInt( "Course" ) );
                System.out.println( "\t Студент: " + result.getInt( "id" ) + "\t" + result.getString( "name" ) + "\t" + result.getString( "surname" ) + "\t" + result.getInt( "age" ) + "\t" + result.getInt( "mark" ) + "\t" + result.getInt( "course" ) );
                return stud;
            }
        } catch (SQLException e) {
            System.err.println( e );
        }
        return null;
    }

    public void del(int id) {
        try {
            String DEL = "delete from Students WHERE id =" + id;
            preparedStatement = connection.prepareStatement( DEL );
            preparedStatement.execute( DEL );
            System.out.println( "Студент под номером " + id + " удален" );

        } catch (SQLException e) {
            System.err.println( e );
        }
    }
}