package bitcamp.myapp;

import java.util.Random;

public class DefaultMembers {

    final static int MAX_SIZE = 50;
    static int userId = 1;
    static int length = 10; // 가져올 기존 회원수 입력

    static int[] no = new int[MAX_SIZE];
    static String[] name = new String[MAX_SIZE];
    static int[] age = new int[MAX_SIZE];
    static String[] locker = new String[MAX_SIZE];
    static char[] gender = new char[MAX_SIZE];
    static int[] remainingDays = new int[MAX_SIZE]; // 회원의 남은 기간 정보 (일 단위)
    static int lockused = 6;

    public static void addDefaultMembers() {
        String[] defaultNames = {"홍길동", "김철수", "이영희", "박영수", "정미경", "최성준", "백김동", "김지영", "오상훈", "최영환"};
        int[] defaultAges = {25, 30, 27, 32, 29, 28, 24, 26, 31, 33};
        String[] defaultLockers = {"Locker 1", "Locker 2", "Locker 3", "Locker 4", "Locker 5", "미사용", "미사용", "미사용", "미사용", "미사용"};
        char[] defaultGenders = {'M', 'M', 'F', 'M', 'F', 'M', 'F', 'F', 'M', 'M'};
        int[] defaultRemainingDays = {121, 60, 196, 84, 168, 186, 119, 194, 174, 90};

        for (int i = 0; i < length; i++) {
            name[i] = defaultNames[i];
            age[i] = defaultAges[i];
            locker[i] = defaultLockers[i];
            gender[i] = defaultGenders[i];
            remainingDays[i] = defaultRemainingDays[i];
            no[i] = userId + i;
        }
    }

    public static void shuffleMembers() {
        Random random = new Random();
        for (int i = length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            swapMembers(i, j);
        }
    }

    private static void swapMembers(int i, int j) {
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
}
