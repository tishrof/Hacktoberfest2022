import java.io.*;
import java.net.*;

class Server {
    private static final String NEWLINE = System.getProperty("line.separator");

    public static void main(String args[]) throws IOException {
        try {

            String str;
            ServerSocket server = new ServerSocket(6555);
            Socket serverSocket = server.accept();

            BufferedReader serverInputStream = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            str = serverInputStream.readLine();
            
            System.out.println("Command recvied = " + str);
            if (str.equals("0")) {
                out.println(execCmd("dir"));

            } else {
                out.println(execCmd("date /t"));
            }
        } catch (IOException e) {
            System.out.println("Error" + e);
        }

    }

    public static String execCmd(String cmd) throws java.io.IOException {
        StringBuilder result = new StringBuilder(80);
        Runtime rt = Runtime.getRuntime();
            String[] commands = { "cmd.exe", "/c", "cd \"F:\\IIIT V BOOKS\\Distributed\\Lab3\" && " + cmd };
            Process proc = rt.exec(commands);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String s = null;
            while ((s = stdInput.readLine()) != null) {
                result.append(s).append(NEWLINE);
            }
            System.out.println(result.toString());
            return result.toString();

        
    }
}