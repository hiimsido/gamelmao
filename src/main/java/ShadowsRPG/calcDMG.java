package ShadowsRPG;

import java.util.concurrent.ThreadLocalRandom;

public class calcDMG {

    //adjust how defense protects against damage?
    //add accuracy modifier in the future



    public static int MeleeDMG(int critChance, double accMod, double critMod, GrabStats user, GrabStats target, double dmgMOD ) {

        int ATK = user.ATK;
        int DEF = target.DEF;
        int CRIT = critChance + user.CRIT;
      //  int ABSORP = target.ABSORP;
        int DODGE = target.DODGE;
        critMod = critMod * (1 + user.addedmods.get("CRITmod"));

        //roll accuracy
        if (Math.random()*ATK*accMod<(DODGE)*Math.random())
        {
            System.out.println("The attack missed it's mark!");
            return 0;
        }




        //calculating damage

        int CalculatedDamage = 0;



        int critRoll = ThreadLocalRandom.current().nextInt(0, 101);




        if (critRoll>CRIT) { // calculating player damage

            ATK = Math.max(ATK, 10);

            int ATKVar = ThreadLocalRandom.current().nextInt(ATK - (ATK/10), ATK + 1+(ATK/10)); //randomized damage variance range of 10%

            //  CalculatedDamage = ATKVar / (DEF / 20); old way of calcing damage

            CalculatedDamage = Math.max((ATKVar - (DEF/2)),(int)(ATKVar*.2));
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");

         /*   if (ABSORP>0)
            {
                CalculatedDamage = CalculatedDamage - Math.min( ((CalculatedDamage * (ABSORP/100))), ((int)(CalculatedDamage*.9)));
            }


          */
        }

        else {
            ATK = Math.max(ATK, 10);

            CalculatedDamage = ThreadLocalRandom.current().nextInt((int)((ATK*critMod)*1.25), (int)((ATK*critMod)*1.5)+5);

         /*   if (ABSORP>0)
            {
                CalculatedDamage = CalculatedDamage - Math.min( ((CalculatedDamage * (ABSORP/100))), ((int)(CalculatedDamage*.9)));
            }

          */
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");
            System.out.println("Critical Hit!");

        }






        return Math.max(1,(int)(CalculatedDamage*dmgMOD));
    }

    public static int RangeDMG(int critChance, double accMod, double critMod, GrabStats user, GrabStats target, double dmgMOD, int DIST ) {

        int ATK = user.RANGE;
        int DEF = target.DEF;
        int CRIT = critChance + user.CRIT;
      //  int ABSORP = target.ABSORP;
        int DODGE = target.DODGE;
        critMod = critMod * (1 + user.addedmods.get("CRITmod"));

        //roll accuracy
        if ((Math.random()*ATK*accMod)/(DIST == 1 ? 1 : 1 + (double)DIST /2)<(DODGE)*Math.random())
        {
            System.out.println("The attack missed it's mark!");
            return 0;
        }




        //calculating damage

        int CalculatedDamage = 0;



        int critRoll = ThreadLocalRandom.current().nextInt(0, 101);




        if (critRoll>CRIT) { // calculating player damage

            ATK = Math.max(ATK, 10);

            int ATKVar = ThreadLocalRandom.current().nextInt(ATK - (ATK/10), ATK + 1+(ATK/10)); //randomized damage variance range of 10%

            //  CalculatedDamage = ATKVar / (DEF / 20); old way of calcing damage

            CalculatedDamage = Math.max((ATKVar - (DEF/2)),(int)(ATKVar*.2));
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");
/*
            if (ABSORP>0)
            {
                CalculatedDamage = CalculatedDamage - Math.min( ((CalculatedDamage * (ABSORP/100))), ((int)(CalculatedDamage*.9)));
            }

 */
        }

        else {
            ATK = Math.max(ATK, 10);

            CalculatedDamage = ThreadLocalRandom.current().nextInt((int)((ATK*critMod)*1.25), (int)((ATK*critMod)*1.5)+5);
/*
            if (ABSORP>0)
            {
                CalculatedDamage = CalculatedDamage - Math.min( ((CalculatedDamage * (ABSORP/100))), ((int)(CalculatedDamage*.9)));
            }

 */
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");
            System.out.println("Critical Hit!");

        }






        return Math.max(1,(int)(CalculatedDamage*dmgMOD));
    }

    public static int MageDMG(int critChance, double critMod, GrabStats user, GrabStats target, double dmgMOD) {

        int ATK = user.MAGE;
        int DEF = target.MAGE;
        int CRIT = critChance + user.CRIT;
        critMod = critMod * (1 + user.addedmods.get("CRITmod"));
       // int ABSORP = target.MAGEABSORP;





        //calculating damage

        int CalculatedDamage = 0;



        int critRoll = ThreadLocalRandom.current().nextInt(0, 101);




        if (critRoll>CRIT) { // calculating player damage

            ATK = Math.max(ATK, 10);

            int ATKVar = ThreadLocalRandom.current().nextInt(ATK - (ATK/10), ATK + 1 + (ATK/10)); //randomized damage variance range of 10%

            //  CalculatedDamage = ATKVar / (DEF / 20); old way of calcing damage

            CalculatedDamage = Math.max((ATKVar - (DEF/2)),(int)(ATKVar*.2));
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");
/*
            if (ABSORP>0)
            {
                CalculatedDamage = CalculatedDamage - Math.min( ((CalculatedDamage * (ABSORP/100))), ((int)(CalculatedDamage*.9)));
            }

 */
        }

        else {

            ATK = Math.max(ATK, 10);

            CalculatedDamage = ThreadLocalRandom.current().nextInt((int)((ATK*critMod)*1.25), (int)((ATK*critMod)*1.5)+5);
/*
            if (ABSORP>0)
            {
                CalculatedDamage = CalculatedDamage - Math.min( ((CalculatedDamage * (ABSORP/100))), ((int)(CalculatedDamage*.9)));
            }

 */
            //System.out.println(CalculatedDamage + " Calculated DMG Post Variance");
            System.out.println("Critical Hit!");

        }






        return Math.max(1,(int)(CalculatedDamage*dmgMOD));
    }


}
