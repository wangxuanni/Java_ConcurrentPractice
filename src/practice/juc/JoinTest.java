package practice.juc;

/**
 * @description:join�����õ�ǰ�̵߳ȴ�join�߳�ִ�н���
 * @author: wangxuanni
 * @create: 2019-07-28 14:56
 **/

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread task1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                    System.out.println("t1 finish");
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
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        task1.start();
        task2.start();
        //���û��join��t1 and ti finish������t1��t2finish
        task1.join();
        task2.join();
        System.out.println("t1 and ti finish");


    }

}
