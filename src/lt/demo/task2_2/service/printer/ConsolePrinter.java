package lt.demo.task2_2.service.printer;

import lt.demo.task2_2.service.def.Printer;

/**
 * Responsible for printing content in console
 */
public class ConsolePrinter implements Printer {
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public void printInline(String string) {
        System.out.print(string);
    }
}
