package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/3/29
 * @description: 5369. 统计作战单位数
 */
public class NumTeams {
    public int numTeams(int[] rating) {
        int count = 0;
        if (rating.length < 3) return count;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int m = j + 1; m < rating.length; m++) {
                    if (rating[i] > rating[j] && rating[j] > rating[m]) count++;
                    if (rating[i] < rating[j] && rating[j] < rating[m]) count++;
                }
            }
        }
        return count;
    }
}
