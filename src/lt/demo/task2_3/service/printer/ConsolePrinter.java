package lt.demo.task2_3.service.printer;

import lt.demo.task2_3.service.def.Printer;

import java.io.PrintWriter;

/**
 * Responsible for printing content in console
 */
public class ConsolePrinter implements Printer {
    protected PrintWriter writer = new PrintWriter(System.out);

    public void print(String string) {
        if (string == null) {
            System.out.println();
            return;
        }

        System.out.println(string);
    }

    @Override
    public void printInline(String string) {
        writer.print(string);
    }

    public void printFormated(String format, String text) {
        System.out.printf(format, text);
    }
    public void printFormated(String format, char text) {
        System.out.printf(format, text);
    }
}
