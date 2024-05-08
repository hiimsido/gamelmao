package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;





//next step is having it redo EVERY single possible movement from all the "solved" solutions, however, the caveat being it won't repeat the same movements. I'll have to figure out this part. I'll need to think outside of the box to have it return to each point.

//Before filter, when a route has been completely mapped, backtrack to first point with multiple options.

//Filter out moves, remove a move done, check if it's still possible to reach end with new set of moves, if possible, nuke it from current list.

//IDEA: While backtracking, if it backtracks to a new multi point, remove anything blacklisted regarding multi moves, as a means to allow for trying ALL different possibilities to get to the end.

//How to accomplish this: The first point with multiple options becomes the "save" point, program runs as per normal. Once all possible moves have been exhausted from said save point, return to the save point, and repeat the process. Once out of moves, the save point would be deleted, and it runs the program until it reaches the next save point aka multi point, program repeats.

//add a hashmap to prioritize spots it has not gone too lest it needs to. So two hashmaps, if one is empty, go to the other one which has moves in it.

//use been here to calculate possible moves.

//Maybe unlist any moves with MULTIPLE options which have already been gone through.

//figure out a way to not delete fallbacks if they still have enough moves, so instead of deleting @ fallback, recalc possible moves then delete if only 1 possible move makeable/distance is < 1
public class ratMazeV2 {

    public static void backtrackalpha()
    {
        boolean stop = false;
        while (!stop)
        {
            setCoord(Prev,Loc);
            Map[Loc[0]][Loc[1]] = "_";
            setCoord(Loc, allSteps.get(allSteps.size()-1));

            actual++;


            for(int[] each : fallback)
            {
                stop = Arrays.equals(each,Loc);
                if (stop)
                {
                   // setCoord(Prev, (fallback.size()>2) ? fallback.get(fallback.size()-2): Loc );


                    fallback.remove(fallback.size()-1);
                    return;
                }
            }
            allSteps.remove(allSteps.size()-1);
            Map[Loc[0]][Loc[1]] = "X";

            if (fallback.isEmpty()&&!(allSteps.size()>1))
            {
                allSteps.remove(0);
                return;
            }

        }
    }

    public static int actual = 0;

    public static void setCoord(int @NotNull [] a, int @NotNull [] b)
    {
        a[0] = b[0];
        a[1] = b[1];
    }




   public static TreeMap<Integer,Coord> test = new TreeMap<>();

    public static ArrayList<int[]> blacklist = new ArrayList<>();
    public static ArrayList<int[]> whitelist = new ArrayList<>();
    public static ArrayList<int[]> deadend = new ArrayList<>();
    public static ArrayList<int[]> safe = new ArrayList<>();


    public static TreeMap<Integer,int[]> allSteps = new TreeMap<>();

    public static ArrayList<int[]> beenhere = new ArrayList<>();

    public static TreeMap<Integer, ArrayList<int[]>> Completed = new TreeMap<>();


  static int[] Loc = {0,0};
  static int[] Prev = {0,0};

  static int[] target = {3,6};

  static ArrayList<int[]> fallback = new ArrayList<>();

    static String[][] Map = {


            /*{"X","#","_","_","#","_","_",},
            {"_","_","_","#","_","#","_",},
            {"_","#","#","#","#","#","#",},
            {"_","_","_","_","_","_","_",},*/

            {"X","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_",},
            {"_","_","_","_","_","_","_",},


           /* {"X"},
            {"_","_","_"},
            {"_","_","_","_","_"} */

    };





    public static void mazeRunV2()
    {




        boolean end = false;

        while (!end) {

            ArrayList<int[]> safezone = new ArrayList<>();


            ArrayList<int[]> moves = new ArrayList<>();
            ArrayList<int[]> options = new ArrayList<>();
            TreeMap<Integer,int[]> distance = new TreeMap<>();
            TreeMap<Integer,int[]> distanceTwo = new TreeMap<>();


            for (int i = 0; i < Map.length; i++) {

                for (int j = 0; j < Map[i].length; j++) {
                    if (Map[i][j].equalsIgnoreCase("_")) {
                        moves.add(new int[]{i, j});
                    }
                }
            }

            for (int[] each : moves) {
                int diffX = Loc[1] > each[1] ? Loc[1] - each[1] : each[1] - Loc[1];
                int diffY = Loc[0] > each[0] ? Loc[0] - each[0] : each[0] - Loc[0];
                int difference = Math.max(diffX, diffY);

                boolean banned = false;

                boolean steps = false;

                boolean nomove = false;

                if (!blacklist.isEmpty()) {
                    for (int[] move : blacklist) {
                        banned = Arrays.equals(move, each);
                        if (banned) {
                            break;
                        }
                    }
                }

                if (!deadend.isEmpty()) {
                    for (int[] move : deadend) {
                        nomove = Arrays.equals(move, each);
                        if (nomove) {
                            break;
                        }
                    }
                }

                if (!allSteps.isEmpty()) {
                    for (int[] move : allSteps.values()) {
                        steps = Arrays.equals(move, each);
                        if (steps) {
                            break;
                        }
                    }
                }




                boolean prev = Arrays.equals(each, Prev);


                if (difference == 1 && !prev && !banned && !steps && !nomove) {
                    options.add(each);
                }




            }

            if (options.isEmpty()||Arrays.equals(Loc,target)) {

                if (!Arrays.equals(Loc,target)) {
                    deadend.add(new int[]{Loc[0], Loc[1]});
                }
                backtrackalpha();
                end = allSteps.isEmpty();
                continue;
            }

            else
            {
                for(int[] each : options)
                {
                    int diffX = target[1] > each[1] ? target[1] - each[1] : each[1] - target[1];
                    int diffY = target[0] > each[0] ? target[0] - each[0] : each[0] - target[0];
                    int difference = Math.max(diffX, diffY);

                    if (beenhere.isEmpty()) {
                        distance.put(difference, new int[]{each[0], each[1]});
                    }
                    
                    else {
                        boolean here = false;
                        for (int i = 0; i < beenhere.size() ; i++) {

                        here = Arrays.equals(each,beenhere.get(i));
                            
                        }

                        if (!here)
                        {
                            distance.put(difference, new int[]{each[0], each[1]});
                        }

                        else {
                            distanceTwo.put(difference, new int[]{each[0], each[1]});
                        }
                    }




                }
            }

            for (int i = 0; i < options.size(); i++) {
                options.clear();
            }

            options.addAll(distance.values());
            options.addAll(distanceTwo.values());

            boolean test = false;





            // System.out.println("Possible Moves: " + Arrays.toString(new ArrayList[]{test.lastEntry().getValue().possibleMoves}));

            System.out.println("current location: " + Loc[0] + "," + Loc[1]);

            System.out.println("possible moves: ");
            for(int[] each : options)
            {
                System.out.print(each[0] + "," + each[1] + " ");
            }
            System.out.println();

            setCoord(Prev, Loc);
            Map[Loc[0]][Loc[1]] = "_";
            setCoord(Loc, options.get(0));
            Map[Loc[0]][Loc[1]] = "X";
           /* if (options.size()>1)
            {
                setCoord(Prev,Loc);
            }

            */
            // movedhere.add(new int[]{Loc[0],Loc[1]});

           for (String[] strings : Map) {
                System.out.println(Arrays.toString(strings));
            }

        /*    for (int[] each : allSteps.values())
            {
                emptyMap[each[0]][each[1]] = "A";
            }
*/

           /* for (String[] strings : emptyMap) {
                System.out.println(Arrays.toString(strings));
            }

            */
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(Loc[0] + " " + Loc[1]);

            allSteps.put(allSteps.size(), new int[]{Loc[0], Loc[1]});
            if (distance.size() > 1 && !test) {

                if (!Arrays.equals(Loc,target))
                {
                    fallback.add(new int[] {Loc[0],Loc[1]});
                }


                //fallback.add(new int[]{distance.get(distance.firstKey())[0], distance.get(distance.firstKey())[1]});

                // whitelist.add(new int[]{distance.get(distance.firstKey())[0], distance.get(distance.firstKey())[1]});
                // blacklist.add(new int[] {options.get(0)[0],options.get(0)[1]});
            }

            if (!beenhere.isEmpty())
            { boolean a = true;
                for (int i = 0; i < beenhere.size(); i++) {
                    if (Arrays.equals(beenhere.get(i),Loc))
                    {
                        a = false;
                        break;
                    }
                }
                if (a)
                {
                    beenhere.add(new int[]{Loc[0], Loc[1]});
                }
            }
            else {
              //  if (!Arrays.equals(Loc,target)) {

                //change to prev for both if unable to fix
                    beenhere.add(new int[]{Loc[0], Loc[1]});
              //  }
            }

            actual++;


            if (Arrays.equals(Loc, target)) {


                Completed.put(allSteps.size(),new ArrayList<>(allSteps.values()));
                for(int[] each : allSteps.values())
                {
                    safe.add(new int[] {each[0],each[1]});

                }

                for (Integer key : Completed.keySet())
                {
                    System.out.println("Key: " + key);
                    for (int[] each: Completed.get(key))
                    {
                        System.out.println(each[0] + "," + each[1]);
                    }
                }


                //work in progress



            }

            end = allSteps.isEmpty();


        }
    }


    public static void filter()
    {

    }

    public static void main(String[] args) {

        /*try {
    while (!Arrays.equals(target, Loc)) {
        mazeRun();

    }
}
catch (Exception e)
{
    System.out.println("Unable to access end point.");
    System.exit(0);
}
*/
        {
    mazeRunV2();
}


        {
            System.out.println("Program ended early.");
        }

        //System.out.println(allSteps.size() + " steps to get to the end.");
try {
    System.out.println("Variation in steps: " + Completed.size());

    System.out.println("Best sequence to reach end: " + Completed.firstKey());
    System.out.println("Worst sequence to reach end: " + Completed.lastKey());
    for (Integer key : Completed.keySet())
    {
        System.out.println("Key: " + key);
        for (int[] each: Completed.get(key))
        {
            System.out.println(each[0] + "," + each[1]);
        }
    }

    System.out.println("Actual Steps: to finish program: " + actual);
}
        catch(Exception e)
        {
            System.out.println("Error. Unable to reach end.");
        }
    }
}
