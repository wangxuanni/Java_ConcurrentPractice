package patterns.singleton;

/**
 * @description:枚举类进化史
 * @author: wangxuanni
 * @create: 2019-10-06 07:30
 **/

public class MyEnum {
    public static MyEnum NumberZero;
    public static MyEnum NumberOne;
    public static MyEnum NumberTwo;
    public static MyEnum NumberThree;

    static {
        NumberZero = new MyEnum(0);
        NumberOne = new MyEnum(1);
        NumberTwo = new MyEnum(2);
        NumberThree = new MyEnum(3);
    }

    private final int value;

    private MyEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
