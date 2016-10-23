/* Solution to the problem : https://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
Referred to in the topcoder dynamic programming tutorial
*/
import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BadNeighbors {

	public static void main(String args[]){
		System.out.println(new BadNeighbors().maxDonations(new int[]

				{ 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
						6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
						52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 }


		));
	}

	public int maxDonations(int[] donations){
		int[] val = new int[donations.length];
		Arrays.fill(val, 0);
		for(int i = 0;i<donations.length;i++)
			val[i] = donations[i];
		int max = Math.max(donations[0], donations[1]);
		for(int i = 2;i<donations.length-1;i++){
			val[i] = Math.max(val[i-1], donations[i] + val[i-2]);
			max = Math.max(max, val[i]);
		}
		Arrays.fill(val, 0);
		for(int i = 0;i<donations.length;i++)
			val[i] = donations[i];
		for(int i = 3;i<donations.length;i++){
			val[i] = Math.max(val[i-1], donations[i] + val[i-2]);
			max = Math.max(max, val[i]);
		}
		return max;
	}
}
