package ASSIGNMENT_1;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class Main {
	
	public static void Interface(String x) {
		if(x.contains("//")) {
			//System.out.println(x);	
	   fish(x);
	   }
	
	   else if ((x.contains("/"))&&(!x.contains("//"))){
		   System.out.println("Wrong Code");
	 
		   
	   }
	   else if (x.isBlank()){
		   System.out.println(" ");
		  
	   }
		
		else
		inscheck(x);
		
}
	public static void fish(String x) {
		String df ="";
		
		for (int i=0; i<x.length();i++) {
			if(x.charAt(i)=='/') {	
				df+=x.substring(0, i);
				System.out.println(i);
				df= df.trim();
				System.out.println(df);
             inscheck(df);
				break;
		}
		
		}
		  }
	public static void inscheck(String x) {
		if (x.charAt(0)=='@') {
			ainc a= new ainc(x);
			}
        else if ((x.charAt(0)=='A')||(x.charAt(0)=='M') ||(x.charAt(0)=='D')||(x.charAt(0)=='0')||(x.charAt(0)=='1')||(x.charAt(0)=='-')||(x.charAt(0)=='!')) {
			
			cinc  c= new cinc(x);
        }
		else {
		System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		try {
	        File file = new File("output.hack"); // opening file
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
			remover first =new remover();
			table table = new table();
			try {
			File file = new File("_no_whitespace.asm");
			
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine()) {
					String f = scan.nextLine();
					
				Interface(f);
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}}
		


