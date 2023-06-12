package bitcamp.project;
import bitcamp.project.Member;

public class DefaultMembers {

    final static int MAX_SIZE = 50;
    static int userId = 1;
    static int length = 10; // 가져올 기존 회원수 입력

    static Member[] members = new Member[MAX_SIZE];
    static int lockused = 6;

    public static void addDefaultMembers() {
      String[] defaultNames = {"홍길동", "김철수", "이영희", "박영수", "정미경", "최성준", "백김동", "김지영", "오상훈", "최영환"};
      int[] defaultAges = {25, 30, 27, 32, 29, 28, 24, 26, 31, 33};
      String[] defaultLockers = {"Locker 1", "Locker 2", "Locker 3", "Locker 4", "Locker 5", "미사용", "미사용", "미사용", "미사용", "미사용"};
      char[] defaultGenders = {'M', 'M', 'F', 'M', 'F', 'M', 'F', 'F', 'M', 'M'};
      int[] defaultRemainingDays = {121, 60, 196, 84, 168, 186, 119, 194, 174, 90};
  
      for (int i = 0; i < length; i++) {
          Member member = new Member();
          member.name = defaultNames[i];
          member.age = defaultAges[i];
          member.locker = defaultLockers[i];
          member.gender = defaultGenders[i];
          member.remainingDays = defaultRemainingDays[i];
          member.no = userId + i;
          members[i] = member;
      }
  }
  
}
