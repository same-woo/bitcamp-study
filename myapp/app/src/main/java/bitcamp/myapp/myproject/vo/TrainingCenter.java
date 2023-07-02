package bitcamp.myapp.myproject.vo;

import java.io.Serializable;

public class TrainingCenter implements Serializable, CsvObject {
  private static final long serialVersionUID = 1L;

  private static int centerId = 1;

  private int id;
  private String name;
  private int age;
  private String location;
  private int duration;
  private String curriculum;
  private String password;

  public int getDuration() {
    return duration;
  }



  public TrainingCenter() {
    this.id = centerId++;
  }



  public void setDuration(int duration) {
    this.duration = duration;
  }



  public int getAge() {
    return age;
  }



  public void setAge(int age) {
    this.age = age;
  }



  public String getCurriculum() {
    return curriculum;
  }



  public TrainingCenter(int id) {
    this.id = id;
  }

  public static TrainingCenter fromCsv(String csv) {
    String[] values = csv.split(",");

    TrainingCenter center = new TrainingCenter(Integer.parseInt(values[0]));
    center.setName(values[1]);
    center.setAge(Integer.parseInt(values[2]));
    center.setLocation(values[3]);
    center.setDuration(Integer.parseInt(values[4]));
    center.setCurriculum(values[5]);
    center.setPassword(values[6]);

    if (centerId <= center.getId()) {
      centerId = center.getId() + 1;
    }

    return center;
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%d,%s,%s,%d,%s,%s", this.getId(), this.getAge(), this.getName(),
        this.getLocation(), this.getDuration(), this.getCurriculum(), this.getPassword());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    TrainingCenter center = (TrainingCenter) obj;
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



  public void setCurriculum(String curriculum) {
    this.curriculum = curriculum;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
