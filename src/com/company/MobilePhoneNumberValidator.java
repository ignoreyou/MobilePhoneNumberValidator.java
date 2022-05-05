package com.company;

import java.util.Scanner;


public class MobilePhoneNumberValidator {

    public void phoneNumberVerification() {
        Scanner number = new Scanner(System.in);
        System.out.print("Enter phone number: ");
        String phoneNumber;
        while (true) {
            phoneNumber = number.nextLine();
            if (operatorNumberCheck(phoneNumber)) {
                calculationPart(arrayConversion(phoneNumber));
                break;
            }
        }
    }

    public boolean checkString(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }

    public boolean operatorNumberCheck(String str) {
        String code;
        if (checkString(str.substring(1))) {
            switch (str.length()) {
                case 13:
                    if (str.startsWith("+380")) {
                        code = str.substring(3, str.length() - 7);
                        break;
                    } else {
                        System.out.print("You are mistaken. Re-enter phone number: ");
                        return false;
                    }
                case 12:
                    if (str.startsWith("380")) {
                        code = str.substring(2, str.length() - 7);
                        break;
                    } else {
                        System.out.print("You are mistaken. Re-enter phone number: ");
                        return false;
                    }
                case 10:
                    code = str.substring(0, str.length() - 7);
                    break;
                default:
                    System.out.print("You are mistaken. Re-enter phone number: ");
                    return false;
            }
        } else {
            System.out.print("You are mistaken. Re-enter phone number: ");
            return false;
        }

        switch (code) {
            case "039", "067", "068", "096", "097", "098", "063", "073", "093", "050", "066", "095", "099":
                System.out.println("Phone number is correct.");
                return true;
            default:
                System.out.print("Operator code entered incorrectly. Re-enter phone number: ");
                return false;
        }
    }

    public static int[] arrayConversion(String str) {
        if (str.startsWith("+"))
            str = str.substring(1);
        String[] strArray = str.split("");
        int[] array = new int[strArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }
        return array;
    }

    public void calculationPart(int[] array) {
        int sum1 = 0, sum2;
        for (int i = 0; i < array.length; i++) {
            sum1 += array[i];
        }
        System.out.println("1st round of calculation, sum is: " + sum1);

        sum2 = (sum1 % 10) + (sum1 / 10) % 10 + (sum1 / 100) % 10;
        System.out.println("2st round of calculation, sum is: " + sum2);
        while (sum2 > 9) {
            sum2 = (sum2 % 10 + (sum2 / 10) % 10);
            System.out.println("3st round of calculation, sum is: " + sum2);
        }

        switch (sum2) {
            case 1:
                System.out.println("Final result is: One");
                break;
            case 2:
                System.out.println("Final result is: Two");
                break;
            case 3:
                System.out.println("Final result is: Three");
                break;
            case 4:
                System.out.println("Final result is: Four");
                break;
            default:
                System.out.println("Final result is: " + sum2);
        }
    }
}
