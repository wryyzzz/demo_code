

public class RadixSort {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] array = new int[amount];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    continue;
                }
                array[i] = Math.min(array[i], 1 + array[i - coins[j]]);
            }
        }

        return array[amount - 1];
    }


}
