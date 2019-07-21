package other;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-07-20 17:55
 **/

public class IntegerTest {
    public static void main(String[] args) {
        Integer i = 127;
        Integer j = 127;
        System.out.println(i == j);    // true
        System.out.println(i.equals(j)); // true

        /**
         * m、n 实际上都是调用了 Integer.valueOf(128)，进行自动装箱操作
         * m、n 都是新创建的对象，会在堆中重新分配内存，地址不同，false
         */
        Integer m = 128;
        Integer n = 128;
        System.out.println(m == n);   //false
        System.out.println(m.equals(n)); //true

        /**
         * k取的是缓存，h是新创建的对象，false
         */
        Integer k = 127;
        Integer h = new Integer(127);
        System.out.println(k == h);   //false
        System.out.println(k.equals(h));//true

        /**
         * new 操作符会分配内存，a、b都是新创建的对象
         * == 比较的是引用的地址，false
         */
        Integer a = new Integer(127);
        Integer b = new Integer(127);
        System.out.println(a == b);  //false
        System.out.println(a.equals(b)); //true

        /**
         * Integer.valueOf() 会优先判断常量池缓存，缓存范围是-128到127，超过范围会new一个对象，
         * w 实际也是调用了 Integer.valueOf(128)
         * w、y 都是新创建的对象 false
         */
        Integer w = 128;
        Integer y = Integer.valueOf(128);
        System.out.println(w == y); // false
        System.out.println(w.equals(y)); //true

        /**
         * Integer和int比较，Integer会自动拆箱成int，数值比较，true
         */
        Integer x = 128;
        int z = 128;
        System.out.println(x == z); //true
        System.out.println(x.equals(z)); //true


    }
}
