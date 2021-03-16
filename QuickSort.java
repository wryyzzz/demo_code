import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {9, 1, 5, 8, 3, 7, 4, 2};
        sort(array, 0, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int base, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int temp = array[base];
        while (i < j) {
            while (i < j && array[j] > temp) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            while (i < j && array[i] < temp) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = temp;
        sort(array, start, start, i - 1);
        sort(array, i + 1, i + 1, end);
    }
}
