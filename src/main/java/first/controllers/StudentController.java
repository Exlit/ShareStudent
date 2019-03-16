package first.controllers;

import first.dto.StudentDto;
import first.model.Student;
import first.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController implements StudentControllerInter {
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @ResponseBody
    String getStudentForm() {
        StudentDto studAdd = new StudentDto();
        return studAdd.add();
    }

    @RequestMapping(value = "/viewstud", method = RequestMethod.GET)
    @ResponseBody
    public String viewstud(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "age") Integer age, @RequestParam(value = "mark") Integer mark, @RequestParam(value = "course") Integer course, @RequestParam(value = "button") String button) {
        System.out.println( "Данные зашли" );
        Student studentReady = new Student( name, surname, age, mark, course );
        System.out.println( "Студент создан" );
        StudentRepository stud = new StudentRepository();
        stud.getConnection();
        System.out.println( "подключились к базе" );
        stud.insert( studentReady );
        return str;

    }

    @RequestMapping("/show")
    public String greeting() {
        StudentDto show = new StudentDto();
        return show.getShow();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @ResponseBody
    String updStudentForm(@RequestParam(value = "id") Integer id) {
        StudentDto studEdit = new StudentDto();
        return studEdit.edit( id );
    }

    @RequestMapping(value = "/editdone", method = RequestMethod.GET)
    @ResponseBody
    public String testRedirect(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "age") Integer age, @RequestParam(value = "mark") Integer mark, @RequestParam(value = "course") Integer course, @RequestParam(value = "id") Integer id, @RequestParam(value = "button") String button) {
        StudentDto studEdit = new StudentDto();
        return studEdit.editDone( name, surname, age, mark, course, id, button );
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ResponseBody
    String delStudent(@RequestParam(value = "id") Integer id) {
        StudentDto studDel = new StudentDto();
        return studDel.del( id );
    }

    @RequestMapping(value = "/deldone", method = RequestMethod.GET)
    @ResponseBody
    public String delRedirect(@RequestParam(value = "id") Integer id) {
        StudentDto studDel = new StudentDto();
        return studDel.delDone( id );
    }
}