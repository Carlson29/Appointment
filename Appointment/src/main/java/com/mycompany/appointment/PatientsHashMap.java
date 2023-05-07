/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.appointment;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Frist
 */
public class PatientsHashMap {

//   Patient
//Patients are made up of the following information:
//• The first name of the Patient (a String)
//• The second name of the Patient (a String)
//• The date of birth of the Patient (a LocalDate)
//• The date they joined the practice (a LocalDate)
//• The appointments associated with the Patient (an Appointment LinkedList).
//Two Appointment are considered equal where they have the same first name, second name and date of birth (irrespective of the rest
//of their fields
//    HashMap – this should hold Appointment and should employ list-based chaining or linear probing as its collision resolution. It
//must include all standard components of a HashMap structure (as outlined in class). 
    private int size;
    private LinkedList<Entry>[] data;
    private static final int DEFAULT_CAPACITY = 103;

    public int getSize() {
        return size;
    }

    public LinkedList<Entry>[] getData() {
        return data;
    }

    public static int getDEFAULT_CAPACITY() {
        return DEFAULT_CAPACITY;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setData(LinkedList<Entry>[] data) {
        this.data = data;
    }

    public PatientsHashMap() {
        data = new LinkedList[DEFAULT_CAPACITY];
    }

    public PatientsHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Map capacity cannot be less than 1");
        }
        data = new LinkedList[capacity];
    }

    /**
     *
     * Returns the number of elements in the hashmap
     *
     * @return the number of elements in the hashmap
     */
    public int size() {
        return size;
    }
    
    public LinkedList<Entry>[] getData() {
        return data;
    }

    /**
     *
     * Returns the hash code value for the given key which determines the slot
     * in the hash table where the key-value pair will be stored
     *
     * @param key the key for which to calculate the hash code
     * @return the hash code value for the given key
     */
    public int hashFunction(String key) {
        int slot = key.hashCode();
        slot = Math.abs(slot);
        slot = slot % data.length;
        return slot;

    }

    /**
     *
     * places the parameter into the hashmap
     *
     * @param key the key with which to associate the specified value
     *
     * @param value the value to be associated with the specified key
     *
     * @return the previous value associated with the specified key, or null if
     * there was no mapping for the key
     *
     * @throws IllegalArgumentException if either the key or value is null
     */
    public Patient put(String key, Patient value) {
        int slot = hashFunction(key);
        if (key == null || value == null) {
            throw new IllegalArgumentException("Null fields not permitted");
        }

        if (data[slot] == null) {
            data[slot] = new LinkedList();
            Entry newPatient = new Entry(key, value);
            data[slot].add(newPatient);
            size++;
            return null;
        } else {
            for (Entry e : data[slot]) {

                if (e.key.equals(key)) {
                    Patient updateOldValue = e.updateValue(value);
                    return updateOldValue;

                }

            }
            Entry newEntry = new Entry(key, value);
            data[slot].add(newEntry);
            size++;
            return null;
        }
    }

    /**
     * returns the patient given the key
     *
     * @param key
     * @return the patient given the key.
     */
    public Patient get(String key) {
        int slot = hashFunction(key);
        if (data[slot] != null) {
            for (Entry e : data[slot]) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * removes the patient given the key in the hashmap
     *
     * @param key
     * @return the value of the removed entry, or null if no entry with the
     * given key is found
     * @throws NullPointerException if the key is null
     */
    public Patient remove(String key) {
        Patient remove;
        int slot = hashFunction(key);
        if (data[slot] != null) {

            Entry current = data[slot].getFirst();
            for (int i = 0; i < data[slot].size() - 1; i++) {

                if (current.getKey().equals(key)) {

                    remove = data[slot].remove(i).value;

                    size--;
                    return remove;
                }
                current = data[slot].get(i + 1);
            }
            if (current.getKey().equals(key)) {

                remove = data[slot].remove(data[slot].size() - 1).value;

                size--;
                return remove;
            }

            return null;

        } else {
            return null;
        }

    }

    /**
     * checks to see if map contains the given key
     *
     * @param key
     * @return true if it does false if not
     */
    public boolean containsKey(String key) {
        int slot = hashFunction(key);
        if (data[slot] != null) {

            for (Entry entry : data[slot]) {
                if (entry.getKey().equalsIgnoreCase(key)) {
                    return true;
                }

            }
            return false;

        } else {
            return false;
        }

    }

    /**
     * gets all the keys in the map
     *
     * @return all the keys in the map
     */
    public String[] getKeys() {

        String[] keys = new String[size];
        int count = 0;
        for (LinkedList<Entry> entry : data) {
            if (entry != null) {
                for (Entry e : entry) {
                    keys[count] = e.getKey();
                    count++;
                }
            }
        }
        return keys;

    }

    /**
     * gets all the values from the hashmap
     *
     * @return all the values from the hashmap
     */
    public Patient[] getValues() {

        Patient[] values = new Patient[size];
        int count = 0;
        for (LinkedList<Entry> entry : data) {
            if (entry != null) {
                for (Entry e : entry) {
                    values[count] = e.getValue();
                    count++;
                }
            }
        }
        return values;

    }

    /**
     * Increases the capacity of the hash table by doubling its size if the load
     * factor exceeds 0.75. This method rehashes all the key-value pairs in the
     * existing table and redistributes them in the new table using a new hash
     * function.
     */
    public void grow() {
        int currentCapacity = data.length;
        if ((size * 1.0) / currentCapacity >= 0.75) {
            int newCapacity = currentCapacity * 2;
            LinkedList<Entry>[] newData = new LinkedList[newCapacity];
            for (int i = 0; i < currentCapacity; i++) {
                if (data[i] != null) {
                    for (Entry e : data[i]) {
                        int newSlot = hashFunction(e.getKey());
                        if (newData[newSlot] == null) {
                            newData[newSlot] = new LinkedList<>();
                        }
                        newData[newSlot].add(e);
                    }
                }
            }
            data = newData;
        }
    }

    private static class Entry {

        private final String key;
        private Patient value;

        public Entry(String key, Patient value) {
            this.key = key;
            this.value = value;
        }

        /**
         *
         * Returns the key associated with this Entry object.
         *
         * @return the key associated with this Entry object
         */
        public String getKey() {
            return key;
        }

        /**
         *
         * Returns the value associated with this Entry object.
         *
         * @return the value associated with this Entry object
         */
        public Patient getValue() {
            return value;
        }

        /**
         *
         * Sets the value associated with this Entry object to the specified
         * value.
         *
         * @param value the new value to associate with this Entry object
         */
        public void setValue(Patient value) {
            this.value = value;
        }

        /**
         *
         * Replaces the value associated with this Entry object with the
         * specified new value and returns the old value.
         *
         * @param newValue the new value to associate with this Entry object
         * @return the old value previously associated with this Entry object
         */
        public Patient updateValue(Patient newValue) {
            Patient oldValue = value;
            this.value = newValue;
            return oldValue;
        }
    }
}
