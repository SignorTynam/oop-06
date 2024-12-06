package it.unibo.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private final static int START = 1000;
    private final static int END = 2000;
    private final static int ELEMS = 100000;
    private final static int READ = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

         List<Integer> arrayList = new ArrayList<>();
         for (int i = START; i < END; i++) {
            arrayList.add(i);
         }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

         List<Integer> linkedList = new LinkedList<>(arrayList);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

         int temp = arrayList.get(0);
         arrayList.set(0, arrayList.get(arrayList.size() - 1)); //oppure arrayList.set(0, arrayList.getLast());
         arrayList.set(arrayList.size() - 1, temp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

         for (Integer integer : arrayList) {
            System.out.println(integer);
         }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

         linkedList = (LinkedList<Integer>) importElements(linkedList, ELEMS);

         arrayList = (ArrayList<Integer>) importElements(arrayList, ELEMS);
         
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

         readElement(linkedList, READ);
         readElement(arrayList, READ);

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
         
         Map<String, BigDecimal> continents = new HashMap<>();
        continents.put("Africa", new BigDecimal("1110635000"));
        continents.put("Americas", new BigDecimal("972005000"));
        continents.put("Antarctica", BigDecimal.ZERO);
        continents.put("Asia", new BigDecimal("4298723000"));
        continents.put("Europe", new BigDecimal("742452000"));
        continents.put("Oceania", new BigDecimal("38304000"));

        /*
         * 8) Compute the population of the world
         */
        BigDecimal worldPopulation = BigDecimal.ZERO;
        for (BigDecimal population : continents.values()) {
            worldPopulation = worldPopulation.add(population);
        }

        System.out.println("World population: " + worldPopulation);


    }

    private static <T extends Number> List<T> importElements(List<T> collection, int elements) {
        long time = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            collection.add((T) Integer.valueOf(i));
        }
        
        final var millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - time);

        System.out.println("Time to import elements: " + millis + "ms");
        return collection;
    }

    private static <T extends Number> void readElement(List<T> collection, int times) {
        long time = System.nanoTime();
        for (int i = 0; i < times; i++) {
            collection.get(collection.size() / 2);
        }
        
        final var millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - time);

        System.out.println("Time to read: " + millis + "ms");
    }
}
