package lt.demo.tests.test;

import lt.demo.task2_2.service.QuickSortDuplicateRemover;
import lt.demo.task2_2.service.RadixSortDuplicateRemover;
import lt.demo.task2_2.service.def.DuplicateRemover;
import lt.demo.task2_2.service.def.Printer;
import lt.demo.task2_2.service.printer.ConsolePrinter;
import lt.demo.task2_2.service.sort.Radix;
import lt.demo.tests.generator.ArrayGenerator;

import java.util.*;

public class DuplicatesTests extends TestBase {
    public static final int NO_OF_TESTS = 100;
    private ArrayGenerator generator = new ArrayGenerator();
    private Printer printer = new ConsolePrinter();

    @Override
    public void run() {
        testRadixSort();
        quickCheckDuplicateRemovalQuickSort();
        quickCheckDuplicateRemovalRadixSort();
    }

    private void testRadixSort() {
        printer.print("starting test for radix sort.");

        int[] array = {1, 5, 3, 2, 5, 6, 6, 7, 33, 1, 2, 3};
        int[] arrayCopy = Arrays.copyOf(array, array.length);

        Radix.radixsort(array, array.length);
        Arrays.sort(arrayCopy);

        assert Arrays.equals(array, arrayCopy);

        printer.print("Success!");
    }

    private void quickCheckDuplicateRemovalQuickSort() {
        printer.print("starting quickcheck with quick sort for duplicate removal.");
        DuplicateRemover remover = new QuickSortDuplicateRemover();

        long start = System.currentTimeMillis();

        executeQuickCheck(remover, false);

        long end = System.currentTimeMillis();

        printer.print("Whole test duration: " +  (end - start) + " ms.");
        printer.print("Success!\n");
    }

    private void quickCheckDuplicateRemovalRadixSort() {
        printer.print("starting quickcheck with radix sort for duplicate removal.");
        DuplicateRemover remover = new RadixSortDuplicateRemover();

        long start = System.currentTimeMillis();

        executeQuickCheck(remover, true);

        long end = System.currentTimeMillis();

        printer.print("Whole test duration: " +  (end - start) + " ms.");
        printer.print("Success!\n");
    }

    private void executeQuickCheck(DuplicateRemover remover, boolean onlyPositive) {
        Collection<int[]> arrays = generator.generateArraysForQuickCheck(NO_OF_TESTS, onlyPositive);

        for (int[] array : arrays) {
            int[] arrayWithoutDuplicates = remover.removeDuplicates(array);
            ArrayList<Integer> collection = new ArrayList<Integer>() {{
                for (int i : array) add(i);
            }};

            // it is known and tested, that Java sets removes duplicates. So we make use of that.
            Collection<Integer> collectionWithoutDuplicatesForSure = new HashSet<Integer>(collection);

            assert arrayWithoutDuplicates.length ==
                    collectionWithoutDuplicatesForSure.size() : "Collection sizes dos not match!";
        }
    }
}
