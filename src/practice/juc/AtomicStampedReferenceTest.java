package practice.juc;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description:ABA问题可以使用AtomicStampedReference解决
 * 关键在于传入值的时候必须传入一个时间戳
 * @author: wangxuanni
 * @create: 2019-08-03 16:17
 **/

public class AtomicStampedReferenceTest {

    public static void main(String[] args) {
        //一个会被赠送的余额
        final AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19,0);
        //启动两个赠送线程

        for (int i = 0; i < 1; i++) {
            //想想为什么时间戳必须在线程外获取？
            int timeStamp=money.getStamp();
            new Thread() {
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.getReference();
                            if (m < 20) {
                                //传入值的时候必须传入一个时间戳
                                if (money.compareAndSet(m, m + 20,timeStamp,timeStamp+1)) {
                                    System.out.println("充值20" + "余额" + money.getReference());
                                    break;
                                }
                            } else {
                                //System.out.println("余额大于20无须充值");
                                break;
                            }
                        }
                    }
                }
            }.start();

        }
        new Thread() {
            public void run() {
                //多个消费线程
                for (int i = 0; i < 50; i++) {
                    while (true) {
                        //而这里的时间戳可以在线程内获取？
                        int timeStamp=money.getStamp();
                        Integer m = money.getReference();
                        if (m > 20) {

                            if (money.compareAndSet(m, m - 10,timeStamp,timeStamp+1)) {
                                System.out.println("消费了20元" + "余额" + money.getReference());
                            }
                        } else {
                            System.out.println("余额不足消费失败");
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
