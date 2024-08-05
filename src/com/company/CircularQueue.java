package com.company;

import java.security.spec.RSAOtherPrimeInfo;

public class CircularQueue {
    static int[] arr;
    static int size;
    static int front = -1;
    static int rear = -1;

    public CircularQueue(int n) {
        size = n;
        arr = new int[size];
    }

    public static boolean isEmpty(){
        return rear == -1 && front == -1;
    }

    public static boolean isFull(){
        return (rear + 1) % size == front;
    }

    public static void enqueue(int data){
        if(isFull()){
            System.out.println("Overflow");
            return ;
        }
        //add first element
        if(front == -1){
            front = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    public static int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int result = arr[front];
        //single element
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % size;
        }
        return result;
    }

    public static int peek(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return  -1;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        enqueue(1);
        enqueue(2);
        enqueue(3);
        enqueue(4);
        enqueue(5);
        dequeue();
        enqueue(6);

        while(!isEmpty()){
            System.out.println(dequeue());

        }
    }
}
