package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/11/14
 * @description: num 1252
 */
public class OddCells {

    public int oddCells4(int n, int m, int[][] indices) {
        //leetcode上的解法
        //利用了只有1奇1偶相加才为奇数，当line[i]为奇数时，column数组中有多少个偶数，那么第i行就会有多少个奇数
        int[] line = new int[n];
        int[] column = new int[m];
        for (int i = 0; i < indices.length; i++) {
            line[indices[i][0]]++;
            column[indices[i][1]]++;
        }
        int count = 0;
        int odds = 0;
        for (int j = 0; j < m; j++) {
            if (column[j] % 2 != 0) odds++;
        }
        for (int i = 0; i < n; i++) {
            if (line[i] % 2 != 0) count = count + (m - odds);
            else count = count + odds;
        }
        return count;
    }

    public int oddCells3(int n, int m, int[][] indices) {
        //对方法2进行了优化，不用初始化矩阵，直接根据line，column数组求出矩阵中相应位置对应的值
        int[] line = new int[n];
        int[] column = new int[m];
        for (int i = 0; i < indices.length; i++) {
            line[indices[i][0]]++;
            column[indices[i][1]]++;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((line[i] + column[j]) % 2 != 0) count++;
            }
        }
        return count;
    }

    public int oddCells2(int n, int m, int[][] indices) {
        //对方法1进行了一定的优化，先求出每行和每列要加1的次数，而后再分别相加
        int[][] map = new int[n][m];
        int[] line = new int[n];
        int[] column = new int[m];
        for (int i = 0; i < indices.length; i++) {
            line[indices[i][0]]++;
            column[indices[i][1]]++;
        }
        for (int i = 0; i < line.length; i++) {
            if (line[i] != 0) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = map[i][j] + line[i];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < column.length; i++) {
            for (int j = 0; j < n; j++) {
                map[j][i] = map[j][i] + column[i];
                if (map[j][i] % 2 != 0) count++;
            }
        }
        return count;
    }

    public int oddCells(int n, int m, int[][] indices) {
        //暴力解
        int[][] map = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < m; j++) {
                map[indices[i][0]][j] = map[indices[i][0]][j] + 1;
            }
            for (int j = 0; j < n; j++) {
                map[j][indices[i][1]] = map[j][indices[i][1]] + 1;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] % 2 != 0) count++;
            }
        }
        return count;
    }

}
