package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/21
 * @description: 190. 颠倒二进制位
 */
public class ReverseBits {

    public int reverseBits(int n){
        /**
         * @Author slwhy
         * @Date 2020/3/21
         * @Param [n]
         * @return int
         * @Description leetcode 上的,刚开始没想到
         **/
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }

    public int reverseBits2(int n) {
        int mark = 1;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((n & mark) != 0) tmp.append('1');
            else tmp.append('0');
            mark <<= 1;
        }
        char[] chars = tmp.toString().toCharArray();
        int res = 0;
        int num;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') num = 1;
            else num = 0;
            res = res * 2 + num;
        }
        return res;
        //这里并不需要对数据符号进行考虑，因为题目里面说的是无符号数
//        if (chars[0] == '1') return -res;
//        else return res;
    }

    public static void main(String[] args) {

        ReverseBits res = new ReverseBits();
        System.out.println(Integer.toBinaryString(res.reverseBits(-3)));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(1 << 31));
        System.out.println(new StringBuilder("00000010100101000001111010011100").reverse());
        char[] chars = "00111001011110000010100101000000".toCharArray();
        System.out.println("11111111111111111111111111111101".length());

    }
}
