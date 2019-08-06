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
                    Executors.newFixedThreadPool(1); // ʹ���̳߳�
            // ִ��FutureTask���൱�������е�client.request("name")��������
        System.out.println("���ú���");

        executor.submit(futureTask);
            // ���������һ��sleep���������ҵ���߼��Ĵ���
            // �ڴ�����Щҵ���߼������У�RealDataҲ���ڴ������Ӷ���������õȴ�ʱ��
        System.out.println("��һЩ��������");
            Thread.sleep(2000);
            // ʹ����ʵ����
            // ���call()û��ִ�������Ȼ��ȴ�
            System.out.println("����=" + futureTask.get());
        }

}
