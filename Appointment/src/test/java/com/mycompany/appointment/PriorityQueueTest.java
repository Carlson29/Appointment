/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appointment;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class PriorityQueueTest {

    public PriorityQueueTest() {
    }

    /**
     * Test of enqueue method, of class PriorityQueue.When queue is Empty
     */
    @Test
    public void testEnqueue_WhenIsEmpty() {
        System.out.println("enqueue");
        PriorityQueue instance = new PriorityQueue();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        boolean expResult = true;
        boolean result = instance.enqueue(a1);
        assertEquals(1, instance.count());
        assertEquals(expResult, result);

    }

    /**
     * Test of enqueue method, of class PriorityQueue.When adding in first
     * position
     */
    @Test
    public void testEnqueue_AddingInFirstPosition() {
        System.out.println("enqueue");
        PriorityQueue instance = new PriorityQueue();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "paul");
        Appointment a2 = new Appointment("Logan", "Freeman", d1, "fever", d2, 2, "paul");
        boolean expResult = true;
        instance.enqueue(a2);
        boolean result = instance.enqueue(a1);
        Appointment a3 = instance.dequeue();
        assertEquals(a3, a1);
        assertEquals(expResult, result);

    }

    /**
     * Test of enqueue method, of class PriorityQueue.When adding in last
     * position and last appointment's triage is less than appointment to be
     * added
     */
    @Test
    public void testEnqueue_AddingInLastPosition1() {
        System.out.println("enqueue");
        PriorityQueue instance = new PriorityQueue();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "Carlson");
        Appointment a2 = new Appointment("Logan", "Freeman", d1, "fever", d2, 2, "Carlson");
        Appointment a3 = new Appointment("Jacob", "lena", d1, "fever", d2, 3, "paul");
        Appointment a4 = new Appointment("Walters", "joe", d1, "fever", d2, 4, "paul");
        boolean expResult = true;
        instance.enqueue(a1);
        instance.enqueue(a2);
        instance.enqueue(a3);
        boolean result = instance.enqueue(a4);
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();
        Appointment a5 = instance.dequeue();
        assertEquals(a5, a4);
        assertEquals(expResult, result);

    }

    /**
     * Test of enqueue method, of class PriorityQueue.When adding in last
     * position and last appointment's triage is equal to appointment to be
     * added
     */
    @Test
    public void testEnqueue_AddingInLastPosition2() {
        System.out.println("enqueue");
        PriorityQueue instance = new PriorityQueue();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "Dr Carlson");
        Appointment a2 = new Appointment("Logan", "Freeman", d1, "fever", d2, 2, "Dr Carlson");
        Appointment a3 = new Appointment("Jacob", "lena", d1, "fever", d2, 3, "paul");
        Appointment a4 = new Appointment("Walters", "joe", d1, "fever", d2, 3, "paul");
        boolean expResult = true;
        instance.enqueue(a1);
        instance.enqueue(a2);
        instance.enqueue(a3);
        boolean result = instance.enqueue(a4);
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();
        Appointment a5 = instance.dequeue();
        assertEquals(a5, a4);
        assertEquals(expResult, result);

    }

    /**
     * Test of enqueue method, of class PriorityQueue.When adding in the middle
     * of the queue
     */
    @Test
    public void testEnqueue_AddingInTheMiddle() {
        System.out.println("enqueue");
        PriorityQueue instance = new PriorityQueue();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "Dr Carlson");
        Appointment a2 = new Appointment("Logan", "Freeman", d1, "fever", d2, 2, "Dr Carlson");
        Appointment a3 = new Appointment("Jacob", "lena", d1, "fever", d2, 4, "paul");
        Appointment a4 = new Appointment("Walters", "joe", d1, "fever", d2, 3, "paul");
        boolean expResult = true;
        instance.enqueue(a1);
        instance.enqueue(a2);
        instance.enqueue(a3);
        boolean result = instance.enqueue(a4);
        instance.dequeue();
        instance.dequeue();
        Appointment a5 = instance.dequeue();
        assertEquals(a5, a4);
        assertEquals(expResult, result);

    }

    /**
     * Test of dequeue method, of class PriorityQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        PriorityQueue instance = new PriorityQueue();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "Dr Carlson");
        Appointment a2 = new Appointment("Logan", "Freeman", d1, "fever", d2, 2, "Dr Carlson");
        instance.enqueue(a1);
        instance.enqueue(a2);
        //  Appointment expResult = a1;
        Appointment result = instance.dequeue();
        assertEquals(a1, result);

    }

    /**
     * Test of remove method, of class PriorityQueue.When is empty
     */
    @Test
    public void testRemove_0args() throws Exception {
        System.out.println("remove");
        PriorityQueue instance = new PriorityQueue();
        assertThrows(NoSuchElementException.class, () -> {
            instance.remove();;
        });

    }

    /**
     * Test of remove method, of class PriorityQueue.When is Not empty
     */
    @Test
    public void testRemove_0args_WhenNotEmpty() throws Exception {
        System.out.println("remove");
        PriorityQueue instance = new PriorityQueue();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "Dr Carlson");
        Appointment a2 = new Appointment("Logan", "Freeman", d1, "fever", d2, 2, "Dr Carlson");
        instance.enqueue(a1);
        instance.enqueue(a2);
        Appointment expResult = a1;
        Appointment result = instance.remove();
        assertEquals(expResult, result);

    }

    /**
     * Test of peek method, of class PriorityQueue.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        PriorityQueue instance = new PriorityQueue();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "Dr Carlson");
        Appointment a2 = new Appointment("Logan", "Freeman", d1, "fever", d2, 2, "Dr Carlson");
        instance.enqueue(a1);
        instance.enqueue(a2);
        Appointment expResult = a1;
        Appointment result = instance.peek();
        assertEquals(expResult, result);
        assertEquals(instance.count(), 2);

    }

    /**
     * Test of Element method, of class PriorityQueue. When is empty
     */
    @Test
    public void testElement_WhenIsEmpty() throws Exception {
        System.out.println("Element");
        PriorityQueue instance = new PriorityQueue();
        assertThrows(NoSuchElementException.class, () -> {
            instance.Element();
        });

    }

    /**
     * Test of Element method, of class PriorityQueue. When is not empty
     */
    @Test
    public void testElement_NotEmpty() throws Exception {
        System.out.println("Element");
        PriorityQueue instance = new PriorityQueue();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "Dr Carlson");
        Appointment a2 = new Appointment("Logan", "Freeman", d1, "fever", d2, 2, "Dr Carlson");
        instance.enqueue(a1);
        instance.enqueue(a2);
        Appointment result = instance.Element();
        assertEquals(a1, result);

    }

    /**
     * Test of count method, of class PriorityQueue.When is empty
     */
    @Test
    public void testCount_WhenIsEmpty() {
        System.out.println("count");
        PriorityQueue instance = new PriorityQueue();
        int expResult = 0;
        int result = instance.count();

    }

    /**
     * Test of count method, of class PriorityQueue. When is not empty
     */
    @Test
    public void testCount_NotEmpty() {
        System.out.println("count");
        PriorityQueue instance = new PriorityQueue();
        LocalDate d1 = LocalDate.of(2005, Month.MAY, 1);
        LocalDate d2 = LocalDate.of(2023, Month.MAY, 1);
        Appointment a1 = new Appointment("Joshua", "Gerry", d1, "fever", d2, 1, "Dr Carlson");
        Appointment a2 = new Appointment("Logan", "Freeman", d1, "fever", d2, 2, "Dr Carlson");
        instance.enqueue(a1);
        instance.enqueue(a2);
        int expResult = 2;
        int result = instance.count();
        assertEquals(expResult, result);

    }

    /**
     * Test of remove method, of class PriorityQueue.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int position = 0;
        PriorityQueue instance = new PriorityQueue();
        assertThrows(UnsupportedOperationException.class, () -> {
            instance.remove(position);
        });
    }

    /**
     * Test of add method, of class PriorityQueue.
     */
    @Test
    public void testAdd_int_Appointment() {
        System.out.println("add");
        int position = 0;
        Appointment appoint = null;
        PriorityQueue instance = new PriorityQueue();
        assertThrows(UnsupportedOperationException.class, () -> {
            instance.add(position, appoint);
        });
    }

    /**
     * Test of add method, of class PriorityQueue.
     */
    @Test
    public void testAdd_Appointment() {
        System.out.println("add");
        Appointment appoint = null;
        PriorityQueue instance = new PriorityQueue();
        assertThrows(UnsupportedOperationException.class, () -> {
            instance.add(appoint);
        });
    }

    /**
     * Test of size method, of class PriorityQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        PriorityQueue instance = new PriorityQueue();
        assertThrows(UnsupportedOperationException.class, () -> {
            instance.size();
        });
    }

    /**
     * Test of get method, of class PriorityQueue.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int position = 0;
        PriorityQueue instance = new PriorityQueue();
        assertThrows(UnsupportedOperationException.class, () -> {
            instance.get(position);
        });
    }

    /**
     * Test of indexOf method, of class PriorityQueue.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Appointment appoint = null;
        PriorityQueue instance = new PriorityQueue();
        assertThrows(UnsupportedOperationException.class, () -> {
            instance.indexOf(appoint);
        });
    }

}
