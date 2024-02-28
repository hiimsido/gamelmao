package ShadowsRPG.maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CombatMap {
    public static Coordinates compare(String c)
    {
        if (c.length()==3) {
            int X = Integer.parseInt(c.substring(0, 1));
            int Y = Integer.parseInt(c.substring(2,2));

            return new Coordinates(X,Y);
        }

        return null;
    }


public static void mapDisplay()
    {
        System.out.println("- - - Displaying Map - - -\n");
        for(String[] each : combatMap)
        {
            System.out.println(Arrays.deepToString(each));
        }

        System.out.println();
    }
   public static String[][] combatMap = {

            {"0","0","0","0","0","0","0","0","0","0",},
            {"0","0","0","0","0","0","0","0","0","0",},
            {"0","0","0","0","0","0","0","0","0","0",},
            {"0","0","0","0","0","0","0","0","0","0",},
            {"0","0","0","0","0","0","0","0","0","0",},
            {"0","0","0","0","0","0","0","0","0","0",},
            {"0","0","0","0","0","0","0","0","0","0",},
           {"0","0","0","0","0","0","0","0","0","0",},
           {"0","0","0","0","0","0","0","0","0","0",},
           {"0","0","0","0","0","0","0","0","0","0",},
           {"0","0","0","0","0","0","0","0","0","0",},

         /*  {"0","0","0","0","0","0","0",},
           {"0","0","0","0","0","0","0",},
           {"0","0","0","0","0","0","0",},
           {"0","0","0","0","0","0","0",},
           {"0","0","0","0","0","0","0",},
           {"0","0","0","0","0","0","0",},
           {"0","0","0","0","0","0","0",},


          */



    };




    public static void main(String[] args) {


        //have old positions, new positions, and create different AIs (run, chase, stay in range, etc)
        //add diag movements. And potentially use math max/min to limit movement options.
        // look at potentially scanning the whole area to determine your move choices and or beside you.
        // figure out algorithm to scan around you via distance, check's the coordinates then looks at the coordinates within the spawn hashmap :)
        // make this return a value/consider making a method for returning stuff on the map
        //constructor: A. Coordinates. B. Icon of Enemy. C. Return new coordinates (delete old position, and add new position) D. Eventually add AI based on weapon choice/Create AI behaviors for different enemies. E. Agility level
        int movementTurn = 1;
        int X = 6;
        int Y = 6;
      combatMap[X][Y] = "P";
      combatMap[0][0] = "E";



      //  mapDisplay();

       // combatMap[6][5] = "P";
       // combatMap[6][6] = "0";




        for (int i = 0; i < 10 ; i++) {
            int x = 0;
            ArrayList<Coordinates> possibleMoves = new ArrayList();
            for (String[] each: combatMap
                 ) {




                for (int y = 0; y < each.length; y++) {
                    int diffX = X>x ? X - x : x - X ;
                    int diffY = Y>y ? Y - y: y - Y;
                    boolean dist = (diffX<=movementTurn)&&(diffY<=movementTurn);
                     if (combatMap[x][y].equalsIgnoreCase("0")&&dist)
                     {
                        possibleMoves.add(new Coordinates(x,y));
                     }


                }

                x = x + 1;
            }




            boolean yourMove = false;

            while (!yourMove)
            {
                System.out.println("Possible moves: " + possibleMoves + "\n- - - \nPick a location from the possible moves.\n" );

                System.out.println("Or type STAY if you wish to not move.\n");
                String moveHere = new Scanner(System.in).nextLine().trim();

               yourMove = new Coordinates().coordCheck(moveHere,possibleMoves);

                /*for (Coordinates each: possibleMoves
                     ) {
                    yourMove = each.getCoord().equals(moveHere);
                    if (yourMove)
                    {
                        break;
                    }
                }

                 */



                if (!yourMove)
                {
                    if (moveHere.equalsIgnoreCase("stay"))
                    {
                        System.out.println("You decide to stay put.\n");
                        break;
                    }

                    if (moveHere.equalsIgnoreCase("map"))
                    {
                        System.out.println("You view the map once more.\n");
                        mapDisplay();
                    }
                    else {
                        System.out.println("Error: Please type your answer again.\n");
                    }
                }

                else {

                    combatMap[X][Y] = "0";
                    X = Integer.parseInt(moveHere.substring(0,1));
                    Y = Integer.parseInt(moveHere.substring(2));
                    combatMap[X][Y] = "P";
                }
            }


           mapDisplay();

            //HashMap<Integer,Integer> move = new HashMap<>();





        }






    }
}
