/**
 * Problem Set 4.
 *
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 *
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 *
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Scanner;
public class ProblemSet4 {
  private static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
    ProblemSet4 ps = new ProblemSet4();

    // comment out or uncomment as needed

    // ps.sum();
    // ps.reverse();
    // ps.digits();
    // ps.average();
    // ps.prime();
    // ps.fibonacci();
    // ps.factors();
    ps.mario();
    ps.luigi();
    ps.credit();

    in.close();
  }

    /*
     * Exercise 1.
     *
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     *
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */

    public void sum() {
      int lowerBound = 1;
      int upperBound = 0;
      int integerSum = 0;

      System.out.println("");
      while (lowerBound > upperBound) {
        System.out.print("Lower bound: ");
        lowerBound = in.nextInt();
        System.out.print("Upper bound: ");
        upperBound = in.nextInt();
      }

      for (int i = lowerBound; i <= upperBound; i++) {
        if (i % 2 == 0) {
          integerSum += i;
        }
      }

      System.out.printf("\n%,d.\n", integerSum);
    }

    /*
     * Exercise 2.
     *
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */

    public void reverse() {
      int forwardPositiveIntegerInput;
      System.out.println("");
      do {
        System.out.print("Positive integer: ");
        forwardPositiveIntegerInput = in.nextInt();
      } while (forwardPositiveIntegerInput <= 0);
      String forwardPositiveInteger = String.valueOf(forwardPositiveIntegerInput);
      String reversePositiveInteger = "";
      String digitToAdd = "";

      for (int i = forwardPositiveInteger.length(); i > 0; i--) {
        if(i != forwardPositiveInteger.length()) {
          reversePositiveInteger = reversePositiveInteger + ", ";
        }
        digitToAdd = forwardPositiveInteger.substring(i - 1, i);
        reversePositiveInteger = reversePositiveInteger + digitToAdd;
      }
      reversePositiveInteger = reversePositiveInteger + ".";

      System.out.println("\n" + reversePositiveInteger);
    }

    /*
     * Exercise 3.
     *
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */

    public void digits() {
      int oddDigitInteger;
      int oddDigitSum = 0;

      System.out.println("");
      do {
        System.out.print("Positive integer: ");
        oddDigitInteger = in.nextInt();
      } while (oddDigitInteger <= 0);
      String oddDigitString = String.valueOf(oddDigitInteger);
      int integerToAdd;

      for (int i = oddDigitString.length(); i > 0; i--) {
        integerToAdd = Integer.parseInt(oddDigitString.substring(i - 1, i));
        if(integerToAdd % 2 == 1) {
          oddDigitSum += integerToAdd;
        }
      }

      System.out.println("\n" + oddDigitSum + ".");
    }

    /*
     * Exercise 4.
     *
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */

    public void average() {
      int integerListItem = 0;
      int integerListTotal = 0;
      int numNonNegativeIntegers = 0;

      System.out.println("");
      do {
        System.out.print("Non-negative integer: ");
        integerListItem = in.nextInt();
        if(integerListItem >= 0) {
          integerListTotal += integerListItem;
          numNonNegativeIntegers++;
        }
      } while (integerListItem >= 0);

      if (numNonNegativeIntegers > 0) {
        double nonNegativeIntegerAverage = (double) integerListTotal / (double) numNonNegativeIntegers;
        System.out.printf("\n%,.2f\n", nonNegativeIntegerAverage);
      } else {
        System.out.println("\nIn order for the program to work, you need to input at least one number to average before entering a negative to end the program.");
      }
    }

    /*
     * Exercise 5.
     *
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */

    public void prime() {
      int maybePrimeInteger = -1;
      boolean isPrime = true;
      boolean isValid = true;

      System.out.println("");
      while (maybePrimeInteger < 0) {
        System.out.print("Non-negative integer: ");
        maybePrimeInteger = in.nextInt();
      }

      if (maybePrimeInteger == 0 || maybePrimeInteger == 1) {
        isValid = false;
      }

      int divisibleNumber = maybePrimeInteger - 1;
      while (divisibleNumber > 1 && isValid == true) {
        int remainder = maybePrimeInteger % divisibleNumber;
        if (remainder != 0) {
          divisibleNumber--;
        } else {
          isPrime = false;
          divisibleNumber = 0;
        }
      }
      if (isValid == true) {
        if (isPrime == true) {
          System.out.println("\nPrime.");
        } else {
          System.out.println("\nNot prime.");
        }
      } else {
        System.out.println("\nNeither prime nor composite.");
      }
    }

    /*
     * Exercise 6.
     *
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */

     public void fibonacci() {
         int n = 0;
         System.out.println("");
         while (n <= 0 || n > 92) {
             System.out.print("Positive integer: ");
             n = in.nextInt();
         }

         long base1 = 0;
         long base2 = 1;
         long fibonacci = 0;

         for (int i = 2; i <= n; i++) {
             fibonacci = base1 + base2;
             base1 = base2;
             base2 = fibonacci;
         }

         System.out.println("\n" + base2 + ".");
     }

    /*
     * Exercise 7.
     *
     * Prompt the user to enter a positive integer. What are its factors?
     */

    public void factors() {
      int intToFactor = 0;
      System.out.println(" ");
      while (intToFactor <= 0) {
          System.out.print("Positive integer: ");
          intToFactor = in.nextInt();
      }

      String usedFactors = " ";
      int factor1;
      int factor2;
      boolean lineStarted = false;
      double factoringRemainder;

      for (int i = 1; i <= intToFactor; i++) {
        factor1 = i;
        factoringRemainder = (double) intToFactor % (double) factor1;
        factor2 = intToFactor / factor1;
        if (factoringRemainder == 0 && !usedFactors.contains(String.valueOf(" " + factor1 + " ")) && !usedFactors.contains(String.valueOf(" " + factor2 + " "))) {
          usedFactors = usedFactors + factor1 + " " + factor2 + " ";
          if (lineStarted == true) {
            System.out.print(", ");
          } else {
            System.out.println(" ");
          }
          System.out.print(factor1 + ", " + factor2);
          lineStarted = true;
        }
      }
      System.out.print(".");
    }

    /*
     * Exercise 8.
     *
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */

    public void mario() {
      int halfPyramidHeight = 0;
      int numHashtags;
      int numSpaces;
      System.out.println("");
      while (halfPyramidHeight < 1 || halfPyramidHeight > 24) {
          System.out.print("Height: ");
          halfPyramidHeight = in.nextInt();
      }
      System.out.println("");
      for (int i = 1; i <= halfPyramidHeight; i++) {
        numHashtags = i;
        numSpaces = halfPyramidHeight - numHashtags - 1;
        for (int x = 0; x <= numSpaces; x++) {
          System.out.print(" ");
        }
        for (int y = 0; y <= numHashtags; y++) {
          System.out.print("#");
        }
        System.out.print("\n");
      }
    }

    /*
     * Exercise 9.
     *
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */

    public void luigi() {

    }

    /*
     * Exercise 10.
     *
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */

    public void credit() {
      System.out.println("");
      in.nextLine();
      System.out.print("Number: ");
      String cardNumber = in.nextLine();
      int sumEveryOtherDigit = 0;
      int digitToMultiply;
      int totalSum = 0;
      for (int i = cardNumber.length() - 2; i >= 0; i -= 2) {
        digitToMultiply = Character.getNumericValue(cardNumber.charAt(i));
        sumEveryOtherDigit = digitToMultiply * 2;
          if (sumEveryOtherDigit >= 10) {
            totalSum += (int)((sumEveryOtherDigit / Math.pow(10, 0)) % 10) + (int)((sumEveryOtherDigit / Math.pow(10, 1)) % 10);
          } else {
            totalSum += sumEveryOtherDigit;
          }
      }
      for (int i = cardNumber.length() - 1; i >= 0; i -= 2) {
        digitToMultiply = Character.getNumericValue(cardNumber.charAt(i));
        totalSum += digitToMultiply;
      }
      String everyOtherDigitString = Integer.toString(totalSum);
      if (everyOtherDigitString.charAt(everyOtherDigitString.length() - 1) == '0') {
        if (cardNumber.charAt(0) == '3' && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7')) {
          System.out.println("\nAmex.");
        } else if (cardNumber.charAt(0) == '5' && (cardNumber.charAt(1) == '1' || cardNumber.charAt(1) == '2' || cardNumber.charAt(3) == '3' || cardNumber.charAt(4) == '4' || cardNumber.charAt(5) == '5')) {
          System.out.println("\nMastercard.");
        } else if (cardNumber.charAt(0) == '4') {
          System.out.println("\nVisa.");
        }
      } else {
        System.out.println("\nInvalid.");
      }
    }
}
