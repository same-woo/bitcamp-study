package bitcamp.myapp.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ShelterAnimal implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final char MALE = 'M';
    public static final char FEMALE = 'F';
    public static final char PROTECTION_YES = 'Y';
    public static final char PROTECTION_NO = 'N';

    private int shelterNo;
    private int animalKindNo;
    private int shelterAnimalNo;
    private int age;
    private double weight;
    private char gender;
    private double animalid;
    private LocalDate protectionDay;
    private String specifics;
    private char protection;



    @Override
    public int hashCode() {
        return Objects.hash(shelterNo, shelterAnimalNo); // Include shelterNo
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ShelterAnimal other = (ShelterAnimal) obj;
        return shelterNo == other.shelterNo && shelterAnimalNo == other.shelterAnimalNo;
    }

	public int getShelterNo() {
		return shelterNo;
	}

	public void setShelterNo(int shelterNo) {
		this.shelterNo = shelterNo;
	}

	public int getAnimalKindNo() {
		return animalKindNo;
	}

	public void setAnimalKindNo(int animalKindNo) {
		this.animalKindNo = animalKindNo;
	}

	public int getShelterAnimalNo() {
		return shelterAnimalNo;
	}

	public void setShelterAnimalNo(int shelterAnimalNo) {
		this.shelterAnimalNo = shelterAnimalNo;
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

	public double getAnimalid() {
		return animalid;
	}

	public void setAnimalid(double animalid) {
		this.animalid = animalid;
	}

	public LocalDate getProtectionDay() {
		return protectionDay;
	}

	public void setProtectionDay(LocalDate protectionDay) {
		this.protectionDay = protectionDay;
	}

	public String getSpecifics() {
		return specifics;
	}

	public void setSpecifics(String specifics) {
		this.specifics = specifics;
	}

	public char getProtection() {
		return protection;
	}

	public void setProtection(char protection) {
		this.protection = protection;
	}

    
   


}
