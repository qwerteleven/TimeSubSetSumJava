package Main;

import ReadFileData.ReadFile;
import SubSetSumStrategy.SubSetSumStrategy;
import SubSetSumStrategy.Memoization;
import SubSetSumStrategy.Tabulation;
import SubSetSumStrategy.RecursiveBruteForce;
import SubSetSumStrategy.RecursiveBackTraking;
import SubSetSumStrategy.IterBruteForce;
import SubSetSumStrategy.IterBackTraking;
import SubSetSumStrategy.Greedy;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println(
                      "ibf --------->  iterative brute force\n\r"
                    + "rbf --------->  recursive brute force\n\r"
                    + "ibt --------->  iterative backtreking\n\r"
                    + "rbt --------->  recursive backtrating\n\r"
                    + "tab --------->  tabulation           \n\r"
                    + "mem --------->  memoization          \n\r"
                    + "gre --------->  greedy               \n\r");
            return;
        }

        if (args.length != 4) {
            System.out.println("SYNTAX     ruteFile    lengthVector      SUM       STRATEGY     \n\r"
                             + "example:    data          100            45            1        \n\r");
            return;
        }

        int sum = Integer.parseInt(args[2]);
        boolean salida;
        SubSetSumStrategy strategy = null;
        String fileName = args[0];
        int size = Integer.parseInt(args[1]);
        double time_start;
        double restTime;

        switch (args[3]) {

            case "rbf":
                strategy = new RecursiveBruteForce();
                break;

            case "ibf":
                strategy = new IterBruteForce();
                break;

            case "ibt":
                strategy = new IterBackTraking();
                break;

            case "rbt":
                strategy = new RecursiveBackTraking();
                break;

            case "tab":
                strategy = new Tabulation();
                break;

            case "mem":
                strategy = new Memoization();
                break;

            case "gre":
                strategy = new Greedy();
                break;

            default:
                System.out.println("Strategy not fount");
                System.exit(-1);
        }

        ReadFile reader = new ReadFile(fileName, size);
        int[] set = reader.read();

        time_start = System.currentTimeMillis();
        salida = strategy.subSetSum(sum, set);
        restTime = (System.currentTimeMillis() - time_start) / 1000;

        System.out.println(strategy.getName() + restTime + " seconds\n\r");
        System.out.println(salida);

    }
}
