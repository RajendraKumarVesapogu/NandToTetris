import seperator # importing the seperator class
class parser:
    def _init_(self, fileName):
        self.final = [] # list that stores the final values
        self.tokens = seperator.seperator.getTokens(fileName) # getting the token objects from the seperator class
        self.tokenIndex = 0; # Index of the current token

    def toString(self, tokenObject):
        return tokenObject.openTag + " " + tokenObject.token + " " + tokenObject.closeTag
    
    def curToken(self): # returns the current token
        return self.tokens[self.tokenIndex]
    
    def nextToken(self): # returns the next token
        return self.tokens[self.tokenIndex + 1]
    
    def advToken(self): # returns the current token and advances the index
        self.tokenIndex += 1
        return self.tokens[self.tokenIndex - 1]

    
    def compileClass(self):
        self.final.append("<class>")
        self.final.append(self.toString(self.advToken())) # class
        self.final.append(self.toString(self.advToken())) # class name
        self.final.append(self.toString(self.advToken())) # {
        
        while(self.curToken().token in ("static", "field")): # for the class variables declearations
            self.compileClassVarDec()

        while(self.curToken().token in ("constructor", "function", "method")): # for the subroutines
            self.compileSubroutineDec()
        
        self.final.append(self.toString(self.advToken())) # }
        self.final.append("</class>")

    def compileClassVarDec(self):
        self.final.append("<classVarDec>")
        self.final.append(self.toString(self.advToken())) # static or field
        self.final.append(self.toString(self.advToken())) # type ("int", "char", "boolean", "void", "className")
        
        while(self.curToken().token != ";"):
            self.final.append(self.toString(self.advToken())) # , (multiple variables)
        
        self.final.append(self.toString(self.advToken())) # ; (end of variable declaration)
        self.final.append("</classVarDec>")
    
    def compileSubroutineDec(self):
        self.final.append("<subroutineDec>")
        self.final.append(self.toString(self.advToken())) # constructor, function, or method
        self.final.append(self.toString(self.advToken())) # type ("int", "char", "boolean", "void", "className")
        self.final.append(self.toString(self.advToken())) # subroutineName
        self.final.append(self.toString(self.advToken())) # opening '(' bracket

        self.compileParameterList() # Parameter List

        self.final.append(self.toString(self.advToken())) # closing ')' bracket
        
        self.compileSubroutineBody() # subroutine body
        
        self.final.append("</subroutineDec>")
        
        

        

    
    def compileParameterList(self):
        self.final.append("<parameterList>")
                
        while self.curToken().token != ")":
            self.final.append(self.toString(self.advToken())) # parameters

        self.final.append("</parameterList>")

        #self.final.append(self.toString(self.advToken())) # closing bracket if parameter is there
    
    def compileSubroutineBody(self):
        self.final.append("<subroutineBody>")
        self.final.append(self.toString(self.advToken())) # '{' opening bracket

        
        if self.curToken().token == "var":
            while self.curToken().token == "var":
                self.compileVarDec()
        
        

        else: # statements
            self.compileStatements()
        
        self.final.append(self.toString(self.advToken())) # '}' closing bracket
        self.final.append("</subroutineBody>")
        
     

        
  

    def compileVarDec(self):
        self.final.append("<varDec>")
        self.final.append(self.toString(self.advToken())) # var
        self.final.append(self.toString(self.advToken())) # type ("int", "char", "boolean", "void", "className")

        while(self.curToken().token != ";"):
            self.final.append(self.toString(self.advToken())) # , (multiple variables)

        self.final.append(self.toString(self.advToken())) # ; (end of variable declaration)
        self.final.append("</varDec>")

    def compileStatements(self):
        self.final.append("<statements>")
        while self.curToken().token in ("let", "if", "while", "do", "return"):
            if self.curToken().token == "let":
                self.compileLet()
            elif self.curToken().token == "if":
                self.compileIf()
            elif self.curToken().token == "while":
                self.compileWhile()
            elif self.curToken().token == "do":
                self.compileDo()
            elif self.curToken().token == "return":
                self.compileReturn()
        self.final.append("</statements>")
    
    def compileLet(self):
        self.final.append("<letStatement>")
        self.final.append(self.toString(self.advToken())) # let
        self.final.append(self.toString(self.advToken())) # varName

        if self.curToken().token == '[':
            self.final.append(self.toString(self.advToken()))
            self.compileExpression() # Handles expression
            self.final.append(self.toString(self.advToken())) # closing bracket
        
        self.final.append(self.toString(self.advToken())) # =
        self.compileExpression() # Handles expression

        self.final.append(self.toString(self.advToken())) # ;
        self.final.append("</letStatement>")
    
    def compileDo(self):
        self.final.append("<doStatement>")
        self.final.append(self.toString(self.advToken())) # do
        self.final.append(self.toString(self.advToken())) # subroutineName

        if self.curToken().token == "(":
            self.final.append(self.toString(self.advToken())) # opening '(' bracket
         
        elif self.curToken().token == ".":
            self.final.append(self.toString(self.advToken())) # .
            self.final.append(self.toString(self.advToken())) # className or varName
            self.final.append(self.toString(self.advToken())) # opening '(' bracket

        self.compileExpressionList() # Handles expression list
        self.final.append(self.toString(self.advToken())) # closing ')' bracket
        self.final.append(self.toString(self.advToken())) # ;
        self.final.append("</doStatement>")


    
    def compileIf(self):
        self.final.append("<ifStatement>")
        self.final.append(self.toString(self.advToken())) # if 
        self.final.append(self.toString(self.advToken())) # (
        
        self.compileExpression() # Handles expression

        self.final.append(self.toString(self.advToken())) # )
        self.final.append(self.toString(self.advToken())) # {
        
        self.compileStatements() # Handles statements

        self.final.append(self.toString(self.advToken())) # }

        if self.curToken().token == "else":
            self.final.append(self.toString(self.advToken())) # else
            self.final.append(self.toString(self.advToken())) # {

            self.compileStatements() # Handles statements

            self.final.append(self.toString(self.advToken())) # }

        self.final.append("</ifStatement>")
    
    def compileWhile(self):
        self.final.append("<whileStatement>")
        self.final.append(self.toString(self.advToken()))
        self.final.append(self.toString(self.advToken())) # (
        
        self.compileExpression() # Handles expression

        self.final.append(self.toString(self.advToken())) # )
        self.final.append(self.toString(self.advToken())) # {

        self.compileStatements() # Handles statements

        self.final.append(self.toString(self.advToken())) # }
        self.final.append("</whileStatement>")
    
    def compileReturn(self):
        self.final.append("<returnStatement>")
        self.final.append(self.toString(self.advToken()))

        if self.curToken().token != ";":
            self.compileExpression()
        
        self.final.append(self.toString(self.advToken())) # ;
        self.final.append("</returnStatement>")

    def compileExpression(self):
        self.final.append("<expression>")
        self.compileTerm()
        while self.curToken().token in ("+", "-", "*", "/", "&amp", "|", "&lt", "&gt", "="):
            self.final.append(self.toString(self.advToken()))
            self.compileTerm()
        self.final.append("</expression>")
    
    def compileTerm(self):
        self.final.append("<term>")
        
        if self.curToken().openTag in ("<integerConstant>", "<stringConstant>", "<keyword>"):
            self.final.append(self.toString(self.advToken()))

        elif self.curToken().openTag == "<identifier>":
            self.final.append(self.toString(self.advToken()))

            if self.curToken().token == "[":
                self.final.append(self.toString(self.advToken())) # [
                self.compileExpression()
                self.final.append(self.toString(self.advToken())) # ]

            elif self.curToken().token in (".", "("):
                if self.curToken().token == "(":
                    self.final.append(self.toString(self.advToken())) # (

                elif self.curToken().token == ".":
                    self.final.append(self.toString(self.advToken())) # .
                    self.final.append(self.toString(self.advToken())) # subroutineName
                    self.final.append(self.toString(self.advToken())) # (
                
                self.compileExpressionList()

                if self.curToken().token == ")":
                    self.final.append(self.toString(self.advToken())) # )
        
        elif self.curToken().token == "(":
            self.final.append(self.toString(self.advToken()))
            self.compileExpression()

            if self.curToken().token == ")":
                self.final.append(self.toString(self.advToken()))

        elif self.curToken().token in ("-", "~"):
            self.final.append(self.toString(self.advToken()))
            self.compileTerm()
        
        self.final.append("</term>")
    
    def compileExpressionList(self):
        self.final.append("<expressionList>")
        if self.curToken().token != ")":
            self.compileExpression()
            while self.curToken().token == ",":
                self.final.append(self.toString(self.advToken()))
                self.compileExpression()
        self.final.append("</expressionList>")
        
    def compileSubroutineCall(self):
        pass

    def parse(self):
        self.compileClass()
        return self.final


# Main -----------------------------------------

with open("test.xml", "w") as file:
    a = parser("MainT.xml")
    for i in a.parse():
        file.write(i + "\n")