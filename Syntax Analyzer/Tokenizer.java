package Tokeniser;

import java.io.*;
import java.util.*;

public class Tokenizer {
	   public static ArrayList<String> list = new ArrayList<String>();

	public static boolean flag=true;
	static String stf="";

	public static String lines;
	private static  ArrayList<String> KEYWORDS ;
	private static  ArrayList<Character> SYMBOLS ;
//=================================================================
	public static void  reader() {
		try {
		File file =new File("Main.jack");
		String line = "";
		  
	Scanner bi = new Scanner (file);
		while (bi.hasNext()) {
		line = bi.nextLine();
		if (line.isEmpty()) {
		
		}
		else{
			line = line.trim();
			verify(line);	
		}}
		}
		catch(IOException e) {	
		}	  
		}
private static void verify(String line) {
	if (line.startsWith("//")) {
		
	}
	else if (line.contains("//")) {
	String x= line.substring(0, line.indexOf("//"));
	write(x);
	
	}
	else if(line.contains("/**")&&(line.contains("*/"))) {
		
	}
	else if (line.startsWith("/**")) {
	flag=false;
	write(line);
}
	else if (line.contains("*/")) {
		write(line);
		flag=true;
		
	}
	else {
		write(line);
	}
}
//===================================================================
private static void write(String line) {
	
	if (flag==true){
		try {	
	File file = new File("dj.txt");
		FileWriter fr= new FileWriter (file,true);
		BufferedWriter br= new BufferedWriter (fr);
		br.write(line);
		br.write("\n");
		br.close();
		fr.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	else{
		System.out.println("Fishing");
		
	}
}
//==================================================================================
private static void Writer(String line) {
	
		try {	
	File file = new File("MainT.xml");
		FileOutputStream fr= new FileOutputStream (file,true);
		PrintWriter br= new PrintWriter (fr);
		br.println(line);
		br.close();
		fr.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	
	

//==================================================================================

public static void initialize() {
	KEYWORDS = new ArrayList<>();
    KEYWORDS.add("class");
    KEYWORDS.add("constructor");
    KEYWORDS.add("function");
    KEYWORDS.add("method");
    KEYWORDS.add("field");
    KEYWORDS.add("static");
    KEYWORDS.add("var");
    KEYWORDS.add("int");
    KEYWORDS.add("char");
    KEYWORDS.add("boolean");
    KEYWORDS.add("void");
    KEYWORDS.add("true");
    KEYWORDS.add("false");
    KEYWORDS.add("null");
    KEYWORDS.add("this");
    KEYWORDS.add("let");
    KEYWORDS.add("do");
    KEYWORDS.add("if");
    KEYWORDS.add("else");
    KEYWORDS.add("while");
    KEYWORDS.add("return");

    SYMBOLS = new ArrayList<>();
    SYMBOLS.add('{');
    SYMBOLS.add('}');
    SYMBOLS.add('(');
    SYMBOLS.add(')');
    SYMBOLS.add('[');
    SYMBOLS.add(']');
    SYMBOLS.add('.');
    SYMBOLS.add(',');
    SYMBOLS.add(';');
    SYMBOLS.add('+');
    SYMBOLS.add('-');
    SYMBOLS.add('*');
    SYMBOLS.add('/');
    SYMBOLS.add('&');
    SYMBOLS.add('~');
    SYMBOLS.add('|');
    SYMBOLS.add('<');
    SYMBOLS.add('>');
    SYMBOLS.add('=');

}
//=================================================================
private static void reader2() {
	//System.out.println("reader2 is called");
	try {
		File file =new File("dj.txt");
		String line ;
		  
	Scanner bi = new Scanner (file);
		while (bi.hasNext()) {
		line = bi.nextLine();
		godlikespeed(line);
		
		}
	}
		catch(IOException e) {
			
		}
		  
		}
//================================================================

//=================================================================
private static void godlikespeed(String line) {
	//System.out.println("=================================================================");
	String out=tokenizer(line);
	
	
	 String[] tokens = out.split(" ");
	 
	 		boolean flak=true;
	 		char a='"';
	        String temp = a+"";
          
	        for (int i = 0; i < tokens.length; i++) {
	        	String s=tokens[i];
	      
	  if (flak==true) {
	
	    	  if (SYMBOLS.contains(s)) {
	             	
	                 Writer("<symbol>"+s+"</symbol>");
	        	 }
	        	 
	        	 else if (KEYWORDS.contains(s)) {
	                 Writer("<keyword>"+s+"</keyword>");

	             }
	        	 else if (isint(s)==true) {
	                 Writer("<integerConstant> "+s+" </integerConstant>");
	   	    	  

	             }
	        	 else if ((s.contains(temp))) {
	        		 stf=stf+s.replace('"', ' ');
	        		flak=!flak;

	        	 }
	             else {
	                 Writer("<identifier>"+s+"</identifier>");

	             }
	        	}
	  else {
	        		
	        		 if ((s.contains(temp))) {
	        			 flak=!flak;
	        			 Writer("<stringConstant>"+stf+"</stringConstant>");
		        		 System.out.println(stf);
		        		 stf="";
	        		 }
	        		 else {
	        			 stf=stf+" "+s;
		        	 }
	        	}
	        }

}
private static boolean isint(String s) {
	try {
		int a= Integer.parseInt(s);
		
	}
	catch(NumberFormatException e) {
		return false;
	}
	return true;
}
//=================================================================
public static String  tokenizer(String line) {


	for (char sym :SYMBOLS) {
		String s= Character.toString(sym);
		if (line.contains(s)) {
			line=line.replace(s, " "+sym+" ");
			}
		
	}
	return line;
}

//=================================================================	
		public static void main(String[] args) {
			try {	
				File file = new File("MainT.xml");
					FileOutputStream fr= new FileOutputStream (file,false);
					PrintWriter br= new PrintWriter (fr);
					br.flush();
					br.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			try {	
				File file = new File("dj.txt");
					FileOutputStream fr= new FileOutputStream (file,false);
					PrintWriter br= new PrintWriter (fr);
					br.flush();
					br.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			 initialize();
			reader();
			reader2();
			
			
		}
}


