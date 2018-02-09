package lt.demo.task2_3.service;

public class RectangleShape {
    // char's of unicode vertices.
    private static final char SQUARE = 0x25FB;

    private static final char VERTICAL_BOX = 0x2758;
    private static final char HORIZONTAL_BOX = 0x2500;
    private static final char TOP_LEFT_VERTEX = 0x250C;
    private static final char BOTTOM_LEFT_VERTEX = 0x2514;
    private static final char TOP_RIGHT_VERTEX = 0x2510;
    private static final char BOTTOM_RIGHT_VERTEX = 0x2518;

    public static final char LEFT_BOX_LINE = 0x23B8;
    public static final char RIGHT_BOX_LINE = 0x23B9;

    public static final char UNDERSCORE = 0x005F;
    public static final char UPPERSCORE = 0x203E;


    public char[][] getPrintableArray(int length, int width) {
        // handling special cases.
        if (length == 0 || width == 0) {
            throw new IllegalArgumentException("length or width cannot be zero.");
        } else if (length == width && length == 1){
            char[][] square = new char[1][1];
            square[0][0] = SQUARE;

            return  square;
        } else if (length == 1 && width != 1) {
            return fillArrayLengthEqOne(width);

        } else if (width == 1 && length != 1) {
            return fillArrayWidthEqOne(length);
        }
        return fillArray(length, width);
    }

    private char [][] fillArrayWidthEqOne(int length) {
        length = length + 2;
        char [][] rectangle = new char[2][length];

        rectangle[1][0] = VERTICAL_BOX;
        rectangle[1][length - 1] = VERTICAL_BOX;

        for (int i = 1; i < length - 1; i++) {
            rectangle[0][i] = UNDERSCORE;
            rectangle[1][i] = UNDERSCORE;
        }

        return rectangle;
    }

    private char [][] fillArrayLengthEqOne(int width) {
        width = width + 2;
        char [][] rectangle = new char[width][2];

        rectangle[0][1] = UNDERSCORE;
        rectangle[width - 1][ 1] = UPPERSCORE;

        for (int i = 1; i < width - 1; i++) {
            rectangle[i][0] = RIGHT_BOX_LINE;
            rectangle[i][1] = RIGHT_BOX_LINE;
        }

        return rectangle;
    }

    private char [][] fillArray(int length, int width) {
        length --;
        width--;

        char [][] rectangle = new char[width + 1][length + 1];

        for (int i = 0; i < width + 1; i++) {
            for (int j = 0; j < length + 1; j++) {

                //put corner characters on edges
                if (isVertex(i, j, length, width )) {
                    rectangle[i][j] = getVertexSymbol(i, j, length, width);
                } else if (isEdge(i, j, length, width)) {
                    rectangle[i][j] = getEdgeSymbol(i, j, length, width);
                }
            }
        }

        return rectangle;
    }

    private char getEdgeSymbol(int i, int j, int width, int height) {
        if (i == 0 || i == height) {
            return HORIZONTAL_BOX;
        }

        return VERTICAL_BOX;
    }

    private boolean isEdge(int i, int j, int width, int height) {
        return i == 0 || j == 0 || j == width || i == height;
    }

    private boolean isVertex(int i, int j, int width, int height) {
        return (i == 0 && j == 0) || (j == width && i == 0) || (i == height && j == width) || (j == 0 && i == height);
    }

    private char getVertexSymbol(int i, int j, int width, int height) {
        if (i == 0 && j == 0) {
            return TOP_LEFT_VERTEX;
        } else if (i == height && j == width) {
            return BOTTOM_RIGHT_VERTEX;
        } else if (j == width && i == 0) {
            return TOP_RIGHT_VERTEX;
        } else if (j == 0 && i == height) {
            return BOTTOM_LEFT_VERTEX;
        }

        return 0; // should never happen
    }
}
