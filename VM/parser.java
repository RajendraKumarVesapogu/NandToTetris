package VM_1;
import java.io.*;
import java.util.Scanner;

public class parser extends vm1{
	 static String filen;
	public static codewriter cd ;
	public parser(String filename) {
		cd= new codewriter(filename);
		this.filen=filename;
		reader();
		
	}
	 
//========================================================================	
			public static void reader() {
				
				try {
					File file = new File(filen+".vm");
					Scanner read=new Scanner(file);
					while (read.hasNextLine()) {
						String s=read.nextLine();
						s=s.trim();
						if(s.startsWith("/")) {
								
							}
						else if (s.isBlank()) {
							
						}
	else if (!(s.startsWith("/")) &&(s.contains("//"))) {
							
		int i=s.indexOf('/');
		String f=s.substring(0,i);
							f=f.trim();
							if (f.length()>3) {
							Checkpost1(f);
						}
							else{
								Checkpost2(f);
								}
							}
				else {	
						if (s.length()>3) {
							Checkpost1(s);
						}
							else{
								Checkpost2(s);
								}
							}
					}
				}catch (Exception E) {
					
				}
			}
//====================================================================================			
			public static void Checkpost1(String s) {
			String f1=s.split(" " , 3)[0] ;
			f1=f1.trim();
			String f2=s.split(" " , 3)[1] ;
			f2=f2.trim();
			if (f1.equals("push")) {
				push(s);
			}
			else if (f1.equals("pop")){
				System.out.println();
				pop(s);
			}
			else if (f1.equals("label")){
				cd.label(f2);
			}
			else if (f1.equals("goto")){
				cd.gotoo(f2);
			}
			else if (f1.equals("if-goto")){
				cd.ifgoto(f2);
			}

			}
			//====================================================================================			
			public static void Checkpost2(String f1) {
		
			
		  if (f1.equals("add")){
				System.out.println("add is called");
				cd.add();
			}
			else if (f1.equals("sub")){
				cd.sub();
			}
			else if (f1.equals("eq")){
				cd.eq();
			}
			else if (f1.equals("lt")){
				cd.lt();
			}
			else if (f1.equals("gt")){
				cd.gt();
			}
			else if (f1.equals("not")){
				cd.not();
			}
			else if (f1.equals("and")){
				cd.and();
			}
			else if (f1.equals("or")){
				cd.or();
			}
		

			}
//=====================================================================================
			public static void push(String s) {
				
				String f2=s.split(" " , 3)[1] ;
				String f3=s.split(" " , 3)[2] ;
                 f2=f2.trim();
                 f3=f3.trim();
                 switch(f2) {
				case "constant":
					cd.pushconst(f3);
					break;
				case "static":
					cd.pushstatic(f3);
					break;
				case "local":
					cd.pushlocal(f3);
					break;
				case "argument":
					cd.pusharg(f3);
					break;
				case "this":
					cd.pushthis(f3);
					break;
				case "that":
					cd.pushthat(f3);
					break;
				case "temp":
					cd.pushtemp(f3);
					break;
				case "pointer":
					cd.pushpointer(f3);
					break;
				default:
					System.out.println("sorry.......");
				}
	
				}

			public static void pop(String s) {
				String f2=s.split(" " , 3)[1] ;
				String f3=s.split(" " , 3)[2] ;
				f2=f2.trim();
                f3=f3.trim();
				switch(f2) {
				
				case "static":
					cd.popstatic(f3);
					break;
				case "local":
					cd.poplocal(f3);
					break;
				case "argument":
					cd.poparg(f3);
					break;
				case "this":
					cd.popthis(f3);
					break;
				case "that":
					cd.popthat(f3);
					break;
				case "temp":
					cd.poptemp(f3);
					break;
				case "pointer":
					cd.poppointer(f3);
					break;
				default:
					System.out.println("sorry.......");
				}
			}
}
