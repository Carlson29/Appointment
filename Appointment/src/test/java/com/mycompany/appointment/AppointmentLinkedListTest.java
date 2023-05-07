/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appointment;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author d00243400
 */
public class AppointmentLinkedListTest {

    public AppointmentLinkedListTest() {
    }

    /**
     * Test of Patient constructor when dateOfBith is after current date
     */
    @Test
    public void testPatientConstructor() {
        System.out.println("constructor");
        LocalDate d1 = LocalDate.of(2025, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        AppointmentLinkedList w = new AppointmentLinkedList();
        assertThrows(DateTimeException.class, () -> {
            Patient a1 = new Patient("Joshua", "Gerry", d1, d2, w);;
        });
    }

    /**
     * Test of Patient constructor when dateJoint is before dateOfBirth
     */
    @Test
    public void testPatientConstructor2() {
        System.out.println("constructor");
        LocalDate d1 = LocalDate.of(2020, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2019, Month.MAY, 1);
        AppointmentLinkedList w = new AppointmentLinkedList();
        assertThrows(DateTimeException.class, () -> {
            Patient a1 = new Patient("Joshua", "Gerry", d1, d2, w);;
        });
    }

    /**
     * Test of Appointment constructor when dateOfBith is after current date
     */
    @Test
    public void testAppointmentConstructor() {
        System.out.println("constructor");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2025, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        assertThrows(DateTimeException.class, () -> {
            Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");;
        });
    }

    /**
     * Test of Appointment constructor when date is before dateOfBirth
     */
    @Test
    public void testAppointmentConstructor2() {
        System.out.println("constructor");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2022, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2021, Month.MAY, 1);
        assertThrows(DateTimeException.class, () -> {
            Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");;
        });
    }

    /**
     * Test of isEmpty method, of class AppointmentLinkedList. when List is
     * empty
     */
    @Test
    public void testIsEmpty_whenIsEmpty() {
        System.out.println("isEmpty");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

    /**
     * Test of isEmpty method, of class AppointmentLinkedList. when List is not
     * empty
     */
    @Test
    public void testIsEmpty_whenIsNotEmpty() {
        System.out.println("isEmpty");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class AppointmentLinkedList. Adding to empty List
     */
    @Test
    public void testAdd_Appointment_AddingToEmptyList() {
        System.out.println("add");
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        boolean expResult = true;
        boolean result = instance.add(a1);
        Appointment a2 = instance.get(0);
        assertEquals(expResult, result);
        assertEquals(a1, a2);

    }

    /**
     * Test of add method, of class AppointmentLinkedList. Adding to a List that
     * has appointments
     */
    @Test
    public void testAdd_Appointment_AddingToListThatHasAppointments() {
        System.out.println("add");
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        Appointment a3 = new Appointment("Logan", "Freeman", d1, "fever", d2, 1, "paul");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        boolean expResult = true;
        instance.add(a1);
        boolean result = instance.add(a3);
        Appointment a2 = instance.get(1);
        assertEquals(expResult, result);
        assertEquals(a3, a2);

    }

    /**
     * Test of add method, of class AppointmentLinkedList.Adding to a negative
     * position
     */
    @Test
    public void testAdd_int_Appointment_AddingToNegativePosition() {
        System.out.println("add");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.add(-1, a1);
        });
    }

    /**
     * Test of add method, of class AppointmentLinkedList.Adding to a position
     * greater than size
     */
    @Test
    public void testAdd_int_Appointment_AddingToPositionGreaterThanSize() {
        System.out.println("add");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.add(instance.size() + 1, a1);
        });
    }

    /**
     * Test of add method, of class AppointmentLinkedList.Adding to a position
     * equal to size
     */
    @Test
    public void testAdd_int_Appointment_AddingToPositionEqualToSize() {
        System.out.println("add");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        Appointment a2 = new Appointment("Jacob", "lena", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.add(instance.size(), a2);
        });
    }

    /**
     * Test of add method, of class AppointmentLinkedList.Adding to a position 0
     */
    @Test
    public void testAdd_int_Appointment_AddingToPosition0() {
        System.out.println("add");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        Appointment a3 = new Appointment("Jacob", "lena", d1, "fever", d2, 1, "paul");
        boolean expResult = true;
        instance.add(0, a3);
        boolean result = instance.add(0, a1);
        Appointment a2 = instance.get(0);
        assertEquals(a1, a2);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class AppointmentLinkedList.Adding to a last
     * position
     */
    @Test
    public void testAdd_int_Appointment_AddingToLastPosition() {
        System.out.println("add");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        Appointment a2 = new Appointment("Jacob", "lena", d1, "fever", d2, 1, "paul");
        Appointment a3 = new Appointment("Walters", "joe", d1, "fever", d2, 1, "paul");
        boolean expResult = true;
        instance.add(a1);
        instance.add(a2);
        boolean result = instance.add(1, a3);
        Appointment a4 = instance.get(2);
        assertEquals(a4, a3);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class AppointmentLinkedList.Adding to the middle
     * position
     */
    @Test
    public void testAdd_int_Appointment_AddingToTheMiddle() {
        System.out.println("add");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        Appointment a2 = new Appointment("Jacob", "lena", d1, "fever", d2, 1, "paul");
        Appointment a3 = new Appointment("Walters", "joe", d1, "fever", d2, 1, "paul");
        Appointment a4 = new Appointment("Jonathan", "Bill", d1, "fever", d2, 1, "paul");
        boolean expResult = true;
        instance.add(a1);
        instance.add(a2);
        instance.add(a3);
        boolean result = instance.add(2, a4);
        Appointment a5 = instance.get(3);
        assertEquals(a5, a4);
        assertEquals(4, instance.size());
        assertEquals(expResult, result);

    }

    /**
     * Test of size method, of class AppointmentLinkedList.When is empty
     */
    @Test
    public void testSize_WhenIsEmpty() {
        System.out.println("size");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of size method, of class AppointmentLinkedList.When is not empty
     */
    @Test
    public void testSize_WhenIsNotEmpty() {
        System.out.println("size");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of indexOf method, of class AppointmentLinkedList. When is empty
     */
    @Test
    public void testIndexOf_WhenIsEmpty() {
        System.out.println("indexOf");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        int expResult = -1;
        int result = instance.indexOf(a1);
        assertEquals(expResult, result);

    }

    /**
     * Test of indexOf method, of class AppointmentLinkedList. When Not empty
     */
    @Test
    public void testIndexOf_WhenIsNotEmpty() {
        System.out.println("indexOf");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        Appointment a2 = new Appointment("Jacob", "lena", d1, "cough", d2, 1, "paul");
        Appointment a3 = new Appointment("Walters", "joe", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        instance.add(a2);
        instance.add(a3);
        int expResult = 1;
        int result = instance.indexOf(a2);
        assertEquals(expResult, result);

    }

    /**
     * Test of get method, of class AppointmentLinkedList.When the position is
     * less than 0
     */
    @Test
    public void testGet_WhenPositionIslessThan0() {
        System.out.println("get");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(-1);
        });

    }

    /**
     * Test of get method, of class AppointmentLinkedList.When the position is
     * equal to size
     */
    @Test
    public void testGet_WhenPositionIsEqualTOSize() {
        System.out.println("get");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(instance.size);
        });

    }

    /**
     * Test of get method, of class AppointmentLinkedList.When the position is
     * greater than size
     */
    @Test
    public void testGet_WhenPositionIsGreaterThanSize() {
        System.out.println("get");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(instance.size + 1);
        });

    }

    /**
     * Test of get method, of class AppointmentLinkedList. when is a valid
     * position and list is not empty
     */
    @Test
    public void testGet_WhenPositionIsvalid() {
        System.out.println("get");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        Appointment a2 = new Appointment("Jacob", "lena", d1, "cough", d2, 1, "paul");
        instance.add(a1);
        instance.add(a2);
        Appointment result = instance.get(0);
        assertEquals(a1, result);

    }

    /**
     * Test of remove method, of class AppointmentLinkedList. When parameter is
     * a negative number
     */
    @Test
    public void testRemove_intNegativePosition() {
        System.out.println("remove");
        int position = -1;
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.remove(position);
        });

    }

    /**
     * Test of remove method, of class AppointmentLinkedList. When parameter is
     * equal to size
     */
    @Test
    public void testRemove_intIsEqualToSize() {
        System.out.println("remove");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.remove(instance.size());
        });

    }

    /**
     * Test of remove method, of class AppointmentLinkedList. When parameter is
     * greater than size
     */
    @Test
    public void testRemove_intGreaterThanSize() {
        System.out.println("remove");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.remove(instance.size() + 1);
        });

    }

    /**
     * Test of remove method, of class AppointmentLinkedList. When position is
     * 0, removing the first appointment
     */
    @Test
    public void testRemove_intWhenPositionIs0() {
        System.out.println("remove");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        Appointment result = instance.remove(0);
        assertEquals(a1, result);

    }

    /**
     * Test of remove method, of class AppointmentLinkedList. Removing from the
     * middle
     */
    @Test
    public void testRemove_intRemovingFromMiddle() {
        System.out.println("remove");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        Appointment a2 = new Appointment("Jacob", "lena", d1, "cough", d2, 1, "paul");
        Appointment a3 = new Appointment("Walters", "joe", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        instance.add(a2);
        instance.add(a3);
        Appointment result = instance.remove(1);
        assertEquals(a2, result);

    }

    /**
     * Test of remove method, of class AppointmentLinkedList. Removing last
     * Appointment
     */
    @Test
    public void testRemove_intRemovingLastAppointment() {
        System.out.println("remove");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        Appointment a2 = new Appointment("Jacob", "lena", d1, "cough", d2, 1, "paul");
        Appointment a3 = new Appointment("Walters", "joe", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        instance.add(a2);
        instance.add(a3);
        Appointment result = instance.remove(instance.size() - 1);
        assertEquals(a3, result);

    }

    /**
     * Test of DeleteAppointments when is not empty
     */
    @Test
    public void testDeleteAppointments() {
        System.out.println("testDeleteAppointments");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        Appointment a2 = new Appointment("Jacob", "lena", d1, "cough", d2, 1, "paul");
        Appointment a3 = new Appointment("Walters", "joe", d1, "fever", d2, 1, "paul");
        instance.add(a1);
        instance.add(a2);
        instance.add(a3);
        boolean result = instance.deleteAppointments(a1.getFirstName(), a1.getLastName(), a1.getDateOfBirth());

        assertEquals(2, instance.size());
        assertEquals(true, result);

    }

    /**
     * Test of DeleteAppointments when is empty
     */
    @Test
    public void testDeleteAppointments2() {
        System.out.println("testDeleteAppointments");
        AppointmentLinkedList instance = new AppointmentLinkedList();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        boolean result = instance.deleteAppointments("carlson", "marco", d1);

        assertEquals(0, instance.size());
        assertEquals(false, result);

    }

}
