package Ch3Threads.returninfo.racecondition;

import Ch3Threads.returninfo.ReturnDigest;

import javax.xml.bind.DatatypeConverter;

public class ReturnDigestUserInterface {



    // Second attempt to read digest in second loop
    public static void main(String[] args) {
        ReturnDigest[] digests = new ReturnDigest[args.length];
        for (int i = 0; i < args.length; i++) {
        // Calculate the digest
            digests[i] = new ReturnDigest(args[i]);
            digests[i].start();
        }
        for (int i = 0; i < args.length; i++) {
        // Now print the result
            StringBuffer result = new StringBuffer(args[i]);
            result.append(": ");
            byte[] digest = digests[i].getDigest();
            System.out.println("digest: " + digest);
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        }
    }
}