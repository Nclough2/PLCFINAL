
import java.io.*;
import java.util.*;

//define token types
enum Type {
	INT_LIT, IDENT, ASSIGN_OP, ADD_OP, SUB_OP, MULT_OP, DIV_OP, LEFT_PAREN, RIGHT_PAREN
}

//define token class
class Token<TokenType, TokenValue> {
    final TokenType type;
    final TokenValue value;
  
    public Token(TokenType t, TokenValue value) {
        this.type = t;
        this.value = value;
    }
    
    //override to print
    public String toString() {
        return "Next Token is: " + this.type;
    }
}
public class LexicalAnalyzer {

	//get operand, concatenate if there are multiple digits or letters
	private static String getOperand(String operand, int index) {
	    int i = index;
	    while(i < operand.length()) {
	        if (Character.isLetterOrDigit(operand.charAt(i))) {
	            i++;
	        } else {
	            return operand.substring(index, i);
	        }
	    }
	    return operand.substring(index, i);
	}
	
	// lex analyzer, input is line of expression, output the list of tokens
	public static ArrayList<Token<Type, String>> lex(String expression) {
	    ArrayList<Token<Type, String>> tokens = new ArrayList<>();
	    for (int i = 0; i < expression.length(); i++) {
	        char currChar = expression.charAt(i);
	        switch (currChar) {
	        case '+':
	            tokens.add(new Token<>(Type.ADD_OP, String.valueOf(currChar)));
	            break;
	        case '-':
	            tokens.add(new Token<>(Type.SUB_OP, String.valueOf(currChar)));
	            break;
	        case '/':
	            tokens.add(new Token<>(Type.DIV_OP, String.valueOf(currChar)));
	            break;
	        case '*':
	            tokens.add(new Token<>(Type.MULT_OP, String.valueOf(currChar)));
	            break;
	        case '(':
	            tokens.add(new Token<>(Type.LEFT_PAREN, String.valueOf(currChar)));
	            break;
	        case ')':
	            tokens.add(new Token<>(Type.RIGHT_PAREN, String.valueOf(currChar)));
	            break;
	        case '=':
	            tokens.add(new Token<>(Type.ASSIGN_OP, String.valueOf(currChar)));
	            break;
	        default:
	            if (Character.isDigit(currChar)) {
	                String operand = getOperand(expression, i);
	                i += operand.length()-1;
	                tokens.add(new Token<>(Type.INT_LIT, operand));
	            } 
	            if (Character.isLetter(currChar)) {
	                String operand = getOperand(expression, i);
	                i += operand.length()-1;
	                tokens.add(new Token<>(Type.IDENT, operand));
	            } 
	            break;
	        }
	    }
	    return tokens;
	}
	

	public static void main(String[] args) throws IOException {
		try {
			final String dir = System.getProperty("user.dir");
	        String path = dir.replace("/", "\\\\") ;
			Scanner sc = new Scanner(new File( path+"\\statements.txt"));	

			//read line by line and generate token
			while (sc.hasNext()) {
				String input= sc.nextLine();
				int idx=input.indexOf(":");
				if(idx>=0) {
					String input1=input.substring(idx+1);
					System.out.println(input);
					List<Token<Type, String>> tokens=lex(input1);				
					for(Token<Type, String> t : tokens) {
			            System.out.println(t);
					}
				}
			}
			sc.close();
		} catch (FileNotFoundException e){
			System.out.println(e);
		}catch (Exception e){
			System.out.println(e);
		}
	}
}
