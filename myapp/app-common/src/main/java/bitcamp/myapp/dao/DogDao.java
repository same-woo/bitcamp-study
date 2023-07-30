package bitcamp.myapp.dao;

import java.util.List;
import bitcamp.myapp.vo.MyDog; // Update the import statement to use MyDog instead of User

public interface DogDao {
  void insert(MyDog myDog); // Update parameter and return type from User to MyDog

  List<MyDog> findAll(); // Update return type from List<User> to List<MyDog>

  MyDog findBy(int dog_no); // Update parameter and return type from int/User to int/MyDog

  MyDog findByEmailAndPassword(MyDog myDog); // Update parameter and return type from User to MyDog

  int update(MyDog myDog); // Update parameter and return type from User to MyDog

  int delete(int dog_no); // Update parameter and return type from int/User to int/MyDog
}
