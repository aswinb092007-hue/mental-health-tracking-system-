import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);

        in.nextToken();
        int n = (int) in.nval;

        long total = 0;
        int bestHouse = 1;
        long bestBill = -1;

        for (int i = 1; i <= n; i++) {
            in.nextToken();
            long units = (long) in.nval;

            long energy = 0;

            if (units > 500) {
                energy += 200;
            }

            if (units > 100) {
                energy += 3 * (Math.min(units, 300) - 100);
            }

            if (units > 300) {
                energy += 5 * (Math.min(units, 500) - 300);
            }

            if (units > 500) {
                energy += 8 * (units - 500);
            }

            long bill = 0;

            if (units > 0) {
                bill = energy + 50;
                bill = ((bill + 9) / 10) * 10;
            }

            total += bill;

            if (bill > bestBill) {
                bestBill = bill;
                bestHouse = i;
            }
        }

        System.out.println(total + " " + bestHouse);
    }
}
