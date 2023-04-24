package ShadowsRPG;

import java.util.*;

public class MainGame {
    static String userName = "";
    static String pClass = "";
    static String[] CharacterSelect = {"archer", "mager", "knight", "initiate", "???", "???", "???", "???"};


    static ArrayList<String> Spells = new ArrayList<>();
    static HashMap<String,Integer> Lmao = new HashMap<>();

    public static int ATK, RNG, MAGE, DEF, AGIL, HP, MANA, LVL = 0; //base stats
    public static int cATK, cRNG, cMAGE, cDEF, cAGIL, cHP, cMANA = 0 ; //current stats
    public static int Coins = 0;

    {
        //Gamestate is where the game is hosted, and runs the game through multitudes of states based on where you are and what you do.


    /*The States:
    Intro (Help menu with all information regarding mechanics and starting the game.
    Character Select: Choose 1 of 7 different builds: Archer (Range Specialist), Mage (Magic Specialist), Knight (Melee Specialist) (These are the 3 well-rounded classes, might also have different unlocks as well meaning to get other classes, you have to beat the game with X requirements. Can allow for hints to unlock classes though), Assassin(High Mobility meaning 2 movement turns, High Damage, Low Defense), Tank(Reflect DMG and Absorption), the Shade (Powerful Magical Abilities, at the cost of health + mana), and the Heavy Artillery (Heavy Range Damage Class, but very immobile).

    (Each class starts off with different gear, wealth, weapons, armor, and abilities.)

    Expedition Prep: Before each expedition, you are given a chance to enter the store and purchase consumables. (may consider a backpack limit or something bc why not)
    Armory: Here you can buy new weapons and gear/equip yourself. Can also check your damage output on different enemy types. (Think about including durability, as a coding challenge, and decide what low durability does). After the first expedition, you also have a chance to find high tier weapons being sold, for a hefty price.
    Magic's Store: Able to learn/upgrade spells, and purchase magical equipment.
    The Academy: A prestigious school, teaching you how to advance your skills. This is the best way to advance your base stats, at the cost of gold (goes up based on your base levels). Once your levels have reached a certain value, you can obtain mastery, which gives you a heavy boost in X stat, but it's incredibly expensive.
    Expedition: Based on your progress thus far, you'll be sent out to expedition. Maps are generated based on region. Regions also have loot modifiers increasing your odds of gold/and findings.
    - Boss Cavern: Each expedition has a final encounter with a boss. It's never recommended to enter a boss Region first, and instead recommended you clear out everything in a region first, then engage in a boss encounter. Defeating a boss guarantees you a drop from the boss loot table.
    - Cavern: Caverns are gauntlets filled with many enemies, filled with lots of loot and experience, however your supplies can easily get drained, and you'll be put in combat scenarios where it's 1 against many. Completing a cavern grants you a guaranteed drop.
    - Empty tiles: Progressing through the map, you might encounter enemies, with the chance increasing based on region/if you have not seen any enemies in a while.
    - Forest/Animal Caverns: A way to replenish on food, but your agility will be tested based on the animals found.
    - Mystery Tiles: These tiles can be filled with loot or possibly a tough miniboss, so it's a gamble. 1% chance to enter the shadow realm unless a shadow gate key is present, which changes it to 100% chance. The shadow realm leads you to finding a shadow weapon.
    - Settlement: Every region doesn't always have to be filled with baddies, Settlements are ways to stock up on consumables, but the supply may be much limited then your normal store pre-expedition.
    - The Forsaken One: A dark sinister being, who offers powerful things, in return for shadow gems or your stats. This can mean permanent debuffs to your health or other stats. However, he's also a trader, and will give you items of equal value in return for something extra (shadow gems). Important for rerolling for end-game tier items. Note, he will only appear by chance minus the final region, where you're guaranteed to encounter him.
    Expedition End: Shows your spoils, and you're rewarded for completing an expedition, ending off of slaying the region boss.
    ??? Tiles: Unknown.
    Ending: After completing the final region.


    EXP: Completing expeditions, and engaging in combat are ways to increase your EXP. At certain EXP thresholds, you'll level up which will boost your stats. Some characters will find they start off with higher base stats then others, and some may even have better

    Stats: Stats, are determined by gear, potion buffs, abilities, and so forth, these will determine how hard you hit, how much damage you can endure, how much you can move during combat encounters, and so on.

   - Basic Stats -
    Archery: Affects damage and range accuracy.
    Melee: Affects damage and melee accuracy.
    Magic: Affects damage, and magic accuracy/curse accuracy. As well as magic defense.
    Defense: Defense against physical attacks.
    Health: How much damage you can take.
    Agility: Agility affects movement and your ability to dodge attacks, as well as slaying animals for food.


    - Alternative Stats (Based on gear, other stats, buffs) -
    Mana: Based on magic and gear, resource for casting magic attacks/buffs. (Magic is always good even as a melee/ranger due to spells enhancing both).
    Mana Regen: Your regen rate for mana.
    Crit: Crit is affected only by gear and buffs. Crits are powerful in the sense that they ignore defense and roll for higher damage vs. the normal damage roll.
    Absorption: Soaks an amount of damage. Guard will always give you 50% damage absorption.
    Reflection: Returns damage back to the attacker. Some enemies naturally reflect damage from one style. (make a boss that reflects all damage while mobs are alive...?)
    Magic Resistance: Based on your magic level and gear. Determines resistance to magic attacks and curses.


   (De)Buffs/Modifiers: There are different buffs, debuffs, and general modifiers you'll encounter throughout combat.

    Debuffs:
  Freeze/Frosted: Affects movement, defense, and offense. Based on severity, it can completely freeze targets, preventing them from moving and attacking for several turns. If a target dies whilest frozen, the ice shards can explode, damaging nearby enemies (might be hard to code)
  Fire: Fire attacks will thaw out frosted enemies but deal increased damage, flame adds lingering damage which can spread its burn duration to other targets beside it.
  Corrosion: An acidic substance, capable of shredding defense. Corrosion burns will also deal damage over time.
  Curse: Curses are a magic debuff, which severity/change dependent on a target's magic defense in relation to your magic capabilities. Able to debuff a variety of stats.
  Shock: Shock damage is powerful, going through defense and bringing down enemy mobility.
  Bleed: Bleeds are powerful in the sense that they can stack/be refreshed, meaning you can cause multiple bleeds. Can be treated with supplies.
  Poison: Poison starts of weak, and gets stronger per turn. Severe cases of poison will reduce combat prowess, and based on the enemy/yourself, can be cured after enough time passes, but this is based on severity. Severe poison can last for long, long, periods of time, and you may find yourself better off curing yourself instead of dice rolling.
  Stun: Stuns will take away a whole turn of movement and combat. Only by the player, bosses, and minibosses.

  Modifiers/Attributes: Some enemies have found themselves embracing the very debuffs, applying them easily onto you, whilst also finding themselves resistant. Bosses will have natural resistance to debuffs but will still be partially affected by them (for example, they can't be frozen, but will still be frosted). (AKA Boss Attribute)

  Other Attributes:
  Retreat: Could be if it's the only enemy alive, could be if it hit's too low HP.
  Rallyer: Retreat attribute, once retreating, if left alive, can call for reinforcements.
  Boss: Given to bosses/minibosses, providing resistances.
  Ranged: Will retreat if you're too close, will get close if out of range.
  Berserk: There sanity traded for a dangerous combo of buffs. Incredibly aggressive, increased offensive stats, resistant to all types of immobility.
  Healer: Heals other targets before prioritizing other actions.
  Tank: Increased resistances to range/melee attacks (absorption)
  Blood: Able to heal off of damage it deals.
  Shadow: ???.

    Combat: During an expedition, you may find yourself engaging in fights. Combat is done in 5x5 map spaces, utilizing movement and attack range mechanics.
    Melee hit's the hardest, but has the lowest amount of distance (Long-Distance weapons have increased range). Range hits the lowest, and has the most accuracy variance, however it has the highest range. Magic is somewhere in the middle, but some enemies will have magical resistance.
    - Movement Turn: These are based on the agility stat, allowing for you to move X times with higher agility. Equipment may weigh you down though. Movement turns can also be used as turns to use potions/buff spells and can be used to end early.
    - Combat Turn: You'll find yourself with 1 combat turn although spells, potions, gear, or other modifiers, may increase your turns. Bosses will usually have multiple combat turns. Again, you can use a combat turn to use supplies, but it's recommended to do so during a movement turn.
    - Swapping styles: Between range and melee, you have to swap weapons meaning you'll spend one turn to swap out. By default, if you run out of ammo, you'll swap to your current melee weapon. Mage has the benefit of being usable with range or melee weapons equipped, but keep in mind your weapons accuracy with magic.

Weapon Types: There are many weapons, but some have different attributes.
Multi-Hit: Will hit the target multiple times.
Tipped Weapons: Weapons with the chance to inflict different debuffs.
Blood Weapons: Deadly weapons, which can siphon health for differring effects. Return health, boost stats, however, note that using them will always take health from you.
Shadow Weapons: Weapons with strange properties.
Cursed/Self-Infliction Weapons: some weapons have a chance/will inflict ailments for long-term usage. Yet they come with incredible power.
Weapon Special Attacks:
During combat, you'll begin gaining combat points which can be spent on special attacks/buffs based on your weapon. More of a late game mechanic.

Regions: There are various regions, you're required to go to 5 of them (6 including the shadow realm)

The Ruins: A once beautiful castle, destroyed by an unknown phenomena.
The Scorched Forest: A strange forest, filled with fire and life. Filled with many fire enemies.
The Frosted Lake: A place, filled with bitter cold, and many frosted enemies.
Giant's Mountain: A rocky land, filled with many obstructions, and caverns.
Sky Temple: An ancient island, only accessible by teleportation. Filled with forgotten relics, and powerful creatures.
Cultist Cavern: A cave filled with looters, the deranged, and cultists, speaking a tongue long forgotten. They speak of men who lurk in the shadows.
The Desert: A land filled with bandits and many creatures.
Underwater City: A city abandoned, covered in a large air bubble. Not much is known about this place nor what led to it being abandoned.
The Raiders Camp: The raider faction gather to this region, filled with many raiders.
The Archmage's Library: The 4th region you'll encounter, filled with forbidden knowledge.
The Palace: A place rumored to exist, this houses the evil which has caused chaos to the climate and well-being of the world. This is the final region.
The Shadow Realm: Unknown. (Secret Boss/Secret Ending?)

The first region will be randomized between 3 options. The second will be again 3 options, and the 3rd will be 3 options again. Region 4/5 are guranteed regions you'll encounter.

Enemies: There's a global pool of enemies you may encounter, but each region does have its own exclusive enemies. For example, goblins are present in most regions minus the final one, but scorpions are only found in the desert.
Obstructions: Some regions will have parts of the map closed off due to obstacles (rubble, terrain difficult to scale, etc).
Region exclusive structures: Some regions may have different distractions: for example, raider camps may have armories you can raid, but are well defended, while the Library may have ancient scrolls, teaching you powerful spells.
    */
    }
    static void runGame(){
        System.out.println("Welcome to the JavaRPG. Let's start off by asking, what is your name?");
        Scanner trackRes = new Scanner(System.in);
        String decision = "";
        String[] introText = {"So, our land was once beautiful and filled with life across the regions",
        "Until an evil man made an appearance.", "His siphoning of power, has led to the climates changing.",
        "And chaos began to unfold with some lands becoming uninhabitable.", "Many attempted to find refuge in new lands...",
        "Some succeeded, others failed and became bandits", "Some of our mages also looked to undo the curse upon our land...",
        "But they never returned. Which brings us to our final solution", "We need you to kill the evil within our lands.",
        "To find him, you must travel to the Archmage's Library, there you'll find out where the mage is.", "And you'll be able to stop the evil man, and restore the lands back to harmony.", "I wish you, the best of luck."};

        while (!decision.contains("yes")){

                userName = trackRes.nextLine();
                System.out.println(userName + " is your name correct?");
                decision = trackRes.nextLine().toLowerCase();

            if (!decision.contains("yes"))
            {
                System.out.println("Well, what's your name then?");
            }

            }


        System.out.println("Well " + userName + " We have much to discuss.");
        System.out.println("Press enter to continue.");
        trackRes.nextLine();
        printer(introText);

        characterSelect();






    }

   static void characterSelect()
    {
        System.out.println("Before we move any further, tell me, what is your classification?");
        Scanner option = new Scanner (System.in);
        ArrayList<String> yourOptions = new ArrayList<>(Arrays.asList(CharacterSelect));
        yourOptions.removeAll(List.of("???"));
        System.out.println("- - - Available Classes - - -");
        yourOptions.forEach((each -> System.out.println(each.toUpperCase())));

        do{

            pClass = option.nextLine().toLowerCase();

            if (!yourOptions.contains(pClass))
            {
                System.out.println("I'm sorry, I didn't catch that, what was your class again?");
            }

        }
        while (!yourOptions.contains(pClass));
        ClassStart.START(pClass);
        System.out.println("Ah so your a " + pClass + " Well, let's not waste more time, prepare yourself for the expedition!");
        System.out.println();



    }

    static void theHub()
    {
        System.out.println("Welcome to the hub, what would you like to do?");
    }


    static void printer(String[] printThis)
    {
        for (String each: printThis
             ) {
            Scanner pressEnter = new Scanner(System.in);
            System.out.println(each);
            System.out.println("Press enter to continue. Type \"skip\" if you wish to move on.");
           String skip = pressEnter.nextLine().toLowerCase();
           if (skip.contains("skip"))
           {
               return;
           }

        }
        System.out.println();
    }


    public static void main(String[] args) {


        runGame();
        //add a start and help command and credits

    }
}
