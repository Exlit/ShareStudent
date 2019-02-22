package first.repository;

import first.model.Student;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public String show() {
        ArrayList<Student> list = new ArrayList<Student>();
        StringBuilder bd = new StringBuilder();
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Students" );
            ResultSet result2 = preparedStatement.executeQuery();
            System.out.println( "Выводим PreparedStatement" );
            while (result2.next()) {
                list.add( new Student( result2.getString( "name" ), result2.getString( "surname" ), result2.getInt( "age" ), result2.getInt( "mark" ), result2.getInt( "Course" ) ) );
                System.out.println( "\t Студент: " + result2.getInt( "id" ) + "\t" + result2.getString( "name" ) + "\t" + result2.getString( "surname" ) + "\t" + result2.getInt( "age" ) + "\t" + result2.getInt( "mark" ) + "\t" + result2.getInt( "course" ) );
            }

            bd.append( "<html>\n" +
                    "                <head>\n" +
                    "                <title>Список студентов</title>\n" +

                    "                </head>\n" +
                    "                <body>\n" +
                    " <table border=\"1\">\n" +
                    "<tr><td> Номер </td>\n" +
                    "<td> Имя </td>\n" +
                    "<td> Фамилия </td>\n" +
                    "<td> Возвраст </td>\n" +
                    "<td> Оценка </td>\n" +
                    "<td> Курс </td>\n" +
                    "</tr>" );

            for (int i = 0; i < list.size(); i++) {
                int id = i + 1;
                bd.append( "<tr><td>\n" + id + "</td>\n" +
                        "<td>\n" + list.get( i ).getName() + "</td>\n" +
                        "<td>\n" + list.get( i ).getSurname() + "</td>\n" +
                        "<td>\n" + list.get( i ).getAge() + "</td>\n" +
                        "<td>\n" + list.get( i ).getMark() + "</td>\n" +
                        "<td>\n" + list.get( i ).getCourse() + "</td>\n" +
                        "<td><a href=\"edit\" method = \"get\">Редактировать</a>\n" +
                        // "<td> <p><a href=\"edit>редактировать</a></p>\n" +
                        "</tr>" );
            }
            bd.append( "</table></body>\n" +
                    "</html>" );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bd.toString();
    }


    public String edit(Integer id) {
        ArrayList<Student> list = new ArrayList<Student>();
        StringBuilder bd = new StringBuilder();
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Students where id=" + id);
            ResultSet result2 = preparedStatement.executeQuery();
            System.out.println( "Выводим PreparedStatement" );
            while (result2.next()) {

                list.add( new Student( result2.getString( "name" ), result2.getString( "surname" ), result2.getInt( "age" ), result2.getInt( "mark" ), result2.getInt( "Course" ) ) );
                System.out.println( "\t Студент: " + result2.getInt( "id" ) + "\t" + result2.getString( "name" ) + "\t" + result2.getString( "surname" ) + "\t" + result2.getInt( "age" ) + "\t" + result2.getInt( "mark" ) + "\t" + result2.getInt( "course" ) );
            }
            bd.append( "<html>\n" +
                    "                <head>\n" +
                    "                <title>Список студентов</title>\n" +

                    "                </head>\n" +
                    "                <body>\n" +
                    " <form action=\"/show\" method=\"get\" >\n" +
                    "<b>Студент</b>\n" +
                    " <table border=\"1\">\n" );

            for (int i = 0; i < list.size(); i++) {
                bd.append(
                                "<tr><td>\n" + list.get( i ).getName() + "</td><td><input type=\"text\" name=\"name\" size=\"40\"></td>\n" +
                                "<tr><td>\n" + list.get( i ).getSurname() + "</td><td><input type=\"text\" name=\"surname\" size=\"40\"></td>\n" +
                                "<tr><td>\n" + list.get( i ).getAge() + "</td><td><input type=\"number\" name=\"age\" size=\"2\"></td>\n" +
                                "<tr><td>\n" + list.get( i ).getMark() + "</td><td><input type=\"number\" name=\"mark\" size=\"2\"></td>\n" +
                                "<tr><td>\n" + list.get( i ).getCourse() + "</td><td><input type=\"number\" name=\"course\" size=\"1\"></td>\n" +
                                "</table>\n" +
                                "<p><input type=\"submit\" name=\"button\" value=\" Готово \"></p>\n" );
            }
            bd.append( "</form></body>\n" +
                    "</html>" );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bd.toString();
    }

    public Student getStidentById(int id) {
        return null;
    }

    public List<Student> studetnList() {
        return null;
    }

}