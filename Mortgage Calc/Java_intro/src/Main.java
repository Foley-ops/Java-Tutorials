import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // byte > short > int > long > float > double
        Scanner scanner = new Scanner(System.in);

        int principal;
        float annualInterest;
        float rate;
        float monthlyRate;
        int period;


        while (true) {
            System.out.print("Principal ($1k - $1M): ");
            principal = scanner.nextInt();

            if (1000 <= principal && principal <= 1_000_000)
                break;
            System.out.println("Please enter a number between $1,000 and $1,000,000.");
        }

        while (true) {
            System.out.print("APR: ");
            annualInterest = (scanner.nextFloat());
            rate = annualInterest / 100;
            monthlyRate = rate / 12;

            if (0 < annualInterest && annualInterest <= 30)
                break;
            System.out.println("Please enter a number between 0 and 30.");
        }

        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextInt();

            if (1 <= period && period <= 30) {
                period = period * 12;
                break;
            }
            System.out.println("Please enter a number between 1 and 30.");
        }

        double apr = Math.pow((monthlyRate + 1), period);

        double mortgage = principal * ((monthlyRate * apr) / (apr - 1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Your mortgage payment is " + mortgageFormatted);
    }
}