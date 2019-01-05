package basic.solution;

/**
 * 转圈打印矩阵
 * 1    2   3   4
 * 5    6   7   8
 * 9    10  11  12
 * 13   14  15  16
 *
 * →    →   →   →
 * ↑    →   →   ↓
 * ↑    ↑   ↓   ↓
 * ↑    ←   ↓   ↓
 * ←    ←   ←   ←
 *
 * 打印结果
 * 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 *
 * @author bingo
 */
public class SpiralOrderPrintMatrix {

    public static void spiralOrderPrint(int[][] matrix) {
        int lx = 0; // 左上角横坐标
        int ly = 0; // 左上角纵坐标
        int rx = matrix.length - 1; // 右下角横坐标
        int ry = matrix[0].length - 1; // 右下角纵坐标

        while (lx <= rx && ly <= ry) {
            // 先打印外圈，再打印内圈，由外往里
            printEdge(matrix, lx++, ly++, rx--, ry--);
        }

    }

    private static void printEdge(int[][] matrix, int lx, int ly, int rx, int ry) {
        if (lx == rx) {
            for (int i = ly; i <= ry; ++i) {
                System.out.print(matrix[lx][i] + " ");
            }
        } else if (ly == ry) {
            for (int i = lx; i <= rx; ++i) {
                System.out.print(matrix[i][ly] + " ");
            }
        } else {
            for (int i = ly; i < ry; ++i) {
                System.out.print(matrix[lx][i] + " ");
            }

            for (int i = lx; i < rx; ++i) {
                System.out.print(matrix[i][ry] + " ");
            }

            for (int i = ry; i > ly; --i) {
                System.out.print(matrix[rx][i] + " ");
            }

            for (int i = rx; i > lx; --i) {
                System.out.print(matrix[i][ly] + " ");
            }
        }
    }

    // for test
    /*public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        spiralOrderPrint(matrix);
    }*/

}
