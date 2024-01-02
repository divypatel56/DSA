package com.company;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String,Integer> countryInfo = new HashMap<String,Integer>();
        //Insert -- put
        countryInfo.put("India",122);
        countryInfo.put("Us",22);
        countryInfo.put("Canada",90);

        System.out.println(countryInfo);
        countryInfo.put("India",135);
        System.out.println(countryInfo );

        //Search --- containsKey,
        System.out.println(countryInfo.containsKey("India"));
        System.out.println(countryInfo.containsValue(99));

        System.out.println(countryInfo.get("Us"));
        System.out.println(countryInfo.get("Mexico"));

        //Iterator >Entry
        for(Map.Entry<String,Integer> e : countryInfo.entrySet()){
            System.out.print("Key:"+e.getKey());
            System.out.print("\nValue:"+e.getValue());

            System.out.println("\n"+e);

        }

        // 2. Way to iterate over HashMAp using Key set
//        System.out.println("---------------Printing HashMap using Key set----------------");
//        Set<String> key = countryInfo.keySet();
//        for(String keys : key){
//            System.out.println(keys+" "+countryInfo.get(keys));
//        }

        // Delete --- remove
        countryInfo.remove("Canada");
        System.out.println("After Deleting "+countryInfo);


    }


}
