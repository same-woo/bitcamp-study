package bitcamp.myapp.myproject.vo;

import java.io.Serializable;

public class TrainingCenterEmployee implements Serializable, CsvObject, AutoIncrement {
  private static final long serialVersionUID = 1L;

  public static int centerId = 1;

  private int id;
  private String name;
  private int age;
  private String location;
  private String rank;
  private String department;
  private String password;



  public static int getCenterId() {
    return centerId;
  }

  public static void setCenterId(int centerId) {
    TrainingCenterEmployee.centerId = centerId;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public TrainingCenterEmployee(int no) {
    this.id = id;
  }

  public TrainingCenterEmployee() {}

  public static TrainingCenterEmployee fromCsv(String csv) {
    String[] values = csv.split(",");

    TrainingCenterEmployee center = new TrainingCenterEmployee(Integer.parseInt(values[0]));
    center.setName(values[1]);
    center.setAge(Integer.parseInt(values[2]));
    center.setLocation(values[3]);
    center.setRank(values[4]);
    center.setDepartment(values[5]);
    center.setPassword(values[6]);

    if (centerId <= center.getId()) {
      centerId = center.getId() + 1;
    }

    return center;
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%s,%s", this.getId(), this.getName(), this.getLocation(),
        this.getRank(), this.getDepartment(), this.getPassword());
  }

  @Override
  public void updateKey() {
    if (TrainingCenterEmployee.centerId <= this.id) {
      TrainingCenterEmployee.centerId = this.id + 1;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    TrainingCenterEmployee center = (TrainingCenterEmployee) obj;
    if (this.getId() != center.getId()) {
      return false;
    }
    return true;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
