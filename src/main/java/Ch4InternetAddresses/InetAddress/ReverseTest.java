package Ch4InternetAddresses.InetAddress;

import java.net.*;

public class ReverseTest {

  public static void main (String[] args) throws UnknownHostException {
    InetAddress ia = InetAddress.getByName("104.74.35.99");
    System.out.println(ia.getCanonicalHostName());
    System.out.println(ia.getHostName());
    System.out.println(ia);
  }
}
