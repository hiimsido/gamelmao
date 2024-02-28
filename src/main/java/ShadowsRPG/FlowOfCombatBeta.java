package ShadowsRPG;

import ShadowsRPG.Enums.Attack;
import ShadowsRPG.Enums.Enemies;
import ShadowsRPG.Enums.EnemyAttacks;
import ShadowsRPG.maps.CombatMapC;
import ShadowsRPG.maps.enemyMovementBeta;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class FlowOfCombatBeta {
    static LinkedHashMap<String, Integer> HoldEnemy = new LinkedHashMap<>();
    static LinkedHashMap<EnemyStats, int[]> HoldObject = new LinkedHashMap<>();

    static int objectSpawn = 0;


    public static void spawnEnemy() {


        Iterator<Map.Entry<String, Integer>> spawn = HoldEnemy.entrySet().iterator();
        while (spawn.hasNext()) {

            String type = spawn.next().getKey();
            int num = HoldEnemy.get(type);
            enemySpawner.addReinforcements(num, type);

            spawn.remove();
        }
    }

    public static void spawnObject() {

        Iterator<Map.Entry<EnemyStats, int[]>> spawn = HoldObject.entrySet().iterator();
        while (spawn.hasNext()) {
            EnemyStats e = spawn.next().getKey();
            int[] num = HoldObject.get(e);
            enemySpawner.generateObject(num, e);

            spawn.remove();
        }

    }


    //include armor stats for calculations :)

    public static void timeout() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    //add a repeat option/cooldown option in the flow of combat thing

    public static void main(String[] args) {

        Player player = new Player();

        System.out.println("Pick your class of choice");
        System.out.println("Options:");


        String choice = "";

        ArrayList<String> choices = new ArrayList<>();

        choices.add("knight");
        choices.add("initiate");
        choices.add("archer");
        choices.add("mager");
        choices.add("bulwark");
        choices.add("pyroknight");

        for (String each : choices
        ) {
            System.out.println(each);
        }

        while (!choices.contains(choice)) {
            Scanner scan = new Scanner(System.in);

            choice = scan.next().toLowerCase();
        }


        ClassStart.START(choice, player);

        CombatMapC.mapInitiate();
        CombatMapC.randomizeMap();
        player.coordinates = CombatMapC.mapRandomizePosition();
        player.calcGear();
        player.statCalc();
        enemySpawner.addBoss(1);
        enemySpawner.addEnemy(3);


        while (!enemySpawner.Enemy.isEmpty() && player.cHP > 0) {
            if (!player.Debuffs.containsKey("Stun") && !player.Debuffs.containsKey("Frozen")) {
//player movement
                if (!player.Debuffs.containsKey("Immobile")) {
                    player.coordinates = CombatMapC.playermapStart((int) ((player.cAGIL + player.TemporaryStats.get("AGIL")) * (1 + player.TemporaryMultiplier.get("AGILmod"))), "none", player.coordinates);
                } else {
                    System.out.println("You are immobile and cannot move!");
                }
                timeout();
//player attack
                possibleAttacksBeta.playerAttack(player);
                timeout();
            }

            if (!player.Debuffs.isEmpty()) {

                DeBuffs.debuff(player);
            }

            if (!player.Buffs.isEmpty()) {

                DeBuffs.buff(player);

            }

            if (!player.getTemporaryWeakness().isEmpty()||!player.getTemporaryResistances().isEmpty())
            {
                WeakRes.player(player);
            }


            if (player.cHP <= 0) {
                enemyAttackBeta.endgame(player);
            }

            player.cMANA = Math.min(player.MANA, player.cMANA + (player.MANA / 10));

            for (Map.Entry<String, Attack> each : player.Options.entrySet()
            ) {


                each.getValue().reduceCooldown();


            }


            Iterator<Map.Entry<String, EnemyStats>> iterator = enemySpawner.Enemy.entrySet().iterator();

            while (iterator.hasNext()) {




                EnemyStats val = iterator.next().getValue();
                if (!val.StoredExtraCondition.isEmpty())
                {
                    Iterator<String> removerator = val.StoredExtraCondition.iterator();

                    while (removerator.hasNext()){

                        String test = removerator.next();
                        val.ExtraCondition.add(test);
                        removerator.remove();
                }
                }


                if (val.cHP < 1) {

                    System.out.println(val.Name + " has perished!");
                    int[] coord = val.Coordinates;

                    if (enemyMovementBeta.enemyInitials(val.Name).equalsIgnoreCase(CombatMapC.combatMap[coord[0]][coord[1]])) {
                        CombatMapC.combatMap[coord[0]][coord[1]] = "_";

                    } else if ((CombatMapC.combatMap[coord[0]][coord[1]]).equalsIgnoreCase("#")) {
                        CombatMapC.combatMap[coord[0]][coord[1]] = "_";
                    }
                    iterator.remove();
                    continue;

                }

                if (val.getType().equalsIgnoreCase("Object")) {
                    continue;
                }


//movement
                if (!val.Debuffs.containsKey("Stun") && !val.Debuffs.containsKey("Frozen")) {

                    if (!val.Debuffs.containsKey("Immobile")&&!val.ExtraCondition.contains("Rest")) {
                        val.Coordinates = enemyMovementBeta.enemymapStart((int) ((val.AGIL + val.TemporaryStats.get("AGIL")) * (1 + val.TemporaryMultiplier.get("AGILmod"))), "none", val.getCoord(), val.getAI(), val.DIST, val.Name, player, val);
                        System.out.println(val.Name + " Has moved to " + Arrays.toString(val.Coordinates));
                    }

                    else if (val.ExtraCondition.contains("Rest"))
                    {
                        System.out.println(val.Name + " rests from movement for a turn.");
                    }

                    else {
                        System.out.println(val.Name + " is immobilized and cannot move!");
                    }
                    timeout();


                    //attack
                    for (int i = 0; i < 1 + val.getDUR(); i++) {

                        enemyAttackBeta.enemyStrikeBeta(val.Coordinates, val, val.CRIT, val.ATK, val.RNG, val.MAGE, val.DIST, val.getAttacks(), val.Name, player);

                    }


                    //reduce atk cooldowns for enemy


                }

                for (EnemyAttacks each : val.getAttacks().keySet()
                ) {

                    int test = val.getAttacks().get(each);

                    if (test != 0) {
                        val.getAttacks().put(each, test - 1);
                    }


                }
                if (!val.Debuffs.isEmpty()) {

                    DeBuffs.enemydebuff(val);
                }

                if (!val.Buffs.isEmpty()) {
                    DeBuffs.enemybuff(val);
                }

                if (!val.getTemporaryWeakness().isEmpty()||!player.getTemporaryResistances().isEmpty())
                {
                    WeakRes.enemy(val);
                }

                if (val.cHP < 1) {

                    System.out.println(val.Name + " has perished!");
                    int[] coord = val.Coordinates;
                    CombatMapC.combatMap[coord[0]][coord[1]] = "_";
                    iterator.remove();

                }


                Iterator<String> deleterator = val.ExtraCondition.iterator();

                while (deleterator.hasNext())
                {
                    deleterator.next();
                    deleterator.remove();
                }

            }


            Iterator<Map.Entry<String, EnemyStats>> purgeDead = enemySpawner.Enemy.entrySet().iterator();
            while (purgeDead.hasNext()) {
                EnemyStats val = purgeDead.next().getValue();

                if (val.cHP < 1) {
                    System.out.println(val.Name + " has perished!");
                    int[] coord = val.Coordinates;
                    if (enemyMovementBeta.enemyInitials(val.Name).equalsIgnoreCase(CombatMapC.combatMap[coord[0]][coord[1]])) {
                        CombatMapC.combatMap[coord[0]][coord[1]] = "_";
                    } else if ((CombatMapC.combatMap[coord[0]][coord[1]]).equalsIgnoreCase("#")) {
                        CombatMapC.combatMap[coord[0]][coord[1]] = "_";
                    }
                    purgeDead.remove();
                }
            }

            if (HoldEnemy.size() > 0) {
                spawnEnemy();
            }

            if (objectSpawn > 0) {
                int pX = player.coordinates[1];
                int pY = player.coordinates[0];

                System.out.println("The stomp causes debris to drop around you!");

                ArrayList<int[]> idealspawns = new ArrayList<>();
                ArrayList<int[]> spawns = new ArrayList<>();
                int y = 0;
                for (String[] letter : CombatMapC.combatMap
                ) {


                    for (int i = 0; i < letter.length; i++) {
                        if (letter[i].equalsIgnoreCase("_")) {
                            int diffX = pX > i ? pX - i : i - pX;
                            int diffY = pY > y ? pY - y : y - pY;

                            int dif = Math.max(diffX, diffY);

                            if (dif == 1) {
                                idealspawns.add(new int[]{y, i});
                            } else {
                                spawns.add(new int[]{y, i});
                            }
                        }

                    }
                    y++;
                }

                int boulderSpawn = objectSpawn;


                for (int i = 0; i < boulderSpawn; i++) {

                    if (idealspawns.size() > 0) {

                        if (idealspawns.size() == 1) {
                            FlowOfCombatBeta.HoldObject.put(new EnemyStats(Enemies.Boulder), idealspawns.remove(0));
                        } else {
                            FlowOfCombatBeta.HoldObject.put(new EnemyStats(Enemies.Boulder), idealspawns.remove((int) (Math.random() * idealspawns.size())));
                        }
                    } else {

                        FlowOfCombatBeta.HoldObject.put(new EnemyStats(Enemies.Boulder), spawns.remove((int) (Math.random() * spawns.size())));

                    }
                }


                if (HoldObject.size() > 0) {
                    spawnObject();
                    objectSpawn = 0;
                }


            }
        }

        //similar to RS, have it run X actions in an order.
    /*
    cycle debuff/buffs
    player move turn/item use turn/potentially a buff spell turn...?
    player attack/guard turn



    cycle debuff/buffs
    enemy move turn/item use turn/buff spell turn...?
    enemy attack/guard turn/spell turn

    repeat until either player HP is 0 or enemy map is empty.
     */
    }
}