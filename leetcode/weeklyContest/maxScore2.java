package leetcode.weeklyContest;

/**
 * @author: slwhy
 * @date: 2020/4/26
 * @description: 5393. 可获得的最大点数
 */
public class maxScore2 {
    int res = Integer.MIN_VALUE;

    public int maxScore(int[] cardPoints, int k) {

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        for (int i = 0; i < k; i++) {
            sum = sum - cardPoints[k - 1 - i] + cardPoints[cardPoints.length - 1 - i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public void helper(int[] cardPoints, int left, int right, int count, int k, int sum) {
        /**
         * @Author slwhy
         * @Date 2020/4/26
         * @Param [cardPoints, left, right, count, k, sum]
         * @return void
         * @Description 暴力
         **/
        if (count == k) {
            res = Math.max(sum, res);
        }
        if (left >= 0 && left <= right && right < cardPoints.length) {
            helper(cardPoints, left + 1, right, count + 1, k, sum + cardPoints[left]);
            helper(cardPoints, left, right - 1, count + 1, k, sum + cardPoints[right]);
        }
    }
}
