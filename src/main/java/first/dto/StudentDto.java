package first.dto;

import first.controllers.BaseHtmlTemplate;
import first.model.Student;
import first.repository.StudentRepository;

import java.util.List;

public class StudentDto implements CRUDHtmlTemplate, ShowHtmlTemplate {
    private final StudentRepository rep = new StudentRepository();


    public String add() {
        return ADDFORM;
    }

    public String editForm(Integer id) {
        rep.getConnection();
        return String.format( EDITFORM, id, rep.getStudentById( id ).getName(), rep.getStudentById( id ).getSurname(), rep.getStudentById( id ).getAge(), rep.getStudentById( id ).getMark(), rep.getStudentById( id ).getCourse() );
    }

    public String editStudent(String name, String surname, Integer age, Integer mark, Integer course, Integer id, String button) {
        System.out.println( "Данные зашли" );
        Student student = new Student( id, name, surname, age, mark, course );
        System.out.println( "Студент создан" );

        rep.getConnection();
        System.out.println( "подключились к базе" );
        rep.update( student );
        return BaseHtmlTemplate.MAIN;
    }

    public String delForm(Integer id) {
        rep.getConnection();
        return String.format( DELFORM, id, rep.getStudentById( id ).getName(), rep.getStudentById( id ).getSurname(), rep.getStudentById( id ).getAge(), rep.getStudentById( id ).getMark(), rep.getStudentById( id ).getCourse() );
    }

    public String delStudentById(Integer id) {
        System.out.println( "Данные зашли" );
        rep.getConnection();
        System.out.println( "подключились к базе" );
        rep.del( id );
        return BaseHtmlTemplate.MAIN;
    }

    public String getShow() {
        rep.getConnection();
        List<Student> list = rep.show();
        StringBuilder sb = new StringBuilder();
        sb.append(SHOWHEAD);
        for (
                int i = 0; i < list.size(); i++) {
            sb.append( String.format( showStudList, (i + 1), (i + 1), (i + 1), list.get( (i) ).getId(), (i + 1), (i + 1), (i + 1), list.get( i ).getName(), list.get( i ).getSurname(), list.get( i ).getAge(), list.get( i ).getMark(), list.get( i ).getCourse() ) );
        }
        sb.append( String.format( showEnd, list.size(), list.size() ) );
        return sb.toString();
    }
}
