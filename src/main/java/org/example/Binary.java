package org.example;

public class Binary {

    public static int BinaryMerge (int[] A, int B)
    {
         int locateNumber = -1;



            for (int i = 0; i < A.length; i++) {
                if (B == A[i])
                {
                    locateNumber = i;
                    break;
                }
            }


        return locateNumber;
    }


    public static void main(String[] args) {

        int[] Array = {-1,0,3,5,9,12};

        System.out.println(BinaryMerge(Array, 3));

    }
}
