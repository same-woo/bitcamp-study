package bitcamp.myapp;

public class Test0531 {
  public static void main(String[] args) {
    int[] no = new int[5];
    int[] no2 = new int[3];

    no2[2] = 31;

    System.out.println(no[2]); // Output: 0
    System.out.println(no2[2]); // Output: 31
  }
}
