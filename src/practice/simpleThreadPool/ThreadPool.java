package practice.simpleThreadPool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    //�����߳���
    private int workerCount;
    // �̳߳ش�С
    private int corePoolSize;
    // ��������
    private BlockingQueue<Runnable> workQueue;
    //�����߳�����
    private Set<Worker> workers;
    // ��������


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
                // ִ�е�ǰ���������԰���������ÿգ����������ѭ��
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