package swordMeansOffer;

/**
 * @author: slwhy
 * @description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 * @date: 2019/6/5
 */
public class MinNumber {
    public String PrintMinNumber(int[] numbers) {
        /**
         * @description 参考他人博客的方法，重写一个比较方法，而后根据这个比较方法对数组进行排序
         * https://www.cnblogs.com/lliuye/p/9159152.html
         * @author slwhy
         * @date 2019/6/5
         * @param numbers
         * @return java.lang.String
         */

        int lent = numbers.length;
        if (lent<1){
            return "";
        }
        int tab;
        String res = "";
        for (int i = 0; i < lent; i++) {
            for (int j = 0; j < lent - i - 1; j++) {
                if (compare(numbers[j], numbers[j + 1])) {
                    tab = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tab;
                }
            }
        }
        for (int i = 0; i < lent; i++) {
            res = res + numbers[i];
        }
        return res;
    }

    public Boolean compare(int n, int m) {
        String res1 = "" + n + m;
        String res2 = "" + m + n;
        if (Long.parseLong(res1) > Long.parseLong(res2)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        MinNumber min = new MinNumber();
//        3, 32, 321
//        3334,3,3333332
        int[] arr = {3334,3,3333332};
        System.out.println(min.PrintMinNumber(arr));

    }
}
