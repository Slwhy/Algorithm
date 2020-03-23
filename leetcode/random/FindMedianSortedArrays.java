package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/10/10
 * @description: num 4
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays5(int[] nums1, int[] nums2) {
        // leetcode 上的方法
        //https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
        // 解法四，没怎么看懂
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays5(nums2, nums1); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && nums2[j - 1] > nums1[i]) { // i 需要增大
                iMin = i + 1;
            } else if (i != 0 && j != n && nums1[i - 1] > nums2[j]) { // i 需要减小
                iMax = i - 1;
            } else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }


    public static double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        // leetcode 上的解法，O(log(m+n))
        //基于二分法
        //https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }


    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        // leetcode 上的方法
        //对方法二进行了优化，不用对数组长度是奇数还是偶数进行分情况考虑
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }


    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // 还是暴力，不过对方法1进行了优化，不用开辟一个m+n的数组来保存两个数组的元素
        int lent1 = nums1.length;
        int lent2 = nums2.length;
        if (lent1 < 1 && lent2 < 1) return 0.0;
        int res = 0;
        int mid = (lent1 + lent2) / 2;
        if (lent1 < 1) {
            if (lent2 % 2 == 0) return (double) (nums2[mid - 1] + nums2[mid]) / 2;
            else return nums2[mid];
        }
        if (lent2 < 1) {
            if (lent1 % 2 == 0) return (double) (nums1[mid - 1] + nums1[mid]) / 2;
            else return nums1[mid];
        }
        int n1 = 0, n2 = 0, i = 0;
        if ((lent1 + lent2) % 2 == 0) {
            while (i <= (lent1 + lent2) / 2) {
                if (n1 < lent1 && n2 < lent2 && nums1[n1] < nums2[n2] && i <= (lent1 + lent2) / 2) {
                    if (i == mid - 1) res = nums1[n1];
                    if (i == mid) {
                        res = res + nums1[n1];
                        break;
                    }
                    n1++;
                    i++;
                }
                if (n1 < lent1 && n2 < lent2 && nums1[n1] >= nums2[n2] && i <= (lent1 + lent2) / 2) {
                    if (i == mid - 1) res = nums2[n2];
                    if (i == mid) {
                        res = res + nums2[n2];
                        break;
                    }
                    n2++;
                    i++;
                }
                if (n1 >= lent1 && n2 < lent2 && i <= (lent1 + lent2) / 2) {
                    if (i == mid - 1) res = nums2[n2];
                    if (i == mid) {
                        res = res + nums2[n2];
                        break;
                    }
                    n2++;
                    i++;
                }
                if (n2 >= lent2 && n1 < lent1 && i <= (lent1 + lent2) / 2) {
                    if (i == mid - 1) res = nums1[n1];
                    if (i == mid) {
                        res = res + nums1[n1];
                        break;
                    }
                    n1++;
                    i++;
                }
            }
            return ((double) res) / 2;
        } else {
            while (i <= (lent1 + lent2) / 2) {
                if (n1 < lent1 && n2 < lent2 && nums1[n1] < nums2[n2] && i <= (lent1 + lent2) / 2) {
                    res = nums1[n1];
                    n1++;
                    i++;
                }
                if (n1 < lent1 && n2 < lent2 && nums1[n1] >= nums2[n2] && i <= (lent1 + lent2) / 2) {
                    res = nums2[n2];
                    n2++;
                    i++;
                }
                if (n1 >= lent1 && n2 < lent2 && i <= (lent1 + lent2) / 2) {
                    res = nums2[n2];
                    n2++;
                    i++;
                }
                if (n2 >= lent2 && n1 < lent1 && i <= (lent1 + lent2) / 2) {
                    res = nums1[n1];
                    n1++;
                    i++;
                }
            }
            return (double) res;
        }
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 暴力
        int lent1 = nums1.length;
        int lent2 = nums2.length;
        if (lent1 == 0 && lent2 == 0) return 0.0;
        int[] num = new int[lent1 + lent2];
        int n1 = 0, n2 = 0, i = 0;
        while (i < lent1 + lent2) {
            if (n1 < lent1 && n2 < lent2 && nums1[n1] < nums2[n2]) {
                num[i++] = nums1[n1++];
            }
            if (n1 < lent1 && n2 < lent2 && nums1[n1] >= nums2[n2]) {
                num[i++] = nums2[n2++];
            }
            if (n1 >= lent1 && n2 < lent2) {
                num[i++] = nums2[n2++];
            }
            if (n2 >= lent2 && n1 < lent1) {
                num[i++] = nums1[n1++];
            }
        }
        if ((lent1 + lent2) % 2 == 0) {
            return (double) (num[(lent1 + lent2) / 2 - 1] + num[(lent1 + lent2) / 2]) / 2;
        } else return (double) num[(lent1 + lent2) / 2];

    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1};
        int[] array2 = new int[]{2};
        System.out.println(findMedianSortedArrays(array1, array2));
    }

}
