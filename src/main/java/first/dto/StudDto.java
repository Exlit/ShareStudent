package first.dto;

public interface StudDto {
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

    String str = " <head>\n" +
            " </head>\n" +
            " <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\">\n" +
            " <body> \n" +
            " <form action=\"/form\" method=\"get\" >\n" +
            " <p><input type=\"submit\" name=\"button\" value=\" Добавить студента \"></p>\n" +
            "  </form>\n" +
            " <form action=\"/show\" method=\"get\" >\n" +
            " <p><input type=\"submit\" name=\"button\" value=\" Посмотреть список \"></p>\n" +
            "  </form>\n" +
            " </body>\n" +
            "</html>";

    String strEdit = " <head>\n" +
            " </head>\n" +
            " <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\">\n" +
            " <body> \n" +
            " <form action=\"/form\" method=\"get\" >\n" +
            " <p><input type=\"submit\" name=\"button\" value=\" Добавить студента \"></p>\n" +
            "  </form>\n" +
            " <form action=\"/show\" method=\"get\" >\n" +
            " <p><input type=\"submit\" name=\"button\" value=\" Посмотреть список \"></p>\n" +
            "  </form>\n" +
            " </body>\n" +
            "</html>";

    String editForm = "<html>\n" +
            " <head>\n" +
            " </head>\n" +
            " <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\">\n" +
            " <body> \n" +
            " <form action=\"/editdone\" method=\"get\" >\n" +
            "   <input type=\"text\" name=\"id\" size=\"40\" value=\" %d \"readonly>\n" +
            "  <p>Имя:<br>\n" +
            "   <input type=\"text\" name=\"name\" size=\"40\" value=\"%s\">\n" +
            "  </p>\n" +
            "  <p>Фамилия:<br>\n" +
            "   <input type=\"text\" name=\"surname\" size=\"40\" value=\"%s\">\n" +
            "  </p>\n" +
            "  <p>Возраст:<br>\n" +
            "   <input type=\"number\" name=\"age\" size=\"2\" value=\"%s\">\n" +
            "  </p>\n" +
            "  <p>Оценка:<br>\n" +
            "   <input type=\"number\" name=\"mark\" size=\"2\" value=\"%s\">\n" +
            "  </p>\n" +
            "  <p>Курс:<br>\n" +
            "   <input type=\"number\" name=\"course\" size=\"1\" value=\"%s\">\n" +
            "  </p>\n" +
            "   <p><input type=\"submit\" name=\"button\" value=\" Обновить \"></p>\n" +
            "  </form>\n" +
            " </body>\n" +
            "</html>";
    String delForm = "<html>\n" +
            " <head>\n" +
            " </head>\n" +
            " <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\">\n" +
            " <body> \n" +
            " <form action=\"/editdone\" method=\"get\" >\n" +
            "   <input type=\"text\" name=\"id\" size=\"40\" value=\" %d \"readonly>\n" +
            "  <p>Имя:<br>\n" +
            "   <input type=\"text\" name=\"name\" size=\"40\" value=\"%s\">\n" +
            "  </p>\n" +
            "  <p>Фамилия:<br>\n" +
            "   <input type=\"text\" name=\"surname\" size=\"40\" value=\"%s\">\n" +
            "  </p>\n" +
            "  <p>Возраст:<br>\n" +
            "   <input type=\"number\" name=\"age\" size=\"2\" value=\"%s\">\n" +
            "  </p>\n" +
            "  <p>Оценка:<br>\n" +
            "   <input type=\"number\" name=\"mark\" size=\"2\" value=\"%s\">\n" +
            "  </p>\n" +
            "  <p>Курс:<br>\n" +
            "   <input type=\"number\" name=\"course\" size=\"1\" value=\"%s\">\n" +
            "  </p>\n" +
            "   <p><input type=\"submit\" name=\"button\" value=\" Удалить \"></p>\n" +
            "  </form>\n" +
            " </body>\n" +
            "</html>";
}


