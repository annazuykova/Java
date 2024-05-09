public class Student extends Human {
    String faculty;

    public Student(String familia, String name, String otchestvo, int age, String faculty) {
        super(familia, name, otchestvo, age);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
