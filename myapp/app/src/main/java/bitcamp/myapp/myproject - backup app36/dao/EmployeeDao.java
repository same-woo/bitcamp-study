package bitcamp.myapp.myproject.dao;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;


public interface EmployeeDao {
  void insert(TrainingCenterEmployee employee);

  List<TrainingCenterEmployee> list();

  TrainingCenterEmployee findBy(int no);

  int update(TrainingCenterEmployee employee);

  int delete(int no);
}
