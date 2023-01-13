import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // byte > short > int > long > float > double

        int principal = (int) readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        
        while (true) {
            System.out.print(prompt);
            value = (scanner.nextFloat());
            if (min <= value && value <= max)
                break;
            System.out.println("Please enter a number between" + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        float monthlyRate = (annualInterest / 100) / 12;
        int period = years * 12;

        double mortgage = principal * ((monthlyRate * (Math.pow((monthlyRate + 1), period))) / ((Math.pow((monthlyRate + 1), period)) - 1));

        return mortgage;
    }

}