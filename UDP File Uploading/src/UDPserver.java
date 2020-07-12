package lab5;
import java.io.*;
import java.net.*;
import java.util.*;

public class UDPserver {

	public static void main(String args[]) throws Exception
    {
       DatagramSocket serverSocket = new DatagramSocket(9900); //Connection creates at said port
          byte[] receiveData = new byte[9]; //Array of bytes for filename
          byte[] receiveData2 = new byte[1024]; //Array of bytes for Strings 
          DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
          //Object receivePacket receives the data in bytes
          
          serverSocket.receive(receivePacket); //ServerSocket receive Packets holding data
          String sentence = new String( receivePacket.getData());
          File file = new File("C://Users//Hamad Nasir//Desktop//"+sentence+ ".txt"); //Filepath
          if(file.createNewFile())
          {
          	System.out.println(sentence+ " File created");
          }
          else
          {
          	System.out.println(sentence+ "already exist");
          }
          while(true) //while executes and data in the form of string writes in a file
          {
                DatagramPacket receivePacket1 = new DatagramPacket(receiveData2, receiveData2.length);
                serverSocket.receive(receivePacket1);
                
                String sentence1 = new String( receivePacket1.getData());
                System.out.println(sentence1);
                BufferedWriter buffer = new BufferedWriter(new FileWriter(file,true));
                PrintWriter pw = new PrintWriter(buffer);
                
                pw.write(sentence1);
                pw.println();
                buffer.close();
          }
     }
}
