package co.com.konex.test.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class WikipediaUser extends User {

    private String userName;

    public WikipediaUser(String userName, String email, String password) {
        super(email, password);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
