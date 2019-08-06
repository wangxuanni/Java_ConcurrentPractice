package practice.juc.future.myFuture;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-04 17:14
 **/

public class TestMain {
    public static void main(String[] args) {
        Client client=new Client();
        Data data=client.request("3243");
        System.out.println("请求完毕");
        try {
            Thread.sleep(1000);
            System.out.println("做一些其他事情");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("调用数据"+data.getData());

    }
}
