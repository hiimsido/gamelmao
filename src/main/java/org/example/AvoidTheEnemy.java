package org.example;


import java.util.*;

public class AvoidTheEnemy {


    static void intro() {
        System.out.println("Here's the rundown. You are trying to survive 10 rounds within a grid.");
        System.out.println("Whatever is chasing you has limited line of sight, however if it sees you.");
        System.out.println("It'll chase you down until you break line of sight.");
        System.out.println("With that said, let the game commence.");
        System.out.println("------------------------------------------------------------");
        gameStart();
    }

    static void gameStart() {
        System.out.println("Type help or start to continue.");
        Scanner InputTracker = new Scanner(System.in);

        String input = InputTracker.nextLine().toLowerCase();
        // String input = "start"; quickstart for test

        if (input.equals("start")) {
            System.out.println("The game, will now begin.");
            runGame();
        } else if (input.equals("help")) {
            intro();
        } else {
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
        int roundsSurvived = 0;
        int[] playerPlaceholder = {4, 4};
        int[] enemyLocation = {0, 0};
        int[] enemyPlaceholder = {0, 0, 0, 0};
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
        for (int i = 0; i < 10; i++) {

            int chaos = 0;
            if (i>1) {
                chaos = (int) (Math.random() * 8);
            }



            grid[playerPlaceholder[0]][playerPlaceholder[1]] = 0; //deletes old location
            System.out.println("--------Player Turn--------");
            System.out.println("--------Current Position: " + Arrays.toString(playerPlaceholder) + "--------");
            //logic for player movement, via user input
            playerPlaceholder = playerPosition(playerPlaceholder);

            grid[playerPlaceholder[0]][playerPlaceholder[1]] += 1; //updates new location


            //printing the map
            {
                System.out.println(Arrays.toString(grid[0]));
                System.out.println(Arrays.toString(grid[1]));
                System.out.println(Arrays.toString(grid[2]));
                System.out.println(Arrays.toString(grid[3]));
                System.out.println(Arrays.toString(grid[4]));
            }

            if (grid[playerPlaceholder[0]][playerPlaceholder[1]] == 3)
            {
                System.out.println("My goodness... You ran right into the creature??? Game Over");
                System.out.println("-----------------------------------");
                break;
            }


            //logic for enemy turn which uses rng
            System.out.println("--------Enemy Turn--------");
            grid[enemyPlaceholder[0]][enemyPlaceholder[1]] = 0; //deletes old location on grid

            enemyPlaceholder = enemyPosition(enemyPlaceholder, prevLocation, playerPlaceholder);



            //Difference of old position, so it doesn't go back to said square (unless player line of sight)
            prevLocation[1] = enemyPlaceholder[3];
            prevLocation[0] = enemyPlaceholder[2];
            grid[enemyPlaceholder[0]][enemyPlaceholder[1]] += 2; //updates new location on grid


            if (chaos==2) //if game isn't over yet, and rng is set to 2, enemy will teleport beside you.
            {
                System.out.println("The enemy has casted a spell, it's right beside you now!");
                grid[enemyPlaceholder[0]][enemyPlaceholder[1]] = 0;
                enemyPlaceholder = Teleportation(enemyPlaceholder,playerPlaceholder);
                grid[enemyPlaceholder[0]][enemyPlaceholder[1]] += 2;

            }




            /*if (Arrays.equals(prevLocation, new int[]{0, 0})) {
                prevLocation[0] = -movingHere[0];
                prevLocation[1] = -movingHere[1];
            }*/


            //printing the map
            if ((chaos!=7)&&(chaos!=6))
            {
                System.out.println(Arrays.toString(grid[0]));
                System.out.println(Arrays.toString(grid[1]));
                System.out.println(Arrays.toString(grid[2]));
                System.out.println(Arrays.toString(grid[3]));
                System.out.println(Arrays.toString(grid[4]));
            }

            else
            {
                System.out.println("A mysterious fog has entered the maze. You can't see anything!");
                System.out.println("[?,?,?,?,?]");
                System.out.println("[?,?,?,?,?]");
                System.out.println("[?,?,?,?,?]");
                System.out.println("[?,?,?,?,?]");
                System.out.println("[?,?,?,?,?]");
            }

            if (grid[enemyPlaceholder[0]][enemyPlaceholder[1]] == 3)
            {
                System.out.println("The enemy has consumed you. Game Over.");
                System.out.println("-----------------------------------");
                break;
            }
            roundsSurvived++;
        }

        if (roundsSurvived==10)
        {
            System.out.println("Congratulations! You survived the challenge!");
        }
    }

    public static int[] playerPosition(int[] pos) {
        String moveChoice = "";


        int up = -1;
        int down = 1;
        int left = -1;
        int right = 1;
        int[] placeholder = pos;

        //assigns values to your choices based on where you are within the grid

        if (pos[0] == 0) {
            up = 0;
        }
        if (pos[0] == 4) {
            down = 0;
        }

        if (pos[1] == 0) {
            left = 0;
        }
        if (pos[1] == 4) {
            right = 0;
        }


        int choice = 0; // continue to loop until movement has a value attached
        System.out.println("Possible Movements:");
        if (left != 0) {
            System.out.print(" | left |");
        }
        if (right != 0) {
            System.out.print(" | right |");
        }
        if (up != 0) {
            System.out.print(" | up |");
        }
        if (down != 0) {
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
                    placeholder[1] = placeholder[1] - 1;
                    break;
                case "right":
                    choice = right;
                    placeholder[1] = placeholder[1] + 1;
                    break;
                case "up":
                    choice = up;
                    placeholder[0] = placeholder[0] - 1;
                    break;
                case "down":
                    choice = down;
                    placeholder[0] = placeholder[0] + 1;
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

    public static int[] Teleportation(int[] pos, int[] playerPos) {


        int up = -1;
        int down = 1;
        int left = -1;
        int right = 1;
        String key = "";
        int value = 0;
        TreeSet<String> TeleChoices = new TreeSet<>();

        // enemy determining where it can and cannot go based on your position

        pos[2] = pos[0];
        pos[3] = pos[1];

        if (playerPos[0] == 0) {
            up = 0;
        }
        if (playerPos[0] == 4) {
            down = 0;
        }

        if (playerPos[1] == 0) {
            left = 0;
        }
        if (playerPos[1] == 4) {
            right = 0;
        }

        if (right!=0) {
            TeleChoices.add("0," + right);
        }
        if (left!=0) {
            TeleChoices.add("0," + left);
        }
        if (up!=0) {
            TeleChoices.add(up +",0");
        }
        if(down!=0) {
            TeleChoices.add(down +",0");
        }

        // System.out.println(TeleChoices); //testing stuff

        int Selection = (int) (Math.random()* TeleChoices.size());
        int loopVal = 0;
        for (String each : TeleChoices
        ) {

            if (Selection == loopVal) {
                int splitThis = each.indexOf(",");
                int coordinateX = Integer.parseInt(each.substring(0, splitThis));
                int coordinateY = Integer.parseInt(each.substring(1 + splitThis));
                pos[0] = playerPos[0] + coordinateX;
                pos[1] = playerPos[1] + coordinateY;

                break;
            }
            loopVal = loopVal + 1;
        }



       





           /* if (choice == 0)
            {
                placeholder = pos;
                System.out.println("Unable to make move. Please look at your available options again.");

            }*/





        return pos;



    }

    static int[] enemyPosition(int[] pos, int[] prevPos, int[] playerPos) {

        int up = -1;
        int down = 1;
        int left = -1;
        int right = 1;

        //assigns values to your choices based on where you are within the grid

        if (pos[0] == 0) {
            up = 0;
        }
        if (pos[0] == 4) {
            down = 0;
        }

        if (pos[1] == 0) {
            left = 0;
        }
        if (pos[1] == 4) {
            right = 0;
        }
        // failsafe for if player position is equal to enemy position on enemy turn
        if (pos[1]==playerPos[1]&&pos[0]==playerPos[0])
        {
            System.out.println("What an odd occurrence?");
            return pos;
        }

        //logic for when the enemy sees you

        if (pos[0] == playerPos[0]) {
            if (pos[1] < playerPos[1]) {
                pos[1] = pos[1] + 1;
                pos[3] = -1;
                pos[2] = 0;
                return pos;
            } else if (pos[1] > playerPos[1]) {
                pos[1] = pos[1] - 1;
                pos[3] = 1;
                pos[2] = 0;
                return pos;
            }
        }

        if (pos[1] == playerPos[1]) {
            if (pos[0] < playerPos[0]) {
                pos[0] = pos[0] + 1;
                pos[2] = -1;
                pos[3] = 0;
                return pos;
            } else if (pos[0] > playerPos[0]) {
                pos[0] = pos[0] - 1;
                pos[2] = 1;
                pos[3] = 0;
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

        //filters out any movements deemed impossible and the previous position to prevent back and fourth movement, even if the enemy can still move in a box
        possibilities.remove("0,0");
        possibilities.remove(prevPos[0] + "," + prevPos[1]);

        int RNG = (int) (Math.random() * possibilities.size());
       //  System.out.println(possibilities); //for testing purposes
        for (String each : possibilities
        ) {

            if (RNG == loopVal) {
                int splitThis = each.indexOf(",");
                int coordinateX = Integer.parseInt(each.substring(0, splitThis));
                int coordinateY = Integer.parseInt(each.substring(1 + splitThis));
                pos[0] = pos[0] + coordinateX;
                pos[1] = pos[1] + coordinateY;
                pos[2] = -coordinateX;
                pos[3] = -coordinateY;

                break;
            }
            loopVal = loopVal + 1;
        }


        return pos;

    }


    public static void main(String[] args) {


        String RunItBack = "";
        Scanner decision = new Scanner(System.in);


        while (!RunItBack.equalsIgnoreCase("end")) {
            intro();
            System.out.println("Continue | End");
            RunItBack = decision.nextLine();
        }
    }
}