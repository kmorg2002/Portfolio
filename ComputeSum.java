import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputeSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n1 = readIntGreaterThanOrEqualTo(input, 0);
		int n2 = readIntGreaterThanOrEqualTo(input, n1);
        double exp = readDouble(input);
        double sum = 0;

		for (int i = n1; i <= n2; i++){
            sum += Math.pow(i, exp);
        }
        System.out.println("The sum of " + n1 + "^" + exp + " + "+ n2 + "^" + exp + " is " + sum);	
	}

    public static int readIntGreaterThanOrEqualTo(Scanner input, int lowerBound){
        int n = 0;
        boolean work = false;
        while (!work){  
            try{
                System.out.print("Enter an integer greater than or equal to " + lowerBound + ":");
                n = input.nextInt();
                work = true;
            } catch (InputMismatchException e){
                System.out.println("Try again, Please enter an integer.");
                input.next();
            }
            if (n < lowerBound) {
                System.out.println("Invalid. Enter an integer greater than or equal to " + lowerBound + ":");
                work = false;
            }
        }
        return n;    
    }

    public static double readDouble(Scanner input){
        boolean work = false;
        double n = 0.0;
        while (!work) {
            try{
                System.out.print("Enter a floating point number:");
                n = input.nextDouble();
                work = true;
            } catch (InputMismatchException e) {
                System.out.print("Try again. A floating point number is required.");
                input.next();
            }
        }
        return n;
    }
}
