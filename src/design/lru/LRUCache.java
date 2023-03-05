package design.lru;

import java.util.LinkedHashMap;

public class LRUCache {

  private final int capacity;
  private final LinkedHashMap<Integer, Integer> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new LinkedHashMap<>(capacity, .75f, true);
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    return cache.get(key);
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      cache.remove(key);
      cache.put(key, value);
    } else if (cache.size() >= capacity) {
      int last = cache.keySet().iterator().next();
      cache.remove(last);
    }
    cache.put(key, value);
  }

  public static void main(String[] args) {
    LRUCache cache1 = new LRUCache(2);

    cache1.get(2);
    cache1.put(2, 6);
    cache1.get(1);
    cache1.put(1, 5);
    cache1.put(1, 2);
    cache1.get(1);
    cache1.get(2);
  }
}
