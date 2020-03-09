package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2019/10/27
 * @description: num 17
 */
public class LetterCombinations {
    public static ArrayList res = new ArrayList<String>();

    public static List<String> letterCombinations(String digits) {
        //DFS
        if (digits.length() < 1) return res;
        HashMap<Character, Character[]> letters = new HashMap<Character, Character[]>();
        letters.put('2', new Character[]{'a', 'b', 'c'});
        letters.put('3', new Character[]{'d', 'e', 'f'});
        letters.put('4', new Character[]{'g', 'h', 'i'});
        letters.put('5', new Character[]{'j', 'k', 'l'});
        letters.put('6', new Character[]{'m', 'n', 'o'});
        letters.put('7', new Character[]{'p', 'q', 'r', 's'});
        letters.put('8', new Character[]{'t', 'u', 'v'});
        letters.put('9', new Character[]{'w', 'x', 'y', 'z'});
        letterCombinationsCore(digits, letters, 0, "");
        return res;
    }

    public static void letterCombinationsCore(String digits, HashMap<Character, Character[]> letters, int num, String temp) {
        if (num == digits.length()) res.add(temp);
        else {
            for (Character letter : letters.get(digits.charAt(num))) {
                letterCombinationsCore(digits, letters, num + 1, temp + letter);
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println('a' + 1);
        List<String> res = new ArrayList<>();
        res = letterCombinations("23");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
