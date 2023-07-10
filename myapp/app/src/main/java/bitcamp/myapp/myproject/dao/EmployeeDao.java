package bitcamp.myapp.myproject.dao;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;


public interface EmployeeDao {
  void insert(TrainingCenterEmployee center);

  List<TrainingCenterEmployee> list();

  TrainingCenterEmployee findBy(int no);

  int update(TrainingCenterEmployee center);

  int delete(int no);
}
