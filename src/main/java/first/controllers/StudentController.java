package first.controllers;

import first.model.Student;
import first.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class StudentController {
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @ResponseBody
    String getStudentForm() {
        String FORM = "<html>\n" +
                " <head>\n" +
                " </head>\n" +
                " <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\">\n" +
                " <body> \n" +
                " <form action=\"/viewstud\" method=\"get\" >\n" +
                "  <p>Имя:<br>\n" +
                "   <input type=\"text\" name=\"name\" size=\"40\">\n" +
                "  </p>\n" +
                "  <p>Фамилия:<br>\n" +
                "   <input type=\"text\" name=\"surname\" size=\"40\">\n" +
                "  </p>\n" +
                "  <p>Возраст:<br>\n" +
                "   <input type=\"number\" name=\"age\" size=\"2\">\n" +
                "  </p>\n" +
                "  <p>Оценка:<br>\n" +
                "   <input type=\"number\" name=\"mark\" size=\"2\">\n" +
                "  </p>\n" +
                "  <p>Курс:<br>\n" +
                "   <input type=\"number\" name=\"course\" size=\"1\">\n" +
                "  </p>\n" +
                "   <p><input type=\"submit\" name=\"button\" value=\" Добавить \"></p>\n" +
                "  </form>\n" +
                " </body>\n" +
                "</html>";
        return FORM;

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
        return "<html>\n" +
                "<head>\n" +
                "<title>HTML код таблицы, примеры</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table border=\"1\">\n" +
                "<tr>\n" +
                "<td>\n" + "</td>\n" +
                "<td>ячейка 2, первый ряд</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>ячейка 1, второй ряд</td>\n" +
                "<td>ячейка 2, второй ряд</td>\n" +
                "</tr>\n" +
                "</table> \n" +
                "</body>\n" +
                "</html>";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public String showStud(ArrayList<Student> student) {
        StudentRepository stude = new StudentRepository();
        stude.getConnection();

        return stude.show();
    }


//    @RequestMapping(value = "/viewstud", method = RequestMethod.GET)
//    @ResponseBody
//    public String studList(@RequestBody StudentDto studentDto) {
//        Student studentReady = new Student(studentDto.getName(), studentDto.getSurname(), studentDto.getAge(), studentDto.getMark(), studentDto.getCourse());
//        StudentRepository stud = new StudentRepository();
//        stud.getConnection();
//        stud.insert(studentReady);
//        return studentDto.getName() + studentDto.getSurname() + studentDto.getAge() + studentDto.getMark()+ studentDto.getCourse();
//    }
}
