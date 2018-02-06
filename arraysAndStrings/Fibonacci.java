package arraysAndStrings;

public class Fibonacci {
    public static int fibonacci(int n) {
        int a = 0, b = 1, c = 0;
        int i;
        for(i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static void main(String args[]) {
        System.out.println(fibonacci(9));
    }
}