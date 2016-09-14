package study.leet.fun;


import java.util.ArrayList;
import java.util.List;

/**
 * @author teng.qian
 * @date 2016/3/13.
 */
public class SpireMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;
        int column = matrix[0].length;
        return travelMatrix(matrix, 0, rows - 1, 0, column - 1, result);
    }

    private List<Integer> travelMatrix(int[][] matrix, int endRows, int rows, int startColumn, int column, List<Integer> result) {

        if (endRows > rows || startColumn > column) {
            return result;
        }

        int j = startColumn;
        int i = endRows;

        while (j <= column) {
            result.add(matrix[i][j++]);
        }
        j--;
        i++;
        if (i > rows) {
            return result;
        }

        while (i <= rows) {
            result.add(matrix[i++][j]);
        }
        j--;
        i--;
        if (j < startColumn) {

            return result;
        }

        while (j >= startColumn) {
            result.add(matrix[i][j--]);
        }

        j++;
        i--;
        if (i < endRows + 1) {

            return result;
        }
        while (i >= endRows + 1) {
            result.add(matrix[i--][j]);
        }
        return travelMatrix(matrix, endRows + 1, rows - 1, startColumn + 1, column - 1, result);
    }

    public static void main(String[] args) {
        SpireMatrix sp = new SpireMatrix();
        int[][] matrix = {
                //{1, 2, 3, 4, 112},
                //{5, 6, 7, 8, 113},
                //{9, 10, 11, 12, 1},
                //{13, 14, 15, 16, 2}
                {1}
        };
        for (Integer integer : sp.spiralOrder(matrix)) {
            System.out.print(integer + ",");
        }
    }
}
