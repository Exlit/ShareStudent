package first.dto;

import first.model.Student;
import first.repository.StudentRepository;

public class StudEdit {
   public String edit(Integer id) {
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
    public String editDone(String name, String surname, Integer age, Integer mark, Integer course, Integer id, String button) {
        System.out.println( "Данные зашли" );
        Student studentRead = new Student( id, name, surname, age, mark, course );
        System.out.println( "Студент создан" );
        StudentRepository stud = new StudentRepository();
        stud.getConnection();
        System.out.println( "подключились к базе" );
        stud.update( studentRead );
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
