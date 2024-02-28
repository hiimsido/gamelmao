package ShadowsRPG.Enums;

public enum WeaponDictionary {

    Steel_Sword("Steel Sword", 200, 50, 2, "A fine crafted steel weapon, ready to slay the baddies!", "none",0,0),

    Mythril_Sword("Mythril Sword", 2000, 100, 5, "A weapon made from the rare material, Mythril.", "none",1,1),
    Titan_Sword("Titan Sword", 5000, 200, 10, "A blade forged by the titan, a man who towered all he came across.", "None",2,2),
    Blood_Blade("Bloodletter Blade", 10000, 300, 20, "A sword which thirsts for blood. Created by the Haemalchemy Demons.","Blood", 100,3),
    Axe_Of_Chaos("Giants Axe Of Chaos", 10000,400,15, "A large axe, one which has been used in many battles, but not for a good cause.","none",20,4),
    Frostwaker_Dagger("Dagger Of The Frostwaker", 10000, 250, 30, "A weapon wielded by the legendary knights of the woken mountains, empowered by ice magics.","Frost", 100 ,5),
    Shadow_Sword("The Shadow Longsword", 1000000, 1000, 50, "A sword which appears to be the physical manifestation of a shadow. It's abilities are unknown.", "Shadow",1000,6)
    ;


    //shadow weapons could have a roulette of things they could do.

  /*  Mythril_Sword("Steel Sword", 2000),
    Frostwaker_Dagger("Dagger Of The Frostwaker")
    Titan_Sword("Steel Sword", 5000),
    Blood_Blade("Steel Sword", 10000),
    Axe_Of_Chaos("Steel Sword", 10000),
    Longblade_Of_Shadows("Steel Sword", 100_000)

   */


    private final String weaponName;
    private final int ATKValue;
    private final int CritChance;
    private final int weaponValue;
    private final String Attribute;

    private final String Description;
    private final int tier;
private final int ID;


    WeaponDictionary(String weaponName, int weaponValue, int ATKValue, int CritChance, String Description, String Attribute, int tier, int ID) {

        this.ATKValue = ATKValue;
        this.weaponName = weaponName;
        this.weaponValue = weaponValue;
        this.Description = Description;
        this.Attribute = Attribute;
        this.CritChance = CritChance;
        this.tier = tier;
        this.ID = ID;
    }

    public String getWeaponName()
    {
        return weaponName;
    }


public int getATKValue() {return ATKValue;}

    public int getCritChance() {
        return CritChance;
    }

    public int getWeaponValue() {
        return weaponValue;
    }

    public String getAttribute() {
        return Attribute;
    }

    public String getDescription() {
        return Description;
    }







}