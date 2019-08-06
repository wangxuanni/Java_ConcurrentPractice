package practice.juc.future.JDK;


import java.util.concurrent.Callable;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-04 17:14
 **/

public class RealData implements Callable<String> {
    protected String data;

    public RealData(String data) {
        this.data = data;
    }

    @Override
    public String call() throws Exception {
        // ����sleep��������ʾ����ҵ���Ƿǳ�������
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }

}
