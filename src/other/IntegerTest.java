package other;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-07-20 17:55
 **/

public class IntegerTest {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b); // true

        Integer a1 = 128;
        Integer b1 = 128;
        System.out.println(a1 == b1); // false

// 采用new的方式，a在堆中，这里打印false
        Integer a2 = new Integer(127);
        Integer b2 = 127;
        System.out.println(a2 == b2);


    }
}
