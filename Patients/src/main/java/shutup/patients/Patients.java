/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package shutup.patients;

import java.util.Date;

/**
 *
 * @author Frist
 */
public class Patients {

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
    private String firstName;
    private String secondName;
    private Date dateOfBirth;
    private Date startDate;
    private int size;
    private Appointments[] data;

//    1. A method called size() that takes no parameters & returns the number of Appointment currently
    //stored in your Map.
    public int size() {
        return size;
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
    private Appointments[] growMap() {
        Appointments[] newMap = new Appointments[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            String key = data[i].key;
            int slot = hashFunction(key);
            if (newMap[slot] != null) {
                throw new MapFullException("Cannot complete resize operation");
            }
            newMap[slot] = data[i];
        }
        return newMap;
    }

    public String put(String key, String value) {
        int slot = hashFunction(key);
        if (key == null || value == null) {
            throw new IllegalArgumentException("Null fields not permitted");
        }
        if (size == data.length) {
            data = growMap();
        }
        if (data[slot] == null) {
            Appointments newPatient = new Appointments(key, value);
            data[slot] = newPatient;
            size++;
            return null;
        } else {

            if (data[slot].key.equals(key)) {
                String updateOldValue = data[slot].updateValue(value);
                return updateOldValue;

            } else {
                throw new SlotOccupiedException("Provided key maps to occupied slot in map.");
            }

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




public String get(String key){
    int slot = hashFunction(key);
    if(data[slot] != null){
        return data[slot].value;
    }
    else{
        return null;
    }
    
}
 
        
        
        
        
    

    private static class Appointments {

        private final String key;
        private String value;

        public Appointments(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String updateValue(String newValue) {
            String oldValue = value;
            this.value = newValue;
            return oldValue;

        }
    }
}
