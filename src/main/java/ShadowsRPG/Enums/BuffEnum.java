package ShadowsRPG.Enums;

public enum BuffEnum {

    //think back to the hashmap approach in the player class.

    Berserk(100,-100,0,0,150,20,0,0,0,0,0,0,0,0,-.2,0,0,0,0,0,0,0,0,0,0,2,"None","None"),

    Enrage(100,0,200,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    Poison(0,0,0,0,0,0,0,0,-.4,-.2,-.4,-.1,-.4,0,-.4,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    Bleed(0,0,0,0,0,0,0,0,-.1,-.1,-.1,-.1,-.2,0,0,0,0,0,-25,0,0,0,0,0,0,0,"None","None"),
    Strong_Bleed(0,0,0,0,0,0,0,0,-.3,-.3,-.3,-.3,-.3,0,0,0,0,0,-50,0,0,0,0,0,0,0,"None","None"),
    Hemorrhage(0,0,0,0,0,0,0,0,-.4,-.4,-.4,-.4,0,0,0,0,0,0,-100,0,0,0,0,0,0,0,"None","None"),

    Freeze(0,0,0,0,0,0,0,0,-.2,-.2,-.2,-.1,-.2,0,0,0,0,0,0,0,0,0,0,0,-100,0,"Ice","None"),

    Chilled(0,0,0,0,0,0,0,0,-.3,-.3,-.3,-.2,-.5,0,0,0,0,0,0,0,0,0,0,0,-200,0,"Ice","None"),

    Frozen(0,0,0,0,0,0,0,0,-.6,-.6,-.6,-.4,-.9,0,0,0,1000,0,0,0,0,0,0,0,-500,0,"Ice","None"),

    Acid(0,0,0,0,0,0,0,0,0,-.8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    Burn(0,0,0,0,0,0,0,0,-.3,0,0,0,0,-.4,0,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    Stun(0,0,0,0,0,0,0,0,0,0,0,0,-.99,0,0,0,0,0,0,0,1000,0,0,0,-200,-.99,"None","None"),

    Guard(0,0,0,0,0,0,100,0,0,1,0,0,-.2,0,0,0,0,0,0,0,40,0,0,0,0,0,"None","None"),

    Riposte(0,0,0,0,0,0,30,60,0,1,0,0,-.2,0,0,0,0,0,0,0,40,0,0,0,0,0,"None","None"),

    Evasive(0,0,0,0,0,0,0,0,0,-.5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,200,3,"None","None"),

    Way_Of_The_Warrior(0,0,0,0,0,20,0,0,.5,.2,-.5,-.5,-.2,1.0,.5,0,0,0,0,0,20,20,0,0,0,0,"None","None"),

Surge_Of_The_Sages(0,0,0,0,0,20,0,0,0,0,0,1,0,1.0,0,30,30,20,20,20,20,20,30,0,0,0,"None","None"),

 //  Arcane_Surge(0,0,0,0,0,20,20,0,.5,.2,-.5,.5,-.2,0,0,0,0,0,0,0,20,20),

    Archers_Focus(0,0,0,0,0,20,0,0,0,-.5,.5,-.5,.3,1.0,2,0,0,0,0,0,20,20,0,0,0,0,"None","None"),

    Critical(0,0,0,0,0,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    Demonic_Rage(0,0,0,120,0,0,0,0,.25,.25,0,.25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    //consider making cripple stack to become Immobile
    Crippled(0,0,0,0,-200,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    Immobile(0,0,0,0,0,0,0,0,0,0,0,0,-.95,0,0,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    Loaded(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-50,0,0,0,0,0,"None","None"),
    Reload(0,0,0,0,0,0,0,0,0,0,0,0,-.9,0,0,0,0,0,0,0,-50,0,0,0,0,0,"None","None"),

    Blind(0,0,0,0,0,0,0,0,0,0,0,0,-.2,0,-.8,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    Fatigue(0,0,0,0,0,0,0,0,-.5,-.3,-.5,0,-.5,0,-.5,0,0,0,0,0,0,0,0,0,0,-.5,"None","None"),

    Vulnerable(0,-500,0,0,0,0,-40,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"All","None"),

    Bulk(0,500,0,0,0,0,50,120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-500,0,"None","All"),

    Masterguard(0,500,0,0,0,0,40,60,0,0,0,0,0,0,0,200,200,200,200,200,500,200,0,0,-500,0,"None","None"),

    Rally(100,100,200,0,0,10,0,0,0,0,0,0,1.2,0,1.4,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    Weakening_Curse(-100,0,-100,0,0,0,0,0,-.2,0,-.2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

   Swordsdance(400,0,-100,0,80,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    Magic_Guard(0,0,0,0,0,0,100,0,0,2,0,2,-.9,0,0,100,100,100,100,100,80,80,100,50,0,0,"None","None"),

    Magic_Fatigue(0,0,0,0,0,0,0,0,0,0,0,-.5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"None","None"),

    Reflection_Curse(0,-800,0,-800,0,0,-100,200,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-100,200,0,0,"All","None"),


    ;


    private final int ATK, DEF, RNG, MAGE, AGIL, CRIT, ABSORP, REFLECT, BURN, FREEZE, POISON, BLEED, ACID, STUN, DEBUFF, MAGEABSORP, MAGEREFLECT, DODGE;

    private final double ATKmod, DEFmod, RNGmod, MAGEmod, AGILmod, CRITmod, ACCmod, DODGEmod;

    private final String weakness,resistance;

    BuffEnum(int ATK, int DEF, int RNG, int MAGE, int AGIL, int CRIT, int ABSORP, int REFLECT, double ATKmod, double DEFmod, double RNGmod, double MAGEmod, double AGILmod, double CRITmod, double ACCmod, int BURN, int FREEZE, int POISON, int BLEED, int ACID, int STUN, int DEBUFF, int MAGEABSORP, int MAGEREFLECT, int DODGE, double DODGEmod, String weakness, String resistance)
    {
        this.ATK = ATK;
        this.RNG = RNG;
        this.DEF = DEF;
        this.MAGE = MAGE;
        this.AGIL = AGIL;
        this.CRIT = CRIT;
        this.ABSORP = ABSORP;
        this.REFLECT = REFLECT;
        this.MAGEREFLECT = MAGEREFLECT;
        this.MAGEABSORP = MAGEABSORP;

        this.ATKmod = ATKmod;
        this.ACCmod = ACCmod;
        this.RNGmod = RNGmod;
        this.DEFmod = DEFmod;
        this.MAGEmod = MAGEmod;
        this.AGILmod = AGILmod;
        this.CRITmod = CRITmod;

        this.BURN = BURN;
        this.FREEZE = FREEZE;
        this.POISON = POISON;
        this.BLEED = BLEED;
        this.ACID = ACID;
        this.STUN = STUN;
        this.DEBUFF = DEBUFF;
        this.DODGE = DODGE;
        this.DODGEmod = DODGEmod;
        this.weakness = weakness;
        this.resistance = resistance;





    }


//add a function which adds/removes all the buff/debuff values from each buff/debuff. Also, create a boolean, true or false to determine if the buff exists or not, as a failsafe.

    public int getATK() {
        return ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public int getRNG() {
        return RNG;
    }

    public int getMAGE() {
        return MAGE;
    }

    public int getAGIL() {
        return AGIL;
    }

    public int getCRIT() {
        return CRIT;
    }

    public int getABSORP() {
        return ABSORP;
    }

    public int getREFLECT() {
        return REFLECT;
    }

    public int getBURN() {
        return BURN;
    }

    public int getFREEZE() {
        return FREEZE;
    }

    public int getPOISON() {
        return POISON;
    }

    public int getBLEED() {
        return BLEED;
    }

    public int getACID() {
        return ACID;
    }

    public int getSTUN() {
        return STUN;
    }

    public int getDEBUFF() {
        return DEBUFF;
    }

    public double getATKmod() {
        return ATKmod;
    }

    public double getDEFmod() {
        return DEFmod;
    }

    public double getRNGmod() {
        return RNGmod;
    }

    public double getMAGEmod() {
        return MAGEmod;
    }

    public double getAGILmod() {
        return AGILmod;
    }

    public double getCRITmod() {
        return CRITmod;
    }

    public double getACCmod() {
        return ACCmod;
    }

    public int getMAGEABSORP() {return MAGEABSORP;}

    public int getMAGEREFLECT() {return MAGEREFLECT;}

    public int getDODGE() {return DODGE;}

    public double getDODGEmod() {return DODGEmod;}

    public String getWeakness(){return weakness;};
    public String getResistance(){return resistance;}
}
