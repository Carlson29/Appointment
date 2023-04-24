/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appointment;

/**
 *
 * @author user
 */
public class AppointmentLinkedList {
    
    private Node first;
    private Node last;
    private int size;
    
    public AppointmentLinkedList(){
        first = null;
        last = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public boolean add(Appointment appoint){
        Node newNode = new Node(appoint);
        
        if(isEmpty()==true){
            first=newNode;
            last=newNode;
        }
        else {
            last.next=newNode;
            last=newNode;
        }
        size++;
        return true;
    }
    
    public boolean add(int position ,Appointment appoint){
        Node newNode = new Node(appoint);
        
        if(position==0){
            first=newNode;
            last=newNode;
        }
        else {
            Node current = first;
            
            for(int i=0; i<position; i++){
            current=current.next;
            }
            newNode.next=current.next;
            current.next=newNode;
        }
        size++;
        return true;
    }
    
    
    private static class Node{
    private Appointment data;
    private Node next;
    
    public Node(Appointment data){
        this.data=data;
        next=null;
    }
}
}
