package lt.demo.task2_3.service.scaner;

import lt.demo.task2_3.service.def.Scanner;

public class ConsoleScanner implements Scanner {
    protected java.util.Scanner scanner = new java.util.Scanner(System.in);

    @Override
    public int getInt() {
        return scanner.nextInt();
    }
}
