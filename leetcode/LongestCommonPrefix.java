package leetcode;

/**
 * @author: slwhy
 * @date: 2019/10/27
 * @description: num 14
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix3(String[] strs) {
        return "";
    }

    public static String longestCommonPrefix2(String[] strs) {
        //在方法1的基础上对内存进行了优化，没有使用中间变量保留结果，而是直接取strs[0]的子串作为结果
        if (strs.length < 1) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() > i && strs[j].charAt(i) == strs[0].charAt(i)) continue;
                else return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length < 1) return "";
        char temp;
        for (int i = 0; i < strs[0].length(); i++) {
            temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() > i && strs[j].charAt(i) == temp) continue;
                else return res;
            }
            res = res + temp;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix3(strs) == "");
        System.out.println("abcdd".indexOf("abc"));

    }
}
