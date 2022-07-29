package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class KeyValueStorage {

  private final Map<String, TreeMap<Integer, String>> storage;

  public KeyValueStorage() {
    this.storage = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!storage.containsKey(key)) {
      storage.put(key, new TreeMap<>());
    }
    storage.get(key).put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    TreeMap<Integer, String> treeMap = storage.get(key);
    if (treeMap == null) {
      return "";
    }
    Integer floor = treeMap.floorKey(timestamp);
    if (floor == null) {
      return "";
    }
    return treeMap.get(floor);
  }
}
