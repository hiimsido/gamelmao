package ShadowsRPG;

import java.util.ArrayList;

public class StoreAndRemoveTest {

    public static void main(String[] args) {
        ArrayList<Integer> Storage = new ArrayList<>();

        for (int i = 0; i < 11; i++) {

            Storage.add(i);

        }

        System.out.println(Storage);

        for (int i = 0; i < 3; i++) {

            int ran = (int)(Math.random()*Storage.size());

            System.out.println(Storage.get(ran));
            Storage.remove(ran);

            System.out.println(Storage);
        }

    }
}
