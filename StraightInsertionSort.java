import java.util.Arrays;

public class StraightInsertionSort {

    public static void main(String[] args) {
        int[] array = {5, 7, 8, 3, 1, 2, 4, 6};

        int temp = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                temp = array[i];
                for (int j = i; j > 0; j--) {
                    if (array[j - 1] > temp) {
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
