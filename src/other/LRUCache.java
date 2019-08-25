package other;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @description:��HashMap+LinkedListʵ��LRU
 * @author: wangxuanni
 * @create: 2019-07-23 14:45
 **/

public class LRUCache<K, V> {
    public static void main(String[] args) {
        LRUCache<String,String> lru=new LRUCache<>(3);

        lru.put("A", null);
        lru.put("B", null);
        lru.put("C", null);
        lru.put("D", null);

        System.out.println(lru);
        /*
        out:[D, C, B]
        */

    }
    //�����С��putʱ�����ж���û���������С
    private final int cacheSize;
    //��ɢ�б��ж��Ƿ����л��档
    private HashMap<K, V> map = new HashMap<>();
    //������ά�����һ�η���ʱ�������ҳ������
    private LinkedList<K> linkCache = new LinkedList();

    LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }
//��syn��֤�̰߳�ȫ
    public synchronized void put(K key, V val) {
        if (!map.containsKey(key)) {
            if (map.size() >= cacheSize) {
                removeLast();
            }
            map.put(key, val);
            linkCache.addFirst(key);//put�ӵ�����ͷ
        } else {
            moveToFirst(key);
        }

    }

    public synchronized V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        moveToFirst(key);
        return map.get(key);
    }

    private synchronized void moveToFirst(K key) {
        linkCache.remove(key);
        linkCache.addFirst(key);

    }

    private synchronized void removeLast() {
        linkCache.removeLast();

    }
    @Override
    public String toString() {
        return linkCache.toString();
    }


}
