public class Compiler {
 Compiler(String filepath){
    Lex lex= new Lex(input: "THESE ARE ALL THE WORDS IN MY FILE");
    List<Token> lexOutput = lex.tokenize();
    for (Token token : lexOutput) {
        System.out.println(token.lexeme + " " + token.code);
    
    }
    Syntax syntax = new Syntax(lexOutput);
    syntax.parse();

    
 }
}
