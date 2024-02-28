package org.example;


import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PlayerTrackerB {


    static void intro() {
        System.out.println("Here's the rundown. You are trying to survive 10 rounds within a grid.");
        System.out.println("Whatever is chasing you has limited line of sight, however if too close.");
        System.out.println("It'll chase you down until you are dead.");
        System.out.println("With that said, let the game commence.");
        System.out.println("------------------------------------------------------------");
        gameStart();
    }

    static void gameStart()
    {
        System.out.println("Type help or start to continue.");
        Scanner InputTracker = new Scanner(System.in);

        String input = InputTracker.nextLine().toLowerCase();
       // String input = "start"; quickstart for test

        if (input.equals("start"))
        {
            System.out.println("The game, will now begin.");
            runGame();
        }

        else if (input.equals("help"))
        {
            intro();
        }
        else {
            System.out.println("--------Unidentified Command--------");
            gameStart();
        }

    }

    static void runGame() {
        int[][] grid =
                {
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},

                };

        int player = 1;
        int enemy = 2;

        grid[4][4] = player; //placing you
        grid[0][0] = enemy; //placing enemy

        //The location variables are used to purge the map when an int moves.
        int[] playerLocation = {4, 4};
        int[] playerPlaceholder = {4, 4};
        int[] enemyLocation = {0, 0};
        int[] enemyPlaceholder = {0,0};
        int[] prevLocation = {0, 0};
        int[] movingHere;

        {
            System.out.println("--------Starting Map--------");
            System.out.println(Arrays.toString(grid[0]));
            System.out.println(Arrays.toString(grid[1]));
            System.out.println(Arrays.toString(grid[2]));
            System.out.println(Arrays.toString(grid[3]));
            System.out.println(Arrays.toString(grid[4]));

        }
        for (int i = 0; i < 20; i++) {

            grid[playerPlaceholder[0]][playerPlaceholder[1]] = 0; //deletes old location
            System.out.println("--------Player Turn--------");
            System.out.println("--------Current Position: " + Arrays.toString(playerPlaceholder) + "--------");
            //logic for player movement, strictly user input
            playerPlaceholder = playerPosition(playerPlaceholder);

            grid[playerPlaceholder[0]][playerPlaceholder[1]] = 1; //updates new location



            //printing the map
            {
                System.out.println(Arrays.toString(grid[0]));
                System.out.println(Arrays.toString(grid[1]));
                System.out.println(Arrays.toString(grid[2]));
                System.out.println(Arrays.toString(grid[3]));
                System.out.println(Arrays.toString(grid[4]));
            }


            //logic for enemy turn which uses rng
            System.out.println("--------Enemy Turn--------");
            grid[enemyPlaceholder[0]][enemyPlaceholder[1]] = 0; //deletes old location on grid
            enemyPlaceholder = enemyPosition(enemyPlaceholder, prevLocation, playerPlaceholder);
            //calculating difference of old position and new position
            prevLocation[1] = prevLocation[1]- enemyPlaceholder[1];
            prevLocation[0] = prevLocation[0] - enemyPlaceholder[0];
            grid[enemyPlaceholder[0]][enemyPlaceholder[1]] = 2; //updates new location on grid




            /*if (Arrays.equals(prevLocation, new int[]{0, 0})) {
                prevLocation[0] = -movingHere[0];
                prevLocation[1] = -movingHere[1];
            }*/


            //printing the map
            {
                System.out.println(Arrays.toString(grid[0]));
                System.out.println(Arrays.toString(grid[1]));
                System.out.println(Arrays.toString(grid[2]));
                System.out.println(Arrays.toString(grid[3]));
                System.out.println(Arrays.toString(grid[4]));
            }
        }

    }

    public static int[] playerPosition (int[] pos)
    {
        String moveChoice = "";


        int up = -1;
        int down = 1;
        int left = -1;
        int right = 1;
        int[] placeholder = pos;

        //assigns values to your choices based on where you are within the grid

        if (pos[0] == 0)
        {
            up = 0;
        }
        if (pos[0] == 4)
        {
            down = 0;
        }

        if (pos[1] == 0)
        {
            left = 0;
        }
        if (pos[1] == 4)
        {
            right = 0;
        }




        int choice = 0; // continue to loop until movement has a value attached
        System.out.println("Possible Movements:");
        if (left !=0)
        {
            System.out.print(" | left |");
        }
        if (right !=0)
        {
            System.out.print(" | right |");
        }
        if (up !=0)
        {
            System.out.print(" | up |");
        }
        if (down !=0)
        {
            System.out.print(" | down |");
        }
        System.out.println();
        Scanner playerMovement = new Scanner(System.in);


        while (choice == 0) {
            moveChoice = playerMovement.next();
           // moveChoice = "up"; quick start for testing
            switch (moveChoice) {
                case "left":
                    choice = left;
                    placeholder[1] = placeholder[1]-1;
                    break;
                case "right":
                    choice = right;
                    placeholder[1] = placeholder[1]+1;
                    break;
                case "up":
                    choice = up;
                    placeholder[0] = placeholder[0]-1;
                    break;
                case "down":
                    choice = down;
                    placeholder[0] = placeholder[0]+1;
                    break;
                default:
                    placeholder = pos;
                    System.out.println("Unable to make move. Please look at your available options again.");

            }

           /* if (choice == 0)
            {
                placeholder = pos;
                System.out.println("Unable to make move. Please look at your available options again.");

            }*/






        }







        System.out.println("Player has moved " + moveChoice + ".");
        return placeholder;


    }

    static int[] enemyPosition(int[] pos, int[] prevPos, int[] playerPos)

    {

        int up = -1;
        int down = 1;
        int left = -1;
        int right = 1;

        //assigns values to your choices based on where you are within the grid

        if (pos[0] == 0)
        {
            up = 0;
        }
        if (pos[0] == 4)
        {
            down = 0;
        }

        if (pos[1] == 0)
        {
            left = 0;
        }
        if (pos[1] == 4)
        {
            right = 0;
        }

        //logic for when the enemy sees you

        if (pos[0] == playerPos[0])
        {
            if (pos[1]<playerPos[1])
            {
                pos[1] = pos[1] + 1 ;
                return pos;
            }

            else if (pos[1]>playerPos[1])
            {
                pos[1] = pos[1] - 1 ;
                return pos;
            }
        }

        if (pos[1] == playerPos[1])
        {
            if (pos[0]<playerPos[0])
            {
                pos[0] = pos[0] + 1 ;
                return pos;
            }

            else if (pos[0]>playerPos[0])
            {
                pos[0] = pos[0] - 1 ;
                return pos;
            }
        }

        //rng logic to determine where to go

        //store all possibilities within an TreeSet (converting it to string then reconverting to int later)
        int loopVal = 0;
        TreeSet<String> possibilities = new TreeSet<>();
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
                pos[0] = pos[0] + coordinateX;
                pos[1] = pos[1] + coordinateY;

                break;
            }
            loopVal = loopVal + 1;
        }





        return pos;

    }



    public static void main(String[] args) {


        intro();

    }
}
