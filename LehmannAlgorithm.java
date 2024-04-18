import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class LehmannAlgorithm {

    public static BigInteger bigMod(BigInteger a, BigInteger b, BigInteger m) {
        BigInteger res = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(b) <= 0; i = i.add(BigInteger.ONE)) {
            res = res.multiply(a).mod(m);
        }
        return res;
    }

    public static boolean lehmannAlgorithm(BigInteger p, int test) {
        if (p.equals(BigInteger.TWO) || p.equals(BigInteger.valueOf(3)))
            return true;
        if (p.equals(BigInteger.ONE) || p.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            return false;

        Random rand = new Random();
        for (int i = 0; i < test; i++) {
            BigInteger a = BigInteger.valueOf(2 + rand.nextInt(p.intValue() - 3));
            BigInteger L = bigMod(a, p.subtract(BigInteger.ONE).divide(BigInteger.TWO), p);
            if (!L.equals(BigInteger.ONE) && !L.equals(p.subtract(BigInteger.ONE)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        BigInteger num = scanner.nextBigInteger();

        System.out.print("Enter number of Test: ");
        int test = scanner.nextInt();

        boolean prime = lehmannAlgorithm(num, test);
        if (prime)
            System.out.println("May be Prime");
        else
            System.out.println("Definitely not prime");
        scanner.close();
    }
}
