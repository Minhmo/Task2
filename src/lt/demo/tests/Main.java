package lt.demo.tests;

import lt.demo.task2_1.service.factory.NumberFormatterFactory;
import lt.demo.tests.test.DuplicatesTests;
import lt.demo.tests.test.TestBase;
import lt.demo.tests.test.TreeTests;

import java.util.Arrays;
import java.util.List;

/**
 * Test runner class.
 * Register new tests in tests list.
 */
public class Main {

    public static void main(String[] args) {
        List<TestBase> tests = Arrays.asList(new TreeTests(new NumberFormatterFactory()), new DuplicatesTests());

        for (TestBase test : tests) {
            test.run();
        }
    }

}
