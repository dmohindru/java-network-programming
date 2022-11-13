package Ch4InternetAddresses.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetByAddress {
    public static void main (String[] args) {
        try {
            // lesswrong.com ip address as of 14/10/22 - 18.67.111.23
            byte[] address = {18, 67, (byte)111, 23};
            InetAddress lessWrongAddress = InetAddress.getByAddress(address);
            System.out.println("lessWrongAddress(getByAddress): " + lessWrongAddress);
            // Making call with getByName and supplying dotted notation address
            // does not connect with local DNS server
            lessWrongAddress = InetAddress.getByName("18.67.111.23");
            System.out.println("lessWrongAddress(getByName(ip-address)): " + lessWrongAddress);
            lessWrongAddress = InetAddress.getByName("lesswrong.com");
            System.out.println("lessWrongAddress(getByName(hostname)): " + lessWrongAddress);

        } catch (UnknownHostException ex) {
            System.out.println("Could not find this computer's address.");
        }
    }
}
