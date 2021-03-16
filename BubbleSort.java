import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {9, 1, 5, 8, 3, 7, 4, 2};
        boolean flag = true;
        //假设从第i个数开始，从后遍历数组，没有发生一次交换，则可以认为从i开始后的所有数字都是有序
        for (int i = 0; i < array.length && flag; i++) {
            flag = false;
            for (int j = array.length - 2; j >= i; j--) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                } 
            }
        }
        System.out.println(Arrays.toString(array));

    }
}
