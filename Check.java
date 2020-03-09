import java.util.Random;

/**
 * @author: slwhy
 * @description: 充当对数器，随机产生数组，并检查结果
 * @date: 2019/5/14
 */
public class Check {

    public static void produceArrayInt(int[] array) {
        int max = 1000;
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(max);
        }
    }


    public static void main(String[] args) {
        System.out.println("hello");
    }
}
