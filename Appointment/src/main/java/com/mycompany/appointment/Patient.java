/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appointment;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Patient {
    
    private String firstName;
    private String secondName;
    private LocalDate dateOfBirth;
    private LocalDate dateJoint;
    private AppointmentLinkedList appointments;

    public Patient(String firstName, String secondName, LocalDate dateOfBirth, LocalDate dateJoint, AppointmentLinkedList appointments) {
         if (dateOfBirth.compareTo(LocalDate.now()) > 0 || dateJoint.compareTo(dateOfBirth)<0 ) {
            throw new DateTimeException("");
        }
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.dateJoint = dateJoint;
        this.appointments = appointments;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
         if (dateOfBirth.compareTo(LocalDate.now()) > 0) {
            throw new DateTimeException("");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateJoint() {
        return dateJoint;
    }

    public void setDateJoint(LocalDate dateJoint) {
          if (dateJoint.compareTo(dateOfBirth)<0 ) {
            throw new DateTimeException("");
        }
        this.dateJoint = dateJoint;
    }

    public AppointmentLinkedList getAppointments() {
        return appointments;
    }

    public void setAppointments(AppointmentLinkedList appointments) {
        this.appointments = appointments;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.secondName);
        hash = 79 * hash + Objects.hashCode(this.dateOfBirth);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.secondName, other.secondName)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Patient{" + "firstName=" + firstName + ", secondName=" + secondName + ", dateOfBirth=" + dateOfBirth + ", dateJoint=" + dateJoint + ", appointments=" + appointments + '}';
    }
    
    
    
    
}
