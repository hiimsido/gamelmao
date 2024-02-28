package ShadowsRPG;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WeakRes {

    public static void player(Player p)
    {
        HashMap<String,Integer> b = p.getTemporaryWeakness();
        HashMap<String,Integer> a = p.getTemporaryWeakness();


        Iterator<Map.Entry<String,Integer>> iterator  = b.entrySet().iterator();
        Iterator<Map.Entry<String,Integer>> iterator2  = a.entrySet().iterator();

        if (!b.isEmpty()) {
            while (iterator.hasNext()) {
                String c = iterator.next().getKey();
                b.replace(c, b.get(c) - 1);

                if (c.equalsIgnoreCase("None")) {
                    iterator.remove();
                    continue;
                }

                if (b.get(c) <= 0) {
                    System.out.println(c + " has ran out.");
                    p.getTemporaryWeakness().remove(c);
                    iterator.remove();
                }
            }
        }

        if (!a.isEmpty()) {
            while (iterator2.hasNext()) {
                String c = iterator.next().getKey();
                b.replace(c, b.get(c) - 1);

                if (b.get(c) <= 0) {
                    System.out.println(c + " has ran out.");
                    p.getTemporaryWeakness().remove(c);
                    iterator.remove();
                }
            }
        }
    }

    public static void enemy(EnemyStats p)
    {
        HashMap<String,Integer> b = p.getTemporaryWeakness();
        HashMap<String,Integer> a = p.getTemporaryWeakness();

        Iterator<Map.Entry<String,Integer>> iterator  = b.entrySet().iterator();
        Iterator<Map.Entry<String,Integer>> iterator2  = a.entrySet().iterator();
        if (!a.isEmpty()) {
            while (iterator.hasNext()) {
                String c = iterator.next().getKey();
                b.replace(c, b.get(c) - 1);

                if (c.equalsIgnoreCase("None")) {
                    iterator.remove();
                    continue;
                }

                if (b.get(c) <= 0) {
                    System.out.println(c + " has ran out.");
                    p.getTemporaryWeakness().remove(c);
                    iterator.remove();
                }
            }
        }
        if (!a.isEmpty()) {
        while(iterator2.hasNext()){
            String c = iterator.next().getKey();
            b.replace(c,b.get(c)-1);

            if (b.get(c) <= 0)
            {
                System.out.println(c + " has ran out.");
                p.getTemporaryWeakness().remove(c);
                iterator.remove();
            }
        }
        }

    }
}
