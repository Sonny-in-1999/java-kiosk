package basic_level2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuItem> menuItemList = List.of(
                new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5400, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거")
        );

        while (true) {
            // 메뉴 출력
            System.out.println("[ SPARTAN BURGER MENU ]");
            for (int i = 0; i < menuItemList.size(); i++) {
                System.out.println(i + 1 + ". " + menuItemList.get(i).name() + " - " + menuItemList.get(i).price() + "원");
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
            if (index < 0 || index > menuItemList.size()) {
                System.out.println("존재하지 않는 메뉴 번호입니다.");
                continue;
            }

            // 선택한 메뉴
            MenuItem selectedMenuItem = menuItemList.get(index - 1);
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