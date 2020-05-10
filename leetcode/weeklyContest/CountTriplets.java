package leetcode.weeklyContest;

/**
 * @author: slwhy
 * @date: 2020/5/10
 * @description: 5405. 形成两个异或相等数组的三元组数目
 */
public class CountTriplets {
    public int countTriplets(int[] arr) {
        int res = 0;
        int a, b;
        for (int i = 1; i < arr.length; i++) {
            a = 0;
            for (int left = i - 1; left >= 0; left--) {
                a = a ^ arr[left];
                b = 0;
                for (int right = i; right < arr.length; right++) {
                    b = b ^ arr[right];
                    if (a == b) res++;
                }
            }
        }
        return res;
    }
}
