package lt.demo.task2_1.service.printer;

import lt.demo.task2_1.service.def.Printer;

/**
 * Responsible for printing content in console
 */
public class ConsolePrinter implements Printer{
    public void print(String string) {
        System.out.println(string);
    }
}
