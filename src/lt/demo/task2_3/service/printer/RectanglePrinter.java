package lt.demo.task2_3.service.printer;

public class RectanglePrinter extends ConsolePrinter {
    public static final char WHITE_SPACE = ' ';
    public static final char THIN_SPACE = 0x2006;

    private boolean putWhitespaceBetweenChars = true;

    public RectanglePrinter(boolean putWhitespaceBetweenChars) {
        this.putWhitespaceBetweenChars = putWhitespaceBetweenChars;
    }

    /**
     * Method, that prints two dimentional char array to stdout.
     * @param rectangle two dimensional char array
     */
    public void printRectangle(char[][] rectangle) {
        writer.flush();

        int width = rectangle[0].length;
        int height = rectangle.length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (rectangle[i][j] == 0x0) {
                    rectangle[i][j] = THIN_SPACE;
                }

                writer.printf("%c", rectangle[i][j]);

                if (putWhitespaceBetweenChars) {
                    writer.print(THIN_SPACE);
                }
            }

            writer.println();
        }

        writer.flush();
    }

    /**
     * Some consoles, or terminals introduce a little bit of space between vertical dashes,
     * in order to compensate that, one could use spaces between
     * @param putWhitespaceBetweenChars
     */
    public void setPutWhitespaceBetweenChars(boolean putWhitespaceBetweenChars) {
        this.putWhitespaceBetweenChars = putWhitespaceBetweenChars;
    }
}
