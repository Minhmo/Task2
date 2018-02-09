package lt.demo.task2_2;

import lt.demo.task2_2.service.QuickSortDuplicateRemover;
import lt.demo.task2_2.service.RadixSortDuplicateRemover;
import lt.demo.task2_2.service.def.Printer;
import lt.demo.task2_2.service.printer.ConsolePrinter;

import java.util.Random;

/**
 * Responsible for dependencies. Change a lot, but does not affect the others.
 *
 * Class showcases two sorts and their impacts on performance. Although, radix sort has better complexity,
 * Quick sort operates faster.
 * Hash tables removed from consideration, as they force to use Java reference objects,
 * in that way, boxing/unboxing takes place and performance slows down, even though complexity is O(n).
 */
public class DuplicateRemoveMain {

    public static void main(String[] args) {
        RadixSortDuplicateRemover radixSortDuplicateRemover = new RadixSortDuplicateRemover();
        QuickSortDuplicateRemover quickSortDuplicateRemover = new QuickSortDuplicateRemover();
        Random random = new Random();

        Printer printer = new ConsolePrinter();
        long start, end;

        int size = 100000000;

        int[] testArray = new int[size];
        int[] output;

        for (int i = 0; i < size; i++) {
            testArray[i] = random.nextInt(100);
        }

//        testArray = new int [] {1,2,3,1,2,3,5,6,7};

        printer.print("radix:");

        start = System.currentTimeMillis();
        output = radixSortDuplicateRemover.removeDuplicates(testArray);
        end = System.currentTimeMillis();

        printer.print("start: " + start);
        printer.print("end: " + end);
        printer.print("duration: " + (end - start) + " ms\n");


        printer.print("quicksort:");

        start = System.currentTimeMillis();
        output = quickSortDuplicateRemover.removeDuplicates(testArray);
        end = System.currentTimeMillis();

        printer.print("start: " + start);
        printer.print("end: " + end);
        printer.print("duration: " + (end - start) + " ms\n");
    }
}
