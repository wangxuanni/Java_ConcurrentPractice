package practice.producerconsumer;

import java.util.LinkedList;

public class MyStack {
    LinkedList<Character> ll = new LinkedList<>();

    public synchronized void push(char c) {
        if (ll.size() > 100) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        ll.addLast(c);

    }

    public synchronized char pull() {
        if (ll.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return ll.removeLast();
    }


}
