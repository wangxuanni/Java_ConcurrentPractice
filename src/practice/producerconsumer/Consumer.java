package practice.producerconsumer;

public class Consumer extends Thread{
    String name;
    MyStack myStack;
    public Consumer(String name, MyStack myStack) {
        this.myStack = myStack;
        this.name = name;
    }
    @Override
    public void run() {
        while (true){
           char c= myStack.pull();
            System.out.println(name+"ฯ๛ทั"+c);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
