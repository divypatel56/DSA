package com.company;
/**This class is for HashSet*/
import java.util.HashSet;
import java.util.Iterator;

public class Hashing {
    public static void main(String[] args) {
        //Creating
        HashSet<Integer> set = new HashSet<Integer>();

        //Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        //Size - total no of elements
        System.out.println("The size of the set is: "+set.size());

        //Search - contains
        System.out.println(set.contains(1));
        System.out.println(set.contains(8));

        //Delete - remove
        set.remove(1);
        System.out.println(set.contains(1));
        set.add(4);
        set.add(5);

        //Print
        System.out.println("The elements of set:"+set);

        //Iterator
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


    }
}
