package Ch8SocketsClients.UsingSockets;

import java.io.IOException;
import java.text.ParseException;

public class DaytimeDriver {
    public static void main(String[] args) throws IOException, ParseException {
        Daytime daytime = new Daytime();
        System.out.println(daytime.getDateFromNetwork());
    }
}
