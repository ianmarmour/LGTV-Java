import java.io.*;

public class WebSocket {

    public static void main(String[] args) {

            new Cli(args).parse();

            File f = new File("key.txt");
            while(!f.exists() && !f.isDirectory()) {
                KeyGenerator.Generate();
            }
    }
}