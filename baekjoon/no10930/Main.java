import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {

    public void run() throws IOException, NoSuchAlgorithmException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        // 해싱
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedCode = digest.digest(input.getBytes(StandardCharsets.UTF_8));

        // 인코딩
        StringBuilder hexString = new StringBuilder(2 * hashedCode.length);
        for (int i = 0; i < hashedCode.length; i++) {
            String hex = Integer.toHexString(0xff & hashedCode[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        System.out.println(hexString);
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        new Main().run();
    }
}
