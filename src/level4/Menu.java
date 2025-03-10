package level4;

import java.util.List;

public class Menu {

    String category;

    List<MenuItem> menuItems;

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getCategory() {
        return category;
    }

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

}
