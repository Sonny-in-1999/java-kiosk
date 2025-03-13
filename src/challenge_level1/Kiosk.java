package challenge_level1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Kiosk {

    List<Menu> menuList;

    List<Cart> cartList = new ArrayList<>();

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    private void printCartList() {
        for (Cart cart : cartList) {
            System.out.println(cart.getName() + "  수량: " + cart.getQuantity() + "  가격: " + cart.getPrice());
        }
    }

    private void printTotalCartPrice() {
        int totalPrice = 0;
        for (Cart cart : cartList) {
            totalPrice += cart.calculateTotalPrice();
        }
        System.out.println("총 합계: " + totalPrice + "원");
    }

    public void start() {
        Scanner sc = new Scanner(System.in); // Scanner 인스턴스 생성
        // 리스트 요소 선택값 인덱스
        int index;

        mainLoop:
        while (true) {
            System.out.println("[ MAIN MENU ]");
            System.out.println("음식 카테고리를 선택해주세요.");
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println(i + 1 + ". " + menuList.get(i).getCategory());
            }
            System.out.println("99. 장바구니 초기화");
            System.out.println("0. 종료");
            System.out.print("원하시는 카테고리 번호를 입력해주세요: ");

            // 카테고리 선택
            try {
                index = Integer.parseInt(sc.next().trim());
                sc.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력해주세요.");
                continue;
            }

            // 입력값이 99인 경우 장바구니 초기화
            if (index == 99) {
                while (true) {
                    System.out.print("장바구니를 초기화 하시겠습니까?(y/n): ");
                    char purchaseYn = sc.next().charAt(0);
                    if (purchaseYn == 'y') {
                        cartList.clear();
                        System.out.println("장바구니를 초기화 합니다.");
                        continue mainLoop;
                    } else if (purchaseYn == 'n') {
                        System.out.println("메뉴로 돌아갑니다.");
                        continue mainLoop;
                    } else {
                        System.out.println("y와 n중 하나를 입력해주세요.");
                    }
                }
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

            menuLoop:
            while (true) {
                // 메뉴 출력
                System.out.println("[ " + selectedCategory.toUpperCase() + " MENU ]");
                for (int i = 0; i < selectedMenuItemList.size(); i++) {
                    System.out.println(i + 1 + ". " + selectedMenuItemList.get(i).name() + " - " + selectedMenuItemList.get(i).price() + "원");
                }
                System.out.println("99. 주문하기");
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

                // 입력값이 99인 경우 주문화면으로
                if (index == 99) {
                    System.out.println(" [ 장바구니 목록 ] ");
                    printCartList(); // 장바구니 목록 출력
                    printTotalCartPrice(); // 장바구니 총 합계 금액 출력
                    while (true) {
                        System.out.print("이대로 주문 하시겠습니까?(y/n): ");
                        char purchaseYn = sc.next().charAt(0);
                        if (purchaseYn == 'y') {
                            break menuLoop;
                        } else if (purchaseYn == 'n') {
                            continue menuLoop;
                        } else {
                            System.out.println("y와 n중 하나를 입력해주세요.");
                        }
                    }
                }

                // 입력값이 0인 경우 카테고리 선택 메뉴로 복귀
                if (index == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    continue mainLoop;
                }

                // 입력값 검증
                if (index < 0 || index > selectedMenuItemList.size()) {
                    System.out.println("존재하지 않는 메뉴 번호입니다.");
                    continue;
                }

                // 선택한 메뉴
                MenuItem selectedMenuItem = selectedMenuItemList.get(index - 1);

                // 선택한 메뉴 정보 출력
                selectedMenuItem.display();

                // 선택한 메뉴 장바구니 추가 여부 확인
                while (true) {
                    System.out.print("장바구니에 추가하시겠습니까?(y/n): ");
                    char addCartYn = sc.next().charAt(0);

                    if (addCartYn == 'y') {
                        // 장바구니에 이미 저장된 품목인지 검증
                        Optional<Cart> existInCart = cartList.stream()
                                .filter(cart -> cart.getName().equals(selectedMenuItem.name()))
                                .findFirst();
                        if (existInCart.isPresent()) { // 이미 저장된 품목이면 수량 추가
                            existInCart.get().addQuantity();
                        } else { // 새로운 품목이면 장바구니에 추가
                            Cart cart = new Cart(selectedMenuItem.name(), 1, selectedMenuItem.price());
                            cartList.add(cart);
                        }
                        for (Cart cart : cartList) {
                            System.out.println(cart.getName() + " 수량: " + cart.getQuantity());
                        }
                        break;
                    } else if (addCartYn == 'n') {
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println("y와 n중 하나를 입력해주세요.");
                    }
                }
            }
            System.out.println("                        [ 구매 영수증 ]");
            System.out.println("------------------------------------------------------------");
            String purchaseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초"));
            System.out.println(purchaseTime);
            printCartList(); // 장바구니 목록 출력
            printTotalCartPrice(); // 장바구니 총 합계 금액 출력
            cartList.clear(); // 구매 후 장바구니 초기화

            while (true) {
                System.out.print("새로 주문하시겠습니까?(y/n): ");
                char purchaseYn = sc.next().charAt(0);
                if (purchaseYn == 'y') {
                    System.out.println("------------------------------------------------------------");
                    break;
                } else if (purchaseYn == 'n') {
                    System.out.println("이용해주셔서 감사합니다. 좋은하루 되세요.");
                    return;
                } else {
                    System.out.println("y와 n중 하나를 입력해주세요.");
                }
            }
        }
    }
}
