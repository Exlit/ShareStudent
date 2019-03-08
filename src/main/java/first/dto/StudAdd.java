package first.dto;

public class StudAdd {
    public String add() {
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
}
