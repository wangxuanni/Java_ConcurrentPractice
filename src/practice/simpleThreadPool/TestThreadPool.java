package practice.simpleThreadPool;


public class TestThreadPool {
    public static void main(String[] args) throws InterruptedException {
        //�̳߳ش�С��ʼ��Ϊ3
            ThreadPool threadPool=ThreadPool.newThreadPool();
        //����10����������̳߳�
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Runnable task=  new Runnable(){
                @Override
                public void run() {
                    System.out.println("�������С�����");
                }
            };
            threadPool.execute(task);
        }

    }
}