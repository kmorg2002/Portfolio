import java.math.BigInteger;

public class BigRational extends Number {
    private BigInteger numerator;
    private BigInteger denominator;

    public BigRational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    public BigRational(BigInteger numerator) {
        this(numerator, BigInteger.ONE);
    }

    public BigRational(long numerator, long denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    public BigRational(long numerator) {
        this(BigInteger.valueOf(numerator));
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public BigRational add(BigRational other) {
        BigInteger numer = numerator.multiply(other.getDenominator()).add(other.getNumerator().multiply(denominator));
        BigInteger denom = denominator.multiply(other.getDenominator());
        return new BigRational(numer, denom);
    }

    public BigRational subtract(BigRational other) {
        BigInteger numer = numerator.multiply(other.getDenominator()).subtract(other.getNumerator().multiply(denominator));
        BigInteger denom = denominator.multiply(other.getDenominator());
        return new BigRational(numer, denom);
    }

    public BigRational multiply(BigRational other) {
        BigInteger numer = numerator.multiply(other.getNumerator());
        BigInteger denom = denominator.multiply(other.getDenominator());
        return new BigRational(numer, denom);
    }

    public BigRational divide(BigRational other) {
        BigInteger numer = numerator.multiply(other.getDenominator());
        BigInteger denom = denominator.multiply(other.getNumerator());
        return new BigRational(numer, denom);
    }

    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int intValue() {
        return (int) doubleValue();
    }

    public long longValue() {
        return (long) doubleValue();
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}