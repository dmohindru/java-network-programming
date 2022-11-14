package Ch4InternetAddresses.InetAddress;

import java.net.*;

public class AddressTests {

  public static int getVersion(InetAddress ia) {
    byte[] address = ia.getAddress();
    if (address.length == 4) return 4;
    else if (address.length == 16) return 6;
    else return -1;
  }

  public static void main(String[] args) throws UnknownHostException {
    InetAddress address = InetAddress.getLocalHost();
    System.out.println("Version of IP address: " + getVersion(address));
  }
}