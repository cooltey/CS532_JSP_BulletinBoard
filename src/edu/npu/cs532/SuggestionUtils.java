
package edu.npu.cs532;

public class SuggestionUtils {

    private static String[] suggestedName
            = {"cs532"};
    private static String chars
            = "abcdefghijklmnopqrstuvwxyz0123456789#@$%^&*?!";

    public static SuggestionBean getSuggestionBean() {
        String name = "cs532";
        String password = "cs532";
        return (new SuggestionBean(name, password));
    }

}
