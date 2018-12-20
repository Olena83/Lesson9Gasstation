package Gasstation;

import com.sun.org.apache.bcel.internal.classfile.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static Gasstation.Petrol.A_95;
import static Gasstation.Petrol.A_98;
import static Gasstation.Petrol.DIESEL;
import static Gasstation.Stage.*;

public class appGas {
    public static void main(String[] args) throws IOException {
        Stage stage = START;

        String input = " ";
        String input1;

        int sum = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            // вітаюся, питаю чи йдкм дальше + кажу шо `q` -- вихід
            System.out.println("Hi, welcome to Gas Station!");
            do {
                if (START.equals(stage)) {
                    System.out.println("Do you need some petrol? Press 'y' to yes  or press 'q' to quit.");
                    input = bufferedReader.readLine();
                    if (input.equals("y")) {
                        stage = ORDER;
                    } else if (input.equals("q")) {
                        System.out.println(" ");
                    } else {
                        System.out.println("You can only enter y or q");
                        stage = START;
                    }
                }

                if (ORDER.equals(stage)) {
                    // виведу всі можливі вили пального і спитаю шо він хоче
                    System.out.println("Please select petrol: 95, 98 ,Diesel, or  press 'q' to exit.");
                    input = bufferedReader.readLine();
                    if (( input.equals(A_95.getDescription()) ) || ( input.equals(A_98.getDescription()) )
                            || ( input.equals(DIESEL.getDescription()) )) {
                        stage = CASH;
                    } else if (input.equals("q")) {
                        System.out.println(" ");
                    } else {
                        System.out.println("You can only enter 95, 98 ,Diesel or  press 'q'");
                        stage = ORDER;
                    }
                }
                if (CASH.equals(stage)) {
                    //запитаю ск-ки літрів пального потрібно і виведу ціну пального
                    if (input.equals(A_95.getDescription())) {
                        System.out.println("One litter costs 30 grn");
                        stage = VOLUME;
                    }
                    if (input.equals(A_98.getDescription())) {
                        System.out.println("One litter costs 50 grn");
                        stage = VOLUME;
                    }
                    if (input.equals(DIESEL.getDescription())) {
                        System.out.println("One litter costs 40 grn");
                        stage = VOLUME;
                    }
                }
                if (VOLUME.equals(stage)) {
                    System.out.println("How much litters do you want?(You can only enter a number)");
                    input1 = bufferedReader.readLine();
                    if (input.equals(A_95.getDescription())) {
                        System.out.println("You need to pay: " + Integer.parseInt(input1) * 30);
                        sum = sum + Integer.parseInt(input1) * 30;
                        System.out.println("Do you need more?(y/q)");
                        input = bufferedReader.readLine();
                        if (input.equals("y")) {
                            stage = ORDER;
                        } else if (input.equals("q")) {
                            System.out.println(" ");
                        } else {
                            System.out.println("You can only enter y or q");
                            stage = ORDER;
                        }
                    }

                    if (input.equals(A_98.getDescription())) {
                        System.out.println("You need to pay: " + Integer.parseInt(input1) * 50);
                        sum = sum + Integer.parseInt(input1) * 50;
                        System.out.println("Do you need more?(y/q)");
                        input = bufferedReader.readLine();
                        if (input.equals("y")) {
                            stage = ORDER;
                        } else if (input.equals("q")) {
                            System.out.println(" ");
                        } else {
                            System.out.println("You can only enter y or q");
                            stage = ORDER;
                        }
                    }

                    if (input.equals(DIESEL.getDescription())) {
                        System.out.println("You need to pay: " + Integer.parseInt(input1) * 40);
                        sum = sum + Integer.parseInt(input1) * 40;
                        System.out.println("Do you need more?(y/q)");
                        input = bufferedReader.readLine();
                        if (input.equals("y")) {
                            stage = ORDER;
                        } else if (input.equals("q")) {
                            System.out.println(" ");
                        } else {
                            System.out.println("You can only enter y or q");
                            stage = ORDER;
                        }
                    }
                }

            } while (! input.equals("q"));
            System.out.println("You need to pay: " + sum + "$");
            System.out.println("Bye!");
        }
    }
}




