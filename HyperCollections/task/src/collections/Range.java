package collections;

import java.util.Optional;

public class Range<E extends Comparable<E>> {
    private final Optional<E> lower;
    private final boolean lowerClosed;
    private final Optional<E> upper;
    private final boolean upperClosed;

    private Range(E lower, boolean lowerClosed, E upper, boolean upperClosed) {
        if (lower == null) {
            this.lower = Optional.empty();
        } else {
            this.lower = Optional.of(lower);
        }
        this.lowerClosed = lowerClosed;
        if (upper == null) {
            this.upper = Optional.empty();
        } else {
            this.upper = Optional.of(upper);
        }
        this.upperClosed = upperClosed;
    }

    private Range(Optional<E> lower, boolean lowerClosed, Optional<E> upper, boolean upperClosed) {
        this.lower = lower;
        this.lowerClosed = lowerClosed;
        this.upper = upper;
        this.upperClosed = upperClosed;
    }

    public static <E extends Comparable<E>> Range<E> open(E a, E b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        if (a.compareTo(b) >= 0) {
            throw new IllegalArgumentException();
        }
        return new Range<>(a, false, b, false);
    }

    public static <E extends Comparable<E>> Range<E> closed(E a, E b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        if (a.compareTo(b) > 0) {
            throw new IllegalArgumentException();
        }
        return new Range<>(a, true, b, true);
    }

    public static <E extends Comparable<E>> Range<E> openClosed(E a, E b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        if (a.compareTo(b) > 0) {
            throw new IllegalArgumentException();
        }
        return new Range<>(a, false, b, true);
    }

    public static <E extends Comparable<E>> Range<E> closedOpen(E a, E b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        if (a.compareTo(b) > 0) {
            throw new IllegalArgumentException();
        }
        return new Range<>(a, true, b, false);
    }

    public static <E extends Comparable<E>> Range<E> greaterThan(E a) {
        if (a == null) {
            throw new NullPointerException();
        }
        return new Range<>(Optional.of(a), false, Optional.empty(), false);
    }

    public static <E extends Comparable<E>> Range<E> atLeast(E a) {
        if (a == null) {
            throw new NullPointerException();
        }
        return new Range<>(Optional.of(a), true, Optional.empty(), false);
    }

    public static <E extends Comparable<E>> Range<E> lessThan(E a) {
        if (a == null) {
            throw new NullPointerException();
        }
        return new Range<>(Optional.empty(), false, Optional.of(a), false);
    }

    public static <E extends Comparable<E>> Range<E> atMost(E a) {
        if (a == null) {
            throw new NullPointerException();
        }
        return new Range<>(Optional.empty(), false, Optional.of(a), true);
    }

    public static <E extends Comparable<E>> Range<E> all() {
        return new Range<E>(Optional.empty(), false, Optional.empty(), false);
    }

    public boolean contains(E value) {
        if (value == null) {
            throw new NullPointerException();
        }

        if (lower.isPresent() && upper.isPresent()) {
            if (value.compareTo(lower.get()) < 0 || value.compareTo(upper.get()) > 0) {
                return false;
            } else if (value.compareTo(lower.get()) == 0) {
                return lowerClosed;
            } else if (value.compareTo(upper.get()) == 0) {
                return upperClosed;
            } else {
                return true;
            }
        } else if (upper.isPresent()) {
            if (value.compareTo(upper.get()) > 0) {
                return false;
            } else if (value.compareTo(upper.get()) == 0) {
                return upperClosed;
            } else {
                return true;
            }
        } else if (lower.isPresent()) {
            if (value.compareTo(lower.get()) < 0) {
                return false;
            } else if (value.compareTo(lower.get()) == 0) {
                return lowerClosed;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public boolean encloses(Range<E> other) {
        if (this == null || other == null) {
            throw new NullPointerException();
        }
        if (this.isEmpty()) {
            return false;
        }
        if (other.isEmpty()) {
            return true;
        }

        boolean lowerBound = other.lower.isPresent() &&
                (this.contains(other.lower.get()) ||
                        (this.lower.isPresent() &&
                                other.lower.get().compareTo(this.lower.get()) == 0 &&
                                !this.lowerClosed && !other.lowerClosed)) ||
                other.lower.isEmpty() && this.lower.isEmpty();
        boolean upperBound = other.upper.isPresent() &&
                (this.contains(other.upper.get()) ||
                        (this.upper.isPresent() &&
                                other.upper.get().compareTo(this.upper.get()) == 0 &&
                                !this.upperClosed && !other.upperClosed)) ||
                other.upper.isEmpty() && this.upper.isEmpty();

        return lowerBound && upperBound;
    }

    public Range<E> intersection(Range<E> other) {
        if (other == null) {
            throw new NullPointerException();
        }

        if (other.isEmpty()) {
            return other;
        }

        if (this.isEmpty()) {
            return this;
        }

        Optional<E> newLower;
        Optional<E> newUpper;
        boolean newLowerClosed;
        boolean newUpperClosed;

        if (this.lower.isEmpty()) {
            newLower = other.lower;
            newLowerClosed = other.lowerClosed;
        } else if (other.lower.isEmpty()) {
            newLower = this.lower;
            newLowerClosed = this.lowerClosed;
        } else if (this.lower.get().compareTo(other.lower.get()) < 0) {
            newLower = other.lower;
            newLowerClosed = other.lowerClosed;
        } else if (this.lower.get().compareTo(other.lower.get()) > 0) {
            newLower = this.lower;
            newLowerClosed = this.lowerClosed;
        } else {
            newLower = this.lower;
            newLowerClosed = this.lowerClosed && other.lowerClosed;
        }

        if (this.upper.isEmpty()) {
            newUpper = other.upper;
            newUpperClosed = other.upperClosed;
        } else if (other.upper.isEmpty()) {
            newUpper = this.upper;
            newUpperClosed = this.upperClosed;
        } else if (this.upper.get().compareTo(other.upper.get()) > 0) {
            newUpper = other.upper;
            newUpperClosed = other.upperClosed;
        } else if (this.upper.get().compareTo(other.upper.get()) < 0) {
            newUpper = this.upper;
            newUpperClosed = this.upperClosed;
        } else {
            newUpper = this.upper;
            newUpperClosed = this.upperClosed && other.upperClosed;
        }

        if (newLower.isEmpty() || newUpper.isEmpty()) {
            return new Range<>(newLower, newLowerClosed, newUpper, newUpperClosed);
        }
        if (newLower.get().compareTo(newUpper.get()) > 0 ||
                newLower.get().compareTo(newUpper.get()) == 0 &&
                        !newLowerClosed && !newUpperClosed) {
            return new Range<>(newUpper, false, newUpper, true);
        }
        return new Range<>(newLower, newLowerClosed, newUpper, newUpperClosed);
    }

    public Range<E> span(Range<E> other) {
        Optional<E> newLower;
        Optional<E> newUpper;
        boolean newLowerClosed = false;
        boolean newUpperClosed = false;

        if (other == null) {
            throw new NullPointerException();
        }
        if (other.isEmpty()) {
            return this;
        }
        if (this.isEmpty()) {
            return other;
        }

        if (this.lower.isEmpty() || other.lower.isEmpty()) {
            newLower = Optional.empty();
            newLowerClosed = false;
        } else if (this.lower.get().compareTo(other.lower.get()) < 0) {
            newLower = this.lower;
            newLowerClosed = this.lowerClosed;
        } else if (this.lower.get().compareTo(other.lower.get()) > 0) {
            newLower = other.lower;
            newLowerClosed = other.lowerClosed;
        } else {
            newLower = this.lower;
            newLowerClosed = this.lowerClosed || other.lowerClosed;
        }

        if (this.upper.isEmpty() || other.upper.isEmpty()) {
            newUpper = Optional.empty();
            newUpperClosed = false;
        } else if (this.upper.get().compareTo(other.upper.get()) > 0) {
            newUpper = this.upper;
            newUpperClosed = this.upperClosed;
        }  else if (this.upper.get().compareTo(other.upper.get()) < 0) {
            newUpper = other.upper;
            newUpperClosed = other.upperClosed;
        } else {
            newUpper = this.upper;
            newUpperClosed = this.upperClosed || other.upperClosed;
        }

        return new Range<>(newLower, newLowerClosed, newUpper, newUpperClosed);
    }

    public boolean isEmpty() {
        return this.lower.isPresent()
                && this.upper.isPresent()
                && this.lower.equals(this.upper)
                && this.lowerClosed != this.upperClosed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            return "EMPTY";
        }
        if (lowerClosed) {
            sb.append("[");
        } else {
            sb.append("(");
        }
        if (lower.isEmpty()) {
            sb.append("-INF, ");
        } else {
            sb.append(lower.get()).append(", ");
        }
        if (upper.isEmpty()) {
            sb.append("INF");
        } else {
            sb.append(upper.get());
        }
        if (upperClosed) {
            sb.append("]");
        } else {
            sb.append(")");
        }
        return sb.toString();
    }
}
