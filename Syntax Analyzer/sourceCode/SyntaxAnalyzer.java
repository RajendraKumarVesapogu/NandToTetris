import java.util.Scanner;

public class SyntaxAnalyzer {
    @SuppressWarnings("unused")
    public static void main(String[] args) throws Exception {
        System.out.println("enter the path of the file");
        Scanner sc = new Scanner(System.in);
        String address = sc.nextLine();
        Tokenizer.tokenize(address);
        String[] adr = address.split("[.]", 0);
        String address1 = adr[0].strip() + ".xml";
        Parser pa = new Parser(address1);
        sc.close();
    }
}
