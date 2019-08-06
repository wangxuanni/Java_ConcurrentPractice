package practice.juc.future.myFuture;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-04 17:14
 **/

public class Client {
public Data request(final String queryStr){
        FutureData futureData=new FutureData();

        new Thread(() -> {
            RealData realData=new RealData(queryStr);
            futureData.setData(realData);

        }).start();
        return futureData;
    }

}
