package practice.producerconsumer;

public class Produce  extends Thread {
    String name;
    MyStack myStack;

    public Produce(String name, MyStack myStack) {
        this.myStack = myStack;
        this.name = name;
    }


    @Override
    public void run() {
        while (true){
        char c = randomChar();
            System.out.println(name+"Éú²ú"+c);
            myStack.push(c);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public char randomChar() {
        return (char) (Math.random() * ('Z' + 1 - 'A') + 'A');
    }
}
