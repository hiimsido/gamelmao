package ShadowsRPG;

import java.util.Arrays;
import java.util.Scanner;

public class enemyStatCheck {

   public static void getStats(){

       boolean a = true;
       while(a) {

           try {
               System.out.println("Choose which target stats you'd like to find out (EX: E1 or ALL)");

               for (String each : enemySpawner.Enemy.keySet()
               ) {

                   System.out.println(each + ": " + enemySpawner.Enemy.get(each).Name + " " + Arrays.toString(enemySpawner.Enemy.get(each).getCoord()));

               }

               String response = capitalizeWord.capItem(new Scanner(System.in).nextLine());


               if (response.equalsIgnoreCase("all")) {


                   for (EnemyStats each : enemySpawner.Enemy.values()
                   ) {
                       System.out.println("ENEMY NAME: " + each.Name);
                       System.out.println("HP: " + each.cHP + "/" + each.HP);
                       System.out.println("ATTACK: " + each.ATK);
                       System.out.println("RANGE: " + each.RNG);
                       System.out.println("MAGE: " + each.MAGE);
                       System.out.println("AGILITY: " + each.AGIL);
                       System.out.println("DEFENSE: " + each.DEF);
                       System.out.println("ATTACK RANGE: " + each.DIST);
                       System.out.println("CRIT: " + each.CRIT);

                       System.out.println(" - - - - - - - - - - - -");

                   }

                   return;
               }

               else if (enemySpawner.Enemy.containsKey(response)) {
                   EnemyStats enemy = enemySpawner.Enemy.get(response);

                   System.out.println("ENEMY NAME: " + enemy.Name);
                   System.out.println("HP: " + enemy.cHP + "/" + enemy.HP);
                   System.out.println("ATTACK: " + enemy.ATK);
                   System.out.println("RANGE: " + enemy.RNG);
                   System.out.println("MAGE: " + enemy.MAGE);
                   System.out.println("AGILITY: " + enemy.AGIL);
                   System.out.println("DEFENSE: " + enemy.DEF);
                   System.out.println("ATTACK RANGE: " + enemy.DIST);
                   System.out.println("CRIT: " + enemy.CRIT);
                   System.out.println(" - - - - - - - - - - - -");

                   return;
               } else if (response.equalsIgnoreCase("exit") || response.equalsIgnoreCase("")) {
                   return;
               }

               else {
                   System.out.println(response + " does not exist. Try again.");
               }


           } catch (Exception e) {
               System.out.println("There was en error. Try again.");
           }


       }
    }


    public static void main(String[] args) {
       enemySpawner.addEnemy(5);
        getStats();
    }
       }



