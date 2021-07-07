package first.dto;

import first.model.Student;
import first.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class StudentDto implements CRUDHtmlTemplate, ShowHtmlTemplate {
    private UserRepository rep;
    private Student student;

    public String add() {

        return ADDFORM;
    }

    public String getShow(Iterable<Student> findAll) {
        List<Student> list = (List) findAll;
        StringBuilder sb = new StringBuilder();
        sb.append(SHOWHEAD);
        for (
                int i = 0; i < list.size(); i++) {
            sb.append( String.format( showStudList, (i + 1), (i + 1), (i + 1), list.get((i)).getId(), (i + 1), (i + 1), (i + 1), list.get( i ).getName(), list.get( i ).getSurname(), list.get( i ).getAge(), list.get( i ).getMark(), list.get( i ).getCourse() ) );
        }
        sb.append( String.format( showEnd, list.size(), list.size() ) );
        return sb.toString();
    }

    public String editForm(Optional<Student> findById) {
        Student stud = findById.orElse(new Student());
        return String.format( EDITFORM, stud.getId(), stud.getName(), stud.getSurname(), stud.getAge(), stud.getMark(), stud.getCourse());
    }
}
