package first.controllers;


import first.dto.StudentDto;
import first.model.Student;
import first.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/")
public class StudentController implements BaseHtmlTemplate{
    @Autowired
    private UserRepository userRepository;
    Student student = new Student();
    StudentDto dto = new StudentDto();
    @RequestMapping(path="/index")
    @ResponseBody
    public String demo()
    {
        return " <head>\n" +
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
    }

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser () {
        return dto.add();
    }

        @RequestMapping(value = "/addDone", method = RequestMethod.GET)
        @ResponseBody
        public String getAllUsers(@RequestParam String name, @RequestParam String surname, @RequestParam Integer age, @RequestParam Integer mark, @RequestParam Integer course) {
        student.setName(name);
        student.setSurname(surname);
        student.setAge(age);
        student.setMark(mark);
        student.setCourse(course);
        userRepository.save(student);
        return dto.getShow(userRepository.findAll());
        }

    @GetMapping(path="/show")
    @ResponseBody
    public String showUsers () {
        return dto.getShow(userRepository.findAll());
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @ResponseBody
    public String updStudentForm(@RequestParam(value = "id") Integer id) {

        return dto.editForm(userRepository.findById(id));
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ResponseBody
    public String delStudentForm(@RequestParam(value = "id") Integer id) {
        userRepository.deleteById(id);
        return dto.getShow(userRepository.findAll());
    }
}