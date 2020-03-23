package leetcode.random;

import java.util.*;

/**
 * @author: slwhy
 * @date: 2020/3/21
 * @description: 365. 水壶问题
 */
public class CanMeasureWater {


    public boolean canMeasureWater(int x, int y, int z) {
        /**
         * @Author slwhy
         * @Date 2020/3/21
         * @Param [x, y, z]
         * @return boolean
         * @Description DFS 遍历所有的可能的倒水情况,
         * 这里需要主要一点, 不能用HashMap 存储已经出现过的状态,因为(0,x),(0,0) 有这种键相同的状态,
         * 如果用HashMap,后面的会将前面的覆盖了,跳出循环
         **/
        Set<Map.Entry<Integer, Integer>> remains = new HashSet<>();
//        HashMap<Integer, Integer> remains = new HashMap<>();
        Stack<int[]> stack1 = new Stack();
        stack1.push(new int[]{0, 0});
        int remainX, remainY;
        while (!stack1.isEmpty()) {
            int[] tmp = stack1.pop();
            remainX = tmp[0];
            remainY = tmp[1];
            if (remainX == z || remainY == z || remainX + remainY == z) return true;
            Map.Entry<Integer, Integer> item = new AbstractMap.SimpleEntry<>(remainX, remainY);
            if (!remains.contains(item)) {
                remains.add(item);
                stack1.add(new int[]{0, remainY});
                stack1.add(new int[]{remainX, 0});
                stack1.add(new int[]{x, remainY});
                stack1.add(new int[]{remainX, y});
                stack1.add(new int[]{Math.max(0, remainX - (y - remainY)), Math.min(y, remainX + remainY)});
                stack1.add(new int[]{Math.min(remainX + remainY, x), Math.max(0, remainY - (x - remainX))});
            }
        }
        return false;
    }

    public boolean canMeasureWater1(int x, int y, int z) {
        if (x + y < z) return false;
        if (x + y == z) return true;
        int n = gcd(x, y);
        if (n != 0 && z % n == 0) return true;
        else return false;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


    public static void main(String[] args) {
        CanMeasureWater can = new CanMeasureWater();
        System.out.println(can.canMeasureWater(3, 5, 4));
    }
}
