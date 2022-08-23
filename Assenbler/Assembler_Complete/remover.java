package ASSIGNMENT_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class remover  {
	
	public remover() {
		try {
	        File file = new File("_no_whitespace.asm"); // opening file
	          FileOutputStream fileWriter = new FileOutputStream(file); // creating writer

	                    PrintWriter appender = new PrintWriter(fileWriter);
	                    //byte[] s=content.getBytes();
	                    
	           // fileWriter.write(s);
	           // appender.flush();
	                  
	         appender.flush();
	         appender.close(); // closing the writer
	         }
		catch(Exception e) {
			System.out.println("m");
		}
		try {
		      File myObj = new File("testNew.asm");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        data=data.trim();
		        if(data.isEmpty()) {
		        	
		        }
		        else if(data.startsWith("/")) {
		        	
		        	
		        }
		        
		        else {
		        	writer(data);
		        }
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		}
	public static void writer(String x) {
	try {
        File file = new File("_no_whitespace.asm"); // opening file
          FileOutputStream fileWriter = new FileOutputStream(file, true); // creating writer
          //ObjectOutputStream oos = new ObjectOutputStream(fileWriter);
                    PrintWriter appender = new PrintWriter(fileWriter);
            //oos.writeObject(l);        
         appender.println(x);
         appender.close(); // closing the writer
         }

          catch (IOException e) {
    e.printStackTrace();}
      }
}
