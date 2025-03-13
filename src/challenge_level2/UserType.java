package challenge_level2;

public enum UserType {

    SOLDIER("군인"),
    STUDENT("학생"),
    NORMAL("일반");

    private final String symbol;

    UserType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String toSymbol() {
        return this.getSymbol();
    }

    public int discountRate() {
        int result = 0;
        switch (this) {
            case NORMAL -> { // 일반: 할인율 없음
                return result;
            }
            case STUDENT -> result = 10; // 학생: 10%
            case SOLDIER -> result = 20; // 군인: 20%
        }
        return result;
    }
}
