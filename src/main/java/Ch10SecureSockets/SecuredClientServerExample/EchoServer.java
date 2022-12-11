package Ch10SecureSockets.SecuredClientServerExample;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/*
This example is take from
https://www.infoworld.com/article/2075291/build-secure-network-applications-with-ssl-and-the-jsse-api.html
Usage: java -Djavax.net.ssl.keyStore=foobar -Djavax.net.ssl.keyStorePassword=foobar EchoServer
 */

public class EchoServer
{
    public static void main(String [] arstring)
    {
        try
        {
            SSLServerSocketFactory sslserversocketfactory =
                    (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
            SSLServerSocket sslserversocket =
                    (SSLServerSocket)sslserversocketfactory.createServerSocket(9999);
            SSLSocket sslsocket = (SSLSocket)sslserversocket.accept();
            InputStream inputstream = sslsocket.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
            String string = null;
            while ((string = bufferedreader.readLine()) != null)
            {
                System.out.println(string);
                System.out.flush();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
