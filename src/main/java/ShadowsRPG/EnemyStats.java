package ShadowsRPG;


import ShadowsRPG.Enums.BuffEnum;
import ShadowsRPG.Enums.Enemies;
import ShadowsRPG.Enums.EnemyAttacks;
import ShadowsRPG.Enums.enemyResistances;
import ShadowsRPG.maps.enemyMovementBeta;

import java.util.*;

public class EnemyStats {
        public String Name;

        int[] formerPlayerLoc;

        int[] formerLocation;



    HashMap<String,Integer> temporaryWeakness = new HashMap<>();
    HashMap<String,Integer> temporaryResistances = new HashMap<>();

        ArrayList<String> Weakness, Resistances = new ArrayList<>();



    public ArrayList<String> ExtraCondition = new ArrayList<>();
    public ArrayList<String> StoredExtraCondition = new ArrayList<>();

        EnemyStats FollowAI;
        int[] Coordinates;

        int HP;

        int DEF;
        int ATK;
        int MAGE;
        int AGIL;
        String ATRI;
        String STATUS;
        int DUR;
        int cHP;
        int CRIT;
        int ABSORP;
        int MAGEABSORP;
    int MAGEREFLECT;
        int RNG;
        int DIST;
        int REFLECT;

        String ID;

        String AI;
        String TYPE;



    HashMap<String, Integer> Buffs = new HashMap<>();
    public HashMap<String, Integer> Debuffs = new HashMap<>();

    public HashMap<String,Integer> DebuffResists = new HashMap<>();
    public HashMap<String,Integer> TemporaryStats = new HashMap<>();
    public HashMap<String,Double> TemporaryMultiplier = new HashMap<>();




        HashSet<String> Immune = new HashSet<>();

      private LinkedHashMap<EnemyAttacks,Integer> Attacks = new LinkedHashMap<>();
        //create an enum and or an attack class. Figure out how to add a cooldown as well as AI behavior regarding which attacks to use. might be specific to enemies as per usual.


    /*  public EnemyStats(String name, int cMAGE, int cAGIL, int HP, int DEF, int ATK, int MAGE, int AGIL, String ATRI, String STATUS, int DUR, int cHP, int cDEF, int cATK, int CRIT, int ABSORP, int RANGE, int DIST, int DEFLECT) {

    Name = name;
          this.cMAGE = cMAGE;
          this.cAGIL = cAGIL;
          this.HP = HP;
          this.DEF = DEF;
          this.ATK = ATK;
          this.MAGE = MAGE;
          this.AGIL = AGIL;
          this.ATRI = ATRI;
          this.STATUS = STATUS;
          this.DUR = DUR;
          this.cHP = cHP;
          this.cDEF = cDEF;
          this.cATK = cATK;
          this.CRIT = CRIT;
          this.ABSORP = ABSORP;
          this.RANGE = RANGE;
          this.DIST = DIST;
          this.DEFLECT = DEFLECT;

      }*/

        public EnemyStats()
        {

        }

        public EnemyStats(Enemies enemy) {

            Name = enemy.getName();
            Coordinates = enemyMovementBeta.mapRandomizePosition(Name);
            HP = enemy.getHP();
            AGIL = enemy.getAGIL();
            ATK = enemy.getATK();
            RNG = enemy.getRANGE();
            MAGE = enemy.getMAGE();
            DEF = enemy.getDEF();
            ABSORP = enemy.getABSORP();
            REFLECT = enemy.getREFLECT();
            DIST = enemy.getDIST();
            cHP = HP;
            AI = enemy.getAI();
            CRIT = enemy.getCRIT();
            TYPE = enemy.getType();
            DUR = enemy.getDUR();
            MAGEABSORP = enemy.getMAGEABSORP();
            MAGEREFLECT = enemy.getMAGEREFLECT();
            Weakness = new ArrayList<>(List.of(enemy.getWeakness()));
            Resistances = new ArrayList<>(List.of(enemy.getResistance()));
// Ternary, if name present in enum, take enum value, otherwise, run base value
            enemyResistances.setStats(enemy.getDebuffRes(),DebuffResists);

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

            for (String each: enemy.getAttacks()
                 ) {

                EnemyAttacks a = EnemyAttacks.valueOf(each);

                Attacks.put(a,a.getCurrentCD());

            }




            //need to make a class in the enum, which stores ATTACK CATEGORIES like magic or other attacks, but for now we will use DIST from the enum as we are making a beta.

            // need to create an AI as well.

            //consider XP and wealth?




        }


    public void enemyStatAdd(String buff)
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
          //  System.out.println("Error. " + buff + " does not exist." );
        }

    }

    public void enemyStatSubtract(String buff)
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
           // System.out.println("Error. " + buff + " does not exist." );
        }

    }

    public int getRNG()
    {
        return RNG;
    }


        public void setHP(int HP) {
            this.HP = HP;
        }



        public void setcHP(int cHP) {
            this.cHP = cHP;
        }


    public int getHP()
    {
        return cHP;
    }

    public int getDUR()
    {
        return DUR;
    }

    public HashMap<EnemyAttacks,Integer> getAttacks() {return Attacks;}

    public String getType() {return TYPE;}

    public String getAI()
    {
        return AI;
    }

    //potentially put in the deal damage stuff inside here
    public void damageDealt (int Damage)
    {
        this.cHP-= Damage;
    }

    public int getDeflect() {return REFLECT;}
    public int getABSORP() {return ABSORP;}


    public int getDEF() {
        return DEF;
    }

    public int getATK() {
        return ATK;
    }

    public int getMAGE() {
        return MAGE;
    }

    public int getAGIL() {
        return AGIL;
    }

    public String getATRI() {
        return ATRI;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public int getcHP() {
        return cHP;
    }

    public int getCRIT() {
        return CRIT;
    }

    public int getMAGEABSORP() {
        return MAGEABSORP;
    }

    public int getMAGEREFLECT() {
        return MAGEREFLECT;
    }


    public int getDIST() {
        return DIST;
    }

    public int getDEFLECT() {
        return REFLECT;
    }

    public String getTYPE() {
        return TYPE;
    }


    public void setCoord (int[] Coordinates)
        {
            this.Coordinates = Coordinates;
        };

        public int[] getPlayerLoc()
    {
        return formerPlayerLoc;
    }


        public int[] getCoord()
        {
            return Coordinates;
        }

        public String getID()
    {
        return ID;
    }

    public void setID(String id)
    {
        this.ID = id;
    }

    public ArrayList<String> getWeakness() {
        return Weakness;
    }

    public ArrayList<String> getResistances() {
        return Resistances;
    }

    public HashMap<String, Integer> getTemporaryWeakness() {
        return temporaryWeakness;
    }

    public HashMap<String, Integer> getTemporaryResistances() {
        return temporaryResistances;
    }

    public void setAttackCooldown(String a,int b)
    {
        getAttacks().put(EnemyAttacks.valueOf(a),b);
    }

      /*  @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer(spawnEnemyTwo.Enemy.size());
            return sb.toString();
        }*/
    }

