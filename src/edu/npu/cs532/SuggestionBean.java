
package edu.npu.cs532;

import java.io.*;

public class SuggestionBean implements Serializable {

    private String name;
    private String password;

    public SuggestionBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return (name);
    }

    public String getPassword() {
        return (password);
    }
}
