/*Michael Lawson
 * Project Euler 119
 * 
The number 512 is interesting because it is equal to the sum of its digits raised to some power: 5 + 1 + 2 = 8, and 8^3 = 512.
Another example of a number with this property is 614656 = 28^4.
We shall define a(n) to be the nth term of this sequence and insist that a number must contain at least two digits to have a sum.
You are given that a2 = 512 and a10 = 614656.
Find a30.
*/

package projectEuler119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solve {
	/***
	 * Method baseAddition
	 * @param x longInt solution to a base raised to a power from Solve() method.
	 * @return A longInt of the addition of every digit from the value passed through the parameter x.
	 */
	long baseAddition(long x) {
		long xTemp = x;
		long addedNumber = 0;
		while(xTemp > 0) {
			addedNumber+= xTemp % 10;
			xTemp = xTemp / 10;
		}
		return addedNumber;
	}
	/***
	 * Constructor of the Solve class. Passes no arguments. Solves project Euler problem 119.
	 * @return Solution to project Euler problem 119.
	 */
	long Solve(){
		//Create an arrayList to store the base numbers that meet the criteria of the problem.
		List solutions = new ArrayList();
		//create the return value, answer.
		long answer = 0;
		
		//Search the first 100 base numbers with a value greater than 1.
		for (int i = 2; i < 100; i++) {
			//Raise each base number to a power of 2-9.
			for (int j = 2; j < 10; j++) {
				//check to see if the base number meets our criteria for being saved in the array using the baseAddition method.
				if (baseAddition((long)Math.pow(i, j)) == i) {
					//add to our array if true
					solutions.add((long)Math.pow(i,j));
				}
			}
		}
		//sort our array list because the solutions may have been found out of order.
		Collections.sort(solutions);
		//set the answer to index 29, which will correspond to the 30th(a30) solution in our array, which is the answer we're looking for.
		answer = (long) solutions.get(29);
		//return the correct answer
		return answer;
	}
}
