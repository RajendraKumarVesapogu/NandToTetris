package ASSIGNMENT_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ainc {
	
	
	public ainc(String x) {
		table tab = new table ();
		
		x=x.trim();
		String f=x.split("@", 3)[1];
		System.out.println(f);
		f=f.trim();
	    if(checker(f)==true) {
	    	String v=tab.Map.get(f);
	    	v=v.trim();
	    	System.out.println(v);
	    	int a= Integer.parseInt(v);
			String bin = Integer.toBinaryString(0x10000 | a).substring(1);
			
			
			String  fss="0";
			for (int i=1;bin.length()>i;i++) {
				char e=bin.charAt(i);
				fss+=e;
			}
			
			
			System.out.println(fss);
		
			System.out.println(fss.length());
			writer(fss);
			
	    }
	    else {
	    	
	   
		int a= Integer.parseInt(f);
		String bin = Integer.toBinaryString(0x10000 | a).substring(1);
		
		
		String  fss="0";
		for (int i=1;bin.length()>i;i++) {
			char e=bin.charAt(i);
			fss+=e;
		}
		
		
		System.out.println(fss);
	
		System.out.println(fss.length());
		writer(fss);
		
	    }	
	}
	
	public static boolean checker(String x) {
		try {
		int a=Integer.parseInt(x);
		return false;
		} catch (NumberFormatException e) {
		    System.out.println("Input String cannot be parsed to Integer.");
		    return true;
		}
		
	}
	public static void writer(String x) {
		try {
	        File file = new File("output.hack"); // opening file
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


