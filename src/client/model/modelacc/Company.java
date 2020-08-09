package client.model.modelacc;

import java.io.Serializable;

public class Company implements Account, Serializable {

    String username;
    String password;

    public Company(String username, String password)
    {
        this.password = password;
        this.username = username;
    }
    @Override
    public String getPassword() {

        return password;
    }

    public String getUsername() {

        return username;
    }

}
