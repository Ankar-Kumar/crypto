import java.math.BigInteger;
import java.util.Random;

public class RabinMiller {
    static BigInteger bigmod(BigInteger a, BigInteger b, BigInteger m) {
        BigInteger res = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(b) <= 0; i = i.add(BigInteger.ONE)) {
            res = res.multiply(a).mod(m);
        }
        return res;
    }

    static boolean robinMiller(BigInteger p) {
        BigInteger m = p.subtract(BigInteger.ONE);
        BigInteger b = BigInteger.ZERO;
        while (m.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            m = m.divide(BigInteger.TWO);
            b = b.add(BigInteger.ONE);
        }

        BigInteger a = BigInteger.ONE.add(new BigInteger(p.bitCount(), new Random()));
        BigInteger j = BigInteger.ZERO;
        BigInteger z = bigmod(a, m, p);
        if (z.equals(BigInteger.ONE) || z.equals(p.subtract(BigInteger.ONE))) {
            return true;
        }

        while (j.compareTo(BigInteger.ZERO) > 0 && z.equals(BigInteger.ONE)) {
            return false;
        }

        j = j.add(BigInteger.ONE);
        while (j.compareTo(b) < 0 && !z.equals(p.subtract(BigInteger.ONE))) {
            z = z.multiply(z).mod(p);
            j = j.add(BigInteger.ONE);
        }

        if (z.equals(p.subtract(BigInteger.ONE))) {
            return true;
        }

        if (j.equals(b) && !z.equals(p.subtract(BigInteger.ONE))) {
            return false;
        }

        return false;
    }

    static boolean isPrime(BigInteger p, int iter) {
        if (p.equals(BigInteger.TWO) || p.equals(BigInteger.valueOf(3))) {
            return true;
        }
        if (p.equals(BigInteger.ONE) || p.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            return false;
        }

        for (int i = 0; i < iter; i++) {
            if (!robinMiller(p)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BigInteger num; // 180181
        System.out.print("Enter a number: ");
        num = new BigInteger(System.console().readLine());

        int test;
        System.out.print("Enter number of Test: ");
        test = Integer.parseInt(System.console().readLine());

        if (isPrime(num, test)) {
            System.out.println("May be Prime");
        } else {
            System.out.println("Definitely not prime");
        }
    }
}
