package leetcode;

/**
 * @author: slwhy
 * @date: 2019/11/14
 * @description: num 34
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        //看复杂度要求，明显二分，不过该方法在处理 nums[mid]==target 还有待优化
        return searchRangeCore(nums, target, 0, nums.length - 1);
    }

    public int[] searchRangeCore2(int[] nums, int target, int start, int end) {
        //对方法1进行优化，当nums[mid]==target时依旧采用二分，通过组合两边的结果获取最终结果

        if (start <= end) {
            if (nums[start] == target && nums[end] == target) {
                int[] res = new int[]{start, end};
                return res;
            }
            int mid = (start + end) / 2;
            if (nums[mid] > target) return searchRangeCore2(nums, target, start, mid - 1);
            else if (nums[mid] < target) return searchRangeCore2(nums, target, mid + 1, end);
//            else if (nums[start] < target) return searchRangeCore(nums, target, start + 1, end);
            else {
                int [] left= searchRangeCore2(nums,target,start,mid);
                int [] right= searchRangeCore2(nums,target,mid+1,end);
                if (left[0]==-1) return right;
                else if (right[0]==-1) return left;
                else {
                    int[] res=new int[] {left[0],right[1]};
                    return res;
                }
            }
        } else {
            int[] res = new int[]{-1, -1};
            return res;
        }
    }

    public int[] searchRangeCore(int[] nums, int target, int start, int end) {
        if (start <= end) {
            if (nums[start] == target && nums[end] == target) {
                int[] res = new int[]{start, end};
                return res;
            }
            int mid = (start + end) / 2;
            if (nums[mid] > target) return searchRangeCore(nums, target, start, mid - 1);
            else if (nums[mid] < target) return searchRangeCore(nums, target, mid + 1, end);
            else if (nums[start] < target) return searchRangeCore(nums, target, start + 1, end);
            else return searchRangeCore(nums, target, start, end - 1);
        } else {
            int[] res = new int[]{-1, -1};
            return res;
        }
    }

}
