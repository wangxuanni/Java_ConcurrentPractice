package jvm;
/**
 * @description:本类用于观察gc有没有使用引用计数算法
 * 因为引用计数算法的弊端在于当对象之间的相互循环引用时不会被回收
 * 如果gc使用的是引用计数算法，则下面代码这两个实例不会被回收。
 * 运行VM option：-verbose:gc
 * 观察到在第一行[PSYoungGen: 7176K->792K(35840K)] 7176K->800K(117760K)
 * 被回收了，可见gc没有使用引用计数器，避免了该弊端。
 * @author: wangxuanni
 * @create: 2019-07-13 11:17
 **/
public class ReferenceCountingGC {
    //为了让实例在堆中互相引用
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;
    /**
     * 这个成员属性的唯一意义就是占点内存，以便在能在GC日志中看清楚是否有回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

// 假设在这行发生GC，objA和objB是否能被回收？
        System.gc();
    }

    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }
}
