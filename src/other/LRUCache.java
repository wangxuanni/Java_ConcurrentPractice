package other;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @description:用HashMap+LinkedList实现LRU
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
    //缓存大小，put时候需判断有没超过缓存大小
    private final int cacheSize;
    //用散列表判断是否命中缓存。
    private HashMap<K, V> map = new HashMap<>();
    //用链表维护最近一次访问时间排序的页面链表
    private LinkedList<K> linkCache = new LinkedList();

    LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }
//用syn保证线程安全
    public synchronized void put(K key, V val) {
        if (!map.containsKey(key)) {
            if (map.size() >= cacheSize) {
                removeLast();
            }
            map.put(key, val);
            linkCache.addFirst(key);//put加到链表头
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
