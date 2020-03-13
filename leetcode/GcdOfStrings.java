package leetcode;

/**
 * @author: slwhy
 * @date: 2020/3/12
 * @description: 1071. 字符串的最大公因子
 */
public class GcdOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        /**
         * @Author slwhy
         * @Date 2020/3/12
         * @Param [str1, str2]
         * @return java.lang.String
         * @Description leetcode 上的 辗转相除法
         **/
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    public String gcdOfStrings2(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] tmp = new char[Math.min(chars1.length, chars2.length)];
        int str1Index = 0, str2Index = 0, tmpIndex = 0;
        while (str1Index < chars1.length && str2Index < chars2.length) {
            if (chars1[str1Index] == chars2[str2Index]) {
                tmp[tmpIndex++] = chars1[str1Index];
                str1Index++;
                str2Index++;
            } else break;
        }
        if (tmpIndex == 0) return "";
        else {
            int j = 0;
            str1Index = 0;
            str2Index = 0;
            for (; str1Index < str1.length() && chars1[str1Index] == tmp[str1Index % tmpIndex]; str1Index++) ;
            for (; str2Index < str2.length() && chars2[str2Index] == tmp[str2Index % tmpIndex]; str2Index++) ;
            if (str1Index == str1.length() && str2Index == str2.length() && (str1Index - 1) % tmpIndex == tmpIndex - 1 && (str2Index - 1) % tmpIndex == tmpIndex - 1)
                return String.copyValueOf(tmp, 0, tmpIndex);
            for (int i = tmpIndex - 1; i > 0; i--) {
                if (tmp[i] == tmp[0]) {
                    j = 0;
                    for (; j < tmpIndex; j++) {
                        if (tmp[j] != tmp[j % i]) break;
                    }
                    if (j == tmpIndex) {
                        str1Index = 0;
                        str2Index = 0;
                        for (; str1Index < str1.length() && chars1[str1Index] == tmp[str1Index % i]; str1Index++) ;
                        for (; str2Index < str2.length() && chars2[str2Index] == tmp[str2Index % i]; str2Index++) ;
                        if (str1Index == str1.length() && str2Index == str2.length() && (str1Index - 1) % i == i - 1 && (str2Index - 1) % i == i - 1)
                            return String.copyValueOf(tmp, 0, i);
                    }
                }
            }
        }
        return "";


    }

    public static void main(String[] args) {
        GcdOfStrings gcd = new GcdOfStrings();
        System.out.println(gcd.gcdOfStrings("ABABAB", "ABAB"));
//        System.out.println(gcd.gcdOfStrings("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
//                , "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
    }
}
