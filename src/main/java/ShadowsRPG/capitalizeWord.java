package ShadowsRPG;

public class capitalizeWord {

    public static String capItem(String input)
    {
        if (input.length() == 0)
        {
            return null;
        }

        StringBuilder string = new StringBuilder(input);
        String firstLetter = String.valueOf(input.charAt(0)).toUpperCase();
        input = input.trim();
        string.setCharAt(0,firstLetter.charAt(0));


        for (int i = 0; i < input.length() ; i++) {

            if (input.charAt(i) == ' ')
            {
                String letter = String.valueOf(input.charAt(i+1)).toUpperCase();
                string.setCharAt(i+1,letter.charAt(0));
            }

            input = string.toString();


        }

        return input;
    }

    public static void main(String[] args) {


        System.out.println(capItem("hello, this be a test! 2"));

    }
}
