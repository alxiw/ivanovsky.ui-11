package ru.mail.track.ui11.hw03.task02;

/**
 * Задача №2 - Сортировка строк матрицы
 *
 * Дан двумерный массив чисел (матрица)
 * Необходимо написать метод, который вернет двумерный массив
 * который сформирован по убыванию сумм строк переданного массива
 */
public class MatrixRowsSort {

    private MatrixRowsSort() {
        //private constructor
    }

    public static int[][] sortMatrixRowsBySumDesc(int[][] matrix) {
        if (isMatrixValid(matrix)) {
            for (int i = 0; i < matrix.length; i++) {
                for(int j = 1; j < (matrix.length - i); j++){
                    if (sumOfRow(matrix[j-1]) > sumOfRow(matrix[j])) {
                        int[] temp = matrix[j-1];
                        matrix[j-1] = matrix[j];
                        matrix[j] = temp;
                    }
                }
            }
            return matrix;
        } else {
            throw new MatrixException("This 2-D array is not a matrix");
        }
    }

    private static boolean isMatrixValid(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i].length != matrix[i + 1].length) {
                return false;
            }
        }
        return true;
    }

    private static int sumOfRow(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }
}
