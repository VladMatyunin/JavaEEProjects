package ru.vladmatyunin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Iterates the execution
 */
class BagIterator {

    /**
     * No recursion
     *
     * Execution description:
     *
     * 1) sort array
     * 2) create list of bag containers, put first value to left bag(does not matter)
     * 3) iterate the values (the array of weight)
     * 3.1) get each value from 3), iterate between list of bag containers
     * @see BagContainer
     * 3.2) create new list of bag container, create two bag containers, put
     *      the value from 3.1 and put to both of created bag containers (first to left bag, second to right)
     * 3.3) put modified bag containers from 3.2 to created list of bag containers
     *      update list of BC (bag container) from 2)
     *
     * @param values - the weight of items
     * @return - all possible results
     */
    static List<BagContainer> execute(int[] values){
        // sort
        Arrays.sort(values);
        BagContainer container = new BagContainer();
        // initial instance
        List<BagContainer> results = new LinkedList<>();
        // put first result
        container.putLeft(values[0]);
        results.add(container);
        // iterate between values
        for (int i = 1; i < values.length; i++){
            List<BagContainer> newResults = new LinkedList<>();
            for (BagContainer container1: results){
                //two different instances of BC
                BagContainer newBag1 = new BagContainer(container1.getLeftBag(), container1.getRightBag());
                BagContainer newBag2 = new BagContainer(container1.getLeftBag(), container1.getRightBag());

                newBag1.putLeft(values[i]);
                newBag2.putRight(values[i]);

                newResults.add(newBag1);
                newResults.add(newBag2);

                results = newResults;
            }
        }
        return results;
    }

    /**
     * Best result is a BC, in which the difference is minimal
     * @see BagContainer
     * @param containers - where to search the best result
     * @return - the BC with minimal difference
     */
    static BagContainer getBestResult(List<BagContainer> containers){
        int min = Integer.MAX_VALUE;
        BagContainer finalResult = new BagContainer();
        for (BagContainer container: containers){
            if (container.getDifference()<min){
                min = container.getDifference();
                finalResult = container;
            }
        }
        return finalResult;
    }
}
