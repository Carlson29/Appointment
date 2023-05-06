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
        if (dateOfBirth.compareTo(LocalDate.now()) > 0 || dateJoint.compareTo(dateOfBirth) < 0) {
            throw new DateTimeException("");
        }
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.dateJoint = dateJoint;
        this.appointments = appointments;
    }

    /**
     * Gets a patient's firsName
     *
     * @return String, returns a string
     *
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets a firstName to a Patient
     *
     * @param firstName, takes a in a String as a parameter
     *
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns a Patients secondName
     *
     * @return String
     *
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Sets a secondName to a Patient
     *
     * @param secondName
     *
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * Gets a Patient's DateOfBirth
     *
     * @return String
     *
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets a Patient's DateOfBirth
     *
     * @param dateOfBirth
     * @throws DateTimeException if date is after today
     *
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.compareTo(LocalDate.now()) > 0) {
            throw new DateTimeException("");
        }
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets dateJoint
     *
     * @return LocalDate
     *
     */
    public LocalDate getDateJoint() {
        return dateJoint;
    }

    /**
     * Sets the dateJoint
     *
     * @param dateJoint
     * @throws DateTimeException if date is before dateOfBirth
     *
     */
    public void setDateJoint(LocalDate dateJoint) {
        if (dateJoint.compareTo(dateOfBirth) < 0) {
            throw new DateTimeException("");
        }
        this.dateJoint = dateJoint;
    }

    /**
     * Gets the Patient's appointments
     *
     * @return AppointmentLinkedList
 *
     */
    public AppointmentLinkedList getAppointments() {
        return appointments;
    }

    /**
     * Set a patient's Appointments
     *
     * @param appointments
 *
     */
    public void setAppointments(AppointmentLinkedList appointments) {
        this.appointments = appointments;
    }

    /**
     * Generates hashCode*
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.secondName);
        hash = 79 * hash + Objects.hashCode(this.dateOfBirth);
        return hash;
    }

    /**
     * Checks if 2 patients are equal, returns true if they have the same
     * firstName,secondName, and dateJoint returns false otherwise
     *
     * @return Boolean
*
     */
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

    /**
     * Returns all a Patients details
     *
     * @return String
 *
     */
    @Override
    public String toString() {
        return "Patient{" + "firstName=" + firstName + ", secondName=" + secondName + ", dateOfBirth=" + dateOfBirth + ", dateJoint=" + dateJoint + ", appointments=" + appointments + '}';
    }

}
