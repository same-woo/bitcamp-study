package bitcamp.myapp.handler.Dog;

import java.util.List;

import bitcamp.myapp.dao.DogDao;
import bitcamp.myapp.vo.MyDog;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class DogListListener implements ActionListener {

  DogDao dogDao;

  public DogListListener(DogDao dogDao) {
    this.dogDao = dogDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

    prompt.println("---------------------------------------");
    prompt.println("번호, 품종, 나이, 성별, 체중, 보호여부");
    prompt.println("---------------------------------------");

    List<MyDog> list = dogDao.findAll();
    for (MyDog dog : list) {
      prompt.printf("%d, %s, %d, %c, %.0f, %b\n",
        dog.getDog_no(), dog.getKind(), dog.getAge(),
        dog.getGender(), dog.getWeight(), dog.isCreated());
    }
  }

}
