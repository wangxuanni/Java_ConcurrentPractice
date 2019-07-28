package practice.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @description:CountDownLatch�ȴ��������
 * @author: wangxuanni
 * @create: 2019-07-28 15:50
 **/

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count=new CountDownLatch(2);
        Thread task1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                    System.out.println("t1 finish");
                    count.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread task2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                    System.out.println("t2 finish");
                    count.countDown();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        task1.start();
        task2.start();
        //���԰�����һ��ע�͵��ᷢ��ʲô
        count.await();
        System.out.println("t1 and ti finish");


    }

}
