package collections;

import java.util.LinkedList;

public class SizeLimitedQueue<E> {
    private final LinkedList<E> elementList = new LinkedList<>();
    private int MAX_SIZE;

    public SizeLimitedQueue(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException();
        }
        MAX_SIZE = maxSize;
    }

    public void add(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (isAtFullCapacity()) {
            elementList.remove();
        }
        elementList.add(element);
    }

    public void clear() {
        elementList.clear();
    }

    public boolean isAtFullCapacity() {
        return elementList.size() == MAX_SIZE;
    }

    public boolean isEmpty() {
        return elementList.isEmpty();
    }

    public int maxSize() {
        return MAX_SIZE;
    }

    public E peek() {
        return elementList.peek();
    }

    public E remove() {
        return elementList.remove();
    }

    public int size() {
        return elementList.size();
    }

    public E[] toArray(E[] e) {
        return elementList.toArray(e);
    }

    public Object[] toArray() {
        return elementList.toArray();
    }

    @Override
    public String toString() {
//        elementList
//                .stream()
//                .map(e -> e.getKey() + "=" + e.getValue())
//                .toList();
        return elementList.toString();
    }
}
