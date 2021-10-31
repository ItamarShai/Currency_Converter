import Currency.Coin;
import Currency.CoinFactory;
import Currency.ILS;
import Currency.USD;
import Enums.Coins;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File results = new File("results.txt");
        FileOutputStream toResults = new FileOutputStream(results);

        ArrayList<Double> resultsInUSD = new ArrayList<Double>();
        ArrayList<Double> resultsInILS = new ArrayList<Double>();

//        Introduction Screen:

        System.out.println("Welcome to the Currency Converter");

        boolean isUserActive = true;

        while (isUserActive) {
            System.out.println("Please Choose an Option:");
//        Choice Screen:
            for (int i = 0; i < 1;) {
                System.out.println("1. Dollars to Shekel");
                System.out.println("2. Shekel to Dollars");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
//        USD to ILS Screen:
                if (choice == 1) {
                    System.out.println("Please enter amount to convert from USD to ILS");
                    double input = scanner.nextDouble();
                    Coin ilsValue = CoinFactory.getCoinInstance(Coins.USD);
                    USD usd = new USD();
                    double value = usd.calculate(input);
                    System.out.println("Dollars: " + input);
                    System.out.println("Shekel: " + value);
                    i++;
                    resultsInILS.add(value);
                    try {
                        DataOutputStream valueOutput = new DataOutputStream(toResults);
                        valueOutput.writeChars(Double.toString(value));
                        valueOutput.writeChars(" ILS, ");
                    } catch (IOException e){
                        System.out.println("IOException: " + e);
                    }
//        ILS to USD Screen:
                } else if (choice == 2) {
                    System.out.println("Please enter amount to convert from ILS to USD");
                    double input = scanner.nextDouble();
                    Coin usdValue = CoinFactory.getCoinInstance(Coins.ILS);
                    ILS ils = new ILS();
                    double value = ils.calculate(input);
                    System.out.println("Shekels: " + input);
                    System.out.println("Dollars: " + String.format("%.2f", value));
                    i++;
                    resultsInUSD.add(value);
                    try {
                        DataOutputStream valueOutput = new DataOutputStream(toResults);
                        valueOutput.writeChars(Double.toString(value));
                        valueOutput.writeChars(" USD, ");
                    } catch (IOException e){
                        System.out.println("IOException: " + e);
                    }
//        Invalid Choice Screen
                } else {
                    System.out.println("Invalid Choice, please choose again");
                }
            }
//        Start Over Screen:
                System.out.println("Start Over?");
            Scanner scanForRestart = new Scanner(System.in);
                String startOver = scanForRestart.next();
                if (startOver.equals("N")) {
                    System.out.println("Thanks for using our Currency Converter");
                    System.out.println(resultsInILS + " Shekels");
                    System.out.println(resultsInUSD + " Dollars");
                    isUserActive = false;
                } else if (!startOver.equals("Y")) {
                    System.out.println("Invalid choice, please choose again");
                }
            }
        }
    }