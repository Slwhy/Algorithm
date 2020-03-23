package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/11/13
 * @description: num 28
 */
public class StrStr {

    public static int strStr2(String haystack, String needle) {
        // kmp 重点在于如何求next数组
        if (needle.equals("")) return 0;
        if (haystack.equals("")) return -1;
        int[] next = new int[needle.length()];
        next[0] = 0;
        //next数组求解过程
        for (int i = 2; i < needle.length(); i++) {
            for (int j = 1; j < i; j++) {
                if (needle.charAt(i - 1) == needle.charAt(next[i - j])) {
                    next[i] = next[i - j] + 1;
                    break;
                }
            }
//            if (needle.charAt(i - 1) == needle.charAt(next[i - 1])) next[i] = next[i - 1] + 1;
//            else if (needle.charAt(i - 1) == needle.charAt(0)) next[i] = 1;
        }
        int source = 0;
        int target = 0;
        while (source < haystack.length() && target < needle.length()) {
            if (haystack.charAt(source) == needle.charAt(target)) {
                source++;
                target++;
                if (target == needle.length()) return source - needle.length();
            } else if (target == 0) {
                source++;
            } else {
                target = next[target];
            }
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        //num 28
        //暴力
        if (needle.equals("")) return 0;
        if (haystack.equals("")) return -1;
        int source, target;
        for (int i = 0; i < haystack.length(); i++) {
            source = i;
            target = 0;
            while (source < haystack.length() && target < needle.length() && haystack.charAt(source++) == needle.charAt(target++))
                ;
            if (target == needle.length() && haystack.charAt(source - 1) == needle.charAt(target - 1)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(FindContinuousSequence(100));
        int[] array1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] array2 = new int[]{2, 3};

//        System.out.println();
//        ListNode head = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        System.out.println(strStr2("aabaaabaaac", "aabaaac"));
        System.out.println(strStr("aabaaabaaac", "aabaaac"));
//        System.out.println(strStr2("bbababaaaababbaabbbabbbaaabbbaaababbabaabbaaaaabbaaabbbbaaabaabbaababbbaabaaababbaaabbbbbbaabbbbbaaabbababaaaaabaabbbababbaababaabbaa", "bbabba"));
//        System.out.println(strStr("bbababaaaababbaabbbabbbaaabbbaaababbabaabbaaaaabbaaabbbbaaabaabbaababbbaabaaababbaaabbbbbbaabbbbbaaabbababaaaaabaabbbababbaababaabbaa", "bbabba"));
        System.out.println(strStr2("mississippi", "issip"));
        System.out.println(strStr2("hello", "ll"));


    }
}
