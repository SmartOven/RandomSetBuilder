package builder;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        // Code example
        RandomSetBuilder randomSetBuilder = new RandomSetBuilder(0, 10);
        randomSetBuilder.append(3);
        randomSetBuilder.append(2);
        randomSetBuilder.appendAll();

        Set<Integer> randomSet = randomSetBuilder.toSet();
        List<Integer> randomList = randomSetBuilder.toList();
        Queue<Integer> randomQueue = randomSetBuilder.toQueue();
        Deque<Integer> randomDeque = randomSetBuilder.toDeque();
        int[] randomArray = randomSetBuilder.toArray();

        System.out.println(randomSet);
        System.out.println(randomList);
        System.out.println(randomQueue);
        System.out.println(randomDeque);
        System.out.println(Arrays.toString(randomArray));
    }

    // Testing if the result of RandomSetBuilder correct
    private static void test() {
        Random random = new Random(System.currentTimeMillis());
        while (true) {
            int min = random.nextInt(10);
            int max = min + 1 + random.nextInt(9);

            List<Integer> randomSet;
            RandomSetBuilder randomSetBuilder = new RandomSetBuilder(min, max);
            randomSetBuilder.append(max - min);

            randomSet = randomSetBuilder.toList();
            Collections.sort(randomSet);

            List<Integer> checker = new LinkedList<>();
            for (int j = min; j < max; j++) {
                checker.add(j);
            }

            if (!randomSet.equals(checker)) {
                System.out.println("Test failed!");
                System.out.println("Generated randomSet:      " + randomSet);
                System.out.println("Correct result should be: " + checker);
                break;
            }
        }
    }
}
