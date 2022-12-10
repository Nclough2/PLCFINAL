public class Token {

    int code;
    String lexeme;

    Token(int code, String lexeme) {
        this.code = code;
        this.lexeme = lexeme;

    }

    Token(int code) {
        this.code = code;
    }
}
