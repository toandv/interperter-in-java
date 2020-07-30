package monkey.lexer;

import monkey.token.Token;
import monkey.token.TokenType;

public class Lexer {

    private String input;
    private char currentChar;
    private int position;
    private int readPosition;

    public Lexer(String input) {
        this.input = input;
        this.readChar();
    }

    public void readChar() {
        if (this.readPosition >= this.input.length()) {
            this.currentChar = 0;
        } else {
            this.currentChar = input.charAt(this.readPosition);
            this.position = this.readPosition;
            this.readPosition++;
        }
    }

    public Token nextToken() {
        Token token = null;
        switch (this.currentChar) {
            case '+':
                token = new Token(TokenType.PLUS, this.currentChar);
                break;
            case '=':
                token = new Token(TokenType.ASSIGN, this.currentChar);
                break;
            case ',':
                token = new Token(TokenType.COMMA, this.currentChar);
                break;
            case ';':
                token = new Token(TokenType.SEMICOLON, this.currentChar);
                break;
            case '(':
                token = new Token(TokenType.LEFT_PAREN, this.currentChar);
                break;
            case ')':
                token = new Token(TokenType.RIGHT_PAREN, this.currentChar);
                break;
            case '{':
                token = new Token(TokenType.LEFT_BRACE, this.currentChar);
                break;
            case '}':
                token = new Token(TokenType.RIGHT_BRACE, this.currentChar);
                break;
            case 0:
                token = new Token(TokenType.EOF, (char) 0);
                break;
        }
        this.readChar();
        return token;
    }
}
