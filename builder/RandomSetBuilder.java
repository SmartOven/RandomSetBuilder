package builder;

import java.util.*;

/**
 * Generator for sets of unique random integers in range [min, max)
 */
public class RandomSetBuilder {
    private final List<Integer> result;
    private final Map<Integer, Integer> usedNumbers;
    private final Random randomGenerator;
    private int currentMin; // 0 by default
    private final int max; // 100 by default

    public RandomSetBuilder() {
        this(0, 100, 0);
    }

    public RandomSetBuilder(int max) {
        this(0, max, 0);
    }

    public RandomSetBuilder(int min, int max) {
        this(min, max, 0);
    }

    public RandomSetBuilder(int min, int max, int seed) {
        this.currentMin = min;
        this.max = max - 1;

        randomGenerator = new Random(seed);
        usedNumbers = new HashMap<>();
        result = new LinkedList<>();
    }

    public List<Integer> toList() {
        return result;
    }

    /**
     * Adds count next unique random integers to the result set
     * @param count count of numbers to be added to set
     */
    public void append(int count) {
        for (int i = 0; i < count; i++) {
            addNextRandomInt();
        }
    }

    /**
     * Generates next unique integer
     *
     * Imagine sorted range of integers from min to max (both included)
     * (for example: [0, 1, 2, 3, 4])
     *
     * Let's generate random int from the range
     * (for example: 3)
     *
     * We want to generate only unique integers, so we follow this steps:
     * 1. When we generate integer from the range, we "swap" the generated one with the first not generated one (in ascending order)
     * (using example range and example generated integer it would be: [3, 1, 2, 0, 4])
     * We swapped 3 and 0, and then we increment min number of the generating range, so we will not generate 3 again
     *
     * We will do it by using currentIndex instead of min and storing swapped numbers in the hash map
     * So the example with [0, 1, 2, 3, 4] and 3 would look like:
     * currentIndex = 1, hashMap = [[3: 0]]
     *
     * And when we generate integer we need to check if we already generated it before (if hash map contains it)
     * If so we "generate" the value stored with key = generated integer
     *
     * Means if we have currentIndex = 1, hashMap = [[3: 0]] and if we generate 3 again
     * we will use 0 instead because hash map has key = 3 with value = 0
     */
    private void addNextRandomInt() {
        // Getting next random integer
        int nextIndex = randomGenerator.nextInt(max - currentMin + 1) + currentMin;

        // Replacing it with the swapped one if we already generated it before
        int next = findNextByIndex(nextIndex);

        // Add it to the result list
        result.add(next);

        // "Swap" it with the first not generated one (if it doesn't equal to itself or less, because instead it will be useless)
        if (nextIndex != currentMin) {
            usedNumbers.put(nextIndex, currentMin);
        }

        // Increment current index
        currentMin++;
    }

    private Integer findNextByIndex(int nextIndex) {
        int next = usedNumbers.getOrDefault(nextIndex, nextIndex);
        if (next == nextIndex) {
            return next;
        }

        return findNextByIndex(next);
    }
}
