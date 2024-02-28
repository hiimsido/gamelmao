package org.example;

import java.util.TreeSet;

public class testConversion {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {


            int loopVal = 0;
            int[] prevPos = {0, 1};
            int up = -1;
            int right = 1;
            int left = -1;
            int down = 1;
            TreeSet<String> possibilities = new TreeSet();
            possibilities.add(up + "," + 0);
            possibilities.add(0 + "," + right);
            possibilities.add(down + "," + 0);
            possibilities.add(0 + "," + left);

            //filters out any movements deemed impossible and the previous position
            possibilities.remove("0,0");
            possibilities.remove(prevPos[0] + "," + prevPos[1]);

            int RNG = (int) (Math.random() * possibilities.size());
            System.out.println(possibilities);
            for (String each : possibilities
            ) {

                if (RNG == loopVal) {
                    int splitThis = each.indexOf(",");
                    int coordinateX = Integer.parseInt(each.substring(0, splitThis));
                    int coordinateY = Integer.parseInt(each.substring(1+splitThis));

                    System.out.println(coordinateX + "," + coordinateY);
                    break;
                }
                loopVal = loopVal + 1;
            }
        }
    }
}