package practice.pc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description:��BlockingQueueVersionʵ�ֵ�������������ģ��
 * @author: wangxuanni
 * @create: 2019-07-31 23:01
 **/

public class BlockingQueueVersion {
        private static Integer count = 0;
        //����һ����������
        final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);
        public static void main(String[] args) {
            BlockingQueueVersion test = new BlockingQueueVersion();
            new Thread(test.new Producer()).start();
            new Thread(test.new Producer()).start();
            new Thread(test.new Consumer()).start();
            new Thread(test.new Consumer()).start();
            new Thread(test.new Consumer()).start();

        }
        class Producer implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        blockingQueue.put(1);
                        count++;
                        System.out.println(Thread.currentThread().getName()
                                + "������������Ŀǰ�������Ϊ��" + blockingQueue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        class Consumer implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        blockingQueue.take();
                        count--;
                        System.out.println(Thread.currentThread().getName()
                                + "���������ѣ�Ŀǰ�������Ϊ��" + blockingQueue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

}
