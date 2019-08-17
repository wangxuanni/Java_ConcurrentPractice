package patterns.factory;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-17 21:54
 **/

public abstract class Factory {

    public abstract Mouse createMouse();

    public static void main(String[] args) {
        Factory factory = new HpFactory();
        Mouse mouse = factory.createMouse();
        mouse.sayHi();
    }


}
