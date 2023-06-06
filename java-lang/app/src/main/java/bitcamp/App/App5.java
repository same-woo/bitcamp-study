package bitcamp.myapp;

import java.util.Random;
import bitcamp.myapp.MemberManager;

public class DefaultMembers {

  static void addDefaultMembers() {
    String[] defaultNames = { "홍길동", "김철수", "이영희", "박영수", "정미경", "최성준", "백김동", "김지영", "오상훈", "최영환" };
    int[] defaultAges = { 25, 30, 27, 32, 29, 28, 24, 26, 31, 33 };
    String[] defaultLockers = { "Locker 1", "Locker 2", "Locker 3", "Locker 4", "Locker 5", "미사용", "미사용", "미사용", "미사용",
        "미사용" };
    char[] defaultGenders = { 'M', 'M', 'F', 'M', 'F', 'M', 'F', 'F', 'M', 'M' };
    int[] defaultRemainingDays = { 121, 60, 196, 84, 168, 186, 119, 194, 174, 90 };

    for (int i = 0; i < MemberManager.length; i++) {
      MemberManager.name[i] = defaultNames[i];
      MemberManager.age[i] = defaultAges[i];
      MemberManager.locker[i] = defaultLockers[i];
      MemberManager.gender[i] = defaultGenders[i];
      MemberManager.remainingDays[i] = defaultRemainingDays[i];
      MemberManager.no[i] = MemberManager.userId + i;
    }
  }

  static void shuffleMembers(int[] remainingDays) {
    Random random = new Random();

    for (int i = MemberManager.length - 1; i >= 0; i--) {
      int j = random.nextInt(i + 1);
      swapMembers(MemberManager.name, MemberManager.age, MemberManager.locker,
          MemberManager.gender, MemberManager.no, MemberManager.remainingDays, i, j);
    }
  }

  static void swapMembers(String[] name, int[] age, String[] locker,
      char[] gender, int[] no, int[] remainingDays, int i, int j) {
    String tempName = name[i];
    int tempAge = age[i];
    String tempLocker = locker[i];
    char tempGender = gender[i];
    int tempRemainingDays = remainingDays[i];

    name[i] = name[j];
    age[i] = age[j];
    locker[i] = locker[j];
    gender[i] = gender[j];
    remainingDays[i] = remainingDays[j];

    name[j] = tempName;
    age[j] = tempAge;
    locker[j] = tempLocker;
    gender[j] = tempGender;
    remainingDays[j] = tempRemainingDays;
  }

  static void printMembers(int[] remainingDays) {
    for (int i = 0; i < MemberManager.length; i++) {
      System.out.printf("%d, %s, %d, %c, %s, %d\n", MemberManager.no[i], MemberManager.name[i],
          MemberManager.age[i], MemberManager.gender[i], MemberManager.locker[i], remainingDays[i]);
    }
  }
}
