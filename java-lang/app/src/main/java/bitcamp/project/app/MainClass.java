package bitcamp.project;
import java.util.Scanner;
import java.util.Arrays;
import bitcamp.project.DefaultMembers;
import bitcamp.project.MemberManager;
import bitcamp.project.Member;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Add default members
        DefaultMembers.addDefaultMembers();

        while (true) {
            // 회원 조회 또는 회원 추가 선택
            System.out.println("---------------------------------------");
            System.out.println("1. 회원 조회");
            System.out.println("2. 회원 추가");
            System.out.println("3. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // 남은 기간에 따른 회원 목록 출력
                System.out.println("---------------------------------------");
                System.out.println("싸다 피트니스 남은 기간 및 회원 목록");
                System.out.println("---------------------------------------");

                // 1. 전체 회원의 남은 기간 출력
                MemberManager.printMembers(DefaultMembers.members);

            } else if (choice == 2) {
                // 회원 등록 및 정보 입력
                MemberManager.printTitle();
                for (int i = DefaultMembers.length; i < DefaultMembers.MAX_SIZE; i++) {
                    MemberManager.inputMember(scanner, DefaultMembers.members[i]);
                }

            } else if (choice == 3) {
                // 종료
                System.out.println("프로그램을 종료합니다.");
                break;

            } else {
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }

        scanner.close();
    }
}
