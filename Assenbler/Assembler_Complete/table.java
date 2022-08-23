package ASSIGNMENT_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class table {
	
	public static HashMap<String, String> Map;
	//private static int programAddress;
	//private static int dataAddress;
	
	public table() {
		initializeSymbolTable();
		
		firstpass();
		secondpass();
		/*for (HashMap.Entry<String,String> entry : Map.entrySet()) {
           writer("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());
		 System.out.println("Key = " + entry.getKey() +
                 ", Value = " + entry.getValue()); 
		}*/
	}
	private static boolean checker(String x) {
		try {
		int a=Integer.parseInt(x);
		return false;
		} catch (NumberFormatException e) {
		 //   System.out.println("Input String cannot be parsed to Integer.");
		    return true;
		}
		
	}
	private void initializeSymbolTable() {
		this.Map = new HashMap<String, String>();
		this.Map.put("SP", "0");
		this.Map.put("LCL", "1");
		this.Map.put("ARG", "2");
		this.Map.put("THIS", "3");
		this.Map.put("THAT","4");
		this.Map.put("R0", "0");
		this.Map.put("R1", "1");
		this.Map.put("R2", "2");
		this.Map.put("R3", "3");
		this.Map.put("R4", "4");
		this.Map.put("R5", "5");
		this.Map.put("R6", "6");
		this.Map.put("R7", "7");
		this.Map.put("R8", "8");
		this.Map.put("R9", "9");
		this.Map.put("R10", "10");
		this.Map.put("R11", "11");
		this.Map.put("R12", "12");
		this.Map.put("R13", "13");
		this.Map.put("R14", "14");
		this.Map.put("R15", "15");
		this.Map.put("SCREEN", "16384");
		this.Map.put("KBD", "24576");
	}
	
	// Adds the pair (symbol, address) to the table.
	public static void addEntry(String symbol, String address) {
		Map.put(symbol, address);
	}
	
	// Does the symbol table contain the given symbol?
	public  static boolean contains(String symbol) {
		return Map.containsKey(symbol);
	}
	
	//  Returns the address associated with the symbol.
	public static String getAddress(String symbol) {
		return Map.get(symbol);
	}
	
	
	public static void firstpass() {
		try {
		      File myObj = new File("_no_whitespace.asm");
		      Scanner myReader = new Scanner(myObj);
		      int count =-1;
		      int n=16;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        data=data.trim();
		        count++;
		        if(data.startsWith("(") ){ // (LOOP)
		        	
		        	data=data.replace("(", "");
		        	data=data.replace(")", "");
		        	data=data.trim();
		        	if(!contains(data)) {
		        	addEntry(data,Integer.toString(count+2));
		        	}
		        	else {
		        		continue;
		        	}
		        }
		       /* else if ((data.charAt(0)=='@')) {
		        	String s= data.split("@",2)[1];
		        	s.trim();
		        	if(checker(s)==true) {
		        		if(!Map.containsKey(s)) {
		        			addEntry(s,Integer.toString(n));
		        			n++;
		        		}
		        	}
		        }*/
		        	
		   
		      }
		        myReader.close();
		    } catch (FileNotFoundException e) {
		    	System.out.println("An error occurred.");
			    
		      e.printStackTrace();
		    }}
	public static void secondpass() {
		try {
		      File myObj = new File("_no_whitespace.asm");
		      Scanner myReader = new Scanner(myObj);
		      int count =-1;
		      int n=16;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        data=data.trim();
		        count++;
		       /* if(data.startsWith("(") ){ // (LOOP)
		        	
		        	data=data.replace("(", "");
		        	data=data.replace(")", "");
		        	data=data.trim();
		        	if(!contains(data)) {
		        	addEntry(data,Integer.toString(count+2));
		        	}
		        	else {
		        		continue;
		        	}
		        }*/
		        if ((data.charAt(0)=='@')) {
		        	String s= data.split("@",2)[1];
		        	s.trim();
		        	if(checker(s)==true) {
		        		if(!Map.containsKey(s)) {
		        			addEntry(s,Integer.toString(n));
		        			n++;
		        		}
		        	}
		        }
		        	
		   
		      }
		        myReader.close();
		    } catch (FileNotFoundException e) {
		    	System.out.println("An error occurred.");
			    
		      e.printStackTrace();
		    }}
	public static void writer(String x) {
		try {
	        File file = new File("SYMBOLTABLE.asm"); // opening file
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