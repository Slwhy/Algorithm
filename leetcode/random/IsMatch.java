package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/3/27
 * @description: 10. 正则表达式匹配
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();

        return isMatchCore(charS, charP, 0, 0);
    }

    public boolean isMatchCore(char[] s, char[] p, int indexS, int indexP) {
        if (indexP == p.length && indexS == s.length) return true;
        if (indexS < s.length && indexP < p.length) {
            if (s[indexS] == p[indexP] || p[indexP] == '.') return isMatchCore(s, p, indexS + 1, indexP + 1);
            else if (p[indexP] == '*')
                return isMatchCore(s, p, indexS, indexP - 1) || isMatchCore(s, p, indexS, indexP + 1);
            else if (indexP + 1 < p.length && p[indexP + 1] == '*') return isMatchCore(s, p, indexS, indexP + 1);
            return false;
        } else return false;
    }
}
