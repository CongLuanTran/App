/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Scanner;

/**
 *
 * @author tranc
 */
public class App {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    private Fraction fraction1;
    private Fraction fraction2;
    private Fraction result;

    public static int getInteger(String message, String errorMessage) {
        int n;
        while (true) {
            try {
                System.out.print(message);
                n = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }

        return n;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        App app = new App();
        app.fraction1 = new Fraction();
        app.fraction2 = new Fraction();
        app.result = new Fraction();
        
        int n, a ,b;
        boolean cont = true;

        do {

            System.out.printf("Menu:\n"
                    + "1-Enter the first fraction.\n"
                    + "2-Enter the second fraction.\n"
                    + "3-Add 2 fractions.\n"
                    + "4-Subtract 2 fractions.\n"
                    + "5-Multiply 2 fractions.\n"
                    + "6-Divide 2 fractions.\n"
                    + "7-Exit.\n");
            
            String message = "Enter your choice, please: ";
            String errorMessage = "Please select a function from 1 to 7!";
            String integerError = "Please enter an integer!";
            String numeratorPrompt = "Enter the numerator: ";
            String denominatorPrompt = "Enter the denominator: ";

            boolean control1 = false;
            boolean control2 = false;

            n = getInteger(message, errorMessage);
            switch (n) {
                case 1:
                    try {
                        a = getInteger(numeratorPrompt, integerError);
                        b = getInteger(denominatorPrompt, integerError);

                        app.fraction1.setDenominator(b);
                        app.fraction1.setNumerator(a);

                        control1 = true;
                        System.out.println(app.fraction1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    if (!control1) {
                        System.out.println("Please enter the first fraction first!");
                        break;
                    }

                    try {
                        a = getInteger(numeratorPrompt, integerError);
                        b = getInteger(denominatorPrompt, integerError);

                        app.fraction2.setDenominator(b);
                        app.fraction2.setNumerator(a);

                        System.out.println(app.fraction2);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    if (!control1) {
                        System.out.println("Please enter the first fraction first!");
                        break;
                    }
                    if (!control2) {
                        System.out.println("Please enter the second fraction first!");
                        break;
                    }

                    app.result = app.fraction1.add(app.fraction2);
                    
                    System.out.println(app.fraction1 + " + " + app.fraction2 + " = " + app.result);
                    break;
                case 4:
                    if (!control1) {
                        System.out.println("Please enter the first fraction first!");
                        break;
                    }
                    if (!control2) {
                        System.out.println("Please enter the second fraction first!");
                        break;
                    }   

                    app.result = app.fraction1.subtract(app.fraction2);
                    
                    System.out.println(app.fraction1 + " - " + app.fraction2 + " = " + app.result);
                    break;
                case 5:
                    if (!control1) {
                        System.out.println("Please enter the first fraction first!");
                        break;
                    }
                    if (!control2) {
                        System.out.println("Please enter the second fraction first!");
                        break;
                    }
                    
                    app.result = app.fraction1.multiply(app.fraction2);
                    
                    System.out.println(app.fraction1 + " * " + app.fraction2 + " = " + app.result);
                    break;
                case 6:
                    if (!control1) {
                        System.out.println("Please enter the first fraction first!");
                        break;
                    }
                    if (!control2) {
                        System.out.println("Please enter the second fraction first!");
                        break;
                    }

                    try {
                        app.result = app.fraction1.divide(app.fraction2);
                        System.out.println(app.fraction1 + " / " + app.fraction2 + " = " + app.result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    cont = false;
                    break;
                default:
                    System.out.println("Please select a function from 1 to 7!");
                }
        } while (cont);
    }
}
