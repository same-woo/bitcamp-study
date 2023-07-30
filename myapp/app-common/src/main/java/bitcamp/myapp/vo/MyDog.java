package bitcamp.myapp.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

// MyDog 클래스에 필요한 필드와 Getter/Setter 메서드 추가
public class MyDog implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final char MALE = 'M';
    public static final char FEMALE = 'F';

    private int dog_no;    
    private String kind;
    private int age;
    private double weight;
    private char gender;
    private String location;
    private double id;
    private boolean isCreated;
    private Date createdDate;

    @Override
    public int hashCode() {
        return Objects.hash(dog_no);
    }
    
    // 필요한 다른 필드들 추가 가능
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyDog other = (MyDog) obj;
        return dog_no == other.dog_no;
    }

    public int getDog_no() {
        return dog_no;
    }

    public void setDog_no(int dog_no) {
        this.dog_no = dog_no;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public void setCreated(boolean isCreated) {
        this.isCreated = isCreated;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
