package ShadowsRPG.Enums;


public enum Bosses  {

    //bosses should have multiple turns


    //rare future enemy encounter
    UNIT_K177("UNIT K177", 0, 4444, 800, 600, 1, 100, 30,0,800,1,0,"None", "None", 0, "MELEE", "Robot", new String[]{/*"Chaingun","Chainsaw Slash","Laser Blast","Missle Volley","Energy Shield", "Nanomachines_S-0N*/}, 1, new String[] {}),



    //make custom AI for bulwark, tries to get in line of sight of you

    //give bulwark an attack which gives it immobile.

       The_Bulwark("The Bulwark", 1000, 2000, 300, 200, 10, 10, 10,90,0,1,0,"None", "None", 0, "BULWARK", "Beast",new String[]{"Bulwark_Charge","Bulwark_Roar","Earthquake","Rock_Toss",}, 1, new String[] {}),

        Talahan_The_Barbarian("Talahan The Barbarian", 1, 1800, 120, 400, 1, 190, 20,0,1,1,0,"None", "None", 0, "MELEE", "Human", new String[]{"Berserker_Barrage","Slash",/*"YARGHHHHH" -> summon berserker*/}, 1, new String[] {}),

    Demon_Lord_Skalzok("Demon Lord Skalzok", 1, 2000, 230, 500, 300, 200, 18,0,0,1,0,"None", "None", 0, "MELEE", "Demon" , new String[]{"Arcane_Comet","Slash","Hellfire_Blast"}, 1, new String[] {}),

    Dwarf_Captain("Dwarf Captain", 1, 1650, 200, 200, 10, 120, 10,0,100,1,0,"None", "None", 0, "MELEE", "Dwarf" , new String[]{"Strike","Crossbow_Shot"/*"Dwarf Reinforcements"*/}, 1, new String[] {}),

    Dwimbledon_The_Forsaken("Dwimbledon The Forsaken", 1, 1400, 100, 100, 500, 120, 10,0,10,1,0,"None", "None", 0, "RANGE", "Human" , new String[]{"The Final Comet","Charge", "Arcane Burn", "Arcane Barrier", "Teleport"/*"Dwarf Reinforcements"*/}, 1, new String[] {}),

    // AI CorpseEater -> checks enemy map to see if it contains corpse, if yes, it will begin going toward it, otherwise it'll go toward you.
    Corpse_Eater("Corpse Eater", 1, 3000, 200, 200, 10, 120, 10,0,100,1,0,"None", "None", 0, "Corpse", "Undead" , new String[]{/*"Summon Ghoul", "Rotting Flesh" -> lose health every turn, "Chomp", "Devour Flesh" -> used on you, heals boss slightly ->, "Devour Corpse" -> heavy heal + buff.*/}, 2, new String[] {}),


    Rotting_Ghoul("Rotting Ghoul", 0, 300, 1, 200, 10, 200, 10,0,100,1,0,"None", "None", 0, "MELEE", "Undead" , new String[]{/*"Summon Ghoul", "Rotting Flesh" -> lose health every turn, "Chomp", "Devour Flesh" */}, 1, new String[] {}),


    //skeleton boss, phase one floods enemies in and debuffs you.
    Skelegog("Skelegog", 0, 3000, 1, 1, 1, 1, 10,0,1,1,0,"None", "None", 0, "MELEE", "Undead" , new String[]{/*"Summon Skeleton","Summon Skeleton Giant","Summon Archer, "Skelerot"*/}, 1, new String[] {}),

    Skelegog_The_Giant("Skelegog The Giant", 0, 2000, 300, 300, 100, 1, 10,0,300,1,0,"None", "None", 0, "MELEE", "Undead" , new String[]{/*"Crush","Skeleton Legion","Decaying Blast", "Bone Throw", "To The Grave",*/}, 1, new String[] {}),

    Grozh_The_Demon_King("Grozh The Demon King", 1, 8000, 700, 900, 900, 250, 32,0,800,1,0,"None", "None", 0, "MELEE", "Demon" , new String[]{"Demon_Reinforcements", "Demonic_Blaze", "Slice_And_Dice","Earthquake","Unholy_Strength","Hellfire_Shot","Slam",}, 1, new String[] {}),

    Elric_The_Hero("Elric The Hero", 0, 8000, 800, 800, 800, 200, 30,0,800,1,0,"None", "None", 0, "MELEE", "Undead" , new String[]{"Bulwark_Charge", "Focused_Lunge", "28_Lunges", "Arrow Deflection","Arrow_Rain", "Eagle_Shot", "Crippling_Shot", "Arcane_Blast", "Arcane_Comet","Rejuvenation"} ,1, new String[] {}),

    Elder_Mage_Kairos("Elder Mage Kairos", 0, 8000, 300, 800, 1600, 200, 40,0,1,1,0,"None", "None", 0, "MELEE", "Human" , new String[]{"Necromancy", "Elder_Blessing", "Forgotten_Blaze", "Snake_Bolt","Draining_Bolt", "Demonic_Curse", "Blood_Blast", "Shadow_Blast",}, 1, new String[] {}),

    Undead_Hero("Undead Hero", 0, 1000, 800, 800, 1, 150, 30,0,1,1,0,"None", "None", 0, "MELEE", "Undead" , new String[]{"Slash","Evicerate", "Critical Blows"}, 1, new String[] {}),

    Undead_Archer("Undead Archer", 0, 1000, 0, 800, 1, 400, 30,0,800,4,0,"None", "None", 0, "MELEE", "Undead" , new String[]{"Arrow_Storm","Arrow_Rain","Critical_Shot"}, 1, new String[] {}),

    Undead_Mage("Undead Mage", 0, 1000, 0, 1, 1000, 150, 30,0,1,2,0,"None", "None", 0, "MELEE", "Undead" , new String[]{"Arcane_Comet","Shadow_Blast", "Empowering_Blaze"}, 1, new String[] {}),

    Undead_Druid("Undead Druid", 0, 1000, 0, 1, 1, 150, 30,0,1,2,0,"None", "None", 0, "MELEE", "Undead" , new String[]{"Energize", "Healers_Touch","Team_Barrier","Critical_Foresight","Masterful_Gaze","Weaken"}, 1, new String[] {}),


    //final boss
    Heimsgot_The_Forsaken("Heimsgot The Forsaken", 0, 3000, 1000, 1000, 1000, 200, 30,0,1000,1,0,"None", "None", 0, "MELEE", "Human" , new String[]{"Embrace_Power","Arcane_Burst","Enraged_Slash","Heartpiercing Shot"/*"Moving Shadow"*/}, 1, new String[] {}),

    Heimsgot_The_Shadow("Heimsgot The Shadow", 0, 4000, 1000, 1000, 1000, 200, 30,0,1000,1,0,"None", "None", 0, "MELEE", "Shadow" , new String[]{"Embrace_The_Shadow","Shadow_Burst","Shadow_Slash","Shadow_Arrow"},1, new String[] {}),

    Shadow("Shadow", 0, 200, 1000, 1000, 1000, 100, 20,0,1000,1,0,"None", "None", 0, "MELEE", "Shadow" , new String[]{"Shadow_Charge", "Gift_Of_Shadow","Shadow_Burst","Shadow_Slash","Shadow_Arrow"}, 1, new String[] {}),



    Heimsgot_The_True("Heimsgot The True", 0, 10000, 1, 1300, 1300, 300, 50,0,1300,1,0,"None", "None", 0, "MELEE", "Shadow" , new String[]{"The_End", "IT_WILL_NOT_END_FOR_ME", "TRUE_POWER","Rain_Of_Shadows","Afterimage_Slash","Shadow_Grasp","Shadowpiercer", /* IT WILL NOT END is used once he reaches half HP, where he will use THE END for the rest of the fight, "Moving Shadow"*/},1,new String[] {}),

    The_Heart_Of_Evil("The Heart Of Evil", 0, 1, 1, 1, 1, 1, 0,100,1,1,0,"None", "None", 0, "MELEE", "Shadow" , new String[]{"Goodbye"}, 1, new String[] {}),





        ;



        private final String Name;

        private final int Weighting;

        private final int cMAGE;

        private final int turnCount;

        private final String[] dropTable;
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
        private final int DEFLECT;
        private final String AI;
        private final String[] Attacks;


    private final String Type; //placeholder till i make attack categories for enemies :)


        //set enums for the player whenever i hard rework all that fun jazz from the tab
        Bosses(String NAME, int WEIGHT, int HP, int DEF, int ATK, int MAGE, int AGIL, int CRIT, int ABSORP, int RNG, int DIST, int DEFLECT, String ATRI, String STATUS, int DUR, String AI, String Type, String[] Attacks, int turnCount, String[] dropTable)
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
            this.DEFLECT = DEFLECT;
            this.AI = AI;
            this.Type = Type;
            this.Attacks = Attacks;
            this.turnCount = turnCount;
            this.dropTable = dropTable;




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

        public int getDEFLECT() {
            return DEFLECT;
        }
        public String getAI() {return AI;}

    }

