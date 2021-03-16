import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{9, 1, 5, 8, 3, 7, 4, 2};
        int len = array.length;
        for (int j = array.length - 1; j > 0; j--) {
            for (int i = (int) Math.floor((j + 1) / 2); i >= 0; i--) {
                //处理left
                int left = 2 * i + 1;
                if (left < len && array[i] < array[left] && left <= j) {
                    int temp = array[i];
                    array[i] = array[left];
                    array[left] = temp;
                }
                //处理right
                int right = left + 1;
                if (right < len && array[i] < array[right] && right <= j) {
                    int temp = array[i];
                    array[i] = array[right];
                    array[right] = temp;
                }
            }
            int temp = array[0];
            array[0] = array[j];
            array[j] = temp;
        }
        System.out.println(Arrays.toString(array));

    }
}