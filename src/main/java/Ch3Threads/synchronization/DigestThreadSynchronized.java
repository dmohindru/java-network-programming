package Ch3Threads.synchronization;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestThreadSynchronized extends Thread {

    private String filename;

    public DigestThreadSynchronized(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            // FileInputStream in = new FileInputStream(filename);
            InputStream in = getClass().getClassLoader().getResourceAsStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);
            while (din.read() != -1) ; // read entire file
            din.close();
            byte[] digest = sha.digest();
            synchronized (System.out) {
                System.out.print(filename + ": ");
                System.out.print(DatatypeConverter.printHexBinary(digest));
                System.out.println();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {

        for (String filename : args) {
            Thread t = new DigestThreadSynchronized(filename);
            t.start();
        }
    }
}