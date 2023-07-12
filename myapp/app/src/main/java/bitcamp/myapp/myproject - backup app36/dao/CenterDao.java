package bitcamp.myapp.myproject.dao;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenter;


public interface CenterDao {
  void insert(TrainingCenter center);

  List<TrainingCenter> list();

  TrainingCenter findBy(int no);

  int update(TrainingCenter center);

  int delete(int no);
}
