import java.io.*;
import java.util.Scanner;

//Kyle Morgan
// This program takes the name of a file and scans over the file and counts
// how many lines are integers and how many are unparsable and spits out the total and average
public class AverageNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of the input file: ");
        String fileName = in.nextLine();
        
        try {
            File file = new File(fileName);
            Scanner fileIn = new Scanner(file);
            int parsable = 0;
            int unparsable = 0;
            double sum = 0;
            
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                try {
                    int num = Integer.parseInt(line);
                    sum += num;
                    parsable++;
                } catch (NumberFormatException e) {
                    System.out.println("Cannot parse " + line + " as an integer");
                    unparsable++;
                }
            }
            double average = sum / parsable;
            System.out.println("Number of parsable lines: " + parsable);
            System.out.println("Average value: " + average);
            System.out.println("Number of unparsable lines: " + unparsable);
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find File: " + fileName);
            System.exit(1);
        }
        in.close();
    }
}
