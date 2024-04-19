package ShadowsRPG;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WeakRes {

    public static void player(Player p)
    {
        HashMap<String,Integer> b = p.getTemporaryWeakness();
        HashMap<String,Integer> a = p.getTemporaryResistances();




        if (!b.isEmpty()) {
            Iterator<Map.Entry<String,Integer>> iterator  = b.entrySet().iterator();

            while (iterator.hasNext()) {
                String c = iterator.next().getKey();
                b.replace(c, b.get(c) - 1);

                if (c.equalsIgnoreCase("None")) {
                    iterator.remove();
                    continue;
                }

                if (b.get(c) <= 0) {
                    System.out.println(c + " has ran out.");
               //     p.getTemporaryWeakness().remove(c);
                    iterator.remove();
                }
            }

        }

        if (!a.isEmpty()) {
            Iterator<Map.Entry<String,Integer>> iterator  = a.entrySet().iterator();
            while (iterator.hasNext()) {
                String c = iterator.next().getKey();
                a.replace(c, a.get(c) - 1);

                if (c.equalsIgnoreCase("None")) {
                    iterator.remove();
                    continue;
                }

                if (a.get(c) <= 0) {
                    System.out.println(c + " has ran out.");
           //         p.getTemporaryWeakness().remove(c);
                    iterator.remove();
                }
            }
        }

    }

    public static void enemy(EnemyStats p)
    {
        HashMap<String,Integer> b = p.getTemporaryWeakness();
        HashMap<String,Integer> a = p.getTemporaryResistances();



if(!b.isEmpty()) {
    Iterator<Map.Entry<String,Integer>> iterator  = b.entrySet().iterator();
    while (iterator.hasNext()) {
        String c = iterator.next().getKey();
        b.replace(c, b.get(c) - 1);

        if (c.equalsIgnoreCase("None")) {
            iterator.remove();
            continue;
        }

        if (b.get(c) <= 0) {
            System.out.println("Vulnerability: " + c + " has ran out.");
          //  p.getTemporaryWeakness().remove(c);
            iterator.remove();
        }
    }
}

if (!a.isEmpty()) {
    Iterator<Map.Entry<String,Integer>> iterator  = a.entrySet().iterator();
    while (iterator.hasNext()) {
        String c = iterator.next().getKey();
        a.replace(c, a.get(c) - 1);

        if (c.equalsIgnoreCase("None")) {
            iterator.remove();
            continue;
        }

        if (a.get(c) <= 0) {
            System.out.println("Resistance: " + c + " has ran out.");
          //  p.getTemporaryWeakness().remove(c);
            iterator.remove();
        }
    }
}

    }
}
