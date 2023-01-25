/*
Author: Stephen Arel
Class: CSC240
Assignment: Lab 0 Recursion Review
Purpose: Using several methods, the goal of this program
        is to help reinforce the concept of recursion and using it in
        situations that would otherwise be trivial with other concepts such as loops.
        This practice helps reinforce the understanding of different ways that
        recursion can be used (evaluating characters of Strings, array elements, etc.).
 */

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionReview
{
    public static void main(String[] args) //main execution
    {
        //------Test cases for count3
        System.out.println("\n---Testing count3---");

        System.out.println("count3(313) ==> " + count3(313));
        System.out.println("count3(3) ==> " + count3(3));
        System.out.println("count3(456) ==> " + count3(456));

        //------Test cases for multiply
        System.out.println("\n---Testing multiply---");

        System.out.println("multiply(0, 10) ==> " + multiply(0, 10));
        System.out.println("multiply(1, 5) ==> " + multiply(1, 5));
        System.out.println("multiply(18, 8) ==> " + multiply(18, 8));

        //------Test cases for isPrime
        System.out.println("\n---Testing isPrime---");

        System.out.println("isPrime(919, 2) ==> " + isPrime(919, 2));
        System.out.println("isPrime(50, 2) ==> " + isPrime(50, 2));
        System.out.println("isPrime(2, 2) ==> " + isPrime(2, 2));

        //------Test cases for dupVowel
        System.out.println("\n---Testing dupVowel---");

        System.out.println("dupVowel(\"hello\") ==> " + dupVowel("hello"));
        System.out.println("dupVowel(\"xxyy\") ==> " + dupVowel("xxyy"));
        System.out.println("dupVowel(\"abc\") ==> " + dupVowel("abc"));

        //------Test cases for array10:
        System.out.println("\n---Testing array10---");

        //Arrays for testing
        int[] arrayFirst = new int[3];
            arrayFirst[0] = 10;
            arrayFirst[1] = 20;
            arrayFirst[2] = 31;

        int[] arraySec = new int[2];
            arraySec[0] = 11;
            arraySec[1] = 10;

        int[] arrayThird = new int[4];
            arrayThird[0] = 1;
            arrayThird[1] = 2;
            arrayThird[2] = 3;
            arrayThird[3] = 4;

        System.out.println("array10([10, 20, 31]) ==> " + array10(arrayFirst));
        System.out.println("array10([11, 10]) ==> " + array10(arraySec));
        System.out.println("array10([1, 2, 3, 4]) ==> " + array10(arrayThird));
    }

    //-------methods------

    //------ count3: Given a non-negative int n, recursively count the occurrences of 3 as a digit.
    public static int count3(int num)
    {
        //ensure num is not negative. if so, throw new exception
        if (num < 0) throw new IllegalArgumentException("The integer used for this method must be greater than zero.");

        //base case
        else if (num == 3) return 1;

        //recursive case.
        else if (num > 9) return count3(num / 10) + count3(num % 10);

        //returns 0 if the digit at-hand is not 3.
        else return 0;
    }

    //------ multiply: Accepts two numbers and performs multiplication by recursively adding the same number multiple times.
    public static int multiply(int num, int times)
    {
        //recursive case
        if (times > 0) return num + multiply(num, times - 1);

        //base case; returns 0 if times = 0.
        else return 0;
    }

    /*------ isPrime: Determines if a number is prime. Recursively
    determines if the any number less the number are divisible by the number. */
    public static boolean isPrime(int numToCheck, int count)
    {
        //base case
        if (numToCheck % count == 0 && numToCheck != count && numToCheck != 1)
            return false;

        //recursive case
        else if (!(numToCheck >= count))
            return isPrime(numToCheck, count + 1);

        //base case
        else
            return true;

        
    }

    //------ dupVowel: Given a String, recursively builds a new string where the vowels are duplicated.
    public static String dupVowel(String str)
    {

        if (str.length() == 1)
        {
            str += " ";
        }

        //base case; if there are no letters left in the string
        if (str.indexOf(" ") == 0)
        {
            return "";
        }

        //if there are multiple letters in the string
        if (str.length() > 0 )
        {

            char[] vowelsArray = new char[5];
            vowelsArray[0] = 'a';
            vowelsArray[1] = 'e';
            vowelsArray[2] = 'i';
            vowelsArray[3] = 'o';
            vowelsArray[4] = 'u';

            //recursive cases; if the letter in question (the first letter of the string) is a vowel
            if (new String(vowelsArray).indexOf(str.charAt(0)) != -1)
            {
                return str.charAt(0) + "" + str.charAt(0) + "" + dupVowel(new String(str.substring(1)));
            }
            else
            {
                return str.charAt(0) + "" + "" + dupVowel(new String(str.substring(1)));
            }
        }
        else return "";

    }

    /*
    ------ array10: Given an array of ints, recursively computes the number of times that
    a multiple of 10 appears in the array. index is used to examine a specific element from the array.
    Uses a helper function (array10Helper) to incorporate an index to count through elements in the array.
     */
    public static int array10(int[] nums)
    {
        return array10Helper(nums, nums.length - 1);
    }

    //array10Helper: Helper method to incorporate index to count through array elements.
    public static int array10Helper(int[] nums, int index)
    {
        //recursive cases: if there are still values to evalulate
        if (index > 0)
        {
            if (nums[index] % 10 == 0)
                return 1 + array10Helper(nums, index - 1);
            else
                return array10Helper(nums, index - 1);
        }

        //base case: if index is at the last element to be evaluated and is a multiple of 10.
        else if (nums[index] % 10 == 0)
            return 1;
        //base case: if the index is at the last element to be evaluated and is not a multiple of 10.
        else
            return 0;
    }
}
