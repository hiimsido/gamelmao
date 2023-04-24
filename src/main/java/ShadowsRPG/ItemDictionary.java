package ShadowsRPG;

public enum ItemDictionary {

    Steel_Sword("Steel Sword", 200, 50, 2, "A fine crafted steel weapon, ready to slay the baddies!", "none"),

    Mythril_Sword("Mythril Sword", 2000, 100, 5, "A weapon made from the rare material, Mythril.", "none"),
    Titan_Sword("Titan Sword", 5000, 200, 10, "A blade forged by the titan, a man who towered all he came across.", "None"),
    Blood_Blade("Bloodletter Blade", 10000, 300, 20, "A sword which thirsts for blood. Created by the Haemalchemy Demons","None")
    ;


  /*  Mythril_Sword("Steel Sword", 2000),
    Frostwaker_Dagger("Dagger Of The Frostwaker")
    Titan_Sword("Steel Sword", 5000),
    Blood_Blade("Steel Sword", 10000),
    Axe_Of_Chaos("Steel Sword", 10000),
    Longblade_Of_Shadows("Steel Sword", 100_000)

   */


    ItemDictionary(String weaponName, int weaponValue, int ATKValue, int CritChance, String Description, String Attribute) {

    }
}