package ru.mail.track.ui11.hw03.task02;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тест-класс позитивных тестов к задаче №2
 */
public class MatrixRowSortPositiveTest {

    @Test
    public void sortRowsOfMatrixOneByOne() {
        int[][] matrix = new int[][]{{0}};
        int[][] expectedMatrix = new int[][]{{0}};
        matrix = MatrixRowsSort.sortMatrixRowsBySumDesc(matrix);
        Assert.assertThat(matrix, Matchers.equalTo(expectedMatrix));
    }

    @Test
    public void sortRowsOfMatrixWithOneColumn() {
        int[][] matrix = new int[][]{{3}, {2}, {9}, {4}, {7}};
        int[][] expectedMatrix = new int[][]{{2}, {3}, {4}, {7}, {9}};
        matrix = MatrixRowsSort.sortMatrixRowsBySumDesc(matrix);
        Assert.assertThat(matrix, Matchers.equalTo(expectedMatrix));
    }

    @Test
    public void sortRowsOfMatrixWithOneRow() {
        int[][] matrix = new int[][]{{3, 7, 2, 5, 8}};
        int[][] expectedMatrix = new int[][]{{3, 7, 2, 5, 8}};
        matrix = MatrixRowsSort.sortMatrixRowsBySumDesc(matrix);
        Assert.assertThat(matrix, Matchers.equalTo(expectedMatrix));
    }

    @Test
    public void sortRowsOfCorrectThreeByOneMatrix() {
        int[][] matrix = new int[][]
                {{40, 99},
                {58, 14},
                {16, 49}};

        int[][] expectedMatrix = new int[][]
                {{16, 49},
                {58, 14},
                {40, 99}};

        matrix = MatrixRowsSort.sortMatrixRowsBySumDesc(matrix);
        Assert.assertThat(matrix, Matchers.equalTo(expectedMatrix));
    }

    @Test
    public void sortRowsOfCorrectFourByFiveMatrix() {
        int[][] matrix = new int[][]
                {{16, 76, 28, 82},
                {85, 22, 84, 89},
                {58, 11, 59, 55},
                {40, 43, 24, 47},
                {13, 53, 61, 82}};

        int[][] expectedMatrix = new int[][]
                {{40, 43, 24, 47},
                {58, 11, 59, 55},
                {16, 76, 28, 82},
                {13, 53, 61, 82},
                {85, 22, 84, 89}};

        matrix = MatrixRowsSort.sortMatrixRowsBySumDesc(matrix);
        Assert.assertThat(matrix, Matchers.equalTo(expectedMatrix));
    }

}