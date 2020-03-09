package swordMeansOffer;

/**
 * 问题：从二维数组中查找到指定的数值
 *
 * 思路：每次都从最右边开始比较，如果值大于目标值，行号加1，如果值小于目标值，列号减1
 * */
public class TwoDimenArray {

    public boolean find(int target, int [][] array){
        int row = array.length;
        int column = array[0].length;
        int i = 0;
        int j = column-1;
        while (i<row&j>=0){
            if (array[i][j]==target){
                return true;
            }
            if (array[i][j]<target){
                i = i + 1;
                continue;
            }
            if (array[i][j]>target){
                j = j-1;
            }

        }
        return false;
    }

    public static void main(String[] args) {

    }

}
