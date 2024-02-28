package ShadowsRPG;

import java.util.Arrays;

public class ClassStart {

    //add code eventually for looking at adding
    // attacks based on weapons
public static void START(String Choice, Player player)
{

switch(Choice)
{



    case "initiate" :
        player.ATK = 100;
        player.DEF = 100;
        player.RNG = 100;
        player.MAGE = 100;
        player.AGIL = 50;
        player.HP = 1000;
        player.MANA = 50;
        player.Coins = 2000;
        player.LVL = 0;
        player.cHP = 1000;
        player.cMANA = 50;

        player.pBurn = 40;
        player.pDebuff = 40;
        player.pFreeze = 40;
        player.pAcid = 40;
        player.pStun = 40;
        player.pPoison = 40;
        player.pBleed = 40;

        player.WornEquipment.put("Head","Steel_Helmet");
        player.WornEquipment.put("Body","Steel_Platebody");
        player.WornEquipment.put("Legs","Steel_Platelegs");
        player.WornEquipment.put("Shield","Steel_Kiteshield");
        player.WornEquipment.put("Bow","Wooden_Bow");
        player.WornEquipment.put("Boots","Steel_Boots");
        player.WornEquipment.put("Gloves","Leather_Gloves");
        player.WornEquipment.put("Weapon","Steel_Sword");
        player.WornEquipment.put("Arrows", "Bronze_Arrow");

        player.Attacks.addAll(Arrays.asList("Strike","Slash","Slam","Shoot Arrow","Arrow Volley","Magic Bolt","Icethrower","Flamethrower","Guard"));
        break;


    case "mager" :
    player.ATK = 75;
    player.DEF = 60;
    player.RNG = 75;
    player.MAGE = 150;
    player.AGIL = 100;
    player.HP = 1000;
    player.MANA = 100;
    player.Coins = 750;
    player.LVL = 0;
    player.cHP = 1000;
    player.cMANA = 100;

        player.pBurn = 20;
        player.pDebuff = 60;
        player.pFreeze = 40;
        player.pAcid = 20;
        player.pStun = 20;
        player.pPoison = 40;
        player.pBleed = 20;

        player.WornEquipment.put("Head","Magic_Hat");
        player.WornEquipment.put("Body","Magic_Robe_Top");
        player.WornEquipment.put("Legs","Magic_Robe_Bottoms");
        player.WornEquipment.put("Shield","Mage_Tome");
        player.WornEquipment.put("Bow","Wooden_Bow");
        player.WornEquipment.put("Boots","Magic_Boots");
        player.WornEquipment.put("Gloves","Leather_Gloves");
        player.WornEquipment.put("Weapon","Magic_Staff");
        player.WornEquipment.put("Arrows", "Bronze_Arrow");

        player.Attacks.addAll(Arrays.asList("Strike","Shoot Arrow","Arcane Mind","Magic Bolt","Lightning Strike","Icethrower","Flamethrower","Weakening Curse","Arcane Comet","Magic Guard","Surge Of The Sages"));


    break;

    case "archer" :
        player.ATK = 75;
        player.DEF = 45;
        player.RNG = 150;
        player.MAGE = 75;
        player.AGIL = 200;
        player.HP = 1000;
        player.MANA = 25;
        player.Coins = 500;
        player.LVL = 0;
        player.cHP = 1000;
        player.cMANA = 25;

        player.pBurn = 20;
        player.pDebuff = 20;
        player.pFreeze = 20;
        player.pAcid = 10;
        player.pStun = 20;
        player.pPoison = 40;
        player.pBleed = 20;

        player.WornEquipment.put("Head","Steel_Plated_Hood");
        player.WornEquipment.put("Body","Leather_Body");
        player.WornEquipment.put("Legs","Leather_Chaps");
        player.WornEquipment.put("Shield","Buckler");
        player.WornEquipment.put("Bow","Oak_Longbow");
        player.WornEquipment.put("Boots","Archer_Boots");
        player.WornEquipment.put("Gloves","Leather_Gloves");
        player.WornEquipment.put("Weapon","Mythril_Dagger");
        player.WornEquipment.put("Arrows", "Mythril_Arrow");



        player.Attacks.addAll(Arrays.asList("Strike","Poison Stab","Crippling Arrows","Shoot Arrow", "Piercing Arrow", "Arrow Volley","Arcane Arrow","Magic Bolt","Evade","Archers Focus"));
        break;

    case "knight" :
        player.ATK = 150;
        player.DEF = 150;
        player.RNG = 100;
        player.MAGE = 75;
        player.AGIL = 100;
        player.HP = 1000;
        player.MANA = 25;
        player.Coins = 1250;
        player.LVL = 0;
        player.cHP = 1000;
        player.cMANA = 25;

        player.pBurn = 20;
        player.pDebuff = 20;
        player.pFreeze = 20;
        player.pAcid = 10;
        player.pStun = 40;
        player.pPoison = 20;
        player.pBleed = 40;

        player.WornEquipment.put("Head","Steel_Helmet");
        player.WornEquipment.put("Body","Steel_Platebody");
        player.WornEquipment.put("Legs","Steel_Platelegs");
        player.WornEquipment.put("Shield","Steel_Kiteshield");
        player.WornEquipment.put("Bow","Oak_Shortbow");
        player.WornEquipment.put("Boots","Steel_Boots");
        player.WornEquipment.put("Gloves","Leather_Gloves");
        player.WornEquipment.put("Weapon","Mythril_Sword");
        player.WornEquipment.put("Arrows", "Steel_Arrow");

        player.Attacks.addAll(Arrays.asList("Strike", "Slash","Spinning Slash", "Critical Blows", "Slam", "Evicerate", "Shoot Arrow", "Arcane Blade", "Magic Bolt", "Guard", "Way Of The Warrior"));

        break;

    case "pyroknight" :
        player.ATK = 230;
        player.DEF = 200;
        player.RNG = 150;
        player.MAGE = 100;
        player.AGIL = 100;
        player.HP = 2500;
        player.MANA = 25;
        player.Coins = 1250;
        player.LVL = 0;
        player.cHP = 2500;
        player.cMANA = 25;

        player.pBurn = 50;
        player.pDebuff = 20;
        player.pFreeze = 80;
        player.pAcid = 20;
        player.pStun = 40;
        player.pPoison = 20;
        player.pBleed = 40;

        player.WornEquipment.put("Head","Infernal_Helmet");
        player.WornEquipment.put("Body","Infernal_Chestplate");
        player.WornEquipment.put("Legs","Infernal_Platelegs");
        player.WornEquipment.put("Shield","Steel_Kiteshield");
        player.WornEquipment.put("Bow","Oak_Shortbow");
        player.WornEquipment.put("Boots","Steel_Boots");
        player.WornEquipment.put("Gloves","Leather_Gloves");
        player.WornEquipment.put("Weapon","Mythril_Sword");
        player.WornEquipment.put("Arrows", "Steel_Arrow");

        player.Attacks.addAll(Arrays.asList("Strike", "Slash","Spinning Slash", "Critical Blows", "Slam", "Evicerate", "Shoot Arrow", "Arcane Blade", "Magic Bolt", "Guard", "Way Of The Warrior"));

        break;

    case "bulwark" :
        player.ATK = 10;
        player.DEF = 100;
        player.RNG = 10;
        player.MAGE = 20;
        player.AGIL = 0;
        player.HP = 10000;
        player.MANA = 200;
        player.Coins = 1250;
        player.LVL = 0;
        player.cHP = 10000;
        player.cMANA = 200;

        player.pBurn = 50;
        player.pDebuff = 50;
        player.pFreeze = 20;
        player.pAcid = 10;
        player.pStun = 100;
        player.pPoison = 10;
        player.pBleed = 80;

        player.WornEquipment.put("Head","Steel_Helmet");
        player.WornEquipment.put("Body","Steel_Platebody");
        player.WornEquipment.put("Legs","Steel_Platelegs");
        player.WornEquipment.put("Shield","Shadow_Bulwark");
        player.WornEquipment.put("Bow","Oak_Shortbow");
        player.WornEquipment.put("Boots","Steel_Boots");
        player.WornEquipment.put("Gloves","Leather_Gloves");
        player.WornEquipment.put("Weapon","Mythril_Sword");
        player.WornEquipment.put("Arrows", "Steel_Arrow");

        player.Attacks.addAll(Arrays.asList("Strike", "Slash","Spinning Slash", "Critical Blows", "Slam", "Evicerate", "Shoot Arrow", "Arcane Blade", "Magic Bolt", "Guard", "Magic Guard", "Reflection Curse"));


         {



        }


        //add scavenger class, weaker stats but guranteed an item per combat encounter like potions and an extra item on boss encounters.

        //add a class which has access to many debuffs like blinds cripples and so on, rogue class?

    break;

}






}




}
