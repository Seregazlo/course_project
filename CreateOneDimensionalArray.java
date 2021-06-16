/*
Преобразование двумерного массива в одномерный. При копировании матрицы A размером M на N необходим одномерный массив B
размером M*N. Очевидно, что при копировании по строкам (сначала первая строка, затем вторая  и  т.д.) элемент первой строки
A[0][j] надо скопировать в B[j], элементы второй строки A[1][j]  в  B[N+j]  и  т.д.
Отсюда  следует,  что  для  любой  строки  i  элемент  A[i][j]  копируется  в B[i*N+j]. Сам цикл копирования выглядит так:

for ( i = 0; i < M; i ++ )

  for ( j = 0; j < N; j ++ )

     B[i*N+j] = A[i][j];

*/

public class CreateOneDimensionalArray {

    public int[] createOneDimensionalArray (int[][] aArray, int aNumberOfRows, int aNumberOfColumns) {

        int[] oneDimensionalArray = new int[aNumberOfRows * aNumberOfColumns];

        for (int counter_rows = 0; counter_rows < aNumberOfRows; counter_rows++) {
            for (int counter_columns = 0; counter_columns < aNumberOfColumns; counter_columns++) {
                oneDimensionalArray[counter_rows * aNumberOfColumns + counter_columns] = aArray[counter_rows][counter_columns];
            }
        }

        return oneDimensionalArray;
    }
}
