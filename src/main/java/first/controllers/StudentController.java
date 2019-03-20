package first.controllers;

import first.dto.StudentDto;
import first.model.Student;
import first.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController implements BaseHtmlTemplate {
    StudentRepository studentRepository = new StudentRepository();
    Student student;
    StudentDto dto = new StudentDto();

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @ResponseBody
    public String getStudentForm() {
        StudentDto studAdd = new StudentDto();
        return studAdd.add();
    }

    @RequestMapping(value = "/viewstud", method = RequestMethod.GET)
    @ResponseBody
    public String viewstud(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "age") Integer age, @RequestParam(value = "mark") Integer mark, @RequestParam(value = "course") Integer course, @RequestParam(value = "button") String button) {
        System.out.println( "Данные зашли" );
        student = new Student( name, surname, age, mark, course );
        System.out.println( "Студент создан" );
        studentRepository.getConnection();
        System.out.println( "подключились к базе" );
        studentRepository.insert( student );
        return main;
    }

    @RequestMapping("/show")
    public String greeting() {
        return dto.getShow();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @ResponseBody
    public String updStudentForm(@RequestParam(value = "id") Integer id) {
        return dto.editForm( id );
    }

    @RequestMapping(value = "/editdone", method = RequestMethod.GET)
    @ResponseBody
    public String testRedirect(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "age") Integer age, @RequestParam(value = "mark") Integer mark, @RequestParam(value = "course") Integer course, @RequestParam(value = "id") Integer id, @RequestParam(value = "button") String button) {
        return dto.editStudent( name, surname, age, mark, course, id, button );
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ResponseBody
    public String delStudent(@RequestParam(value = "id") Integer id) {
        return dto.delForm( id );
    }

    @RequestMapping(value = "/deldone", method = RequestMethod.GET)
    @ResponseBody
    public String delRedirect(@RequestParam(value = "id") Integer id) {
        return dto.delStudentById( id );
    }
}