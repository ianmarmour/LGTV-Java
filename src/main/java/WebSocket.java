import java.io.*;

public class WebSocket {

    public static void main(String[] args) {

            String relax = "null";

            File f = new File("key.txt");
            while(!f.exists() && !f.isDirectory()) {
                KeyGenerator.Generate();
            }
            boolean test3 = TV.showFloat("This is a test");
            boolean fuckit = TV.turnOff();
            TV.WakeOnLan("192.168.1.255", "A0:6F:AA:5F:27:D4");
    }
}