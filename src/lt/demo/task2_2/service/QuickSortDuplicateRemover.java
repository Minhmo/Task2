package lt.demo.task2_2.service;

import lt.demo.task2_2.service.def.DuplicateRemover;

import java.util.Arrays;

/**
 * Class, that removes duplicates from array by applying quick sort first.
 * Complexity O(nlog(n))
 */
public class QuickSortDuplicateRemover implements DuplicateRemover {

    @Override
    public int[] removeDuplicates(int[] input) {
        int arrayLength = input.length;
        Arrays.sort(input);

        if (arrayLength == 0 || arrayLength == 1)
            return input;

        int j = 0;


        for (int i = 0; i < arrayLength-1; i++)
            if (input[i] != input[i+1])
                input[j++] = input[i];

        input[j++] = input[arrayLength-1];

        return Arrays.copyOf(input, j);
    }

}
