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

    protected Node first;
    protected Node last;
    protected int size;

    public AppointmentLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Checks if the LinkedList is empty
     *
     * @return Boolean, true for empty and false for not empty
     *
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an appointment to the end of the LinkedList
     *
     * @param appoint, takes in an appointment as a parameter
     * @return Boolean indicating the appointment was added
     *
     */
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
            newNode.next = first;
            first = newNode;
            size++;
            return true;
        }

        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = first;

            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            if (position == size - 1) {
                last = newNode;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Returns the number of appointments in the LinkedList
     *
     * @return int, the method returns an int
     *
     */
    public int size() {
        return size;
    }

    /**
     * Gets the first instance of an appointment in the LinkedList
     *
     * @param appoint, takes in an appointment as a parameter
     * @return int, method returns an int or returns -1 if the appointment is
     * not in the LinkedList
     *
     */
    public int indexOf(Appointment appoint) {
        if (isEmpty() == true) {
            return -1;
        } else {
            Node current = first;
            for (int i = 0; i < size; i++) {
                if (current.data.equals(appoint)) {
                    return i;
                }
                current = current.next;
            }
        }
        return -1;
    }

    /**
     * Gets an appointment at a given position
     *
     * @return Appointment,
     * @param position, takes in an int as a parameter
     * @throws IndexOutOfBoundsException, if the position it less than 0 or
     * greater than or equal to size
     *
     */
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

    /**
     * Removes an appointment from a particular position
     *
     * @param position, takes in an int
     * @return Appointment, returns the appointment in that position
     * @throws IndexOutOfBoundsException if the position is less than 0 or
     * greater than or equal to size
     *
     *
     */
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
            if (position == size - 1) {
                last = prev;
            }

            prev.next = current.next;
            size--;
            return current.data;
        }

    }

    protected static class Node {

        protected Appointment data;
        protected Node next;

        public Node(Appointment data) {
            this.data = data;
            next = null;
        }
    }
}
