package ShadowsRPG;

public class ClassStart {

public static void START(String Choice)
{

switch(Choice)
{
    case "initiate" :
        MainGame.ATK = 100;
        MainGame.DEF = 100;
        MainGame.RNG = 100;
        MainGame.MAGE = 100;
        MainGame.AGIL = 150;
        MainGame.HP = 1000;
        MainGame.MANA = 50;
        MainGame.Coins = 2000;
        MainGame.LVL = 0;

        MainGame.cATK = 100;
        MainGame.cDEF = 100;
        MainGame.cRNG = 100;
        MainGame.cMAGE = 100;
        MainGame.cAGIL = 150;
        MainGame.cHP = 1000;
        MainGame.cMANA = 50;
        break;


    case "mager" :
    MainGame.ATK = 75;
    MainGame.DEF = 100;
    MainGame.RNG = 75;
    MainGame.MAGE = 150;
    MainGame.AGIL = 125;
    MainGame.HP = 1000;
    MainGame.MANA = 100;
    MainGame.Coins = 750;
    MainGame.LVL = 0;

        MainGame.cATK = 75;
        MainGame.cDEF = 100;
        MainGame.cRNG = 75;
        MainGame.cMAGE = 150;
        MainGame.cAGIL = 125;
        MainGame.cHP = 1000;
        MainGame.cMANA = 100;
    break;

    case "archer" :
        MainGame.ATK = 75;
        MainGame.DEF = 75;
        MainGame.RNG = 150;
        MainGame.MAGE = 75;
        MainGame.AGIL = 200;
        MainGame.HP = 1000;
        MainGame.MANA = 25;
        MainGame.Coins = 500;
        MainGame.LVL = 0;

        MainGame.cATK = 75;
        MainGame.cDEF = 75;
        MainGame.cRNG = 150;
        MainGame.cMAGE = 75;
        MainGame.cAGIL = 200;
        MainGame.cHP = 1000;
        MainGame.cMANA = 25;
        break;

    case "knight" :
        MainGame.ATK = 150;
        MainGame.DEF = 150;
        MainGame.RNG = 100;
        MainGame.MAGE = 100;
        MainGame.AGIL = 100;
        MainGame.HP = 1000;
        MainGame.MANA = 50;
        MainGame.Coins = 1250;
        MainGame.LVL = 0;

        MainGame.cATK = 150;
        MainGame.cDEF = 150;
        MainGame.cRNG = 100;
        MainGame.cMAGE = 100;
        MainGame.cAGIL = 100;
        MainGame.cHP = 1000;
        MainGame.cMANA = 50;

    break;

}




}




}
