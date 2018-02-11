package lt.demo.task2_1.service.def;

import java.util.Collection;

public interface Formatter {
    void append(String msg, Collection<Integer> index);
    String getFormattedText();
    void clear();
}
