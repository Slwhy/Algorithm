package leetcode.primary;

import java.util.Random;

/**
 * @author: slwhy
 * @date: 2020/3/20
 * @description: 384. 打乱数组
 */
public class Shuffle {

    public int[] original;
    public int[] num;

    public Shuffle(int[] nums) {
        original = new int[nums.length];
        num = nums;
        for (int i = 0; i < nums.length; i++) {
            original[i] = nums[i];
        }
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int tmp;
        int index;
        Random random = new Random();
        for (int i = 0; i < num.length; i++) {
            index = random.nextInt(num.length);
            tmp = num[i];
            num[i] = num[index];
            num[index] = tmp;
        }
        return num;
    }
}
