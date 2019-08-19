package patterns.abstractFactory;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-17 21:54
 **/

public abstract class Factory {

    public abstract Mouse createMouse();
    public abstract KeyBo createKeyBo();


    public static void main(String[] args) {
        Factory factory = new HpFactory();
        KeyBo keyBo = factory.createKeyBo();
        keyBo.keyBoSayHi();


    }


}
