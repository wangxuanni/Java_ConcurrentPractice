package practice.producerconsumer;

public class MainTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        new practice.producerconsumer.Produce("Producer1", stack).start();
        new practice.producerconsumer.Produce( "Producer2", stack).start();
        new Consumer("Consumer1", stack).start();
        new Consumer("Consumer2", stack).start();
        new Consumer("Consumer3", stack).start();
    }
}
