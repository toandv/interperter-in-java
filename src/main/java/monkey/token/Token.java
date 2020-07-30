package monkey.token;

import java.util.Objects;

public class Token {

    public final TokenType type;

    public final String literal;

    public Token(TokenType type, String literal) {
        this.type = type;
        this.literal = literal;
    }

    public Token(TokenType type, char literal) {
        this.type = type;
        this.literal = String.valueOf(literal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return type == token.type &&
                literal.equals(token.literal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, literal);
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", literal='" + literal + '\'' +
                '}';
    }
}
