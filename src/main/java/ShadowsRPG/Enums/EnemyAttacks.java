package ShadowsRPG.Enums;

public enum EnemyAttacks {
    // start working on support class enemies

    //add a boss/attack that if two enemies are close/enemy lives for long enough, it wipes you.

    //add SUPPORT type for attacks, which are used on allies.


    //add penetration to penetrate absorb for some attacks?

    Strike("Strike",0, "MELEE", 1,1, "None", "None","None",0, 0,0, "None",0,1,0,false,0,1.0,"None"),

    Assassinate("Assassinate",3, "MELEE", 1,1, "None", "None","None",0, 0,100, "None",0,200,0,false,0,1.0,"None"),

    Berserk("Berserk",3, "SELF", 1,1, "Berserk", "None","None",3, 99,0, "None",5,0,0,false,0,1.0,"None"),

    Penetrate("Penetrate",0, "MELEE", 1,1, "None", "None","None",0, 0,100, "None",0,1,0,false,0,1.0,"None"),

    Berserker_Barrage("Berserker Barrage",3, "MELEE", 1,3, "None", "None","None",1, 0,0, "Berserk",0,.7,0,false,0,1.0,"None"),
    Arcane_Comet("Arcane Comet",5, "MAGE", 1, 1,"None", "None","None",2, 0,100, "None",0,1,0,false,0,1.0,"None"),

    Ice_Blast("Ice Blast",5, "MAGE", 1, 1,"None", "Frozen","None",3, 0,0, "None",0,1,100,false,0,1.0,"None"),

    Ice_Barrage("Ice Barrage",6, "MAGE", 1, 1,"None", "Frozen","None",3, 0,0, "None",0,1,300,false,0,1.0,"None"),


    Smash("Smash",0, "MELEE", .6, 1,"None", "Stun","None",0, 0,0, "None",2,1,55,false,0,1.0,"None"),

    Crushing_Blow("Crushing Blow",3, "MELEE", 1, 1,"None", "Stun","None",3, 0,0, "None",2,1,80,false,0,1.0,"Crush"),

    Karasawa_Slam("Karasawa Slam",0, "MELEE", 1, 1,"None", "Stun","None",0, 0,0, "None",2,2,70,false,0,1.0,"None"),

    Slash("Slash",0, "MELEE", 1, 1,"None", "Bleed","None",0, 0,0, "None",2,1,55,false,0,1.0,"None"),

    Frozen_Punch("Frozen Punch",2, "MELEE", 1, 1,"None", "Freeze","None",0, 0,0, "None",3,1,130,false,0,1.0,"None"),

    Crush("Crush",0, "MELEE", 1.1, 1,"None", "None","None",0, 0,0, "None",0,1,0,false,0,1.0,"None"),

    Berserker_Slash("Berserker Slash",1, "MELEE", 1, 1,"None", "Bleed","None",1, 0,0, "Berserk",2,1,55,false,0,1.0,"None"),

    Axe_Throw("Axe Throw",1, "MELEE", 1, 1,"None", "Bleed","None",0, 2,0, "None",0,.8,0,false,0,1.0,"None"),

    Bite("Bite",2, "MELEE", 1.3, 1,"None", "Bleed","None",0, 0,10, "None",3,1,60,false,0,1.0,"None"),

    Spider_Bite("Spider Bite",2, "MELEE", 1.3, 1,"None", "Poison","None",0, 0,10, "None",3,1,90,false,0,1.0,"None"),

    Web_Shoot("Web Shoot",2, "Range", .1, 1,"None", "Immobile","None",0, 2,10, "None",2,3,90,false,0,1.0,"None"),

    Web_Encasement("Web Encasement",3, "Range", .5, 1,"None", "Stun","None",0, 2,10, "None",2,3,60,false,0,1.0,"None"),

    Shatter("Shatter",0, "MELEE", 1.5,1, "None", "None","None",0, 0,100, "Frozen",0,3000,0,true,0,2.0,"None"),


    Arrow_Shot("Arrow Shot",0, "RANGE", 1,1, "None", "None","None",0, 0,0, "None",0,1,0,false,0,1.0,"None"),

    Teleport("Teleport",4, "SPECIAL", 1,1, "None", "None","None",1, 0,0, "None",0,0,0,false,0,1.0,"None"),

    Crossbow_Shot("Crossbow Shot",0, "RANGE", 1,1, "None", "None","None",0, 1,0, "None",0,1,0,false, 0,1.0,"None"),

    Pistol_Shot("Pistol Shot",0, "RANGE", 1.2,1, "None", "None","None",0, 1,20, "None",0,1,0,false, 0,1.0,"None"),

    Chaingun_Burst("Chaingun Burst",2, "RANGE", .15,10, "None", "None","None",1, 0,50, "Loaded",0,.7,0,false,0,1.5,"None"),

    Buckshot("Buckshot",0, "RANGE", .20,6, "None", "None","Reload",0, 0,50, "Loaded",0,.3,0,true,99,1.0,"None"),

    Reload("Reload",0, "SELF", 1,1, "Loaded", "None","None",0, 99,0, "Reload",99,1,0,true,0,1.0,"None"),

    Dwarf_Flamethrower("Dwarf Flamethrower",0, "RANGE", .15,10, "None", "Burn","None",1, 0,50, "Loaded",0,1.2,120,false,0,1.0,"Fire"),

    Rev_Flamethrower("Rev Flamethrower",4, "SELF", 1,1, "Loaded", "None","None",1, 99,0, "None",4,0,0,false,0,1.0,"None"),

    Rev_Chaingun("Rev Chaingun",1, "SELF", 1,1, "Loaded", "None","Immobile",1, 0,0, "None",2,0,0,false,2,1.0,"None"),

    Rev_Systems("Rev Systems",6, "SELF", 1,1, "Loaded", "None","None",2, 0,0, "None",6,0,0,false,2,1.0,"None"),

    Arrow_Rain("Arrow Rain",3, "RANGE", .75,3, "None", "None","None",3, 0,0, "None",0,1,0,false,0,1.0,"None"),

    Arcane_Bolt("Arcane Bolt",0, "MAGE", 1,1, "None", "None","None",0, 0,0, "None",0,1,0,false,0,1.0,"None"),

    Hellfire_Blast("Hellfire Blast",0, "MAGE", 1,1, "None", "Burn","None",0, 2,0, "None",3,1,120,false,0,1.0,"Fire"),

    Throw_Knife("Throw Knife",0, "RANGE", 1,1, "None", "None","None",0, 1,0, "None",0,1,0,false,0,1.0,"None"),

    Blinding_Powder("Blinding Powder",3, "RANGE", .1,1, "None", "Blind","None",0, 1,0, "No Debuff",1,3,140,false,0,1.0,"None"),

    Dragonbreath("Dragonbreath",1, "MAGE", .25,4, "None", "Burn","None",0, 0,25, "None",3,1,50,false,0,1.0,"Fire"),

    Frostbreath("Frostbreath",1, "MAGE", .25,4, "None", "Freeze","None",0, 0,25, "None",3,1,80,false,0,1.0,"Ice"),

    Bulwark_Charge("Bulwark Charge",3, "MELEE", 1.2,1, "None", "Stun","Vulnerable",0, 99,100, "Bulwark Charge",2,2000,100000,true,3,1.0,"None"),

    Bulwark_Roar("Bulwark Roar",6, "SELF", 1,1, "Bulk", "None","Immobile",3, 99,0, "None",2,1,0,true,2,1.0,"None"),


  /*  Bulwark_Gaze("Bulwark Gaze",999, "MAGE", 1,1, "Enrage", "Immobile","Immobile",999, 99,100, "RoarCD",1,100,1000000,false,2), */


    Rock_Toss("Rock Toss",1, "RANGE", 1,1, "None", "None","None",0, 2,0, "None",0,1,0,false,1,1.0,"None"),

    Bulwark_Stomp("Bulwark Stomp",2, "RANGE", 1,1, "None", "None","None",0, 6,10, "None",0,200,0,true,1,1.0,"None"),

    Earthquake("Earthquake",3, "SPECIAL", 1.5,1, "None", "None","Vulnerable",0, 7,100, "Immobile",0,300,0,false,3,1.0,"None"),

    Quake("Quake",0, "SPECIAL", 1,1, "None", "None","None",0, 0,100, "Resting",0,300,0,false,3,1.0,"None"),

    Chomp("Chomp",1, "MELEE", 1.3,1, "None", "None","None",0, 0,100, "None",1,2,0,true,2,1.0,"None"),

    Lunge("Lunge",1, "MELEE", 1,1, "None", "None","None",0, 1,20, "None",0,1.2,0,false,0,1.0,"None"),
    Swordsdance("Swordsdance",5, "SELF", 1,1, "Swordsdance", "None","None",2, 1,20, "None",5,1.0,0,false,0,1.0,"None"),

    Slice_And_Dice("Slice And Dice",3, "MELEE", .2,5, "None", "None","None",0, 1,30, "Swordsdance",0,1.0,0,false,0,1.5,"None"),

    Ballista_Shot("Ballista Shot",0, "RANGE", 1,1, "None", "None","None",0, 0,100, "Loaded",0,200,0,false,0,1.0,"None"),

    Load_Ballista("Load Ballista",0, "SELF", 1,1, "Loaded", "None","Immobile",0, 0,0, "Max Distance",2,0,0,false,2,1.0,"None"),

    Catapult_Reload("Catapult Reload",0, "SELF", 1,1, "Loaded", "None","Immobile",0, 0,0, "Reload",2,0,0,true,2,1.0,"None"),

    Fire_The_Catapult("Fire The Catapult",0, "SELF", 1,1, "None", "None","Immobile",0, 0,0, "Catapult",99,0,0,true,2,1.0,"None"),

   Shot_Landed("Shot Landed",0, "SPECIAL", 1,1, "None", "None","None",0, 99,0, "Projectile In Air",0,0,0,false,0,1.0,"None"),


    Demonic_Ritual("Demonic Ritual",4, "SELF", 1,1, "Demonic Rage", "None","None",3, 0,0, "None",3,0,0, false,0,1.0,"None"),

   Hellfire_Surge("Hellfire Surge",4, "SELF", 1,1, "None", "Burn","None",0, 0,100, "Demonic Rage",3,0,0, false,0,1.0,"Ice"),

    Dwarf_Reinforcements("Dwarf Reinforcements",7, "SELF", 1,1, "None", "None","None",0, 10,0, "None",0,0,0,true,0,1.0,"None"),

    Hatch_Spider("Hatch Spider",3, "SELF", 1,1,
            "None", "None","None",0, 10,0, "None",0,0,0,true,0,1.0,"None"),

    Dwarf_Rally("Dwarf Rally",7, "SELF", 1,1, "Rally", "None","None",1, 99,0, "Allies",5,0,0,true,0,1.0,"None"),



    Grenade_Blast("Grenade Blast",3, "RANGE", 1.3,1, "None", "None","None",1, 0,100, "None",0,.8,0,false,0,1.0,"None"),

    Flame_Grenade("Flame Grenade",3, "RANGE", 1,1, "None", "Burn","None",1, 0,30, "Loaded",0,.8,130,false,0,1.0,"Ice"),

    Just_Desserts("Just Desserts",3, "MELEE", 1,1, "None", "Bleed","None",1, 0,0, "None",2,0,0,true,0,1.0,"None"),


    Consume("Consume",0, "SELF", 1,1, "Enrage", "None","None",0, 99,0, "Consume",2,0,0,false,0,1.0,"None"),








//add duration for buff attacks...?
//make guard it's own attack category/choice vs adding it in here
    ;
    //default range attack

    EnemyAttacks(String name, int Cooldown, String type, double DMGMod, int count, String buff, String debuff, String selfDebuff, int cCooldown, int extraDIST, int extraCRIT, String Condition, int duration, double ACCMod, int debuffChance, boolean Special, int selfDebuffDuration, double CRITMOD, String Weakness)
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
        this.Condition = Condition;
        this.DMGMod = DMGMod;
        this.duration = duration;
        this.ACCMod = ACCMod;
        this.debuffChance = debuffChance;
        this.Special = Special;
        this.selfDebuff = selfDebuff;
        this.selfDebuffDuration = selfDebuffDuration;
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

    private final String Condition;
    private final int Cooldown;

    private final double DMGMod;

    private final String type,weakness;
    private final int count;

    private final int selfDebuffDuration;

    private final String buff;
    private final String debuff;
    private final String selfDebuff;
    private int cCooldown;

    private final int extraDIST;
    private final int extraCRIT;

    private final int duration;

    private final double ACCMod;

    private final int debuffChance;

    private final boolean Special;
    private final double CRITMOD;
    public String getSelfDebuff(){ return selfDebuff;}
    public int getSelfDebuffDuration(){ return selfDebuffDuration;}

    public String getName() {
        return name;
    }

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

    public String getCondition() {
        return Condition;
    }

    public int getDuration() {return duration;}

    public boolean getSpecial() {return Special;}

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

    public double getDMGMod(){return DMGMod;}

    public double getCRITMOD(){return CRITMOD;}

    public double getACCMod(){return ACCMod;}

    public int getDebuffChance(){return debuffChance;}

    public void reduceCooldown()
    {
        if (cCooldown!=0)
        {
            this.cCooldown = cCooldown - 1;
        }

    }
    public String getWeakness()
    {
        return weakness;
    }


    @Override
    public String toString() {
        return getName();
    }
}
