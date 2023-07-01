package bitcamp.myapp.myproject.vo;

import java.io.Serializable;
import bitcamp.myapp.project.vo.CsvObject;

public class TrainingCenter implements Serializable, CsvObject {
  private static final long serialVersionUID = 1L;

  private static int centerId = 1;

  private int id;
  private String name;
  private String location;
  private String duration;
  private String curriculum;
  private String password;

  public TrainingCenter() {
    this.id = centerId++;
  }

  public TrainingCenter(int id) {
    this.id = id;
  }

  public static TrainingCenter fromCsv(String csv) {
    String[] values = csv.split(",");

    TrainingCenter center = new TrainingCenter(Integer.parseInt(values[0]));
    center.setName(values[1]);
    center.setLocation(values[2]);
    center.setDuration(values[3]);
    center.setCurriculum(values[4]);
    center.setPassword(values[5]);

    if (centerId <= center.getId()) {
      centerId = center.getId() + 1;
    }

    return center;
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%s,%s", this.getId(), this.getName(), this.getLocation(),
        this.getDuration(), this.getCurriculum(), this.getPassword());
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

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getCurriculum() {
    return curriculum;
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
