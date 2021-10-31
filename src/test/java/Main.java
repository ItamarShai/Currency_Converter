import Currency.Coin;
import Currency.CoinFactory;
import Currency.ILS;
import Currency.USD;
import Enums.Coins;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Introduction Screen:
        System.out.println("Welcome to the Currency Converter");
        boolean isUserActive = true;
        while (isUserActive) {
            System.out.println("Please Choose an Option:");
//        Choice Screen:
            System.out.println("1. Dollars to Shekel");
            System.out.println("2. Shekel to Dollars");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
//            while (choice != 1 && choice != 2) {
//                System.out.println("Invalid choice, please choose again");
//                choice = scanner.nextInt();
//        USD to ILS Screen:
            if (choice == 1) {
                System.out.println("Please enter amount to convert from USD to ILS");
                double input = scanner.nextDouble();
                Coin ilsValue = CoinFactory.getCoinInstance(Coins.USD);
                USD usd = new USD();
                double value = usd.calculate(input);
                System.out.println("Dollars: " + input);
                System.out.println("Shekel: " + value);
//        ILS to USD Screen:
            } else if (choice == 2) {
                System.out.println("Please enter amount to convert from ILS to USD");
                double input = scanner.nextDouble();
                Coin usdValue = CoinFactory.getCoinInstance(Coins.ILS);
                ILS ils = new ILS();
                double value = ils.calculate(input);
                System.out.println("Shekels: " + input);
                System.out.println("Dollars: " + value);
            } else if (choice != 1 && choice != 2) {
                System.out.println("Invalid Choice, please choose again");
            }
//        Start Over Screen:
            System.out.println("Start Over?");
            String startOver = scanner.next();
            if (startOver.equals("N")){
                System.out.println("Thanks for using our Currency Converter");
                isUserActive = false;
            } else if (!startOver.equals("Y")){
                System.out.println("Invalid choice, please chose again");
            }
        }

    }
}