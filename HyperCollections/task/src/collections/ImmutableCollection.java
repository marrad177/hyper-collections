package collections;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableCollection<T> {
    private List<T> collection;

    ImmutableCollection() {
        this.collection = new ArrayList<>();
    }

    ImmutableCollection(T... values) {
        this.collection = new ArrayList<>();
        for (T value : values) {
            collection.add(value);
        }
    }

    public static <T> ImmutableCollection<T> of() {
        return new ImmutableCollection<T>();
    }

    public static <T> ImmutableCollection<T> of(T... args) {
        if (args.length == 0) {
            return new ImmutableCollection<T>();
        }
        for (T t : args) {
            if (t == null) {
                throw new NullPointerException("Null argument");
            }
        }
        return new ImmutableCollection<T>(args);
    }

    public <T> boolean contains(T element) {
        return collection.contains(element);
    }

    public int size() {
        return collection.size();
    }

    public boolean isEmpty() {
        return collection.isEmpty();
    }
}
