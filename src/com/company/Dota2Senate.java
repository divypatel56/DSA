package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();

        // add element is queues
        for(int i =0; i<senate.length(); i++){
            if(senate.charAt(i)=='R'){
                radiant.add(i);
            }
            else{
                dire.add(i);
            }
        }

        while(!radiant.isEmpty() && !dire.isEmpty()){
            // Get the front of both quueue
            int r = radiant.poll() , d = dire.poll();
            // if radiant sentor is before the dire senatore, he will ban the next dire
            // senate
            if(r < d){
                // add the radiant at last of queue. Bcz it is a circular table.
                radiant.add(r+senate.length());
            }
            else{
                // else the dire senate ban the next radiant senate.
                // add the dire at last of queue. Bcz it is a circular table.
                dire.add(d + senate.length());
            }
        }
        //Determine the winner party
        return (radiant.size() > dire.size() ) ? "Radiant":"Dire";

    }
}


