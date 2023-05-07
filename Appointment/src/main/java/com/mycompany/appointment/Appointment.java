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
public class Appointment {

    private String FirstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String issue;
    private LocalDate date;
    private int triage;
    private String doctorsName;

    /**
     * Constructor for Appointment class
     *
     * @param FirstName, String
     * @param lastName,String
     * @param dateOfBirth,LocalDate
     * @param issue,String
     * @param date,LocalDate
     * @param triage,int
     * @param doctorsName,String
     * @throws DateTimeException, if dateOfBirth is after today or if date is
     * before dateOfBirth
     *
     */
    public Appointment(String FirstName, String lastName, LocalDate dateOfBirth, String issue, LocalDate date, int triage, String doctorsName) {
        if (dateOfBirth.compareTo(LocalDate.now()) > 0 || date.compareTo(dateOfBirth) < 0) {
            throw new DateTimeException("");
        }
        this.FirstName = FirstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.issue = issue;
        this.date = date;
        this.triage = triage;
        this.doctorsName = doctorsName;
    }

    /**
     * Sets a firstName to a Patient
     *
     * @param FirstName, takes a in a String as a parameter
     *
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * Sets lastName
     *
     * @param lastName
     *
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
            throw new DateTimeException("The date is after current date ");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * Sets a Patient's DateOfBirth
     *
     * @param date
     * @throws DateTimeException if date is before dateOfBirth
     *
     */
    public void setDate(LocalDate date) {
        if (date.compareTo(dateOfBirth) < 0) {
            throw new DateTimeException("");
        }
        this.date = date;
    }

    /**
     * Sets triage
     *
     * @param triage
     *
     */
    public void setTriage(int triage) {
        this.triage = triage;
    }

    /**
     * Sets doctor's name
     *
     * @param doctorsName
     */
    public void setDoctorsName(String doctorsName) {
        this.doctorsName = doctorsName;
    }

    /**
     * Gets a patient's firsName
     *
     * @return String, returns a string
     *
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * Returns a Patients lastName
     *
     * @return String
     *
     */
    public String getLastName() {
        return lastName;
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
     * Gets issue
     *
     * @return String
     *
     */
    public String getIssue() {
        return issue;
    }

    /**
     * Gets date
     *
     * @return LocalDate
     *
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets Patient's triage
     *
     * @return int
     *
     */
    public int getTriage() {
        return triage;
    }

    /**
     * Gets Doctor's Name
     *
     * @return String
     *
     */
    public String getDoctorsName() {
        return doctorsName;
    }

    /**
     * Gets appointment hashCode*
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.FirstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 29 * hash + Objects.hashCode(this.issue);
        hash = 29 * hash + Objects.hashCode(this.date);
        return hash;
    }

    /**
     * checks if 2 appointments are equal, returns true if they have same
     * fisrtName,lastName,dateOfBirth,issue, and date if otherwise it returns
     * false
     *
     * @return Boolean
     * @
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
        final Appointment other = (Appointment) obj;
        if (!Objects.equals(this.FirstName, other.FirstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.issue, other.issue)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    /**
     * Returns an appointment details,
     *
     * @return String
     *
     */
    @Override
    public String toString() {
        return "Appointment{" + "FirstName=" + FirstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", issue=" + issue + ", date=" + date + ", triage=" + triage + ", doctorsName=" + doctorsName + '}';
    }

}
