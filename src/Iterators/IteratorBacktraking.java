package Iterators;

import java.util.Arrays;

public class IteratorBacktraking {

    int[] contador;
    int min;
    int max;
    int sum;
    boolean next;
    int[] set;

    public IteratorBacktraking(int n, int min, int max, int sum, int[] set) {
        this.contador = new int[n];
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.set = set;
        next = true;

        if (min != 0) {
            for (int i = 1; i < n; i++) {
                contador[i] = min;
            }
        }

    }

    public void next() {
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] < max) {
                contador[i] = contador[i] + 1;
                if (isValid(contador, sum, set)) {
                    System.out.println(Arrays.toString(contador));
                    return;
                } else {
                    contador[i] = min;
                }
            } else {
                for (int j = i; j >= 0; j--) {
                    contador[j] = 0;
                }
            }
        }
        next = false;
    }

    public boolean hasNext() {
        return next;
    }

    private static boolean isValid(int[] comb, int sum, int[] set) {
        for (int i = 0; i < comb.length; i++) {
            if (comb[i] == 1) {
                sum -= set[i];
            }
            if (sum < 0) {
                return false;
            }
        }
        return true;
    }

    public int[] getContador() {
        return contador.clone();
    }
}
