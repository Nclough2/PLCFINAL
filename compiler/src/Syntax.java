import java.util.List;

public class Syntax {
    List<Token> tokens;
    int placeholder = 0;

    Syntax(List<Token> tokens) {
        this.tokens = tokens;

    }

    boolean parse() {
        program();
        return false;
    }

    // <S> --> aBC | b Ab
    void S() {
        if (tokens.get(placeholder).code == 10) {
            placeholder++;
            B();
            C();

        } else if (tokens.get(placeholder).code == 11) {
            placeholder++;
            A();
            if (tokens.get(placeholder).code == 11) {
                placeholder++;
            } else {
                error();
            }
        } else {
            error();
        }
    }
}
/*
 * 
 * 
 * [0-9]+(u|1|LL|i64)?
 * 
 * 
 * 
 * 
 * START --> S
 * S --> A
 * A ---> D
 * D ----> M
 * M ----> E
 * E -----> P
 * P ----> (<Start>) \ID \INT
 * 
 * P
 * E
 * M
 * D
 * A
 * S
 */