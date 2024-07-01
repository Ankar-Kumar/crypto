import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class sha {
    public static String getMD5(String msg) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // passing data to the created msg digest
            // compute the msg digest
            byte[] messageDigest = md.digest(msg.getBytes());
            System.out.println(messageDigest);

            // Converting the byte array in to HexString format
            StringBuffer hexString = new StringBuffer(); // store the hexadecimal representation of the hash.

            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b)); // two-digit hexadecimal string
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String msg = sc.nextLine();
        System.out.println("MD5 generated hash code: " + getMD5(msg));

        sc.close();
    }
}
// fdc3e8d7e8562ac05f9b43d562818636
// 64618f6be0336cbffd8981a033c94b1ebe7a3debe725166403d6a995098c1c4b