package bitcamp.myapp.myproject.dao;

import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.JsonDataHelper;

public class CenterListDao implements CenterDao {

  String filename;
  ArrayList<TrainingCenter> list = new ArrayList<>();

  public CenterListDao(String filename) {
    this.filename = filename;
    JsonDataHelper.loadJson(filename, list, TrainingCenter.class);
  }

  @Override
  public void insert(TrainingCenter center) {
    // 데이터 입력할 때 해당 데이터의 식별 번호는 DAO에서 관리한다.
    center.setId(TrainingCenterEmployee.centerId++);
    this.list.add(center);

    // 데이터를 등록할 때 마다 즉시 파일에 저장한다.
    JsonDataHelper.saveJson(filename, list);
  }

  @Override
  public List<TrainingCenter> list() {
    return this.list;
  }

  @Override
  public TrainingCenter findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      TrainingCenter m = this.list.get(i);
      if (m.getId() == no) {
        return m;
      }
    }
    return null;
  }

  @Override
  public int update(TrainingCenter center) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getId() == center.getId()) {
        list.set(i, center);
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
