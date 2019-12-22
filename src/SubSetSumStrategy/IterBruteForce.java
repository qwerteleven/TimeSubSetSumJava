package SubSetSumStrategy;

import Iterators.Iterator;

public class IterBruteForce implements SubSetSumStrategy {

    @Override
    public boolean subSetSum(int sum, int[] set) {
        return forceIter(sum, set);

    }

    private boolean forceIter(int sum, int[] set) {
        int count = 0;
        int[] comb;
        Iterator iter = new Iterator(set.length, 0, 1);

        while (iter.hasNext()) {
            comb = iter.getComb();
            for (int j = 0; j < set.length; j++) {
                if (comb[j] == 1) {
                    count += set[j];
                }
            }

            if (count == sum) {
                return true;
            }

            count = 0;
            iter.next();
        }
        return false;
    }

    @Override
    public String getName() {
        return "IterBruteForce";
    }
}
