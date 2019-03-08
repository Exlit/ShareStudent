package first.controllers;

import first.dto.StudAdd;
import first.dto.StudDel;
import first.dto.StudEdit;
import first.dto.StudShow;
import first.model.Student;
import first.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @ResponseBody
    String getStudentForm() {
        StudAdd studAdd = new StudAdd();
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
        String str = " <head>\n" +
                " </head>\n" +
                " <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\">\n" +
                " <body> \n" +
                " <form action=\"/form\" method=\"get\" >\n" +
                " <p><input type=\"submit\" name=\"button\" value=\" Добавить студетна \"></p>\n" +
                "  </form>\n" +
                " <form action=\"/show\" method=\"get\" >\n" +
                " <p><input type=\"submit\" name=\"button\" value=\" Посмотреть список \"></p>\n" +
                "  </form>\n" +
                " </body>\n" +
                "</html>";
        return str;

    }


    @RequestMapping("/show")
    public String greeting() {
        StudShow show = new StudShow();
        return show.getShow();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @ResponseBody
    String updStudentForm(@RequestParam(value = "id") Integer id) {
        StudEdit studEdit = new StudEdit();
        return studEdit.edit( id );
    }


    @RequestMapping(value = "/editdone", method = RequestMethod.GET)
    @ResponseBody
    public String testRedirect(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "age") Integer age, @RequestParam(value = "mark") Integer mark, @RequestParam(value = "course") Integer course, @RequestParam(value = "id") Integer id, @RequestParam(value = "button") String button) {
        StudEdit studEdit = new StudEdit();
        return studEdit.editDone( name, surname, age, mark, course, id, button );
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ResponseBody
    String delStudent(@RequestParam(value = "id") Integer id) {
        StudDel studDel = new StudDel();
        return studDel.del( id );
    }

    @RequestMapping(value = "/deldone", method = RequestMethod.GET)
    @ResponseBody
    public String delRedirect(@RequestParam(value = "id") Integer id) {
        StudDel studDel = new StudDel();
        return studDel.delDone( id );
    }
}