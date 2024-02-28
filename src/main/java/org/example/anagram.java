package org.example;

public class anagram {

   public static boolean anagramSeeker (String a, String b)
    {
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        if (a.length()!=b.length())
        {return false;}


        for (int i = 0; i < a.length(); i++) {
            char letterCheck = a.charAt(i);
            String letterCheckB = String.valueOf(letterCheck);

            if (!b.contains(letterCheckB))
            {
                return false;
            }

            else

            {

                b = b.replaceFirst(letterCheckB,"");
            }

        }



        return true;
    }

    public static void main(String[] args) {

        System.out.println(anagramSeeker("rat", "car"));

    }
}
