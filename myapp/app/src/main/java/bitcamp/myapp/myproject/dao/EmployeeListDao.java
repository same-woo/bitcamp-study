package bitcamp.myapp.myproject.dao;

import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.JsonDataHelper;

public class EmployeeListDao implements EmployeeDao {

  String filename;
  ArrayList<TrainingCenterEmployee> list = new ArrayList<>();

  public EmployeeListDao(String filename) {
    this.filename = filename;
    JsonDataHelper.loadJson(filename, list, TrainingCenterEmployee.class);
  }

  @Override
  public void insert(TrainingCenterEmployee employee) {
    // 데이터 입력할 때 해당 데이터의 식별 번호는 DAO에서 관리한다.
    employee.setId(TrainingCenterEmployee.centerId++);
    this.list.add(employee);

    // 데이터를 등록할 때 마다 즉시 파일에 저장한다.
    JsonDataHelper.saveJson(filename, list);
  }

  @Override
  public List<TrainingCenterEmployee> list() {
    return this.list;
  }

  @Override
  public TrainingCenterEmployee findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      TrainingCenterEmployee m = this.list.get(i);
      if (m.getId() == no) {
        return m;
      }
    }
    return null;
  }

  @Override
  public int update(TrainingCenterEmployee employee) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getId() == employee.getId()) {
        list.set(i, employee);
        JsonDataHelper.saveJson(filename, list);
        return 1;
      }
    }
    return 0;
  }

  @Override
  public int delete(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getId() == no) {
        list.remove(i);
        JsonDataHelper.saveJson(filename, list);
        return 1;
      }
    }
    return 0;
  }



}
