package lt.demo.tests.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class ArrayGenerator {
    int minLength = 20;
    int maxLength = 100000;

    public Collection<int[]> generateArraysForQuickCheck(int numberOfArrays, boolean onlyPositive) {
        ArrayList<int[]> output = new ArrayList<>();

        // inserting some edge cases
        output.add(new int[0]);
        output.add(new int[]{Integer.MAX_VALUE});
        output.add(new int[]{0, 0});
        output.add(new int[]{0, 1});

        for (int i = 0; i < numberOfArrays - 4; i++) {
            if (i % 3 == 0) {
                output.add(generateWithDuplicates(onlyPositive));
            } else {
                output.add(generateWithoutDuplicates(onlyPositive));
            }
        }

        return output;
    }

    private int[] generateWithoutDuplicates(boolean onlyPositive) {
        Random random = new Random();

        int size = random.nextInt(maxLength);
        int numToAdd = random.nextInt(maxLength);

        if (size < minLength) size = minLength;

        int[] output = new int[size];

        for (int i = 0; i < size; i++) {
            if (onlyPositive && numToAdd < 0) {
                output[i] = i- numToAdd;
            }
            output[i] = i + numToAdd;
        }

        return output;
    }

    public int[] generateWithDuplicates(boolean onlyPositive) {
        Random random = new Random();

        int size = random.nextInt(maxLength);

        if (size < minLength) size = minLength;

        int[] output = new int[size];

        for (int i = 0; i < size; i++) {
            output[i] = random.nextInt(maxLength);

            //insert some duplicates
            if (i % 10 == 0 && i != 0) {
                output[i] = output[i - 1];
            }

            if (onlyPositive &&  output[i] < 0) {
                output[i] =  - output[i];
            }
        }

        return output;
    }
}
