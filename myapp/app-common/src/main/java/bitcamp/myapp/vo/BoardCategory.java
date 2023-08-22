//package bitcamp.myapp.vo;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//public class BoardCategory implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    private int categoryNo;
//    private String name;
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(categoryNo);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null || getClass() != obj.getClass())
//            return false;
//        BoardCategory other = (BoardCategory) obj;
//        return categoryNo == other.categoryNo;
//    }
//
//    public int getCategoryNo() {
//        return categoryNo;
//    }
//
//    public void setCategoryNo(int categoryNo) {
//        this.categoryNo = categoryNo;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
