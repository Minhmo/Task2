package lt.demo.task2_2.service.def;

public interface Formatter {
    void append(String msg, int depth, int index);
    String getFormattedText();
}
