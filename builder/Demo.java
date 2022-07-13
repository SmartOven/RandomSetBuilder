package builder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        test();
    }

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
