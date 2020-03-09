package swordMeansOffer;

/**问题：青蛙跳台阶
 * */

public class JumpFloor {
    /**简单版的青蛙跳台阶，每次跳一阶或者两阶
     * */
    public static int JumpFloor1(int target) {
        int num1,num2,res;
        num1 = 1;
        num2 = 2;
        res = 0;
        if (target<=2){
            return target;
        }
        while (target>2){
            res = num1+num2;
            num1 = num2;
            num2 = res;
            target--;
        }
        return res;
    }

    public static int JumpFloor(int target){
        /**变态版青蛙跳台阶，一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级
         * 可以根据数学归纳法证明,f(n) = 2^(n-1)
         * */
        if (target<=2){
            return target;
        }
        else {
            return 2<<(target-2);
        }

    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }
}
