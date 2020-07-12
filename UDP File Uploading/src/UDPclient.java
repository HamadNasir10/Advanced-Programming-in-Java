package lab5;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class UDPclient {
	 public static void main(String args[]) throws Exception 
	   {
		  Scanner s = new Scanner(System.in); 
		  System.out.println("Type Filename: "); 
	      BufferedReader inFromUser =
	         new BufferedReader(new InputStreamReader(System.in)); //Taking input from system via Bufferedreader
	      DatagramSocket clientSocket = new DatagramSocket(); //creating a UDP Connection
	      
	      InetAddress IPAddress = InetAddress.getByName("10.7.12.68"); //IP of server
	      
	      byte[] sendData = new byte[1024]; //Bytes to transfer
	      
	      String sentence = inFromUser.readLine(); //Read a line from system
	      
	      System.out.println("Filename is "+ sentence); //Displaying filename 
	      
	      sendData = sentence.getBytes(); //converts to Bytes
	      
	      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9900);
	      
	      clientSocket.send(sendPacket); //send a UDP Packet to Server containing filename
	      
	      char choice = 'Y';
		while(choice == 'Y') {
			System.out.println("Enter data: ");
	    	 BufferedReader inFromUser1 = new BufferedReader(new InputStreamReader(System.in));
	    	 DatagramSocket clientSocket1 = new DatagramSocket();
	    	 String sentence1 = inFromUser1.readLine();
	    	 
	    	 sendData = sentence1.getBytes();
	    	 DatagramPacket sendPacket1 = new DatagramPacket(sendData, sendData.length, IPAddress, 9900);        
	         clientSocket.send(sendPacket1);
	         System.out.println("Packet Successfully transfered");
	    	 
	    	 System.out.println("Want to enter another data or not");
	    	 choice = s.next().charAt(0);
	     	if(choice == 'N') 
	    	 { 
	     		 System.out.println("Transfer Completed!");
	        	 System.out.println("Connection at"+ IPAddress + " is closed");    	
	        	 clientSocket1.close();
	        	 clientSocket.close();
	    	 } 	 
			
	   }
	   } 
	       
	}

		
		
