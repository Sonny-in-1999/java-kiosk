package necessary_level3;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MenuItem> menuItemList = List.of(
                new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5400, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거")
        );

        Kiosk kiosk = new Kiosk(menuItemList);
        kiosk.start();
    }
}