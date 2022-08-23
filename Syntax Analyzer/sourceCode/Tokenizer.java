import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Tokenizer {

    private static ArrayList<String> tokens = new ArrayList<>();
    private static ArrayList<String> tokenized_tokens = new ArrayList<>();

    public static void tokenize(String address) throws IOException {

        ArrayList<String> keyWords = new ArrayList<>();
        keyWords.add("class");
        keyWords.add("constructor");
        keyWords.add("function");
        keyWords.add("method");
        keyWords.add("field");
        keyWords.add("static");
        keyWords.add("var");
        keyWords.add("int");
        keyWords.add("true");
        keyWords.add("false");
        keyWords.add("null");
        keyWords.add("let");
        keyWords.add("do");
        keyWords.add("if");
        keyWords.add("else");
        keyWords.add("while");
        keyWords.add("return");
        keyWords.add("void");
        keyWords.add("this");

        ArrayList<String> symbols = new ArrayList<>();
        symbols.add("{");
        symbols.add("}");
        symbols.add("(");
        symbols.add(")");
        symbols.add("[");
        symbols.add("]");
        symbols.add(".");
        symbols.add(",");
        symbols.add(";");
        symbols.add("+");
        symbols.add("-");
        symbols.add("*");
        symbols.add("/");
        symbols.add("&");
        symbols.add("|");
        symbols.add("<");
        symbols.add(">");
        symbols.add("=");
        symbols.add("~");

        File src = new File(address);
        FileReader fr = new FileReader(src);
        BufferedReader br = new BufferedReader(fr);

        int currentCharInt = 0;
        String currentToken = "";
        boolean isInString = false;

        while ((currentCharInt = br.read()) != -1) {
            char currentChar = (char) currentCharInt;
            if (isInString) {
                if (currentChar == '"') {
                    isInString = false;
                    tokens.add(encloseString(currentToken));
                    currentToken = "";
                } else {
                    currentToken = currentToken + currentChar;
                }
            } else if (currentChar == '"') {
                isInString = true;
            } else if (Character.isAlphabetic(currentChar) | currentChar == '_' | Character.isDigit(currentChar)) {
                currentToken = currentToken + currentChar;
            } else if (currentChar == ' ' & currentToken != "") {
                if (keyWords.contains(currentToken)) {
                    tokens.add((currentToken));
                    currentToken = "";
                } else if (isInt(currentToken)) {
                    tokens.add((currentToken));
                    currentToken = "";
                } else {
                    tokens.add((currentToken));
                    currentToken = "";
                }
            } else if (symbols.contains(String.valueOf(currentChar)) & currentToken != "") {
                if (isInt(currentToken)) {
                    tokens.add((currentToken));
                    currentToken = "" + currentChar;
                } else {
                    tokens.add((currentToken));
                    currentToken = "" + currentChar;
                }
                tokens.add((currentToken));
                currentToken = "";
            } else if (symbols.contains(String.valueOf(currentChar)) & currentToken == "") {
                currentToken = currentToken + currentChar;
                tokens.add(currentToken);
                currentToken = "";
            }

        }

        tokenized_tokens.add("<tokens>");

        for (String token : tokens) {
            token = token.strip();
            if (keyWords.contains(token)){
                tokenized_tokens.add(encloseKeyWord(token));
            }else if (symbols.contains(token)){
                tokenized_tokens.add(encloseSymbol(token));
            }else if (token.startsWith("<stringConstant>")){
                tokenized_tokens.add(token);
            }else if (isInt(token)){
                tokenized_tokens.add(encloseInteger(token));
            }else{
                tokenized_tokens.add(encloseIdentifier(token));
            }
        }
        tokenized_tokens.add("</tokens>");
        // System.out.println(keyWords.contains("this"));
        br.close();
        writer(tokenized_tokens, address);

    }

    private static String encloseKeyWord(String keyWord) {
        return "<keyword>" + keyWord.strip() + "</keyword>";
    }

    private static String encloseIdentifier(String Identifier) {
        return "<identifier>" + Identifier.strip() + "</identifier>";
    }

    private static String encloseSymbol(String symbol) {
        return "<symbol>" + symbol.strip() + "</symbol>";
    }

    private static String encloseString(String s) {
        return "<stringConstant>" + s.strip() + "</stringConstant>";
    }

    private static String encloseInteger(String integer) {
        return "<integerConstant>" + integer.strip() + "</integerConstant>";
    }

    private static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static void writer(ArrayList<String> tokens, String sourceAddress) throws IOException {
        String[] adr = sourceAddress.split("[.]", 0);
        String address = adr[0].strip() + ".xml";
        File out = new File(address);
        FileWriter fw = new FileWriter(out);
        // for (String string : tokens) {
        //     fw.write(string + "\n");
        // }

        fw.write(new Prettier().format(String.join(" ",tokens)));
        fw.close();
        fw.close();
    }
}
