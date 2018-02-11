package lt.demo.task2_3.service;

import lt.demo.task2_3.service.def.RectangleShape;

/**
 * Class, that is responsible for constructing a printable rectangle array of desired width and height.
 */
public class RectangleShapeImpl implements RectangleShape {
    // Unicode values of required symbols.
    private static final char SQUARE = 0x25FB;

    private static final char VERTICAL_BOX_LINE = 0x2758;
    private static final char HORIZONTAL_BOX_LINE = 0x2500;
    private static final char TOP_LEFT_VERTEX = 0x250C;
    private static final char BOTTOM_LEFT_VERTEX = 0x2514;
    private static final char TOP_RIGHT_VERTEX = 0x2510;
    private static final char BOTTOM_RIGHT_VERTEX = 0x2518;

    private static final char RIGHT_BOX_LINE = 0x23B9;

    private static final char UNDERSCORE = 0x005F;
    private static final char UPPERSCORE = 0x203E;

    /**
     * Method, that constructs a printable char array to represent a rectangle of desired width and height.
     * @param length
     * @param width
     * @return
     */
    @Override
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

        // regular case
        return fillArray(length, width);
    }

    /**
     * Special case, when rectangle width is equal to 1.
     * @param length of a rectangle
     * @return array, that represents rectangle.
     */
    private char [][] fillArrayWidthEqOne(int length) {
        length = length + 2;
        char [][] rectangle = new char[2][length];

        rectangle[1][0] = VERTICAL_BOX_LINE;
        rectangle[1][length - 1] = VERTICAL_BOX_LINE;

        for (int i = 1; i < length - 1; i++) {
            rectangle[0][i] = UNDERSCORE;
            rectangle[1][i] = UNDERSCORE;
        }

        return rectangle;
    }

    /**
     * Special case, when length equals to 1.
     * @param width of a rectangle
     * @return array, that represents rectangle.
     */
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

    /**
     * Fills array to represent a rectangle, which width and height is more than 1.
     * @param length of a rectangle
     * @param width of a rectangle
     * @return array, that represents rectangle.
     */
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

    // Utility functions.

    private char getEdgeSymbol(int i, int j, int width, int height) {
        if (i == 0 || i == height) {
            return HORIZONTAL_BOX_LINE;
        }

        return VERTICAL_BOX_LINE;
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
