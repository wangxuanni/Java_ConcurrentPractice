package practice.juc.future.myFuture;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-04 17:14
 **/

public class RealData implements Data {
    String questStr;
    public RealData(String questStr) {
        try {
            Thread.sleep(1000);
            this.questStr=questStr+"-该数据处理完成。";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getData() {
        return this.questStr;
    }
}
