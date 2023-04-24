package ShadowsRPG;

import java.util.concurrent.ThreadLocalRandom;

public class calcDMG {

    public static int MeleeDMG(int critChance, int ATK, int DEF, int AGIL, float ABSORP, String[] debuff, String[] buff) {

        //roll accuracy

        int accChance = (int)((float)ATK - (float)(AGIL/4) + 5);

        if (Math.random()*101>accChance)
        {
            System.out.println("The attack missed it's mark!");
            return 0;
        }





        //calculating damage

        int CalculatedDamage = 0;



        int critRoll = ThreadLocalRandom.current().nextInt(0, 101);




        if (critRoll>critChance) { // calculating player damage

            int PlayerATKVar = ThreadLocalRandom.current().nextInt(ATK - (ATK/10), ATK + (ATK/10)); //randomized damage variance range of 10%

            CalculatedDamage = PlayerATKVar / (DEF / 4);
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");

            if (ABSORP>0)
            {
                CalculatedDamage = CalculatedDamage - (int)(CalculatedDamage * ABSORP);
            }
        }

        else { //crit calculation, penetrates through absorption

            CalculatedDamage = ThreadLocalRandom.current().nextInt(ATK + (ATK/2), ATK*2);
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");
            System.out.println("Critical Hit!");

        }





        return CalculatedDamage;
    }

    public static int RangeDMG(int critChance, int RNG, int DEF, int AGIL, int DIST, float ABSORP, String[] debuff, String[] buff) {

// roll accuracy

        int accChance = (int)((float)RNG - (float)AGIL/6) - DIST*4 + 5;

        if (Math.random()*101>accChance)
        {
            System.out.println("The attack missed it's mark!");
            return 0;
        }

        int CalculatedDamage = 0;



        int critRoll = ThreadLocalRandom.current().nextInt(0, 101);




        if (critRoll>critChance) { // calculating player damage

            int PlayerATKVar = ThreadLocalRandom.current().nextInt(RNG - (RNG/10), RNG + (RNG/10)); //randomized damage variance range of 10%

            CalculatedDamage = PlayerATKVar / (DEF / 4);
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");

            if (ABSORP>0)
            {
                CalculatedDamage = CalculatedDamage - (int)(CalculatedDamage * ABSORP);
            }
        }

        else { //crit calculation, penetrates through absorption

            CalculatedDamage = ThreadLocalRandom.current().nextInt(RNG + (RNG/2), RNG*2);
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");
            System.out.println("Critical Hit!");

        }





        return CalculatedDamage;
    }

    public static int MageDMG(int critChance, int MAGE, int enemyMAGE, int AGIL, String[] debuff, String[] buff) {

//mage never misses, nor does it worry about absorption

        int CalculatedDamage = 0;



        int critRoll = ThreadLocalRandom.current().nextInt(0, 101);




        if (critRoll>critChance) { // calculating player damage

            int PlayerATKVar = ThreadLocalRandom.current().nextInt(MAGE - (MAGE/10), MAGE + (MAGE/10)); //randomized damage variance range of 10%

            CalculatedDamage = PlayerATKVar / (enemyMAGE/2);
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");


        }

        else { //crit calculation

            CalculatedDamage = ThreadLocalRandom.current().nextInt(MAGE + (MAGE/2), MAGE*2);
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");
            System.out.println("Critical Hit!");

        }





        return CalculatedDamage;
    }
}
