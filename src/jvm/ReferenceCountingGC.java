package jvm;
/**
 * @description:�������ڹ۲�gc��û��ʹ�����ü����㷨
 * ��Ϊ���ü����㷨�ı׶����ڵ�����֮����໥ѭ������ʱ���ᱻ����
 * ���gcʹ�õ������ü����㷨�����������������ʵ�����ᱻ���ա�
 * ����VM option��-verbose:gc
 * �۲쵽�ڵ�һ��[PSYoungGen: 7176K->792K(35840K)] 7176K->800K(117760K)
 * �������ˣ��ɼ�gcû��ʹ�����ü������������˸ñ׶ˡ�
 * @author: wangxuanni
 * @create: 2019-07-13 11:17
 **/
public class ReferenceCountingGC {
    //Ϊ����ʵ���ڶ��л�������
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;
    /**
     * �����Ա���Ե�Ψһ�������ռ���ڴ棬�Ա�������GC��־�п�����Ƿ��л��չ�
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

// ���������з���GC��objA��objB�Ƿ��ܱ����գ�
        System.gc();
    }

    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }
}
