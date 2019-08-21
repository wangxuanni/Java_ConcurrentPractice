package practice.pc;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @description:用Wait、Notify实现的生产者消费者模型
 * @author: wangxuanni
 * @create: 2019-07-28 16:28
 **/

public class WaitNotifyVersion {
    public static void main(String[] args) {
        Produce p1 = new Produce();
        Produce p2 = new Produce();
        Consummer c1 = new Consummer();
        Consummer c2 = new Consummer();
        Consummer c3 = new Consummer();
        Consummer c4 = new Consummer();
        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();


    }

    private static final ConcurrentLinkedQueue<String> list = new ConcurrentLinkedQueue<>();
    private static final Integer FULL = 10;
    private static Object synObj = new Object();

    static class Produce extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (synObj) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.offer(this.getName());
                    System.out.println(this.getName() + "生产了一个" + "目前库存" + list.size());
                    synObj.notifyAll();
                }
            }
        }
    }

    static class Consummer extends Thread {
        @Override
        public void run() {

            while (true) {
                synchronized (synObj) {
                    if (list.isEmpty()) {
                        try {
                            synObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.poll();

                    System.out.println(this.getName() + "消费了一个" + "目前库存" + list.size());
                }
            }
        }
    }
}
