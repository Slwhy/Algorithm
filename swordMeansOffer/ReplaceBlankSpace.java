package swordMeansOffer;

/**
 * 问题：将一个字符串中的每个空格替换成“%20”
 *
 * 思路：StringBuffer只能对指定索引位置的字符串进行替换，将StringBuffer 转化成String，而后调用string的replaceAll函数，
 * */
public class ReplaceBlankSpace {
    public static String replaceSpace(StringBuffer str) {
        String res = str.toString().replaceAll(" ","%20");
        return res;
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        String res = replaceSpace(str);
        System.out.println(res);


    }
}
