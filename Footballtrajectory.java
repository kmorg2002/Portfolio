import java.util.Scanner;

public class Footballtrajectory {
    public static void main(String[] args){
      double GRAVITY = -9.8;
      double SINX = .707;
      double COSX = .707;
      Scanner vel = new Scanner(System.in);
      System.out.println("Enter velocity:");
      Double velocity = vel.nextDouble();
      


      double x = 0;
      double t = 0;
      t = (velocity * SINX) / (-(GRAVITY) / 2);
      x = velocity * COSX * t;
      vel.close();
    
      System.out.println("The football will fly " + x + " meters with a hangtime of " + t + " seconds.");



    }
}