package ShadowsRPG;

import ShadowsRPG.Enums.Attack;
import ShadowsRPG.Enums.BuffEnum;
import ShadowsRPG.Enums.playerEquipment;
import ShadowsRPG.maps.CombatMapC;

import java.util.*;


//create something for bleed logic outside the class for readability reasons

//see if i can have one statement for all 3 types of combat styles (switch statement for deciding what damage to use)
public class possibleAttacksBeta {




    public static String bleedLogic (EnemyStats b, String debuff)
    {
        boolean bleedA =  ((b.Debuffs.containsKey("Bleed")||b.Debuffs.containsKey("Hemorrhage")||b.Debuffs.containsKey("Strong Bleed"))&&debuff.equalsIgnoreCase("Bleed"));

        boolean bleedB = ((b.Debuffs.containsKey("Bleed")||b.Debuffs.containsKey("Hemorrhage")||b.Debuffs.containsKey("Strong Bleed"))&&debuff.equalsIgnoreCase("Strong Bleed"));


        if (bleedA)
        {
            if (b.Debuffs.containsKey("Bleed"))
            {
                b.Debuffs.remove("Bleed");
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Bleed"));
                return "Strong Bleed";
            }

            if (b.Debuffs.containsKey("Strong Bleed"))
            {
                b.Debuffs.remove("Strong Bleed");
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Strong_Bleed"));
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
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Bleed"));
                return "Hemorrhage";
            }

            if (b.Debuffs.containsKey("Strong Bleed"))
            {
                b.Debuffs.remove("Strong Bleed");
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Strong_Bleed"));
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
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Bleed"));
            }

            if (b.Debuffs.containsKey("Strong Bleed")) {
                b.Debuffs.remove("Strong Bleed");
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Strong_Bleed"));
            }
        }

        return debuff;
    }

    public static String freezeLogic (EnemyStats b, String debuff)
    {

        // make a new code snippit to calculate truth vs. having all this written out.
        boolean coldA = ((b.Debuffs.containsKey("Freeze")||b.Debuffs.containsKey("Chilled")||b.Debuffs.containsKey("Frozen"))&&debuff.equalsIgnoreCase("Freeze"));

        boolean coldB = ((b.Debuffs.containsKey("Freeze")||b.Debuffs.containsKey("Chilled")||b.Debuffs.containsKey("Frozen"))&&debuff.equalsIgnoreCase("Chilled"));


        if (coldA)
        {
            if (b.Debuffs.containsKey("Freeze"))
            {
                b.Debuffs.remove("Freeze");
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Freeze"));
                return "Chilled";
            }

            if (b.Debuffs.containsKey("Chilled"))
            {
                b.Debuffs.remove("Chilled");
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Chilled"));
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
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Freeze"));
                return "Frozen";
            }

            if (b.Debuffs.containsKey("Chilled"))
            {
                b.Debuffs.remove("Chilled");
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Chilled"));
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
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Freeze"));
                b.Debuffs.remove("Freeze");

            }

            if (b.Debuffs.containsKey("Chilled")) {
                b.enemyStatSubtract(possibleAttacksBeta.stringConversion("Chilled"));
                b.Debuffs.remove("Chilled");
            }
        }

        return debuff;
    }

    //add a case option for mage spells and or regular attacks?
    public static String stringConversion(String input)
    {
        if(input==null)
        {
            return null;
        }

        return input.replaceAll(" ", "_");
    }

    //make a string converter, converting the spaces to _
   // static LinkedHashMap<String, Attack> Options = new LinkedHashMap<>();

    //make an option to check enemy stats


    public static void playerAttack(Player player) {


        LinkedHashMap<String, Attack> Options = new LinkedHashMap<>();

        String Weapon = player.WornEquipment.get(stringConversion("Weapon"));
        String Bow = player.WornEquipment.get(stringConversion("Bow"));


        boolean choice = false;

        boolean choice2 = false;

        String option = "";
        String optionName = "";


        //eventually: instead of reading the whole enum, have a list of unlocked attacks.
        if (player.Options.isEmpty()) {
            for (String each : player.Attacks
            ) {

                player.Options.put("A" + (player.Options.size() + 1), Attack.valueOf(stringConversion(each)));
            }
//unsure if this works
            for (String each: player.gearAttacks)
            {
                if (!player.Options.containsValue(Attack.valueOf(stringConversion(each))))
                {
                    player.Options.put("A" + (player.Options.size() + 1), Attack.valueOf(stringConversion(each)));
                }
            }
        }


        System.out.println("CHOOSE YOUR ATTACK (LIKE A1)");
        System.out.println("YOU HAVE: " + player.cMANA + "/" + player.MANA + " MANA.");

        // HashSet<String> available = new HashSet<>();


        for (Map.Entry<String, Attack> each : player.Options.entrySet()
        ) {

            int CD = each.getValue().getCurrentCD();

            boolean cond = Condition.playerCondition(each.getValue().getCondition(), player);

            if (CD == 0 && each.getValue().getManaCost() <= player.cMANA && cond) {

                System.out.println(each.getKey() + " : " + each.getValue() + (each.getValue().getManaCost() > 0 ? " - Mana Cost: " + each.getValue().getManaCost() : ""));
                //available.add(each.getKey());

            } else if (each.getValue().getManaCost() > player.cMANA) {
                System.out.println(each.getKey() + " : " + each.getValue() + " (NOT ENOUGH MANA)");
            } else if (!cond) {
                System.out.println(each.getKey() + " : " + each.getValue() + " (CONDITION NOT MET)");
            } else {
                System.out.println(each.getKey() + " : " + each.getValue() + " (ON COOLDOWN FOR " + CD + (CD > 1 ? " TURNS)" : " TURN)"));
            }


        }
        System.out.println("Examine: Examine enemy stats/positions.");
        System.out.println("Exit");

        while (!choice) {

            try {
                // option =  stringConversion(Options.get(capitalizeWord.capItem( new Scanner(System.in).nextLine().trim())).getName());}

                option = capitalizeWord.capItem(new Scanner(System.in).nextLine().trim());
                optionName = stringConversion(player.Options.get(option).getName());

            } catch (Exception e) {

  /*  if (Objects.requireNonNull(option).length()>0) {

        if (!option.equalsIgnoreCase("exit")) {
            System.out.println("ERROR: Attack not found (remember A1/A2 are acceptable).");
        }
    }

   */

            }


            choice = player.Options.containsKey(option) && ((Attack.valueOf(optionName).getCurrentCD() == 0)) && Attack.valueOf(optionName).getManaCost() <= player.cMANA && Condition.playerCondition(Attack.valueOf(optionName).getCondition(), player);

            try {
                if (option.equalsIgnoreCase("EXIT")) {
                    System.out.println("You decide to do nothing.");
                    return;
                } else if (option.equalsIgnoreCase("examine")) {
                    enemyStatCheck.getStats();
                }
            } catch (Exception e) {
                System.out.println("You decide to do nothing.");
                return;
            }

            if (choice) {
                if (Attack.valueOf(optionName).getType().equalsIgnoreCase("SELF")) {
                    Attack b = Attack.valueOf(optionName);
                    String selfDebuff = b.getSelfDebuff();
                    if (!b.getBuff().equalsIgnoreCase("None")) {

                        if (!player.Buffs.containsKey(b.getBuff())) {
                            player.playerStatAdd(stringConversion(b.getBuff()));
                            System.out.println("You've been buffed with " + b.getName() + "!");
                        }
                        player.Buffs.put(b.getBuff(), b.getDuration());

                        player.getTemporaryWeakness().put(BuffEnum.valueOf(stringConversion(b.getBuff())).getWeakness(),b.getDuration());

                        player.getTemporaryResistances().put(BuffEnum.valueOf(stringConversion(b.getBuff())).getResistance(),b.getDuration());


                        if (!selfDebuff.equalsIgnoreCase("None")) {


                            if (!player.Debuffs.containsKey(selfDebuff)) {
                                player.playerStatAdd(possibleAttacksBeta.stringConversion(selfDebuff));
                                System.out.println("You suffer from " + selfDebuff + "!");
                            }

                            player.Debuffs.put(selfDebuff, b.getSelfDebuffDuration());

                            player.getTemporaryWeakness().put(BuffEnum.valueOf(stringConversion(b.getSelfDebuff())).getWeakness(),b.getSelfDebuffDuration());

                            player.getTemporaryResistances().put(BuffEnum.valueOf(stringConversion(b.getSelfDebuff())).getResistance(),b.getSelfDebuffDuration());
                        }

                    }


                    b.setCooldown();
                    player.cMANA -= b.getManaCost();
                    if (b.getSpecial()) {
                        playerSpec.special(b.getName(), player, b);
                    }

                    return;
                }

            } else if (!option.equalsIgnoreCase("EXAMINE")) {
                System.out.println(option + " is not available. Try another option");
            }
        }


        while (!choice2) {

            System.out.println("\n- - - ENEMIES IN RANGE - - -");

            // String finalOption = optionName;
            Attack a = Attack.valueOf(optionName);
            LinkedHashSet<String> targets = new LinkedHashSet<>();
            final int weaponDist;


            switch (a.getType()) {
                case "RANGE":
                    weaponDist = playerEquipment.Bow.valueOf(Bow).getDIST();
                    break;
                case "MELEE":
                    weaponDist = playerEquipment.Weapon.valueOf(Weapon).getDIST();
                    break;
                default:
                    weaponDist = 0;
                    break;

            }


            enemySpawner.Enemy.forEach((key, val) ->
            {
                //make three categories for attacks (RANGE, MAGE, MELEE)

                int[] P = player.coordinates; // using test coordinates
                int[] E = val.Coordinates;

                int difX = P[1] > E[1] ? P[1] - E[1] : E[1] - P[1];
                int difY = P[0] > E[0] ? P[0] - E[0] : E[0] - P[0];

                int dif = Math.max(difX, difY);







                  /*
                  if (dif <= val.DIST + GameEnums.Weapon.valueOf(Weapon).getDIST() );

                    {

                        available.add(val.Name);
                    }

                   */

       /* boolean choiceTwo = false;

        String yourChoice = "";

        while (!choiceTwo) {
            yourChoice = capitalizeWord.capItem(new Scanner(System.in).nextLine());
            choiceTwo = available.contains(yourChoice);
        }

        */


                //have it look at distance based on what im attacking with
                if (dif <= weaponDist + a.getDIST()) {


                    targets.add(key);
                    System.out.println(key + " : " + val.Name + "\nHP: " + val.getHP() + "\nLOCATION: " + Arrays.toString(val.getCoord()) + "\n- - - - - - - - - - - - - - - - -");


                }



/*
                    while (!choiceTwo)
                    {
                       String yourChoice = new Scanner(System.in).nextLine();
                       choiceTwo = available.contains(yourChoice);

                       if (choiceTwo)
                       {
                           System.out.println("PICK YOUR TARGET");

                       }

                    }
*/


            });
            //add an option for guard/for attack
            if (!targets.isEmpty()) {

                String targetinsight = "";
                boolean targetAcquired = false;

                while (!targetAcquired) {
                    System.out.println("PICK YOUR TARGET (Like E1) or EXIT to change target/attack!");
                    targetinsight = capitalizeWord.capItem(new Scanner(System.in).nextLine());
                    targetAcquired = targets.contains(targetinsight);
                    EnemyStats b = enemySpawner.Enemy.get(targetinsight);

                    if (targetAcquired) {

                        //after use it sets attack cooldown
                        a.setCooldown();
                        String debuff = a.getDebuff();
                        String buff = a.getBuff();
                        String bane = "none";

                        String selfDebuff = a.getSelfDebuff();

                        if (!buff.equalsIgnoreCase("None")) {
                            player.Buffs.put(buff, a.getDuration());

                            player.getTemporaryWeakness().put(BuffEnum.valueOf(stringConversion(buff)).getWeakness(),a.getDuration());

                            player.getTemporaryResistances().put(BuffEnum.valueOf(stringConversion(buff)).getResistance(),a.getDuration());



                            if (!player.Buffs.containsKey(buff)) {
                                player.playerStatAdd(possibleAttacksBeta.stringConversion(buff));
                                System.out.println("You've been buffed with" + buff + "!");
                            }
                        }

                        int[] P = player.coordinates;
                        int[] E = b.Coordinates;

                        int difX = P[1] > E[1] ? P[1] - E[1] : E[1] - P[1];
                        int difY = P[0] > E[0] ? P[0] - E[0] : E[0] - P[0];
                        int dif = Math.max(difX, difY);

                        player.cMANA -= a.getManaCost();

                        for (int i = 0; i < a.getCount(); i++) {
                            if (player.cHP<1)
                            {
                                enemyAttackBeta.endgame(player);
                                return;
                            }
                            int REFLECT = 0;
                            int ABSORP = 0;
                            int Damage = 0;
                            boolean primaryTarget = true;


                            if (a.getType().equalsIgnoreCase("MELEE") || a.getType().equalsIgnoreCase("RANGE") || a.getType().equalsIgnoreCase("MAGE") || a.getType().equalsIgnoreCase("SPECIAL")) {

if (a.getType().equalsIgnoreCase("MELEE")) {


                                bane = playerEquipment.Weapon.valueOf(player.WornEquipment.get("Weapon")).getBane();
                                Damage = calcDMG.MeleeDMG(a.getExtraCRIT(), a.getACCMod(), a.getCRITMOD(), new GrabStats(player), new GrabStats(b), a.getDMGMod());

                                REFLECT = b.REFLECT + b.TemporaryStats.get("REFLECT");
                                ABSORP = b.ABSORP + b.TemporaryStats.get("ABSORP");
                            } else if (a.getType().equalsIgnoreCase("RANGE")) {
    bane = playerEquipment.Bow.valueOf(player.WornEquipment.get("Bow")).getBane();
                                Damage = calcDMG.RangeDMG(a.getExtraCRIT(), a.getACCMod(), a.getCRITMOD(), new GrabStats(player), new GrabStats(b), a.getDMGMod(), dif);

                                REFLECT = b.REFLECT + b.TemporaryStats.get("REFLECT");
                                ABSORP = b.ABSORP + b.TemporaryStats.get("ABSORP");
                            } else if (a.getType().equalsIgnoreCase("MAGE")) {

                                Damage = calcDMG.MageDMG(a.getExtraCRIT(), a.getCRITMOD(), new GrabStats(player), new GrabStats(b), a.getDMGMod());
                                ABSORP = b.MAGEABSORP + b.TemporaryStats.get("MAGEABSORP");
                                REFLECT = b.MAGEREFLECT + b.TemporaryStats.get("MAGEREFLECT");
                            } else if (a.getType().equalsIgnoreCase("SPECIAL")) {
                                playerSpec.specDMG(a.getName(), player, b, a);
                            }

                            if (a.getSpecial()) {
                                playerSpec.special(a.getName(), player, b, a);
                            }

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
                                    dmgchange = - Damage/5;
                                }

                                if (b.getWeakness().contains(bane)||b.getTemporaryWeakness().containsKey(bane))
                                {
                                    dmgchange = Damage/5;
                                }

                                Damage+= dmgchange;
                            }


                            if (REFLECT > 0) {
                                player.cHP -= Damage*(REFLECT/100);
                                System.out.println("You take " + Damage*(REFLECT/100) + " recoil damage!");

                                if (player.cHP<1)
                                {
                                    enemyAttackBeta.endgame(player);
                                }

                                System.out.println("Remaining HP: " + player.cHP + ".");

                            }

                            if (ABSORP > 0) {
                                Damage = Damage - Math.min(((Damage * (ABSORP / 100))), ((int) (Damage * .9)));
                            }
                            //calculate stat bonuses based on debuffs/buffs later on :)
                            b.cHP -= Damage;

                            if (b.cHP > 0) {
                                System.out.println(b.Name + " has taken " + (Damage) + " Damage! "
                                        + b.cHP + " HP remains.");
                            } else if (b.cHP < 1) {
                                System.out.println(b.Name + " has taken " + (Damage) + " Damage and has perished!");
                                int[] coords = b.getCoord();

                                CombatMapC.combatMap[coords[0]][coords[1]] = "_";
                                enemySpawner.Enemy.remove(targetinsight);
                                primaryTarget = false;
                                if (!enemySpawner.Enemy.isEmpty() && i < a.getCount()) {

                                    for (String each : enemySpawner.Enemy.keySet()
                                    ) {

                                        EnemyStats enemy = enemySpawner.Enemy.get(each);

                                        E = enemy.getCoord();

                                        difX = P[1] > E[1] ? P[1] - E[1] : E[1] - P[1];
                                        difY = P[0] > E[0] ? P[0] - E[0] : E[0] - P[0];
                                        dif = Math.max(difX, difY);

                                        if (dif <= weaponDist + a.getDIST()) {
                                            b = enemy;
                                            if (i < a.getCount() - 1) {
                                                System.out.println("With the enemy dead, you swap targets!");
                                            }
                                            targetinsight = each;
                                            break;

                                        } else {
                                            break;
                                        }


                                    }


                                } else {
                                    break;
                                }
                            }

                            if (!primaryTarget) {
                                continue;
                            }


                            if (!debuff.equalsIgnoreCase("None")) {


                                double chance = Math.random() * a.getDebuffChance();

                                String debuffName = debuff;

                                if (!debuff.equals("Bleed") && !debuff.equals("Freeze") && !debuff.equals("Stun") && !debuff.equals("Acid") && !debuff.equals("Poison") && !debuff.equals("Burn")) {
                                    debuffName = "Debuff";
                                }

                                boolean resist = b.Buffs.containsKey(debuffName + " Resist");

                                //make a seperate enum for resistances based on the enemy

                                double resistSum = b.DebuffResists.get(debuffName) + b.TemporaryStats.get(debuffName) + (resist ? 100 : 0);

                                if (chance < resistSum) {
                                    System.out.println(b.Name + " managed to resist the " + debuff + "!");
                                    continue;
                                }

                                if (debuff.contains("Bleed") || debuff.contains("Strong Bleed") || debuff.contains("Hemorrhage")) {
                                    debuff = bleedLogic(b, debuff);
                                }

                                if (debuff.contains("Freeze") || debuff.contains("Chilled") || debuff.contains("Frozen")) {
                                    debuff = freezeLogic(b, debuff);
                                }

                                if (!b.Debuffs.containsKey(debuff)) {
                                    System.out.println(b.Name + " been struck by " + debuff + "!");
                                    b.enemyStatAdd(possibleAttacksBeta.stringConversion(debuff));
                                }
                                b.Debuffs.put(debuff, a.getDuration());
                                b.getTemporaryWeakness().put(BuffEnum.valueOf(stringConversion(debuff)).getWeakness(),a.getDuration());

                                b.getTemporaryResistances().put(BuffEnum.valueOf(stringConversion(debuff)).getResistance(),a.getDuration());

                            }
                        }


                        //make statement for reflect/absorp

              /*  if (enemySpawner.Enemy.get(targetinsight).cHP <= 0) {
                    System.out.println(b.Name + " has died!");
                    //void out the enemy position to a 0;
                    int[] coords = b.getCoord();

                    CombatMapC.combatMap[coords[0]][coords[1]] = "_";
                    enemySpawner.Enemy.remove(targetinsight);
                    return;
                }

               */


                    }

                    if (!selfDebuff.equalsIgnoreCase("None")) {


                        if (!player.Debuffs.containsKey(selfDebuff)) {
                            player.playerStatAdd(possibleAttacksBeta.stringConversion(selfDebuff));
                            System.out.println("You suffer from " + selfDebuff + "!");
                        }

                        player.Debuffs.put(selfDebuff, a.getSelfDebuffDuration());

                        player.getTemporaryWeakness().put(BuffEnum.valueOf(stringConversion(selfDebuff)).getWeakness(),a.getSelfDebuffDuration());

                        player.getTemporaryResistances().put(BuffEnum.valueOf(stringConversion(selfDebuff)).getResistance(),a.getSelfDebuffDuration());
                    }

                    choice2 = true;
                }


     else{

                    try {
                        assert targetinsight != null;
                        if (targetinsight.equalsIgnoreCase("EXIT") || targetinsight.equalsIgnoreCase("ELSE")) {
                            System.out.println("Alright well choose another move then.");
                            playerAttack(player);
                            return;
                        } else {
                            System.out.println("ERROR: Make sure the target format is E1/E2 for example.");
                        }

                    } catch (Exception e) {

                    }


                }
            }


        }

else
        {
            System.out.println("No targets in range. Choose a different move.\n");
            playerAttack(player);
            break;
        }



    /*Options.forEach((key, val) ->
            {
                System.out.println(val.getName() + " " + val.getCurrentCD());
                val.setCooldown(val.getCooldown());
                System.out.println(val.getName() + " " + val.getCurrentCD());

            }
    );

     */


}

                // System.out.println(Options.keySet());

            }

  /*  public static void main(String[] args) {

        Equipment.testRun();
        MainGame.coordinates = CombatMapC.mapRandomizePosition();
        spawnEnemyTwo.addEnemy(2);
        playerAttack();
    }


   */



    }



