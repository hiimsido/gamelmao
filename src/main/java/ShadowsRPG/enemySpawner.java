package ShadowsRPG;

import ShadowsRPG.Enums.Enemies;
import ShadowsRPG.Enums.playerEquipment;
import ShadowsRPG.maps.CombatMapC;

import java.util.Arrays;
import java.util.LinkedHashMap;


public class enemySpawner {

    public static LinkedHashMap<String, EnemyStats> Enemy = new LinkedHashMap<>();

    public static void addEnemy(int i
    ) {

        for (int j = 0; j < i; j++) {


            rngTable<String> enemyGenerator = new rngTable<>();

            for (Enemies each : Enemies.values()
            ) {

                if (!each.getATRI().equalsIgnoreCase("BOSS")) {

                    enemyGenerator.add(each.getWeighting(), possibleAttacksBeta.stringConversion(each.getName()));
                }

            }

            EnemyStats E = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
            for (int k = 0; k < 10; k++) {

                if (Enemy.size() >= 10) {
                    System.out.println("Too many enemies present.");
                    return;
                } else {

                    String enemyKey = "E" + (1 + k);
                    E.setID((enemyKey));

                    if (!Enemy.containsKey(enemyKey)) {
                        Enemy.put(enemyKey, E);
                        break;
                    }


                }

            }

/*

            if (!Enemy.containsKey("E1")) {
                EnemyStats E1 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E1", E1);
            } else if (!Enemy.containsKey("E2")) {
                EnemyStats E2 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E2", E2);
            } else if (!Enemy.containsKey("E3")) {
                EnemyStats E3 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E3", E3);
            } else if (!Enemy.containsKey("E4")) {
                EnemyStats E4 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E4", E4);
            } else if (!Enemy.containsKey("E5")) {
                EnemyStats E5 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E5", E5);
            }

            */


            //test thing lmao


        }


    }

    public static void addBoss(int i
    ) {

        for (int j = 0; j < i; j++) {


            rngTable<String> enemyGenerator = new rngTable<>();

            for (Enemies each : Enemies.values()
            ) {

                if (each.getATRI().equalsIgnoreCase("BOSS")) {

                    enemyGenerator.add(each.getWeighting(), possibleAttacksBeta.stringConversion(each.getName()));
                }

            }

            EnemyStats E = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
            for (int k = 0; k < 10; k++) {

                if (Enemy.size() >= 10) {
                    System.out.println("Too many enemies present.");
                    return;
                } else {

                    String enemyKey = "E" + (1 + k);
                    E.setID((enemyKey));

                    if (!Enemy.containsKey(enemyKey)) {
                        Enemy.put(enemyKey, E);
                        break;
                    }


                }

            }

/*

            if (!Enemy.containsKey("E1")) {
                EnemyStats E1 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E1", E1);
            } else if (!Enemy.containsKey("E2")) {
                EnemyStats E2 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E2", E2);
            } else if (!Enemy.containsKey("E3")) {
                EnemyStats E3 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E3", E3);
            } else if (!Enemy.containsKey("E4")) {
                EnemyStats E4 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E4", E4);
            } else if (!Enemy.containsKey("E5")) {
                EnemyStats E5 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E5", E5);
            }

            */


            //test thing lmao


        }


    }

    public static void addReinforcements(int i, String type
    ) {

        for (int j = 0; j < i; j++) {


            rngTable<String> enemyGenerator = new rngTable<>();

            for (Enemies each : Enemies.values()
            ) {

                if (each.getType().equalsIgnoreCase(type) && !each.getATRI().equalsIgnoreCase("BOSS")) {

                    enemyGenerator.add(each.getWeighting(), possibleAttacksBeta.stringConversion(each.getName()));
                }

            }

            EnemyStats E = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
            for (int k = 0; k < 10; k++) {

                if (Enemy.size() >= 10) {
                    System.out.println("Too many enemies present.");
                    return;
                } else {

                    String enemyKey = "E" + (1 + k);
                    E.setID((enemyKey));

                    if (!Enemy.containsKey(enemyKey)) {
                        Enemy.put(enemyKey, E);
                        break;
                    }


                }

            }

/*

            if (!Enemy.containsKey("E1")) {
                EnemyStats E1 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E1", E1);
            } else if (!Enemy.containsKey("E2")) {
                EnemyStats E2 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E2", E2);
            } else if (!Enemy.containsKey("E3")) {
                EnemyStats E3 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E3", E3);
            } else if (!Enemy.containsKey("E4")) {
                EnemyStats E4 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E4", E4);
            } else if (!Enemy.containsKey("E5")) {
                EnemyStats E5 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E5", E5);
            }

            */


            //test thing lmao


        }


    }

    public static void generateObject(int[] i, EnemyStats name
    ) {

        int[] oldcoord = name.getCoord();
        name.setCoord(i);

        CombatMapC.combatMap[oldcoord[0]][oldcoord[1]] = "_";
        String enemyKey = "E" + (1+ Enemy.size());
        name.setID((enemyKey));

        CombatMapC.combatMap[i[0]][i[1]] = "#";

        if (!Enemy.containsKey(enemyKey)) {
            Enemy.put(enemyKey, name);
        }



/*

            if (!Enemy.containsKey("E1")) {
                EnemyStats E1 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E1", E1);
            } else if (!Enemy.containsKey("E2")) {
                EnemyStats E2 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E2", E2);
            } else if (!Enemy.containsKey("E3")) {
                EnemyStats E3 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E3", E3);
            } else if (!Enemy.containsKey("E4")) {
                EnemyStats E4 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E4", E4);
            } else if (!Enemy.containsKey("E5")) {
                EnemyStats E5 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E5", E5);
            }

            */


            //test thing lmao



        }




    public static void addReinforcementsTest(int i, String type
    ){

        for (int j = 0; j < i; j++) {



            rngTable<String> enemyGenerator = new rngTable<>();

            for ( Enemies each: Enemies.values()
            ) {

                if(each.getType().equalsIgnoreCase(type)&&!each.getATRI().equalsIgnoreCase("BOSS")) {

                    enemyGenerator.add(each.getWeighting(), possibleAttacksBeta.stringConversion(each.getName()));
                }

            }

            EnemyStats E = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
            for (int k = 0; k < 10; k++) {

                if (Enemy.size()>=10)
                {
                    System.out.println("Too many enemies present.");
                    return;
                }

                else{

                    String enemyKey = "E" + (1+k);

                    if (!Enemy.containsKey(enemyKey))
                    {
                        Enemy.put(enemyKey,E);
                        break;
                    }



                }

            }

/*

            if (!Enemy.containsKey("E1")) {
                EnemyStats E1 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E1", E1);
            } else if (!Enemy.containsKey("E2")) {
                EnemyStats E2 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E2", E2);
            } else if (!Enemy.containsKey("E3")) {
                EnemyStats E3 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E3", E3);
            } else if (!Enemy.containsKey("E4")) {
                EnemyStats E4 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E4", E4);
            } else if (!Enemy.containsKey("E5")) {
                EnemyStats E5 = new EnemyStats(Enemies.valueOf(enemyGenerator.next()));
                Enemy.put("E5", E5);
            }

            */


            //test thing lmao



        }


    }


    public void deleteEnemy(){

    }


    public static void runSpawn() {

        addEnemy(2);

        String Nombre = "Rogue"; //do a random number thing to determine NPC to spawn
        String Nombre2 = "Goblin";
        int[] coordinates = {0,0};

//for enemy spawner throw in an E when it spawns an enemy :)



        System.out.println(Enemy.keySet());

        for (EnemyStats each: Enemy.values()
             ) {
            System.out.println(each);
            System.out.println(each.HP);
            System.out.println(each.Name);
            System.out.println(Arrays.toString(each.getCoord()));
        }



        //figure out how to get the value of x Enemy




    }

    public static void main(String[] args) {
        runSpawn();
        System.out.println(Arrays.toString(playerEquipment.Head.values()));
    }





//could redo a lot of the store code using values enum method
//consider changing the way hashmap works into EnemyName + coordinates, but would need to store the stats.




}
