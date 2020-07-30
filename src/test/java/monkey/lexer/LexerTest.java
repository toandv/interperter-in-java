package monkey.lexer;

import monkey.token.Token;
import monkey.token.TokenType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexerTest {

    @Test
    void testNexToken1() {
        String input = "+=(){};,";
        List<Token> expectedTokens = Arrays.asList(
                new Token(TokenType.PLUS, '+'),
                new Token(TokenType.ASSIGN, '='),
                new Token(TokenType.LEFT_PAREN, '('),
                new Token(TokenType.RIGHT_PAREN, ')'),
                new Token(TokenType.LEFT_BRACE, '{'),
                new Token(TokenType.RIGHT_BRACE, '}'),
                new Token(TokenType.SEMICOLON, ';'),
                new Token(TokenType.COMMA, ','),
                new Token(TokenType.EOF, (char) 0)
        );
        Lexer lexer = new Lexer(input);
        expectedTokens.forEach(expected -> assertEquals(expected, lexer.nextToken(),
                        () -> "nextToken should be: " + expected));
    }

}
