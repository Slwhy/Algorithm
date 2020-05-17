package leetcode.weeklyContest;


/**
 * @author: slwhy
 * @date: 2020/4/19
 * @description: 1419. 数青蛙
 */
public class MinNumberOfFrogs {
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() < 5 || croakOfFrogs.length() % 5 != 0) return -1;
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int res = 0;
        char[] chars = croakOfFrogs.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'c') {
                if (k > 0) k--;
                else res++;
                c++;
            }
            if (chars[i] == 'r') {
                c--;
                r++;
            }
            if (chars[i] == 'o') {
                r--;
                o++;
            }
            if (chars[i] == 'a') {
                o--;
                a++;
            }
            if (chars[i] == 'k') {
                a--;
                k++;
            }
            if (c < 0 || r < 0 || o < 0 || a < 0) break;
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) return -1;
        else return res;
    }

    public static void main(String[] args) {
        MinNumberOfFrogs minNumberOfFrogs = new MinNumberOfFrogs();
        StringBuilder test = new StringBuilder("crcoakroak");
        System.out.println(test.delete(0, 1).toString());
        System.out.println(minNumberOfFrogs.minNumberOfFrogs("crcoakroak"));
    }
}
