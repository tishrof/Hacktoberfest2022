import java.io.*;
import java.net.*;

class client {
    public static void main(String args[]) throws IOException {
        try {
            String str;
            Socket client = new Socket("127.0.0.1", 6555);
            
            PrintStream clientOutputStream = new PrintStream(client.getOutputStream());
            BufferedReader systemInputStream = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader clientInputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Chaitanya Soni (201951046)");
            System.out.println("CLIENT WINDOW\n\nEnter TheCommand: (1 or 0)");
            
            str = systemInputStream.readLine();
            clientOutputStream.println(str);
            String s = null;
                while ((s = clientInputStream.readLine()) != null) {
                    System.out.println(s);
                }
            
            client.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }
}