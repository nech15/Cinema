package cinema.model;

import java.util.UUID;

public class Token {
    UUID token;

    public Token() {
    }

    public Token(UUID token) {
        this.token = token;
    }

    public String  getToken() {
        return token.toString();
    }

    public void setToken(UUID token) {
        this.token = token;
    }


}
