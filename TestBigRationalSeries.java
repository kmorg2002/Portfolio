import java.math.BigInteger;

public class TestBigRationalSeries {
    public static void main(String[] args) {
        BigRational sum = new BigRational(BigInteger.ZERO, BigInteger.ONE);
        for (int i = 1; i <= 99; i++) {
            BigRational frac = new BigRational(BigInteger.valueOf(i), BigInteger.valueOf(i+1));
            sum = sum.add(frac);
        }
        System.out.println("Series sum = " + sum.toString());
        System.out.println("Series sum = " + sum.doubleValue());
    }
}