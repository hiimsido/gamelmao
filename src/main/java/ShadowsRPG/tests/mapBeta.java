package ShadowsRPG.tests;

import ShadowsRPG.maps.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class mapBeta {

    public boolean coordCheck (String c, ArrayList<Coordinates> b)
    {
        for (Coordinates each: b
        ) {

            boolean truth = (c.equals(each.getCoord()));
            if (truth) {
                return true;
            }
        }
        return false;
    }

    public static boolean coordCheckB (int[] a, ArrayList<int[]> b)
    {
        for (int[] each: b
        ) {

            boolean truth = (a[0]==each[0]&&a[1]==each[1]);
            if (truth) {
                return true;
            }
        }
        return false;
    }


    public static int[] stringtocoord(String a) {
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        ArrayList<Integer> intHolder = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            intHolder.add(ints[i]);
        }

        int[] coords = {0, 0};
        for (int j = 0; j < 2; j++) {


            for (int i = 0; i < a.length(); i++) {

                try {
                    int converter = Integer.parseInt(String.valueOf(a.charAt(i)));
                    if (intHolder.contains(converter)) {
                        coords[j] = converter;
                        a = String.valueOf(new StringBuilder(a).deleteCharAt(i));
                        break;

                    }
                } catch (Exception e) {

                }
            }



        }
        return coords;
    }



    public static String StringConversion(ArrayList<int[]> a) {
        final StringBuffer sb = new StringBuffer();

        for (int[] b: a
        ) {

            sb.append(Arrays.toString(b)).append(", ");
        }
        return sb.toString();
    }

    public static String StringConversion(int[] a) {
        final StringBuffer sb = new StringBuffer();



        sb.append(a[1]).append(",").append(a[0]);




        return sb.toString();
    }
    public static void mapDisplay()
    {

        for (int i = 0; i < map.length; i++) {

            System.out.println(Arrays.toString(map[i]));
        }

    }
    
    public static String[][] map =


            {

                    {"0","0","0","0","0","0","0",},
                    {"0","0","0","0","0","0","0",},
                    {"0","0","0","0","0","0","0",},
                    {"0","0","0","0","0","0","0",},
                    {"0","0","0","0","0","0","0",},

            };

    public static void main(String[] args) {

        ArrayList<int[]> possibilities = new ArrayList<>();

        int moveLimit = 1;

        int Y = 2;
        int X = 4;





        map[Y][X] = "D";
        mapDisplay();

        System.out.println("Current Position: " + X + "," + Y);

        //the Y
        for (int i = 0; i < map.length; i++) {

            int diffY = Y > i ? Y - i : i - Y;

            if (moveLimit<diffY)
            {
                continue;
            }
//the X
            for (int j = 0; j < map[i].length; j++) {

                int diffX = X > j ? X - j : j - X;

                if (moveLimit<diffX)
                {
                    continue;
                }

                if (map[i][j].equalsIgnoreCase("0"))
                {
                    possibilities.add(new int[] {i,j});
                }
            }
        }

        System.out.println("Possible locations: " + "\n" + StringConversion(possibilities));

        boolean truth = false;

        int[] coordinates = {};

        while (!truth) {

            try {
                String choice = new Scanner(System.in).nextLine();

                  /* switch(choice.toLowerCase().trim()){
                       case "stay":
                           System.out.println("You decide to stay put.\n");
                           yourMove = true;
                          break;
                       case "map":
                           mapDisplay();
                           break;
                   }

                   */

                coordinates = stringtocoord(choice);

            } catch (Exception e) {
                System.out.println("ERROR: Int required. Try again");
            }

            truth = coordCheckB(coordinates,possibilities);
        }




map[Y][X] = "0";
map[coordinates[0]][coordinates[1]] = "D";



            mapDisplay();








    }
            
            
}
