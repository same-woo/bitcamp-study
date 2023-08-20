package bitcamp.myapp.vo;

import java.io.Serializable;

public class Shelter implements Serializable {
  private static final long serialVersionUID = 1L;

  private int shelterNo;
  private String shelterName;
  private String email;
  private String tel;
  private String primaryAddress;
  private String postalCode;
  private String detailAddress;

  public int getShelterNo() {
    return shelterNo;
  }

  public void setShelterNo(int shelterNo) {
    this.shelterNo = shelterNo;
  }

  public String getShelterName() {
    return shelterName;
  }

  public void setShelterName(String shelterName) {
    this.shelterName = shelterName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getPrimaryAddress() {
    return primaryAddress;
  }

  public void setPrimaryAddress(String primaryAddress) {
    this.primaryAddress = primaryAddress;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getDetailAddress() {
    return detailAddress;
  }

  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }
}
