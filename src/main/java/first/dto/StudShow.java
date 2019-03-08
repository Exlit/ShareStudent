package first.dto;

import first.model.Student;
import first.repository.StudentRepository;

import java.util.List;

public class StudShow {
    public String getShow() {
    StudentRepository studRep = new StudentRepository();
        studRep.getConnection();
    List<Student> list = studRep.show();
    StringBuilder bd = new StringBuilder();
        bd.append("<h1>Hello vas!</h1>"+
                "<table border=\"1\">"+
                "<tr><td></td>"+
                "<td>id</td>"+
                "<td>Имя</td>"+
                "<td>Фамилия</td>"+
                "<td>Возраст</td>"+
                "<td>Оценка</td>"+
                "<td>Курс</td>");
        for(
    int i = 0; i<list.size();i++)

    {
        bd.append(
                "<tr>" +
                        "<p id=\"student" + (i + 1) + "\"> <td><input type=\"checkbox\" id=\"" + (i + 1) + "\"></td>\n" + "<td> <div id=\"sNum" + (i + 1) + "\" style=\"display: none;\">" + list.get( (i) ).getId() + "</div>" + "<div id=\"number" + (i + 1) + "\" style=\"display: none;\">" + (i + 1) + "</div>" + (i + 1) + "</td><td>" + list.get( i ).getName() + "</td><td>" + list.get( i ).getSurname() + "</td><td>" + list.get( i ).getAge() + "</td><td>" + list.get( i ).getMark() + "</td><td>" + list.get( i ).getCourse() + "</td></p><tr>\n" );
    }
        bd.append("</table>"+
                "<p><button id=\"edit\">Редактировать</button></p>\n"+
                "<p><button id=\"del\">Удалить</button></p>\n"+
                "<script>"+
                "console.log(\"Javascript is working!\");"+
                "document.getElementById(\"edit\").addEventListener(\"click\", function(){\n"+
                "var result;\n"+
                "var numResult;\n"+
                "for (var i = 1; i <= "+list.size()+"; i++) {\n"+
                "            var checkBox = document.getElementById(i);\n"+
                "            if (checkBox.checked == true){\n"+
                "                console.log(\"Checkbox was selected\");\n"+
                "                result = document.getElementById(\"sNum\" + i).textContent;\n"+
                "                break;\n"+
                "            }\n"+
                "        }"+
                "alert(result);\n"+
                "const Http = new XMLHttpRequest();\n"+
                "const url='http://localhost:8080/edit?id=' + result;\n"+
                "console.log(url);\n"+
                "window.location.href = url;\n"+
                "});"+

                "document.getElementById(\"del\").addEventListener(\"click\", function(){\n"+
                "var resultd;\n"+
                "var numResultd;\n"+
                "for (var i = 1; i < "+list.size()+"; i++) {\n"+
                "            var checkBox = document.getElementById(i);\n"+
                "            if (checkBox.checked == true){\n"+
                "                console.log(\"Checkbox was selected\");\n"+
                "                resultd = document.getElementById(\"sNum\" + i).textContent;\n"+
                "                break;\n"+
                "            }\n"+
                "        }"+
                "alert(resultd);\n"+
                "const Http = new XMLHttpRequest();\n"+
                "const url='http://localhost:8080/del?id=' + resultd;\n"+
                "console.log(url);\n"+
                "window.location.href = url;\n"+
                "});"+
                "</script>");
        return bd.toString();
}
}
