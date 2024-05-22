import java.util.Objects;

enum GENDER{
    MAN,
    WOMAN
}

public class Human {
    private String familia;
    private String name;
    private String otchestvo;
    private int age;
    private GENDER gender;

    public Human(String familia, String name, String otchestvo, int age,GENDER gender) {
        this.familia = familia;
        this.name = name;
        this.otchestvo = otchestvo;
        this.age = age;
        this.gender = gender;
    }

    public String getFamilia() {
        return familia;
    }

    public String getName() {
        return name;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public int getAge() {
        return age;
    }
    public GENDER getGender(){
        return gender;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(GENDER gender){
        this.gender=gender;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(familia, human.familia) && Objects.equals(name, human.name) && Objects.equals(otchestvo, human.otchestvo) && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(familia, name, otchestvo, age, gender);
    }
}
