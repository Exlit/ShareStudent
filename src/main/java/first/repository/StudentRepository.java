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

    public List<Student> show() {
        LinkedList<Student> list = new LinkedList<Student>();
        StringBuilder bd = new StringBuilder();
        try {

            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Students" );
            ResultSet result2 = preparedStatement.executeQuery();
            System.out.println( "Выводим PreparedStatement" );
            while (result2.next()) {
                list.add( new Student(result2.getInt("id"), result2.getString( "name" ), result2.getString( "surname" ), result2.getInt( "age" ), result2.getInt( "mark" ), result2.getInt( "Course" ) ) );
                System.out.println( "\t Студент: " + result2.getInt( "id" ) + "\t" + result2.getString( "name" ) + "\t" + result2.getString( "surname" ) + "\t" + result2.getInt( "age" ) + "\t" + result2.getInt( "mark" ) + "\t" + result2.getInt( "course" ) );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
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
            e.printStackTrace();
        }
    }

    public Student getStudentById(int id) {
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Students where id=" + id );

            ResultSet result2 = preparedStatement.executeQuery();
            System.out.println( "Выводим PreparedStatement" );
            while (result2.next()) {
                Student stud = new Student( result2.getInt( "id" ), result2.getString( "name" ), result2.getString( "surname" ), result2.getInt( "age" ), result2.getInt( "mark" ), result2.getInt( "Course" ) );
                System.out.println( "\t Студент: " + result2.getInt( "id" ) + "\t" + result2.getString( "name" ) + "\t" + result2.getString( "surname" ) + "\t" + result2.getInt( "age" ) + "\t" + result2.getInt( "mark" ) + "\t" + result2.getInt( "course" ) );
                return stud;
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
}