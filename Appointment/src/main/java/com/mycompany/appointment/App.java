/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appointment;

import com.mycompany.appointment.AppointmentLinkedList.Node;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author d00243400
 */
public class App {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner pk = new Scanner(System.in);
        PatientsHashMap patients = new PatientsHashMap();
        PriorityQueue queue = new PriorityQueue();
        AppointmentLinkedList appointments = new AppointmentLinkedList();

        try {
            File appoints = new File("appointments.txt");
            if (appoints.exists()) {
                Scanner fc = new Scanner(appoints);
                while (fc.hasNextLine()) {
                    String[] ap = fc.nextLine().split(",");
                    if (ap.length == 11) {
                        try {
                            LocalDate d3 = LocalDate.of(Integer.parseInt(ap[2]), Integer.parseInt(ap[3]), Integer.parseInt(ap[4]));
                            LocalDate d4 = LocalDate.of(Integer.parseInt(ap[6]), Integer.parseInt(ap[7]), Integer.parseInt(ap[8]));

                            Appointment line = new Appointment(ap[0], ap[1], d3, ap[5], d4, Integer.parseInt(ap[9]), ap[10]);
                            appointments.add(line);

                        } catch (NumberFormatException | DateTimeException ex) {

                        }
                    }
                }
                System.out.println("Appointments have been read from appointments.txt ");
            } else {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry Appointments file not found");
        }

        try {
            File f = new File("patients.txt");
            if (f.exists()) {
                Scanner sc = new Scanner(f);
                while (sc.hasNextLine()) {
                    String[] line = sc.nextLine().split(",");
                    if (line.length == 8) {
                        try {

                            LocalDate d1 = LocalDate.of(Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                            LocalDate d2 = LocalDate.of(Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]));

                            AppointmentLinkedList list = new AppointmentLinkedList();
                            for (int i = 0; i < appointments.size(); i++) {
                                Appointment current = appointments.get(i);
                                if (line[0].equalsIgnoreCase(current.getFirstName()) && line[1].equalsIgnoreCase(current.getLastName()) && d1.equals(current.getDateOfBirth())) {

                                    list.add(current);

                                }
                            }
                            try {
                                Patient p = new Patient(line[0], line[1], d1, d2, list);
                                String details = generateKey(p.getFirstName(), p.getSecondName(), p.getDateOfBirth());
                                patients.put(details, p);

                            } catch (DateTimeException ex) {

                            }
                        } catch (NumberFormatException ex) {

                        }

                    }

                }
                System.out.println("Patients have been read from patients.txt");
            } else {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry Patients file not found");
        }

        String[] options = {"0. Add a new patient ", "1. Delete a Patient ", "2. Display All patients ", "3. Create an Appointment for a specific Patient", "4. Next Patient ", "5. Exit"};
        Boolean state = false;
        while (state == false) {
            int choice = Menu(options);
            try {
                if (choice == 0) {

                    Patient p = patientDetails();
                    String key = generateKey(p.getFirstName(), p.getSecondName(), p.getDateOfBirth());
                    if (patients.containsKey(key) == true) {
                        System.out.println("Patient should not be added");
                    } else {

                        patients.put(key, p);
                        System.out.println("Patient added");
                    }

                }
                if (choice == 1) {
                    Patient p = patientDetails();
                    String key = generateKey(p.getFirstName(), p.getSecondName(), p.getDateOfBirth());
                    if (patients.containsKey(key) == true) {
                        patients.remove(key);
                        appointments.deleteAppointments(p.getFirstName(), p.getSecondName(), p.getDateOfBirth());
                        System.out.println("Patient deleted");
                    }

                }
                if (choice == 2) {
                    Patient[] patient = patients.getValues();
                    for (int i = 0; i < patient.length; i++) {
                        System.out.println(patient[i]);
                         if (patient[i].getAppointments().size() > 0) {
                           System.out.println("Appointments ");
                            Node current = patient[i].getAppointments().first;
                            for (int j = 0; j < patient[i].getAppointments().size; j++) {

                                if (current.data != null) {
                                    System.out.println(current.data.toString());
                                }
                                current = current.next;

                            }
                        }
                    }
                }
                if (choice == 3) {
                    System.out.println("Enter Patient FirstName");
                    String firstName = pk.nextLine();
                    pk.nextLine();
                    System.out.println("Enter Patient secondName");
                    String secondName = pk.nextLine();
                    System.out.println("Enter year of birth");
                    int year = pk.nextInt();
                    System.out.println("Enter day of birth(number)");
                    int day = pk.nextInt();
                    System.out.println("Enter month of birth(number)");
                    int month = pk.nextInt();

                    LocalDate dateOfBirth = LocalDate.of(year, month, day);
                    String key = generateKey(firstName, secondName, dateOfBirth);
                    if (patients.containsKey(key) == true) {
                        System.out.println("Enter Appointment year ");
                        int appointmentYear = pk.nextInt();
                        System.out.println("Enter Appointment day (number)");
                        int appointmentDay = pk.nextInt();
                        System.out.println("Enter Appointment month (number)");
                        int appointmentMonth = pk.nextInt();
                        LocalDate appointmentDate = LocalDate.of(appointmentYear, appointmentMonth, appointmentDay);
                        pk.nextLine();
                        System.out.println("Enter issue");
                        String issue = pk.nextLine();
                        System.out.println("Enter your Doctors Name");
                        String doctor = pk.nextLine();
                        Random rg = new Random();
                        int triage = rg.nextInt(6);
                        Appointment ap1 = new Appointment(firstName, secondName, dateOfBirth, issue, appointmentDate, triage, doctor);

                        Patient p1 = patients.get(key);
                        p1.getAppointments().add(ap1);
                        queue.enqueue(ap1);
                        System.out.println("Appointment added ");

                    } else {
                        System.out.println("Sorry No patient has does deatils in our System");
                    }

                }

                if (choice == 4) {
                    Appointment remove = queue.dequeue();
                    if (remove != null) {
                        System.out.println("Next appointment is " + remove.toString());
                    } else {
                        System.out.println("Sorry no patients available in the Queue at the moment");
                    }

                }
                if (choice == 5) {
                    File f = new File("Patients2.txt");
                    PrintStream output = new PrintStream(f);
                    Patient[] vals = patients.getValues();
                    for (int i = 0; i < vals.length; i++) {
                        output.println(vals[i].toString());
                        if (vals[i].getAppointments().size() > 0) {
                            output.println("Appointments ");
                            Node current = vals[i].getAppointments().first;
                            for (int j = 0; j < vals[i].getAppointments().size; j++) {

                                if (current.data != null) {
                                    output.println(current.data.toString());
                                }
                                current = current.next;

                            }
                        }
                        output.println();
                    }
                    output.close();

                    File f1 = new File("Appointment2.txt");
                    PrintStream output1 = new PrintStream(f1);
                    if (appointments != null) {
                        Node current = appointments.first;
                        for (int i = 0; i < appointments.size(); i++) {
                            output1.println(current.data.toString());
                            output.println();
                            current = current.next;
                        }
                    }
                    output1.close();
                    System.out.println("Patients have been written to Patients2.txt ");
                    System.out.println("Appointments have been written to Appointment2.txt");
                    System.out.println("********Exit********");
                    state = true;
                }

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input Entered");

            } catch (DateTimeException ex) {
                System.out.println("You entered an invalid date");
            }

        }
    }

    public static int Menu(String[] ops) {
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        for (String val : ops) {
            System.out.println(val);
        }
        System.out.println("Enter valid option");
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
            if (choice < ops.length && choice >= 0) {
                return choice;
            } else {
                sc.nextLine();
                choice = Menu(ops);
            }
        } else {
            sc.nextLine();
            choice = Menu(ops);
        }
        return choice;
    }

    public static String generateKey(String firstName, String lastName, LocalDate dateOfBirth) {
        return firstName + lastName + dateOfBirth.getDayOfYear() + dateOfBirth.getMonth() + dateOfBirth.getDayOfMonth();

    }

    public static Patient patientDetails() {
        Scanner pk = new Scanner(System.in);
        System.out.println("Enter Patient FirstName");
        String firstName = pk.nextLine();
        pk.nextLine();
        System.out.println("Enter Patient secondName");
        String secondName = pk.nextLine();
        System.out.println("Enter year of birth");
        int year = pk.nextInt();
        System.out.println("Enter day of birth(number)");
        int day = pk.nextInt();
        System.out.println("Enter month of birth(number)");
        int month = pk.nextInt();

        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        System.out.println("Enter year Joint");
        int yearJoint = pk.nextInt();
        System.out.println("Enter day Joint (number)");
        int dayJoint = pk.nextInt();
        System.out.println("Enter month Joint (number)");
        int monthJoint = pk.nextInt();
        LocalDate dateOfJoint = LocalDate.of(yearJoint, monthJoint, dayJoint);
        AppointmentLinkedList l = new AppointmentLinkedList();
        Patient newP = new Patient(firstName, secondName, dateOfBirth, dateOfJoint, l);
        return newP;
    }
}
