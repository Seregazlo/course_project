public class CalculateNeighbors {

    private int[][] neighborXYOffsets = new int[][]{{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public int[] findNeighborsCentralArea(int aPoint, int[][] aRandomArray, int aNumberOfRows, int aNumberOfColumns) {

        int[] neighborOffsets = new int[]{-aNumberOfColumns - 1, -aNumberOfColumns, -aNumberOfColumns + 1, -1, 1, aNumberOfColumns - 1,
                aNumberOfColumns, aNumberOfColumns + 1};
        CreateOneDimensionalArray croda = new CreateOneDimensionalArray();

        int[] oneDimensionalArray = croda.createOneDimensionalArray(aRandomArray, aNumberOfRows, aNumberOfColumns);
        int[] aNeighborsArray = new int[8];

        for (int i = 0; i < 8; i++) {

            aNeighborsArray[i] = oneDimensionalArray[aPoint + neighborOffsets[i]];
        }

        return aNeighborsArray;
    }

    public int[] findNeighborsTopArea(int aXPosition, int[][] aRandomArray, int aNumberOfRows, int aNumberOfColumns) {

        int[] aNeighborsArray = new int[8];

        CreateOneDimensionalArray croda = new CreateOneDimensionalArray();
        int[] oneDimensionalArray = croda.createOneDimensionalArray(aRandomArray, aNumberOfRows, aNumberOfColumns);

        for (int i = 0; i < 8; i++) {
            int bx = (aXPosition + neighborXYOffsets[i][0] + aNumberOfColumns) % aNumberOfColumns;
            int by = (neighborXYOffsets[i][1] + aNumberOfRows) % aNumberOfRows;
            aNeighborsArray[i] = oneDimensionalArray[by * aNumberOfColumns + bx];
        }

        return aNeighborsArray;
    }

    public int[] findNeighborsButtomArea(int aXPosition, int[][] aRandomArray, int aNumberOfRows, int aNumberOfColumns) {

        int[] aNeighborsArray = new int[8];

        CreateOneDimensionalArray croda = new CreateOneDimensionalArray();
        int[] oneDimensionalArray = croda.createOneDimensionalArray(aRandomArray, aNumberOfRows, aNumberOfColumns);

        for (int i = 0; i < 8; i++) {
            int bx = (aXPosition + neighborXYOffsets[i][0] + aNumberOfColumns) % aNumberOfColumns;
            int by = ((aNumberOfRows -1) + neighborXYOffsets[i][1] + aNumberOfRows) % aNumberOfRows;
            aNeighborsArray[i] = oneDimensionalArray[by * aNumberOfColumns + bx];
        }

        return aNeighborsArray;
    }

    public int[] findNeighborsLeftArea(int aYPosition, int[][] aRandomArray, int aNumberOfRows, int aNumberOfColumns) {

        int[] aNeighborsArray = new int[8];
        CreateOneDimensionalArray croda = new CreateOneDimensionalArray();
        int[] oneDimensionalArray = croda.createOneDimensionalArray(aRandomArray, aNumberOfRows, aNumberOfColumns);

        for (int i = 0; i < 8; i++) {

            int bx = (neighborXYOffsets[i][0] + aNumberOfColumns) % aNumberOfColumns;
            int by = (aYPosition + neighborXYOffsets[i][1] + aNumberOfRows) % aNumberOfRows;
            aNeighborsArray[i] = oneDimensionalArray[by * aNumberOfColumns + bx];

        }

        return aNeighborsArray;
    }


    public int[] findNeighborsRightArea(int aYPosition, int[][] aRandomArray, int aNumberOfRows, int aNumberOfColumns) {

        int[] aNeighborsArray = new int[8];
        CreateOneDimensionalArray croda = new CreateOneDimensionalArray();
        int[] oneDimensionalArray = croda.createOneDimensionalArray(aRandomArray, aNumberOfRows, aNumberOfColumns);

        for (int i = 0; i < 8; i++) {

            int bx = ((aNumberOfColumns-1) + neighborXYOffsets[i][0] + aNumberOfColumns) % aNumberOfColumns;
            int by = (aYPosition + neighborXYOffsets[i][1] + aNumberOfRows) % aNumberOfRows;
            aNeighborsArray[i] = oneDimensionalArray[by * aNumberOfColumns + bx];

        }
        return aNeighborsArray;
    }
}
