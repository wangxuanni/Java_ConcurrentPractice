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
         * m��n ʵ���϶��ǵ����� Integer.valueOf(128)�������Զ�װ�����
         * m��n �����´����Ķ��󣬻��ڶ������·����ڴ棬��ַ��ͬ��false
         */
        Integer m = 128;
        Integer n = 128;
        System.out.println(m == n);   //false
        System.out.println(m.equals(n)); //true

        /**
         * kȡ���ǻ��棬h���´����Ķ���false
         */
        Integer k = 127;
        Integer h = new Integer(127);
        System.out.println(k == h);   //false
        System.out.println(k.equals(h));//true

        /**
         * new ������������ڴ棬a��b�����´����Ķ���
         * == �Ƚϵ������õĵ�ַ��false
         */
        Integer a = new Integer(127);
        Integer b = new Integer(127);
        System.out.println(a == b);  //false
        System.out.println(a.equals(b)); //true

        /**
         * Integer.valueOf() �������жϳ����ػ��棬���淶Χ��-128��127��������Χ��newһ������
         * w ʵ��Ҳ�ǵ����� Integer.valueOf(128)
         * w��y �����´����Ķ��� false
         */
        Integer w = 128;
        Integer y = Integer.valueOf(128);
        System.out.println(w == y); // false
        System.out.println(w.equals(y)); //true

        /**
         * Integer��int�Ƚϣ�Integer���Զ������int����ֵ�Ƚϣ�true
         */
        Integer x = 128;
        int z = 128;
        System.out.println(x == z); //true
        System.out.println(x.equals(z)); //true


    }
}
