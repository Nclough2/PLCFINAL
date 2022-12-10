

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Parse {
	static int nextTokenIndex=0;
	static Token<Type, String> nextToken=null;
	static List<Token<Type, String>> tt;
	
	static void nextToken() {		
		if(nextTokenIndex == tt.size()-1) {					
			return;
		}
		nextTokenIndex++;
		nextToken = tt.get(nextTokenIndex);		
		if(nextToken.type==Type.ASSIGN_OP) {
			assign();
			return;
		}
		System.out.println(nextToken);
	}

	static void assign() {		
		System.out.println("Enter <assign>");	
		System.out.println(nextToken);
		nextToken();
		expr();
		System.out.println("Exit <assign>");
	} 
	
	static void expr() {
		/* Parse the first term */
		System.out.println("Enter <expr>");
		 term();
		 while (nextToken.type == Type.ADD_OP || nextToken.type == Type.SUB_OP){
			 nextToken();
			 term();
		 }
		 System.out.println("Exit <expr>");
	} 
	static void term() {
		System.out.println("Enter <term>");
		 factor();
		 while (nextToken.type == Type.MULT_OP||nextToken.type ==Type.DIV_OP) {
			 nextToken();
			 factor(); 
		 }
		 System.out.println("Exit <term>");
	} 
	
	 static void factor() {
		 System.out.println("Enter <factor>");
		 if (nextToken.type == Type.IDENT||nextToken.type==Type.INT_LIT )
			 nextToken();
		 else {
			 if (nextToken.type == Type.LEFT_PAREN) {
				 nextToken();
				 expr();
				 if (nextToken.type == Type.RIGHT_PAREN)
					 nextToken();
				 else
					 return;
			 }  else
				 return;
		 } 
		 System.out.println("Exit <factor>");
	 } 
 	 
	 public static void main(String[] args) throws IOException {
		try {
			final String dir = System.getProperty("user.dir");
	        String path = dir.replace("/", "\\\\") ;
			Scanner sc = new Scanner(new File( path+"\\statements.txt"));	
			while (sc.hasNext()) {
				String input= sc.nextLine();
				int idx=input.indexOf(":");
				if(idx>=0) {
					String input1=input.substring(idx+1);
					System.out.println(input);			
					List<Token<Type, String>> tokens = LexicalAnalyzer.lex(input1);
					tt =tokens;				
					nextToken = tt.get(0);
					nextTokenIndex=0;
					System.out.println(nextToken);						
					nextToken();					
				} 			
			}
			System.out.println("END_OF_FILE");
			sc.close();
		} catch (FileNotFoundException e){
			System.out.println(e);
		}catch (Exception e){
			System.out.println(e);
		}
	}
}
