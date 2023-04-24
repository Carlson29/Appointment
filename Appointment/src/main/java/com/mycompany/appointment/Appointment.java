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

    public Appointment(String FirstName, String lastName, LocalDate dateOfBirth, String issue, LocalDate date, int triage, String doctorsName) {
         if (dateOfBirth.compareTo(LocalDate.now()) > 0 || date.compareTo(dateOfBirth)<0) {
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

    
    
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
         if (dateOfBirth.compareTo(LocalDate.now()) > 0) {
            throw new DateTimeException("The date is after current date ");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setDate(LocalDate date) {
         if (date.compareTo(dateOfBirth)<0) {
            throw new DateTimeException("");
        }
        this.date = date;
    }

    public void setTriage(int triage) {
        this.triage = triage;
    }

    public void setDoctorsName(String doctorsName) {
        this.doctorsName = doctorsName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getIssue() {
        return issue;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTriage() {
        return triage;
    }

    public String getDoctorsName() {
        return doctorsName;
    }

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

    @Override
    public String toString() {
        return "Appointment{" + "FirstName=" + FirstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", issue=" + issue + ", date=" + date + ", triage=" + triage + ", doctorsName=" + doctorsName + '}';
    }
    
    
}

