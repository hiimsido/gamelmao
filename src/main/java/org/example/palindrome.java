package org.example;

public class palindrome {

    public static Boolean test(String Input)
    {
        Input = Input.replaceAll(
                "[^a-zA-Z0-9]", "");
        Input = Input.toLowerCase();

        String backwards = "";

        for (int i = Input.length() - 1; i>-1 ; i--) {
            backwards = backwards + Input.charAt(i);
        }

        return (Input.equals(backwards));


    }

    public static void main(String[] args) {
        System.out.println(test("A man, a plan, a canal: Panama"));
    }

}
