package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

/** We are implementing HashMap using Array of Linked List
 * And Time complexity will be constant O(1).
 */
public class HashMapCode {
    static class HashMap<K,V>  { //Generics

        /** Class Node: Represents node of linkedList*/
        private class Node{
            K key;
            V value;
        //Node class Constructor
            public Node(K key , V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // total no of nodes
        private final int N; // total no of bucket(index of array)
        private LinkedList<Node>[] buckets; //LinkedList type of array.
                                             // N = buckets.length;

        public HashMap(){
            this.N=4; //
            this.buckets = new LinkedList[4]; // Initializing LinkedList on Array.
            //At start array contains null. So we have to make an empty LinkedList at every
            //index of array that we can add node to that empty linked list.
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<Node>();
            }

        }
        /**Hash Algorithm that will return Bucket Index.*/
        private int HashFunction(K key){ //0 - N-1
            int bi = key.hashCode();
            return Math.abs(bi) % N;

        }

        /** Put() : To add(insert) key,value pair in HashMap.*/
        public void put(K key, V value){
            int bucketIndex = HashFunction(key);
            int dataIndex = SearchInLL(key,bucketIndex); // valid - 0+ inValid - -1

            if(dataIndex==-1){ //Key doesn't exist
                // add new linked list node at bucket index
                buckets[bucketIndex].add(new Node(key, value));
                //increase the n=nodes of linked list;
                n++;
            }
            else{ // Key already exist
                // Update the value of key.
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }

            double lambda = (double)n/N;
            if (lambda > 2.0) {
                //2.0 --> constant value K.
                //rehashing
                rehash();
            }
        }
        /** Search in Linked List Function*/
        //This function will check the key which we are trying to put/insert/add in Array is
        // already exist or not. This function will return the index value of linkedList at
        // specific bucket Index(Array Index).
        private int SearchInLL(K key, int bucketIndex) {
            LinkedList<Node> l1 = buckets[bucketIndex];

            for (int i = 0; i < l1.size(); i++) {
                if(l1.get(i).key == key){
                    return i; //di
                }
                
            }
            return  -1;
        }
        /** Rehash function : when lambda > K ---> it will increase the value of N: array size.*/
        private void rehash(){
            //1. copy the current buckets array to new array/bucket.
            LinkedList<Node>[] oldBuckets = buckets;
            //2.increase the size of buckets
            buckets = new LinkedList[N*2];
            //3.Initialize empty Linked List at every bucket\Index.
            for (int i = 0; i < N*2; i++) {
                buckets[i] = new LinkedList<Node>();
            }

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> l1 = oldBuckets[i];
                for (int j = 0; j <l1.size() ; j++) {
                    Node node = l1.get(j);
                    put(node.key,node.value);

                }
            }
        }

        /** Get Function: return the passed key's value."*/
        public V getKey(K key){
            int bucketIndex = HashFunction(key);
            int dataIndex = SearchInLL(key,bucketIndex); // valid - 0+ inValid - -1

            if(dataIndex==-1){ //Key doesn't exist
                return null;
            }
            else{ // Key already exist
                // Update the value of key.
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }

        }

        /** Contains Function: return true or false if key exist or not.*/
        public boolean containsKey(K key){
            int bucketIndex = HashFunction(key);
            int dataIndex = SearchInLL(key,bucketIndex); // valid - 0+ inValid - -1

            //Key doesn't exist
            // Key already exist
            return dataIndex != -1;
        }

        /** Remove: If key exist --> remove and return value.*/
        public K removeKey(K key){
            int bucketIndex = HashFunction(key);
            int dataIndex = SearchInLL(key,bucketIndex); // valid - 0+ inValid - -1
            if(dataIndex==-1){ //Key doesn't exist
                return null;
            }
            else{ // Key already exist
                Node node = buckets[bucketIndex].remove(dataIndex);
                n--;
                return node.key;

            }

        }
        /** isEmpty checks the hashmap is empty or not*/
        public boolean isEmpty(){
            return n==0;
        }

        /** This function will display the key as ArrayList*/
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<K>();
            for (int i = 0; i < buckets.length; i++) { //i = bi
                LinkedList<Node> l1 = buckets[i];
                for (int j = 0; j <l1.size(); j++) { //j= di
                    //remove node from linkedlist
                    Node node  = l1.get(j);
                    // add key of node to ArrayList
                    keys.add(node.key);
                }
            }
                return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> countryInfo =  new HashMap<String,Integer>();
        countryInfo.put("India",195);
        countryInfo.put("Us",105);
        countryInfo.put("China",135);
        countryInfo.put("Mexico",95);
        countryInfo.put("Canada",50);

        ArrayList<String> keys = countryInfo.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i)+": "+ countryInfo.getKey(keys.get(i)));
        }





    }
}
