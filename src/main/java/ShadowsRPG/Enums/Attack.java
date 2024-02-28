package ShadowsRPG.Enums;

public enum Attack {

    //need to make an object with the player stats, gear, attacks, and so fourth.

    //have some attacks unlock on level ups, and based on your classes mastery level in some stats, based on which class you pick, said mastery level will be higher than others. Mastery level also determines how many points you gain on level up.

    //add an accuracy modifier for attacks

    //add attack multipliers for heavy attacks, but maybe reduced accuracy...?

    //attack unlocks based on weapons

    //bow type/arrow type will change range attack elements?

    //do i want it to be an enum or a class...?





    Strike("Strike",0, "MELEE", 1, "None", "None",0, 0,0,1,0,1,0,0, false,"None",0,"None",1.0,"None"),

    Slash("Slash",0, "MELEE", 1, "None", "Bleed",0, 0,0,.7,0,1,3,60, false,"None",0,"None",1.0,"None"),

    Swift_Strike("Swift Strike",3, "MELEE", 1, "None", "None",0, 0,50,.7,0,2,0,0, false,"None",0,"None",1.3,"None"),

    Poison_Stab("Poison Stab",0, "MELEE", 1, "None", "Poison",0, 0,0,.7,0,1,4,80, false,"None",0,"None",1.0,"Stab"),

    Stab("Stab",0, "MELEE", 1, "None", "Bleed",0, 0,0,.7,0,1,3,80, false,"None",0,"None",1.0,"Stab"),

    Crippling_Arrows("Crippling Arrows",0, "RANGE", 3, "None", "Crippled",0, 0,0,.33,0,.7,3,100, false,"None",0,"None",1.0,"None"),


    Slam("Slam",0, "MELEE", 1, "None", "Stun",0, 0,0,.75,0,1,0,60, false,"None",0,"None",1.0,"Crush"),

    Spinning_Slash("Spinning Slash",3, "MELEE", 1, "None", "None",0, 0,0,1,0,1,0,0, true,"None",0,"None",1.0,"Slash"),

    Evicerate("Evicerate",5, "MELEE", 3, "None", "None",2, 0,20,1,0,.7,0,0, false,"Fatigue",3,"None",1.0,"None"),

    Critical_Blows("Critical Blows",3, "MELEE", 2, "None", "None",1, 0, 100,1,0,.8,0,0, false,"Fatigue",3,"None",1.0,"None"),

    Shoot_Arrow("Shoot Arrow", 0, "RANGE",1, "None", "None",0, 0, 0,1,0,1,0,0, false,"None",0,"Arrow",1.0,"None"),

    Piercing_Arrow("Piercing Arrow", 5, "RANGE",1, "None", "None",0, 0, 100,.5,0,2,0,0, false,"None",0,"Archers Focus",1.0,"None"),

   Longshot("Longshot", 5, "RANGE",1, "None", "None",0, 3, 0,1,0,2,0,0, false,"None",0,"Longbow",1.0,"None"),

    Arrow_Volley("Arrow Volley", 3, "RANGE",2, "None", "None",0, 0, -20,1,0,.75,0,0, false,"None",0,"Arrow",1.0,"None"),

   Arrow_Barrage("Arrow Barrage", 3, "RANGE",10, "None", "None",0, -1, 40,.4,0,.50,0,0, false,"None",0,"Arrow",1.0,"None"),

    Arcane_Arrow("Arcane Arrow", 0, "RANGE",1, "None", "None",0, 1, 20,1.5,10,1000,0,0, false,"None",0,"Arrow",1.0,"Arcane"),

    Arcane_Blade("Arcane Blade", 0, "MELEE",1, "None", "None",0, 1, 20,1.5,10,1000,0,0, false,"None",0,"None",1.0,"Arcane"),

    Arcane_Mind("Arcane Mind", 0, "SELF",1, "None", "None",0, 0, 0,0,0,0,0,0, true,"None",0,"None",1.0,"None"),

    Magic_Bolt("Magic Bolt", 0, "MAGE",1, "None", "None",0, 3, 0,1.2,10,1,0,0, false,"None",0,"None",1.0,"None"),

    //code lightning strike behavior to hit multiple enemies

    Lightning_Strike("Lightning Strike", 0, "SPECIAL",1, "None", "None",0, 2, 33,.5,30,1,0,0, false,"None",0,"None",1.0,"Lightning"),

    Lightning_Shot("Lightning Shot", 0, "SPECIAL",1, "None", "None",0, 2, 33,.5,30,1,0,0, false,"None",0,"None",1.0,"Lightning"),

    Icethrower("Icethrower", 2, "MAGE",10, "None", "Freeze",0, 2, 10,.15,40,1,3,55, false,"None",0,"None",1.0,"Ice"),

    Flamethrower("Flamethrower", 2, "MAGE",10, "None", "Burn",0, 2, 25,.15,40,1,3,140, false,"None",0,"None",1.0,"Fire"),

    Weakening_Curse("Weakening Curse", 2, "MAGE",1, "None", "Weakening Curse",0, 2, 0,.1,40,1,3,80, false,"None",0,"None",1.0,"None"),

    Arcane_Comet("Arcane Comet", 4, "MAGE",1, "None", "Magic Fatigue",2, 2, 100,1.5,100,1,0,0, false,"None",0,"None",1.0,"Arcane"),

    Guard("Guard", 0, "SELF", 1, "Guard", "None",0, 0,0,1,0, 1,2,0, false,"None",0,"None",1.0,"None"),

    Masterguard("Masterguard", 4, "SELF", 1, "Masterguard", "None",0, 0,0,1,0, 1,2,0, false,"None",0,"None",1.0,"None"),

    Magic_Guard("Magic Guard", 3, "SELF", 1, "Magic Guard", "None",0, 0,0,1,40, 1,2,0, false,"None",0,"None",1.0,"None"),

    Evade("Evade", 0, "SELF", 1, "Evasive", "None",0, 0,0,1,0, 1,2,0, false,"None",0,"None",1.0,"None"),

    Way_Of_The_Warrior("Way Of The Warrior", 6, "SELF", 1, "Way Of The Warrior", "None",0, 0,0,1,20, 1,5,0, false, "None",0,"None",1.0,"None"),

    Surge_Of_The_Sages("Surge Of The Sages", 6, "SELF", 1, "Surge Of The Sages", "None",0, 0,0,1,40, 1,5,0, false, "None",0,"None",1.0,"None"),

    Archers_Focus("Archers Focus", 6, "SELF", 1, "Archers Focus", "None",0, 0,0,1,20, 1,5,0, false, "None",0,"None",1.0,"None"),

    Reflection_Curse("Reflection Curse", 6, "SELF", 1, "Reflection Curse", "None",0, 0,0,1,100, 1,5,0, false, "None",0,"None",1.0,"None"),

  /*  Sword_Deflection("Sword Deflection", 0, "SELF", 1, "Deflect", "Fatigue",0, 0,0,1,0)
*/


//add duration for buff attacks...?
//make guard it's own attack category/choice vs adding it in here
    ;
    //default range attack

    Attack(String name, int Cooldown, String type, int count, String buff, String debuff, int cCooldown, int extraDIST, int extraCRIT, double DMGMod, int ManaCost, double accMod, int duration, int debuffChance, boolean Special, String selfDebuff, int selfDebuffDuration, String Condition, double CRITMOD, String Weakness)
    {
        this.name = name;
        this.Cooldown = Cooldown;
        this.type = type;
        this.count = count;
        this.buff = buff;
        this.debuff = debuff;
        this.cCooldown = cCooldown;
        this.extraDIST = extraDIST;
        this.extraCRIT = extraCRIT;
        this.DMGMod = DMGMod;
        this.ManaCost = ManaCost;
        this.accMod = accMod;
        this.duration = duration;
        this.debuffChance = debuffChance;
        this.Special = Special;
        this.selfDebuff = selfDebuff;
        this.selfDebuffDuration = selfDebuffDuration;
        this.condition = Condition;
        this.CRITMOD = CRITMOD;
        this.weakness = Weakness;
        //consider adding a buff for x attacks (1 turn for some to calculate increase damage)
        //ideas: scythe hitting multiple adjacent targets, ricochet for a bow, hitting multiple targets
        //multi hit
        //potentially learn techniques later in the game via SCROLLS/learning them from the academy/maybe characters have exclusive moves?

        //figure out how to add special attacks for x weapons, if the weapon itself adds it or if i add a requirement for x weapon.

        //some attacks buff where as some attacks debuff
    }

    /*
    Required variables
    Attack Name
    Type: RANGE/MELEE/MAGE (doubt mage will be used lest it's a special magic item)
    Cooldown: some weapons/attacks will have a cooldown (for heavy weapons like the battle axe, could maybe have it do hella damage (EX: 1 turn buff, heavy hit)
    Special Attacks based on weapon...?

    //add a special condition, to allow for rules such as scythe/ricochet effect, etc.
     */

    private final String name;
    private final double CRITMOD;
    private final int Cooldown;

    private final double accMod;

    private final String type;
    private final int count;

    private final String buff, weakness;
    private final String debuff, selfDebuff;
    private int cCooldown;

    private final int extraDIST;
    private final int extraCRIT;
    private final double DMGMod;
    private final int ManaCost;

    private final int duration;

    private final int debuffChance, selfDebuffDuration;

    private final boolean Special;

    private final String condition;
    public String getName() {
        return name;
    }

    public String getWeakness() { return weakness;}

    public int getCooldown() {
        return Cooldown;
    }

    public String getType() {
        return type;
    }

    public String getBuff() {
        return buff;
    }

    public String getDebuff() {
        return debuff;
    }


    public int getCount() {
        return count;
    }

    public int getDIST(){ return extraDIST;}
    public int getCurrentCD()
    {
        return cCooldown;
    }

    public void setCooldown(int i)
    {
        cCooldown = i;
    }

    public void setCooldown()
    {
        cCooldown = getCooldown();
    }

    public int getExtraCRIT(){ return extraCRIT;}

    public double getDMGMod(){ return DMGMod;}

    public int getManaCost(){ return ManaCost;}

    public int getDuration(){return duration;}

    public double getACCMod(){return accMod;}

    public int getDebuffChance() {
        return debuffChance;
    }

    public String getSelfDebuff() { return selfDebuff;}

    public int getSelfDebuffDuration() { return selfDebuffDuration;}

    public boolean getSpecial() { return Special;}

    public String getCondition(){
        return condition;
    }

    public double getCRITMOD(){ return CRITMOD;}

    public void reduceCooldown()
    {
        if (cCooldown!=0)
        {
            this.cCooldown = cCooldown - 1;
        }

    }



    @Override
    public String toString() {
        return getName();
    }
}
