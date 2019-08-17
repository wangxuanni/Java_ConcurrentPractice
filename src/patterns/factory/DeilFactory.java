package patterns.factory;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-17 22:18
 **/

public class DeilFactory extends Factory {
    public Mouse createMouse() {
        return new HpMouse();
    }
}
