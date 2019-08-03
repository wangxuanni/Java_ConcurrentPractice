package practice.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:ģ�³������̼�ʹ�ö���̸߳�������20���˻�����20��ÿ���˻�ֻ����һ��
 * ʹ��AtomicReference��¼�������Ͷ�Σ���Ϊ���ֱ治����û�б���ֵ����
 * �����ֵ���ֱ������˻��ǵ���20���ͻ��ظ����͡������ABA���⡣
 * ABA�������ʹ��AtomicStampedReference�����
 * @author: wangxuanni
 * @create: 2019-08-03 16:17
 **/

public class AtomicReferenceTest {

    public static void main(String[] args) {
        //һ���ᱻ���͵����

        final AtomicReference<Integer> money = new AtomicReference<>();
        money.set(19);
        for (int i = 0; i < 1; i++) {
            //�������������߳�
            new Thread() {
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.get();
                            if (m < 20) {
                                if (money.compareAndSet(m, m + 20)) {
                                    System.out.println("��ֵ20" + "���" + money.get());
                                    break;
                                }
                            } else {
                                //System.out.println("������20�����ֵ");
                                break;
                            }
                        }
                    }
                }
            }.start();

        }
        new Thread() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    //��������߳�
                    while (true) {
                        Integer m = money.get();
                        if (m > 20) {

                            if (money.compareAndSet(m, m - 10)) {
                                System.out.println("������20Ԫ" + "���" + money.get());
                            }
                        } else {
                            System.out.println("��������ʧ��");

                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }.start();
    }
}
