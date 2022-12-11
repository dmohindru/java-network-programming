package Ch10SecureSockets.SecuredClientServerExample;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
/*
This example is take from
https://www.infoworld.com/article/2075291/build-secure-network-applications-with-ssl-and-the-jsse-api.html
Usage: java -Djavax.net.ssl.keyStore=foobar -Djavax.net.ssl.keyStorePassword=foobar EchoClient
 */

public
class EchoClient
{
    public
    static
    void
    main(String [] arstring)
    {
        try
        {
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket sslsocket = (SSLSocket)sslsocketfactory.createSocket("localhost", 9999);
            InputStream inputstream = System.in;
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
            OutputStream outputstream = sslsocket.getOutputStream();
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
            BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);
            String string = null;
            while ((string = bufferedreader.readLine()) != null)
            {
                bufferedwriter.write(string + '\n');
                bufferedwriter.flush();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
