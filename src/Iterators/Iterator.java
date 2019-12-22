package Iterators;

public class Iterator {

    private final int[] contador;
    private final int min;
    private final int max;
    private boolean next;

    public Iterator(int n, int min, int max) {
        this.contador = new int[n];
        this.min = min;
        this.max = max;
        next = true;

        if (min != 0) {
            for (int i = 0; i < n; i++) {
                contador[i] = min;
            }
        }

    }

    public void next() {

        for (int i = 0; i < contador.length; i++) {
            if (contador[i] < max) {
                contador[i] = contador[i] + 1;
                return;

            } else {
                for (int j = i; j >= 0; j--) {
                    contador[j] = min;
                }
            }
        }
        next = false;
    }

    public boolean hasNext() {
        return next;
    }

    public int[] getComb() {
        return contador.clone();
    }
}
