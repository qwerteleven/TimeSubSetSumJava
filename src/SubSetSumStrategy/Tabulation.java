package SubSetSumStrategy;

public class Tabulation implements SubSetSumStrategy {

    @Override
    public boolean subSetSum(int n, int[] set) {
        boolean[][] table = new boolean[set.length + 1][n + 1];
        tab(n, set, table);
        return tab(n, set, table);
    }

    private boolean tab(int n, int[] set, boolean[][] table) {

        for (int i = 0; i <= set.length; i++) {
            table[i][0] = true;
        }

        for (int i = 1; i <= set.length; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = table[i - 1][j];

                if (j >= set[i - 1]) {
                    table[i][j] = table[i - 1][j] || table[i - 1][j - set[i - 1]];
                }
            }
        }
        return table[table.length - 1][table[0].length - 1];
    }

    @Override
    public String getName() {
        return "Tabulation";
    }

}
