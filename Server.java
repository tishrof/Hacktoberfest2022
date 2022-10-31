import java.net.*;
import java.io.*;
public class Server
{
      public static void main (String[] args)
      {
            try
            { 
                  ServerSocket ss = new ServerSocket(6000); 
                  Socket s = ss.accept(); 
                  DataInputStream dis = new DataInputStream(s.getInputStream()); 
                  String k = dis.readUTF(); 
                  System.out.println("File Transferred"); 
                  FileOutputStream fos = new FileOutputStream("F:\\IIIT V BOOKS\\Distributed\\Lab3\\201951046.txt"); 
                  fos.write(k.getBytes()); 
            }
            catch (IOException ie)
            {
                  ie.printStackTrace();
            }
      }
}