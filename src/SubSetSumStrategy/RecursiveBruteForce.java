package SubSetSumStrategy;

public class RecursiveBruteForce implements SubSetSumStrategy {

    @Override
    public boolean subSetSum(int sum, int[] set) {
        return forceRec(set.length - 1, sum, set);
    }

    private boolean forceRec(int j, int sum, int[] set) {
        if (sum == 0) {
            return true;
        }
        if (j == 0) {
            return false;
        }

        return forceRec(j - 1, sum - set[j], set) || forceRec(j - 1, sum, set);

    }

    @Override
    public String getName() {
        return "RecursiveBruteForce";
    }
}
