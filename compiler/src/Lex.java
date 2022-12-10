import java.util.List;
import java.util.HashMap;
import java.util.regex.*;

public class Lex {
    List<token> token;
    String input;

    Lex(String input) {
        this.input = input;
        this.tokens = null;
        this.getTokens();
    }

    List<Token> tokenize() {
        return tokens;
    }

    void getTokens() {
        String i = "";
        if (i == new Tokens().addition.lexeme) {
            tokens.add(new Tokens().addition);
        } else if (i.charAt(0) >= 'a' && i.charAt(0) <= 'z' ||
                i.charAt(0) >= 'A' && i.charAt(0) <= 'Z' ||
                i.charAt(0) == '_') {
            tokens.add(alphabetStart());
        } else if (i.charAt(0) >= '1' && i.chatAt(0) <= '0') {
            tokens.add(alphabetStart());
        }
    }

    void getNextChar() {

    }

    Token alphabetStart() {
        return null;
    }
}

class Tokens {
    final Token addition = new Token(code: 1, lexeme: "+");
    final Token equal = new Token(code:1, lexeme:"==");
    final Token forLoop = new Token(code:4, lexeme:"for");

    final Token identifier = new Token(code:120);
    final String identifierREGEX = "[a-zA-Z][a-zA-Z0-9]";
    final HashMap<String, Integer> keywords = new HashMap<String, Integer>();

    Tokens() {
        this.keywords.put(forLoop.lexeme, forLoop);
    }
}