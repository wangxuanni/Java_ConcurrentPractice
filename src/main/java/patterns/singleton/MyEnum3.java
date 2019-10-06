package patterns.singleton;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-06 07:33
 **/

public enum MyEnum3 {
    NumberZero,
    NumberOne,
    NumberTwo,
    NumberThree;

    public int lgetValue() {
        return ordinal();
    }

}
