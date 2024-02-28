package org.example;

import java.util.Scanner;

class endBracket {

    public static boolean closingStatement (String input)
    {

        for (int i = 0; i < input.length(); i++) {

            String singleChar = input.substring(i,i+1);


            if (singleChar.equals("("))
            {
                String secondChar = input.substring(i+1,i+2);
                if (secondChar.equals(")"))
                {
                    continue;
                }
                return false;
            }


            if (singleChar.equals("["))
            {
                String secondChar = input.substring(i+1,i+2);
                if (secondChar.equals("]"))
                {
                    continue;
                }
                return false;
            }


            if (singleChar.equals("{"))
            {
                String secondChar = input.substring(i+1,i+2);
                if (secondChar.equals("}"))
                {
                    continue;
                }
                return false;
            }



        }
        return true;

    }



}


public class parenthesis {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        String Checkzor = input.nextLine();


        System.out.println(endBracket.closingStatement(Checkzor));



    }
}
