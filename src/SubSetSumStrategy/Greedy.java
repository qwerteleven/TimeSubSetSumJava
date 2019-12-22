package SubSetSumStrategy;

import java.util.Arrays;

public class Greedy implements SubSetSumStrategy {

    @Override
    public boolean subSetSum(int sum, int[] set) {
        Arrays.sort(set);    //uses quick sort
        reverse(set);
        return greedy(sum, set);

    }

    private boolean greedy(int sum, int[] set) {
        int count = 0;

        for (int i = 0; i < set.length; i++) {
            count += set[i];
            if (count == sum) {
                return true;
            }
        }

        return false;
    }

    static void reverse(int a[]) {
        int n = a.length;
        int t;
        for (int i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    @Override
    public String getName() {
        return "Greedy";
    }

}
