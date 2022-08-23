package VM_1;

import java.io.*;
import java.io.File;
import java.io.FileWriter;

public class vm1 {
	public static String f= "Test";
public static void main(String[] args) {
	try {
		File file = new File(f+".asm");
        FileWriter fileWriter = new FileWriter(file,false); // creating writer
        BufferedWriter writer = new BufferedWriter(fileWriter);
        
        writer.flush();
        writer.close();
        
	}catch (Exception E) {
		
	}
	parser p = new parser (f);
	System.out.println("Done");
}

}
