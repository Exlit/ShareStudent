package first.dto;

public interface StudDtoShow {

    String showHead = "<h1>Hello vas!</h1>" +
            "<table border=\"1\">" +
            "<tr><td></td>" +
            "<td>id</td>" +
            "<td>Имя</td>" +
            "<td>Фамилия</td>" +
            "<td>Возраст</td>" +
            "<td>Оценка</td>" +
            "<td>Курс</td>";

    String showStudList = "<tr>" +
            "<p id=\"student%d\"> <td><input type=\"checkbox\" id=\"%d\"></td>\n" +
            "<td> <div id=\"sNum%d\" style=\"display: none;\">%d</div>\n" +
            "<div id=\"number%d\" style=\"display: none;\">%d</div>%d</td>\n" +
            "<td>%s</td><td>%s</td>\n" +
            "<td>%s</td><td>%s</td>\n" +
            "<td>%s</td></p><tr>\n";

    String showEnd = "</table>" +
            "<p><button id=\"edit\">Редактировать</button></p>\n" +
            "<p><button id=\"del\">Удалить</button></p>\n" +
            "<script>" +
            "console.log(\"Javascript is working!\");" +
            "document.getElementById(\"edit\").addEventListener(\"click\", function(){\n" +
            "var result;\n" +
            "var numResult;\n" +
            "for (var i = 1; i <= %d; i++) {\n" +
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
            "for (var i = 1; i < %d; i++) {\n" +
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
            "</script>";
}
