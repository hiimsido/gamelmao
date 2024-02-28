package ShadowsRPG;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DeBuffs {


    //add debuff odds into this, by including the stats of the player/enemy.
    //add debuff stat bases, to each enemies. Maybe based on their type?

    //figure out how to calculate debuff chance


    //change stun resist to a buff

    public static void buff(Player player){

        HashMap<String,Integer> b = player.Buffs;

        Iterator<Map.Entry<String,Integer>> iterator = b.entrySet().iterator();

        while(iterator.hasNext())
        {

            String c = iterator.next().getKey();
               b.replace(c,b.get(c)-1);

            if (b.get(c) <= 0) {
                System.out.println(c + " has ran out.");
                player.playerStatSubtract(possibleAttacksBeta.stringConversion(c));
                iterator.remove();
            }
        }


       /* for (String each: b.keySet()
        ) {
            b.replace(each,b.get(each)-1);

            if (b.get(each) <= 0) {
                System.out.println(each + " has ran out.");
                b.remove(each);
            }
        }
*/


    }

    public static void enemybuff(EnemyStats e){

        HashMap<String,Integer> b = e.Buffs;


        Iterator<Map.Entry<String,Integer>> iterator = b.entrySet().iterator();

        while(iterator.hasNext())
        {

            String c = iterator.next().getKey();
            b.replace(c,b.get(c)-1);

            if (b.get(c) <= 0) {
                System.out.println(c + " has ran out.");
                e.enemyStatSubtract(possibleAttacksBeta.stringConversion(c));
                iterator.remove();
            }
        }

      /*  for (String each: b.keySet()
        ) {
            b.replace(each, b.get(each) - 1);

            if (b.get(each) <= 0) {
                System.out.println(each + " has ran out.");
                b.remove(each);
            }

        }
*/
    }

    //create an apply debuff/buff thingy in here

    public static void debuff(Player player){
        HashMap<String,Integer> b = player.Debuffs;
        HashMap<String,Integer> a = player.Buffs;

        Iterator<Map.Entry<String,Integer>> iterator = b.entrySet().iterator();

        while (iterator.hasNext()){
            String c = iterator.next().getKey();

            if (c.equalsIgnoreCase("Stun")) {
                System.out.println("You're stunned!");
                player.playerStatSubtract(possibleAttacksBeta.stringConversion("Stun"));
                iterator.remove();

                //need to do more for stun resist soon tm regarding the new system for debuff calc
               // a.put("Stun Resist", 2);
                continue;
            }

            if (c.equalsIgnoreCase("Frozen")) {
                System.out.println("You're frozen!");

                player.playerStatSubtract(possibleAttacksBeta.stringConversion("Frozen"));
                iterator.remove();
                continue;
            }

            if (c.equalsIgnoreCase("Bleed"))
            {
                System.out.println("You suffer from bleeding and take " + (int)(player.HP * .1) + " damage.");
                player.cHP -= (int)(player.HP * .1);
                System.out.println("Remaining Health: " + player.cHP);
            }

            if (c.equalsIgnoreCase("Poison"))
            {
                System.out.println("You suffer from poison and take " + (int)(player.HP * .1)*b.get(c) + " damage.");
                player.cHP -= (int)(player.HP * .1)*b.get(c);
                System.out.println("Remaining Health: " + player.cHP);
            }

            if (c.equalsIgnoreCase("Strong Bleed"))
            {
                System.out.println("You suffer from a strong bleed and take " + (int)(player.HP * .2) + " damage.");
                player.cHP -= (int)(player.HP * .2);
                System.out.println("Remaining Health: " + player.cHP);
            }

            if (c.equalsIgnoreCase("Hemorrhage"))
            {
                System.out.println("You suffer from an extreme bleed and take " + (int)(player.HP * .3) + " damage.");
                player.cHP -= (int)(player.HP * .3);
                System.out.println("Remaining Health: " + player.cHP);
            }

            if (c.equalsIgnoreCase("Burn"))
            {
                System.out.println("You suffer from burn and take " + (int)(player.HP * .08) + " damage.");
                player.cHP -= (int)(player.HP * .15);
                System.out.println("Remaining Health: " + player.cHP);
            }

            b.replace(c,b.get(c)-1);

            if (b.get(c) <= 0)
            {
                System.out.println(c + " has ran out.");
                player.playerStatSubtract(possibleAttacksBeta.stringConversion(c));
                iterator.remove();
            }

        }
        
        
      /*  for (String each: b.keySet()

             ) {




            if (each.equalsIgnoreCase("Stun")) {
                System.out.println("You're stunned!");
               b.remove("Stun");
               a.put("Stun Resist", 2);
               continue;
            }

            if (each.equalsIgnoreCase("Bleed"))
            {
                System.out.println("You suffer from bleeding and take " + (int)(player.HP * .05) + " damage.");
                player.cHP -= (int)(player.HP * .05);
                System.out.println("Remaining Health: " + player.cHP);
            }

            if (each.equalsIgnoreCase("Burn"))
            {
                System.out.println("You suffer from burn and take " + (int)(player.HP * .08) + " damage.");
                player.cHP -= (int)(player.HP * .08);
                System.out.println("Remaining Health: " + player.cHP);
            }

            b.replace(each,b.get(each)-1);

            if (b.get(each) <= 0)
            {
                System.out.println(each + " has ran out.");
                b.remove(each);
            }


        }
*/


    }

    public static void enemydebuff(EnemyStats e){
        HashMap<String,Integer> b = e.Debuffs;
        HashMap<String,Integer> a = e.Buffs;

        Iterator<Map.Entry<String,Integer>> iterator = b.entrySet().iterator();

       while (iterator.hasNext()){
           String c = iterator.next().getKey();

           if (c.equalsIgnoreCase("Stun")) {
               System.out.println(e.Name + " is stunned!");
               e.enemyStatSubtract(possibleAttacksBeta.stringConversion("Stun"));
               iterator.remove();
              // a.put("Stun Resist", 2);
               continue;
           }

           if (c.equalsIgnoreCase("Frozen")) {
               System.out.println(e.Name + " is frozen!");
               e.enemyStatSubtract(possibleAttacksBeta.stringConversion("Frozen"));
               iterator.remove();
               continue;
           }

           if (c.equalsIgnoreCase("Bleed"))
           {
               System.out.println(e.Name + " suffers from bleeding and takes " + (int)(e.HP * .1) + " damage.");
               e.cHP -= (int)(e.HP * .1);
               System.out.println("Remaining Health: " + e.cHP);

           }

           if (c.equalsIgnoreCase("Poison"))
           {
               System.out.println(e.Name + " suffers from bleeding and takes " +(int)(e.HP * .1)/b.get(c) + " damage.");
               e.cHP -= (int)(e.HP * .1)*b.get(c);
               System.out.println("Remaining Health: " + e.cHP);
           }

           if (c.equalsIgnoreCase("Strong Bleed"))
           {
               System.out.println(e.Name + " suffers from a strong bleed and takes " + (int)(e.HP * .2) + " damage.");
               e.cHP -= (int)(e.HP * .2);
               System.out.println("Remaining Health: " + e.cHP);

           }

           if (c.equalsIgnoreCase("Hemorrhage"))
           {
               System.out.println(e.Name + " suffers from an extreme bleed and takes " + (int)(e.HP * .3) + " damage.");
               e.cHP -= (int)(e.HP * .3);
               System.out.println("Remaining Health: " + e.cHP);

           }

           if (c.equalsIgnoreCase("Burn"))
           {
               System.out.println(e.Name + " suffers from burn and takes " + (int)(e.HP * .15) + " damage.");
               e.cHP -= (int)(e.HP * .15);
               System.out.println("Remaining Health: " + e.cHP);
           }

           b.replace(c,b.get(c)-1);

           if (b.get(c) <= 0)
           {
               System.out.println(c + " has ran out.");
               e.enemyStatSubtract(possibleAttacksBeta.stringConversion(c));
               iterator.remove();
           }

       }





    }



}
