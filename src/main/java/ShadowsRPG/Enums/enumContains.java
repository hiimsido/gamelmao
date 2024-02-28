package ShadowsRPG.Enums;

public class enumContains {
    public static boolean weapon(String item)

    {

        for (playerEquipment.Weapon each : playerEquipment.Weapon.values()
             ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return true;
            }

        }
        return false;
    }

    public static int wepVal(String item)

    {

        for (playerEquipment.Weapon each : playerEquipment.Weapon.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return each.getValue();
            }

        }
        return 0;
    }

    public static boolean helmet(String item)

    {

        for (playerEquipment.Head each : playerEquipment.Head.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return true;
            }

        }
        return false;
    }

    public static int headVal(String item)

    {

        for (playerEquipment.Head each : playerEquipment.Head.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return each.getValue();
            }

        }
        return 0;
    }

    public static boolean body(String item)

    {

        for (playerEquipment.Body each : playerEquipment.Body.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return true;
            }

        }
        return false;
    }

    public static int bodyVal(String item)

    {

        for (playerEquipment.Body each : playerEquipment.Body.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return each.getValue();
            }

        }
        return 0;
    }

    public static boolean legs(String item)

    {

        for (playerEquipment.Legs each : playerEquipment.Legs.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return true;
            }

        }
        return false;
    }

    public static int legsVal(String item)

    {

        for (playerEquipment.Legs each : playerEquipment.Legs.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return each.getValue();
            }

        }
        return 0;
    }

    public static boolean gloves(String item)

    {

        for (playerEquipment.Gloves each : playerEquipment.Gloves.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return true;
            }

        }
        return false;
    }

    public static int glovesVal(String item)

    {

        for (playerEquipment.Gloves each : playerEquipment.Gloves.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return each.getValue();
            }

        }
        return 0;
    }

    public static boolean shield(String item)

    {

        for (playerEquipment.Shield each : playerEquipment.Shield.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return true;
            }

        }
        return false;
    }

    public static int shieldVal(String item)

    {

        for (playerEquipment.Shield each : playerEquipment.Shield.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return each.getValue();
            }

        }
        return 0;
    }

    public static boolean arrow(String item)

    {

        for (playerEquipment.Arrows each : playerEquipment.Arrows.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return true;
            }

        }
        return false;
    }

    public static int arrowVal(String item)

    {

        for (playerEquipment.Arrows each : playerEquipment.Arrows.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return each.getValue();
            }

        }
        return 0;
    }

    public static boolean bow(String item)

    {

        for (playerEquipment.Bow each : playerEquipment.Bow.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return true;
            }

        }
        return false;
    }

    public static int bowVal(String item)

    {

        for (playerEquipment.Bow each : playerEquipment.Bow.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return each.getValue();
            }

        }
        return 0;
    }

    public static boolean boots(String item)

    {

        for (playerEquipment.Boots each : playerEquipment.Boots.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return true;
            }

        }
        return false;
    }

    public static int bootsVal(String item)

    {

        for (playerEquipment.Boots each : playerEquipment.Boots.values()
        ) {
            if (each.getName().equalsIgnoreCase(item))
            {
                return each.getValue();
            }

        }
        return 0;
    }



    // Returns coin value and item name

/*
    public static String helmetVal(String item)

    {

        for (GameEnums.Head each : GameEnums.Head.values()
        ) {

            if (each.getName().equalsIgnoreCase(item)) {


                return each.getName() + "|" + each.getValue();
            }
        }
        return null;
    }

    public static String bodyVal(String item)

    {

        for (GameEnums.Body each : GameEnums.Body.values()
        ) {

            if (each.getName().equalsIgnoreCase(item)) {


                return each.getName() + "|" + each.getValue();
            }
        }
        return null;
    }

    public static String legsVal(String item)

    {

        for (GameEnums.Legs each : GameEnums.Legs.values()
        ) {

            if (each.getName().equalsIgnoreCase(item)) {


                return each.getName() + "|" + each.getValue();
            }
        }
        return null;
    }

    public static String glovesVal(String item)

    {

        for (GameEnums.Gloves each : GameEnums.Gloves.values()
        ) {

            if (each.getName().equalsIgnoreCase(item)) {


                return each.getName() + "|" + each.getValue();
            }
        }
        return null;
    }

    public static String shieldVal(String item)

    {

        for (GameEnums.Shield each : GameEnums.Shield.values()
        ) {

            if (each.getName().equalsIgnoreCase(item)) {


                return each.getName() + "|" + each.getValue();
            }
        }
        return null;
    }





    public static String bootsVal(String item) {

        for (GameEnums.Boots each : GameEnums.Boots.values()
        ) {

            if (each.getName().equalsIgnoreCase(item)) {


                return each.getName() + "|" + each.getValue();
            }
        }
        return null;
    }

    public static String weaponVal (String item)
    {
        for (GameEnums.Weapon each: GameEnums.Weapon.values()
             ) {

            if (each.getName().equalsIgnoreCase(item))
            {


                return each.getName() + "|" + each.getValue();
            }

        }


        return null;
    }

    public static String arrowVal (String item)
    {
        for (GameEnums.Arrows each: GameEnums.Arrows.values()
        ) {

            if (each.getName().equalsIgnoreCase(item))
            {


                return each.getName() + "|" + each.getValue();
            }

        }


        return null;
    }

    public static String bowVal (String item)
    {
        for (GameEnums.Bow each: GameEnums.Bow.values()
        ) {

            if (each.getName().equalsIgnoreCase(item))
            {


                return  each.getName() + "|" + each.getValue();
            }

        }


        return null;
    }

    */

   /* public static boolean range(String item)

    {

    }
    */
}
