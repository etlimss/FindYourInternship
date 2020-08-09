package client.model.modelacc;

import java.io.Serializable;

public class Student implements Account, Serializable {
    String username;
    String password;

    public Student(String username, String password)
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
