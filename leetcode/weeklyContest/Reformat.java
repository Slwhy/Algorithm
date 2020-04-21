package leetcode.weeklyContest;


/**
 * @author: slwhy
 * @date: 2020/4/19
 * @description: 5388. 重新格式化字符串
 */
public class Reformat {
    public static String reformat(String s) {
        char[] chars = s.toCharArray();
        char[] nums = new char[s.length()];
        char[] letters = new char[s.length()];
        char[] reformt = new char[s.length()];
        int indexLetter = 0;
        int indexNum = 0;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) nums[indexNum++] = chars[i];
            else letters[indexLetter++] = chars[i];
        }
        if (Math.abs(indexLetter - indexNum) > 1) return "";
        int i = 0, j = 0;
        while (i < indexNum && j < indexLetter) {
            if (indexLetter>indexNum){
                reformt[index++] = letters[j++];
                reformt[index++] = nums[i++];
            }else {
                reformt[index++] = nums[i++];
                reformt[index++] = letters[j++];
            }

        }
        if (indexLetter > indexNum || indexLetter < indexNum)
            reformt[index] = indexLetter > indexNum ? letters[indexLetter - 1] : nums[indexNum - 1];
        return String.copyValueOf(reformt);
    }

    public static void main(String[] args) {
        System.out.println(reformat("0a1b2c"));
    }
}
