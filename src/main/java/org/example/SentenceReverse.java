package org.example;

import java.util.ArrayList;

public class SentenceReverse {

    public static String reversal(String result)
    {
        ArrayList <String> returnReversedString =  new ArrayList<>();

        if (result.length() >0) {
            String returnValue = "";
            String[] test = result.split(" ");

            for (int i = 0; i < test.length ; i++) {
                StringBuilder placeholder = new StringBuilder();
                String word = test[i];

                for (int b = word.length(); b > 0; b--) {
                    placeholder.append(word.charAt(b-1));


                }
              /*  returnReversedString.add(placeholder.toString());*/

                returnValue = returnValue + placeholder + " ";

            }

           /* for (String each:
                    returnReversedString) {
                returnValue = returnValue + each + " ";

            }*/

            return returnValue.trim();
        }


        return null;
    }


    public static void main(String[] args) {

        System.out.println(SentenceReverse.reversal("This be a test string"));

    }
}
