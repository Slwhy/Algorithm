package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/11
 * @description: 125. 验证回文串
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        int left = 0;
        char[] sChar = s.toCharArray();
        int right = sChar.length - 1;
        while (left < right) {
            if (!(Character.isDigit(sChar[left]) || Character.isLetter(sChar[left]))) {
                left++;
                continue;
            }
            if (!(Character.isDigit(sChar[right]) || Character.isLetter(sChar[right]))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(sChar[left]) == Character.toLowerCase(sChar[right])) {
                left++;
                right--;
                continue;
            }
            return false;
        }
        return true;
    }
}
