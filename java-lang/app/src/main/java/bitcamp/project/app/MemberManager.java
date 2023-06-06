package bitcamp.myapp;

import java.util.Scanner;

public class MemberManager {

    static int userId = 1;
    static int length = DefaultMembers.length;

    public static void printTitle() {
        System.out.println("헬스장에 등록할 회원정보를 입력합니다.");
        System.out.println("----------------------------------");
    }

    public static void inputMember(Scanner scanner) {
        if (length >= DefaultMembers.MAX_SIZE) {
            System.out.println("더 이상 회원을 추가할 수 없습니다.");
            return;
        }
        System.out.print("이름? ");
        DefaultMembers.name[length] = scanner.next();

        System.out.print("나이? ");
        DefaultMembers.age[length] = scanner.nextInt();
        scanner.nextLine();

        loop: while (true) {
            System.out.println("락커 사용유무: ");
            System.out.println("  1. 사용");
            System.out.println("  2. 미사용");
            System.out.print("> ");
            String lockerUse = scanner.next();
            scanner.nextLine();

            switch (lockerUse) {
                case "1":
                    DefaultMembers.locker[length] = "Locker " + DefaultMembers.lockused++;
                    break loop;
                case "2":
                    DefaultMembers.locker[length] = "미사용";
                    break loop;
                default:
                    System.out.println("무효한 번호입니다.");
            }
        }

        loop: while (true) {
            System.out.println("성별: ");
            System.out.println("  1. 남자");
            System.out.println("  2. 여자");
            System.out.print("> ");
            String menuNo = scanner.next();
            scanner.nextLine();

            switch (menuNo) {
                case "1":
                    DefaultMembers.gender[length] = 'M';
                    break loop;
                case "2":
                    DefaultMembers.gender[length] = 'W';
                    break loop;
                default:
                    System.out.println("무효한 번호입니다.");
            }
        }

        loop: while (true) {
            System.out.println("회원권 등록일수 ? : ");
            System.out.println("  1. 3개월");
            System.out.println("  2. 6개월");
            System.out.println("  3. 12개월");
            System.out.print("> ");
            String menuNo = scanner.next();
            scanner.nextLine();

            switch (menuNo) {
                case "1":
                    DefaultMembers.remainingDays[length] = 90;
                    break loop;
                case "2":
                    DefaultMembers.remainingDays[length] = 180;
                    break loop;
                case "3":
                    DefaultMembers.remainingDays[length] = 360;
                    break loop;
                default:
                    System.out.println("무효한 번호입니다.");
            }
        }

        DefaultMembers.no[length] = userId + 10; // 기존 회원수가 30명이므로..
        length++;
    }

    public static boolean promptContinue(Scanner scanner) {
        while (true) {
            System.out.print("계속 하시겠습니까?(Y/n)\n");
            System.out.print("> ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y") || choice.equals("")) {
                inputMember(scanner);
                return true;
            } else if (choice.equalsIgnoreCase("N")) {
                System.out.println("실행을 종료합니다.");
                return false;
            } else {
                System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public static void printMembers() {
        for (int i = 0; i < length; i++) {
            System.out.printf("%d, %s, %d, %c, %s, %d\n", DefaultMembers.no[i], DefaultMembers.name[i], DefaultMembers.age[i],
                    DefaultMembers.gender[i], DefaultMembers.locker[i], DefaultMembers.remainingDays[i]);
        }
    }
}
