package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/12
 * @description: 面试题 16.03. 交点
 */
public class Intersection {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double k1 = (double) (end1[1]-start1[1]) /(end1[0]-start1[0]);
        double b1 = end1[1] - k1*end1[0];
        double k2 = (double) (end2[1]-start2[1]) /(end2[0]-start2[0]);
        double b2 = end2[1] - k2*end2[0];
        double [] res = new double[2];
        if (k1!=k2){
            res[0] = (b2-b1)/(k1-k2);
            res[1] = k1*res[0]+b1;
            return res;
        }
        return null;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] start1 = new  int[]{0,0};
        int[] end1 = new  int[]{0,1};
        int[] start2 = new  int[]{1,0};
        int[] end2 = new  int[]{1,1};
        intersection.intersection(start1,end1,start2,end2);

    }
}
