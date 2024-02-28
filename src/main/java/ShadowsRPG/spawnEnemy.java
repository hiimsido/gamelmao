package ShadowsRPG;

import ShadowsRPG.Enums.Enemies;

import java.util.LinkedHashMap;


public class spawnEnemy {

    static LinkedHashMap<EnemyStats,int[]> Enemy = new LinkedHashMap<>();

    public void addEnemy(){

    }

    public void deleteEnemy(){

    }


    public static void main(String[] args) {
//make randomizer to decide which enemy to spawn
        String Nombre = "Rogue";
        String Nombre2 = "Goblin";
        EnemyStats stats = new EnemyStats(Enemies.valueOf(Nombre));
        EnemyStats renegame = new EnemyStats(Enemies.valueOf(Nombre));
        Enemy.put(stats,stats.Coordinates);
        Enemy.put(renegame, renegame.Coordinates);

        System.out.println(Enemy.keySet());

        for (EnemyStats each: Enemy.keySet()
             ) {
            System.out.println(each.HP);

            each.setHP(20);
        }


        System.out.println(stats.HP);
        int zero = 1;
    }





//could redo a lot of the store code using values enum method
//consider changing the way hashmap works into EnemyName + coordinates, but would need to store the stats.




}
