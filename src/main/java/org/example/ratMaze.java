package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

//what if i remove the first move vs the last move
//idea: remove all moves until it returns to the last point with multiple options...?

public class ratMaze {

    public static int actual = 0;

    public static void setCoord(int[] a, int [] b)
    {
        a[0] = b[0];
        a[1] = b[1];
    }

    public static void backtrack(int[] loc)
    {
        Coord simple = test.lastEntry().getValue();
        while (simple.posCount!=1)
        {
            setCoord(Prev,Loc);
            Map[Loc[0]][Loc[1]] = "_";
            setCoord(Loc,simple.possibleMoves.get(0));
            simple.possibleMoves.remove(0);
            Map[Loc[0]][Loc[1]] = "X";
            if(simple.possibleMoves.isEmpty())
            {
                test.remove(simple);
            }
        }
    }


    public static void backtrackalpha()
    {
        boolean stop = false;
        while (!stop)
        {
            setCoord(Prev,Loc);
            Map[Loc[0]][Loc[1]] = "_";
            setCoord(Loc,allSteps.get(allSteps.size()-1));
            allSteps.remove(allSteps.size()-1);
            Map[Loc[0]][Loc[1]] = "X";
            actual++;

            for(int[] each : fallback)
            {
                stop = Arrays.equals(each,Loc);
                if (stop)
                {
                    setCoord(Prev, (fallback.size()>2) ? fallback.get(fallback.size()-2): Loc );
                    fallback.remove(fallback.size()-1);
                    return;
                }
            }
        }
    }


   public static TreeMap<Integer,Coord> test = new TreeMap<>();

    public static ArrayList<int[]> blacklist = new ArrayList<>();

    public static TreeMap<Integer,int[]> allSteps = new TreeMap<>();


  static int[] Loc = {0,0};
  static int[] Prev = {0,0};

  static int[] target = {9,10};

  static ArrayList<int[]> fallback = new ArrayList<>();

    static String[][] Map = {


            {"X","_","#","#","_","_","_","_","#","_","_"},
            {"_","_","_","#","_","_","_","_","#","_","#"},
            {"_","_","#","#","_","_","_","_","_","_","#"},
            {"#","_","#","_","_","_","#","_","#","_","#"},
            {"_","_","_","_","_","_","#","_","#","#","_"},
            {"_","_","#","#","#","#","#","_","#","_","_"},
            {"_","_","#","_","_","_","_","_","#","_","_"},
            {"#","#","#","_","#","#","#","#","#","#","#"},
            {"_","_","_","_","_","_","#","_","#","_","_"},
            {"_","_","#","_","#","_","_","_","#","_","_"},

    };


    public static void mazeRun()
    {
        test.put(test.size(),new Coord());

        ArrayList<int[]> moves = new ArrayList<>();
        ArrayList<int[]> options = new ArrayList<>();

        for (int i = 0; i < Map.length; i++) {

            for (int j = 0; j < Map[i].length; j++) {
                if (Map[i][j].equalsIgnoreCase("_")) {
                    moves.add(new int[]{i, j});
                }
            }
        }

        for (int[] each : moves)
        {
            int diffX = Loc[1]>each[1] ? Loc[1] - each[1] : each[1] - Loc[1];
            int diffY = Loc[0]>each[0] ? Loc[0] - each[0]: each[0]- Loc[0];
            int difference = Math.max(diffX,diffY);

            boolean banned = false;

            boolean steps = false;

            if(!blacklist.isEmpty())
            {
                for(int[] move : blacklist)
                {
                    banned = Arrays.equals(move,each);
                    if (banned)
                    {
                        break;
                    }
                }
            }

            if(!allSteps.isEmpty())
            {
                for(int[] move : allSteps.values())
                {
                    steps = Arrays.equals(move,each);
                    if (steps)
                    {
                        break;
                    }
                }
            }

            boolean prev = Arrays.equals(each,Prev);


            if (difference==1 && !prev && !banned&&!steps)
            {
                options.add(each);
            }





        }

        if (options.isEmpty())
        {
            blacklist.add(new int[] {Loc[0],Loc[1]});
            backtrackalpha();
            return;
        }

           /* if (options.isEmpty())
            {
                int[] Prev2 = new int[] {Loc[0],Loc[1]};
                Map[Loc[0]][Loc[1]] = "_";
                setCoord(Loc,Prev);
                setCoord(Prev,Prev2);
                Map[Loc[0]][Loc[1]] = "X";

                for (String[] strings : Map) {
                    System.out.println(Arrays.toString(strings));
                }
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println(Loc[0] + " " + Loc[1]);


                return;
            }
*/
         /*  if (options.size()>1)
            {
                boolean contains = false;
                if (!blacklist.isEmpty())
                {

                    for(int[] move : blacklist)
                    {
                        contains = Arrays.equals(move,Loc);
                        if (contains) {
                            break;
                        }
                    }
                }

                if (!contains) {
                    blacklist.add(new int[]{Loc[0], Loc[1]});
                }
            }
*/
           if (options.size()>1)
           {
               fallback.add(new int[] {options.get(0)[0],options.get(0)[1]});
               blacklist.add(new int[] {options.get(0)[0],options.get(0)[1]});
           }

            test.put(test.size(),new Coord());
            Coord simple = test.lastEntry().getValue();
            simple.possibleMoves.addAll(options);
            simple.posCount = simple.possibleMoves.size();
            simple.start = new int[] {Loc[0],Loc[1]};

       // System.out.println("Possible Moves: " + Arrays.toString(new ArrayList[]{test.lastEntry().getValue().possibleMoves}));

        System.out.println("possible moves: " + Arrays.toString(new ArrayList[]{options}));

            setCoord(Prev,Loc);
            Map[Loc[0]][Loc[1]] = "_";
            setCoord(Loc,options.get(0));
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
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(Loc[0] + " " + Loc[1]);

            allSteps.put(allSteps.size(),new int[] {Loc[0],Loc[1]});
            actual++;





    }

    public static void main(String[] args) {
try {
    while (!Arrays.equals(target, Loc)) {
        mazeRun();

    }
}
catch (Exception e)
{
    System.out.println("Unable to access end point.");
    System.exit(0);
}


        System.out.println(allSteps.size() + " steps to get to the end.");

        for(int[] each : allSteps.values())

        {
            System.out.println(each[0] + "," + each[1]);
        }

        System.out.println("Actual Steps: " + actual);
    }
}
