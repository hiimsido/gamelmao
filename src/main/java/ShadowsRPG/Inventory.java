package ShadowsRPG;

import ShadowsRPG.store.TheStore;

import java.util.HashMap;

public class Inventory {

    public static HashMap <String, Integer> Inv = new HashMap<>();


    public static void main(String[] args) {

        Inv.put("Steel Helmet", 4);
        Inv.put("The Shadow Longsword", 1);
        Inv.put("Titan Sword",2);
        Inv.put("Frostwaker Dagger",1);
        Inv.put("Mythril Sword",1);
        Inv.put("Wooden Bow",1);
        Inv.put("Steel Arrow",100);


        TheStore.Store();



    }
}
