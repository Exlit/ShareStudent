package first.dto;

import first.model.Student;
import first.repository.StudentRepository;

import java.util.List;

public class StudentDto implements StudDto, StudDtoShow {
    private final StudentRepository rep = new StudentRepository();

    public String add() {
        return FORM;
    }

    public String edit(Integer id) {
        rep.getConnection();
        return String.format( editForm, id, rep.getStudentById( id ).getName(), rep.getStudentById( id ).getSurname(), rep.getStudentById( id ).getAge(), rep.getStudentById( id ).getMark(), rep.getStudentById( id ).getCourse() );
    }

    public String editDone(String name, String surname, Integer age, Integer mark, Integer course, Integer id, String button) {
        System.out.println( "Данные зашли" );
        Student studentRead = new Student( id, name, surname, age, mark, course );
        System.out.println( "Студент создан" );
        StudentRepository stud = new StudentRepository();
        stud.getConnection();
        System.out.println( "подключились к базе" );
        stud.update( studentRead );

        return strEdit;
    }

    public String del(Integer id) {
        rep.getConnection();
        return String.format( delForm, id, rep.getStudentById( id ).getName(), rep.getStudentById( id ).getSurname(), rep.getStudentById( id ).getAge(), rep.getStudentById( id ).getMark(), rep.getStudentById( id ).getCourse() );
    }

    public String delDone(Integer id) {
        System.out.println( "Данные зашли" );
        StudentRepository stud = new StudentRepository();
        stud.getConnection();
        System.out.println( "подключились к базе" );
        stud.del( id );
        return str;
    }

    public String getShow() {
        rep.getConnection();
        List<Student> list = rep.show();
        StringBuilder bd = new StringBuilder();
        bd.append( showHead );
        for (
                int i = 0; i < list.size(); i++) {
            bd.append( String.format( showStudList, (i + 1), (i + 1), (i + 1), list.get( (i) ).getId(), (i + 1), (i + 1), (i + 1), list.get( i ).getName(), list.get( i ).getSurname(), list.get( i ).getAge(), list.get( i ).getMark(), list.get( i ).getCourse() ) );
        }
        bd.append( String.format( showEnd, list.size(), list.size() ) );
        return bd.toString();
    }

}
