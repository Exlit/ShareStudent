package first.controllers;

public interface BaseHtmlTemplate {

    String MAIN = " <head>\n" +
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
