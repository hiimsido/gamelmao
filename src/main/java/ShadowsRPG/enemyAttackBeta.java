package ShadowsRPG;

import ShadowsRPG.Enums.BuffEnum;
import ShadowsRPG.Enums.EnemyAttacks;
import ShadowsRPG.maps.CombatMapC;

import java.util.HashMap;

import static ShadowsRPG.possibleAttacksBeta.stringConversion;

public class enemyAttackBeta {

    public static String bleedLogic (Player b, String debuff)
    {
        boolean bleedA =  ((b.Debuffs.containsKey("Bleed")||b.Debuffs.containsKey("Hemorrhage")||b.Debuffs.containsKey("Strong Bleed"))&&debuff.equalsIgnoreCase("Bleed"));

        boolean bleedB = ((b.Debuffs.containsKey("Bleed")||b.Debuffs.containsKey("Hemorrhage")||b.Debuffs.containsKey("Strong Bleed"))&&debuff.equalsIgnoreCase("Strong Bleed"));

        //add a special condition for attacks, namely for bosses


        if (bleedA)
        {
            if (b.Debuffs.containsKey("Bleed"))
            {
                b.Debuffs.remove("Bleed");
                b.playerStatSubtract(stringConversion("Bleed"));
                return "Strong Bleed";
            }

            if (b.Debuffs.containsKey("Strong Bleed"))
            {
                b.Debuffs.remove("Strong Bleed");
                b.playerStatSubtract(stringConversion("Strong_Bleed"));
                return "Hemorrhage";
            }

            if (b.Debuffs.containsKey("Hemorrhage"))
            {
                return "Hemorrhage";
            }

        }

        if (bleedB)
        {

            if (b.Debuffs.containsKey("Bleed")) {
                b.Debuffs.remove("Bleed");
                b.playerStatSubtract(stringConversion("Bleed"));
                return "Hemorrhage";
            }

            if (b.Debuffs.containsKey("Strong Bleed"))
            {
                b.Debuffs.remove("Strong Bleed");
                b.playerStatSubtract(stringConversion("Strong_Bleed"));
                return "Hemorrhage";
            }

            if (b.Debuffs.containsKey("Hemorrhage"))
            {
                return "Hemorrhage";
            }
        }

        if (debuff.equals("Hemorrhage"))
        {
            if (b.Debuffs.containsKey("Bleed"))
            {
                b.Debuffs.remove("Bleed");
                b.playerStatSubtract(stringConversion("Bleed"));
            }

            if (b.Debuffs.containsKey("Strong Bleed")) {
                b.Debuffs.remove("Strong Bleed");
                b.playerStatSubtract(stringConversion("Strong_Bleed"));
            }
        }

        return debuff;

    }

    public static String freezeLogic (Player b, String debuff)
    {
        boolean coldA = ((b.Debuffs.containsKey("Freeze")||b.Debuffs.containsKey("Chilled")||b.Debuffs.containsKey("Frozen"))&&debuff.equalsIgnoreCase("Freeze"));

        boolean coldB = ((b.Debuffs.containsKey("Freeze")||b.Debuffs.containsKey("Chilled")||b.Debuffs.containsKey("Frozen"))&&debuff.equalsIgnoreCase("Chilled"));


        if (coldA)
        {
            if (b.Debuffs.containsKey("Freeze"))
            {
                b.Debuffs.remove("Freeze");
                b.playerStatSubtract(stringConversion("Freeze"));
                return "Chilled";
            }

            if (b.Debuffs.containsKey("Chilled"))
            {
                b.Debuffs.remove("Chilled");
                b.playerStatSubtract(stringConversion("Chilled"));
                return "Frozen";
            }

            if (b.Debuffs.containsKey("Frozen"))
            {
                return "Frozen";
            }

        }

        if (coldB)
        {

            if (b.Debuffs.containsKey("Freeze")) {
                b.Debuffs.remove("Freeze");
                b.playerStatSubtract(stringConversion("Freeze"));
                return "Frozen";
            }

            if (b.Debuffs.containsKey("Chilled"))
            {
                b.Debuffs.remove("Chilled");
                b.playerStatSubtract(stringConversion("Chilled"));
                return "Frozen";
            }

            if (b.Debuffs.containsKey("Frozen"))
            {
                return "Frozen";
            }
        }

        if (debuff.equals("Frozen"))
        {

            if (b.Debuffs.containsKey("Freeze")) {
                b.playerStatSubtract(stringConversion("Freeze"));
                b.Debuffs.remove("Freeze");

            }

            if (b.Debuffs.containsKey("Chilled")) {
                b.playerStatSubtract(stringConversion("Chilled"));
                b.Debuffs.remove("Chilled");
            }
        }

        return debuff;

    }

    public static void endgame(Player player)
    {
        System.out.println("You've died!");
        //void out the enemy position to a 0;
        int[] coords = player.coordinates;
        CombatMapC.combatMap[coords[0]][coords[1]] = "_";
        CombatMapC.mapDisplay();
        System.exit(0);
    }

    public static void enemyStrikeBeta(int[] E, EnemyStats B, int Crit, int ATK, int RNG, int MAGE, int DIST, HashMap<EnemyAttacks,Integer> attack, String name, Player player) {
        int[] P = player.coordinates; // using test coordinates




        for (EnemyAttacks each: attack.keySet()
             ) {



          String  TYPE = each.getType();

          boolean cooldown = attack.get(each)==0;
          boolean condition = Condition.Condition(each.getCondition(), E, (DIST + each.getDIST()),B, player, each.getBuff(),each.getDebuff(),each.getSelfDebuff()); //soon will make a condition page

            if (!cooldown||!condition)
            {
                continue;
            }


            int difX = P[1] > E[1] ? P[1] - E[1] : E[1] - P[1];
            int difY = P[0] > E[0] ? P[0] - E[0] : E[0] - P[0];


            int dif = Math.max(difX, difY);

            //make a hashset/hashmap, for the attacks which fall under the dist criteria.

            if (DIST + each.getDIST() < dif) {
                continue ;
            } else {
                attack.put(each, each.getCooldown());


                String debuff = each.getDebuff();
                String buff = each.getBuff();
                String selfDebuff = each.getSelfDebuff();

                if (!buff.equalsIgnoreCase("None")) {


                    if (!B.Buffs.containsKey(buff))
                    {
                        B.enemyStatAdd(stringConversion(buff));
                    }

                    B.Buffs.put(buff, each.getDuration());

                    B.getTemporaryWeakness().put(BuffEnum.valueOf(stringConversion(each.getBuff())).getWeakness(),each.getDuration());

                    B.getTemporaryResistances().put(BuffEnum.valueOf(stringConversion(each.getBuff())).getResistance(),each.getDuration());
                }




                System.out.println(name + " uses " + each.getName() + "!");

                if (TYPE.equalsIgnoreCase("MELEE")||TYPE.equalsIgnoreCase("RANGE")||TYPE.equalsIgnoreCase("MAGE")||TYPE.equalsIgnoreCase("SPECIAL"))  {


                for (int i = 0; i < each.getCount(); i++) {

                    if (B.cHP<1)
                    {
                        return;
                    }
                    int Damage = 0;
                    int REFLECT = 0;
                    int ABSORP = 0;
                    if (TYPE.equalsIgnoreCase("MELEE")) {

                        Damage = calcDMG.MeleeDMG(each.getExtraCRIT(),each.getACCMod(), each.getCRITMOD(), new GrabStats(B), new GrabStats(player),each.getDMGMod());

                        REFLECT = player.REFLECT + player.TemporaryStats.get("REFLECT");
                        ABSORP = player.ABSORP + player.TemporaryStats.get("ABSORP");
                    }

                   else if (TYPE.equalsIgnoreCase("RANGE")) {

                        Damage = calcDMG.RangeDMG(each.getExtraCRIT(),each.getACCMod(), each.getCRITMOD(), new GrabStats(B), new GrabStats(player),each.getDMGMod(),DIST);

                        REFLECT = player.REFLECT + player.TemporaryStats.get("REFLECT");
                        ABSORP = player.ABSORP + player.TemporaryStats.get("ABSORP");

                    }

                else  if (TYPE.equalsIgnoreCase("MAGE")) {
                        Damage = calcDMG.MageDMG(each.getExtraCRIT(), each.getCRITMOD(), new GrabStats(B), new GrabStats(player),each.getDMGMod());
                        REFLECT = player.MAGEREFLECT + player.TemporaryStats.get("MAGEREFLECT");
                        ABSORP = player.MAGEABSORP + player.TemporaryStats.get("MAGEABSORP");
                    }

                    else if (TYPE.equalsIgnoreCase("SPECIAL"))
                    {

                            Damage = EnemSpec.SpecialDMG(player,B,each.getName());

                    }

                    if (each.getSpecial())
                    {
                        EnemSpec.Special(player, B, each.getName(), Damage);
                    }



                    if (Damage == 0) {
                        continue;
                    }

                    if (!each.getWeakness().equalsIgnoreCase("None")||player.getTemporaryWeakness().containsKey("All")||player.getTemporaryResistances().containsKey("All"))
                    {
                        if (player.getTemporaryWeakness().containsKey(each.getWeakness())||player.getTemporaryWeakness().containsKey("All"))
                        {
                            Damage*=2;
                        }

                        if (player.getTemporaryResistances().containsKey(each.getWeakness())||player.getTemporaryResistances().containsKey("All"))
                        {
                            Damage/=2;
                        }
                    }

                    if (!each.getWeakness().equalsIgnoreCase("None")||player.gearWeakness.containsKey("All")||player.gearResistances.containsKey("All"))
                    {
                        String weakness = each.getWeakness();
                        double damagereduction = 1;
                        if (player.gearResistances.containsKey(each.getWeakness()))
                        {
                            damagereduction -= ((double) player.gearResistances.get(weakness) /10);
                        }

                        if (player.gearResistances.containsKey("All"))
                        {
                            damagereduction -= ((double) player.gearResistances.get("All") /10);
                        }

                        if (player.gearWeakness.containsKey(each.getWeakness()))
                        {
                            damagereduction += ((double) player.gearWeakness.get(weakness) /10);
                        }

                        if (player.gearWeakness.containsKey("All"))
                        {
                            damagereduction += ((double) player.gearWeakness.get("All") /10);
                        }

                        if (damagereduction!=1) {
                            System.out.println(
                                    (damagereduction > 1) ? "Your equipment makes you more vulnerable to the attack" : "Your equipment helps you resist the attack!"
                            );
                        }
                        Damage *= Math.max(damagereduction,.2);
                    }

                    //calculate stat bonuses based on debuffs/buffs later on :)
                    if (REFLECT>0)
                    {
                        B.cHP -= Damage*(REFLECT/100);
                        System.out.println("The enemy takes " + Damage*(REFLECT/100) + " recoil damage!");

                        System.out.println("Remaining HP: " + B.cHP + ".");

                    }

                    if (ABSORP>0)
                    {
                        Damage = Damage - Math.min( ((Damage * (ABSORP/100))), ((int)(Damage*.9)));
                    }

                    player.cHP -= Damage;


                    System.out.println("You've taken " + (Damage) + " Damage! "
                            + player.cHP + " HP remains.");

                    if (player.cHP<1)
                    {
                        endgame(player);
                    }




                    if (!debuff.equalsIgnoreCase("None")) {

                        double chance = Math.random()*each.getDebuffChance();

                        String debuffName = debuff;

                        if (!debuff.equals("Bleed")&&!debuff.equals("Freeze")&&!debuff.equals("Stun")&&!debuff.equals("Acid")&&!debuff.equals("Poison")&&!debuff.equals("Burn"))
                        {
                            debuffName = "Debuff";
                        }

                        boolean resist = player.Buffs.containsKey(debuffName + " Resist");

                        double resistSum = player.DebuffResists.get(debuffName) + player.TemporaryStats.get(debuffName) + (resist ? 100 : 0) ;

                        if (chance<resistSum) {
                            System.out.println("You manage to resist the " + debuff + "!");
                            continue;}

                        if (debuff.contains("Bleed") || debuff.contains("Strong Bleed") || debuff.contains("Hemorrhage")) {
                            debuff = bleedLogic(player, debuff);
                        }

                        if (debuff.contains("Freeze") || debuff.contains("Chilled") || debuff.contains("Frozen")) {
                            debuff = freezeLogic(player, debuff);
                        }
                            if (!player.Debuffs.containsKey(debuff)) {
                                System.out.println("You've been struck by " + debuff + "!");
                                player.playerStatAdd(stringConversion(debuff));
                            }

                            player.Debuffs.put(debuff, each.getDuration());

                        player.getTemporaryWeakness().put(BuffEnum.valueOf(stringConversion(debuff)).getWeakness(),each.getDuration());

                        player.getTemporaryResistances().put(BuffEnum.valueOf(stringConversion(debuff)).getResistance(),each.getDuration());
                    }



                    if (player.cHP < 1) {
                        endgame(player);
                    }
                }

                    if (!selfDebuff.equalsIgnoreCase("None")) {



                        if (!B.Debuffs.containsKey(selfDebuff))
                        {
                            B.enemyStatAdd(stringConversion(selfDebuff));
                            System.out.println("The enemy suffers from " + selfDebuff + "!");
                        }

                        B.Debuffs.put(selfDebuff, each.getSelfDebuffDuration());

                        B.getTemporaryWeakness().put(BuffEnum.valueOf(stringConversion(each.getSelfDebuff())).getWeakness(),each.getSelfDebuffDuration());

                        B.getTemporaryResistances().put(BuffEnum.valueOf(stringConversion(each.getSelfDebuff())).getResistance(),each.getSelfDebuffDuration());
                    }

                return;
            }



                //make statement for reflect/absorp


            else if (TYPE.equalsIgnoreCase("SELF")) {

                if (!buff.equalsIgnoreCase("None")) {
                    System.out.println("The enemy buffs themself with " + buff + "!");
                }


                    if (!selfDebuff.equalsIgnoreCase("None")) {



                        if (!B.Debuffs.containsKey(selfDebuff))
                        {
                            B.enemyStatAdd(stringConversion(selfDebuff));
                            System.out.println("The enemy suffers from " + selfDebuff + "!");
                        }

                        B.Debuffs.put(selfDebuff, each.getSelfDebuffDuration());

                        B.getTemporaryWeakness().put(BuffEnum.valueOf(stringConversion(each.getSelfDebuff())).getWeakness(),each.getSelfDebuffDuration());

                        B.getTemporaryResistances().put(BuffEnum.valueOf(stringConversion(each.getSelfDebuff())).getResistance(),each.getSelfDebuffDuration());
                    }

                    if (each.getSpecial())
                    {
                        EnemSpec.Special(player, B, each.getName(), 0);
                    }


                    return;


                }

            }
        }

        System.out.println("The enemy is unable to attack and stands it's ground.");
    }
}






