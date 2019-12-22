package SubSetSumStrategy;

import java.util.HashMap;

public class Memoization implements SubSetSumStrategy {

    @Override
    public boolean subSetSum(int sum, int[] set) {
        HashMap<String, Boolean> dict = new HashMap<>();
        return memo(set.length - 1, dict, set, sum);
    }

    private boolean memo(int j, HashMap<String, Boolean> dict, int[] set, int sum) {
        if (sum == 0) {
            return true;
        }
        if (j < 0 || sum < 0) {
            return false;
        }

        String key = j + "|" + sum;

        if (!dict.containsKey(key)) {
            boolean exclude = memo(j - 1, dict, set, sum);
            boolean include = memo(j - 1, dict, set, sum - set[j]);
            dict.put(key, include || exclude);
        }
        return dict.get(key);
    }

    @Override
    public String getName() {
        return "Memoization";
    }
}
