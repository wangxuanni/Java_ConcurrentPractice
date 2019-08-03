package practice.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:模仿场景：商家使用多个线程给余额低于20的账户赠送20，每个账户只赠送一次
 * 使用AtomicReference记录余额，会赠送多次，因为它分辨不出有没有被充值过。
 * 如果充值过又被消费了还是低于20，就会重复赠送。这就是ABA问题。
 * ABA问题可以使用AtomicStampedReference解决。
 * @author: wangxuanni
 * @create: 2019-08-03 16:17
 **/

public class AtomicReferenceTest {

    public static void main(String[] args) {
        //一个会被赠送的余额

        final AtomicReference<Integer> money = new AtomicReference<>();
        money.set(19);
        for (int i = 0; i < 1; i++) {
            //启动两个赠送线程
            new Thread() {
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.get();
                            if (m < 20) {
                                if (money.compareAndSet(m, m + 20)) {
                                    System.out.println("充值20" + "余额" + money.get());
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
                for (int i = 0; i < 50; i++) {
                    //多个消费线程
                    while (true) {
                        Integer m = money.get();
                        if (m > 20) {

                            if (money.compareAndSet(m, m - 10)) {
                                System.out.println("消费了20元" + "余额" + money.get());
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
