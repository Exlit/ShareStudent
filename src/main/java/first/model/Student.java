package first.model;


public class Student {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int mark;
    private int course;

    public Student(String name, String surname, int age, int mark, int course) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.mark = mark;
        this.course = course;
    }

    public Student(int id, String name, String surname, int age, int mark, int course) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.mark = mark;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
