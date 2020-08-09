package client.model.modelacc;

import java.io.Serializable;

public class VOS implements Account, Serializable {

    private String username;
    private String password;

    public VOS(String username, String password) {
        this.password = password;
        this.username= username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
