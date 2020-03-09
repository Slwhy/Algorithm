package swordMeansOffer;

import java.util.Stack;

/**
 * @author: slwhy
 * @description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @date: 2019/5/14
 */
public class StackOutAndIn {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        /**
         * @description
         * 参考博客：https://www.cnblogs.com/edisonchou/p/4779755.html
         * 思路：反推，如果能根据当前的输出序列找出一个相对应的入栈顺序，即说明可能是弹出序列，
         * 一边将pushA中的数据压入栈中，一边与popA进行比较，看当前栈顶是否应该弹出，
         * @author slwhy
         * @date 2019/5/19
         * @param pushA
         * @param popA
         * @return boolean
         */
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(pushA[0]);
        int i = 0; //popA的下标
        int j = 1;//pushA的下标
        while (j<pushA.length){
            if (stack1.peek()==popA[i]){
                stack1.pop();
                i++;
                stack1.push(pushA[j]);
                j++;
            }else {
                stack1.push(pushA[j]);
                j++;
            }
        }
        while (!stack1.isEmpty()){
            if (stack1.pop()!=popA[i]){
                return false;
            }
            i++;
        }
        if (i==j){
            return true;
        }
        else return false;
    }
    public Boolean IsPopOrder2(int[] pushA,int[] popA){
        /**
         * @description 牛客上的代码
         * @author slwhy
         * @date 2019/5/19
         * @param pushA
         * @param popA
         * @return java.lang.Boolean
         */

        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        int pushA[]={1,2,3,4,5};
        int [] popA = {4,5,3,2,1};
        System.out.print(IsPopOrder(pushA,popA));

    }
}
