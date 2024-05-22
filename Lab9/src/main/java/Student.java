public class Student extends Human {
    String faculty;
    String university;
    String speciality;

    public Student(String familia, String name, String otchestvo, int age,GENDER gender, String faculty,String university,String speciality) {
        super(familia, name, otchestvo, age,gender);
        this.faculty = faculty;
        this.university = university;
        this.speciality=speciality;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
