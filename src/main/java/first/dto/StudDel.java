package first.dto;

import first.repository.StudentRepository;

public class StudDel {
   public String del(Integer id) {
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

    public String delDone(Integer id) {
        System.out.println( "Данные зашли" );
        StudentRepository stud = new StudentRepository();
        stud.getConnection();
        System.out.println( "подключились к базе" );
        stud.del( id );
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
        return str;
    }
}
