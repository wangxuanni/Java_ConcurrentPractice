package practice.pc;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:��ReentrantLockʵ�ֵ�������������ģ��
 * @author: wangxuanni
 * @create: 2019-07-28 16:28
 **/

public class ReentrantLockVersion {
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


    }

    private static final LinkedList<String> list = new LinkedList<>();
    private static ReentrantLock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();

    static class Produce extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    Thread.sleep(1000);
                    list.offer(this.getName());
                    System.out.println(this.getName() + "������һ��" + "Ŀǰ���������" + list.size());
                    notEmpty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }


            }
        }
    }

    static class Consummer extends Thread {
        @Override
        public void run() {

            while (true) {
                lock.lock();
                if (list.isEmpty()) {
                    try {
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(300);
                    list.poll();
                    System.out.println(this.getName() + "������һ��" + "Ŀǰ���������" + list.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        }
    }
}
