import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // byte > short > int > long > float > double
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("APR: ");
        float rate = ((scanner.nextFloat() / 100) / 12);

        System.out.print("Period (Years): ");
        int period = scanner.nextInt() * 12;

        double apr = Math.pow((rate + 1), period);

        double mortgage = principal * ((rate * apr) / (apr - 1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Your mortgage payment is " + mortgageFormatted);
    }
}