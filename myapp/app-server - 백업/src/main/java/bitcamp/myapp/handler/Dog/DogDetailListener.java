package bitcamp.myapp.handler.Dog;

import java.io.IOException;
import bitcamp.myapp.dao.DogDao;
import bitcamp.myapp.vo.MyDog;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class DogDetailListener implements ActionListener {

  DogDao dogDao;

  public DogDetailListener(DogDao dogDao) {
    this.dogDao = dogDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    int dogNo = prompt.inputInt("번호? ");

    MyDog dog = dogDao.findBy(dogNo);
    if (dog == null) {
      prompt.println("해당 번호의 보호동물이 없습니다!");
      return;
    }

    prompt.printf("번호: %d\n", dog.getDog_no());
    prompt.printf("품종: %s\n", dog.getKind());
    prompt.printf("나이: %d\n", dog.getAge());
    prompt.printf("성별: %c\n", dog.getGender());
    prompt.printf("체중: %.2f\n", dog.getWeight());
    prompt.printf("위치: %s\n", dog.getLocation());
    prompt.printf("ID: %.0f\n", dog.getId());
    prompt.printf("공고일: %s\n", dog.getCreatedDate());
    prompt.printf("보호여부: %s\n", dog.isCreated());

  }
}
