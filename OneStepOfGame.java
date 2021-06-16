public class OneStepOfGame {

    public int countingReps(int[] aRandomArray, int searchingValue) {

        int count = 0;

        for (int i = 0; i < aRandomArray.length; i++) {

            Integer firstValue = aRandomArray[i];
            Integer secondValue = searchingValue;

            if (firstValue.equals(secondValue))
                count++;
        }

        return count;
    }

    public int[][] oneStepOfGame(int[][] aRandomArray, int aNumberOfRows, int aNumberOfColumns) {

        int[][] oneStepOfGameArray = new int[aNumberOfRows][aNumberOfColumns];
        CalculateNeighbors cn = new CalculateNeighbors();

        for (int i = 0; i < aNumberOfRows; i++) {
            for (int j = 0; j < aNumberOfColumns; j++) {

                oneStepOfGameArray[i][j] = aRandomArray[i][j];
            }
        }

        for (int i = 1; i < aNumberOfRows - 1; i++) {
            for (int j = 1; j < aNumberOfColumns - 1; j++) {

                int aPoint = i * aNumberOfColumns + j;
                int[] neighbors = cn.findNeighborsCentralArea(aPoint, aRandomArray, aNumberOfRows, aNumberOfColumns);

                if ((countingReps(neighbors, 1) + countingReps(neighbors, 2)) > 4 ||
                        (countingReps(neighbors, 1) + countingReps(neighbors, 2)) < 2) {

                    oneStepOfGameArray[i][j] = 0;

                } else if ((countingReps(neighbors, 0) == 4)
                        && (countingReps(neighbors, 2) != 2))

                    oneStepOfGameArray[i][j] = 0;

                else if ((countingReps(neighbors, 1) + countingReps(neighbors,
                        2)) == 3 && oneStepOfGameArray[i][j] == 0) {

                    if (countingReps(neighbors, 1) == 1)
                        oneStepOfGameArray[i][j] = 1;
                    else
                        oneStepOfGameArray[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < aNumberOfColumns; i++) {

            int[] neighborsTop = cn.findNeighborsTopArea(i, aRandomArray, aNumberOfRows, aNumberOfColumns);
            int[] neighborsButtom = cn.findNeighborsButtomArea(i, aRandomArray, aNumberOfRows, aNumberOfColumns);

            if ((countingReps(neighborsTop, 1) + countingReps(neighborsTop, 2)) > 4 ||
                    (countingReps(neighborsTop, 1) + countingReps(neighborsTop, 2)) < 2) {

                oneStepOfGameArray[0][i] = 0;

            } else if ((countingReps(neighborsTop, 0) == 4)
                    && (countingReps(neighborsTop, 2) != 2))

                oneStepOfGameArray[0][i] = 0;

            else if ((countingReps(neighborsTop, 1) + countingReps(neighborsTop,
                    2)) == 3 && oneStepOfGameArray[0][i] == 0) {

                if (countingReps(neighborsTop, 1) == 1)
                    oneStepOfGameArray[0][i] = 1;
                else
                    oneStepOfGameArray[0][i] = 2;
            }

            if ((countingReps(neighborsButtom, 1) + countingReps(neighborsButtom, 2)) > 4 ||
                    (countingReps(neighborsButtom, 1) + countingReps(neighborsButtom, 2)) < 2) {

                oneStepOfGameArray[aNumberOfRows-1][i] = 0;

            } else if ((countingReps(neighborsButtom, 0) == 4)
                    && (countingReps(neighborsButtom, 2) != 2))

                oneStepOfGameArray[aNumberOfRows-1][i] = 0;

            else if ((countingReps(neighborsButtom, 1) + countingReps(neighborsButtom,
                    2)) == 3 && oneStepOfGameArray[aNumberOfRows-1][i] == 0) {

                if (countingReps(neighborsButtom, 1) == 1)
                    oneStepOfGameArray[aNumberOfRows-1][i] = 1;
                else
                    oneStepOfGameArray[aNumberOfRows-1][i] = 2;
            }
        }

        for (int i = 0; i < aNumberOfRows-1; i++) {

            int[] neighborsLeft = cn.findNeighborsLeftArea(i, aRandomArray, aNumberOfRows, aNumberOfColumns);
            int[] neighborsRight = cn.findNeighborsRightArea(i, aRandomArray, aNumberOfRows, aNumberOfColumns);

            if ((countingReps(neighborsLeft, 1) + countingReps(neighborsLeft, 2)) > 4 ||
                    (countingReps(neighborsLeft, 1) + countingReps(neighborsLeft, 2)) < 2) {

                oneStepOfGameArray[i][0] = 0;

            } else if ((countingReps(neighborsLeft, 0) == 4)
                    && (countingReps(neighborsLeft, 2) != 2))

                oneStepOfGameArray[i][0] = 0;

            else if ((countingReps(neighborsLeft, 1) + countingReps(neighborsLeft,
                    2)) == 3 && oneStepOfGameArray[i][0] == 0) {

                if (countingReps(neighborsLeft, 1) == 1)
                    oneStepOfGameArray[i][0] = 1;
                else
                    oneStepOfGameArray[i][0] = 2;
            }

            if ((countingReps(neighborsRight, 1) + countingReps(neighborsRight, 2)) > 4 ||
                    (countingReps(neighborsRight, 1) + countingReps(neighborsRight, 2)) < 2) {

                oneStepOfGameArray[i][aNumberOfColumns-1] = 0;

            } else if ((countingReps(neighborsRight, 0) == 4)
                    && (countingReps(neighborsRight, 2) != 2))

                oneStepOfGameArray[i][aNumberOfColumns-1] = 0;

            else if ((countingReps(neighborsRight, 1) + countingReps(neighborsRight,
                    2)) == 3 && oneStepOfGameArray[i][aNumberOfColumns-1] == 0) {

                if (countingReps(neighborsRight, 1) == 1)
                    oneStepOfGameArray[i][aNumberOfColumns-1] = 1;
                else
                    oneStepOfGameArray[i][aNumberOfColumns-1] = 2;
            }
        }
        return oneStepOfGameArray;
    }
}