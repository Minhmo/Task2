package lt.demo.task2_1.service.format;

import lt.demo.task2_1.service.def.NumberFormat;

public class IntegerNumberFormat implements NumberFormat {
    private final static String FORMAT = "%d. ";

    @Override
    public String get(int number) {
        return String.format(FORMAT, number);
    }
}
