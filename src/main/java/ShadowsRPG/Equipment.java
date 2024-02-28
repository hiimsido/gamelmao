package ShadowsRPG;

import ShadowsRPG.Enums.playerEquipment;

import java.util.HashMap;

//redo this to add/remove on gear changes

public class Equipment {

    static int equipDef = 0;
    static int equipAtk = 0;
  static  int equipMag = 0;
  static  int equipRng = 0;
   static int equipAgil = 0;
   static int equipAbsorp = 0;
  static  int equipCrit = 0;

 static  int equipReflect = 0;

    public static void calcStats()
    {

        int ATK = 0;
        int DEF = 0;
        int MAGE = 0;
        int RNG = 0;
        int AGIL = 0;
        int CRIT = 0;
        int ABSORP = 0;
        int REFLECT = 0;
        //sum of all values

        if (!WornEquipment.get("Head").equalsIgnoreCase("none"))

        {


            playerEquipment.Head Item = playerEquipment.Head.valueOf(WornEquipment.get("Head"));

            ATK += Item.getATKVal();
            DEF += Item.getDEFVal();
            MAGE += Item.getMAGEVal();
            RNG += Item.getRNGVal();
            AGIL += Item.getAGILVal();
            CRIT += Item.getCritChance();
            ABSORP += Item.getAbsorption();
            REFLECT+= Item.getReflection();


        }

        if (!WornEquipment.get("Body").equalsIgnoreCase("none"))

        {


            playerEquipment.Body Item = playerEquipment.Body.valueOf(WornEquipment.get("Body"));

            ATK += Item.getATKVal();
            DEF += Item.getDEFVal();
            MAGE += Item.getMAGEVal();
            RNG += Item.getRNGVal();
            AGIL += Item.getAGILVal();
            CRIT += Item.getCritChance();
            ABSORP += Item.getAbsorption();
            REFLECT+= Item.getReflection();



        }

        if (!WornEquipment.get("Legs").equalsIgnoreCase("none"))

        {


            playerEquipment.Legs Item = playerEquipment.Legs.valueOf(WornEquipment.get("Legs"));

            ATK += Item.getATKVal();
            DEF += Item.getDEFVal();
            MAGE += Item.getMAGEVal();
            RNG += Item.getRNGVal();
            AGIL += Item.getAGILVal();
            CRIT += Item.getCritChance();
            ABSORP += Item.getAbsorption();
            REFLECT+= Item.getReflection();



        }

        if (!WornEquipment.get("Shield").equalsIgnoreCase("none"))

        {


            playerEquipment.Shield Item = playerEquipment.Shield.valueOf(WornEquipment.get("Shield"));

            ATK += Item.getATKVal();
            DEF += Item.getDEFVal();
            MAGE += Item.getMAGEVal();
            RNG += Item.getRNGVal();
            AGIL += Item.getAGILVal();
            CRIT += Item.getCritChance();
            ABSORP += Item.getAbsorption();
            REFLECT+= Item.getReflection();



        }

        if (!WornEquipment.get("Boots").equalsIgnoreCase("none"))

        {


            playerEquipment.Boots Item = playerEquipment.Boots.valueOf(WornEquipment.get("Boots"));

            ATK += Item.getATKVal();
            DEF += Item.getDEFVal();
            MAGE += Item.getMAGEVal();
            RNG += Item.getRNGVal();
            AGIL += Item.getAGILVal();
            CRIT += Item.getCritChance();
            ABSORP += Item.getAbsorption();
            REFLECT+= Item.getReflection();



        }

        if (!WornEquipment.get("Gloves").equalsIgnoreCase("none"))

        {


            playerEquipment.Gloves Item = playerEquipment.Gloves.valueOf(WornEquipment.get("Gloves"));

            ATK += Item.getATKVal();
            DEF += Item.getDEFVal();
            MAGE += Item.getMAGEVal();
            RNG += Item.getRNGVal();
            AGIL += Item.getAGILVal();
            CRIT += Item.getCritChance();
            ABSORP += Item.getAbsorption();
            REFLECT+= Item.getReflection();



        }

        if (!WornEquipment.get("Bow").equalsIgnoreCase("none"))

        {


            playerEquipment.Bow Item = playerEquipment.Bow.valueOf(WornEquipment.get("Bow"));

            MAGE += Item.getMAGEVal();
            RNG += Item.getRNGVal();
            CRIT += Item.getCritChance();



        }

        if (!WornEquipment.get("Weapon").equalsIgnoreCase("none"))

        {


            playerEquipment.Weapon Item = playerEquipment.Weapon.valueOf(WornEquipment.get("Weapon"));

            ATK += Item.getATKVal();
            MAGE += Item.getMAGEVal();
            AGIL += Item.getAGILVal();
            CRIT += Item.getCritChance();



        }

        if (!WornEquipment.get("Arrows").equalsIgnoreCase("none"))

        {


            playerEquipment.Arrows Item = playerEquipment.Arrows.valueOf(WornEquipment.get("Arrows"));

            RNG += Item.getRNGVal();





        }

      equipAtk =  ATK ;
       equipDef = DEF;
       equipMag = MAGE;
      equipRng =  RNG;
      equipAgil =  AGIL;
        equipCrit = CRIT;
       equipAbsorp = ABSORP;
       equipReflect = REFLECT;



    }

  public static HashMap<String,String> WornEquipment = new HashMap<>();

public static void testRun()
{

    // Create a function which adds every single value from the item to the equipment stats above. Thinking about checking all the words within it and storing them, then making if statements.


calcStats();






}





    //add an ID to track items, as it might be the best way to track values within an enum.

    public static void main(String[] args) {
        testRun();
    }



}