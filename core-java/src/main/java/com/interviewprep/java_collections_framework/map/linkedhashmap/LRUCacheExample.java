package com.interviewprep.java_collections_framework.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCacheExample {
  // Custom LRU Cache Implementation Using LinkedHashMap
  private static class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    // Constructor: Enable access order and define maximum capacity
    public LRUCache(int capacity) {
      super(capacity, 0.75f, true); // true = access order
      this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
      // Remove the eldest entry if size exceeds capacity
      return size() > capacity;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) return false;
      if (!super.equals(o)) return false;
      LRUCache<?, ?> lruCache = (LRUCache<?, ?>) o;
      return capacity == lruCache.capacity;
    }

    @Override
    public int hashCode() {
      return Objects.hash(super.hashCode(), capacity);
    }
  }

  public static void main(String[] args) {
    // Initialize an LRU Cache with a capacity of 3
    LRUCache<Integer, String> cache = new LRUCache<>(3);

    // Add elements to the cache
    cache.put(1, "One");
    cache.put(2, "Two");
    cache.put(3, "Three");
    System.out.println("Initial Cache: " + cache);

    // Access an element to make it "recently used"
    cache.get(1);
    System.out.println("Accessed Key 1: " + cache);

    // Add another element, which should evict the least recently used (Key 2)
    cache.put(4, "Four");
    System.out.println("After Adding Key 4: " + cache);

    // Add another element, which should evict Key 3
    cache.put(5, "Five");
    System.out.println("After Adding Key 5: " + cache);
  }
}
