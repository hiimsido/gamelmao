package ShadowsRPG.maps;

import ShadowsRPG.enemyStatCheck;

import java.util.*;

public class CombatMapC {



public static void mapDisplay()
    {
        System.out.println("- - - Displaying Map - - -\n");
        for (String[] strings : combatMap) {
            System.out.println(Arrays.toString(strings));
        }
        System.out.println();

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

    public static void mapPurge()
    {
        System.out.println("Combat is over. Purging map.");
        for (String[] map: combatMap
             ) {
            Arrays.fill(map, "_");

        }
        mapDisplay();
    }


    //make a randomize position around a few tiles of enemy position
    //make a forced spawn spot for certain boss fights
    public static int[] mapRandomizePosition()
    {
        LinkedHashMap<Integer,int[]> startPosition = new LinkedHashMap<>();
        int newY = 0;
        for (String[] map: combatMap
             ) {
            for (int i = 0; i < map.length; i++) {
                if (map[i].equalsIgnoreCase("_"))
                {
                    startPosition.put(startPosition.size(), new int[] {newY,i});
                }
            }
            newY = newY + 1;

        }

            int[] position = startPosition.get((int)(Math.random()* startPosition.size()));

        combatMap[position[0]][position[1]] = "P";

        return position;
    }

    public static void mapRandomizeObstacle(int count)
    {
        for (int j = 0; j < count + 1; j++) {


            LinkedHashMap<Integer, int[]> startPosition = new LinkedHashMap<>();
            int newY = 0;
            int X = 0;
            int Y = 0;
            for (String[] map : combatMap
            ) {
                for (int i = 0; i < map.length; i++) {
                    if (map[i].equalsIgnoreCase("_")) {
                        startPosition.put(startPosition.size(), new int[]{i, newY});
                    }
                }
                newY = newY + 1;

            }

            int randomize = (int) (Math.random() * startPosition.size());

          X =  startPosition.get(randomize)[1];
          Y =  startPosition.get(randomize)[0];
          combatMap[Y][X] = "[X]";
        }

    }

    public static void mapInitiate()
    {
        boolean mapCheck = true;
        for (String[] map: combatMap)
        {
            for (int i = 0; i < map.length; i++) {
                mapCheck = (map[i].equalsIgnoreCase("_") );
            }

            if (!mapCheck)
            {
                mapPurge();
            }






        }
    }
   public static String[][] combatMap = {

            {"_","_","_","_","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_","_","_","_",},






    };

public static void randomizeMap()
{
    int length = (int)(Math.random()*5) + 5;
    int height = (int)(Math.random()*5) + 5;

    ArrayList <String> x = new ArrayList<>();

    for (int i = 0; i<length; i++) {
        x.add("_");
    }

    ArrayList<String[]> y = new ArrayList<>();

    for (int i = 0; i < height; i++) {
        String [] test = x.toArray(new String[0]);
        if (!x.isEmpty())
        {
        y.add( x.toArray(new String[0]));
        }

    }
    combatMap = y.toArray(new String[0][0]);

}







    public static String StringConversion(ArrayList<int[]> a) {
        final StringBuffer sb = new StringBuffer();

       int i = 0;

        for (int[] b: a
             ) {

            if(i!=b[0]) {
                i = b[0];
                System.out.println(sb);
                sb.delete(0,sb.length());

            }

            sb.append(Arrays.toString(b)).append(", ");


        }
        return sb.toString();
    }

    public static String StringConversion(int[] a) {
        final StringBuffer sb = new StringBuffer();



        sb.append(a[0]).append(",").append(a[1]);




        return sb.toString();
    }

    //consider constructing a starting map if no map is present/beginning to initialize positions
  public static int[] playermapStart(int agility, String status, int[] start) {


        //have old positions, new positions, and create different AIs (run, chase, stay in range, etc)
        //add diag movements. And potentially use math max/min to limit movement options.
        // look at potentially scanning the whole area to determine your move choices and or beside you.
        // figure out algorithm to scan around you via distance, check's the coordinates then looks at the coordinates within the spawn hashmap :)
        // make this return a value/consider making a method for returning stuff on the map
        //constructor: A. Coordinates. B. Icon of Enemy. C. Return new coordinates (delete old position, and add new position) D. Eventually add AI based on weapon choice/Create AI behaviors for different enemies. E. Agility level
      //create scythe algorithm


        int movementTurn = Math.max(1,agility/100);
        int X = start[1];
        int Y = start[0];

     /* int[] Z = mapRandomizePosition();
      combatMap[Z[0]][Z[1]] = "E";

      */

      mapDisplay();



      //  mapDisplay();

       // combatMap[6][5] = "P";
       // combatMap[6][6] = "_";





            int y = 0;
            ArrayList<int[]> possibleMoves = new ArrayList();
            for (String[] each: combatMap
                 ) {




                for (int x = 0; x < each.length; x++) {
                    int diffX = X>x ? X - x : x - X ;
                    int diffY = Y>y ? Y - y: y - Y;
                    boolean dist = (diffX<=movementTurn)&&(diffY<=movementTurn);
                     if (combatMap[y][x].equalsIgnoreCase("_")&&dist)
                     {
                        possibleMoves.add(new int[] {y,x});
                     }


                }

                y = y + 1;
            }


            if (possibleMoves.size() == 0)
            {
                System.out.println("Unable to move.");
                return start;
            }


            boolean yourMove = false;

            while (!yourMove)
            {
                String choice = "";
              //  System.out.println("You can move a max of " + movementTurn + " tiles\n");
                System.out.println("- - - Possible moves - - -\n");
                System.out.println("Your current position: " + Y + "," + X);
                System.out.println(StringConversion(possibleMoves) + "\n\n- - - - - - - - \n\nType two numbers for where you'd like to move (like " + Arrays.toString(possibleMoves.get(0)) + ")\n");

                System.out.println("- - - Alternative Options - - -\n");
                System.out.println("Map: Redisplay the map.");
                //eventually have a buff/use items option which uses your turn, aka return boolean
                System.out.println("Items: Use an item (NOT DONE YET)");
                System.out.println("Examine: Examine enemy stats/positions.");
                System.out.println("Stay: Don't move.\n");


                int[] moveTo = {};
               try {
                   choice = new Scanner(System.in).nextLine();

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
                    if (choice.equalsIgnoreCase("")) {
                        choice = "stay";
                        System.out.println("You decide to stay put.");
                        return new int[] {Y,X};
                    }

                    else {
                        moveTo = stringtocoord(choice);
                    }

               }
               catch (Exception e)
               {
                   System.out.println("ERROR: Int required. Try again");
               }


                       yourMove = new Coordinates().coordCheckB(moveTo, possibleMoves);






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
                    if ((moveTo[0] == start[0] && moveTo[1] == start[1])||choice.trim().equalsIgnoreCase("stay")||choice.length()==0)
                    {
                        System.out.println("You decide to stay put.\n");
                        return new int[] {Y,X};
                    }

                    if (choice.trim().equalsIgnoreCase("map"))
                    {
                        System.out.println("You view the map once more.\n");
                        mapDisplay();
                    }

                    else if(choice.trim().equalsIgnoreCase("examine"))
                    {
                        enemyStatCheck.getStats();
                }



                    else {
                        System.out.println("Error: Please type your answer again.\n");
                    }
                }

                else {
//consider making an object that has a way to SET the x and y instead of needing 2 values
                    combatMap[Y][X] = "_";
                    X = moveTo[1];
                    Y = moveTo[0];
                    combatMap[Y][X] = "P";
                }
            }

            mapDisplay();
      return new int[] {Y,X};

            //HashMap<Integer,Integer> move = new HashMap<>();





        }










    public static void main(String[] args) {
      int[] test = mapRandomizePosition();
      //for obstacles make sure it doesnt spawn beside enemies/players or just have it spawn at a maximum 2 tiles away from other obstacles aka X letter objects.
        // mapRandomizeObstacle(3);

        for (int i = 0; i < 20; i++) {

            test = playermapStart(100, "none", test);
        }
        System.out.println();
    }


}
