package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("input number of candies (for example 15)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int candies = 0;
        boolean isValid = true;
        while (isValid) {
            try {
                candies = Integer.parseInt(bufferedReader.readLine());
                if (candies <= 0) {
                    throw new NumberFormatException();
                }
                isValid = false;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Wrong input format. Repeat input");
                isValid = true;
            }
        }

        System.out.println("input ratio exchange for 1 candy (for example 3)");

        int ratio = 0;
        isValid = true;
        while (isValid) {
            try {
                ratio = Integer.parseInt(bufferedReader.readLine());
                if (ratio <= 0) {
                    throw new NumberFormatException();
                }
                isValid = false;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Wrong input format. Repeat input");
                isValid = true;
            }
        }

        int wrap = candies;
        int tempCandie = 0;
        int balance = 0;

        while (true) {
            if (wrap >= ratio) {
                tempCandie = wrap / ratio;
                candies = candies + tempCandie;
                balance = wrap % ratio;
                wrap = tempCandie + balance;
            } else {
                break;
            }
        }
        System.out.println("You may got " + candies + " candies and " + wrap + " wrap ;)");

    }
}
