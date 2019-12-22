package SubSetSumStrategy;

public class RecursiveBackTraking implements SubSetSumStrategy {

    @Override
    public boolean subSetSum(int sum, int[] set) {
        return backRec(set.length - 1, sum, set);

    }

    private boolean backRec(int j, int sum, int[] set) {
        if (sum == 0) {
            return true;
        }
        if (j == 0) {
            return false;
        }

        if (set[j - 1] > sum) {
            return backRec(j - 1, sum, set);
        }

        return (backRec(j - 1, sum - set[j], set) || backRec(j - 1, sum, set));
    }

    @Override
    public String getName() {
        return "RecursiveBackTraking";
    }
}
