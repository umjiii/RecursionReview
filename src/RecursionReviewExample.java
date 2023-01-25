/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.®®®
********	***********************************************************************/
public class RecursionReviewExample
{
	public static void main(String[] args) {
		/*
		a. base case - num < 10, return num
		b. recursive case - digit + sumDigits( num / 10)
		*/

		System.out.println( "sumDigits(126) = " + sumDigits(126));
		System.out.println( "sumDigits(49)  = " + sumDigits(49));
		System.out.println( "sumDigits(2)   = " + sumDigits(2));
		System.out.println();

	}

	// sumDigits will add the digits in a number
	public static int sumDigits( int num){
	//    if( num < 10 )              // base case
	//		return num;
	    if( num == 0)                 // alternate base case version
	        return 0;
	    else                        // recursive case
	        return num % 10 + sumDigits( num / 10 );
	}
}







