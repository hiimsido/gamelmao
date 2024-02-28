package ShadowsRPG;

import ShadowsRPG.Enums.Attack;
import ShadowsRPG.Enums.playerEquipment;
import ShadowsRPG.maps.CombatMapC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class  playerSpec {

    public static void specDMG(String name, Player player, EnemyStats enemy,Attack a) {

//consider using magic level to determine
// amount of bounces? 1 bounce = 200 magic?
            if (name.equalsIgnoreCase("Lightning Strike"))


            {
                int ABSORP = 0;
                int REFLECT = 0;
                ArrayList<EnemyStats> deadTarget = new ArrayList<>();

                EnemyStats target = enemy;
                int[] E = enemy.getCoord();

                int  DamageA = calcDMG.MageDMG(a.getExtraCRIT(), a.getCRITMOD(), new GrabStats(player), new GrabStats(target), a.getDMGMod());
                ABSORP = target.MAGEABSORP + target.TemporaryStats.get("MAGEABSORP");
                REFLECT = target.MAGEREFLECT + target.TemporaryStats.get("MAGEREFLECT");

                if (!a.getWeakness().equalsIgnoreCase("none")||target.getTemporaryWeakness().containsKey("All")||target.getResistances().contains("All"))
                {

                    if (target.getWeakness().contains(a.getWeakness())||target.getTemporaryWeakness().containsKey(a.getWeakness())||target.getWeakness().contains("All")||target.getTemporaryWeakness().containsKey("All"))
                    {
                        System.out.println("The target is weak to your attack!");
                        DamageA*=2;
                    }

                    if (target.getResistances().contains(a.getWeakness())||target.getTemporaryResistances().containsKey(a.getWeakness())||target.getResistances().contains("All")||target.getTemporaryResistances().containsKey("All"))
                    {
                        System.out.println("The target resists the attack!");
                        DamageA/=2;
                    }

                }

                if (REFLECT > 0) {
                    player.cHP -= DamageA*(REFLECT/100);
                    System.out.println("You take" + DamageA*(REFLECT/100) + " reflection damage!");

                    if (player.cHP<1)
                    {
                        enemyAttackBeta.endgame(player);
                    }

                    System.out.println("Remaining HP: " + player.cHP + ".");

                }

                if (ABSORP > 0) {
                    DamageA = DamageA - Math.min(((DamageA * (ABSORP / 100))), ((int) (DamageA * .9)));
                }
                target.cHP -= DamageA;
                if (target.cHP>0)
                {
                    System.out.println(target.Name + " has taken " + DamageA + " Damage! "
                            + target.cHP + " HP remains.");
                }

                else  if (target.cHP<1) {
                    System.out.println(target.Name + " has taken " + DamageA + " Damage and has perished!");
                    int[] coords = target.getCoord();
                    enemySpawner.Enemy.remove(target.getID());
                    CombatMapC.combatMap[coords[0]][coords[1]] = "_";
                }

                if((enemySpawner.Enemy.isEmpty()))
                {
                    return;
                }



                for (int i = 0; i < 3; i++) {
                    TreeMap<Integer,EnemyStats> Options = new TreeMap<>();
                    Iterator<Map.Entry<String, EnemyStats>> iterator = enemySpawner.Enemy.entrySet().iterator();

                    while (iterator.hasNext()) {

                        EnemyStats B = iterator.next().getValue();

                        int[] b = B.getCoord();
                        if (B.equals(target)) {
                            continue;
                        }


                        int difX = b[1] > E[1] ? b[1] - E[1] : E[1] - b[1];
                        int difY = b[0] > E[0] ? b[0] - E[0] : E[0] - b[0];
                        int dif = Math.max(difX, difY);

                        if (dif <=2&&B.cHP>0) {
                            Options.put(Options.size(), B);
                        }

                    }

                    if (Options.isEmpty()) {
                        return;
                    }
                        target = Options.get((int)(Math.random()*Options.size()));

                        E = target.getCoord();

                        System.out.println("The lightning bounces to a new target!");
                    int  Damage = calcDMG.MageDMG(a.getExtraCRIT(), a.getCRITMOD(), new GrabStats(player), new GrabStats(target), a.getDMGMod())/(1+i);
                    ABSORP = target.MAGEABSORP + target.TemporaryStats.get("MAGEABSORP");
                    REFLECT = target.MAGEREFLECT + target.TemporaryStats.get("MAGEREFLECT");

                    if (!a.getWeakness().equalsIgnoreCase("none")||target.getTemporaryWeakness().containsKey("All")||target.getResistances().contains("All"))
                    {

                        if (target.getWeakness().contains(a.getWeakness())||target.getTemporaryWeakness().containsKey(a.getWeakness())||target.getWeakness().contains("All")||target.getTemporaryWeakness().containsKey("All"))
                        {
                            System.out.println("The target is weak to your attack!");
                            DamageA*=2;
                        }

                        if (target.getResistances().contains(a.getWeakness())||target.getTemporaryResistances().containsKey(a.getWeakness())||target.getResistances().contains("All")||target.getTemporaryResistances().containsKey("All"))
                        {
                            System.out.println("The target resists the attack!");
                            DamageA/=2;
                        }

                    }

                    if (REFLECT > 0) {
                        player.cHP -= Damage*(REFLECT/100);
                        System.out.println("You take" + Damage*(REFLECT/100) + " reflection damage!");

                        if (player.cHP<1)
                        {
                            enemyAttackBeta.endgame(player);
                        }

                        System.out.println("Remaining HP: " + player.cHP + ".");

                    }

                    if (ABSORP > 0) {
                        Damage = Damage - Math.min(((Damage * (ABSORP / 100))), ((int) (Damage * .9)));
                    }

                        target.cHP -=  Damage;
                        if (target.cHP>0)
                        {
                            System.out.println(target.Name + " has taken " + (Damage) + " Damage! "
                                    + target.cHP + " HP remains.");

                        }

                        else {
                            System.out.println(target.Name + " has taken " + (Damage) + " Damage and has perished!");
                            int[] coords = target.getCoord();

                            CombatMapC.combatMap[coords[0]][coords[1]] = "_";
                            enemySpawner.Enemy.remove(target.getID());
                        }
                    }
                }

        if (name.equalsIgnoreCase("Lightning Shot"))


        {
           String bane = playerEquipment.Bow.valueOf(player.WornEquipment.get("Bow")).getBane();
            int ABSORP = 0;
            int REFLECT = 0;
            ArrayList<EnemyStats> deadTarget = new ArrayList<>();

            EnemyStats target = enemy;
            int[] E = enemy.getCoord();

            int[] P = player.coordinates;

            int difX = P[1] > E[1] ? P[1] - E[1] : E[1] - P[1];
            int difY = P[0] > E[0] ? P[0] - E[0] : E[0] - P[0];
            int dif = Math.max(difX, difY);

            int  DamageA = calcDMG.RangeDMG(a.getExtraCRIT(), a.getACCMod(), a.getCRITMOD(), new GrabStats(player), new GrabStats(target), a.getDMGMod(), dif);

            if (DamageA==0)
            {
                return;
            }
            ABSORP = target.ABSORP + target.TemporaryStats.get("ABSORP");
            REFLECT = target.REFLECT + target.TemporaryStats.get("REFLECT");

            if (!a.getWeakness().equalsIgnoreCase("none")||target.getTemporaryWeakness().containsKey("All")||target.getResistances().contains("All"))
            {

                if (target.getWeakness().contains(a.getWeakness())||target.getTemporaryWeakness().containsKey(a.getWeakness())||target.getWeakness().contains("All")||target.getTemporaryWeakness().containsKey("All"))
                {
                    System.out.println("The target is weak to your attack!");
                    DamageA*=2;
                }

                if (target.getResistances().contains(a.getWeakness())||target.getTemporaryResistances().containsKey(a.getWeakness())||target.getResistances().contains("All")||target.getTemporaryResistances().containsKey("All"))
                {
                    System.out.println("The target resists the attack!");
                    DamageA/=2;
                }

            }

            if (!bane.equalsIgnoreCase("none"))
            {

                int dmgchange = 0;
                if (target.getResistances().contains(bane)||target.getTemporaryResistances().containsKey(bane))
                {
                    dmgchange = -DamageA/5;
                }

                if (target.getWeakness().contains(bane)||target.getTemporaryWeakness().containsKey(bane))
                {
                    dmgchange = DamageA/5;
                }

                DamageA+= dmgchange;
            }

            if (REFLECT > 0) {
                player.cHP -= DamageA*(REFLECT/100);
                System.out.println("You take" + DamageA*(REFLECT/100) + " reflection damage!");

                if (player.cHP<1)
                {
                    enemyAttackBeta.endgame(player);
                }

                System.out.println("Remaining HP: " + player.cHP + ".");

            }

            if (ABSORP > 0) {
                DamageA = DamageA - Math.min(((DamageA * (ABSORP / 100))), ((int) (DamageA * .9)));
            }
            target.cHP -= DamageA;
            if (target.cHP>0)
            {
                System.out.println(target.Name + " has taken " + DamageA + " Damage! "
                        + target.cHP + " HP remains.");
            }

            else  if (target.cHP<1) {
                System.out.println(target.Name + " has taken " + DamageA + " Damage and has perished!");
                int[] coords = target.getCoord();
                enemySpawner.Enemy.remove(target.getID());
                CombatMapC.combatMap[coords[0]][coords[1]] = "_";
            }

            if((enemySpawner.Enemy.isEmpty()))
            {
                return;
            }



            for (int i = 0; i < 3; i++) {
                TreeMap<Integer,EnemyStats> Options = new TreeMap<>();
                Iterator<Map.Entry<String, EnemyStats>> iterator = enemySpawner.Enemy.entrySet().iterator();

                while (iterator.hasNext()) {

                    EnemyStats B = iterator.next().getValue();

                    int[] b = B.getCoord();
                    if (B.equals(target)) {
                        continue;
                    }


                    int difXb = b[1] > E[1] ? b[1] - E[1] : E[1] - b[1];
                    int difYb = b[0] > E[0] ? b[0] - E[0] : E[0] - b[0];
                    int difb = Math.max(difXb, difYb);

                    if (difb <=2&&B.cHP>0) {
                        Options.put(Options.size(), B);
                    }

                }

                if (Options.isEmpty()) {
                    return;
                }
                target = Options.get((int)(Math.random()*Options.size()));

                E = target.getCoord();

                System.out.println("The lightning bounces to a new target!");
                int Damage = calcDMG.RangeDMG(a.getExtraCRIT(), 999, a.getCRITMOD(), new GrabStats(player), new GrabStats(target), a.getDMGMod()/(1+i), dif);
                ABSORP = target.MAGEABSORP + target.TemporaryStats.get("MAGEABSORP");
                REFLECT = target.MAGEREFLECT + target.TemporaryStats.get("MAGEREFLECT");

                if (!a.getWeakness().equalsIgnoreCase("none")||target.getTemporaryWeakness().containsKey("All")||target.getResistances().contains("All"))
                {

                    if (target.getWeakness().contains(a.getWeakness())||target.getTemporaryWeakness().containsKey(a.getWeakness())||target.getWeakness().contains("All")||target.getTemporaryWeakness().containsKey("All"))
                    {
                        System.out.println("The target is weak to your attack!");
                        DamageA*=2;
                    }

                    if (target.getResistances().contains(a.getWeakness())||target.getTemporaryResistances().containsKey(a.getWeakness())||target.getResistances().contains("All")||target.getTemporaryResistances().containsKey("All"))
                    {
                        System.out.println("The target resists the attack!");
                        DamageA/=2;
                    }

                }

                if (REFLECT > 0) {
                    player.cHP -= Damage*(REFLECT/100);
                    System.out.println("You take" + Damage*(REFLECT/100) + " reflection damage!");

                    if (player.cHP<1)
                    {
                        enemyAttackBeta.endgame(player);
                    }

                    System.out.println("Remaining HP: " + player.cHP + ".");

                }

                if (ABSORP > 0) {
                    Damage = Damage - Math.min(((Damage * (ABSORP / 100))), ((int) (Damage * .9)));
                }

                target.cHP -=  Damage;
                if (target.cHP>0)
                {
                    System.out.println(target.Name + " has taken " + (Damage) + " Damage! "
                            + target.cHP + " HP remains.");

                }

                else {
                    System.out.println(target.Name + " has taken " + (Damage) + " Damage and has perished!");
                    int[] coords = target.getCoord();

                    CombatMapC.combatMap[coords[0]][coords[1]] = "_";
                    enemySpawner.Enemy.remove(target.getID());
                }
            }
        }



            }




    public static void changeTarget(String name, Player player, EnemyStats enemy) {

    }

    public static void special(String name, Player player, EnemyStats enemy, Attack a) {

        String bane = playerEquipment.Weapon.valueOf(player.WornEquipment.get("Weapon")).getBane();

        if (name.equalsIgnoreCase("Spinning Slash")) {
            Iterator<Map.Entry<String, EnemyStats>> iterator = enemySpawner.Enemy.entrySet().iterator();

            while (iterator.hasNext()) {
                EnemyStats b = iterator.next().getValue();

                if (b.equals(enemy))
                {
                    continue;
                }

                int[] P = player.coordinates;
                int[] E = b.Coordinates;

                int difX = P[1] > E[1] ? P[1] - E[1] : E[1] - P[1];
                int difY = P[0] > E[0] ? P[0] - E[0] : E[0] - P[0];
                int dif = Math.max(difX, difY);

                int Damage = 0;

                if (dif == 1) {


                    Damage = calcDMG.MeleeDMG(a.getExtraCRIT(), a.getACCMod(), a.getCRITMOD(), new GrabStats(player), new GrabStats(b), a.getDMGMod());


                }
                int REFLECT = b.REFLECT + b.TemporaryStats.get("REFLECT");
              int ABSORP = b.ABSORP + b.TemporaryStats.get("ABSORP");



                if (Damage == 0) {
                    continue;
                }

                if (!a.getWeakness().equalsIgnoreCase("none")||b.getTemporaryWeakness().containsKey("All")||b.getResistances().contains("All"))
                {

                    if (b.getWeakness().contains(a.getWeakness())||b.getTemporaryWeakness().containsKey(a.getWeakness())||b.getWeakness().contains("All")||b.getTemporaryWeakness().containsKey("All"))
                    {
                        System.out.println("The target is weak to your attack!");
                        Damage*=2;
                    }

                    if (b.getResistances().contains(a.getWeakness())||b.getTemporaryResistances().containsKey(a.getWeakness())||b.getResistances().contains("All")||b.getTemporaryResistances().containsKey("All"))
                    {
                        System.out.println("The target resists the attack!");
                        Damage/=2;
                    }

                }

                if (!bane.equalsIgnoreCase("none"))
                {

                    int dmgchange = 0;
                    if (b.getResistances().contains(bane)||b.getTemporaryResistances().containsKey(bane))
                    {
                        dmgchange = -Damage/5;
                    }

                    if (b.getWeakness().contains(bane)||b.getTemporaryWeakness().containsKey(bane))
                    {
                        dmgchange = Damage/5;
                    }

                    Damage+= dmgchange;
                }

                if (REFLECT>0)
                {
                    player.cHP -= Damage*(REFLECT/100);
                    System.out.println("You take" + Damage*(REFLECT/100) + " reflection damage!");

                    if (player.cHP<1)
                    {
                        enemyAttackBeta.endgame(player);
                    }

                    System.out.println("Remaining HP: " + player.cHP + ".");
                }

                if (ABSORP>0)
                {
                    Damage = Damage - Math.min(((Damage * (ABSORP / 100))), ((int) (Damage * .9)));
                }
                b.cHP -= (Damage);
                if (b.cHP < 1) {
                    System.out.println(b.Name + " has taken " + (Damage) + " Damage and has perished!");
                    int[] coords = b.getCoord();
                    CombatMapC.combatMap[coords[0]][coords[1]] = "_";
                    iterator.remove();
                    continue;
                }

                System.out.println(b.Name + " has taken " + (Damage) + " Damage! "
                        + b.cHP + " HP remains.");


            }


    /*    for (EnemyStats b: enemySpawner.Enemy.values()
             ) {
            if (b.equals(enemy))
            {
                continue;
            }
            else
            {
                int[] P = player.coordinates;
                int[] E = b.Coordinates;

                int difX = P[1] > E[1] ? P[1] - E[1] : E[1] - P[1];
                int difY = P[0] > E[0] ? P[0] - E[0] : E[0] - P[0];
                int dif = Math.max(difX, difY);

                int Damage = 0;

                if (dif==1)
                {


                    Damage = calcDMG.MeleeDMG(player.CRIT + player.TemporaryStats.get("CRIT") + a.getExtraCRIT(), (int)((player.cATK + player.TemporaryStats.get("ATK"))*(1 + player.TemporaryMultiplier.get("ATKmod"))), (int)((b.DEF + b.TemporaryStats.get("DEF")) * (1 + b.TemporaryMultiplier.get("DEFmod"))), (int)((b.cAGIL + b.TemporaryStats.get("AGIL")) * (1 + b.TemporaryMultiplier.get("AGILmod"))), b.getABSORP() + b.TemporaryStats.get("ABSORP"), a.getAccMod()*(1 + player.TemporaryMultiplier.get("ACCmod")), b.getDeflect() + b.TemporaryStats.get("REFLECT"));
                }

                if (Damage == 0) {
                    continue;
                }
                b.cHP -= (int) (Damage * a.getDMGMod());
            }
        }
    } */

        }


        }



    public static void special(String name, Player player, Attack a)
    {
        if (name.equalsIgnoreCase("Arcane Mind"))
        {
            System.out.println("You channel the knowledge of arcane magics. You feel your mana returning.");
            player.cMANA = Math.min(player.MANA,player.cMANA + player.MANA/2);
        }


    }
}
