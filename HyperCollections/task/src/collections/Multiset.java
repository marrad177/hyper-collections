package collections;

import java.util.*;
import java.util.stream.Collectors;

public class Multiset<E> {
    Map<E, Integer> elements = new HashMap<E, Integer>();

    public void add(E element) {
        if (elements.containsKey(element)) {
            elements.put(element, elements.get(element) + 1);
        } else {
            elements.put(element, 1);
        }
    }

    public void add(E element, int occurrences) {
        if (elements.containsKey(element) && occurrences >= 0) {
            elements.put(element, elements.get(element) + occurrences);
        } else if (occurrences >= 0) {
            elements.put(element, occurrences);
        }
    }

    public boolean contains(E element) {
        return elements.containsKey(element);
    }

    public int count(E element) {
        if (elements.containsKey(element)) {
            return elements.get(element);
        }
        return 0;
    }

    public Set<E> elementSet() {
        return elements
                .keySet()
                .stream()
                .filter(entry -> elements.get(entry) > 0)
                .collect(Collectors.toSet());
    }

    public void remove(E element) {
        if (elements.containsKey(element) && elements.get(element) == 1) {
            elements.remove(element);
        } else if (elements.containsKey(element)) {
            elements.put(element, elements.get(element) - 1);
        }
    }

    public void remove(E element, int occurrences) {
        if (elements.containsKey(element) && elements.get(element) <= occurrences) {
            elements.remove(element);
        } else if (elements.containsKey(element) && occurrences > 0) {
            elements.put(element, elements.get(element) - occurrences);
        }
    }

    public void setCount(E element, int count) {
        if (elements.containsKey(element) && count >= 0) {
            elements.put(element, count);
        }
    }

    public void setCount(E element, int oldCount, int newCount) {
        if (elements.containsKey(element) && elements.get(element) == oldCount && newCount >= 0) {
            elements.put(element, newCount);
        }
    }

    @Override
    public String toString() {
        List<E> elementList = new ArrayList<E>();
        elements
                .entrySet()
                .stream()
                .forEach(entry -> {
                    for (int i = 0; i < entry.getValue(); i++) {
                        if (entry.getValue() > 0) {
                            elementList.add(entry.getKey());
                        }
                    }
                });
        return elementList.toString();
    }
}
