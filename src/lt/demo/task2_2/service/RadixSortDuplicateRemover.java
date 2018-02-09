package lt.demo.task2_2.service;

import lt.demo.task2_2.service.def.DuplicateRemover;
import lt.demo.task2_2.service.sort.Radix;

import java.util.Arrays;

/**
 * Class that removes duplicates from an array, by applying Radix sort first.
 * Radix sort can give a complexity of O(n), when integers are not too long.
 * However, costs more memory.
 */
public class RadixSortDuplicateRemover implements DuplicateRemover {
    private final int INSERTION_SORT_THRESHOLD = 64;

    @Override
    public int[] removeDuplicates(int[] input) {
        int arrayLength = input.length;

        // strong influence on time
//        RadixSort.sort(input, 0, input.length, 0);
        Radix.radixsort(input, input.length);

        if (arrayLength == 0 || arrayLength == 1)
            return input;

        int j = 0;

        for (int i = 0; i < arrayLength - 1; i++) {
            if (input[i] != input[i + 1]) {
                input[j++] = input[i];
            }
        }

        input[j++] = input[arrayLength - 1];

        return Arrays.copyOf(input, j);
    }
}
