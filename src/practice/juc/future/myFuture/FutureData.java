package practice.juc.future.myFuture;

/**
 * @description:FutureData�ۺ���RealData��Ҳ���ǰ���һ��RealDataʵ�� get������������ȥ��set����֪ͨ
 * @author: wangxuanni
 * @create: 2019-08-04 17:14
 **/

public class FutureData implements Data {

    RealData realData;
    boolean isReady;

    /**
     * ��syn����
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
        //����˵��realData�Ѿ���ʼ�����
        if (isReady)
            return ;
        this.realData = realData;
        this.isReady=true;
        notifyAll();

    }
}
