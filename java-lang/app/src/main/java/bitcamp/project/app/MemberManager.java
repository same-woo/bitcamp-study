package bitcamp.project;
import java.util.Scanner;
import java.util.Arrays;
import bitcamp.project.DefaultMembers;
import bitcamp.project.Member;

public class MemberManager {

    static int userId = 1;
    static int lockused = 6;

    public static void printTitle() {
        System.out.println("헬스장에 등록할 회원정보를 입력합니다.");
        System.out.println("----------------------------------");
    }

    public static void inputMember(Scanner scanner, Member m) {
        Member m = new Member();
        System.out.print("이름? ");
        m.name = scanner.next();

        System.out.print("나이? ");
        m.age = scanner.nextInt();
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
                    m.locker = "Locker " + lockused++;
                    break loop;
                case "2":
                    m.locker = "미사용";
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
                    m.gender = 'M';
                    break loop;
                case "2":
                    m.gender = 'W';
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
                    m.remainingDays = 90;
                    break loop;
                case "2":
                    m.remainingDays = 180;
                    break loop;
                case "3":
                    m.remainingDays = 360;
                    break loop;
                default:
                    System.out.println("무효한 번호입니다.");
            }
        }

        m.no = userId + 10; // 기존 회원수가 30명이므로..
        userId++;
    }


    public static void printMembers(Member[] members) {
      for (int i = 0; i < DefaultMembers.length; i++) {
          Member m = members[i];
          System.out.printf("%d, %s, %d, %c, %s, %d\n", m.no, m.name, m.age,
                  m.gender, m.locker, m.remainingDays);
      }
  }
  
  
  
  
    }
