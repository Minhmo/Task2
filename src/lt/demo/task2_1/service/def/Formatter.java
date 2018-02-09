package lt.demo.task2_1.service.def;

public interface Formatter {
    void append(String msg, int depth, int index);
    String getFormattedText();
    void clear();
}
