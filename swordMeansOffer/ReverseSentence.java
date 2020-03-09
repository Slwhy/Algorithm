package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/3
 * @description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    public static String ReverseSentence(String str) {
        /**
         * @Author slwhy
         * @Date 2019/9/3
         * @Param [str]
         * @return java.lang.String
         * @Description
         * if (str.length()<2){
         *    return str;
         *  }
         * 不行，因为不清楚str里面有多少个空格，如果全是空格，则结果为空
         **/
        if (str == null || str.trim().equals("")) return str;
        String[] str_arr = str.split(" ");
        String res = "";
        for (int i = str_arr.length - 1; i >= 0; i--) {
            String item = str_arr[i];
            if (i > 0) {
                item = item + " ";
            }
            res = res + item;
        }
        return res;
    }

}
