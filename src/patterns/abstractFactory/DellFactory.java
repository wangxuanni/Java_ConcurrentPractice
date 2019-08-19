package patterns.abstractFactory;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-17 22:18
 **/

public class DellFactory extends Factory {
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBo createKeyBo() {
        return new HpKeyBo();
    }
}
