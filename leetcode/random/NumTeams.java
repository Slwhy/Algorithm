package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/3/29
 * @description: 5369. 统计作战单位数
 */
public class NumTeams {

    public int numTeams(int[] rating) {
        /**
         * @Author slwhy
         * @Date 2020/3/31
         * @Param [rating]
         * @return int
         * @Description leetcode 上面的n^2 解法，中心扩展
         **/
        int count = 0;
        if (rating.length < 3) return count;
        int leftS; //左边的比中间小的数
        int rightS;
        int leftL; //左边的比中间大的数
        int rightL;
        for (int i = 1; i < rating.length - 1; i++) {
            leftL = 0;
            rightL = 0;
            leftS = 0;
            rightS = 0;
            for (int left = 0; left < i; left++) {
                if (rating[left] < rating[i]) leftS++;
                if (rating[left] > rating[i]) leftL++;
            }
            for (int right = i + 1; right < rating.length; right++) {
                if (rating[right] < rating[i]) rightS++;
                if (rating[right] > rating[i]) rightL++;
            }
            count += (leftL * rightS + leftS * rightL);

        }
        return count;
    }

    public int numTeams1(int[] rating) {
        /**
         * @Author slwhy
         * @Date 2020/3/31
         * @Param [rating]
         * @return int
         * @Description 周赛时写的，n^3复杂度的暴力
         **/
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
