package lt.demo.task2_1.service.format;

import lt.demo.task2_1.service.def.Formatter;

/**
 * Class, rensponsible for formating the nodes of the tree for printing.
 */
public class TreeFormatter implements Formatter {

    private StringBuilder sb = new StringBuilder();

    @Override
    public void append(String msg, int depth, int index) {
        appendTabs(depth);
        appendIndex(index);

        sb.append(msg);
        sb.append('\n');
    }

    public String getFormattedText() {
        return sb.toString();
    }

    private void appendIndex(int index) {
        sb.append(index);
        sb.append(". ");
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
