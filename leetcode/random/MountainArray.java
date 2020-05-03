package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/29
 * @description: 1095. 山脉数组中查找目标值
 */
public class MountainArray {

    public int length() {
        return 0;
    }

    public int get(int index) {
        /**
         * @Author slwhy
         * @Date 2020/4/29
         * @Param [index]
         * @return int
         * @Description 因为是交互式的题目，length和get函数是避免idea报错定义的空函数
         **/
        return 0;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        return helper(target, mountainArr, 0, mountainArr.length() - 1);
    }

    public int helper(int target, MountainArray mountainArray, int left, int right) {
        if (left == right) {
            if (mountainArray.get(left) == target) return left;
            else return -1;
        }
        if (left < right && right < mountainArray.length()) {
            int mid = (left + right) / 2;
            int num = mountainArray.get(mid);
            if (num > mountainArray.get(mid + 1) && target > num) return helper(target, mountainArray, left, mid - 1);

            else if (target > num) return helper(target, mountainArray, mid + 1, right);

            int subLeft = helper(target, mountainArray, left, mid - 1);
            if (subLeft != -1) return subLeft;
            if (num == target) return mid;
            else return helper(target, mountainArray, mid + 1, right);

        } else return -1;
    }

    public static void main(String[] args) {
        //[3,5,3,2,0]
    }

}
