package lt.demo.task2_1.service.factory;

import lt.demo.task2_1.service.def.Formatter;
import lt.demo.task2_1.service.def.FormatterFactory;
import lt.demo.task2_1.service.format.IntegerNumberFormat;
import lt.demo.task2_1.service.format.TreeFormatterImpl;

public class NumberFormatterFactory implements FormatterFactory{
    @Override
    public Formatter getFormatter() {
        return new TreeFormatterImpl(new IntegerNumberFormat());
    }
}
