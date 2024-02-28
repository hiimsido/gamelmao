package ShadowsRPG;

import ShadowsRPG.Enums.Attack;
import ShadowsRPG.Enums.BuffEnum;
import ShadowsRPG.Enums.playerEquipment;
import ShadowsRPG.Enums.Spells;

import java.util.*;

public class Player {

     int equipDef = 0;
     int equipAtk = 0;
     int equipMag = 0;
      int equipRng = 0;
      int equipAgil = 0;
    int equipAbsorp = 0;
     int equipCrit = 0;

    int equipReflect = 0;
    int equipMageabsorp = 0;
    int equipMagereflect = 0;

    int gearDebuff = 0;

    int gearAcid = 0;
    int gearPoison = 0;
    int gearBleed = 0;
    int gearFreeze = 0;
    int gearBurn = 0;
    int gearStun = 0;

    HashMap<String,Integer> gearWeakness = new HashMap<>();
    HashMap<String,Integer> gearResistances = new HashMap<>();

    public HashMap<String, Integer> getTemporaryResistances() {
        return temporaryResistances;
    }

    public HashMap<String, Integer> getTemporaryWeakness() {
        return temporaryWeakness;
    }

    public HashMap<String, Integer> getGearWeakness() {
        return gearWeakness;
    }

    public HashMap<String, Integer> getGearResistances() {
        return gearResistances;
    }


    HashMap<String,Integer> temporaryResistances = new HashMap<>();



    HashMap<String,Integer>  temporaryWeakness = new HashMap<>();


    public void statCalc()
    {
        cATK = ATK + equipAtk;
        cRNG = RNG + equipRng;
        cMAGE = MAGE + equipMag;
        cDEF = DEF + equipDef;
        cAGIL = AGIL + equipAgil;
        REFLECT = equipReflect;
        ABSORP = equipAbsorp;
        CRIT = equipCrit;
        MAGEABSORP = equipMageabsorp;
        MAGEREFLECT = equipMagereflect;

        System.out.println(cATK);
        System.out.println(cRNG);
        System.out.println(cMAGE);
        System.out.println(cDEF);
        System.out.println(cAGIL);
        System.out.println(REFLECT);
        System.out.println(ABSORP);
        System.out.println(CRIT);
        System.out.println(MAGEABSORP);
        System.out.println(MAGEREFLECT);

        DebuffResists.put("Stun", pStun + gearStun);
        DebuffResists.put("Freeze", pFreeze + gearFreeze);
        DebuffResists.put("Burn", pBurn + gearBurn);
        DebuffResists.put("Bleed", pBleed + gearPoison);
        DebuffResists.put("Poison", pPoison + gearPoison);
        DebuffResists.put("Acid", pAcid + gearAcid);
        DebuffResists.put("Debuff", pDebuff + gearDebuff);

        TemporaryStats.put("Stun",0);
        TemporaryStats.put("Freeze",0);
        TemporaryStats.put("Burn",0);
        TemporaryStats.put("Bleed",0);
        TemporaryStats.put("Poison",0);
        TemporaryStats.put("Acid",0);
        TemporaryStats.put("Debuff",0);


        TemporaryStats.put("ATK",0);
        TemporaryStats.put("ACC",0);
        TemporaryStats.put("RNG",0);
        TemporaryStats.put("MAGE",0);
        TemporaryStats.put("AGIL",0);
        TemporaryStats.put("DEF",0);
        TemporaryStats.put("CRIT",0);
        TemporaryStats.put("ABSORP",0);
        TemporaryStats.put("REFLECT",0);
        TemporaryStats.put("MAGEREFLECT",0);
        TemporaryStats.put("MAGEABSORP",0);
        TemporaryStats.put("DODGE",0);





        TemporaryMultiplier.put("ATKmod",0.0);
        TemporaryMultiplier.put("ACCmod",0.0);
        TemporaryMultiplier.put("RNGmod",0.0);
        TemporaryMultiplier.put("MAGEmod",0.0);
        TemporaryMultiplier.put("AGILmod",0.0);
        TemporaryMultiplier.put("DEFmod",0.0);
        TemporaryMultiplier.put("CRITmod",0.0);
        TemporaryMultiplier.put("DODGEmod",0.0);



    }

    //resistances



    public HashMap<String,Integer> DebuffResists = new HashMap<>();
    public HashMap<String,Integer> TemporaryStats = new HashMap<>();
    public HashMap<String,Double> TemporaryMultiplier = new HashMap<>();

    public HashMap<String,Integer> Weakness = new HashMap<>();
    public HashMap<String,Integer> Resistance = new HashMap<>();


    public void playerStatAdd(String buff)
    {

        //make hashmap so that I can do an EACH piece of code for simplicity :)

        try{

          BuffEnum buffType = BuffEnum.valueOf(buff);


            TemporaryStats.compute("Stun", (key,val) -> val + buffType.getSTUN());
            TemporaryStats.compute("Freeze", (key,val) -> val + buffType.getFREEZE());
            TemporaryStats.compute("Burn", (key,val) -> val + buffType.getBURN());
            TemporaryStats.compute("Bleed", (key,val) -> val + buffType.getBLEED());
            TemporaryStats.compute("Poison", (key,val) -> val + buffType.getPOISON());
            TemporaryStats.compute("Acid", (key,val) -> val + buffType.getACID());
            TemporaryStats.compute("Debuff", (key,val) -> val + buffType.getDEBUFF());

            TemporaryStats.compute("ATK", (key,val) -> val + buffType.getATK());
            TemporaryStats.compute("DEF", (key,val) -> val + buffType.getDEF());
            TemporaryStats.compute("RNG", (key,val) -> val + buffType.getRNG());
            TemporaryStats.compute("MAGE", (key,val) -> val + buffType.getMAGE());
            TemporaryStats.compute("AGIL", (key,val) -> val + buffType.getAGIL());
            TemporaryStats.compute("CRIT", (key,val) -> val + buffType.getCRIT());
            TemporaryStats.compute("ABSORP", (key,val) -> val + buffType.getABSORP());
            TemporaryStats.compute("REFLECT", (key,val) -> val + buffType.getREFLECT());
            TemporaryStats.compute("MAGEABSORP", (key,val) -> val + buffType.getMAGEABSORP());
            TemporaryStats.compute("MAGEREFLECT", (key,val) -> val + buffType.getMAGEREFLECT());
            TemporaryStats.compute("DODGE", (key,val) -> val + buffType.getDODGE());


            TemporaryMultiplier.compute("ATKmod", (key,val) -> val + buffType.getATKmod());
            TemporaryMultiplier.compute("DEFmod", (key,val) -> val + buffType.getDEFmod());
            TemporaryMultiplier.compute("RNGmod", (key,val) -> val + buffType.getRNGmod());
            TemporaryMultiplier.compute("MAGEmod", (key,val) -> val + buffType.getMAGEmod());
            TemporaryMultiplier.compute("AGILmod", (key,val) -> val + buffType.getAGILmod());
            TemporaryMultiplier.compute("ACCmod", (key,val) -> val + buffType.getACCmod());
            TemporaryMultiplier.compute("CRITmod", (key,val) -> val + buffType.getCRITmod());
            TemporaryMultiplier.compute("DODGEmod", (key,val) -> val + buffType.getDODGEmod());




        }

        catch(Exception e)
        {
            System.out.println("Error. " + buff + " does not exist." );
        }

    }

    public void playerStatSubtract(String buff)
    {

        //make hashmap so that I can do an EACH piece of code for simplicity :)

        try{

            BuffEnum buffType = BuffEnum.valueOf(buff);

            TemporaryStats.compute("Stun", (key,val) -> val - buffType.getSTUN());
            TemporaryStats.compute("Freeze", (key,val) -> val - buffType.getFREEZE());
            TemporaryStats.compute("Burn", (key,val) -> val - buffType.getBURN());
            TemporaryStats.compute("Bleed", (key,val) -> val - buffType.getBLEED());
            TemporaryStats.compute("Poison", (key,val) -> val - buffType.getPOISON());
            TemporaryStats.compute("Acid", (key,val) -> val - buffType.getACID());
            TemporaryStats.compute("Debuff", (key,val) -> val - buffType.getDEBUFF());

            TemporaryStats.compute("ATK", (key,val) -> val - buffType.getATK());
            TemporaryStats.compute("DEF", (key,val) -> val - buffType.getDEF());
            TemporaryStats.compute("RNG", (key,val) -> val - buffType.getRNG());
            TemporaryStats.compute("MAGE", (key,val) -> val - buffType.getMAGE());
            TemporaryStats.compute("AGIL", (key,val) -> val - buffType.getAGIL());
            TemporaryStats.compute("CRIT", (key,val) -> val - buffType.getCRIT());
            TemporaryStats.compute("ABSORP", (key,val) -> val - buffType.getABSORP());
            TemporaryStats.compute("REFLECT", (key,val) -> val - buffType.getREFLECT());
            TemporaryStats.compute("MAGEABSORP", (key,val) -> val - buffType.getMAGEABSORP());
            TemporaryStats.compute("MAGEREFLECT", (key,val) -> val - buffType.getMAGEREFLECT());
            TemporaryStats.compute("DODGE", (key,val) -> val - buffType.getDODGE());

            TemporaryMultiplier.compute("ATKmod", (key,val) -> val - buffType.getATKmod());
            TemporaryMultiplier.compute("DEFmod", (key,val) -> val - buffType.getDEFmod());
            TemporaryMultiplier.compute("RNGmod", (key,val) -> val - buffType.getRNGmod());
            TemporaryMultiplier.compute("MAGEmod", (key,val) -> val - buffType.getMAGEmod());
            TemporaryMultiplier.compute("AGILmod", (key,val) -> val - buffType.getAGILmod());
            TemporaryMultiplier.compute("ACCmod", (key,val) -> val - buffType.getACCmod());
            TemporaryMultiplier.compute("CRITmod", (key,val) -> val - buffType.getCRITmod());
            TemporaryMultiplier.compute("DODGEmod", (key,val) -> val - buffType.getDODGEmod());


        }

        catch(Exception e)
        {
            System.out.println("Error. " + buff + " does not exist." );
        }

    }

    public  void calcGear()
    {
        gearResistances = new HashMap<>();
        gearWeakness = new HashMap<>();
        ArrayList<int[]> debuff = new ArrayList<>();

        int ATK = 0;
        int DEF = 0;
        int MAGE = 0;
        int RNG = 0;
        int AGIL = 0;
        int CRIT = 0;
        int ABSORP = 0;
        int REFLECT = 0;
        int MAGEREFLECT = 0;
        int MAGEABSORP = 0;
        int DEBUFF = 0;
        int ACID = 0;
        int BLEED = 0;
        int FREEZE = 0;
        int POISON = 0;
        int STUN = 0;
        int BURN = 0;
        gearAttacks = new LinkedList<>();
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
            MAGEREFLECT+=Item.getMageReflection();
            MAGEABSORP+=Item.getMageAbsorption();
            debuff.add(Item.getDebuffVal());

            for(String each : Item.getResistance()) {
                gearResistances.put(each, gearResistances.containsKey(each) ? gearResistances.get(each) + 1 : 1);
            }

            for(String each : Item.getWeakness()) {
                gearWeakness.put(each, gearWeakness.containsKey(each) ? gearWeakness.get(each) + 1 : 1);
            }


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
            MAGEREFLECT+=Item.getMageReflection();
            MAGEABSORP+=Item.getMageAbsorption();
            debuff.add(Item.getDebuffVal());

            for(String each : Item.getResistance()) {
                gearResistances.put(each, gearResistances.containsKey(each) ? gearResistances.get(each) + 1 : 1);
            }

            for(String each : Item.getWeakness()) {
                gearWeakness.put(each, gearWeakness.containsKey(each) ? gearWeakness.get(each) + 1 : 1);
            }

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
            MAGEREFLECT+=Item.getMageReflection();
            MAGEABSORP+=Item.getMageAbsorption();
            debuff.add(Item.getDebuffVal());

            for(String each : Item.getResistance()) {
                gearResistances.put(each, gearResistances.containsKey(each) ? gearResistances.get(each) + 1 : 1);
            }

            for(String each : Item.getWeakness()) {
                gearWeakness.put(each, gearWeakness.containsKey(each) ? gearWeakness.get(each) + 1 : 1);
            }
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
            MAGEREFLECT+=Item.getMageReflection();
            MAGEABSORP+=Item.getMageAbsorption();
            debuff.add(Item.getDebuffVal());
            if (Item.getAttack() != null)
            {
                gearAttacks.addAll(Arrays.asList(Item.getAttack()));
            }
            for(String each : Item.getResistance()) {
                gearResistances.put(each, gearResistances.containsKey(each) ? gearResistances.get(each) + 1 : 1);
            }

            for(String each : Item.getWeakness()) {
                gearWeakness.put(each, gearWeakness.containsKey(each) ? gearWeakness.get(each) + 1 : 1);
            }

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
            MAGEREFLECT+=Item.getMageReflection();
            MAGEABSORP+=Item.getMageAbsorption();
            debuff.add(Item.getDebuffVal());

            for(String each : Item.getResistance()) {
                gearResistances.put(each, gearResistances.containsKey(each) ? gearResistances.get(each) + 1 : 1);
            }

            for(String each : Item.getWeakness()) {
                gearWeakness.put(each, gearWeakness.containsKey(each) ? gearWeakness.get(each) + 1 : 1);
            }
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
            MAGEREFLECT+=Item.getMageReflection();
            MAGEABSORP+=Item.getMageAbsorption();
            debuff.add(Item.getDebuffVal());


            for(String each : Item.getResistance()) {
                gearResistances.put(each, gearResistances.containsKey(each) ? gearResistances.get(each) + 1 : 1);
            }

            for(String each : Item.getWeakness()) {
                gearWeakness.put(each, gearWeakness.containsKey(each) ? gearWeakness.get(each) + 1 : 1);
            }
        }

        if (!WornEquipment.get("Bow").equalsIgnoreCase("none"))

        {


            playerEquipment.Bow Item = playerEquipment.Bow.valueOf(WornEquipment.get("Bow"));

            MAGE += Item.getMAGEVal();
            RNG += Item.getRNGVal();
            CRIT += Item.getCritChance();
            if (Item.getAttack() != null)
            {
                gearAttacks.addAll(Arrays.asList(Item.getAttack()));
            }
            for(String each : Item.getResistance()) {
                gearResistances.put(each, gearResistances.containsKey(each) ? gearResistances.get(each) + 1 : 1);
            }

            for(String each : Item.getWeakness()) {
                gearWeakness.put(each, gearWeakness.containsKey(each) ? gearWeakness.get(each) + 1 : 1);
            }

        }

        if (!WornEquipment.get("Weapon").equalsIgnoreCase("none"))

        {


            playerEquipment.Weapon Item = playerEquipment.Weapon.valueOf(WornEquipment.get("Weapon"));

            ATK += Item.getATKVal();
            MAGE += Item.getMAGEVal();
            AGIL += Item.getAGILVal();
            CRIT += Item.getCritChance();

            if (Item.getAttack() != null)
            {
                gearAttacks.addAll(Arrays.asList(Item.getAttack()));
            }
            for(String each : Item.getResistance()) {
                gearResistances.put(each, gearResistances.containsKey(each) ? gearResistances.get(each) + 1 : 1);
            }

            for(String each : Item.getWeakness()) {
                gearWeakness.put(each, gearWeakness.containsKey(each) ? gearWeakness.get(each) + 1 : 1);
            }
        }

        if (!WornEquipment.get("Arrows").equalsIgnoreCase("none"))

        {


            playerEquipment.Arrows Item = playerEquipment.Arrows.valueOf(WornEquipment.get("Arrows"));

            RNG += Item.getRNGVal();

            if (Item.getAttack() != null)
            {
                gearAttacks.addAll(Arrays.asList(Item.getAttack()));
            }
            for(String each : Item.getResistance()) {
                gearResistances.put(each, gearResistances.containsKey(each) ? gearResistances.get(each) + 1 : 1);
            }

            for(String each : Item.getWeakness()) {
                gearWeakness.put(each, gearWeakness.containsKey(each) ? gearWeakness.get(each) + 1 : 1);
            }


        }

        equipAtk =  ATK ;
        equipDef = DEF;
        equipMag = MAGE;
        equipRng =  RNG;
        equipAgil =  AGIL;
        equipCrit = CRIT;
        equipAbsorp = ABSORP;
        equipReflect = REFLECT;
        equipMagereflect = MAGEREFLECT;
        equipMageabsorp = MAGEABSORP;

        for (int[] each : debuff)
        {
            DEBUFF += each[0];
            ACID += each[1];
            BLEED += each[2];
            FREEZE += each[3];
            POISON += each[4];
            STUN += each[5];
            BURN += each[6];
        }

        gearDebuff = DEBUFF;
        gearAcid = ACID;
        gearBleed = BLEED;
        gearFreeze = FREEZE;
        gearPoison = POISON;
        gearStun = STUN;
        gearBurn = BURN;




    }


    public int ATK, RNG, MAGE, DEF, AGIL, HP, MANA, LVL, pBurn, pPoison, pStun, pAcid, pFreeze, pBleed, pDebuff = 0; //base stats
    public int cATK, cRNG, cMAGE, cDEF, cAGIL, cHP, cMANA, CRIT, ABSORP, REFLECT, MAGEABSORP, MAGEREFLECT = 0 ; //current stats


    public int[] coordinates;
    public int Coins = 0;



    public HashMap<String,String> WornEquipment = new HashMap<>();
    public HashMap<String,Integer> Inventory = new HashMap<>();

    // figure out how to get rid of attacks if temporary
    public LinkedList<String> Attacks = new LinkedList<>();
    public LinkedList<String> gearAttacks = new LinkedList<>();
     public LinkedHashMap<String, Attack> Options = new LinkedHashMap<>();
     public LinkedHashMap<String, Spells> Spells = new LinkedHashMap<>();
     public HashMap<String,Integer> Buffs = new HashMap<>();
    public HashMap<String,Integer> Debuffs = new HashMap<>();

    public int getEquipDef() {
        return equipDef;
    }

    public int getEquipAtk() {
        return equipAtk;
    }

    public int getEquipMag() {
        return equipMag;
    }

    public int getEquipRng() {
        return equipRng;
    }

    public int getEquipAgil() {
        return equipAgil;
    }

    public int getEquipAbsorp() {
        return equipAbsorp;
    }

    public int getEquipCrit() {
        return equipCrit;
    }

    public int getEquipReflect() {
        return equipReflect;
    }

    public int getEquipMageabsorp() {
        return equipMageabsorp;
    }

    public int getEquipMagereflect() {
        return equipMagereflect;
    }

    public HashMap<String, Integer> getDebuffResists() {
        return DebuffResists;
    }

    public HashMap<String, Integer> getTemporaryStats() {
        return TemporaryStats;
    }

    public HashMap<String, Double> getTemporaryMultiplier() {
        return TemporaryMultiplier;
    }

    public int getATK() {
        return ATK;
    }

    public int getRNG() {
        return RNG;
    }

    public int getMAGE() {
        return MAGE;
    }

    public int getDEF() {
        return DEF;
    }

    public int getAGIL() {
        return AGIL;
    }

    public int getHP() {
        return HP;
    }

    public int getMANA() {
        return MANA;
    }

    public int getLVL() {
        return LVL;
    }

    public int getcATK() {
        return cATK;
    }

    public int getcRNG() {
        return cRNG;
    }

    public int getcMAGE() {
        return cMAGE;
    }

    public int getcDEF() {
        return cDEF;
    }

    public int getcAGIL() {
        return cAGIL;
    }

    public int getcHP() {
        return cHP;
    }

    public int getcMANA() {
        return cMANA;
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

    public int[] getCoordinates() {
        return coordinates;
    }

    public int getCoins() {
        return Coins;
    }

    public HashMap<String, String> getWornEquipment() {
        return WornEquipment;
    }

    public HashMap<String, Integer> getInventory() {
        return Inventory;
    }

    public LinkedList<String> getAttacks() {
        return Attacks;
    }

    public LinkedHashMap<String, Attack> getOptions() {
        return Options;
    }

    public LinkedHashMap<String, ShadowsRPG.Enums.Spells> getSpells() {
        return Spells;
    }

    public HashMap<String, Integer> getBuffs() {
        return Buffs;
    }

    public HashMap<String, Integer> getDebuffs() {
        return Debuffs;
    }

    public int getMAGEABSORP() {
        return MAGEABSORP;
    }

    public int getMAGEREFLECT() {
        return MAGEREFLECT;
    }


}
