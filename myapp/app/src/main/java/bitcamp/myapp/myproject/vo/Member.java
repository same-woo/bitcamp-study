package bitcamp.myapp.myproject.vo;

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
