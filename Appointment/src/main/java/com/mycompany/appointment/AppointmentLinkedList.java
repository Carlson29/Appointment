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

    public AppointmentLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(Appointment appoint) {
        Node newNode = new Node(appoint);

        if (isEmpty() == true) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    public boolean add(int position, Appointment appoint) {
        Node newNode = new Node(appoint);

        if (position == 0) {
            first = newNode;
            last = newNode;
        } else {
            Node current = first;

            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public int indexOf(Appointment appoint) {
        if (isEmpty() == true) {
            return -1;
        } else {
            Node current = new Node(appoint);
            for (int i = 0; i < size; i++) {
                if (current.data.equals(appoint)) {
                    return i;
                }
                current = current.next;
            }
        }
        return -1;
    }

    public Appointment get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = first;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    public boolean remove(Appointment appoint) {
        if (isEmpty() == true) {
            return false;
        }
        if (first.data.equals(appoint)) {
            first = first.next;
            size--;
            return true;
        } else {
            Node current = first.next;
            Node prev = first;
            while (current.next != null) {
                if (current.data.equals(appoint)) {
                    prev.next = current.next;
                    size--;
                    if (current.data.equals(last.data)) {
                        last = prev;
                    }
                    return true;
                }
                prev = current;
                current = current.next;
            }
        }
        return false;
    }

    public Appointment remove(int position) {
        Appointment remove = null;
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            remove = first.data;
            first = first.next;
            size--;
            return remove;
        } else {
            Node current = first;
            Node prev = null;
            for (int i = 0; i < position; i++) {
                prev = current;
                current = current.next;
            }
            if (current.data.equals(last.data)) {
                last = prev;
            }

            prev.next = current.next;
            size--;
            return current.data;
        }

    }

    private static class Node {

        private Appointment data;
        private Node next;

        public Node(Appointment data) {
            this.data = data;
            next = null;
        }
    }
}
