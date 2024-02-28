package ShadowsRPG;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class dropTable<E> {

    private NavigableMap<Double,E> map = new TreeMap<Double,E>();

    Random random;
    private double total;

   public dropTable()
   {
       this(new Random());
   }

   dropTable(Random random)
   {
       this.random = random;
   }

}
