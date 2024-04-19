package ShadowsRPG;

import ShadowsRPG.Enums.EnemyAttacks;
import ShadowsRPG.maps.CombatMapC;
import ShadowsRPG.maps.enemyMovementBeta;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class EnemSpec {

    public static void Special(Player player, EnemyStats each, String attack, int Damage) {


      /*  if(attack.equalsIgnoreCase("Bulwark Roar"))
        {
            each.setAttackCooldown("Bulwark_Gaze",0);
        }

       */

       if (attack.equalsIgnoreCase("Bulwark Stomp")) {
            FlowOfCombatBeta.objectSpawn = (int) (Math.random() * 4) + 1;
            /*
            //rewrite to occur AFTER all enemies have done their movements
            int pX = player.coordinates[1];
            int pY = player.coordinates[0];

                System.out.println("The stomp causes debris to drop around you!");

            ArrayList<int[]> idealspawns = new ArrayList<>();
            ArrayList<int[]> spawns = new ArrayList<>();
            int y = 0;
            for (String[] letter: CombatMapC.combatMap
            ) {


                for (int i = 0; i < letter.length; i++) {
                    if (letter[i].equalsIgnoreCase("_"))
                    {
                        int diffX = pX>i ? pX - i : i - pX ;
                        int diffY = pY>y ? pY - y: y - pY;

                        int dif = Math.max(diffX,diffY);

                        if (dif==1)
                        {
                            idealspawns.add(new int[] {y,i});
                        }
                        else
                        {
                            spawns.add(new int[] {y,i});
                        }
                    }

                }
                y++;
            }

           int boulderSpawn = (int)(Math.random()*4) + 1;

            for (int i = 0; i < boulderSpawn; i++) {

                if (idealspawns.size()>0)
                {

                    if (idealspawns.size()==1)
                    {
                        FlowOfCombatBeta.HoldObject.put(new EnemyStats(Enemies.Boulder), idealspawns.remove(0));
                    }

                    else {
                        FlowOfCombatBeta.HoldObject.put(new EnemyStats(Enemies.Boulder), idealspawns.remove((int) (Math.random() * idealspawns.size())));
                    }
                }

                else
                {

                        FlowOfCombatBeta.HoldObject.put(new EnemyStats(Enemies.Boulder), spawns.remove((int)(Math.random()*spawns.size())));

                }

            } */

        }

       else if (attack.equalsIgnoreCase("Chomp")){
           each.StoredExtraCondition.add("Rest");
       }


        //write code to kill anything in the path of the Bulwark creature. Would be cool.
   else     if (attack.equalsIgnoreCase("Bulwark Charge")) {
            String name = enemyMovementBeta.enemyInitials(each.Name);

            int pX = player.coordinates[1];
            int pY = player.coordinates[0];

            int X = each.getCoord()[1];
            int Y = each.getCoord()[0];

            int oldX = X;
            int oldY = Y;


            if (pY == Y) {
                if (X > pX) {
                    pX = 0;
                    X = 1;
                } else if (X < pX) {
                    pX = CombatMapC.combatMap[0].length-1;
                    X = CombatMapC.combatMap[0].length-2;
                }
            } else if (pX == X) {
                if (Y > pY) {
                    pY = 0;
                    Y = 1;
                } else if (Y < pY) {
                    pY = CombatMapC.combatMap.length - 1;
                    Y = CombatMapC.combatMap.length - 2;
                }
            }

            String[][] map = CombatMapC.combatMap;
            if (enemySpawner.Enemy.size() > 1) {
                Iterator<Map.Entry<String, EnemyStats>> iterator = enemySpawner.Enemy.entrySet().iterator();

                while (iterator.hasNext()) {
                    EnemyStats b = iterator.next().getValue();

                    if (b.equals(each)) {
                        continue;
                    }

                    int[] coords = b.getCoord();

                    int bX = coords[1];
                    int bY = coords[0];

                    if (pX == X && bX == X) {
                        if (pY <= bY && bY < oldY) {
                            System.out.println("An enemy was in the path of the Bulwark's Charge!");
                            b.cHP = 0;
                            continue;
                        }

                        if (pY >= bY && bY > oldY) {
                            System.out.println("An enemy was in the path of the Bulwark's Charge!");
                            b.cHP = 0;
                            continue;
                        }

                    }

                    if (pY == Y && Y == bY) {
                        if (pX <= bX && bX < oldX) {
                            System.out.println("An enemy was in the path of the Bulwark's Charge!");
                            b.cHP = 0;
                            continue;
                        }

                        if (pX >= bX && bX > oldX) {
                            System.out.println("An enemy was in the path of the Bulwark's Charge!");
                            b.cHP = 0;
                        }
                    }

                }
            }

            map[player.coordinates[0]][player.coordinates[1]] = "_";
            map[each.getCoord()[0]][each.getCoord()[1]] = "_";

            player.coordinates[0] = pY;
            player.coordinates[1] = pX;

            System.out.println("The bulwark slams you into the wall and shifts you to " + Arrays.toString(player.coordinates) + "!");

            each.Coordinates[0] = Y;
            each.Coordinates[1] = X;


            map[player.coordinates[0]][player.coordinates[1]] = "P";

            map[each.getCoord()[0]][each.getCoord()[1]] = name;


        }

    else    if (attack.equalsIgnoreCase("Dwarf Rally")) {
            System.out.println("The dwarf rallys his dwarf squad, increasing their offensive capability.");
            enemySpawner.Enemy.forEach((key, value) -> {

                if (value.getType().equalsIgnoreCase("Dwarf")) {

                    if (!value.Buffs.containsKey("Rally")) {
                        value.enemyStatAdd(possibleAttacksBeta.stringConversion("Rally"));
                    }

                    value.Buffs.put("Rally", 3);
                }
            });

        }

  else      if (attack.equalsIgnoreCase("Dwarf Reinforcements") || attack.equalsIgnoreCase("Hatch Spider")) {
            System.out.println(each.TYPE + " reinforcements come running in!");
            int spawn = (int) (Math.random() * 3) + 2;
            FlowOfCombatBeta.HoldEnemy.put(each.TYPE, spawn);
        }

   else     if (attack.equalsIgnoreCase("Just Desserts") && (Damage > 0)) {
            each.cHP = Math.min(each.HP*2, each.cHP + Damage);
            System.out.println("The Ogre takes a bite out of you, healing up!");
            System.out.println("Ogre current health: " + each.cHP);

        }

     else   if (attack.equalsIgnoreCase("Shatter")) {
            System.out.println("You've been broken out of the ice, but you've taken severe damage!");
            player.Debuffs.remove("Frozen");
            player.playerStatSubtract("Frozen");
        }

  else      if (attack.equalsIgnoreCase("Buckshot")) {
            each.Buffs.remove("Loaded");
            each.enemyStatSubtract("Loaded");
        }

   else     if (attack.equalsIgnoreCase("Reload")) {
            if (each.Debuffs.containsKey("Reload")) {
                each.Debuffs.remove("Reload");
                each.enemyStatSubtract("Reload");
            }
        }

    else    if (attack.equalsIgnoreCase("Fire The Catapult"))
        {
            System.out.println("The catapult has fired, a giant projectile is flying toward your location!");
            each.Buffs.remove("Loaded");
            each.enemyStatSubtract("Loaded");

            each.formerPlayerLoc = new int[] {player.coordinates[0],player.coordinates[1]};
        }


    }

    public static int SpecialDMG(Player player, EnemyStats each, String attack) {
        int dif;

        if (attack.equalsIgnoreCase("Shot Landed")) {
int[] playerLoc = each.getPlayerLoc();
            int diffX = player.coordinates[1] > playerLoc[1] ? player.coordinates[1] - playerLoc[1] : playerLoc[1] - player.coordinates[1];
            int diffY = player.coordinates[0] > playerLoc[0] ? player.coordinates[0] - playerLoc[0] : playerLoc[0] - player.coordinates[0];

            dif = Math.max(diffX, diffY);

            if (dif==0)
            {
                int Damage = calcDMG.RangeDMG(0,1000, 0.0, new GrabStats(each), new GrabStats(player),1,dif);
                System.out.println("The catapult shot directly hit you!");
                each.formerPlayerLoc = null;
               return Damage;
            }

            if (dif==1)
            {
                int Damage = calcDMG.RangeDMG(0,1000, 0.0, new GrabStats(each), new GrabStats(player),1,dif);

                System.out.println("The catapult shot missed, but you were close enough to take shockwave damage!");
                each.formerPlayerLoc = null;
                return Damage/2;
            }


            System.out.println("The catapult shot missed!");

            each.formerPlayerLoc = null;
            return 0;

        }
        else if (attack.equalsIgnoreCase("Earthquake")||attack.equalsIgnoreCase("Quake")) {

            Iterator<Map.Entry<String, EnemyStats>> iterator = enemySpawner.Enemy.entrySet().iterator();

            while (iterator.hasNext()) {
                EnemyStats e = iterator.next().getValue();

                if (e.getType().equalsIgnoreCase("Object")) {
                    e.cHP = 0;
                }
            }


        /*for (String[] letter: CombatMapC.combatMap
             ) {
            for (int i = 0; i < letter.length; i++) {
                if (letter[i].equalsIgnoreCase("[X]"))
                {
                    letter[i] = "_";
                }
            }
        } */

            {
                int diffX = player.coordinates[1] > each.Coordinates[1] ? player.coordinates[1] - each.Coordinates[1] : each.Coordinates[1] - player.coordinates[1];
                int diffY = player.coordinates[0] > each.Coordinates[0] ? player.coordinates[0] - each.Coordinates[0] : each.Coordinates[0] - player.coordinates[0];

                dif = Math.max(diffX, diffY);
            }

            return (int)((player.HP / 3) * EnemyAttacks.valueOf(attack).getDMGMod())/ dif;
        }

        else
        {
            return 0;
        }
    }
}