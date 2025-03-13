package challenge_level2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 음식 목록
        List<MenuItem> burgerMenuList = List.of(
                new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5400, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거")
        );
        Menu burgerMenu = new Menu("Burger", burgerMenuList);
        
        List<MenuItem> drinkMenuList = List.of(
                new MenuItem("Coca Cola", 1500, "시원한 코카콜라"),
                new MenuItem("Dr.Pepper", 2000, "뭘 좀 아는 사람들의 음료"),
                new MenuItem("Sprite", 1500, "국룰 스프라이트")
        );
        Menu drinkMenu = new Menu("Drink", drinkMenuList);
        
        List<MenuItem> dessertMenuList = List.of(
                new MenuItem("Vanila Ice Cream", 1500, "부드러운 바닐라 맛 아이스크림"),
                new MenuItem("Chocolate Ice Cream", 1500, "달콤한 초콜릿 맛 아이스크림"),
                new MenuItem("Corn Salad", 1000, "맛있는 콘 샐러드")
        );
        Menu dessertMenu = new Menu("Dessert", dessertMenuList);
        
        List<Menu> menuList = List.of(burgerMenu, drinkMenu, dessertMenu);
        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}