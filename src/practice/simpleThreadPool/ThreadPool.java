package practice.simpleThreadPool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    //工作线程数
    private int workerCount;
    // 线程池大小
    private int corePoolSize;
    // 任务容器
    private BlockingQueue<Runnable> workQueue;
    //工作线程容器
    private Set<Worker> workers;
    // 任务容器


    private static ThreadPool threadPool;

    public static ThreadPool newThreadPool() {
        threadPool = new ThreadPool(3);
        return threadPool;
    }

    private ThreadPool(int corePoolSize) {
        this.corePoolSize = corePoolSize;
        workQueue = new LinkedBlockingQueue<>();
        workers = new HashSet<>();
    }

    public void execute(Runnable r) {
        if (workerCount < corePoolSize) {
            addWorker(r);
        } else {
            try {
                workQueue.put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addWorker(Runnable r) {
        workerCount++;
        Worker worker = new Worker(r);
        Thread t = worker.thread;
        workers.add(worker);
        t.start();
    }

    class Worker implements Runnable {
        Runnable task;
        Thread thread;

        public Worker(Runnable task) {
            this.task = task;
            this.thread = new Thread(this);
        }

        @Override
        public void run() {
            while (true) {
                Runnable task = this.task;
                // 执行当前的任务，所以把这个任务置空，以免造成死循环
                this.task = null;
                if (task != null || (task = getTask()) != null) {
                    task.run();
                }
            }
        }
    }

    private Runnable getTask() {
        Runnable r = null;
        try {
            r = workQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return r;
    }
}