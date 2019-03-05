package first.controllers;

import first.model.Student;
import first.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Controller
@RestController
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
        return " <head>\n" +
                " </head>\n" +
                " <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\">\n" +
                " <body> \n" +
                " <form action=\"/form\" method=\"get\" >\n" +
                " <p><input type=\"submit\" name=\"button\" value=\" Добавить еще \"></p>\n" +
                "  </form>\n" +
                " <form action=\"/show\" method=\"get\" >\n" +
                " <p><input type=\"submit\" name=\"button\" value=\" Посмотреть список \"></p>\n" +
                "  </form>\n" +
                " </body>\n" +
                "</html>";

    }


    @RequestMapping("/show")
    public String greeting() {
        StudentRepository studRep = new StudentRepository();
        studRep.getConnection();
        List<Student> list = studRep.show();
        StringBuilder bd = new StringBuilder();
        bd.append( "<h1>Hello vas!</h1>" +
                "<table border=\"1\">" +
                "<tr><td></td>"+
                "<td>id</td>"+
                "<td>Имя</td>" +
                "<td>Фамилия</td>"+
                "<td>Возраст</td>"+
                "<td>Оценка</td>"+
                "<td>Курс</td>");
        for (int i = 0; i < list.size(); i++) {
            bd.append(
                    "<tr>" +
                    "<p id=\"student" + (i+1) + "\"> <td><input type=\"checkbox\" id=\"" + (i+1) + "\"></td>\n" + "<td> <div id=\"sNum" + (i + 1) + "\" style=\"display: none;\">" + list.get((i)).getId() + "</div>" + "<div id=\"number" + (i + 1) + "\" style=\"display: none;\">" + (i+1) + "</div>" + (i+1) + "</td><td>" + list.get( i ).getName() + "</td><td>" + list.get( i ).getSurname() + "</td><td>" + list.get( i ).getAge() + "</td><td>" + list.get( i ).getMark() + "</td><td>" + list.get( i ).getCourse() + "</td></p><tr>\n" );
        }
        bd.append( "</table>" +
                "<p><button id=\"edit\">Редактировать</button></p>\n" +
                "<p><button id=\"del\">Удалить</button></p>\n" +
                "<script>" +
                "console.log(\"Javascript is working!\");" +
                "document.getElementById(\"edit\").addEventListener(\"click\", function(){\n" +
                "var result;\n" +
                "var numResult;\n" +
                "for (var i = 1; i <= "+ list.size() +"; i++) {\n" +
                "            var checkBox = document.getElementById(i);\n" +
                "            if (checkBox.checked == true){\n" +
                "                console.log(\"Checkbox was selected\");\n" +
                "                result = document.getElementById(\"sNum\" + i).textContent;\n" +
                "                break;\n" +
                "            }\n" +
                "        }" +
                "alert(result);\n" +
                "const Http = new XMLHttpRequest();\n" +
                "const url='http://localhost:8080/edit?id=' + result;\n" +
                "console.log(url);\n" +
                "window.location.href = url;\n" +
                "});" +

                "document.getElementById(\"del\").addEventListener(\"click\", function(){\n" +
                "var resultd;\n" +
                "var numResultd;\n" +
                "for (var i = 1; i < "+ list.size() +"; i++) {\n" +
                "            var checkBox = document.getElementById(i);\n" +
                "            if (checkBox.checked == true){\n" +
                "                console.log(\"Checkbox was selected\");\n" +
                "                resultd = document.getElementById(\"sNum\" + i).textContent;\n" +
                "                break;\n" +
                "            }\n" +
                "        }" +
                "alert(resultd);\n" +
                "const Http = new XMLHttpRequest();\n" +
                "const url='http://localhost:8080/del?id=' + resultd;\n" +
                "console.log(url);\n" +
                "window.location.href = url;\n" +
                "});" +
                "</script>" );
        return bd.toString();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @ResponseBody
    String updStudentForm(@RequestParam(value = "id") Integer id) {
        StudentRepository rep = new StudentRepository();
        rep.getConnection();


        String FORM = "<html>\n" +
                " <head>\n" +
                " </head>\n" +
                " <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\">\n" +
                " <body> \n" +
                " <form action=\"/editdone\" method=\"get\" >\n" +
                "   <input type=\"text\" name=\"id\" size=\"40\" value=\"" + id + "\"readonly>\n" +
                "  <p>Имя:<br>\n" +
                "   <input type=\"text\" name=\"name\" size=\"40\" value=\"" + rep.getStudentById( id ).getName() + "\">\n" +
                "  </p>\n" +
                "  <p>Фамилия:<br>\n" +
                "   <input type=\"text\" name=\"surname\" size=\"40\" value=\"" + rep.getStudentById( id ).getSurname() + "\">\n" +
                "  </p>\n" +
                "  <p>Возраст:<br>\n" +
                "   <input type=\"number\" name=\"age\" size=\"2\" value=\"" + rep.getStudentById( id ).getAge() + "\">\n" +
                "  </p>\n" +
                "  <p>Оценка:<br>\n" +
                "   <input type=\"number\" name=\"mark\" size=\"2\" value=\"" + rep.getStudentById( id ).getMark() + "\">\n" +
                "  </p>\n" +
                "  <p>Курс:<br>\n" +
                "   <input type=\"number\" name=\"course\" size=\"1\" value=\"" + rep.getStudentById( id ).getCourse() + "\">\n" +
                "  </p>\n" +
                "   <p><input type=\"submit\" name=\"button\" value=\" Обновить \"></p>\n" +
                "  </form>\n" +
                " </body>\n" +
                "</html>";
        return FORM;
    }


    @RequestMapping(value = "/editdone", method = RequestMethod.GET)
    @ResponseBody
    public String testRedirect(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "age") Integer age, @RequestParam(value = "mark") Integer mark, @RequestParam(value = "course") Integer course, @RequestParam(value = "id") Integer id, @RequestParam(value = "button") String button) {
        System.out.println( "Данные зашли" );
        Student studentRead= new Student(id, name, surname, age, mark, course);
        System.out.println( "Студент создан" );
        StudentRepository stud = new StudentRepository();
        stud.getConnection();
        System.out.println( "подключились к базе" );
        stud.update( studentRead );
        return  " <head>\n" +
                " </head>\n" +
                " <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\">\n" +
                " <body> \n" +
                " <form action=\"/form\" method=\"get\" >\n" +
                " <p><input type=\"submit\" name=\"button\" value=\" Добавить еще \"></p>\n" +
                "  </form>\n" +
                " <form action=\"/show\" method=\"get\" >\n" +
                " <p><input type=\"submit\" name=\"button\" value=\" Посмотреть список \"></p>\n" +
                "  </form>\n" +
                " </body>\n" +
                "</html>";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ResponseBody
    String delStudent(@RequestParam(value = "id") Integer id) {
        StudentRepository rep = new StudentRepository();
        rep.getConnection();


        String FORM = "<html>\n" +
                " <head>\n" +
                " </head>\n" +
                " <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\">\n" +
                " <body> \n" +
                " <form action=\"/deldone\" method=\"get\" >\n" +
                "   <input type=\"text\" name=\"id\" size=\"40\" value=\"" + id + "\"readonly>\n" +
                "  <p>Имя:<br>\n" +
                "   <input type=\"text\" name=\"name\" size=\"40\" value=\"" + rep.getStudentById( id ).getName() + "\">\n" +
                "  </p>\n" +
                "  <p>Фамилия:<br>\n" +
                "   <input type=\"text\" name=\"surname\" size=\"40\" value=\"" + rep.getStudentById( id ).getSurname() + "\">\n" +
                "  </p>\n" +
                "  <p>Возраст:<br>\n" +
                "   <input type=\"number\" name=\"age\" size=\"2\" value=\"" + rep.getStudentById( id ).getAge() + "\">\n" +
                "  </p>\n" +
                "  <p>Оценка:<br>\n" +
                "   <input type=\"number\" name=\"mark\" size=\"2\" value=\"" + rep.getStudentById( id ).getMark() + "\">\n" +
                "  </p>\n" +
                "  <p>Курс:<br>\n" +
                "   <input type=\"number\" name=\"course\" size=\"1\" value=\"" + rep.getStudentById( id ).getCourse() + "\">\n" +
                "  </p>\n" +
                "   <p><input type=\"submit\" name=\"button\" value=\" Удалить \"></p>\n" +
                "  </form>\n" +
                " </body>\n" +
                "</html>";
        return FORM;
    }

    @RequestMapping(value = "/deldone", method = RequestMethod.GET)
    @ResponseBody
    public String delRedirect(@RequestParam(value = "id") Integer id) {
        System.out.println( "Данные зашли" );
        StudentRepository stud = new StudentRepository();
        stud.getConnection();
        System.out.println( "подключились к базе" );
        stud.del(id);
        return  " <head>\n" +
                " </head>\n" +
                " <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\">\n" +
                " <body> \n" +
                " <form action=\"/form\" method=\"get\" >\n" +
                " <p><input type=\"submit\" name=\"button\" value=\" Добавить еще \"></p>\n" +
                "  </form>\n" +
                " <form action=\"/show\" method=\"get\" >\n" +
                " <p><input type=\"submit\" name=\"button\" value=\" Посмотреть список \"></p>\n" +
                "  </form>\n" +
                " </body>\n" +
                "</html>";
    }
}