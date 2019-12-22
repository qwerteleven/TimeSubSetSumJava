package SubSetSumStrategy;

import Iterators.IteratorBacktraking;

public class IterBackTraking implements SubSetSumStrategy {

    @Override
    public boolean subSetSum(int sum, int[] set) {
        return backIter(sum, set);
    }

    private boolean backIter(int sum, int[] set) {
        IteratorBacktraking iter = new IteratorBacktraking(set.length, 0, 1, sum, set);
        int[] comb;
        int aux;

        while (iter.hasNext()) {
            iter.next();
            comb = iter.getContador();
            aux = 0;
            for (int i = 0; i < comb.length; i++) {
                if (comb[i] == 1) {
                    aux += set[i];
                }
            }
            if (aux == sum) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "IterBackTraking";
    }
}
