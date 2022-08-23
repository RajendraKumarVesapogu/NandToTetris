import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private int currentTokenIndex;
    private String currentToken;
    private ArrayList<String> tokens;
    private ArrayList<String> parseOutput = new ArrayList<>();

    public Parser(String Address) {
        try {
            this.tokens = reader(Address);
            this.currentToken = tokens.get(0);
            this.currentTokenIndex = 0;
            parse();
            writer(parseOutput, Address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parse() {
        parseClass();
    }

    private boolean isOp(String token) {
        char sy = token.charAt(8);
        if (sy == '+') {
            return true;
        } else if (sy == '-') {
            return true;
        } else if (sy == '*') {
            return true;
        } else if (sy == '/') {
            return true;
        } else if (sy == '<') {
            return true;
        } else if (sy == '>') {
            return true;
        } else if (sy == '=') {
            return true;
        } else {
            return false;
        }
    }

    private void parseExpression() {
        parseOutput.add("<expression>");
        while (currentToken.contains("<identifier>") | isOp(currentToken)
                | currentToken.contains("<integerConstant>" )|currentToken.contains( "<stringConstant>")){
            if (currentToken.contains("<identifier>") | currentToken.contains("<integerConstant>")|currentToken.contains( "<stringConstant>")) {
                parseOutput.add("<term>");
                parseOutput.add(currentToken);
                parseOutput.add("</term>");
                Advance();

            } else if (isOp(currentToken)) {
                // parseOutput.add("<op>");
                parseOutput.add(currentToken);
                // parseOutput.add("</op>");
                Advance();
            }
        }
        parseOutput.add("</expression>");
    }

    private void parseExpressionList() {
        parseOutput.add("<expressionList>");
        parseExpression();
        while (currentToken.contains(",")) {
            Advance();
            parseExpression();
        }
        parseOutput.add("</expressionList>");
    }

    private void parseStatemets() {
        if (currentToken.contains("{")) {
            parseOutput.add(currentToken);
            parseOutput.add("<statements>");
            int bracketCount = 1;

            while (bracketCount > 0) {
                if (currentToken.contains("}")) {
                    bracketCount = 0;
                    parseOutput.add("</statements>");
                    parseOutput.add(currentToken);
                    return;
                }

                if (currentToken.contains("let")) {
                    parseLetStatement();
                } else if (currentToken.contains("while")) {
                    parseWhileStatement();
                } else if (currentToken.contains(">if<")) {
                    parseIfStatement();
                } else if (currentToken.contains("return")) {
                    parseReturnStatement();
                } else if (currentToken.contains("do")) {
                    parseDoStatement();
                }
                Advance();
            }

        } else {
            System.err.println("illegal call");
            System.exit(0);
        }

    }

    private void parseWhileStatement() {
        parseOutput.add("<whileStatement>");
        parseOutput.add(currentToken);
        Advance();
        if (currentToken.contains("(")) {
            parseOutput.add(currentToken);
            Advance();
            parseExpression();
            parseOutput.add(currentToken);
            Advance();
        } else {
            System.err.println("invalid syntax");
            System.exit(0);
        }

        if (currentToken.contains("{")) {
            parseStatemets();
        } else {
            System.err.println("invalid syntax");
            System.exit(0);
        }
        parseOutput.add("</whileStatement>");
    }

    private void parseIfStatement() {
        if (currentToken.contains(">if<")) {
            parseOutput.add("<ifStatement>");
            parseOutput.add(currentToken);
            Advance();
        } else {
            System.err.println("invalid if call 1"+ String.valueOf(currentTokenIndex));
            System.exit(0);
        }

        if (currentToken.contains("(")) {
            parseOutput.add(currentToken);
            Advance();
            parseExpression();
        } else {
            System.err.println("invalid if call 2" +String.valueOf(currentTokenIndex));
            System.exit(0);
        }
        if (currentToken.contains(")")) {
            parseOutput.add(currentToken);
            Advance();

        } else {
            System.err.println("invalid if call 3" + String.valueOf(currentTokenIndex));
            System.exit(0);
        }
        if (currentToken.contains("{")) {
            parseStatemets();
        } else {
            System.err.println("invalid if syntax 4" + String.valueOf(currentTokenIndex));
            System.exit(0);
        }
        parseOutput.add("</ifStatement>");
    }

    private void parseLetStatement() {
        if (currentToken.contains("let")){
            parseOutput.add("<letStatement>");
            parseOutput.add(currentToken);
            Advance();
        }
        else{
            System.err.println("invalid let call 1");
            System.exit(0);
        }

        if (currentToken.contains("<identifier>")){
            parseOutput.add(currentToken);
            Advance();
        }else{
            System.err.println("invalid let call 2");
            System.exit(0);
        }

        if (currentToken.contains("=")){
            parseOutput.add(currentToken);
            Advance();
        }else{
            System.err.println("invalid let call 3");
            System.exit(0);
        }

        parseExpression();

        if (currentToken.contains(";")){
            parseOutput.add(currentToken);
            // Advance();
        }else{
            System.err.println("invalid let call 4");
            System.exit(0);
        }
        parseOutput.add("</letStatement>");

    }

    private void parseDoStatement() {
        if (currentToken.contains("do")){
            parseOutput.add("<doStatement>");
            parseOutput.add(currentToken);
            Advance();
        }
        else{
            System.err.println("invalid do call");
            System.exit(0);
        }

        if (currentToken.contains("<identifier>")){
            while(! currentToken.contains("(")){
                parseOutput.add(currentToken);
                Advance();
            }
            if (currentToken.contains("(")){
                parseOutput.add(currentToken);
                Advance();
                parseExpressionList();
                if(currentToken.contains(")")){
                    parseOutput.add(currentToken);
                    Advance();
                }
                if (currentToken.contains(";")){
                    parseOutput.add(currentToken);
                }
            }
        }else{
            System.err.println("invalid do call");
            System.exit(0);
        }
        parseOutput.add("</doStatement>");
    }


    private void parseReturnStatement() {
        if (currentToken.contains("return")){
            parseOutput.add("<returnStatement>");
            parseOutput.add(currentToken);
            Advance();
        }
        else{
            System.err.println("invalid let call");
            System.exit(0);
        }

        parseExpression();
        if (currentToken.contains(";")){
            parseOutput.add(currentToken);
        }
        parseOutput.add("</returnStatement>");
    }

    private void parseSubroutineDec() {
        parseOutput.add("<subroutineDec>");
        parseOutput.add(currentToken);
        Advance();

        if (currentToken.contains("<identifier>") | currentToken.contains("<keyword>")) {
            parseOutput.add(currentToken);
        } else {
            System.err.println("the subroutine declaration sytax is not correct");
            System.exit(0);
        }
        Advance();

        if (currentToken.contains("<identifier>")) {
            parseOutput.add(currentToken);
        } else {
            System.err.println("the subroutine declaration sytax is not correct");
            System.exit(0);
        }
        Advance();

        if (currentToken.contains("<symbol>(</symbol>")) {
            parseOutput.add(currentToken);
            parseOutput.add("<parameterList>");
        } else {
            System.err.println("the subroutine declaration sytax is not correct");
            System.exit(0);
        }
        Advance();

        while (!currentToken.equals("<symbol>)</symbol>")) {
            parseOutput.add(currentToken);
            Advance();
        }
        parseOutput.add("</parameterList>");
        parseOutput.add(currentToken);
        Advance();

        if (currentToken.contains("<symbol>{</symbol>")) {
            parseOutput.add("<subroutineBody>");
            parseStatemets();
            parseOutput.add("</subroutineBody>");
        } else {
            System.err.println("the subroutine declaration sytax is not correct");
            System.exit(0);
        }

        parseOutput.add("</subroutineDec>");
    }

    private void parseClassVarDec() {
        parseOutput.add("<classVarDec>");
        while (!currentToken.equals("<symbol>;</symbol>")) {
            parseOutput.add(currentToken);
            Advance();
        }
        parseOutput.add(currentToken);
        parseOutput.add("</classVarDec>");
    }

    private void parseClass() {
        int class_count = 0;
        parseOutput.add("<class>");
        parseOutput.add(currentToken);
        Advance();
        if (currentToken.contains("<identifier>")) {
            parseOutput.add(currentToken);
        } else {
            System.err.println("the class declaration sytax is not correct 1");
            System.exit(0);
        }
        Advance();
        if (currentToken.contains("<symbol>{</symbol>")) {
            class_count += 1;
            parseOutput.add(currentToken);
        } else {
            System.err.println("the class declaration sytax is not correct 2");
            System.exit(0);
        }
        Advance();

        while (class_count > 0) {
            if (currentToken.contains("<symbol>{</symbol>")) {
                class_count += 1;
            } else if (currentToken.contains("<symbol>}</symbol>")) {
                class_count -= 1;
            }

            if (currentToken.contains("<keyword>field</keyword>")
                    | currentToken.contains("<keyword>static</keyword>")) {
                parseClassVarDec();
            } else if (currentToken.contains("<keyword>constructor</keyword>")
                    | currentToken.contains("<keyword>method</keyword>")
                    | currentToken.contains("<keyword>function</keyword>")) {
                parseSubroutineDec();
            } else if (currentToken.contains("<keyword>class</keyword>")) {
                parseClass();
            }
            if (currentTokenIndex < tokens.size()-1){
                Advance();
            }
        }

        if (currentToken.contains("<symbol>}</symbol>")) {
            parseOutput.add(currentToken);
        } else {
            System.err.println("the class declaration sytax is not correct 3");
            System.exit(0);
        }
        parseOutput.add("</class>");
    }

    private static ArrayList<String> reader(String Address) throws IOException {
        File src = new File(Address);
        FileReader fr = new FileReader(src);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> tokens = new ArrayList<>();
        String currentToken;
        while ((currentToken = br.readLine()) != null) {
            tokens.add(currentToken.strip());
        }
        br.close();

        tokens.remove(0);
        tokens.remove(tokens.size()-1);
        return tokens;
    }

    private static void writer(ArrayList<String> tokenized, String sourceAddress) throws IOException {
        String[] adr = sourceAddress.split("[.]", 0);
        String address = adr[0].strip() + "P.xml";
        File out = new File(address);
        FileWriter fw = new FileWriter(out);
        // for (String string : tokenized) {
        //     fw.write(string + "\n");
        // }

        fw.write(new Prettier().format(String.join(" ",tokenized)));
        fw.close();
    }

    private void Advance() {
        this.currentTokenIndex += 1;
        this.currentToken = tokens.get(currentTokenIndex);
    }
}
