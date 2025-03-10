package basic_level3;

public record MenuItem(String name, int price, String description) {

    public void display() {
        System.out.println(name);
        System.out.println(description);
        System.out.println("가격 - " + price);
    }
}
