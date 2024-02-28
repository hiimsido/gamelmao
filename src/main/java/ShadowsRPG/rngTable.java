package ShadowsRPG;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class rngTable<E> {



    private NavigableMap<Double, E> map = new TreeMap<>();
    private final Random random;
    private double total = 0;


    public rngTable()
    {
        this(new Random());
    }

    public rngTable(Random random){
        this.random = random;
    }



    public rngTable<E> add (double weight, E result)
    {
        if (weight <= 0) return this;
        total += weight;
        map.put(total,result);
        return this;
    }

    public rngTable<E> remove()
    {
        double value = random.nextDouble();

        map.remove(map.higherEntry(value).getKey());
        return this;
    }

    public boolean isEmpty ()
    {
        return map.isEmpty();
    }

    public E next(){
        double value = random.nextDouble()*total;

        return map.higherEntry(value).getValue();


    }

    public static void main(String[] args) {

        rngTable<String> rc = new rngTable<>();
        rc.add(100, "Wooden Sword");
        rc.add(1,"The Blades Of Chaos");

        System.out.println(rc.next());
       while (!rc.isEmpty()) {
            System.out.println(rc.next());
            rc.remove();
        }



    }

}
