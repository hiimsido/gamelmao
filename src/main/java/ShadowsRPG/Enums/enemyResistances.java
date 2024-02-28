package ShadowsRPG.Enums;

import java.util.HashMap;

public enum enemyResistances {

    Standard(40,40,40,40,40,40,40),

    Elite(100,100,100,100,100,100,100),

    Master(200,200,200,200,200,200,200),


    Ice(40,40,40,1000,40,20,-200),

    Flame(40,20,20,1000,20,40,1000),

    Stone(40,20,1000,1000,1000,100,1000),


    Heavy(20,20,20,60,20,200,20),

    Elite_Heavy(100,100,100,90,100,400,90),

    Bulwark(10,10,10,2000,20,1000,10),

    Dwarf_Captain(10,10,150,50,150,120,10),

    Dwarf(10,10,100,50,100,100,10),

    Demon(200,120,150,230,100,150,200),

    Dragon(150,120,100,30,100,200,300),

    Immune(99999,99999,99999,99999,99999,99999,99999),
    ;






enemyResistances(int DEBUFF, int ACID, int BLEED, int FREEZE, int POISON, int STUN, int BURN)
    {
        this.DEBUFF = DEBUFF;
        this.ACID = ACID;
        this.BLEED = BLEED;
        this.FREEZE = FREEZE;
        this.POISON = POISON;
        this.STUN = STUN;
        this.BURN = BURN;

    }

    public int getDEBUFF() {
        return DEBUFF;
    }

    public int getACID() {
        return ACID;
    }

    public int getBLEED() {
        return BLEED;
    }

    public int getFREEZE() {
        return FREEZE;
    }

    public int getPOISON() {
        return POISON;
    }

    public int getSTUN() {
        return STUN;
    }

    public int getBURN() {
        return BURN;
    }

    private final int DEBUFF,ACID,BLEED,FREEZE,POISON,STUN,BURN;

public static void setStats(String Type, HashMap<String,Integer> baseDebuffResists)
{
    if(Type.equalsIgnoreCase("")||Type.equalsIgnoreCase("None")){
        for(String each : baseDebuffResists.keySet())
        {
            baseDebuffResists.put(each,40);
        }


    }
    //no result means go to default
    else
    {
        enemyResistances type = enemyResistances.valueOf(Type);

        baseDebuffResists.put("Burn",type.getBURN());
        baseDebuffResists.put("Acid",type.getACID());
        baseDebuffResists.put("Stun",type.getSTUN());
        baseDebuffResists.put("Freeze",type.getFREEZE());
        baseDebuffResists.put("Debuff",type.getDEBUFF());
        baseDebuffResists.put("Bleed",type.getBLEED());
        baseDebuffResists.put("Poison",type.getPOISON());


    }
}


}
