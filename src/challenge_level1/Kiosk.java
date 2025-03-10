package challenge_level1;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    List<Menu> menuList;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[ MAIN MENU ]");
            System.out.println("음식 카테고리를 선택해주세요.");
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println(i + 1 + ". " + menuList.get(i).getCategory());
            }
            System.out.println("0. 종료");
            System.out.print("원하시는 카테고리 번호를 입력해주세요: ");

            int index;

            // 카테고리 선택
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
            if (index < 0 || index > menuList.size()) {
                System.out.println("존재하지 않는 카테고리 번호입니다.");
                continue;
            }

            // 선택된 카테고리 값
            String selectedCategory = menuList.get(index - 1).getCategory();

            // 카테고리에 맞는 음식 메뉴 목록 필터링
            List<MenuItem> selectedMenuItemList = menuList.stream()
                    .filter(menu -> menu.getCategory().equals(selectedCategory))
                    .map(Menu::getMenuItems)
                    .findAny()
                    .get();

            // 메뉴 출력
            System.out.println("[ " + selectedCategory.toUpperCase() + " MENU ]");
            for (int i = 0; i < selectedMenuItemList.size(); i++) {
                System.out.println(i + 1 + ". " + selectedMenuItemList.get(i).name() + " - " + selectedMenuItemList.get(i).price() + "원");
            }
            System.out.println("0. 뒤로가기");
            System.out.print("원하시는 메뉴 번호를 입력해주세요: ");

            // 메뉴 선택
            try {
                index = Integer.parseInt(sc.next().trim());
                sc.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력해주세요.");
                continue;
            }

            // 입력값이 0인 경우 카테고리 선택 메뉴로 복귀
            if (index == 0) {
                System.out.println("프로그램을 종료합니다.");
                continue;
            }

            // 입력값 검증
            if (index < 0 || index > selectedMenuItemList.size()) {
                System.out.println("존재하지 않는 메뉴 번호입니다.");
                continue;
            }

            // 선택한 메뉴
            MenuItem selectedMenuItem = selectedMenuItemList.get(index - 1);
            selectedMenuItem.display(); // 선택한 메뉴 정보 출력

            // 구매 여부 확인
            while (true) {
                System.out.print("구매하시겠습니까?(y/n): ");
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
