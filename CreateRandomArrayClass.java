public class CreateRandomArrayClass {

    public  int [][] setRandomArray (int rows, int columns) {

        int [][] aRandomArray = new int[rows][columns];
        int count = 0;

        for (int i=0; i < aRandomArray.length; i++) {
            for (int j=0; j < aRandomArray[i].length; j++){
                count = (int) (Math.random() * 3);
                aRandomArray[i][j] = count;
            }
        }

        return aRandomArray;
    }
}