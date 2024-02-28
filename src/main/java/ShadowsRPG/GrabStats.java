package ShadowsRPG;

import java.util.HashMap;

public class GrabStats {

    EnemyStats FollowAI;
    int[] Coordinates;
    int cMAGE;
    int HP;

    int DEF;
    int ATK;
    int MAGE;
    int AGIL;
    String ATRI;
    String STATUS;
    int DUR;
    int cHP;
    int CRIT;
    int ABSORP;
    int MAGEABSORP;
    int REFLECT;
    int RANGE;
    int DIST;
    int DODGE;
    String AI;
    String TYPE;
    int MAGEREFLECT;

    public HashMap<String,Integer> addedstats;
    public HashMap<String, Double> addedmods;

    GrabStats(Player play){

        addedstats = play.TemporaryStats;
        addedmods = play.TemporaryMultiplier;

        AGIL = (int)((play.cAGIL + addedstats.get("AGIL"))*Math.max(.05,(1+addedmods.get("AGILmod"))));
        ATK = (int)((play.cATK + addedstats.get("ATK"))*Math.max(.05,(1+addedmods.get("ATKmod"))));
        RANGE = (int)((play.cRNG + addedstats.get("RNG"))*Math.max(.05,(1+addedmods.get("RNGmod"))));
        MAGE = (int)((play.cMAGE + addedstats.get("MAGE"))*Math.max(.05,(1+addedmods.get("MAGEmod"))));
        DEF = (int)((play.cDEF + addedstats.get("DEF"))*Math.max(.05,(1+addedmods.get("DEFmod"))));
        ABSORP = play.ABSORP + addedstats.get("ABSORP");
        REFLECT = play.REFLECT + addedstats.get("REFLECT");
        HP = play.HP;
        CRIT = play.CRIT + addedstats.get("CRIT");
        MAGEABSORP = play.getMAGEABSORP() + addedstats.get("MAGEABSORP");
        MAGEREFLECT = play.getMAGEREFLECT()+ addedstats.get("MAGEREFLECT");
        DODGE = (int)((addedstats.get("DODGE") + AGIL)*Math.max(.05,(1+ addedmods.get("DODGEmod"))));



    }

  public  GrabStats(EnemyStats enem){

        addedstats = enem.TemporaryStats;
        addedmods = enem.TemporaryMultiplier;

      AGIL = (int)((enem.AGIL + addedstats.get("AGIL"))*Math.max(.05,(1+addedmods.get("AGILmod"))));
      ATK = (int)((enem.ATK + addedstats.get("ATK"))*Math.max(.05,(1+addedmods.get("ATKmod"))));
      RANGE = (int)((enem.RNG + addedstats.get("RNG"))*Math.max(.05,(1+addedmods.get("RNGmod"))));
      MAGE = (int)((enem.MAGE + addedstats.get("MAGE"))*Math.max(.05,(1+addedmods.get("MAGEmod"))));
      DEF = (int)((enem.DEF + addedstats.get("DEF"))*Math.max(.05,(1+addedmods.get("DEFmod"))));
      ABSORP = enem.ABSORP + addedstats.get("ABSORP");
      REFLECT = enem.REFLECT + addedstats.get("REFLECT");
      HP = enem.HP;
      CRIT = enem.CRIT + addedstats.get("CRIT");
      MAGEABSORP = enem.getMAGEABSORP() + addedstats.get("MAGEABSORP");
      MAGEREFLECT = enem.getMAGEREFLECT()+ addedstats.get("MAGEREFLECT");
      DODGE = (int)((addedstats.get("DODGE") + AGIL)*Math.max(.05,1+ addedmods.get("DODGEmod")));


    }


}
