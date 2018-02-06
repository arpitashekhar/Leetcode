package arraysAndStrings;

public class DecimalToBinary {
	public static void dtob(int decimal) {
		int binary = 0;
		String result = "";
		while(decimal >= 1) {
			binary = decimal % 2;
			decimal = decimal/2;
			result = Integer.toString(binary) + result;
		}
		System.out.println(result);
	}
	public static void main(String args[]) {
		dtob(10);
	}
}
