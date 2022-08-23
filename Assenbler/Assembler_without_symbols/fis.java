package EoC;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class fis {
	 
	public static void Writer(String content) { // method that writes data into files
       
 try {
             File file = new File("bin.asm"); // opening file
               FileOutputStream fileWriter = new FileOutputStream(file, true); // creating writer

                         PrintWriter appender = new PrintWriter(fileWriter);
                         //byte[] s=content.getBytes();
                    //fk=false;     
                // fileWriter.write(s);
              appender.println(content);
              appender.close(); // closing the writer
              }

               catch (IOException e) {
         e.printStackTrace();}
           } // exception statement for the above try

public static void reader() {
		
		try {
		      File myObj = new File("eoc.asm");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        data=data.trim();
		        
		        Interface(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }}
//===========================================================================

  public static void Interface(String x) {
		if(x.contains("//")) {
			System.out.println(x);	
	   comcheck(x);
	   }
	
	   else if ((x.contains("/"))&&(!x.contains("//"))){
		   System.out.println("Wrong Code");
	 
		   
	   }
	   else if (x.isBlank()){
		   
		  
	   }
		
		else
		inscheck(x);
		
}
//============================================================================
	public static void alokc(String x) {
	
		String df="";
		for (int i=0; i<x.length();i++) {
			if(x.charAt(i)=='/') {	
				df+=x.substring(0, i);
				//System.out.println(i);
				
				System.out.println(df);
				alokdj(df);
				break;
		}
		
		}
		
	}
//===========================================================================	
	public static void inscheck(String x) {
		if (x.charAt(0)=='@') {
			alokdj(x);
			}
        else if ((x.charAt(0)=='A')||(x.charAt(0)=='M') ||(x.charAt(0)=='D')||(x.charAt(0)=='0')||(x.charAt(0)=='1')||(x.charAt(0)=='-')||(x.charAt(0)=='!')) {
			
			alokdj(x);
        }
		else {
		System.out.println("");
		}
	}
//===================================================================
	public static void cominstructcheck(String x) {
		if (x.charAt(0)=='@') {
			aloka(x);
			}
		else if ((x.charAt(0)=='A')||(x.charAt(0)=='M')||(x.charAt(0)=='D')||(x.charAt(0)=='0')) {
			
			alokc(x);
			
		}
		else {
			int a=0;
		}
	}
//=======================================================================================
		public static void comcheck(String x) {
			if (x.charAt(0)=='/') {
				System.out.println("this is a comment");
				}
			else {
				cominstructcheck(x);
			}
	}
//========================================================================================
	public static void aloka(String x) {
	String df ="";
	
	for (int i=0; i<x.length();i++) {
		if(x.charAt(i)=='/') {	
			df+=x.substring(0, i);
			System.out.println(i);
			
			System.out.println(df);
			alokdj(df);
			break;
	}
	
	}
	  }
//===========================================================================================	
	public static void alokdj(String x) {
		String dn ="";
		
		if(x.contains(" ")) {
		
			//dn=x.substring(0, x.indexOf(' '));
				dn=x.trim();
				System.out.println(dn);
				if(dn.charAt(0)=='@') {
					ainc(dn);}
		else {
			cinccheck(dn);}
				
				}
			
	else { 
		if(x.charAt(0)=='@')
					ainc(x);
		else 
			cinccheck(x);
			}}
//====================================================================	
	public static void cinccheck(String x) {
		if (x.contains("=")&&!(x.contains(";"))) {
			cinc1(x);
	}
		else if (x.contains(";")&&!(x.contains("="))) {
		cinc2(x);}
	else if ((x.contains("="))&&(x.contains(";"))) {
		cinc3(x);
	}
	}
//======================================================================================	
public static void cinc3(String g) {
   System.out.println(g);
		String w="";
		
		String c=g.split(";", 3)[0];
		c=c.trim();
		String d=c.split("=", 3)[0];
		d=d.trim();
		System.out.println(d);                
		String s=c.split("=", 3)[1];
		s=s.trim();
		System.out.println(s);                
		String h=g.split(";", 3)[1];
		h=h.trim();
		System.out.println(h); 
				
				HashMap <String,String>map=new HashMap<String,String>();
				map.put("JLT", "100");
				map.put("JGT", "001");
				map.put("JEQ", "010");
				map.put("JNE", "101");
				map.put("JMP", "111");
				map.put("JLE", "110");
				map.put("JGE", "011");
				
				HashMap <String,String>mapm=new HashMap<String,String>();
				mapm.put("A", "100");
				mapm.put("M", "001");
				mapm.put("D", "010");
				mapm.put("AM", "101");
				mapm.put("AMD", "111");
				mapm.put("AD", "110");
				mapm.put("MD", "011");
				
				
				char[] sd=new char[16];
				sd[0]='1';
				sd[1]='1';
				sd[2]='1';
				
				
				
				//System.out.println(map.get(s));
		if (s.equals("M")||s.equals("!M")||s.equals("-M")||s.equals("M+1")||s.equals("M-1")||s.equals("D+M")||s.equals("D-M")||s.equals("M-D")||s.equals("D&M")||s.equals("D|M")) {		
			sd[3]='1';
			
		}else
			sd[3]='0';
				
		if (s.equals("0")) {		
			sd[4]='1';
			sd[5]='0';
			sd[6]='1';
			sd[7]='0';
			sd[8]='1';
			sd[9]='0';
			
		}
		else if(s.equals("1")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='1';
			sd[7]='1';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("-1")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='1';
			sd[7]='0';
			sd[8]='1';
			sd[9]='0';
		}		
		else if(s.equals("D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='1';
			sd[7]='1';
			sd[8]='0';
			sd[9]='0';
		}		
		else if(s.equals("M")||s.equals("A")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='0';
			sd[7]='0';
			sd[8]='0';
			sd[9]='0';
		}		
		else if(s.equals("!D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='1';
			sd[7]='1';
			sd[8]='0';
			sd[9]='1';
		}		
		else if(s.equals("!M")||s.equals("!A")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='0';
			sd[7]='0';
			sd[8]='0';
			sd[9]='1';
		}		
		else if(s.equals("-D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='1';
			sd[7]='1';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("-M")||s.equals("-A")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='0';
			sd[7]='0';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("D+1")) {
			sd[4]='0';
			sd[5]='1';
			sd[6]='1';
			sd[7]='1';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("M+1")||s.equals("A+1")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='0';
			sd[7]='1';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("D-1")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='1';
			sd[7]='1';
			sd[8]='1';
			sd[9]='0';
		}		
		else if(s.equals("M-1")||s.equals("A-1")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='0';
			sd[7]='0';
			sd[8]='1';
			sd[9]='0';
		}		
		else if(s.equals("D+M")||s.equals("D+A")||s.equals("M+D")||s.equals("A+D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='0';
			sd[7]='0';
			sd[8]='1';
			sd[9]='0';
		}		
		else if(s.equals("D-M")||s.equals("D-A")) {
			sd[4]='0';
			sd[5]='1';
			sd[6]='0';
			sd[7]='0';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("M-D")||s.equals("A-D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='0';
			sd[7]='1';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("D&M")||s.equals("D&A")||s.equals("M&D")||s.equals("A&D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='0';
			sd[7]='0';
			sd[8]='0';
			sd[9]='0';
		}		
		else if(s.equals("D||M")||s.equals("D||A")||s.equals("M||D")||s.equals("A||D")) {
			sd[4]='0';
			sd[5]='1';
			sd[6]='0';
			sd[7]='1';
			sd[8]='0';
			sd[9]='1';
		}	
		else { 
			System.out.println("fuckkkk");
		}
		String dest=mapm.get(d);
        sd[10]=dest.charAt(0);
		sd[11]=dest.charAt(1);
		sd[12]=dest.charAt(2);
					
	     String jmp=map.get(h);
	        sd[13]=jmp.charAt(0);
			sd[14]=jmp.charAt(1);
			sd[15]=jmp.charAt(2);
		
			
			for(char se : sd){
				w+=se;
			}
			System.out.println(w);

	Writer(w);
		
}

//=====================================================================	
	public static void cinc2(String g) {
		String w="";
		
		String s=g.split(";", 3)[0];
		s=s.trim();
		System.out.println(s);                
		String h=g.split(";", 3)[1];
		h=h.trim();
		System.out.println(h); 
				
				HashMap <String,String>map=new HashMap<String,String>();
				map.put("JLT", "100");
				map.put("JGT", "001");
				map.put("JEQ", "010");
				map.put("JNE", "101");
				map.put("JMP", "111");
				map.put("JLE", "110");
				map.put("JGE", "011");
				
				char[] sd=new char[16];
				sd[0]='1';
				sd[1]='1';
				sd[2]='1';
				sd[10]='0';
				sd[11]='0';
				sd[12]='0';
				
				
				//System.out.println(map.get(s));
		if (s.equals("M")||s.equals("!M")||s.equals("-M")||s.equals("M+1")||s.equals("M-1")||s.equals("D+M")||s.equals("D-M")||s.equals("M-D")||s.equals("D&M")||s.equals("D|M")) {		
			sd[3]='1';
			
		}else
			sd[3]='0';
				
		if (s.equals("0")) {		
			sd[4]='1';
			sd[5]='0';
			sd[6]='1';
			sd[7]='0';
			sd[8]='1';
			sd[9]='0';
			
		}
		else if(s.equals("1")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='1';
			sd[7]='1';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("-1")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='1';
			sd[7]='0';
			sd[8]='1';
			sd[9]='0';
		}		
		else if(s.equals("D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='1';
			sd[7]='1';
			sd[8]='0';
			sd[9]='0';
		}		
		else if(s.equals("M")||s.equals("A")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='0';
			sd[7]='0';
			sd[8]='0';
			sd[9]='0';
		}		
		else if(s.equals("!D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='1';
			sd[7]='1';
			sd[8]='0';
			sd[9]='1';
		}		
		else if(s.equals("!M")||s.equals("!A")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='0';
			sd[7]='0';
			sd[8]='0';
			sd[9]='1';
		}		
		else if(s.equals("-D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='1';
			sd[7]='1';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("-M")||s.equals("-A")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='0';
			sd[7]='0';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("D+1")) {
			sd[4]='0';
			sd[5]='1';
			sd[6]='1';
			sd[7]='1';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("M+1")||s.equals("A+1")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='0';
			sd[7]='1';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("D-1")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='1';
			sd[7]='1';
			sd[8]='1';
			sd[9]='0';
		}		
		else if(s.equals("M-1")||s.equals("A-1")) {
			sd[4]='1';
			sd[5]='1';
			sd[6]='0';
			sd[7]='0';
			sd[8]='1';
			sd[9]='0';
		}		
		else if(s.equals("D+M")||s.equals("D+A")||s.equals("M+D")||s.equals("A+D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='0';
			sd[7]='0';
			sd[8]='1';
			sd[9]='0';
		}		
		else if(s.equals("D-M")||s.equals("D-A")) {
			sd[4]='0';
			sd[5]='1';
			sd[6]='0';
			sd[7]='0';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("M-D")||s.equals("A-D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='0';
			sd[7]='1';
			sd[8]='1';
			sd[9]='1';
		}		
		else if(s.equals("D&M")||s.equals("D&A")||s.equals("M&D")||s.equals("A&D")) {
			sd[4]='0';
			sd[5]='0';
			sd[6]='0';
			sd[7]='0';
			sd[8]='0';
			sd[9]='0';
		}		
		else if(s.equals("D||M")||s.equals("D||A")||s.equals("M||D")||s.equals("A||D")) {
			sd[4]='0';
			sd[5]='1';
			sd[6]='0';
			sd[7]='1';
			sd[8]='0';
			sd[9]='1';
		}		
				
         String dest=map.get(h);
            sd[13]=dest.charAt(0);
			sd[14]=dest.charAt(1);
			sd[15]=dest.charAt(2);
			
			
			for(char se : sd){
				w+=se;
			}
			System.out.println(w);

  Writer(w);
		
	}
//=====================================================================
public static void cinc1(String f) {
	String w="";
	String g= f.trim();
	g=g.trim();
	String d=g.split("=", 3)[0];
	d=d.trim();
	System.out.println(d);                
	String s=g.split("=", 3)[1];
	s=s.trim();
	System.out.println(s); 
			
			HashMap <String,String>mapm=new HashMap<String,String>();
			mapm.put("A", "100");
			mapm.put("M", "001");
			mapm.put("D", "010");
			mapm.put("AM", "101");
			mapm.put("AMD", "111");
			mapm.put("AD", "110");
			mapm.put("MD", "011");
			
			char[] sd=new char[16];
			sd[0]='1';
			sd[1]='1';
			sd[2]='1';
			sd[13]='0';
			sd[14]='0';
			sd[15]='0';
			//System.out.println(map.get(s));
	if (s.equals("M")||s.equals("!M")||s.equals("-M")||s.equals("M+1")||s.equals("M-1")||s.equals("D+M")||s.equals("D-M")||s.equals("M-D")||s.equals("D&M")||s.equals("D|M")) {		
		sd[3]='1';
		
	}else
		sd[3]='0';
			
	if (s.equals("0")) {		
		sd[4]='1';
		sd[5]='0';
		sd[6]='1';
		sd[7]='0';
		sd[8]='1';
		sd[9]='0';
		
	}
	else if(s.equals("1")) {
		sd[4]='1';
		sd[5]='1';
		sd[6]='1';
		sd[7]='1';
		sd[8]='1';
		sd[9]='1';
	}		
	else if(s.equals("-1")) {
		sd[4]='1';
		sd[5]='1';
		sd[6]='1';
		sd[7]='0';
		sd[8]='1';
		sd[9]='0';
	}		
	else if(s.equals("D")) {
		sd[4]='0';
		sd[5]='0';
		sd[6]='1';
		sd[7]='1';
		sd[8]='0';
		sd[9]='0';
	}		
	else if(s.equals("M")||s.equals("A")) {
		sd[4]='1';
		sd[5]='1';
		sd[6]='0';
		sd[7]='0';
		sd[8]='0';
		sd[9]='0';
	}		
	else if(s.equals("!D")) {
		sd[4]='0';
		sd[5]='0';
		sd[6]='1';
		sd[7]='1';
		sd[8]='0';
		sd[9]='1';
	}		
	else if(s.equals("!M")||s.equals("!A")) {
		sd[4]='1';
		sd[5]='1';
		sd[6]='0';
		sd[7]='0';
		sd[8]='0';
		sd[9]='1';
	}		
	else if(s.equals("-D")) {
		sd[4]='0';
		sd[5]='0';
		sd[6]='1';
		sd[7]='1';
		sd[8]='1';
		sd[9]='1';
	}		
	else if(s.equals("-M")||s.equals("-A")) {
		sd[4]='1';
		sd[5]='1';
		sd[6]='0';
		sd[7]='0';
		sd[8]='1';
		sd[9]='1';
	}		
	else if(s.equals("D+1")) {
		sd[4]='0';
		sd[5]='1';
		sd[6]='1';
		sd[7]='1';
		sd[8]='1';
		sd[9]='1';
	}		
	else if(s.equals("M+1")||s.equals("A+1")) {
		sd[4]='1';
		sd[5]='1';
		sd[6]='0';
		sd[7]='1';
		sd[8]='1';
		sd[9]='1';
	}		
	else if(s.equals("D-1")) {
		sd[4]='0';
		sd[5]='0';
		sd[6]='1';
		sd[7]='1';
		sd[8]='1';
		sd[9]='0';
	}		
	else if(s.equals("M-1")||s.equals("A-1")) {
		sd[4]='1';
		sd[5]='1';
		sd[6]='0';
		sd[7]='0';
		sd[8]='1';
		sd[9]='0';
	}		
	else if(s.equals("D+M")||s.equals("D+A")||s.equals("M+D")||s.equals("A+D")) {
		sd[4]='0';
		sd[5]='0';
		sd[6]='0';
		sd[7]='0';
		sd[8]='1';
		sd[9]='0';
	}		
	else if(s.equals("D-M")||s.equals("D-A")) {
		sd[4]='0';
		sd[5]='1';
		sd[6]='0';
		sd[7]='0';
		sd[8]='1';
		sd[9]='1';
	}		
	else if(s.equals("M-D")||s.equals("A-D")) {
		sd[4]='0';
		sd[5]='0';
		sd[6]='0';
		sd[7]='1';
		sd[8]='1';
		sd[9]='1';
	}		
	else if(s.equals("D&M")||s.equals("D&A")||s.equals("M&D")||s.equals("A&D")) {
		sd[4]='0';
		sd[5]='0';
		sd[6]='0';
		sd[7]='0';
		sd[8]='0';
		sd[9]='0';
	}		
	else if(s.equals("D||M")||s.equals("D||A")||s.equals("M||D")||s.equals("A||D")) {
		sd[4]='0';
		sd[5]='1';
		sd[6]='0';
		sd[7]='1';
		sd[8]='0';
		sd[9]='1';
	}		
			
     String dest=mapm.get(d);
        sd[10]=dest.charAt(0);
		sd[11]=dest.charAt(1);
		sd[12]=dest.charAt(2);
		
		
		for(char se : sd){
			w+=se;
		}
		System.out.println(w);
   Writer(w);
}

//================================================================================================	
	public static void ainc(String x) {
		System.out.println(x);
		
		//String h=x.substring(0, c);
		String f=x.split("@", 5)[1];
		int a= Integer.parseInt(f);
		String bin = Integer.toBinaryString(0x10000 | a).substring(1);
		/*char ff[]=bin.toCharArray();
		ff[0]='0';
		String  fss=ff.toString();
		*/
		
		String  fss="0";
		for (int i=1;bin.length()>i;i++) {
			char e=bin.charAt(i);
			fss+=e;
		}
		
		
		System.out.println(fss);
	
		//System.out.println(a);
		//System.out.println(bin);
		System.out.println(fss.length());
		Writer(fss);
		
	  
//===============================================================================================	
		
	}
public static void main(String[] args) {
	try {
        File file = new File("bin.asm"); // opening file
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
		reader();
	}}
	