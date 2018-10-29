package ru.mail.track.ui11.hw03.task02;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест-класс негативных тестов к задаче №2
 */
public class MatrixRowSortNegativeTest {

    @Test(expected = NullPointerException.class)
    public void sortRowsOfNull() {
        int[][] matrix = null;

        MatrixRowsSort.sortMatrixRowsBySumDesc(matrix);
    }

    @Test(expected = NullPointerException.class)
    public void sortRowsOfNonInitTwoDimArray() {
        int[][] matrix = new int[5][];

        MatrixRowsSort.sortMatrixRowsBySumDesc(matrix);
    }

    @Test
    public void sortRowsOfDefaultInitMatrix() {
        int[][] matrix = new int[5][8];
        int[][] expectedMatrix = new int[][]
                {{0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}};

        matrix = MatrixRowsSort.sortMatrixRowsBySumDesc(matrix);
        Assert.assertThat(matrix, Matchers.equalTo(expectedMatrix));
    }

    @Test
    public void sortRowsOfEmptyMatrix() {
        int[][] matrix = new int[][]{{}, {}, {}};
        int[][] expectedMatrix = new int[][]{{}, {}, {}};

        matrix = MatrixRowsSort.sortMatrixRowsBySumDesc(matrix);
        Assert.assertThat(matrix, Matchers.equalTo(expectedMatrix));
    }

    @Test(expected = MatrixException.class)
    public void sortRowsOfTwoDimArray() {
        int[][] matrix = new int[][]
                {{63, 26, 69, 75},
                {93, 45},
                {58, 11, 75},
                {77, 43, 24, 99},
                {18, 54, 76, 33}};
        MatrixRowsSort.sortMatrixRowsBySumDesc(matrix);
    }

}
