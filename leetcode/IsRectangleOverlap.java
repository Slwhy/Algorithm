package leetcode;

/**
 * @author: slwhy
 * @date: 2020/3/18
 * @description: 836. 矩形重叠
 */
public class IsRectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        /**
         * @Author slwhy
         * @Date 2020/3/18
         * @Param [rec1, rec2]
         * @return boolean
         * @Description 两个思路
         * 1.求反
         * 2.重叠区域为矩形
         **/
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);//top
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
