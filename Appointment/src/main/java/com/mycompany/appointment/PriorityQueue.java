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
public class PriorityQueue extends AppointmentLinkedList {

    public PriorityQueue() {
        super();
    }

    /**
     * Adds an appointment in the queue based on it.s triage in ascending order
     *
     * @param appoint, takes in an appointment as it's parameter
     * @return Boolean
     *
     */
    public boolean enqueue(Appointment appoint) {
        if (super.isEmpty() == true) {
            return super.add(appoint);
        }
        if (super.first.data.getTriage() > appoint.getTriage()) {
            return super.add(0, appoint);
        }
        if (super.last.data.getTriage() <= appoint.getTriage()) {
            return super.add(appoint);
        } else {
            Node current = super.first.next;
            Node prev = super.first;
            Node newNode = new Node(appoint);
            for (int i = 0; i < super.size() - 1; i++) {
                if (current.data.getTriage() > appoint.getTriage()) {

                    prev.next = newNode;
                    newNode.next = current;
                    return true;
                }
                prev = current;
                current = current.next;
            }
        }
        return false;
    }

    /**
     * Removes the first appointment from the queue
     *
     * @return an Appointment, returns null if the queue is empty
     *
     */
    public Appointment dequeue() {
        return super.remove(0);
    }

    /**
     * Removes the first appointment from the queue
     *
     * @return Appointment
     * @throws NoSuchElementException if the queue is empty
 *
     */
    public Appointment remove() throws NoSuchElementException {
        if (super.isEmpty() == true) {
            throw new NoSuchElementException();
        }
        return super.remove(0);
    }

    /**
     * Gets the first appointment in the queue
     *
     * @return Appointment
     *
     */
    public Appointment peek() {
        return super.get(0);
    }

    /**
     * Gets the first appointment in the queue
     *
     * @return Appointment
     * @throws NoSuchElementException if queue is empty
 *
     */
    public Appointment Element() throws NoSuchElementException {
        if (super.get(0) == null) {
            throw new NoSuchElementException();
        }
        return super.get(0);
    }

    /**
     * Returns the number of Appointments in the LinkedList#
     *
     * @return an int
     *
     */
    public int count() {
        return super.size();
    }

    @Override
    public Appointment remove(int position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(int position, Appointment appoint) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Appointment appoint) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Appointment get(int position) {
        throw new UnsupportedOperationException();
    }

    public int indexOf(Appointment appoint) {
        throw new UnsupportedOperationException();
    }
}
