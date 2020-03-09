import java.util.ArrayList;

/**
 * @author: slwhy
 * @description: 打印序列，如array，Arraylist
 * @date: 2019/5/14
 */
public class Print {
    public static void printArray(int[] array){
        System.out.println();
        for (int i=0;i<array.length;i++){
            System.out.print("\t");
            System.out.print(array[i]);
        }
    }
    public static void printArray(double[] array){
        System.out.println();
        for (int i=0;i<array.length;i++){
            System.out.print("\t");
            System.out.print(array[i]);
        }
    }
    public static void printArray(ArrayList array){
        System.out.println();
        for (Object i:array){
            System.out.print("\t");
            System.out.print(i);
        }
    }


    public static void main(String[] args) {

    }
}
