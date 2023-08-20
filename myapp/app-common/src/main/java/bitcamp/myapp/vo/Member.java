package bitcamp.myapp.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Member implements Serializable {
  private static final long serialVersionUID = 1L;


  public static final char MALE = 'M';
  public static final char FEMALE = 'F';

  private int no;
  private String name;
  private String email;
  private String password;
  private String tel;
  private char gender;
  private LocalDate createdDate;
  

  
  @Override
  public int hashCode() {
      return Objects.hash(email);
  }
  
  @Override
  public boolean equals(Object obj) {
      if (this == obj)
          return true;
      if (obj == null || getClass() != obj.getClass())
          return false;
      Member other = (Member) obj;
      return Objects.equals(email, other.email);
  }

public int getNo() {
	return no;
}

public void setNo(int no) {
	this.no = no;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public char getGender() {
	return gender;
}

public void setGender(char gender) {
	this.gender = gender;
}

public LocalDate getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
}


 


}
