package ShadowsRPG.maps;

import ShadowsRPG.EnemyStats;
import ShadowsRPG.Player;
import ShadowsRPG.enemySpawner;
import ShadowsRPG.hashMapAtIndex;


import java.util.*;

public class enemyMovementBeta extends CombatMapC {

    public static String enemyInitials(String enemyName)
    {
        boolean initial = true;

        StringBuilder makeName = new StringBuilder();

        for (int i = 0; i < enemyName.length(); i++) {

            if (initial)
            {
                initial = false;
                makeName.append(enemyName.charAt(i));
                continue;
            }

            if (Character.toString(enemyName.charAt(i)).equals(" ")){
                initial = true;
            }


        }

        return makeName.toString();
    }
    

    //consider changing how it reads position by making int = player position.
    public static int[] mapRandomizePosition(String name)
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

        combatMap[position[0]][position[1]] = enemyInitials(name);

        return position;
    }

     public static int[] enemymapStart(int agility, String status, int[] start, String AI, int DIST, String name, Player player, EnemyStats E) {

        if (AI.equalsIgnoreCase("ALLY"))

        {
            AI = enemySpawner.Enemy.size()>1 ? "MELEE" : "FLEEING";
        }

//add a name field in the constructor

        int movementTurn = Math.max(1,agility/100);
       // int X = start[0];
      //  int Y = start[1];

        int X = start[1];
        int Y = start[0];

        //at the start, calculate distance between prayer and enemy

         {
             int diffX = player.coordinates[1]>X ? player.coordinates[1] - X : X - player.coordinates[1] ;
             int diffY = player.coordinates[0]>Y ? player.coordinates[0] - Y: Y- player.coordinates[0];

             int dif = Math.max(diffX, diffY);

             if ((AI.equalsIgnoreCase("RANGE")||AI.equalsIgnoreCase("MELEE"))&&dif==DIST)
             {
                // System.out.println("The target stays in place.");
                 mapDisplay();
                 return start;
             }
         }




       // int[] Z = mapRandomizePosition();
        //combatMap[Z[0]][Z[1]] = "P";

       // combatMap[player[0]][player[1]] = "P";
       // mapDisplay();





        //  mapDisplay();

        // combatMap[6][5] = "P";
        // combatMap[6][6] = "_";





            int y = 0;

            ArrayList<int[]> possibleMoves = new ArrayList();
            for (String[] each: combatMap
            ) {


                //calculates possible moves
                if (AI.equalsIgnoreCase("BULWARK")) {
                    for (int x = 0; x < each.length; x++) {
                        int diffX = X > x ? X - x : x - X;
                        int diffY = Y > y ? Y - y : y - Y;
                        boolean dist = (diffX <= movementTurn) && (diffY <= movementTurn);
                        if (!combatMap[y][x].equalsIgnoreCase("P") && dist) {
                            possibleMoves.add(new int[]{y, x});
                        }


                    }
                    y = y + 1;
                }

                else  {
                    for (int x = 0; x < each.length; x++) {
                        int diffX = X > x ? X - x : x - X;
                        int diffY = Y > y ? Y - y : y - Y;
                        boolean dist = (diffX <= movementTurn) && (diffY <= movementTurn);
                        if (combatMap[y][x].equalsIgnoreCase("_") && dist) {
                            possibleMoves.add(new int[]{y, x});
                        }


                    }
                    y = y + 1;
                }
            }


//AI behavior deciding moves based on player position

            TreeSet<Integer> difference = new TreeSet<>();
            HashMap<int[],Integer> possibleChoices = new HashMap<>();
            if (AI.equalsIgnoreCase("MELEE"))
            {
                for (int[] each: possibleMoves
                     ) {

                   // int diffX = Z[0]>each[0] ? Z[0] - each[0] : each[0] - Z[0] ;
                   // int diffY = Z[1]>each[1] ? Z[1] - each[1]: each[1]- Z[1];
//INTS of player AKA target
                    int diffX = player.coordinates[1]>each[1] ? player.coordinates[1] - each[1] : each[1] - player.coordinates[1] ;
                    int diffY = player.coordinates[0]>each[0] ? player.coordinates[0] - each[0]: each[0] - player.coordinates[0];

                    int dif = Math.max(diffX, diffY);
                    difference.add(dif);
                    possibleChoices.put(each,dif);

                    //figure out how to remove elements









                    
                }

                possibleChoices.entrySet().removeIf(entry -> !difference.first().equals(entry.getValue()));

//old code incase i need to not use the iterator anymore
              /*  while (iterator.hasNext())
                {
                    Map.Entry<int[],Integer>
                            entry = iterator.next();
                    if (!difference.first().equals(entry.getValue()))
                    {
                        iterator.remove();
                    }
                }

               */

                int index = (int)(Math.random()*possibleChoices.size());


               /* if (X==6&&Y==6)
                {
                    System.out.println("ERROR");
                }

                */


                    combatMap[Y][X] = "_";
                    X = hashMapAtIndex.atIndex(index, possibleChoices)[1];
                    Y = hashMapAtIndex.atIndex(index, possibleChoices)[0];
                    combatMap[Y][X] = enemyInitials(name);


            }





         if (AI.equalsIgnoreCase("BULWARK"))
         {
             boolean move = false;


             int newX = player.coordinates[1]>X ? player.coordinates[1] - X : X - player.coordinates[1] ;
             int newY = player.coordinates[0]>Y ? player.coordinates[0] - Y: Y- player.coordinates[0];

             int dif2 = Math.max(newX,newY);

             move = (dif2<=1)&&((player.coordinates[1]==X)||(player.coordinates[0]==Y));

             if (move)
             {
                 System.out.println("The enemy stays in place.");
                 return new int[] {Y,X};
             }

             else {
                 E.StoredExtraCondition.add("Rest");
             }


             for (int[] each: possibleMoves
             ) {

                 //goal: get into line of sight of player

                 int diffX = player.coordinates[1]>each[1] ? player.coordinates[1] - each[1] : each[1] - player.coordinates[1] ;
                 int diffY = player.coordinates[0]>each[0] ? player.coordinates[0] - each[0]: each[0] - player.coordinates[0];

                 int dif = Math.min(diffX, diffY);
                 difference.add(dif);
                 possibleChoices.put(each,dif);

                 //figure out how to remove elements

             }

             possibleChoices.entrySet().removeIf(entry -> !difference.first().equals(entry.getValue()));

//old code incase i need to not use the iterator anymore
              /*  while (iterator.hasNext())
                {
                    Map.Entry<int[],Integer>
                            entry = iterator.next();
                    if (!difference.first().equals(entry.getValue()))
                    {
                        iterator.remove();
                    }
                }

               */

             int index = (int)(Math.random()*possibleChoices.size());

             TreeMap<Integer,int[]> secondDist = new TreeMap<>();
             for ( int[] each : possibleChoices.keySet()
             ) {
                 int difX = player.coordinates[1]>each[1] ? player.coordinates[1] - each[1] : each[1] - player.coordinates[1] ;
                 int difY = player.coordinates[0]>each[0] ? player.coordinates[0] - each[0]: each[0] - player.coordinates[0];

                 int Diff = Math.max(difX,difY);
                 secondDist.put(Diff,each);
             }


               /* if (X==6&&Y==6)
                {
                    System.out.println("ERROR");
                }

                */


             combatMap[Y][X] = "_";
             X = secondDist.get(secondDist.firstKey())[1];
             Y = secondDist.get(secondDist.firstKey())[0];
             combatMap[Y][X] = enemyInitials(name);

             Iterator<Map.Entry<String, EnemyStats>> iterator = enemySpawner.Enemy.entrySet().iterator();

             while (iterator.hasNext()){

                 int[] coordinates = {Y,X};

                 EnemyStats enemy = iterator.next().getValue();

                 if (E != enemy )
                 {
                     if (enemy.getCoord()[0]==coordinates[0]&&enemy.getCoord()[1]==coordinates[1])
                     {
                         System.out.println("An enemy was crushed by the Bulwark!");
                         enemy.setcHP(0);

                     }
                 }



             }



         }

         if (AI.equalsIgnoreCase("RANGE"))
         {



             for (int[] each: possibleMoves
             ) {

                 // int diffX = Z[0]>each[0] ? Z[0] - each[0] : each[0] - Z[0] ;
                 // int diffY = Z[1]>each[1] ? Z[1] - each[1]: each[1]- Z[1];
//INTS of player AKA target
                 int diffX = player.coordinates[1]>each[1] ? player.coordinates[1] - each[1] : each[1] - player.coordinates[1] ;
                 int diffY = player.coordinates[0]>each[0] ? player.coordinates[0] - each[0]: each[0]- player.coordinates[0];

                 int dif = Math.max(diffX, diffY);

                 difference.add(dif);
                 possibleChoices.put(each,dif);


                 //figure out how to remove elements


             }

             //figure out A. sit in the DIST range of enemy.



                 int diffX = player.coordinates[1]>X ? player.coordinates[1] - X : X - player.coordinates[1] ;
                 int diffY = player.coordinates[0]>Y ? player.coordinates[0] - Y: Y- player.coordinates[0];

                 int dif = Math.max(diffX, diffY);

                 if (dif<DIST)
                 {
                     Iterator<Map.Entry<int[],Integer>> iterator = possibleChoices.entrySet().iterator();

                     while(iterator.hasNext())
                     {
                         if (difference.contains(DIST))
                         {
                             if (iterator.next().getValue()!= DIST)
                             {
                                 iterator.remove();
                             }
                         }

                         else
                         {
                             if (!Objects.equals(iterator.next().getValue(), difference.last()))
                             {
                                 iterator.remove();
                             }

                         }

                     }


                 }

                 if (dif>DIST)
                 {
                     Iterator<Map.Entry<int[],Integer>> iterator = possibleChoices.entrySet().iterator();

                     while(iterator.hasNext())
                     {
                         if (difference.contains(DIST))
                         {
                             if (iterator.next().getValue()!= DIST)
                             {
                                 iterator.remove();
                             }
                         }

                         else
                         {
                             if (!Objects.equals(iterator.next().getValue(), difference.first()))
                             {
                                 iterator.remove();
                             }

                         }

                     }

                 }









               /* if (X==6&&Y==6)
                {
                    System.out.println("ERROR");
                }

                */
             int index = (int)(Math.random()*possibleChoices.size());

             combatMap[Y][X] = "_";
             X = hashMapAtIndex.atIndex(index, possibleChoices)[1];
             Y = hashMapAtIndex.atIndex(index, possibleChoices)[0];
             combatMap[Y][X] = enemyInitials(name);


         }

         if (AI.equalsIgnoreCase("FLEEING"))
         {



             for (int[] each: possibleMoves
             ) {

                 // int diffX = Z[0]>each[0] ? Z[0] - each[0] : each[0] - Z[0] ;
                 // int diffY = Z[1]>each[1] ? Z[1] - each[1]: each[1]- Z[1];
//INTS of player AKA target
                 int diffX = player.coordinates[1]>each[1] ? player.coordinates[1] - each[1] : each[1] - player.coordinates[1] ;
                 int diffY = player.coordinates[0]>each[0] ? player.coordinates[0] - each[0]: each[0]- player.coordinates[0];

                 int dif = Math.max(diffX, diffY);

                 difference.add(dif);
                 possibleChoices.put(each,dif);


                 //figure out how to remove elements


             }

             //figure out A. sit in the DIST range of enemy.



             int diffX = player.coordinates[1]>X ? player.coordinates[1] - X : X - player.coordinates[1] ;
             int diffY = player.coordinates[0]>Y ? player.coordinates[0] - Y: Y- player.coordinates[0];

             int dif = Math.max(diffX, diffY);

            // if (dif<DIST) {

             possibleChoices.entrySet().removeIf(integerEntry -> !Objects.equals(integerEntry.getValue(), difference.last()));


           // }
/*
             if (dif>DIST)
             {
                 Iterator<Map.Entry<int[],Integer>> iterator = possibleChoices.entrySet().iterator();

                 while(iterator.hasNext())
                 {
                     if (difference.contains(DIST))
                     {
                         if (iterator.next().getValue()!= DIST)
                         {
                             iterator.remove();
                         }
                     }

                     else
                     {
                         if (!Objects.equals(iterator.next().getValue(), difference.first()))
                         {
                             iterator.remove();
                         }

                     }

                 }

             }

*/







               /* if (X==6&&Y==6)
                {
                    System.out.println("ERROR");
                }

                */
             int index = (int)(Math.random()*possibleChoices.size());

             combatMap[Y][X] = "_";
             X = hashMapAtIndex.atIndex(index, possibleChoices)[1];
             Y = hashMapAtIndex.atIndex(index, possibleChoices)[0];
             combatMap[Y][X] = enemyInitials(name);


         }

            mapDisplay();
            return new int[] {Y,X};





        }








}
