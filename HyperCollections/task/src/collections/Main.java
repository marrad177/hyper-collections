package collections;

public class Main {
    public static void main(String[] args) {
//    BiMap<Character, Integer> biMap = new BiMap<>();
//
//    biMap.put('a', 3);
//    biMap.putAll(Map.of('b', 4, 'c', 5));
//
//    System.out.println(biMap); // {a=3, b=4, c=5}
//    System.out.println(biMap.values()); // [3, 4, 5]
//
////biMap.put('a', 6); - an IllegalArgumentException should be thrown
////biMap.put('d', 3); - an IllegalArgumentException should be thrown
////biMap.putAll(Map.of('d', 6, 'e', 4)); - an IllegalArgumentException should be thrown
////biMap.putAll(Map.of('d', 6, 'c', 7)); - an IllegalArgumentException should be thrown
//
//    biMap.putAll(Map.of('d', 6, 'e', 7));
//
//    System.out.println(biMap); // {a=3, b=4, c=5, d=6, e=7}
//    System.out.println(biMap.inverse()); // {3=a, 4=b, 5=c, 6=d, 7=e}
//
//    biMap.forcePut('f', 8);
//
//    System.out.println(biMap); // {a=3, b=4, c=5, d=6, e=7, f=8}
//    System.out.println(biMap.inverse()); // {3=a, 4=b, 5=c, 6=d, 7=e, 8=f}
//
//    biMap.forcePut('a', 9);
//
//    System.out.println(biMap); // {a=9, b=4, c=5, d=6, e=7, f=8}
//    System.out.println(biMap.inverse()); // {4=b, 5=c, 6=d, 7=e, 8=f, 9=a}
//
//    biMap.forcePut('g', 4);
//
//    System.out.println(biMap); // {a=9, c=5, d=6, e=7, f=8, g=4}
//    System.out.println(biMap.inverse()); // {4=g, 5=c, 6=d, 7=e, 8=f, 9=a}
//
//    biMap.forcePut('c', 6);
//
//    System.out.println(biMap); // {a=9, c=6, e=7, f=8, g=4}
//    System.out.println(biMap.inverse()); // {4=g, 6=c, 7=e, 8=f, 9=a}
//
//    Multiset<Character> multiset = new Multiset<>();
//    multiset.add('a');
//    multiset.add('b', 6);
//
//    System.out.println(multiset); // [a, b, b, b, b, b, b]
//    System.out.println(multiset.contains('c')); // false
//    System.out.println(multiset.count('b')); // 6
//    System.out.println(multiset.elementSet()); // ['a', 'b']
//
//    multiset.remove('a');
//    multiset.remove('b', 3);
//
//    System.out.println(multiset); // [b, b, b]
//
//    multiset.add('c');
//    multiset.setCount('c', 2);
//    multiset.setCount('b', 3, 4);
//
//    System.out.println(multiset); // [b, b, b, b, c, c]

//      SizeLimitedQueue<Integer> collection = new SizeLimitedQueue<>(3); // limit is 3
//
//      System.out.println(collection); // []
//      System.out.println(collection.maxSize()); // 3
//      System.out.println(collection.size()); // 0
//      System.out.println(collection.isEmpty()); // true
//
//      collection.add(1);
//      collection.add(2);
//
//      System.out.println(collection.isEmpty()); // false
//      System.out.println(collection); // [1, 2]
//      System.out.println(collection.isAtFullCapacity()); // false
//
//      collection.add(3);
//
//      System.out.println(collection); // [1, 2, 3]
//      System.out.println(collection.isAtFullCapacity()); // true
//
//      collection.add(4);
//      System.out.println(collection); // [2, 3, 4]
//
//      System.out.println(collection.peek()); // 2
//      System.out.println(collection); // [2, 3, 4]
//      System.out.println(collection.remove()); // 2
//      System.out.println(collection); // [3, 4]
//
//      System.out.println(collection.toArray().getClass()); // class [Ljava.lang.Object;
//      System.out.println(collection.toArray(new Integer[0]).getClass()); // class [Ljava.lang.Integer;

//        System.out.println(Range.open(1, 10)); //(1, 10)
//        System.out.println(Range.closed(1, 10)); //[1, 10]
//        System.out.println(Range.openClosed(1, 10)); //(1, 10]
//        System.out.println(Range.closedOpen(1, 10)); //[1, 10)
//        System.out.println(Range.greaterThan(1)); //(1, INF)
//        System.out.println(Range.atLeast(1)); //[1, INF)
//        System.out.println(Range.lessThan(10)); //(-INF, 10)
//        System.out.println(Range.atMost(10)); //(-INF, 10]
//        System.out.println(Range.all()); //(-INF, INF)
//
//        System.out.println(Range.closed(1, 1)); //[1, 1]
//        System.out.println(Range.openClosed(1, 1)); //EMPTY
//        System.out.println(Range.closedOpen(1, 1)); //EMPTY
//
//        System.out.println(Range.open(1, 10).contains(5)); //true
//        System.out.println(Range.open(1, 10).contains(10)); //false
//        System.out.println(Range.openClosed(1, 10).contains(10)); //true
//
//        System.out.println(Range.closed(1, 10).encloses(Range.closed(5, 7))); //true
//        System.out.println(Range.open(1, 10).encloses(Range.closedOpen(1, 10))); //false
//        System.out.println(Range.closed(1, 10).encloses(Range.open(1, 10))); //true
//        System.out.println(Range.all().encloses(Range.all())); //true
//        System.out.println(Range.openClosed(5, 15).encloses(Range.openClosed(5, 15))); //true
        System.out.println(Range.greaterThan(25).encloses(Range.greaterThan(25))); //true
//        System.out.println(Range.atLeast(25).span(Range.greaterThan(25))); //true
//
//        System.out.println(Range.atMost(10).span(Range.closed(1, 5))); //(-INF, 10]
//        System.out.println(Range.atMost(10).span(Range.atLeast(11))); //(-INF, INF)
////        System.out.println(Range.all().span(Range.atMost(10))); //(-INF, INF)
////
//        System.out.println(Range.all().intersection(Range.atLeast(5))); //[5, INF)
//        System.out.println(Range.atMost(10).intersection(Range.greaterThan(10))); //EMPTY
//        System.out.println(Range.closedOpen(1, 1).intersection(Range.openClosed(1, 1))); //EMPTY
//
//        System.out.println(Range.openClosed(1, 1).contains(1)); //false
//        System.out.println(Range.lessThan(10).contains(10)); //false
//        System.out.println(Range.atMost(10).contains(10)); //true
//        System.out.println(Range.greaterThan(10).contains(10)); //false
//        System.out.println(Range.atLeast(10).contains(10)); //true
//
//        System.out.println(Range.closed(0, 0).encloses(Range.closed(0, 0))); //true
//        System.out.println(Range.openClosed(0, 5).encloses(Range.closedOpen(0, 0))); //true
//        System.out.println(Range.closedOpen(0, 5).encloses(Range.openClosed(0, 5))); //false
//        System.out.println(Range.openClosed(0, 0).encloses(Range.closedOpen(0, 5))); //false
//        System.out.println(Range.openClosed(0, 0).encloses(Range.closedOpen(0, 0))); //false
//
//        System.out.println(Range.closed(10,10).span(Range.closed(10,10))); //[10, 10]
//        System.out.println(Range.closed(10,10).span(Range.openClosed(10,10))); //[10, 10]
//        System.out.println(Range.closed(10,10).span(Range.closedOpen(10,10))); //[10, 10]
//        System.out.println(Range.openClosed(10,10).span(Range.closed(10,10))); //[10, 10]
//        System.out.println(Range.openClosed(10,10).span(Range.openClosed(10,10))); //EMPTY
//        System.out.println(Range.openClosed(10,10).span(Range.closedOpen(10,10))); //EMPTY
//        System.out.println(Range.closedOpen(10,10).span(Range.closed(10,10))); //[10, 10]
//        System.out.println(Range.closedOpen(10,10).span(Range.openClosed(10,10))); //EMPTY
//        System.out.println(Range.closedOpen(10,10).span(Range.closedOpen(10,10))); //EMPTY
//
//        System.out.println(Range.closed(10,10).intersection(Range.closed(10,10))); //[10, 10]
//        System.out.println(Range.closed(10,10).intersection(Range.openClosed(10,10))); //EMPTY
//        System.out.println(Range.closed(10,10).intersection(Range.closedOpen(10,10))); //EMPTY
//        System.out.println(Range.openClosed(10,10).intersection(Range.closed(10,10))); //EMPTY
//        System.out.println(Range.openClosed(10,10).intersection(Range.openClosed(10,10))); //EMPTY
//        System.out.println(Range.openClosed(10,10).intersection(Range.closedOpen(10,10))); //EMPTY
//        System.out.println(Range.closedOpen(10,10).intersection(Range.closed(10,10))); //EMPTY
//        System.out.println(Range.closedOpen(10,10).intersection(Range.openClosed(10,10))); //EMPTY
//        System.out.println(Range.closedOpen(10,10).intersection(Range.closedOpen(10,10))); //EMPTY
//          System.out.println(Range.openClosed(5, 5).span(Range.greaterThan(20)));
//        System.out.println(Range.closed(15, 25).intersection(Range.closed(15, 15)));

    }
}