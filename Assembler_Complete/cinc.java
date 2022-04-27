package ASSIGNMENT_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class cinc {
	public cinc(String x) {
		cinccheck(x);
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
	   writer(w);
	}
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

  writer(w);
		
	}
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

			writer(w);
				
		}
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
	

}
