package lt.demo.task2_3;

import lt.demo.task2_3.service.RectangleShapeImpl;
import lt.demo.task2_3.service.def.RectangleShape;
import lt.demo.task2_3.service.printer.RectanglePrinter;
import lt.demo.task2_3.service.scaner.ConsoleScanner;

import java.util.InputMismatchException;

/**
 * Main class to show off functionality. Asks for input and prints rectangle.
 */
public class RectanglePrinterMain {

    public static void main(String[] args) {
        RectanglePrinter rectanglePrinter = new RectanglePrinter(true);
        ConsoleScanner scanner = new ConsoleScanner();

        rectanglePrinter.print("Hi, please input width and height:");

        int length;
        int width;

        try {
            width = scanner.getInt();
            length = scanner.getInt();
        } catch (InputMismatchException e) {
            rectanglePrinter.print("Wrong input.");
            return;
        }

        rectanglePrinter.print("OK. So there is your rectangle:");
        rectanglePrinter.print(null);

        RectangleShape rectangleShape = new RectangleShapeImpl();
        char[][] printableArray = rectangleShape.getPrintableArray(length, width);

        rectanglePrinter.printRectangle(printableArray);

        rectanglePrinter.print("\nInput any number to exit.");
        scanner.getInt();
    }
}
