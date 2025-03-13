package challenge_level2;

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

    /*
    유저타입을 매개변수로 받아 할인율이 적용된 총 합계 금액 출력
     */
    public int calculateTotalPrice(UserType userType) {
        int result = 0;
        switch (userType) {
            case NORMAL ->  result = quantity * price; // 일반: 할인율 없음
            case STUDENT ->  result = (int) (quantity * price * 0.9); // 학생: 10% 할인
            case SOLDIER ->  result = (int) (quantity * price * 0.8);// 군인: 20% 할인
        }
        return result;
    }
}
