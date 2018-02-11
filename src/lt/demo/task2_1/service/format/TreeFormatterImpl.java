package lt.demo.task2_1.service.format;

import lt.demo.task2_1.service.def.Formatter;
import lt.demo.task2_1.service.def.NumberFormat;

import java.util.Collection;

/**
 * Class, rensponsible for formating the nodes of the tree for printing.
 */
public class TreeFormatterImpl implements Formatter {
    private NumberFormat numberFormat;
    private StringBuilder sb = new StringBuilder();

    public TreeFormatterImpl(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    @Override
    public void append(String msg, Collection<Integer> index) {
        int depth = index.size() - 1;
        appendTabs(depth);
        appendIndex(index);

        sb.append(msg);
        sb.append('\n');
    }

    public String getFormattedText() {
        String text = sb.toString();
        sb = new StringBuilder();

        return text;
    }

    private void appendIndex(Collection<Integer> index) {
        for (Integer number : index) {
            sb.append(numberFormat.get(number));
        }
    }

    private void appendTabs(int depth) {
        for (int i = 0; i < depth; i++) {
            sb.append('\t');
        }
    }

    public void clear() {
        sb = new StringBuilder();
    }
}
