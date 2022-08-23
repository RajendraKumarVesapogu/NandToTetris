package VM_1;


import java.io.*;

public class codewriter {
	public  static int n=0; 
	public  static String fileee;
	public codewriter(String filename){
		this.fileee=filename;
		
	}
	//======================================================================
	public static void gotoo(String x) {
		String out=  "//goto"
				+ "@" + x + "\n" +
			      "0;JMP\n";
	 write(out);
}
	//======================================================================
	public static void ifgoto(String x) {
		String out=  "// if-goto\n"
				+ "@SP\n" +
			      "AM=M-1\n" +
			      "D=M\n" +
			      "@" + x + "\n" +
			      "D;JNE\n";
	 write(out);
}
	
//======================================================================
			public static void label(String Name) {
				String out= "//label \n"
						+ "(" + Name + ")\n";
			 write(out);
		}
//======================================================================
		public static void or() {
			String out= "//or \n "
					+ "@SP\n" +
				    "AM=M-1\n" +
				    "D=M\n" +
				    "A=A-1\n" +
				    "M=D|M\n";
		 write(out);
	}
//======================================================================
		public static void and() {
			String out= "//and \n "
					+"@SP\n" +
				    "AM=M-1\n" +
				    "D=M\n" +
				    "A=A-1\n" +
				    "M=D&M\n";
		 write(out);
		}
//======================================================================
		public static void eq() {
			
			String out=  "//EQ \n"
					+ "@SP\n" +
				      "AM=M-1\n" +
				      "D=M\n" +
				      "A=A-1\n" +
				      "D=M-D\n" +
				      "@EQ.true." + n + "\n" +
				      "D;JEQ\n" +
				      "@SP\n" +
				      "A=M-1\n" +
				      "M=0\n" +
				      "@EQ.after." + n + "\n" +
				      "0;JMP\n" +
				      "(EQ.true." + n + ")\n" +
				      "@SP\n" +
				      "A=M-1\n" +
				      "M=-1\n" +
				      "(EQ.after." + n + ")\n";
			 write(out);
					n++;
		}
//======================================================================
		public static void neg() {
			String out ="//neg\n"
					+"@SP\n" +
				    "A=M-1\n" +
				    "M=-M\n";	
			 write(out);
		}
//======================================================================
		public static void lt() {
		
			String out= "//LT \n"
					+ "@SP\n" +
				      "AM=M-1\n" +
				      "D=M\n" +
				      "A=A-1\n" +
				      "D=M-D\n" +
				      "@LT.true." + n + "\n" +
				      "D;JLT\n" +
				      "@SP\n" +
				      "A=M-1\n" +
				      "M=0\n" +
				      "@LT.after." + n + "\n" +
				      "0;JMP\n" +
				      "(LT.true." + n + ")\n" +
				      "@SP\n" +
				      "A=M-1\n" +
				      "M=-1\n" +
				      "(LT.after." + n + ")\n";
		 write(out);
		 n++;
		}
//======================================================================
		public static void gt() {
		
			String out=  "//gt \n"
					+ "@SP\n" +
				      "AM=M-1\n" +
				      "D=M\n" +
				      "A=A-1\n" +
				      "D=M-D\n" +
				      "@GT.true." + n + "\n" +
				      "\nD;JGT\n" +
				      "@SP\n" +
				      "A=M-1\n" +
				      "M=0\n" +
				      "@GT.after." + n + "\n" +
				      "0;JMP\n" +
				      "(GT.true." + n + ")\n" +
				      "@SP\n" +
				      "A=M-1\n" +
				      "M=-1\n" +
				      "(GT.after." + n + ")\n";
		 write(out);
		 n++;
		}
//======================================================================
		public static void not() {
			String out= "//not \n"
					+ " @SP \n"
				    + "A=M-1 \n"
				    + "M=!M\n";
		 write(out);
		}
//======================================================================
		public static void sub() {
			String out="//sub\n"
					+ "@SP\n" +
				    "AM=M-1\n" +
				    "D=M\n" +
				    "A=A-1\n" +
				    "M=M-D\n";
			 write(out);
		}
	//======================================================================
			public static void add() {
				String out ="//add \n"
						+ "@SP\n" +
					    "AM=M-1\n" +
					    "D=M\n" +
					    "A=A-1\n" +
					    "M=D+M\n";
				 write(out);
	        }
//======================================================================
	public static void pushconst(String x) {
		String out ="//Push Constant i \n"
				+ "@"+x +"\n"
				+ "D=A\n"
				+ "@SP\n"
				+ "A=M\n"
				+ "M=D\n"
				+ "@SP\n"
				+ "M=M+1\n";	
		 write(out);
	}
//======================================================================
	public static void pushstatic(String x) {
		String out ="//Push Static i \n"
				+ "@" + fileee + "." + x + "\n" +
		          "D=M\n" +
		          "@SP\n" +
		          "A=M\n" +
		          "M=D\n" +
		          "@SP\n" +
		          "M=M+1\n";
				
				write(out);
		
	}
//======================================================================
	public static void pusharg(String x) {
		String out ="//Push Argument i \n"
				+ "@ARG\n" +
		          "D=M\n" +
		          "@" + x + "\n" +
		          "A=D+A\n" +
		          "D=M\n" +
		          "@SP\n" +
		          "A=M\n" +
		          "M=D\n" +
		          "@SP\n" +
		          "M=M+1\n";

				
				write(out);
}
//======================================================================
	public static void pushlocal(String x) {
		String out ="//push local \n"
				+ "@LCL\n" +
        "D=M\n" +
        "@" + x + "\n" +
        "A=D+A\n" +
        "D=M\n" +
        "@SP\n" +
        "A=M\n" +
        "M=D\n" +
        "@SP\n" +
        "M=M+1\n";
				
				write(out);
}

//======================================================================
	public static void pushtemp(String x) {
String out ="//push temp \n"
		+ "@R5\n" +
        "D=A\n" +
        "@" + x + "\n" +
        "A=D+A\n" +
        "D=M\n" +
        "@SP\n" +
        "A=M\n" +
        "M=D\n" +
        "@SP\n" +
        "M=M+1\n";
				
				write(out);
}
//======================================================================
	public static void pushthis(String x) {
String out ="//push this\n "
		+ "@THIS\n" +
        "D=M\n" +
        "@" + x + "\n" +
        "A=D+A\n" +
        "D=M\n" +
        "@SP\n" +
        "A=M\n" +
        "M=D\n" +
        "@SP\n" +
        "M=M+1\n";
				
				write(out);
}
//======================================================================
	public static void pushthat(String x) {
String out = "//push that\n"
		+ "@THAT\n" +
        "D=M\n" +
        "@" + x + "\n" +
        "A=D+A\n" +
        "D=M\n" +
        "@SP\n" +
        "A=M\n" +
        "M=D\n" +
        "@SP\n" +
        "M=M+1\n";
				
				write(out);
	}
	
	
//======================================================================
		public static void pushpointer(String x) {
			 String out;
				if (x.equals("0")) {
			           out="//Push Pointer 0 \n"+
			            "@THIS\n" +
			            "D=M\n" +
			            "@SP\n" +
			            "A=M\n" +
			            "M=D\n" +
			            "@SP\n" +
			            "M=M+1\n";
				}
			        else{
			        	out="//Push Pointer 1 \n"+
			            "@THAT\n" +
			            "D=M\n" +
			            "@SP\n" +
			            "A=M\n" +
			            "M=D\n" +
			            "@SP\n" +
			            "M=M+1\n";
			        }
						write(out);

			}

		
//======================================================================
				public static void poppointer(String x) {
			          String out;
			          if (x.equals("0")) {
			              out="//pop Pointer 0 \n"+
			                "@THIS\n" +
			                "D=A\n" +
			                "@R13\n" +
			                "M=D\n" +
			                "@SP\n" +
			                "AM=M-1\n" +
			                "D=M\n" +
			                "@R13\n" +
			                "A=M\n" +
			                "M=D\n";
				}
				else {
			              out="//Pop Pointer 1 \n"+
			                "@THAT\n" +
			                "D=A\n" +
			                "@R13\n" +
			                "M=D\n" +
			                "@SP\n" +
			                "AM=M-1\n" +
			                "D=M\n" +
			                "@R13\n" +
			                "A=M\n" +
			                "M=D\n";
				}
							write(out);

				}
//======================================================================
				public static void popstatic(String x) {
					String out ="//pop  static i \n"
							+ "@" + fileee + "." + x + "\n" +
					          "D=A\n" +
					          "@R13\n" +
					          "M=D\n" +
					          "@SP\n" +
					          "AM=M-1\n" +
					          "D=M\n" +
					          "@R13\n" +
					          "A=M\n" +
					          "M=D\n";
							
							write(out);

				}
//======================================================================
		public static void poparg(String x) {
			
			String out ="//pop argument \n"
					+ "@ARG\n" +
			          "D=M\n" +
			          "@" + x + "\n" +
			          "D=D+A\n" +
			          "@R13\n" +
			          "M=D\n" +
			          "@SP\n" +
			          "AM=M-1\n" +
			          "D=M\n" +
			          "@R13\n" +
			          "A=M\n" +
			          "M=D\n";
					
					write(out);
	}
//======================================================================
		public static void poplocal(String x) {
		   
			String out ="//pop local \n"
					+ "@LCL\n" +
			          "D=M\n" +
			          "@" + x + "\n" +
			          "D=D+A\n" +
			          "@R13\n" +
			          "M=D\n" +
			          "@SP\n" +
			          "AM=M-1\n" +
			          "D=M\n" +
			          "@R13\n" +
			          "A=M\n" +
			          "M=D\n";
					
					write(out);
			
	}
//======================================================================
		public static void poptemp(String x) {
			String out ="//pop temp \n"
					+ "@R5\n" +
			          "D=A\n" +
			          "@" + x + "\n" +
			          "D=D+A\n" +
			          "@R13\n" +
			          "M=D\n" +
			          "@SP\n" +
			          "AM=M-1\n" +
			          "D=M\n" +
			          "@R13\n" +
			          "A=M\n" +
			          "M=D\n";
					
					write(out);

			
	}
//======================================================================
		public static void popthis(String x) {
			String out ="//pop this \n"
					+ "@THIS\n" +
			          "D=M\n" +
			          "@" + x + "\n" +
			          "D=D+A\n" +
			          "@R13\n" +
			          "M=D\n" +
			          "@SP\n" +
			          "AM=M-1\n" +
			          "D=M\n" +
			          "@R13\n" +
			          "A=M\n" +
			          "M=D\n";
					
					write(out);
		}
//======================================================================
		public static void popthat(String x) {
			String out ="//pop that \n"
					+ "@THAT\n" +
			          "D=M\n" +
			          "@" + x + "\n" +
			          "D=D+A\n" +
			          "@R13\n" +
			          "M=D\n" +
			          "@SP\n" +
			          "AM=M-1\n" +
			          "D=M\n" +
			          "@R13\n" +
			          "A=M\n" +
			          "M=D\n";
					
					write(out);
		}
//======================================================================
		public static void write ( String data ) {
			try {
				File file = new File(fileee+".asm");
		        FileWriter fileWriter = new FileWriter(file,true); // creating writer
		        BufferedWriter writer = new BufferedWriter(fileWriter);
		        System.out.println("Writer is called");
		        writer.write(data);
		        writer.close();
		        
			}catch (Exception E) {
				
			}
		}
}
