package leetcode.random;

import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2020/4/1
 * @description: 1111. 有效括号的嵌套深度
 */
public class MaxDepthAfterSplit {

    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray()) {
            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
        }
        return ans;
    }

    public int[] maxDepthAfterSplit1(String seq) {
        /**
         * @Author slwhy
         * @Date 2020/4/1
         * @Param [seq]
         * @return int[]
         * @Description leetcode 上的解法
         * 相比于方法2，优化了两个栈，只用一个变量统计当前栈里面‘(’的个数,而后根据其个数进行分配
         **/
        int[] res = new int[seq.length()];
        int d = 0;
        int index = 0;
        for (char ch : seq.toCharArray()) {
            if (ch == '(') {
                d++;
                res[index++] = d % 2;
            } else {
                res[index++] = d % 2;
                d--;
            }
        }
        return res;
    }

    public int[] maxDepthAfterSplit2(String seq) {
        //0表示A，1表示B
        int[] res = new int[seq.length()];
        char[] seqArray = seq.toCharArray();
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        res[0] = 0;
        stackA.push(seqArray[0]);
        for (int i = 1; i < seqArray.length; i++) {
            if (seqArray[i] == '(') {
                if (stackA.size() > stackB.size()) {
                    res[i] = 1;
                    stackB.push('(');
                } else {
                    res[i] = 0;
                    stackA.push('(');
                }
            } else {
                if (!stackA.isEmpty() && !stackB.isEmpty()) {
                    if (stackA.size() < stackB.size()) {
                        stackB.pop();
                        res[i] = 1;
                    } else {
                        stackA.pop();
                        res[i] = 0;
                    }
                } else if (!stackA.isEmpty()) {
                    stackA.pop();
                    res[i] = 0;
                } else {
                    stackB.pop();
                    res[i] = 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("".length());
    }
}
