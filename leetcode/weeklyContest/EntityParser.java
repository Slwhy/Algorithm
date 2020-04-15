package leetcode.weeklyContest;

/**
 * @author: slwhy
 * @date: 2020/4/12
 * @description: 5382. HTML 实体解析器
 */
public class EntityParser {
    public String entityParser(String text) {
        return text.replace("&quot;", "\"").replace("&apos;", "'").replace("&gt;", ">").replace("&lt;", "<").replace("&frasl;", "/").replace("&amp;", "&");
    }
}
