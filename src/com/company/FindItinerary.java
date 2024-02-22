package com.company;

import java.util.HashMap;

public class FindItinerary {

    public static String getStart(HashMap<String,String> ticket){
        HashMap<String,String> reverseMap = new HashMap<String, String>();
        for(String key : ticket.keySet()){
            reverseMap.put(ticket.get(key),key);
        }
       for(String key : ticket.keySet()){
           if(!reverseMap.containsKey(key)){
               return  key;
           }
       }
       return null;
    }

    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<String, String>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");
        String start = getStart(tickets);

        while (tickets.containsKey(start)){
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }
        System.out.print(start);

    }
}
