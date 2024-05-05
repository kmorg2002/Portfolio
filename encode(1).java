import java.io.*;
//Kyle Morgan
//This program asks the user for a file to encode and encodes it

public class encode {
  public static void main(String[] args) {
    try {
      BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Enter a file to encode.");
      String inputName = buff.readLine();
      System.out.print("Enter the desired output name.");
      String outputName = buff.readLine();
      FileInputStream in = new FileInputStream(inputName);
      FileOutputStream out = new FileOutputStream(outputName);
      int x;
      
      while ((x = in.read()) != -1) {
        out.write(x + 5);
      }
     
      in.close();
      out.close();

    } catch (IOException ex) {
      System.out.println("Invalid input.");
    }
  }
}