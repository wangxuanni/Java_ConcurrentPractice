package practice.juc.future.JDK;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-04 17:14
 **/

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
            FutureTask<String> futureTask =
                    new FutureTask<String>(new RealData("name"));

        ExecutorService executor =
                    Executors.newFixedThreadPool(1); // 使用线程池
            // 执行FutureTask，相当于上例中的client.request("name")发送请求
        System.out.println("调用函数");

        executor.submit(futureTask);
            // 这里可以用一个sleep代替对其他业务逻辑的处理
            // 在处理这些业务逻辑过程中，RealData也正在创建，从而充分了利用等待时间
        System.out.println("做一些其他事情");
            Thread.sleep(2000);
            // 使用真实数据
            // 如果call()没有执行完成依然会等待
            System.out.println("数据=" + futureTask.get());
        }

}
