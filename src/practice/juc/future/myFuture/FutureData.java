package practice.juc.future.myFuture;

/**
 * @description:FutureData聚合了RealData，也就是包含一个RealData实例 get方法会阻塞的去等set方法通知
 * @author: wangxuanni
 * @create: 2019-08-04 17:14
 **/

public class FutureData implements Data {

    RealData realData;
    boolean isReady;

    /**
     * 用syn修饰
     *
     * @return
     */
    public synchronized String getData() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.realData.questStr;

    }

    synchronized void setData(RealData realData) {
        //这里说明realData已经初始化完成
        if (isReady)
            return ;
        this.realData = realData;
        this.isReady=true;
        notifyAll();

    }
}
