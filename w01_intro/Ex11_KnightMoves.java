package teme.w01_intro;

class Ex11_KnightMoves {

    /**
     * Check if a given position is valid (within the bounds of a 8x8 chess table)
     *
     * @param row row number (valid range: 1..8)
     * @param col column number (valid range: 1..8)
     * @return true if both row and col values are in valid range, false otherwise
     */
    static boolean isValidPos(int row, int col) {

        return row <= 8 && row >= 1 && col <= 8 && col >= 1 ? true : false;
    }

    /**
     * Starting from a current position (row+column) and a given piece movement on table
     * (specified as a number of rows to move, and a number of columns, relative to current pos)
     * it will compute and return the destination position, encoded as a single String value.
     * <p>
     * If either the current or the destination position are invalid (outside the table)
     * it will return instead just an empty string.
     *
     * @param crtRow     current row (valid range: 1..8)
     * @param crtCol     current column (valid range: 1..8)
     * @param rowsToMove number of rows to move (a positive or negative number)
     * @param colsToMove number of rows to move (a positive or negative number)
     * @return the destination position as a string with format "(row,col)",
     * or empty string if source or destination positions are invalid
     */
    static String getDestinationIfValid(int crtRow, int crtCol,
                                        int rowsToMove, int colsToMove) {

        int isDestinationValidRow = crtRow + rowsToMove;
        int isDesinationValidCol = crtCol + colsToMove;
        boolean position = isValidPos(crtRow, crtCol);
        String isValid = position == true && isDesinationValidCol <= 8 && isDesinationValidCol >= 1 && isDestinationValidRow <= 8
                && isDestinationValidRow >= 1 ? "(" + String.valueOf(isDestinationValidRow) + "," + String.valueOf(isDesinationValidCol) + ")" : "";
        return isValid;
    }

    static String eachPosition(int x, int y, int crtRow, int crtCol) {

        int row = x + crtRow;
        int col = y + crtCol;
        String destination = row <= 8 && row >= 1 && col <= 8 && col >= 1 && crtCol <= 8 && crtCol >= 1 && crtRow <= 8 && crtRow >= 1 ?
                "(" + String.valueOf(row) + "," + String.valueOf(col) + ")" : "";
        return destination;
    }

    /**
     * Given the current position of a knight (row+column), it will compute and return
     * the list of all VALID possible destinations to reach in 1 valid knight move.
     *
     * @param crtRow current row
     * @param crtCol current column
     * @return list of all valid destinations, in format "(row1,col1)(row2,col2)...(rowN,colN)"
     * (order of the destination cells doesn't count)
     */
    static String getAllValidDestinations(int crtRow, int crtCol) {

        return eachPosition(1, 2, crtRow, crtCol) + eachPosition(2, 1, crtRow, crtCol) + eachPosition(2, -1, crtRow, crtCol) +
                eachPosition(1, -2, crtRow, crtCol) + eachPosition(-1, -2, crtRow, crtCol) + eachPosition(-2, -1, crtRow, crtCol) +
                eachPosition(-2, 1, crtRow, crtCol) + eachPosition(-1, 2, crtRow, crtCol);
    }

    /**
     * Main, just for running manual tests
     */
    public static void main(String[] args) {
        System.out.println(isValidPos(1, 9));
        System.out.println(isValidPos(2, 4));

        System.out.println(getDestinationIfValid(1, 1, -2, +1));
        System.out.println(getDestinationIfValid(1, 1, +2, +1));

        System.out.println(getAllValidDestinations(1, 1));
        System.out.println(getAllValidDestinations(2, 4));
    }
}
