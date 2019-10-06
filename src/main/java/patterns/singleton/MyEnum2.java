package patterns.singleton;

public enum MyEnum2 {
    NumberZero(0),
    NumberOne(1),
    NumberTwo(2),
    NumberThree(3);
    private final int value;

    MyEnum2(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}