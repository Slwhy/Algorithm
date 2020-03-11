package leetcode;

import java.lang.reflect.Array;

/**
 * @author: slwhy
 * @date: 2020/3/11
 * @description: 1013. 将数组分成和相等的三个部分
 */
public class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
        }
        if (sum % 3 != 0) return false;
        int target = sum / 3;
        sum = 0;
        int cout = 0;
        for (int i = 0; i < A.length - 1; i++) {
            sum = sum + A[i];
            if (sum == target) {
                cout++;
                sum = 0;
            }
            if (cout == 2) return true;
        }
        return false;
    }
}
