import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class rsa {

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;

    private int bitLength = 128;
    private SecureRandom rnd;

    public rsa() {
        rnd = new SecureRandom();
        p = BigInteger.probablePrime(bitLength, rnd);
        q = BigInteger.probablePrime(bitLength, rnd);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.valueOf(65537); // Common public exponent
        d = e.modInverse(phi); // Private exponent
    }

    public byte[] encrypt(String message) {
        BigInteger plaintext = new BigInteger(message.getBytes());
        // Compute the ciphertext c = m^e mod n
        BigInteger ciphertext = plaintext.modPow(e, n);
        return ciphertext.toByteArray();       
    }

    public String decrypt(byte[] ciphertext) {
        // Compute the ciphertext m = c^d mod n
        BigInteger decrypted = new BigInteger(ciphertext).modPow(d, n);
        return new String(decrypted.toByteArray());
    }

    public static void main(String[] args) {
        rsa rsa = new rsa();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a message to encrypt: ");
        String message = sc.nextLine();

        // Encryption
        byte[] encryptedBytes = rsa.encrypt(message);
        System.out.println("Encrypted: " + new String(encryptedBytes));

        // Decryption
        String decryptedMessage = rsa.decrypt(encryptedBytes);
        System.out.println("Decrypted: " + decryptedMessage);

        sc.close();
    }
}
