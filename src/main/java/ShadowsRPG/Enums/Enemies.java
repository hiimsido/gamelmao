package ShadowsRPG.Enums;


public enum Enemies {

    //change types to race in order to add damage modifiers based on what they are, such as demonbane weapons/frosted enemies, etc.

    //have an enemy that can change its own AI

    //add movement condition/action condition for enemies. Going to be needed for the Bulwark boss and other bosses.

        //eventually have each enemy have it's own letter attached, to distinguish who's who

    //add an enemy that shapeshifts, changing it's AI, and it's stats/attack types.

    //add an enemy that randomly buffs other enemies beside it.

    //add an enemy that would kill/eat other enemies to heal itself (OGRE)

    //add a boss known as the corpse feeder, when you kill it's minions, it spawns a corpse on the map tile it was once in. Then, the corpse feeder will start moving toward the body and consume it to get a buff which allows it to do loads of damage in its next attack.

    //undead don't die until it's actual turn? Could add "UNDYING" string for that.

    Goblin("Goblin", 50, 100, 20, 40, 10, 100, 5,0,0,1,0,"None", "None", 0, "MELEE","Goblin" , new String[]{"Strike"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

    Boulder("Boulder", 0, 100, 100, 0, 0, 0, 5,0,0,1,0,"None", "None", 0, "None","Object" , new String[]{"Strike"},0,0,"Immune", new String[]{"None"}, new String[]{"None"}),
    Fire("Fire", 0, 100, 100, 0, 0, 0, 5,0,0,1,0,"None", "None", 2, "None","Hazard" , new String[]{"Disipate","Expand","Scorch"},0,0,"Immune", new String[]{"Fire"}, new String[]{"Water"}),

    //if target undead, leaves corpse on death. Necromancer/some boss units can either bring it back to life as a stronger varient, or the corpse can be devoured for health by some enemies/buffs.

    Corpse("Corpse", 0, 100, 20, 0, 0, 0, 5,0,0,1,0,"None", "None", 0, "None","Object" , new String[]{"Strike"},0,0,"Immune", new String[]{"None"}, new String[]{"None"}),


    Giant_Spider("Giant Spider", 50, 100, 20, 50, 10, 300, 5,0,250,1,0,"None", "None", 0, "MELEE","Spider" , new String[]{"Bite","Web_Shoot","Strike"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

        Rogue("Rogue", 20, 100, 10, 50, 10, 200, 100,0,100,1,0,"None", "None", 0, "MELEE", "Human" , new String[]{"Blinding_Powder","Assassinate","Strike","Throw_Knife"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

        Archer("Archer", 40, 100, 10, 50, 10, 200, 100,0,60,3,0,"None", "None", 0, "RANGE", "Human" , new String[]{"Arrow_Shot"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

        Goblin_Mage("Goblin Mage", 40, 100, 10, 50, 80, 100, 5,0,0,3,0,"None", "None", 0, "RANGE", "Goblin" , new String[]{"Arcane_Bolt"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

        Berserker("Berserker", 20, 200, 20, 200, 10, 100, 10,0,0,1,0,"None", "None", 0, "MELEE","Human" , new String[]{"Berserk","Berserker_Barrage","Berserker_Slash","Strike"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

        Rogue_Knight("Rogue Knight", 20, 200, 80, 100, 10, 80, 10,0,0,1,0,"None", "None", 0, "MELEE", "Human" , new String[]{"Smash","Strike"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

    Hardened_Knight("Hardened Knight", 10, 400, 250, 220, 30, 80, 15,0,0,1,0,"None", "None", 0, "MELEE", "Human" , new String[]{"Smash","Slash"},0,0,"Heavy", new String[]{"None"}, new String[]{"None"}),

        Elite_Archer("Elite Archer", 20, 200, 10, 100, 10, 200, 5,0,100,3,0,"None", "None", 0, "RANGE", "Human" , new String[]{"Arrow_Rain","Arrow_Shot"},0,0,"Elite", new String[]{"None"}, new String[]{"None"}),

    Rogue_Mage("Rogue Mage", 20, 200, 10, 20, 130, 100, 5,0,100,3,0,"None", "None", 0, "RANGE", "Human" , new String[]{"Arcane_Bolt"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

        Arch_Mage("Arch Mage", 10, 300, 10, 20, 250, 100, 5,0,100,3,0,"None", "None", 0, "RANGE", "Human" , new String[]{"Arcane_Comet","Arcane_Bolt"},0,0,"Elite", new String[]{"None"},
                new String[]{"None"}),

    Cryo_Mage("Cryo Mage", 15, 300, 10, 20, 130, 100, 5,0,100,3,0,"None", "None", 0, "RANGE", "Human" , new String[]{"Ice_Blast","Arcane_Bolt"},0,0,"Standard", new String[]{"Ice"}, new String[]{"Fire"}),

        The_Dreadnought("The Dreadnought", 10, 1500, 300, 400, 10, 20, 10,0,0,1,0,"None", "None", 0, "MELEE", "Human" , new String[]{"Crushing_Blow","Crush"},0,0,"Elite_Heavy", new String[]{"None"}, new String[]{"None"}),

        Gargoyle("Gargoyle", 15, 200, 300, 100, 60, 200, 12,20,100,1,0,"None", "None", 0, "MELEE", "Stone" , new String[]{"Slash","Rock_Toss"},0,0,"Stone", new String[]{"Fire"}, new String[]{"Crush","Acid","Stone"}),

    Ancient_Colossus("Ancient Colossus", 5, 3000, 300, 500, 60, 10, 20,50,300,1,0,"None", "None", 0, "MELEE", "Stone" , new String[]{"Slash","Rock_Toss"},0,0,"Stone", new String[]{"Fire"}, new String[]{"Crush","Acid","Stone"}),

    Ogre("Ogre", 15, 1200, 80, 350, 200, 10, 12,0,10,1,0,"None", "None", 0, "MELEE", "Ogre" , new String[]{"Consume","Just_Desserts","Smash",},0,0,"Heavy", new String[]{"None"}, new String[]{"Slash"}),

    Ogre_Shaman("Ogre Shaman", 5, 2300, 40, 500, 300, 10, 12,0,10,1,0,"None", "None", 0, "MELEE", "Ogre" , new String[]{"Consume","Just_Desserts","Smash","Arcane_Bolt"},0,0,"Heavy", new String[]{"None"}, new String[]{"Slash"}),

        Baby_Dragon("Baby Dragon", 15, 400, 50, 100, 100, 100, 12,0,0,1,0,"None", "None", 0, "MELEE", "Dragon" , new String[]{"Dragonbreath","Strike"},0,0,"Dragon", new String[]{"Fire"}, new String[]{"Stab","Dragon"}),

    Dragon("Dragon", 5, 2000, 300, 500, 500, 100, 12,0,0,1,0,"None", "None", 0, "MELEE", "Dragon" , new String[]{"Dragonbreath","Bite","Slash"},0,0,"Dragon", new String[]{"Fire"}, new String[]{"Stab","Dragon"}),

    Elder_Dragon("Elder Dragon", 1, 5000, 500, 750, 750, 100, 12,0,0,1,0,"None", "None", 0, "MELEE", "Dragon" , new String[]{"Dragonbreath","Bite","Slash"},0,0,"Dragon", new String[]{"Fire"}, new String[]{"Stab","Dragon"}),

    Frost_Dragon("Frost Dragon", 5, 2400, 300, 500, 500, 100, 12,0,0,1,0,"None", "None", 0, "MELEE", "Dragon" , new String[]{"Frostbreath","Bite","Slash"},0,0,"Dragon", new String[]{"Ice"}, new String[]{"Stab","Dragon"}),

        The_Shield_Of_Karasawa("The Shield Of Karasawa", 10, 500, 300, 60, 10, 0, 5,40,0,1,0,"None", "None", 0, "MELEE", "Human" , new String[]{"Karasawa_Slam"},0,0,"Elite_Heavy", new String[]{"None"}, new String[]{"None"}),

        Ballista_Archer("Ballista Archer", 10, 300, 20, 50, 10, 50, 25,0,250,5,0,"None", "None", 0, "RANGE", "Human" , new String[]{"Ballista_Shot", "Load_Ballista"/*,"Teleport"*/,"Crossbow_Shot"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}), //eventually make a rule where it can only attack if 5 tiles away
    //give heavy archer's a teleport attack if they can't use ballista shot. With a cooldown
        //conditions return a boolean based on what the condition is



        Madman("Madman", 15, 400, 40, 350, 10, 120, 35,0,100,1,0,"None", "None", 0, "MELEE","Human" , new String[]{"Berserk","Berserker_Barrage","Berserker_Slash","Strike","Axe_Throw",},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

        //add special rules at some point like can only use x attack with x condition.

        Skeleton("Skeleton", 50, 20, 10, 60, 10, 0, 1,0,0,1,0,"None", "None", 0, "MELEE", "Undead" , new String[]{"Strike"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

    Zombie("Zombie", 50, 130, 1, 200, 10, 0, 15,0,0,1,0,"None", "None", 0, "MELEE", "Undead" , new String[]{"Bite","Strike"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

        Spearman("Spearman", 20, 300, 50, 200, 10, 0, 1,0,0,2,0,"None", "None", 0, "RANGE", "Human" , new String[]{"Strike"},0,0,"Elite", new String[]{"None"}, new String[]{"None"}),

        Assassin("Assassin", 15, 130, 10, 230, 10, 300, 50,0,230,1,0,"None", "None", 0, "MELEE", "Human" , new String[]{"Assassinate","Slash","Throw_Knife"},0,0,"Standard", new String[]{"None"}, new String[]{"None"}),

        Dwarf_Mercenary("Dwarf Mercenary", 20, 230, 100, 160, 10, 120, 10,0,100,1,0,"None", "None", 0, "MELEE", "Dwarf" , new String[]{"Strike","Crossbow_Shot"},0,0,"Dwarf", new String[]{"None"}, new String[]{"Lightning"}),

    Dwarf_Gunner("Dwarf Gunner", 15, 350, 160, 10, 10, 120, 10,0,250,2,0,"None", "None", 0, "RANGE", "Dwarf" , new String[]{"Chaingun_Burst","Rev_Chaingun","Pistol_Shot"},0,0,"Dwarf", new String[]{"None"}, new String[]{"Lightning"}),

    Masterworked_Dwarf_Gunner("Masterworked Dwarf Gunner", 1, 1350, 300, 10, 200, 120, 10,0,500,2,0,"None", "None", 0, "RANGE", "Dwarf" , new String[]{"Rev_Systems","Flame_Grenade","Chaingun_Burst","Pistol_Shot"},0,0,"Dwarf", new String[]{"None"}, new String[]{"Lightning"}),

    Dwarf_Shotgunner("Dwarf Shotgunner", 1, 1750, 450, 10, 10, 80, 10,0,500,1,0,"None", "None", 0, "MELEE", "Dwarf" , new String[]{"Buckshot","Reload"},0,0,"Dwarf", new String[]{"None"}, new String[]{"Lightning"}),


    Dwarf_Warlord("Dwarf Warlord", 15, 400, 200, 230, 10, 130, 10,0,200,1,0,"None", "None", 0, "MELEE", "Dwarf" , new String[]{"Slash","Crossbow_Shot"},0,0,"Dwarf", new String[]{"None"}, new String[]{"Lightning"}),

    Dwarf_Torcher("Dwarf Torcher", 15, 700, 300, 30, 10, 130, 10,0,500,1,0,"None", "None", 0, "MELEE", "Dwarf" , new String[]{"Rev_Flamethrower","Dwarf_Flamethrower","Strike"},0,0,"Dwarf", new String[]{"None"}, new String[]{"Lightning"}),

    Dwarf_Catapult("Dwarf Catapult", 1, 2000, 600, 30, 10, 0, 10,0,1000,7,0,"None", "None", 0, "RANGE", "Dwarf" , new String[]{"Shot_Landed","Fire_The_Catapult","Catapult_Reload"},0,0,"Dwarf", new String[]{"None"}, new String[]{"Fire"}),


    Dwarf_Shielder("Dwarf Shielder", 10, 400, 500, 130, 10, 130, 10,0,100,1,0,"None", "None", 0, "MELEE", "Dwarf" , new String[]{"Smash","Strike","Crossbow_Shot",},0,0,"Dwarf", new String[]{"None"}, new String[]{"Lightning"}),

    Dwarf_Hammer("Dwarf Hammer", 10, 400, 150, 500, 10, 130, 10,0,100,1,0,"None", "None", 0, "MELEE", "Dwarf" , new String[]{"Crushing_Blow","Crush"},0,0,"Dwarf", new String[]{"None"}, new String[]{"Lightning"}),


    Ice_Troll("Ice Troll", 10, 800, 150, 200, 10, 130, 10,0,100,1,0,"None", "None", 0, "MELEE", "Troll" , new String[]{"Shatter","Crushing_Blow","Crush","Rock_Toss"},0,0,"Ice", new String[]{"Ice"}, new String[]{"Fire"}),


    Demon("Demon", 10, 600, 170, 200, 180, 160, 15,0,0,1,0,"None", "None", 0, "MELEE", "Demon" , new String[]{"Slash","Hellfire_Blast"},0,0,"Demon", new String[]{"Fire"}, new String[]{"Demonbane"}),

    Ice_Demon("Ice Demon", 2, 4000, 600, 800, 700, 100, 15,0,0,1,0,"None", "None", 0, "MELEE", "Demon" , new String[]{"Shatter","Ice_Barrage","Frozen_Punch","Slash"},0,0,"Ice", new String[]{"Ice"}, new String[]{"Demonbane"}),

    Imp("Imp", 20, 150, 60, 150, 130, 120, 10,0,1,1,0,"None", "None", 0, "MELEE", "Demon" , new String[]{"Slash","Arcane_Bolt"},0,0,"Standard", new String[]{"Fire"}, new String[]{"Demonbane"}),

   Elder_Demon("Elder Demon", 5, 800, 230, 260, 260, 180, 15,0,1,1,0,"None", "None", 0, "MELEE", "Demon" , new String[]{"Hellfire_Surge", "Demonic_Ritual","Slash","Hellfire_Blast"},0,0,"Demon", new String[]{"None"}, new String[]{"Demonbane"}),

        The_Armor_Piercer("The Armor Piercer", 20, 200, 170, 100, 0, 60, 100,0,0,1,0,"None", "None", 0, "MELEE", "Human" , new String[]{"Penetrate"},0,0,"Heavy", new String[]{"None"}, new String[]{"None"}),

        Bear("Bear", 10, 400, 20, 250, 0, 160, 10,0,0,1,0,"None", "None", 0, "MELEE", "Beast", new String[]{"Bite","Slash"},0,0,"Heavy", new String[]{"None"}, new String[]{"None"}),

    Wolf("Wolf", 15, 230, 20, 120, 0, 230, 10,0,0,1,0,"None", "None", 0, "MELEE", "Beast", new String[]{"Bite", "Slash"} ,0,0,"Standard", new String[]{"None"}, new String[]{"None"}),


    //bosses
    Spider_Queen("Spider Queen", 1, 2000, 40, 150, 10, 200, 10,0,150,1,0,"BOSS", "None", 0, "MELEE", "Spider" , new String[]{"Hatch_Spider","Web_Encasement","Spider_Bite","Lunge",},0,0,"Elite", new String[]{"None"}, new String[]{"None"}),

    Dwarf_Captain("Dwarf Captain", 1, 3450, 200, 200, 10, 120, 10,0,100,1,0,"BOSS", "None", 0, "ALLY", "Dwarf" , new String[]{"Dwarf_Reinforcements","Dwarf_Rally","Grenade_Blast","Strike","Pistol_Shot"},0,0,"Dwarf_Captain", new String[]{"None"}, new String[]{"Lightning"}),
    The_Bulwark("The Bulwark", 1, 6000, 600, 200, 10, 10, 10,50,200,1,0,"BOSS", "None", 0, "BULWARK", "Beast",new String[]{"Bulwark_Charge",/*"Bulwark_Gaze",*/"Earthquake","Quake","Chomp","Bulwark_Stomp","Bulwark_Roar",},0,0, "Bulwark", new String[]{"None"}, new String[]{"None"})

        ;



        private final String Name;

        private final int Weighting;

        private final int cMAGE;
        private final int cAGIL;
        private final int HP;
        private final int DEF;
        private final int ATK;
        private final int MAGE;
        private final int AGIL;
        private final String ATRI;
        private final String STATUS;
        private final int DUR;
        private final int cHP;
        private final int CRIT;
        private final int ABSORP;
        private final int RANGE;
        private final int DIST;
        private final int REFLECT;
        private final String AI;
        private final String[] Attacks;
        private final int MAGEABSORP;
        private final int MAGEREFLECT;

        private final String debuffRes;

        private final String[] Resistance,Weakness;



    private final String Type; //placeholder till i make attack categories for enemies :)


        //set enums for the player whenever i hard rework all that fun jazz from the tab
        Enemies(String NAME, int WEIGHT, int HP, int DEF, int ATK, int MAGE, int AGIL, int CRIT, int ABSORP, int RNG, int DIST, int REFLECT, String ATRI, String STATUS, int DUR, String AI, String Type, String[] Attacks, int MAGEREFLECT, int MAGEABSORP, String debuffRes, String Resistance[], String[] Weakness)
        {
            //need to add hashmap for attacks and spells, as well as XP and Wealth ints.
            //Bosses/Demibosses will prob have their own enums, but they will reward loot alongside xp and coins.
            this.Name = NAME;
            this.cMAGE = MAGE;
            this.Weighting = WEIGHT;
            this.cAGIL = AGIL;
            this.HP = HP;
            this.DEF = DEF;
            this.ATK = ATK;
            this.MAGE = MAGE;
            this.AGIL = AGIL;
            this.ATRI = ATRI;
            this.STATUS = STATUS;
            this.DUR = DUR;
            this.cHP = HP;
            this.CRIT = CRIT;
            this.ABSORP = ABSORP;
            this.RANGE = RNG;
            this.DIST = DIST;
            this.REFLECT = REFLECT;
            this.AI = AI;
            this.Type = Type;
            this.Attacks = Attacks;
            this.MAGEREFLECT = MAGEREFLECT;
            this.MAGEABSORP = MAGEABSORP;
            this.debuffRes = debuffRes;
            this.Resistance = Resistance;
            this.Weakness = Weakness;



        }

        public String getName() {
            return Name;
        }

        public int getWeighting() {
            return Weighting;
        }

        public int getcMAGE() {
            return cMAGE;
        }

        public int getcAGIL() {
            return cAGIL;
        }

        public int getHP() {
            return HP;
        }

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

        public String[] getAttacks() {return Attacks;}

        public int getDUR() {
            return DUR;
        }

        public String getType() {return Type;}


        public int getcHP() {
            return cHP;
        }

        public int getCRIT() {
            return CRIT;
        }

        public int getABSORP() {
            return ABSORP;
        }

        public int getRANGE() {
            return RANGE;
        }

        public int getDIST() {
            return DIST;
        }

        public int getREFLECT() {
            return REFLECT;
        }

        public int getMAGEREFLECT(){
            return MAGEREFLECT;
        }

        public String getDebuffRes() { return debuffRes;}

    public String[] getResistance() {return Resistance;}
    public String[] getWeakness(){return Weakness;}

    public int getMAGEABSORP(){
        return MAGEABSORP;
    }
        public String getAI() {return AI;}

    }

