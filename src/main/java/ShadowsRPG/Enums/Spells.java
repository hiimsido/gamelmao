package ShadowsRPG.Enums;

public enum Spells{

    //default melee attack
    //do i want it to be an enum or a class...?
    Strike("Strike",0, "MELEE", 1, "None", "None",0, 0,0),

    Shoot_Arrow("Shoot Arrow", 0, "RANGE",1, "None", "None",0, 0,0),
    Arrow_Volley("Arrow Volley", 3, "RANGE",2, "None", "None",0, 0,0)


//add duration for buff attacks...?
//make guard it's own attack category/choice vs adding it in here
    ;
    //default range attack

    Spells(String name, int Cooldown, String type, int count, String buff, String debuff, int cCooldown, int extraDIST, int manacost)
    {
        this.name = name;
        this.Cooldown = Cooldown;
        this.type = type;
        this.count = count;
        this.buff = buff;
        this.debuff = debuff;
        this.cCooldown = cCooldown;
        this.extraDIST = extraDIST;
        this.manacost = manacost;
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
    private final int Cooldown;

    private final int manacost;

    private final String type;
    private final int count;

    private final String buff;
    private final String debuff;
    private int cCooldown;

    private int extraDIST;

    public String getName() {
        return name;
    }

    public int getManacost() {return manacost;}

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


    @Override
    public String toString() {
        return getName();
    }



}
