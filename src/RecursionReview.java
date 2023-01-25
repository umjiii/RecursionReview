import java.util.ArrayList;
import java.util.Arrays;

public class RecursionReview
{
    public static void main(String[] args) //main execution
    {
        //Test cases for count3
        System.out.println("count3(313) ==> " + count3(313));
        System.out.println("count3(3) ==> " + count3(3));
        System.out.println("count3(456) ==> " + count3(456));

        //Test cases for multiply
        System.out.println("multiply(0, 10) ==> " + multiply(0, 10));
        System.out.println("multiply(1, 5) ==> " + multiply(1, 5));
        System.out.println("multiply(18, 8) ==> " + multiply(18, 8));

        //Test cases for isPrime
        System.out.println("isPrime(919, 2) ==> ");
        System.out.println("isPrime(50, 2) ==> ");
        System.out.println("isPrime(2, 2) ==> ");

        //Test cases for dupVowel
        System.out.println("dupVowel(\"hello\") ==> " + dupVowel("hello"));
        System.out.println("dupVowel(\"xxyy\") ==> " + dupVowel("xxyy"));
        System.out.println("dupVowel(\"abc\") ==> " + dupVowel("abc"));
    }

    //-------methods------

    //count3: Given a non-negative int n, recursively count the occurrences of 3 as a digit.
    public static int count3(int num)
    {
        //ensure num is not negative. if so, throw new exception
        if (num < 0) throw new IllegalArgumentException("The integer used for this method must be greater than zero.");

        //base case
        else if (num < 10 && num == 3) return 1;

        //recursive case.
        else if (num > 9) return count3(num / 10) + count3(num % 10);

        //returns 0 if the digit at-hand is not 3.
        else return 0;
    }

    //multiply: Accepts two numbers and performs multiplication by recursively adding the same number multiple times.
    public static int multiply(int num, int times)
    {
        //recursive case
        if (times > 0) return num + multiply(num, times - 1);

        //base case; returns 0 if times = 0.
        else return 0;
    }

    /* isPrime: Determines if a number is prime. Recursively
    determines if the any number less the number are divisible by the number. */
    public static boolean isPrime(int numToCheck, int count)
    {
        if (numToCheck % count == 0 && numToCheck != count)
            return true;

        else if (count != numToCheck)
            return isPrime(numToCheck, count + 1);

        else
            return false;

        
    }


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

            //recursive case; if the letter in question (the first letter of the string) is a vowel
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

}
