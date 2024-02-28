package ShadowsRPG.maps;

import ShadowsRPG.hashMapAtIndex;

import java.util.*;

public class enemyMovement extends CombatMapC {

    int[] player = {0,1};



    static void enemymapStart(int agility, String status, int[] start, String AI, int DIST) {

//add a name field in the constructor

        int movementTurn = Math.max(1,agility/100);
       // int X = start[0];
      //  int Y = start[1];

        int X = 0;
        int Y = 0;

        combatMap[X][Y] = "E";

        int[] Z = mapRandomizePosition();
        //combatMap[Z[0]][Z[1]] = "P";

        combatMap[6][6] = "P";
        mapDisplay();



        //  mapDisplay();

        // combatMap[6][5] = "P";
        // combatMap[6][6] = "0";




        for (int i = 0; i < 10 ; i++) {
            int y = 0;

            ArrayList<int[]> possibleMoves = new ArrayList();
            for (String[] each: combatMap
            ) {



//calculates possible moves
                //need to calculate which move closes distance the most (FOR AGGRESSIVE AI) probably via hashmap.
                for (int x = 0; x < each.length; x++) {
                    int diffX = X>x ? X - x : x - X ;
                    int diffY = Y>y ? Y - y: y - Y;
                    boolean dist = (diffX<=movementTurn)&&(diffY<=movementTurn);
                    if (combatMap[x][y].equalsIgnoreCase("0")&&dist)
                    {
                        possibleMoves.add(new int[] {x,y});
                    }


                }

                y = y + 1;
            }

            TreeSet<Integer> difference = new TreeSet<>();
            HashMap<int[],Integer> possibleChoices = new HashMap<>();
            if (AI.equalsIgnoreCase("MELEE"))
            {
                for (int[] each: possibleMoves
                     ) {

                   // int diffX = Z[0]>each[0] ? Z[0] - each[0] : each[0] - Z[0] ;
                   // int diffY = Z[1]>each[1] ? Z[1] - each[1]: each[1]- Z[1];

                    int diffX = 6>each[0] ? 6 - each[0] : each[0] - 6 ;
                    int diffY = 6>each[1] ? 6 - each[1]: each[1]- 6;

                    int dif = Math.max(diffX, diffY);
                    difference.add(dif);
                    possibleChoices.put(each,dif);

                    //figure out how to remove elements









                    
                }
                Iterator<Map.Entry<int[],Integer>> iterator = possibleChoices.entrySet().iterator();

                while (iterator.hasNext())
                {
                    Map.Entry<int[],Integer>
                            entry = iterator.next();
                    System.out.println(difference);
                    if (!difference.first().equals(entry.getValue()))
                    {
                        iterator.remove();
                    }
                }

                int index = (int)(Math.random()*possibleChoices.size());

                combatMap[X][Y] = "0";
                X = hashMapAtIndex.atIndex(index,possibleChoices)[0];
                Y = hashMapAtIndex.atIndex(index,possibleChoices)[0];
                combatMap[X][Y] = "E";
            }

        /*    {





                boolean yourMove = false;



//consider making an object that has a way to SET the x and y instead of needing 2 values
                    combatMap[X][Y] = "0";
                    X = moveTo[0];
                    Y = moveTo[1];
                    combatMap[X][Y] = "P";
                }


            }*/

            mapDisplay();

            //HashMap<Integer,Integer> move = new HashMap<>();





        }






    }

    public static void main(String[] args) {

        enemymapStart(100, "none", CombatMapC.mapRandomizePosition(),"MELEE",0 );
    }
}
