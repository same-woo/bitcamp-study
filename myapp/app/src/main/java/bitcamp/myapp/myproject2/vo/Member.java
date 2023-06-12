package bitcamp.myapp.myproject2.vo;

public class Member {
  private static int userId = 1;
  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  private int no;
  private String name;
  private int age;
  private int remainingDays;
  private char gender;
  private boolean locker;

  public Member(String name, int age, int remainingDays, char gender, boolean locker) {
    this.no = userId++;
    this.name = name;
    this.age = age;
    this.remainingDays = remainingDays;
    this.gender = gender;
    this.locker = locker;
  }

  public Member() {
    this.no = userId++;
  }

  public int getNo() {
    return this.no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if (age <= 5 | age > 100) {
      System.out.println("5살 이상, 100세 이하만 입장 가능합니다.");
      return;
    }
    this.age = age;
  }

  public int getRemainingDays() {
    return remainingDays;
  }

  public void setRemainingDays(int remainingDays) {
    this.remainingDays = remainingDays;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public boolean isLocker() {
    return locker;
  }

  public void setLocker(boolean locker) {
    this.locker = locker;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }



}
