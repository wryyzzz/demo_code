import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {9, 1, 5, 8, 3, 7, 4, 2};
        for (int gap = array.length / 2; gap != 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[gap];
                for (int j = 0; j > 0; j -= gap) {
                    if (array[j - gap] > temp) {
                        array[j] = array[j - gap];
                        array[j - gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
