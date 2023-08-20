package bitcamp.myapp.dao;

import java.util.List;
import bitcamp.myapp.vo.ShelterAnimal;

public interface AnimalDao {
  void insert(ShelterAnimal shelterAnimal);

  List<ShelterAnimal> findAll();

  ShelterAnimal findBy(int shelterAnimalNo);

  ShelterAnimal findByEmailAndPassword(ShelterAnimal shelterAnimal);

  int update(ShelterAnimal shelterAnimal);

  int delete(int shelterAnimalNo);
}
