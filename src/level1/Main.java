package level1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        mainLoop:
        while (true) {
            System.out.println("[ SPARTAN BURGER MENU ]");
            System.out.println("1. ShackBurger - 6900원");
            System.out.println("2. SmokeShack - 8900원");
            System.out.println("3. CheeseBurger - 6900원");
            System.out.println("4. Hamburger - 5400원");
            System.out.println("0. 종료");
            System.out.print("원하시는 메뉴 번호를 입력해주세요: ");
            int index = Integer.parseInt(sc.next().trim());
            sc.nextLine();

            menuLoop:
            while (true) {
                try {
                    switch (index) {
                        case 1 -> {
                            System.out.println("ShackBurger");
                            System.out.println("토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                            System.out.println("가격 - 6900원");
                            System.out.print("구매하시겠습니까?(y/n): ");
                            char purchaseYn = sc.next().charAt(0);
                            switch (purchaseYn) {
                                case 'y' -> {
                                    System.out.println("ShackBurger를 구매합니다.");
                                    System.out.println("SPARTAN BURGER를 이용해주셔서 감사합니다.");
                                    return;
                                }
                                case 'n' -> {
                                    System.out.println("메뉴 선택화면으로 돌아갑니다.");
                                    sc.nextLine();
                                    continue mainLoop;
                                }
                                default -> System.out.println("y와 n 중 하나를 입력해주세요.");

                            }
                        }
                        case 2 -> {
                            System.out.println("SmokeShack");
                            System.out.println("베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                            System.out.println("가격 - 8900원");
                            System.out.print("구매하시겠습니까?(y/n): ");
                            char purchaseYn = sc.next().charAt(0);
                            switch (purchaseYn) {
                                case 'y' -> {
                                    System.out.println("SmokeShack를 구매합니다.");
                                    System.out.println("SPARTAN BURGER를 이용해주셔서 감사합니다.");
                                    return;
                                }
                                case 'n' -> {
                                    System.out.println("메뉴 선택화면으로 돌아갑니다.");
                                    sc.nextLine();
                                    continue mainLoop;
                                }
                                default -> System.out.println("y와 n 중 하나를 입력해주세요.");

                            }
                        }
                        case 3 -> {
                            System.out.println("CheeseBurger");
                            System.out.println("포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                            System.out.println("가격 - 6900원");
                            System.out.print("구매하시겠습니까?(y/n): ");
                            char purchaseYn = sc.next().charAt(0);
                            switch (purchaseYn) {
                                case 'y' -> {
                                    System.out.println("CheeseBurger를 구매합니다.");
                                    System.out.println("SPARTAN BURGER를 이용해주셔서 감사합니다.");
                                    return;
                                }
                                case 'n' -> {
                                    System.out.println("메뉴 선택화면으로 돌아갑니다.");
                                    sc.nextLine();
                                    continue mainLoop;
                                }
                                default -> System.out.println("y와 n 중 하나를 입력해주세요.");

                            }
                        }
                        case 4 -> {
                            System.out.println("Hamburger");
                            System.out.println("비프패티를 기반으로 야채가 들어간 기본버거");
                            System.out.println("가격 - 5400원");
                            System.out.print("구매하시겠습니까?(y/n): ");
                            char purchaseYn = sc.next().charAt(0);
                            switch (purchaseYn) {
                                case 'y' -> {
                                    System.out.println("Hamburger를 구매합니다.");
                                    System.out.println("SPARTAN BURGER를 이용해주셔서 감사합니다.");
                                    return;
                                }
                                case 'n' -> {
                                    System.out.println("메뉴 선택화면으로 돌아갑니다.");
                                    sc.nextLine();
                                    continue mainLoop;
                                }
                                default -> System.out.println("y와 n 중 하나를 입력해주세요.");

                            }
                        }
                        case 0 -> {
                            System.out.println("프로그램을 종료합니다.");
                            return;
                        }
                        default -> {
                            System.out.println("존재하지 않는 메뉴 번호입니다.");
                            continue mainLoop;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("올바른 숫자를 입력해주세요.");
                }
            }
        }
    }
}