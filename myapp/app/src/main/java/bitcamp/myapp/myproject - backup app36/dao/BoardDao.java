package bitcamp.myapp.myproject.dao;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;

public interface BoardDao {
  void insert(TrainingCenterBoard board);

  List<TrainingCenterBoard> list();

  TrainingCenterBoard findBy(int no);

  int update(TrainingCenterBoard board);

  int delete(int no);
}
