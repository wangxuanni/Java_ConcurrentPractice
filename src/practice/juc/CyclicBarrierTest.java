package practice.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:CyclicBarrierTestd�Ĺ��췽�������������� ��һ����������CountDownLatch�ļ�����������ڶ�����������������������������
 * @author: wangxuanni
 * @create: 2019-07-28 16:00
 **/

public class CyclicBarrierTest {
    static int taskNum = 4;
    static Thread barrierTask = new Thread(new Runnable() {
        @Override
        public void run() {
            if (taskNum > 0) {
                System.out.println("���һ�������г���Ϣһ��");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("���ȫ������");
            }

        }
    });

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier c = new CyclicBarrier(2, barrierTask);

        Thread task1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("t1�߳��������" + taskNum);
                    taskNum--;
                    c.await();
                    Thread.sleep(2000);

                    System.out.println("t1�߳��������" + taskNum);
                    taskNum--;
                    c.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread task2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("t1�߳��������" + taskNum);
                    taskNum--;
                    c.await();
                    Thread.sleep(2000);

                    System.out.println("t1�߳��������" + taskNum);
                    taskNum--;
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        });


        task1.start();
        task2.start();

    }
}
