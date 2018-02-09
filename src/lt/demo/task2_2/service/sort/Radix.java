package lt.demo.task2_2.service.sort;

import java.util.Arrays;

public class Radix {
    // A utility function to get maximum value in array
    static int getMaxValue(int array[], int n)
    {
        int mx = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > mx)
                mx = array[i];
        return mx;
    }

    // A function to do counting sort of array.
    static void countSort(int array[], int n, int exp)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (array[i]/exp)%10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (array[i]/exp)%10 ] - 1] = array[i];
            count[ (array[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++)
            array[i] = output[i];
    }

    // The main function to that sorts array
    public static void radixsort(int array[], int n)
    {
        if (n == 0 || n == 1) {
            return;
        }
        // Find the maximum number to know number of digits
        int m = getMaxValue(array, n);

        // Do counting sort for every digit.
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(array, n, exp);
    }
}
