package jvm;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-23 10:58
 **/

public class ShowByteCode {
 /*
      public int s();
    Code:
       0: bipush        100
       2: istore_1
       3: sipush        300
       6: istore_2
       7: iload_1
       8: iload_2
       9: iadd
      10: istore_3
      11: iload_3
      12: ireturn*/

    public int s() {
        int i = 100;
        int j = 300;
        int k = i + j;
        return k;
    }

  /*  public int f(int);
    Code:
       0: iload_1
       1: ifge          6
       4: iconst_m1
       5: ireturn
       6: iload_1
       7: ifne          12
      10: iconst_0
      11: ireturn
      12: iload_1
      13: iconst_1
      14: if_icmpeq     22
      17: iload_1
      18: iconst_2
      19: if_icmpne     24
      22: iload_1
      23: ireturn
      24: aload_0
      25: iload_1
      26: iconst_1
      27: isub
      28: invokevirtual #2                  // Method f:(I)I
      31: aload_0
      32: iload_1
      33: iconst_1
      34: isub
      35: invokevirtual #2                  // Method f:(I)I
      38: iadd
      39: ireturn
*/

    public int f(int i) {

        if (i < 0) {
            return -1;
        } else if (i == 0) {
            return 0;
        } else if (i == 1 || i == 2) {
            return i;
        }
        return f(i - 1) + f(i - 1);

    }

    public static void main(String[] args) {
        System.out.println();
    }
}
