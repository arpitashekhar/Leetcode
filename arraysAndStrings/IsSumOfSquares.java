package arraysAndStrings;

import java.util.HashSet;

public class IsSumOfSquares {
	/*public static boolean sumOfSquares(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i <= Math.sqrt(n); i++) {
			if(set.contains(n - i*i)) {
				return true;
			} else {
				set.add(n - i*i);
			}
		}
		return false;
	}*/
	
	//Fermat's Theorem
	//Any positive number nn is expressible as a sum of two squares if and only if the prime factorization of nn, 
	//every prime of the form (4k+3)(4k+3) occurs an even number of times.
	
	public static boolean sumOfSquares(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
	
	public static void main(String[] args) {
		System.out.println(sumOfSquares(2));
	}
}
