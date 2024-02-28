package ShadowsRPG;

public class Prefix {

    public boolean Check (String sentence, String Category)
    {

       sentence = sentence.substring((sentence.indexOf(" ")));




        return (sentence.equalsIgnoreCase(Category));
    }
}
