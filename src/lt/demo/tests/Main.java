package lt.demo.tests;

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
        Class<?>[] classes = TestBase.class.getClasses();
        List<TestBase> tests = Arrays.asList(new TreeTests(), new DuplicatesTests());

        for (TestBase test : tests) {
            test.run();
        }
    }

}
