package basic_level3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        // 키오스크 동작 로직 필요
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 메뉴 출력
            System.out.println("[ SPARTAN BURGER MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println(i + 1 + ". " + menuItems.get(i).name() + " - " + menuItems.get(i).price() + "원");
            }
            System.out.println("0. 종료");
            System.out.print("원하시는 메뉴 번호를 입력해주세요: ");

            // 메뉴 선택
            int index;
            try {
                index = Integer.parseInt(sc.next().trim());
                sc.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력해주세요.");
                continue;
            }

            // 입력값이 0인 경우 프로그램 종료
            if (index == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            // 입력값 검증
            if (index < 0 || index > menuItems.size()) {
                System.out.println("존재하지 않는 메뉴 번호입니다.");
                continue;
            }

            // 선택한 메뉴
            MenuItem selectedMenuItem = menuItems.get(index - 1);
            selectedMenuItem.display(); // 선택한 메뉴 정보 출력

            // 구매 여부 확인
            while (true) {
                System.out.println("구매하시겠습니까?(y/n): ");
                char purchaseYn = sc.next().charAt(0);

                if (purchaseYn == 'y') {
                    System.out.println(selectedMenuItem.name() + "를 구매합니다.");
                    System.out.println("SPARTAN BURGER를 이용해주셔서 감사합니다.");
                    return;
                } else if (purchaseYn == 'n') {
                    System.out.println("메뉴 선택화면으로 돌아갑니다.");
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("y와 n중 하나를 입력해주세요.");
                }
            }
        }
    }
}
