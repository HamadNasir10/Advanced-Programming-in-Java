package lab4;

import java.io.*; 
import java.net.*; 
public class JavaClient { 

    public static void main(String argv[]) throws Exception 
    { 
        String sentence; 
        String modifiedSentence; 
        Socket clientSocket = new Socket("10.99.17.225", 6700);  
      //create input stream
       BufferedReader inFromUser = 
         new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
      
        
/**
        File file = new File("C:\\Users\\Hamad Nasir\\Desktop\\text.txt "); 
        
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        String st;
        while ((st = br.readLine()) != null) 
          System.out.println(st);
   **/
    	String filePath = "C:\\Users\\Hamad Nasir\\Desktop\\text.txt ";
    	 
    	try {
    	    BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
    	    String lineText = null;
    	 
    	    while ((lineText = lineReader.readLine()) != null) {
    	        System.out.println(lineText);
    	    }
    	 
    	    lineReader.close();
    	} catch (IOException ex) {
    	    System.err.println(ex);
    	}
    	
    	
        
       DataOutputStream outToServer = 
         new DataOutputStream(clientSocket.getOutputStream()); 
        
        
       BufferedReader inFromServer = 
                new BufferedReader(new
                InputStreamReader(clientSocket.getInputStream())); 

              sentence = inFromUser.readLine(); 
 

              outToServer.writeBytes(sentence + '\n'); 

              modifiedSentence = inFromServer.readLine(); 

              System.out.println("FROM SERVER: " + modifiedSentence); 

              clientSocket.close(); 
                        
    }
}