package org.example;

public class equalsTest {

    void testRun(){
        int b = 2;
        int a = b;
        int i = 0;

        while (i<3) {
            a = b;
            a = 2;
            b = b * 2;
            System.out.println(a);
            i++;
        }
    }

    public static void main(String[] args) {
       equalsTest practice = new equalsTest();

       practice.testRun();
    }
}
