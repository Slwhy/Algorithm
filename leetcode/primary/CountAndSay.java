package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/16
 * @description: 外观数列
 */
public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder("1");
        int count;
        while (n-- > 1) {
            char[] tmp = ans.toString().toCharArray();
            ans.delete(0, ans.length());
            char tab;
            for (int i = 0; i < tmp.length; i++) {
                tab = tmp[i];
                count = 0;
                while (i < tmp.length && tmp[i] == tab) {
                    i++;
                    count++;
                }
                i--;
                ans.append(count);
                ans.append(tab);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        CountAndSay count = new CountAndSay();
        System.out.println(count.countAndSay(4));
    }
}
