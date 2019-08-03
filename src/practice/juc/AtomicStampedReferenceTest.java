package practice.juc;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description:ABA�������ʹ��AtomicStampedReference���
 * �ؼ����ڴ���ֵ��ʱ����봫��һ��ʱ���
 * @author: wangxuanni
 * @create: 2019-08-03 16:17
 **/

public class AtomicStampedReferenceTest {

    public static void main(String[] args) {
        //һ���ᱻ���͵����
        final AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19,0);
        //�������������߳�

        for (int i = 0; i < 1; i++) {
            //����Ϊʲôʱ����������߳����ȡ��
            int timeStamp=money.getStamp();
            new Thread() {
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.getReference();
                            if (m < 20) {
                                //����ֵ��ʱ����봫��һ��ʱ���
                                if (money.compareAndSet(m, m + 20,timeStamp,timeStamp+1)) {
                                    System.out.println("��ֵ20" + "���" + money.getReference());
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
                //��������߳�
                for (int i = 0; i < 50; i++) {
                    while (true) {
                        //�������ʱ����������߳��ڻ�ȡ��
                        int timeStamp=money.getStamp();
                        Integer m = money.getReference();
                        if (m > 20) {

                            if (money.compareAndSet(m, m - 10,timeStamp,timeStamp+1)) {
                                System.out.println("������20Ԫ" + "���" + money.getReference());
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
