package ShadowsRPG;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class hashMapAtIndex<K,V> extends HashMap<K,V> {



    public static int[] atIndex(int index, HashMap<int[], Integer> map)
    {
       final int[] test;

       HashMap<Integer,int[]> planB = new HashMap<>();
        AtomicInteger a = new AtomicInteger(0);

        map.forEach((key,val)-> {

            planB.put(a.get(),key);


        a.getAndIncrement();

        });

        return planB.get(index);







    }

}
