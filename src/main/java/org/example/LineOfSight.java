package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.TreeMap;

//ideas to solve problem: map all tiles you move to. If
//if unable to reach destination, run back to next position with multiple movement options.
//have several hashmaps, one logs movements, another logs single choice movements, while the others log multi choice. Once all choices have been "used" with no success, it goes back to the next
//make a new class that stores the coordinate, the options where you can move, and a way to confirm if you've been down that spot already.

//when we reach a split point, save all points we've gone through thus far.

//run a function that goes backwards till it finds a move with more then 1 available possibile movement

//idea: A. add current position + the different possible positions you can move from x spot. If all options emptied, backtrack by 1 and then run all possible movements, not including previous movement. Repeat

//to see which of the multiple options are the best, maybe doing something like creating an instance per movement might be the play...?

//figure out why the treemap no worky, and establish a new method to blacklist moves





public class LineOfSight{

    static ArrayList<int[]> donemoves = new ArrayList<>();
    static TreeMap <Integer,int[]> storedmoves = new TreeMap<>();



    public class Coordinate{
        int coord;
        TreeMap<Integer,Coord> possibleMoves = new TreeMap<>();

        public int Choices()
        {
            return possibleMoves.size();
        }

        public void removeCoord()
        {
            possibleMoves.remove(possibleMoves.lastEntry());
        }

    }

    public static void setCoord(int [] a, int[] b)
    {
        a[1] = b[1];
        a[0] = b[0];
    }

    public static class Coord{

        TreeMap<int[], ArrayList<int[]>> Location = new TreeMap<>();

       public int[] prev = {0,0};
       public int[] current = {0,0};

       public ArrayList<int[]> moves = new ArrayList<>();


        public int[] getLocation() {
            return Location.lastKey();
        }



        public void remove() {
            Location.remove(Location.lastKey());
        }

    }

    static int moveCount = 0;

    static String[][] Map = {


            {"X","_","_","_","_","_",},
            {"_","#","_","#","#","_",},
            {"_","#","_","#","#","_",},
            {"_","#","_","#","#","_",},
            {"_","#","_","#","#","_",},
            {"_","#","_","#","#","_",},
            {"_","_","_","#","#","_",},


    };


    public static int[] newTarget (int[] start, int[] end, ArrayList <int[]> blocked)
    {

        ArrayList<int[]> list = new ArrayList<>();




        return new int [] {0,0};
    }

    public static class Guy{

        String guy = "X";
       static int[] Coord = {0,0};
       static int[] prev = {0,0};

        public String getGuy() {
            return guy;
        }

        public static int[] getCoord() {
            return Coord;
        }

        public static int[] getprevCoord() {
            return prev;
        }

        public static void setCoord(int[] coord) {
            Coord = coord;
        }
        public static void setPrevCoord(int[] coord) {
            prev = coord;
        }
    }


    public static void move(){


       int[] Loc = Guy.getCoord();

        ArrayList<int[]> moves = new ArrayList<>();


        for (int i = 0; i < Map.length; i++) {

            for (int j = 0; j < Map[i].length; j++) {
                if (Map[i][j].equalsIgnoreCase("_"))
                {
                    moves.add(new int[] {i,j});
                }
            }

        }




        //how to calculate line of sight. xddd



       int X = Loc[0];
       int Y = Loc[1];

       int endX = 5;
       int endY = 6;

       int[] end = {endX,endY};

      // LinkedHashMap<int[],Integer> endDif = new LinkedHashMap<>();
       // TreeSet<Integer> differences = new TreeSet<>();

        LinkedHashMap<Integer,int[]> move = new LinkedHashMap<>();

        for (int[] each: moves)
        {
            int diffX = Loc[1]>each[1] ? Loc[1] - each[1] : each[1] - Loc[1];
            int diffY = Loc[0]>each[0] ? Loc[0] - each[0]: each[0]- Loc[0];
            int difference = Math.max(diffX,diffY);


            boolean equal = false;
            if (donemoves.size()>0)
            {
                for (int[] x : donemoves) {

                    equal = each[0]==x[0]&&each[1]==x[1];


                }
            }



            if (difference!=1||(equal))
            {
                continue;
            }



            move.put(move.size(),each);
            //endDif.put(each,difference);
            //differences.add(difference);

        }

        if (move.isEmpty())
        {
            move.put(0,Guy.getprevCoord());
            donemoves.remove(Guy.getprevCoord());
        }

       int get = (int) ((Math.random()*move.size()));

        Map[Loc[0]][Loc[1]] = "_";
        Guy.setPrevCoord(new int[] {Loc[0],Loc[1]});
        donemoves.add(Guy.getprevCoord());
        storedmoves.put(storedmoves.size(),new int[] {Loc[0],Loc[1]});
        int[] newcoord = {move.get(get)[0],move.get(get)[1]};
        Loc[0] = newcoord[0];
        Loc[1] = newcoord[1];
        Guy.setCoord(Loc);
        Map[Loc[0]][Loc[1]] = "X";
        for (String[] strings : Map) {
            System.out.println(Arrays.toString(strings));
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        moveCount++;



/*if(Loc[0]!=endX&&Loc[1]!=endY)
{
    move();
}
*/






      // Guy.setCoord(new int[] {X,Y} );



    }

    public static void moveAlpha()
    {
        int[] Loc = Guy.getCoord();

        int[] prev = Guy.getprevCoord();

        ArrayList<int[]> blacklist = new ArrayList<>();
        ArrayList<int[]> washere = new ArrayList<>();

        ArrayList<int[]> moves = new ArrayList<>();
        TreeMap<Integer,Coord> moveTracker = new TreeMap<>();


        for (int i = 0; i < Map.length; i++) {

            for (int j = 0; j < Map[i].length; j++) {
                if (Map[i][j].equalsIgnoreCase("_"))
                {
                    moves.add(new int[] {i,j});
                }
            }

        }

        while (!(Guy.getCoord()[1]==5 && Guy.getCoord()[0]==6)) {
            ArrayList<int[]> test = new ArrayList<>();

            for (int[] each : moves) {
                int diffX = Loc[1] > each[1] ? Loc[1] - each[1] : each[1] - Loc[1];
                int diffY = Loc[0] > each[0] ? Loc[0] - each[0] : each[0] - Loc[0];
                int difference = Math.max(diffX, diffY);

                boolean blacklisted = false;
                boolean here = false;

              /*  if (!blacklist.isEmpty())
                {
                    for (int[] cord : blacklist)
                    {
                        if (Arrays.equals(cord,each)){
                            blacklisted = true;
                            break;
                        }
                    }
                }

                if (!washere.isEmpty())
                {
                    for (int[] cord : blacklist)
                    {
                        if (Arrays.equals(cord,each)){
                            here = true;
                            break;
                        }
                    }
                }
*/
                if (!(Arrays.equals(each,Loc)) && difference == 1 && !(Arrays.equals(each,prev))&&!blacklisted&&!here) {
                    test.add(each);
                }
            }

            Coord hi = new Coord();
            boolean truth = false;

            if (!moveTracker.isEmpty())
            {
                for( Coord hello : moveTracker.values()) {

                    for (int[] each : hello.moves) {
                        truth = Arrays.equals(each, Loc);
                    }

                }
            }

            if (!truth) {
                moveTracker.put(moveTracker.size(), hi);

                setCoord(hi.prev, prev);
                setCoord(hi.current, Loc);
                hi.moves = test;
            }

            Map[Loc[0]][Loc[1]] = "_";
            Coord testerino = moveTracker.lastEntry().getValue();

            if (!testerino.moves.isEmpty()) {
                setCoord(Guy.prev,Loc);
                washere.add(new int[] {Loc[0],Loc[1]});
                setCoord(Loc,hi.moves.get(0));
                setCoord(Guy.Coord,Loc);
                hi.moves.remove(hi.moves.get(0));
                Map[Loc[0]][Loc[1]] = "X";

            }
            //backtrack
         /*   else {
                while (testerino.moves.isEmpty()) {
                    Map[Loc[0]][Loc[1]] = "_";
                    blacklist.add(new int[]{Loc[0], Loc[1]});
                    moveTracker.remove(moveTracker.lastKey());
                    setCoord(Loc, moveTracker.lastEntry().getValue().current);
                    Map[Loc[0]][Loc[1]] = "X";
                    testerino = moveTracker.lastEntry().getValue();

                    System.out.println("BACKTRACKING");
                    for (String[] strings : Map) {
                        System.out.println(Arrays.toString(strings));
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println(Loc[0] + " " + Loc[1]);
                }

            }

          */

            for (String[] strings : Map) {
                System.out.println(Arrays.toString(strings));
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(Loc[0] + " " + Loc[1]);

        }




    }


    public static void main(String[] args) {


        moveAlpha();


        System.out.println("totalmoves: " + moveCount);
    }


}
