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

    public PatientsHashMap() {
        data = new LinkedList[DEFAULT_CAPACITY];
    }

    public PatientsHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Map capacity cannot be less than 1");
        }
        data = new LinkedList[capacity];
    }

//    1. A method called size() that takes no parameters & returns the number of Appointment currently
    //stored in your Map.
    public int size() {
        return size;
    }
    
    public LinkedList<Entry>[] getData() {
        return data;
    }

//2. A method called hashFunction() that takes one parameter, the data representing the key to be used.    
//the method should calculate the appropriate slot based on the key supplied (an int).
    public int hashFunction(String key) {
        int slot = key.hashCode();
        slot = Math.abs(slot);
        slot = slot % data.length;
        return slot;

    }

//3. A method called put() that takes two parameters, the data representing the key of the new entry and a Patient
//representing the value of the new entry. The method should add the new pairing to the map in an appropriate
//location. If the key is already present, the method should update the associated value and return the old
//version. If the key is not already present in the map, the situation should be handled appropriately.
//     String put parameters key and patient, patient represents value
//	int slot to add equals hashFunction key
//	ifdata [slot] is empty
//		create new entry with key and patient
//		increase size
//	if the key is already present
//		update data[slot]  with patient  
//		and return that as the old value
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

//        4. A method called get() that takes a single parameter, the key mapping to the value to be retrieved.
//The method should return a Patient - the value associated with the supplied key. If no such key is found in the
//map, an appropriate value should be returned to indicate this
//	
//	
//	
//get() paremeter is key
//	slot is hashcode of key
//	if the slot is not empty 
//		return the value of the key in that slot
//	if the slot is empty
//	return nothing
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

//   5. A method called remove() that takes one parameter – the key of the pairing to be removed.
//The method should return the value that has been removed. If no such key is found in the map, an appropriate
//value should be returned to indicate this.
//
//remove () parameter is key
//	int slot that is the hashcode of key
//		if the slot is not empty
//			return the value then remove
//		if the slot is empty
//			return null
    public Patient remove(String key) {
        Patient remove;
        int slot = hashFunction(key);
        if (data[slot] != null) {

            Entry current = data[slot].getFirst();
            for (int i = 0; i < data[slot].size()-1; i++) {

                if (current.getKey().equals(key)) {

                    remove = data[slot].remove(i).value;

                    size--;
                    return remove;
                }
                current = data[slot].get(i + 1);
            }
             if (current.getKey().equals(key)) {

                    remove = data[slot].remove(data[slot].size()-1).value;

                    size--;
                    return remove;
                }

            return null;

        } else {
            return null;
        }

    }
//    6.
//A method called containsKey() that takes one parameter – the key whose presence is being confirmed. This
//should return a boolean indicating whether or not this key currently exists within the map.
//	
//boolean contains key() takes in key as paramter
//	slot equals the hashfucntion of the key	
//	current equals the slot in the map
//		while the current is not empty
//			if the key of current is equals to the key	
//				return true
//			if not 	
//				get next current
//				return false

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
//    7. A method called getKeys() that takes no parameters.
//This method should return an array containing all of the keys currently stored within the map
//
//String []getkeys()
//	new array keys
//	slot equals hashfunction of key
//	for slot in map 	
//	current = slot
//		while current is not null
//	keys add (current.key)
//	current equals current.next
//return keys
//

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
//8.
//String[] getvalues()
//	values equals new array
//	for slot in map		
//	current equals slot
//		while current is not null
//	values.add (current.value)
//	curreent = next current
//return the values
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

    private static class Entry {

        private final String key;
        private Patient value;

        public Entry(String key, Patient value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Patient getValue() {
            return value;
        }

        public void setValue(Patient value) {
            this.value = value;
        }

        public Patient updateValue(Patient newValue) {
            Patient oldValue = value;
            this.value = newValue;
            return oldValue;

        }
    }
}
