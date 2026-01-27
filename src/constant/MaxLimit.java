package constant;

public enum MaxLimit {
    ID(100),
    SCORE(10),
    AGE(100),
    LESSON(9999),
    PRICE(99999),
    Length(22);

    private final int value;

    MaxLimit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
