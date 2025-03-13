package challenge_level1;

public class Cart {

    private final String name;
    private int quantity;
    private final int price;

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void addQuantity() {
        quantity += 1;
    }

    public Cart(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int calculateTotalPrice() {
        return quantity * price;
    }
}
