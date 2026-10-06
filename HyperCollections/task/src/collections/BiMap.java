package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BiMap<K, V> {
    private Map<K, V> keyMap = new HashMap<>();
    private Map<V, K> valueMap = new HashMap<>();

    public V put(K key, V value) {
        if (keyMap.containsKey(key) || valueMap.containsKey(value)) {
            throw new IllegalArgumentException();
        }
        keyMap.put(key, value);
        valueMap.put(value, key);
        return value;
    }

    public void putAll(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<V> values() {
        Set<V> set = new HashSet<>();
        for (Map.Entry<K, V> entry : keyMap.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }

    public V forcePut(K key, V value) {
        if (keyMap.containsKey(key)) {
            valueMap.remove(keyMap.get(key));
        }
        if (valueMap.containsKey(value)) {
            keyMap.remove(valueMap.get(value));
        }
        keyMap.put(key, value);
        valueMap.put(value, key);
        return value;
    }

    public void forcePutAll(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            forcePut(entry.getKey(), entry.getValue());
        }
    }

    public BiMap<V, K> inverse() {
        BiMap<V, K> reverseBiMap = new BiMap<>();
        reverseBiMap.putAll(valueMap);
        return reverseBiMap;
    }

    @Override
    public String toString() {
        keyMap
                .entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .toList();
        return keyMap.toString();
    }
}
