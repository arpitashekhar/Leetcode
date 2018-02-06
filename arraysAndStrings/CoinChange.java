package arraysAndStrings;

public class CoinChange{

	public static int NumberofCoins(int[] denomination,int value){
		 //Write your code here to find out minimum number of coins required to provide the change for given value.
		 //This method will have a denomination array and an int which specifies the value as inputs(Please see testcase file)
		 //This method should return the number of coins
        int count[] = new int [value + 1];
		int i, j, next;
		for (i = 1; i <= value; i++)
				count[i] = Integer.MAX_VALUE;
			
		for (i = 1; i <= value; i++)
			for(j = 0; j < denomination.length; j++)
				if(i >= denomination[j]) {
				    next = i - denomination[j];
					count[i] = Math.min(1 + count[next], count[i]);
				}
		return count[value];

	}
}
