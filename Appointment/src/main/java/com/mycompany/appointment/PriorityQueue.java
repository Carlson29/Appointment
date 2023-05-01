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
            Node current = super.first;
            for (int i = 0; i < super.size() - 1; i++) {
                if (current.data.getTriage() <= appoint.getTriage()) {

                    return super.add(i + 1, appoint);
                }
            }
        }
        return false;
    }

    public Appointment dequeue() {
        return super.remove(0);
    }

    public Appointment peek() {
        return super.get(0);
    }

    public int count() {
        return super.size();
    }

    @Override
    public Appointment remove(int position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Appointment appoint) {
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
}
