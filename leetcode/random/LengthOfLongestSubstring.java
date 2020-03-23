package leetcode.random;

import java.util.*;

/**
 * @author: slwhy
 * @date: 2019/10/8
 * @description: num 3
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring5(String s) {
        /**
         * @Author slwhy
         * @Date 2019/10/8
         * @Param [s]
         * @return int
         * @Description leetcode 上的优雅解法
         **/
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        for (int j = 0; j < chars.length; j++) {
            for (int innerIndex = leftIndex; innerIndex < j; innerIndex++) {
                if (chars[innerIndex] == chars[j]) {
                    maxLength = Math.max(maxLength, j - leftIndex);
                    leftIndex = innerIndex + 1;
                    break;
                }
            }
        }
        return Math.max(chars.length - leftIndex, maxLength);
    }


    public static int lengthOfLongestSubstring4(String s) {
        /**
         * @Author slwhy
         * @Date 2019/10/8
         * @Param [s]
         * @return int
         * @Description
         * 针对版本3进行优化，省略了队列，直接根据字符的顺序重hashset中删除
         * 以及直接从字符串中读取，没有将String转为CharArray
         * 可以考虑用一个字符数组（存Boolean）取代set
         **/
        if (s.length() < 2) {
            return s.length();
        }
        int max = 0;
        HashSet<Character> strSet = new HashSet<Character>();
//        char[] strArray = s.toCharArray();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (strSet.contains(s.charAt(i))) {
                strSet.remove(s.charAt(j++));
            }
            strSet.add(s.charAt(i));
            max = i - j + 1 > max ? i - j + 1 : max; //i - j + 1，直接用这个求字串长度，耗时比求set的size要少
//            if (strSet.size() > max) max = strSet.size();
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
        /**
         * @Author slwhy
         * @Date 2019/10/8
         * @Param [s]
         * @return int
         * @Description 针对版本2进行了优化，利用一个队列记录下字符串的顺序，
         * 省去了arraylist，以及重复对arraylist进行hashset的操作
         **/
        if (s.length() < 2) {
            return s.length();
        }
        int max = 0;
        HashSet<Character> strSet = new HashSet<Character>();
        char[] strArray = s.toCharArray();
        Queue<Character> queue1 = new LinkedList<Character>();
        for (int i = 0; i < strArray.length; i++) {
            while (strSet.contains(strArray[i]) && !queue1.isEmpty()) {
                strSet.remove(queue1.poll());
            }
            strSet.add(strArray[i]);
            queue1.add(strArray[i]);
            if (strSet.size() > max) max = strSet.size();
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        /**
         * @Author slwhy
         * @Date 2019/10/8
         * @Param [s]
         * @return int
         * @Description
         * 利用一个arraylist保存字符子串，并根据这个arraylist定义一个hashset用来判断是否有重复元素。
         * 如果有重复元素则从arraylist的头部开始删除，直到里面没有重复元素，arraylist的最大size即为结果
         **/
        int max = 0;
        LinkedHashSet<Character> strSet = new LinkedHashSet<Character>();
        char[] strArray = s.toCharArray();
        ArrayList<Character> charList = new ArrayList<Character>();
        for (int i = 0; i < strArray.length; i++) {
            strSet = new LinkedHashSet<Character>(charList);
            while (strSet.contains(strArray[i])) {
                charList.remove(0);
                strSet = new LinkedHashSet<Character>(charList);
            }
            charList.add(strArray[i]);
            if (charList.size() > max) max = charList.size();
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        /**
         * @Author slwhy
         * @Date 2019/10/8
         * @Param [s]
         * @return int
         * @Description 暴力
         **/
        int max = 0;
        int lent;
        char[] strArray = s.toCharArray();
        for (int i = 0; i < strArray.length - max; i++) {
            lent = 0;
            Set<Character> strSet = new TreeSet<Character>();
            for (int j = i; j < strArray.length; j++) {
                if (strSet.contains(strArray[j])) break;
                lent++;
                strSet.add(strArray[j]);
            }
            if (lent > max) max = lent;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring4("pwwkew"));
    }
}
