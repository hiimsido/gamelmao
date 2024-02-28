package ShadowsRPG.store;

import ShadowsRPG.Enums.playerEquipment;
import ShadowsRPG.Enums.enumContains;
import ShadowsRPG.Inventory;
import ShadowsRPG.MainGame;
import ShadowsRPG.capitalizeWord;

import java.util.*;

public class TheStore {


    public static void Store() {


        ArrayList<String> Options = new ArrayList<>();
        Options.add("PREVIOUS");

        //remove choices based on items and wealth
        if (MainGame.Coins > 0) {
            Options.add("BUY");
        }
        if (!Inventory.Inv.isEmpty()) {
            Options.add("SELL");
        }

        String response = "";

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Store! How may I help you?");
        for (String each : Options
        ) {
            System.out.println(each);
        }

        do {
            response = scan.nextLine();

        }
        while (!Options.contains(response.toUpperCase()));


        switch (response.toUpperCase()) {


            case "EXIT":
                return;

            case "BUY":

                System.out.println("So you'd like to buy something? What would you like to buy?");
                buy();
                break;


            case "SELL":

                System.out.println("So you'd like to sell something? What do you want to sell?");
                sell();
                break;


        }


    }

    static void buy() {
        Scanner scan = new Scanner(System.in);
        String[] optionsBuy = {"WEAPONS", "ARMOR", "RANGE EQUIPMENT", "PREVIOUS"};
        ArrayList<String> Options = new ArrayList<>(List.of(optionsBuy));
        LinkedHashMap<String,Integer> forSale = new LinkedHashMap<>();

        System.out.println("- - - ITEMS TO BUY - - -");

        String response = "";

        for (String each :
                Options) {
            System.out.println(each);
        }

        do {
            response = scan.nextLine();

        }
        while (!Options.contains(response.toUpperCase()));


        switch (response.toUpperCase()) {


            //note: to make life easier, could do a check on coins vs items to determine if it gets added to the hashmap.

            case "PREVIOUS":
                Store();
                break;
            case "WEAPONS":
                for (playerEquipment.Weapon each : playerEquipment.Weapon.values()
                     ) {
                    forSale.put(each.getName(),each.getValue());
                }
                break;
            case "ARMOR":
                for (playerEquipment.Head each : playerEquipment.Head.values()
                ) {
                    forSale.put(each.getName(),each.getValue());
                }

                for (playerEquipment.Body each : playerEquipment.Body.values()
                ) {
                    forSale.put(each.getName(),each.getValue());
                }

                for (playerEquipment.Legs each : playerEquipment.Legs.values()
                ) {
                    forSale.put(each.getName(),each.getValue());
                }

                for (playerEquipment.Shield each : playerEquipment.Shield.values()
                ) {
                    forSale.put(each.getName(),each.getValue());
                }
                break;
            case "RANGE EQUIPMENT":

                for (playerEquipment.Bow each : playerEquipment.Bow.values()
                ) {
                    forSale.put(each.getName(),each.getValue());
                }
                for (playerEquipment.Arrows each : playerEquipment.Arrows.values()
                ) {
                    forSale.put(each.getName(),each.getValue());
                }
                break;


        }

        do
        {
            System.out.println("Here's what you can purchase");

            forSale.forEach ((key,value) -> {
                System.out.println(key + " : " + value + " coins.");
                    }
            );

            System.out.println("Pick an item you'd like to purchase.");

            do
            {
                response = capitalizeWord.capItem(scan.nextLine());
            }
            while(!response.equalsIgnoreCase("EXIT")&&!forSale.containsKey(response));

            if(forSale.containsKey(response)) {
                int price = forSale.get(response);
                int buyCap = MainGame.Coins/price;
                int purchase = 0;
                String itemName = response;

                if (buyCap>0)
                {
                    while (purchase<1)
                    {
                            try {
                                System.out.println("How many " + itemName + "s would you like to buy?");
                                purchase = Math.min(Integer.parseInt(scan.nextLine()), buyCap);

                            } catch (Exception e) {
                                System.out.println("Please pick a number and not a letter.");
                            }

                            if (purchase<1)
                            {
                                System.out.println("You can't buy negative items. Fool.");
                            }
                    }

                    if (purchase > 1) {
                        System.out.println("Are you sure you want to buy " + buyCap + " " + itemName + "?");
                        System.out.println("Total: " + purchase);
                    }

                    else {
                        System.out.println("Are you sure you want to buy a " + itemName + "?");
                    }

                    System.out.println("YES or NO");

                    while (!response.equalsIgnoreCase("yes")&&!response.equalsIgnoreCase("no"))
                    {
                        response = scan.nextLine();
                    }

                    if (response.equalsIgnoreCase("yes")){
                        MainGame.Coins = MainGame.Coins - price*purchase ;
                        if(Inventory.Inv.containsKey(itemName))
                        {
                            Inventory.Inv.replace(itemName, Inventory.Inv.get(itemName) + purchase);
                        }

                        else{
                            Inventory.Inv.put(itemName,purchase);
                        }
                        System.out.println("You have purchased: " + buyCap + " " + "of " + itemName + ".");

                        if (Inventory.Inv.get(itemName)<1)
                        {
                            System.out.println("You have " + Inventory.Inv.get(itemName) + " of " + itemName + " in your inventory.");
                        }
                        System.out.println("You're left with " + MainGame.Coins  + ".");



                    }

                  else if (response.equalsIgnoreCase("no")){
                        System.out.println("Purchase canceled.");
                    }


                }

                else
                {
                    System.out.println("You can't afford this item.");
                }




        }



            if (MainGame.Coins<=0)
            {
                System.out.println("You have no more money to spend.");
                Store();
            }


            System.out.println("Would you like to buy anything else?");
            System.out.println("CONTINUE or EXIT");

            while (!response.equalsIgnoreCase("continue")&&!response.equalsIgnoreCase("exit"))
            {
                response = scan.nextLine();
            }


        }
        while(!response.equalsIgnoreCase("EXIT")&&(MainGame.Coins>0));

        buy();
    }

    static void sell() {
        Scanner scan = new Scanner(System.in);
        System.out.println("- - - ITEMS TO SELL - - -");

        ArrayList<String> Options = new ArrayList<>();
        Options.add("PREVIOUS");

        String response = "";
        String sellItem = "";







        /* ArrayList<String> InvQuantity =  new ArrayList<>(); */

        HashMap<String, Integer> invArmor = new HashMap<>();
        HashMap<String, Integer> invWeapons = new HashMap<>();
        HashMap<String, Integer> invRange = new HashMap<>();


        Inventory.Inv.forEach((key, value) -> {
          /*  for (int i = 0; i < value; i++) {
                InvQuantity.add(key);
            }*/


                    if (enumContains.weapon(key)) {
                        invWeapons.put(key, enumContains.wepVal(key));
                    } else if (enumContains.bow(key)) {
                        invRange.put(key, enumContains.bowVal(key));
                    } else if (enumContains.arrow(key)) {
                        invRange.put(key, enumContains.arrowVal(key));
                    } else if (enumContains.helmet(key)) {
                        invArmor.put(key, enumContains.headVal(key));
                    } else if (enumContains.legs(key)) {
                        invArmor.put(key, enumContains.legsVal(key));
                    } else if (enumContains.body(key)) {
                        invArmor.put(key, enumContains.bodyVal(key));
                    } else if (enumContains.boots(key)) {
                        invArmor.put(key, enumContains.bootsVal(key));
                    } else if (enumContains.gloves(key)) {
                        invArmor.put(key, enumContains.glovesVal(key));
                    } else if (enumContains.shield(key)) {
                        invArmor.put(key, enumContains.shieldVal(key));
                    }


                }


        );

        if (!invWeapons.isEmpty()) {
            Options.add("WEAPONS");
        }

        if (!invRange.isEmpty()) {
            Options.add("RANGE EQUIPMENT");
        }

        if (!invArmor.isEmpty()) {
            Options.add("ARMOR");
        }


        for (String each :
                Options) {
            System.out.println(each);
        }


        do {
            response = scan.nextLine();

        }
        while (!Options.contains(response.toUpperCase()));

        if (response.equalsIgnoreCase("previous")) {
            Store();
        } else if (response.equalsIgnoreCase("weapons")) {
            String option = "";
            if (invWeapons.isEmpty()) {
                System.out.println("You have nothing else to sell.");
                System.out.println("Press enter to continue.");
                scan.nextLine();
                Store();
            }

            do {
                //capitalization failsafe for it to match all enum items.
                System.out.println("Choose one of the following items you'd like to sell.");
                System.out.println("Or type EXIT if you've changed your mind.");
                invWeapons.forEach((key, value) -> {
                            System.out.println(key + " x" + Inventory.Inv.get(key) + " : " + value + " Coins.");

                        }
                );
                sellItem = capitalizeWord.capItem(scan.nextLine());

                if (Inventory.Inv.containsKey(sellItem) && !Inventory.Inv.isEmpty()) {

                    if (Inventory.Inv.get(sellItem) == 1) {
                        System.out.println("Are you sure you want to sell a " + sellItem + " for " + invWeapons.get(sellItem));
                        System.out.println("YES to confirm.");
                        System.out.println("NO to return to your items.");

                        if (scan.nextLine().toUpperCase().equals("YES")) {
                            int val = invWeapons.get(sellItem);

                            MainGame.Coins = MainGame.Coins + val;
                            System.out.println("You've sold 1 " + sellItem + " for " + val + " coins!");
                            System.out.println("You now have " + MainGame.Coins + " coins!");
                            invWeapons.remove(sellItem);
                            Inventory.Inv.remove(sellItem);
                        }


                    } else if (Inventory.Inv.get(sellItem) > 1) {
                        int sellCap = Inventory.Inv.get(sellItem);
                        int sell = 0;

                        while (sell < 1) {
                            try {
                                System.out.println("How many of your " + sellItem + "s would you like to sell?");
                                sell = Math.min(Integer.parseInt(scan.nextLine()), sellCap);

                            } catch (Exception e) {
                                System.out.println("Please pick a number and not a letter.");
                            }

                            if (sell<1)
                            {
                                System.out.println("You can't sell negative items. Fool.");
                            }
                        }

                        System.out.println("Are you sure you want to sell " + sell + " " + sellItem + "s for " + invWeapons.get(sellItem) + " coins each? (total: " + invWeapons.get(sellItem) * sell + ")");
                        System.out.println("YES to confirm.");
                        System.out.println("NO to return to your items.");

                        if (scan.nextLine().equalsIgnoreCase("YES")) {
                            int val = invWeapons.get(sellItem) * sell;
                            MainGame.Coins = MainGame.Coins + val;
                            System.out.println("You've sold " + sell + " " + sellItem + "s" + " for " + val + " coins!");
                            System.out.println("You now have " + MainGame.Coins + " coins!");
                            Inventory.Inv.replace(sellItem, Inventory.Inv.get(sellItem) - sell);

                            if (Inventory.Inv.get(sellItem) == 0) {
                                invWeapons.remove(sellItem);
                                Inventory.Inv.remove(sellItem);
                            } else {
                                System.out.println("You still have " + Inventory.Inv.get(sellItem) + " of your " + sellItem + " left.");
                            }
                        }


                    }

                } else if (sellItem.equalsIgnoreCase("EXIT")) {
                    break;
                } else {
                    System.out.println("That item is not present in your inventory.");

                }

                if (!invWeapons.isEmpty()) {
                    System.out.println("Would you like to continue or would you like to exit?");
                    option = scan.nextLine();
                } else {
                    System.out.println("You have nothing else to sell.");
        /*sell();
        break;*/
                }

            }
            while (!invWeapons.isEmpty() && (!option.equalsIgnoreCase("EXIT")));

            sell();

        } else if (response.equalsIgnoreCase("armor")) {
            String option = "";
            if (invArmor.isEmpty()) {
                System.out.println("You have nothing else to sell.");
                System.out.println("Press enter to continue.");
                scan.nextLine();
                Store();
            }

            do {
                //capitalization failsafe for it to match all enum items.
                System.out.println("Choose one of the following items you'd like to sell.");
                System.out.println("Or type EXIT if you've changed your mind.");
                invArmor.forEach((key, value) -> {
                            System.out.println(key + " x" + Inventory.Inv.get(key) + " : " + value + " Coins.");

                        }
                );
                sellItem = capitalizeWord.capItem(scan.nextLine());

                if (Inventory.Inv.containsKey(sellItem) && !Inventory.Inv.isEmpty()) {

                    if (Inventory.Inv.get(sellItem) == 1) {
                        System.out.println("Are you sure you want to sell a " + sellItem + " for " + invArmor.get(sellItem));
                        System.out.println("YES to confirm.");
                        System.out.println("NO to return to your items.");

                        if (scan.nextLine().toUpperCase().equals("YES")) {
                            int val = invArmor.get(sellItem);

                            MainGame.Coins = MainGame.Coins + val;
                            System.out.println("You've sold 1 " + sellItem + " for " + val + " coins!");
                            System.out.println("You now have " + MainGame.Coins + " coins!");
                            invArmor.remove(sellItem);
                            Inventory.Inv.remove(sellItem);
                        }


                    } else if (Inventory.Inv.get(sellItem) > 1) {
                        int sellCap = Inventory.Inv.get(sellItem);
                        int sell = 0;

                        while (sell < 1) {
                            try {
                                System.out.println("How many of your " + sellItem + "s would you like to sell?");
                                sell = Math.min(Integer.parseInt(scan.nextLine()), sellCap);

                            } catch (Exception e) {
                                System.out.println("Please pick a number and not a letter.");
                            }

                            if (sell<1)
                            {
                                System.out.println("You can't sell negative items. Fool.");
                            }
                        }

                        System.out.println("Are you sure you want to sell " + sell + " " + sellItem + "s for " + invArmor.get(sellItem) + " coins each? (total: " + invArmor.get(sellItem) * sell + ")");
                        System.out.println("YES to confirm.");
                        System.out.println("NO to return to your items.");

                        if (scan.nextLine().equalsIgnoreCase("YES")) {
                            int val = invArmor.get(sellItem) * sell;
                            MainGame.Coins = MainGame.Coins + val;
                            System.out.println("You've sold " + sell + " " + sellItem + "s" + " for " + val + " coins!");
                            System.out.println("You now have " + MainGame.Coins + " coins!");
                            Inventory.Inv.replace(sellItem, Inventory.Inv.get(sellItem) - sell);

                            if (Inventory.Inv.get(sellItem) == 0) {
                                invArmor.remove(sellItem);
                                Inventory.Inv.remove(sellItem);
                            } else {
                                System.out.println("You still have " + Inventory.Inv.get(sellItem) + " of your " + sellItem + " left.");
                            }
                        }


                    }

                } else if (sellItem.equalsIgnoreCase("EXIT")) {
                    break;
                } else {
                    System.out.println("That item is not present in your inventory.");

                }

                if (!invArmor.isEmpty()) {
                    System.out.println("Would you like to continue or would you like to exit?");
                    option = scan.nextLine();
                } else {
                    System.out.println("You have nothing else to sell.");
        /*sell();
        break;*/
                }

            }
            while (!invArmor.isEmpty() && (!option.equalsIgnoreCase("EXIT")));

            sell();


        } else if (response.equalsIgnoreCase("range equipment")) {
            String option = "";

            if (invRange.isEmpty()) {
                System.out.println("You have nothing else to sell.");
                System.out.println("Press enter to continue.");
                scan.nextLine();
                Store();
            }

  /*  else {
        System.out.println("Choose one of the following items you'd like to sell.");
        System.out.println("Or type EXIT if you've changed your mind.");
        invRange.forEach((key,value)-> {
                    System.out.println(key + " x" + Inventory.Inv.get(key) + " : " + value + " Coins.");

                }
        );
*/
            // the code for selling stuff

            do {
                //capitalization failsafe for it to match all enum items.
                System.out.println("Choose one of the following items you'd like to sell.");
                System.out.println("Or type EXIT if you've changed your mind.");
                invRange.forEach((key, value) -> {
                            System.out.println(key + " x" + Inventory.Inv.get(key) + " : " + value + " Coins.");

                        }
                );
                sellItem = capitalizeWord.capItem(scan.nextLine());

                if (Inventory.Inv.containsKey(sellItem) && !Inventory.Inv.isEmpty()) {

                    if (Inventory.Inv.get(sellItem) == 1) {
                        System.out.println("Are you sure you want to sell a " + sellItem + " for " + invRange.get(sellItem));
                        System.out.println("YES to confirm.");
                        System.out.println("NO to return to your items.");

                        if (scan.nextLine().toUpperCase().equals("YES")) {
                            int val = invRange.get(sellItem);

                            MainGame.Coins = MainGame.Coins + val;
                            System.out.println("You've sold 1 " + sellItem + " for " + val + " coins!");
                            System.out.println("You now have " + MainGame.Coins + " coins!");
                            invRange.remove(sellItem);
                            Inventory.Inv.remove(sellItem);
                        }


                    } else if (Inventory.Inv.get(sellItem) > 1) {
                        int sellCap = Inventory.Inv.get(sellItem);
                        int sell = 0;

                        while (sell < 1) {
                            try {
                                System.out.println("How many of your " + sellItem + "s would you like to sell?");
                                sell = Math.min(Integer.parseInt(scan.nextLine()), sellCap);

                            } catch (Exception e) {
                                System.out.println("Please pick a number and not a letter.");
                            }

                            if (sell<1)
                            {
                                System.out.println("You can't sell negative items. Fool.");
                            }
                        }

                        System.out.println("Are you sure you want to sell " + sell + " " + sellItem + "s for " + invRange.get(sellItem) + " coins each? (total: " + invRange.get(sellItem) * sell + ")");
                        System.out.println("YES to confirm.");
                        System.out.println("NO to return to your items.");

                        if (scan.nextLine().equalsIgnoreCase("YES")) {
                            int val = invRange.get(sellItem) * sell;
                            MainGame.Coins = MainGame.Coins + val;
                            System.out.println("You've sold " + sell + " " + sellItem + "s" + " for " + val + " coins!");
                            System.out.println("You now have " + MainGame.Coins + " coins!");
                            Inventory.Inv.replace(sellItem, Inventory.Inv.get(sellItem) - sell);

                            if (Inventory.Inv.get(sellItem) == 0) {
                                invRange.remove(sellItem);
                                Inventory.Inv.remove(sellItem);
                            } else {
                                System.out.println("You still have " + Inventory.Inv.get(sellItem) + " of your " + sellItem + " left.");
                            }
                        }


                    }

                } else if (sellItem.equalsIgnoreCase("EXIT")) {
                    break;
                } else {
                    System.out.println("That item is not present in your inventory.");

                }

                if (!invRange.isEmpty()) {
                    System.out.println("Would you like to continue or would you like to exit?");
                    option = scan.nextLine();
                } else {
                    System.out.println("You have nothing else to sell.");
        /*sell();
        break;*/
                }

            }
            while (!invRange.isEmpty() && (!option.equalsIgnoreCase("EXIT")));

            sell();
        }


    }







        /*switch (response.toUpperCase()) {


            case "PREVIOUS":
                Store();
            case "WEAPONS":
                ;
            case "ARMOR":
                ;

            case "RANGE EQUIPMENT":
                ;


        }*/


}


