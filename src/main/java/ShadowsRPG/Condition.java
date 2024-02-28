package ShadowsRPG;

import ShadowsRPG.Enums.EnemyAttacks;

public class Condition {

    public static boolean playerCondition(String condition, Player player){

        if (condition.equalsIgnoreCase("None"))
        {
            return true;
        }

        if (condition.equalsIgnoreCase("Archers Focus"))
        {
            return player.Buffs.containsKey("Archers Focus");
        }

        if (condition.equalsIgnoreCase("Arrow"))
        {
            return  player.WornEquipment.get("Arrows").toLowerCase().contains("arrow");
        }

        return false;
    }

   public static boolean Condition (String condition, int[] E, int dist, EnemyStats B, Player player, String Buff, String Debuff, String SelfDebuff)

    {

        if (condition.equalsIgnoreCase("None"))
        {
            return true;
        }

        else if (condition.equalsIgnoreCase("No Debuff"))
        {
            return !player.Debuffs.containsKey(Debuff);
        }

        else if (condition.equalsIgnoreCase("Frozen"))
        {
            return player.Debuffs.containsKey("Frozen");
        }

        else if (condition.equalsIgnoreCase("Berserk")) {
            return B.Buffs.containsKey("Berserk");

        }

        else if (condition.equalsIgnoreCase("Demonic Rage")) {
            return B.Buffs.containsKey("Demonic Rage");

        }

        else if (condition.equalsIgnoreCase("Bulwark Stance")) {
            int[] P = player.coordinates;

            int difX = P[1] > E[1] ? P[1] - E[1] : E[1] - P[1];
            int difY = P[0] > E[0] ? P[0] - E[0] : E[0] - P[0];


            int dif = Math.max(difX, difY);



            return (dif==1)&&!B.Buffs.containsKey("Enrage");
        }

        else if (condition.equalsIgnoreCase("Bulwark Charge")) {
            int[] P = player.coordinates;
            boolean MapPosition = E[0]==P[0]||E[1]==P[1];
           // B.setAttackCooldown("Bulwark_Roar",4);

            return ((B.Debuffs.containsKey("Immobile")||B.ExtraCondition.contains("Rest"))&&MapPosition);

        }

        else if (condition.equalsIgnoreCase("Immobile"))
        {
            return (B.Debuffs.containsKey("Immobile"));
        }

        else if (condition.equalsIgnoreCase("Roar"))
        {
            return (B.Debuffs.containsKey("Immobile")||B.ExtraCondition.contains("Rest"));
        }



        else if (condition.equalsIgnoreCase("Max Distance"))

        {



            int[] P = player.coordinates;

            int difX = P[1] > E[1] ? P[1] - E[1] : E[1] - P[1];
            int difY = P[0] > E[0] ? P[0] - E[0] : E[0] - P[0];


            int dif = Math.max(difX, difY);

            return dif == dist;


        }

        else if (condition.equalsIgnoreCase("Loaded"))
        {


            int[] P = player.coordinates;

            int difX = P[1] > E[1] ? P[1] - E[1] : E[1] - P[1];
            int difY = P[0] > E[0] ? P[0] - E[0] : E[0] - P[0];


            int dif = Math.max(difX, difY);
            boolean ready =  (B.Buffs.containsKey("Loaded"))&&(dif==dist);
            if (ready){
                B.Buffs.remove("Loaded");
                B.enemyStatSubtract("Loaded");
            }
            return ready;


        }

        else if (condition.equalsIgnoreCase("Catapult"))
        {


            int[] P = player.coordinates;

            int difX = P[1] > E[1] ? P[1] - E[1] : E[1] - P[1];
            int difY = P[0] > E[0] ? P[0] - E[0] : E[0] - P[0];


            int dif = Math.max(difX, difY);
            boolean ready =  (B.Buffs.containsKey("Loaded"))&&(dif>1);
            if (ready){
                B.Buffs.remove("Loaded");
                B.enemyStatSubtract("Loaded");
            }
            return ready;


        }

        else if (condition.equalsIgnoreCase("Line Of Sight"))
        {

            // for boss, do it on turn it is immobile.

            int[] P = player.coordinates;

           return (E[0]==P[0]||E[1]==P[1]);





        }

        else if (condition.equalsIgnoreCase("RoarCD"))
        {
            for (EnemyAttacks each : B.getAttacks().keySet()
            ) {

                if (each.name().equalsIgnoreCase("Bulwark Roar"));
                {
                    return (each.getCurrentCD()>0);
                }


            }
            return false;
        }

        else if (condition.equalsIgnoreCase("SELF"))
        {

            return !B.Buffs.containsKey(condition)||!B.Debuffs.containsKey(condition);





        }

        if (condition.equalsIgnoreCase("Consume"))
        {
            boolean eat = false;

            String target = "";

            for (String EnemyName: enemySpawner.Enemy.keySet()
            ) {

                EnemyStats e2 = enemySpawner.Enemy.get(EnemyName);
                int dif;
                if (e2 != B)

                {

                    if (e2.cHP<B.ATK&&e2.cHP>0) {

                        int diffX = e2.Coordinates[1] > B.Coordinates[1] ? e2.Coordinates[1] - B.Coordinates[1] : B.Coordinates[1] - e2.Coordinates[1];
                        int diffY = e2.Coordinates[0] > B.Coordinates[0] ? e2.Coordinates[0] - B.Coordinates[0] : B.Coordinates[0] - e2.Coordinates[0];

                        dif = Math.max(diffX, diffY);
                        if (dif==1)
                        {
                            target = EnemyName;
                            eat = true;
                            break;
                        }
                    }
                }


                if (eat)
                {
                    break;
                }




            }

            if (eat)
            {
                System.out.println("The Ogre's cravings overtake him! He consumes the " + enemySpawner.Enemy.get(target).Name + "!");
                B.cHP = Math.min(B.cHP + enemySpawner.Enemy.get(target).cHP , B.HP);
                enemySpawner.Enemy.get(target).cHP = 0;
                System.out.println("The Ogre has " + B.cHP + "HP.");
                return true;
            }

        }

        else if (condition.equalsIgnoreCase("Allies"))
        {
            int allycount = 0;

            for (EnemyStats each: enemySpawner.Enemy.values()
                 ) {

                if (each!=B)
                {
                    if (each.getType().equalsIgnoreCase(B.getType()))
                    {
                        allycount++;
                    }
                }

            }
            return allycount>0;
        }


        else if (condition.equalsIgnoreCase("No Allies"))
        {
            int allycount = 0;

            for (EnemyStats each: enemySpawner.Enemy.values()
            ) {

                if (each!=B)
                {
                    if (each.getType().equalsIgnoreCase(B.getType()))
                    {
                        allycount++;
                    }
                }

            }
            return allycount<1;
        }

        else if (condition.equalsIgnoreCase("Reload")){

            return B.Debuffs.containsKey("Reload")||!B.Buffs.containsKey("Loaded");

        }

        else if (condition.equalsIgnoreCase("Projectile In Air")){

            return B.formerPlayerLoc != null;
        }

        else if (condition.equalsIgnoreCase("Resting"))
        {
            return B.ExtraCondition.contains("Rest");
        }






        else
        {
            return B.Buffs.containsKey(condition)||B.Debuffs.containsKey(condition);
        }

        return false;
    }

}

