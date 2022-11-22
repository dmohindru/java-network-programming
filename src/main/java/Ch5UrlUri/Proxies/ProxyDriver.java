package Ch5UrlUri.Proxies;

import java.net.InetAddress;
import java.net.ProxySelector;
import java.net.UnknownHostException;

public class ProxyDriver {

    public static void main(String[] args) {

        // Set default proxy server
        ProxySelector selector = new LocalProxySelector();
        ProxySelector.setDefault(selector);

        try {
            InetAddress address = InetAddress.getByName("www.oreilly.com");
            System.out.println(address);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


    }
}
