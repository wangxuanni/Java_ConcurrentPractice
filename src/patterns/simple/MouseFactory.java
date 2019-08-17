package patterns.simple;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-17 21:54
 **/

public class MouseFactory {
    Mouse getMouse(MouseType type) {
        switch (type) {
            case HpMouse:
                return new HpMouse();
            case DeilMouse:
                return new DeilMouse();
        }
        return null;
    }

    public static void main(String[] args) {
        MouseFactory mouseFactory = new MouseFactory();
        Mouse mouse = mouseFactory.getMouse(MouseType.HpMouse);
        mouse.sayHi();
    }
}
