package practice.simpleThreadPool;


public class TestThreadPool {
    public static void main(String[] args) throws InterruptedException {
        //线程池大小初始化为3
            ThreadPool threadPool=ThreadPool.newThreadPool();
        //生成10个任务放入线程池
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Runnable task=  new Runnable(){
                @Override
                public void run() {
                    System.out.println("做任务中。。。");
                }
            };
            threadPool.execute(task);
        }

    }
}