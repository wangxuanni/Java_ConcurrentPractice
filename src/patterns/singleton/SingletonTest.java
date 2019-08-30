package patterns.singleton;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-08-30 13:11
 **/

public class SingletonTest {


    private SingletonTest(){

    }

    /**
     * ö���������̰߳�ȫ�ģ�����ֻ��װ��һ��
     */
    private enum Singleton{
        INSTANCE;

        private final SingletonTest instance;

        Singleton(){
            instance = new SingletonTest();
        }

        private SingletonTest getInstance(){
            return instance;
        }
    }

    public static SingletonTest getInstance(){
        return SingletonTest.Singleton.INSTANCE.getInstance();
    }
}

