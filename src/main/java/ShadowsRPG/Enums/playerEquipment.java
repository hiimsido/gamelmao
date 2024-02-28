package ShadowsRPG.Enums;

public class playerEquipment {

    //add attacks per weapon. Such as daggers getting assassinate, sword's getting an atk in the middle, axe's getting heavy atks, etc

    //add BANE, which deals additional damage to targets if they're weak to it (could be percentage of HP?)


    public enum Weapon {

        Steel_Sword("Steel Sword", 200, 0,100, 2, -20,1,"A fine crafted steel weapon, ready to slay the baddies!", new String[]{"None"}, 0, 0, new String[] {"Slash"},new String[]{"None"},"None"),

        Magic_Wand("Magic Wand", 200, 0,10, 2, 50,1,"A basic wand, imbued in magic.", new String[]{"None"}, 0, 1, new String[] {"Flurry"},new String[]{"None"},"None"),

        Mythril_Sword("Mythril Sword", 500, 0,140, 5, -20, 1,"A weapon made from the rare material, Mythril.", new String[]{"None"}, 1, 2, new String[] {"Slash"},new String[]{"None"},"None"),

        Mystic_Wand("Magic Wand", 400, 0,20, 5, 200,1,"I can feel the energy surging within this wand.", new String[]{"None"}, 0, 4, new String[] {"Arcane_Flurry"},new String[]{"None"},"None"),

        Magic_Staff("Magic Staff", 400, -50,30, 0, 300,2,"A large staff, crafted in magic wood.", new String[]{"None"}, 0, 5, new String[] {"Arcane_Comet"},new String[]{"None"},"None"),

        Mythril_Dagger("Mythril Dagger", 500, 10,100, 15, 0, 1,"A lightweight weapon made from the rare material, Mythril.", new String[]{"None"}, 1, 6, new String[] {"Swift_Strike","Stab"},new String[]{"None"},"None"),

        Flameblade("Flameblade", 1000, 0,200, 10, -40,1,"A sword, covered in an eternal flame.", new String[]{"Fire"}, 2, 7, new String[] {"Fire_Slash","Slash"},new String[]{"None"},"Fire"),

        Chaos_Wand("Chaos Wand", 2000, 0,25, 10, 250,1,"Imbued in the magics of chaos, you know it was used for evil purposes.", new String[]{"None"}, 2, 8, new String[] {"Bouncing_Skull","Chaos_Volley"},new String[]{"None"},"None"),

        Chaos_Battlestaff("Chaos Battlestaff", 2000, -100,100, 2, 450,2,"Imbued with evil magics, allowing a caster to blast whomever opposes them. You feel the evil intent while in the presence of this item.", new String[]{"None"}, 2, 9, new String[] {"Chaos_Blast","Arcane_Comet"},new String[]{"None"},"None"),

        Reinforced_Mace("Reinforced Mace", 600, -15,150, 5, -50,1,"A light yet hardhitting steel mace.", new String[]{"None"}, 2, 10, new String[] {"Crushing_Blow","Smash","Blunt_Trauma"},new String[]{"None"},"None"),

        Dragonbone_Spear("Dragonbone Spear", 2000, -60,250, 10, -100,2,"A crudely made spear. But it has more reach then other weapons.", new String[]{"None"}, 3, 11, null,new String[]{"None"},"Dragon"),

        Titan_Sword("Titan Sword", 3000, -50,350, 3, -40,1,"A blade forged by the titan, a man who towered all he came across.", new String[]{"None"}, 3, 12, null,new String[]{"None"},"None"),

        Blood_Blade("Bloodletter Blade", 10000, 0,300, 20, -100,1,"A sword which thirsts for blood. Created by the Haemalchemy Demons.", new String[]{"Blood"}, 4, 13, null,new String[]{"None"},"Blood"),

        Giants_Axe_Of_Chaos("Giants Axe Of Chaos", 10000, -30,450, 5, -200,1,"A large axe, one which has been used in many battles, but not for a good cause.", new String[]{"None"}, 4, 14, new String[] {"Heavy_Slash","Spinning_Slash"},new String[]{"None"},"None"),

        Sword_Of_Edmond("Sword Of Edmond", 20000, 0,600, 25, -80,1,"The legendary sword of Edmond, which slayed many evildoers.", new String[]{"None"}, 6, 15, new String[] {"Edmonds_Courge","Sword_Deflection","Smite_Thy_Evildoer"},new String[]{"None"},"None"),

        Demon_Greataxe("Demon Greataxe", 5000, -50,900, 0, -40,1,"A large, heavy, hardhitting axe forged by metals not of this world. Imbued in blood.", new String[]{"Blood"}, 5, 16, new String[] {"Heavy_Slash","Spinning_Slash","Lifeleach","Blood_Price"},new String[]{"None"},"None"),

        Gorgons_Wand("Gorgon's Wand", 10000, 0,50, 40, 1000,1,"A wand held by Gorgon, the first sage.", new String[]{"None"}, 5, 17, null,new String[]{"None"},"Ice"),

        Staff_Of_The_Dark_Sage("Staff Of The Dark Sage", 10000, -100,200, 20, 1000,2,"The Sage order, were the strongest mages in the land, but they were corrupted on their mission to undo the chaos caused by the evil one.", new String[]{"None"}, 5, 18, new String[] {"Arcane_Comet","Lightning_Strike","Icethrower","Flamethrower","Shadow_Blast"},new String[]{"None"},"Ice"),

        Dagger_Of_The_Frostwaker("Dagger Of The Frostwaker", 10000, 50, 250, 40, 0,1,"A weapon wielded by the legendary knights of the waker mountains, empowered by ice magics.", new String[]{"Ice"}, 5, 19, new String[] {"Stab","Frostwakers_Curse"},new String[]{"None"},"Ice"),

        Pyrosteel_Blade("Pyrosteel Blade", 10000, 0, 400, 20, 0,1,"A powerful blade imbued by flames, once held by the demon riders.", new String[]{"Fire"}, 5, 20, new String[] {"Fire_Strike","Pyre_Dance","Slice_And_Dice"},new String[]{"None"},"Fire"),

        The_Shadow_Longsword("The Shadow Longsword", 1000000, 200, 1000, 40,0,2,"A sword which appears to be the physical manifestation of a shadow. It's abilities are unknown.", new String[]{"Shadow"}, 1000, 21, new String[] {"Unleash_Shadow","Shadow_Slash","Shadow_Lunge","Afterimage_Slash"},new String[]{"None"},"Shadow"),


        Shadow_Of_Gorgon("Shadow Of Gorgon", 1000000, 200, 300, 40,1500,2,"Gorgon before death, removed his shadow, and imbued it into this mastercrafted staff. It was unknown of the truths of this tale, but this staffs power should not be ignored.", new String[]{"Shadow"}, 1000, 22, new String[] {"Shadow_Barrage","Shadow_Comet","Shadow_Curse","Shadow_Lightning","Shadow_Eruption","Black_Hole"}, new String[]{"None"},"Shadow");

        //shadow weapons could have a roulette of things they could do.

  /*  Mythril_Sword("Steel Sword", 2000),
    Frostwaker_Dagger("Dagger Of The Frostwaker")
    Titan_Sword("Steel Sword", 5000),
    Blood_Blade("Steel Sword", 10000),
    Axe_Of_Chaos("Steel Sword", 10000),
    Longblade_Of_Shadows("Steel Sword", 100_000)

   */


        private final String Name;
        private final int ATKValue;
        private final int CritChance;
        private final int Value;

        private final String[] Resistance,Weakness;

        private final String Description;
        private final int tier;
        private final int ID;

        private final int MAGEVal;
        private final int AGILVal;

        private final int DIST;

        private final String[] attacks;
        private final String bane;


        Weapon(String Name, int Value, int AGILVal, int ATKVal, int CritChance, int MAGEVal, int DIST, String Description, String[] Resistance, int tier, int ID, String[] attacks, String[] Weakness, String bane) {

            this.ATKValue = ATKVal;
            this.Name = Name;
            this.Value = Value;
            this.Description = Description;
            this.Resistance = Resistance;
            this.CritChance = CritChance;
            this.tier = tier;
            this.ID = ID;
            this.MAGEVal = MAGEVal;
            this.AGILVal = AGILVal;
            this.DIST = DIST;
            this.attacks = attacks;
            this.Weakness = Weakness;
            this.bane = bane;
        }

        public String getName() {
            return Name;
        }

        public int getDIST() {return DIST;}

        public int getATKVal() {
            return ATKValue;
        }

        public int getCritChance() {
            return CritChance;
        }

        public int getValue() {
            return Value;
        }

        public String[] getResistance() {
            return Resistance;
        }
        public String[] getWeakness() {
            return Weakness;
        }

        public String getDescription() {
            return Description;
        }

        public int getTier() {
            return tier;
        }

        public int getID() {
            return ID;
        }

        public int getMAGEVal() {
            return MAGEVal;
        }

        public int getAGILVal() {
            return AGILVal;
        }
        public String[] getAttack() {return attacks;}

        public String getBane() {return bane;}


    }

    public enum Bow {

        Wooden_Bow( "Wooden Bow", 30,0, 100, 0, 3, 0, 0, "A sturdy wooden bow, not the best but it gets the job done", new String[]{"None"}, null,new String[]{"None"},"None"),

        Crossbow( "Crossbow", 60,0, 100, 0, 1, 0, 0, "A wooden crossbow, effective for close encounters", new String[]{"None"}, new String[] {"Bolt_Shot","Tumbleshot"},new String[]{"None"},"None"),

        Oak_Shortbow("Oak Shortbow", 120, 0, 300,10,3,1,1,"A short range bow made of oak.", new String[]{"None"}, null,new String[]{"None"},"None"),

        Oak_Longbow("Oak Longbow", 120, 0, 300,0,4,1,1,"A long range bow made of oak.", new String[]{"None"}, null,new String[]{"None"},"None"),

        Maple_Longbow("Maple Longbow", 150, 0, 300,0,4,1,1,"A long range bow made of oak.", new String[]{"None"}, null,new String[]{"None"},"None"),

        Frost_Bow("Frozen Bow", 150, 0, 1000,5,3,2,1,"A wooden bow imbued in ice.", new String[]{"Ice"}, new String[] {}, new String[]{"Fire"},"Ice"),

        Flaming_Bow("Flaming Bow", 150, 0, 1000,5,3,2,1,"A wooden bow that burns, and get the wood doesn't disappear.", new String[]{"Fire"}, null, new String[]{"Water"},"Fire"),

        Dwarf_Pistol("Dwarf Pistol", 300, 0, 1000,5,2,2,1,"A mastercrafted weapon with deadly stopping power.", new String[]{"None"}, new String[] {"Pistol_Shot"},new String[]{"None"},"None"),

        Dwarf_Shotgun("Dwarf Shotgun", 300, 0, 1000,5,0,2,1,"A mastercrafted weapon, deadly for close encounters.", new String[]{"None"}, new String[] {"Buckshot","Slugshot"},new String[]{"None"},"None"),

        Bloodletter_Bow("Bloodletter Bow", 300, 0, 1000,10,4,3,1,"A wood imbued with blood, crafted in an ancient wood.", new String[]{"Blood"}, null,new String[]{"None"},"Blood"),

        Bow_Of_Helios("Bow Of Helios", 1000, 0, 1000000,40,5,1000,1,"The tales speak, of the archer Helios, all who fell before him could not see what had striked them before death. The imbued shadows may explain that myth.", new String[]{"Shadow"}, new String[] {"Shadow_Shot","Shadow_Volley","Shadow_Storm","Shadow_Gaze"},new String[]{"None"},"Shadow"),

        ;





        private final String Name;
        private final int RNGVal;
        private final int MAGEVal;
        private final int Value;
        private final int CritChance;
        private final int Tier;
        private final int ID;
        private final String Description ;
        private final String[] Resistance,Weakness;
        private final int DIST;

        private final String[] attacks;

        private final String bane;
        Bow(String Name, int RNGVal, int MAGEVal, int Value, int CritChance, int DIST, int Tier, int ID, String Description, String[] Resistance,  String[] attacks, String[] Weakness, String bane)
        {
            this.Name = Name ;
            this.MAGEVal = MAGEVal ;
            this.RNGVal = RNGVal ;
            this.Value = Value ;
            this.CritChance = CritChance ;
            this.Tier = Tier;
            this.ID = ID;
            this.Description = Description;
            this.Resistance = Resistance ;
            this.DIST = DIST;
            this.attacks = attacks;
            this.Weakness = Weakness;
            this.bane = bane;

        }

        public String getName() {
            return Name ;
        }

        public int getRNGVal() {
            return RNGVal;
        }

        public int getMAGEVal() {
            return MAGEVal;
        }

        public int getValue() {
            return Value;
        }

        public int getCritChance() {
            return CritChance;
        }

        public int getTier() {
            return Tier;
        }

        public int getID() {
            return ID;
        }

        public int getDIST() {
            return DIST;
        }

        public String getDescription() {
            return Description;
        }

        public String[] getResistance() {
            return Resistance;
        }
        public String[] getWeakness() {
            return Weakness;
        }

        public String[] getAttack() {return attacks;}
        public String getBane() {return bane;}


    }

    public enum Head {

        Steel_Helmet("Steel Helmet", 10, 0,-10,-10, -10, 0,100, 0, 0,0,0,"A sturdy steel helmet, standard issue for all knight infantry." ,0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,1,0,0,1,1}),

        Leather_Hood("Leather Hood", 0, 0,-10,10, 0, 0,100, 0, 0,0,0,"A leather hood, light and designed for archers." ,0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,0,0,0,0,0}),

        Magic_Hat("Magic Hat", 0, 0,10,-10, -5, 0,100, 0, 0,0,0,"A big, pointy, hat. This is supposed to give me more magic powers?",0,0,new String[]{"None"}, new String[]{"None"}, new int[] {2,0,0,0,0,0,0}),

        Mythril_Helmet("Mythril Helmet", 15, 0,-10,-10, -10, 0,500, 0, 0,0,0,"A sturdy steel helmet, standard issue for all knight infantry.",0,0,new String[]{"None"}, new String[]{"None"}, new int[] {0,0,5,0,0,5,5}),

        Infernal_Helmet("Infernal Helmet",200 , 50, -80, -120,-40,0, 10000,0, 0,0,0,"Armor created in the hellblazen demon lands." ,0,0, new String[]{"Ice","Fire"}, new String[]{"Water"}, new int[] {0,0,10,0,20,10,10}),

        Steel_Plated_Hood("Steel Plated Hood", 5, 0,-20,20, 0, 0,500, 0, 0,0,0,"A somewhat light hood, reinforced with steel metal.",0,0,new String[]{"None"}, new String[]{"None"}, new int[] {0,0,1,0,0,1,1}),

        Darkmage_Hat("Darkmage Hat", 0, 0,15,-20, -5, 0,500, 0, 0,0,0,"A hat worn by dark mages." ,0,0,new String[]{"None"}, new String[]{"None"}, new int[] {5,0,0,0,0,0,0});

        private final String Name;

        private final int ATKVal;
        private final int DEFVal;

        private final int RNGVal;
        private final int MAGEVal;

        private final int AGILVal;
        private final int Value;
        private final int Tier;
        private final int ID;

        private final int CritChance;
        private final String Description ;
        private final int Reflection ;
        private final int Absorption ;

        private final int mageAbsorption;
        private final int mageReflection;
        private final String[] Resistance,Weakness;

        private final int[] debuffVal;

        Head(String Name, int DEFVal, int ATKVal, int MAGEVal, int RNGVal, int AGILVal, int CritChance, int Value,  int Absorption, int Reflection, int Tier, int ID, String Description, int mageAbsorption, int mageReflection, String[] resistance, String[] weakness, int[] debuffVal )
        {
            this.Name = Name;
            this.DEFVal = DEFVal;
            this.ATKVal = ATKVal;
            this.MAGEVal = MAGEVal;
            this.RNGVal = RNGVal;
            this.AGILVal = AGILVal;
            this.Value = Value ;
            this.CritChance = CritChance ;
            this.Tier = Tier;
            this.ID = ID;
            this.Reflection = Reflection ;
            this.Absorption = Absorption ;
            this.mageReflection = mageReflection ;
            this.mageAbsorption = mageAbsorption ;
            this.Description = Description;
            this.Resistance = resistance;
            this.Weakness = weakness;
this.debuffVal = debuffVal;
        }
        public String getName() {
            return Name;
        }

        public int getATKVal() {
            return ATKVal;
        }

        public int getDEFVal() {
            return DEFVal;
        }

        public int getRNGVal() {
            return RNGVal;
        }

        public int getMAGEVal() {
            return MAGEVal;
        }

        public int getAGILVal() {
            return AGILVal;
        }

        public int getValue() {
            return Value;
        }

        public int getTier() {
            return Tier;
        }

        public int getID() {
            return ID;
        }

        public int getCritChance() {
            return CritChance;
        }

        public String getDescription() {
            return Description;
        }

        public int getReflection() {
            return Reflection;
        }

        public int getAbsorption() {
            return Absorption;
        }

        public int getMageAbsorption(){return mageAbsorption;}
        public int getMageReflection(){return mageReflection;}

        public String[] getResistance() {
            return Resistance;
        }
        public String[] getWeakness() {
            return Weakness;
        }
        public int[] getDebuffVal() {return debuffVal;}



    }

    public enum Body {

        Steel_Platebody("Steel Platebody",50 , 0, -20, -20,-20,0, 200,0, 0,0,0,"A sturdy steel platebody, standard issue for all knight infantry." ,0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,10,0,0,10,10}),

        Infernal_Chestplate("Infernal Chestplate",200 , 50, -80, -120,-40,0, 10000,0, 0,0,0,"Armor created in the hellblazen demon lands." ,0,0, new String[]{"Ice","Fire"}, new String[]{"Water"}, new int[] {0,0,40,0,100,40,70}),

        Leather_Body("Leather Body",20 , 0, -20, 30,0,0, 200,0, 0,0,0,"A leather body, easy to move around in this." ,0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,1,0,0,1,1}),

        Magic_Robe_Top("Magic Robe Top",5 , 0, 40, -20,-10,0, 200,0, 0,0,0,"An oversized magic robe top.",0,0,new String[]{"None"}, new String[]{"None"}, new int[] {10,0,0,0,0,0,0});

        private final String Name;

        private final int ATKVal;
        private final int DEFVal;

        private final int RNGVal;
        private final int MAGEVal;

        private final int AGILVal;
        private final int Value;
        private final int Tier;
        private final int ID;

        private final int CritChance;
        private final String Description ;
        private final int Reflection ;
        private final int Absorption ;

        private final int mageAbsorption;
        private final int mageReflection;
        private final String[] Resistance,Weakness;
        private final int[] debuffVal;

        Body(String Name, int DEFVal, int ATKVal, int MAGEVal, int RNGVal, int AGILVal, int CritChance, int Value,  int Absorption, int Reflection, int Tier, int ID, String Description, int mageReflection, int mageAbsorption, String[] resistance, String[] weakness, int[] debuffVal)
        {
            this.Name = Name;
            this.DEFVal = DEFVal;
            this.ATKVal = ATKVal;
            this.MAGEVal = MAGEVal;
            this.RNGVal = RNGVal;
            this.AGILVal = AGILVal;
            this.Value = Value ;
            this.CritChance = CritChance ;
            this.Tier = Tier;
            this.ID = ID;
            this.Reflection = Reflection ;
            this.Absorption = Absorption ;
            this.Description = Description;
            this.mageReflection = mageReflection ;
            this.mageAbsorption = mageAbsorption ;
            this.Resistance = resistance;
            this.Weakness = weakness;
            this.debuffVal = debuffVal;
        }
        public String getName() {
            return Name;
        }

        public int getATKVal() {
            return ATKVal;
        }

        public int getDEFVal() {
            return DEFVal;
        }

        public int getRNGVal() {
            return RNGVal;
        }

        public int getMAGEVal() {
            return MAGEVal;
        }

        public int getAGILVal() {
            return AGILVal;
        }

        public int getValue() {
            return Value;
        }

        public int getTier() {
            return Tier;
        }

        public int getID() {
            return ID;
        }

        public int getCritChance() {
            return CritChance;
        }

        public String getDescription() {
            return Description;
        }

        public int getReflection() {
            return Reflection;
        }

        public int getAbsorption() {
            return Absorption;
        }

        public int getMageAbsorption(){return mageAbsorption;}
        public int getMageReflection(){return mageReflection;}

        public String[] getResistance() {
            return Resistance;
        }
        public String[] getWeakness() {
            return Weakness;
        }
        public int[] getDebuffVal() {return debuffVal;}


    }

    public enum Legs {

        Steel_Platelegs("Steel Platelegs", 15, 0, -15,-15,-5,0, 150, 0, 0,0,0,"A sturdy set of steel platelegs, standard issue for all knight infantry." ,0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,7,0,0,7,7}),

        Infernal_Platelegs("Infernal Platelegs",150 , 50, -60, -80,-30,0, 10000,0, 0,0,0,"Armor created in the hellblazen demon lands." ,0,0, new String[]{"Ice","Fire"}, new String[]{"Water"}, new int[] {0,0,30,0,80,30,50}),

        Leather_Chaps("Leather Chaps",7 , 0, -20, 20,0,0, 200,0, 0,0,0,"A leather legs, easy to move around in this." ,0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,1,0,0,1,1}),

        Magic_Robe_Bottoms("Magic Robe Bottoms",3 , 0, 30, -15,-10,0, 200,0, 0,0,0,"Oversized magic robe bottoms.",0,0,new String[]{"None"}, new String[]{"None"}, new int[] {2,0,0,0,0,0,0});

        private final String Name;

        private final int ATKVal;
        private final int DEFVal;

        private final int RNGVal;
        private final int MAGEVal;

        private final int AGILVal;
        private final int Value;
        private final int Tier;
        private final int ID;

        private final int CritChance;
        private final String Description ;
        private final int Reflection ;
        private final int Absorption ;
        private final int mageAbsorption;
        private final int mageReflection;
        private final String[] Resistance,Weakness;
        private final int[] debuffVal;
        Legs(String Name, int DEFVal, int ATKVal, int MAGEVal, int RNGVal, int AGILVal, int CritChance, int Value,  int Absorption, int Reflection, int Tier, int ID, String Description, int mageReflection, int mageAbsorption, String[] resistance, String[] weakness, int[] debuffVal)
        {
            this.Name = Name;
            this.DEFVal = DEFVal;
            this.ATKVal = ATKVal;
            this.MAGEVal = MAGEVal;
            this.RNGVal = RNGVal;
            this.AGILVal = AGILVal;
            this.Value = Value ;
            this.CritChance = CritChance ;
            this.Tier = Tier;
            this.ID = ID;
            this.Reflection = Reflection ;
            this.Absorption = Absorption ;
            this.mageReflection = mageReflection ;
            this.mageAbsorption = mageAbsorption ;
            this.Description = Description;
            this.Resistance = resistance;
            this.Weakness = weakness;
            this.debuffVal = debuffVal;
        }

        public String getName() {
            return Name;
        }

        public int getATKVal() {
            return ATKVal;
        }

        public int getDEFVal() {
            return DEFVal;
        }

        public int getRNGVal() {
            return RNGVal;
        }

        public int getMAGEVal() {
            return MAGEVal;
        }

        public int getAGILVal() {
            return AGILVal;
        }

        public int getValue() {
            return Value;
        }

        public int getTier() {
            return Tier;
        }

        public int getID() {
            return ID;
        }

        public int getCritChance() {
            return CritChance;
        }

        public String getDescription() {
            return Description;
        }

        public int getReflection() {
            return Reflection;
        }

        public int getAbsorption() {
            return Absorption;
        }

        public int getMageAbsorption(){return mageAbsorption;}
        public int getMageReflection(){return mageReflection;}

        public String[] getResistance() {
            return Resistance;
        }
        public String[] getWeakness() {
            return Weakness;
        }

        public int[] getDebuffVal() {return debuffVal;}

    }

    public enum Boots {

        Steel_Boots("Steel Boots", 10, 0,-5,-5,-5,0, 200, 0, 0,0, 0,"Sturdy yet small boots. I wish they had these in a bigger size.",0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,0,0,0,0,0}),

        Archer_Boots("Archer Boots", 10, 0,-5,5,5,0, 200, 0, 0,0, 0,"Boots designed for mobile combat.",0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,0,0,0,0,0}),

        Magic_Boots("Magic Boots", 10, 0,5,-5,0,0, 200, 0, 0,0, 0,"Boots for the wizardly like.",0,0,new String[]{"None"}, new String[]{"None"}, new int[] {5,0,0,0,0,0,0})

        ;





        private final String Name;

        private final int ATKVal;
        private final int DEFVal;

        private final int RNGVal;
        private final int MAGEVal;

        private final int AGILVal;
        private final int Value;
        private final int Tier;
        private final int ID;

        private final int CritChance;
        private final String Description ;
        private final int Reflection ;
        private final int Absorption ;

        private final int mageAbsorption;
        private final int mageReflection;
        private final String[] Resistance,Weakness;
        private final int[] debuffVal;
        Boots(String Name, int DEFVal, int ATKVal, int MAGEVal, int RNGVal, int AGILVal, int CritChance, int Value,  int Absorption, int Reflection, int Tier, int ID, String Description, int mageReflection, int mageAbsorption, String[] resistance, String[] weakness, int[] debuffVal)
        {
            this.Name = Name;
            this.DEFVal = DEFVal;
            this.ATKVal = ATKVal;
            this.MAGEVal = MAGEVal;
            this.RNGVal = RNGVal;
            this.AGILVal = AGILVal;
            this.Value = Value ;
            this.CritChance = CritChance ;
            this.Tier = Tier;
            this.ID = ID;
            this.Reflection = Reflection ;
            this.Absorption = Absorption ;
            this.mageReflection = mageReflection ;
            this.mageAbsorption = mageAbsorption ;
            this.Description = Description;
            this.Resistance = resistance;
            this.Weakness = weakness;
            this.debuffVal = debuffVal;
        }

        public String getName() {
            return Name;
        }

        public int getATKVal() {
            return ATKVal;
        }

        public int getDEFVal() {
            return DEFVal;
        }

        public int getRNGVal() {
            return RNGVal;
        }

        public int getMAGEVal() {
            return MAGEVal;
        }

        public int getAGILVal() {
            return AGILVal;
        }

        public int getValue() {
            return Value;
        }

        public int getTier() {
            return Tier;
        }

        public int getID() {
            return ID;
        }

        public int getCritChance() {
            return CritChance;
        }

        public String getDescription() {
            return Description;
        }

        public int getReflection() {
            return Reflection;
        }

        public int getAbsorption() {
            return Absorption;
        }
        public int getMageAbsorption(){return mageAbsorption;}
        public int getMageReflection(){return mageReflection;}

        public String[] getResistance() {
            return Resistance;
        }
        public String[] getWeakness() {
            return Weakness;
        }

        public int[] getDebuffVal() {return debuffVal;}

    }

    public enum Gloves {

        Leather_Gloves("Leather Gloves", 0, 0,0,0,0, 0, 0, 0, 0,0,0,"Standard leather gloves, for gardening and general use.",0,0,new String[]{"None"}, new String[]{"None"}, new int[] {0,0,0,0,0,0,0});

        private final String Name;

        private final int ATKVal;
        private final int DEFVal;

        private final int RNGVal;
        private final int MAGEVal;

        private final int AGILVal;
        private final int Value;
        private final int Tier;
        private final int ID;

        private final int CritChance;
        private final String Description ;
        private final int Reflection ;
        private final int Absorption ;
        private final int mageAbsorption;
        private final int mageReflection;

        private final String[] Resistance,Weakness;
        private final int[] debuffVal;


        Gloves(String Name, int DEFVal, int ATKVal, int MAGEVal, int RNGVal, int AGILVal, int CritChance, int Value,  int Absorption, int Reflection, int Tier, int ID, String Description, int mageReflection, int mageAbsorption, String[] resistance, String[] weakness, int[] debuffVal)
        {
            this.Name = Name;
            this.DEFVal = DEFVal;
            this.ATKVal = ATKVal;
            this.MAGEVal = MAGEVal;
            this.RNGVal = RNGVal;
            this.AGILVal = AGILVal;
            this.Value = Value ;
            this.CritChance = CritChance ;
            this.Tier = Tier;
            this.ID = ID;
            this.Reflection = Reflection ;
            this.Absorption = Absorption ;
            this.Description = Description;
            this.mageReflection = mageReflection;
            this.mageAbsorption = mageAbsorption;
            this.Resistance = resistance;
            this.Weakness = weakness;
            this.debuffVal = debuffVal;
        }

        public String getName() {
            return Name;
        }

        public int getATKVal() {
            return ATKVal;
        }

        public int getDEFVal() {
            return DEFVal;
        }

        public int getRNGVal() {
            return RNGVal;
        }

        public int getMAGEVal() {
            return MAGEVal;
        }

        public int getAGILVal() {
            return AGILVal;
        }

        public int getValue() {
            return Value;
        }

        public int getTier() {
            return Tier;
        }

        public int getID() {
            return ID;
        }

        public int getCritChance() {
            return CritChance;
        }

        public String getDescription() {
            return Description;
        }

        public int getReflection() {
            return Reflection;
        }

        public int getAbsorption() {
            return Absorption;
        }
        public int getMageAbsorption(){return mageAbsorption;}
        public int getMageReflection(){return mageReflection;}

        public String[] getResistance() {
            return Resistance;
        }
        public String[] getWeakness() {
            return Weakness;
        }

        public int[] getDebuffVal() {return debuffVal;}



    }

    public enum Shield {

        Steel_Kiteshield("Steel Kiteshield", 100, 0, -20, -30, 0,0, 100, 10, 0,0,0,"A sturdy, yet heavy shield, designed to block off archery attacks",new String[] {"Guard"},0,0,new String[]{"None"}, new String[]{"None"}, new int[] {0,0,5,0,5,0,5}),

        Mage_Tome("Magic Tome", 0, 0, 50, -30, 0,0, 100, 0, 0,0,1,"A book, filled with arcane magic.",new String[] {"Arcane_Mind"},0,0,new String[]{"None"}, new String[]{"None"}, new int[] {10,0,0,0,0,0,0}) ,

        Healer_Tome("Healer Tome", 0, 0, 50, -30, 0,0, 100, 0, 0,0,1,"A book, filled with healer magic.",new String[] {"Gift_Of_The_Angels"},0,0,new String[]{"None"}, new String[]{"None"}, new int[] {40,0,0,0,0,0,0}) ,

        Necromancer_Tome("Necromancer Tome", 0, 0, 50, -30, 0,0, 100, 0, 0,0,1,"A book, filled with evil magics.",new String[] {"Summon_Skeleton","Summon_Zombie"},0,0,new String[]{"None"}, new String[]{"None"}, new int[] {20,0,0,0,0,0,0}) ,

        Buckler("Buckler", 50, 0, -40, 40, 0,5, 100, 5, 0,0,2,"A small shield, designed for protection for archers.",null,0,0,new String[]{"None"},new String[]{"None"}, new int[] {10,0,30,0,0,30,20}),

        Offhand_Crossbow("Offhand Crossbow", -20, 0, -40, 100, 0,5, 100, 5, 0,0,2,"Offhand crossbow, for those who want to go akimbo on your targets.",new String[] {"Double_Shot"},0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,0,0,0,0,0}),

        Mythril_Kiteshield("Mythril Kiteshield", 150, 0, -40, -40, 0,0, 600, 12, 0,1,3,"A sturdy Mythril shield.",new String[] {"Guard","Charge"},0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,10,0,0,10,10}),

        Steel_Blade("Steel Blade", 0, 100, -20, -30, 0,10, 400, 0, 0,1,4,"A small, sword to hold in the offhand.",new String[] {"Riposte"},0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,0,0,0,0,0}),

        Prime_Steel_Shield("Primordial Steel Shield", 200, 0, -50, -50, 0,0, 1000, 15, 0,2,5,"A shield crafted in refined steel, heavy, yet durable.",new String[] {"Guard","Smash"},0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,30,0,0,30,20}),

        Diamond_Plated_Shield("Diamond Plated Shield", 300, 0, -80, -80, 0,0, 3000, 20, 0,2,5,"A glamerous shield, that still offers protection.",new String[] {"Guard","Charge"},0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,25,50,0,0,60,50}),

        Dragonbone_Shield("Dragonbone Shield", 400, 0, -150, -150, 0,0, 10000, 25, 0,2,5,"Someone was able to carve out dragon bone?",new String[] {"Guard","Charge"},0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,25,50,0,0,60,80}),

        Shield_Of_Edmond("Shield Of Edmond", 500, 50, -40, -40, 0,0, 20000, 30, 0,2,5,"The legendary shield of the hero Edmond, no one knows what happened to him.",null,0,0,new String[]{"None"},new String[]{"None"}, new int[] {30,40,50,0,60,60,80}),
        Assassins_Breach("Assassins Breach", 20, 250, -150, -150, 100,20, 10000, 0, 0,2,5,"A incredibly light, yet deadly dagger.", new String[] {"Assassinate"},0,0,new String[]{"None"},new String[]{"None"}, new int[] {0,0,0,0,0,0,0}),

        The_Bulwark("The Bulwark", 1000, 0, -200, -200, 0,0, 100000, 50, 50,1000,1,"An incredibly, heavy shield, sturdy enough to be a dinner table for trolls.", new String[] {"Masterguard"/*,"Bulwark_Charge"*/},0,0,new String[]{"None"},new String[]{"None"}, new int[] {10,50,100,10,5,200,100}),

        Shadow_Bulwark("Shadow Bulwark", 1000, 0, -400, -500, 0,0, 1000000, 50, 200,1000,1,"A cursed shield, made from a Bulwark's corpse.", new String[] {"Masterguard","Reflection_Curse"},90,200,new String[]{"None"}, new String[]{"None"}, new int[] {200,50,100,10,5,200,100})
        ;


        private final String Name;

        private final int ATKVal;
        private final int DEFVal;

        private final int RNGVal;
        private final int MAGEVal;

        private final int AGILVal;
        private final int Value;
        private final int Tier;
        private final int ID;

        private final int CritChance;
        private final String Description ;
        private final int Reflection ;
        private final int Absorption ;
        private final int mageAbsorption;
        private final int mageReflection;
        private final String[] Resistance,Weakness;
        private final int[] debuffVal;

        private final String[] attacks;
        Shield(String Name, int DEFVal, int ATKVal, int MAGEVal, int RNGVal, int AGILVal, int CritChance, int Value,  int Absorption, int Reflection, int Tier, int ID, String Description, String[] attacks, int mageAbsorption, int mageReflection, String[] resistance, String[] weakness, int[] debuffVal)
        {
            this.Name = Name;
            this.DEFVal = DEFVal;
            this.ATKVal = ATKVal;
            this.MAGEVal = MAGEVal;
            this.RNGVal = RNGVal;
            this.AGILVal = AGILVal;
            this.Value = Value ;
            this.CritChance = CritChance ;
            this.Tier = Tier;
            this.ID = ID;
            this.Reflection = Reflection ;
            this.Absorption = Absorption ;
            this.mageReflection = mageReflection ;
            this.mageAbsorption = mageAbsorption ;
            this.Description = Description;
            this.attacks = attacks;
            this.Resistance = resistance;
            this.Weakness = weakness;
            this.debuffVal = debuffVal;
        }

        public String getName() {
            return Name;
        }

        public int getATKVal() {
            return ATKVal;
        }

        public int getDEFVal() {
            return DEFVal;
        }

        public int getRNGVal() {
            return RNGVal;
        }

        public int getMAGEVal() {
            return MAGEVal;
        }

        public int getAGILVal() {
            return AGILVal;
        }

        public int getValue() {
            return Value;
        }

        public int getTier() {
            return Tier;
        }

        public int getID() {
            return ID;
        }

        public int getCritChance() {
            return CritChance;
        }

        public String getDescription() {
            return Description;
        }

        public int getReflection() {
            return Reflection;
        }

        public int getAbsorption() {
            return Absorption;
        }

        public int getMageAbsorption(){return mageAbsorption;}
        public int getMageReflection(){return mageReflection;}

        public String[] getResistance() {
            return Resistance;
        }
        public String[] getWeakness() {
            return Weakness;
        }
        public String[] getAttack() {return attacks;}

        public int[] getDebuffVal() {return debuffVal;}


    }

    public enum Arrows {

        Steel_Arrow("Steel Arrow", 50,5, 5,new String[]{"None"}, 0, 1, new String[] {},new String[]{"None"}),
        Bronze_Arrow("Bronze Arrow", 30,1, 3,new String[]{"None"}, 0, 1, new String[] {},new String[]{"None"}),

        Mythril_Arrow("Mythril Arrow", 75,1, 3,new String[]{"None"}, 0, 1, new String[] {"Arrow_Volley",},new String[]{"None"}),

        Lightning_Arrow("Lightning Arrow", 75,1, 3, new String[]{"Lightning"}, 0, 1, new String[] {"Arrow_Volley","Thundershot"},new String[]{"None"}),

        Fire_Arrow("Fire Arrow", 75,1, 3, new String[]{"Ice"}, 0, 1, new String[] {"Pyro_Volley","Spreading_Ember"}, new String[]{"Water"}),

        Water_Arrow("Water Arrow", 75,1, 3, new String[]{"Fire"}, 0, 1, new String[] {"Arrow_Volley","Aquatic_Shot"}, new String[]{"Ice"}),

        Frosternhorn_Arrow("Frosternhorn Arrow", 75,1, 3, new String[]{"Ice"}, 0, 1, new String[] {"Freezing_Volley","Frostshot"}, new String[]{"Fire"}),

        Dwarf_Bullets("Dwarf Bullets", 150,1, 3,new String[]{"None"}, 0, 1, new String[] {"Pistol Shot"},new String[]{"None"}),

        Dwarf_Shotgun_Shells("Dwarf Shotgun Shells", 150,1, 3,new String[]{"None"}, 0, 1, null,new String[]{"None"}),

        Dwarf_Explosive_Shells("Dwarf Shotgun Shells", 150,1, 3,new String[]{"None"}, 0, 1, new String[] {"Explosive_Buckshot"},new String[]{"None"}),

        ;

        private final String Name;
        private final int RNGVal;
        private final int Value;
        private final int Crit;
        private final String[] Resistance,Weakness;
        private final int ID;
        private final int ArrowCount;

        private final String[] Attacks;
        Arrows(String Name, int RNGVal, int Value, int Crit, String Resistance[], int ID, int ArrowCount, String[] Attacks, String[] Weakness)
        {
            this.Name = Name;
            this.RNGVal = RNGVal;
            this.Value = Value;
            this.Crit = Crit;
            this.Resistance = Resistance;
            this.ID = ID;
            this.ArrowCount = ArrowCount;
            this.Attacks = Attacks;
            this.Weakness = Weakness;

        }

        public String getName() {
            return Name;
        }

        public int getRNGVal() {
            return RNGVal;
        }

        public int getValue() {
            return Value;
        }

        public int getCrit() {
            return Crit;
        }

        public String[] getWeakness() {
            return Weakness;
        }

        public int getID() {
            return ID;
        }

        public int getArrowCount() {
            return ArrowCount;
        }

        public String[] getResistance() {
            return Resistance;
        }

        public String[] getAttack() {return Attacks;}
    }





}