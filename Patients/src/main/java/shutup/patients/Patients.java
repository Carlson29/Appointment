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
//Two Patients are considered equal where they have the same first name, second name and date of birth (irrespective of the rest
//of their fields
    
//    HashMap – this should hold Patients and should employ list-based chaining or linear probing as its collision resolution. It
//must include all standard components of a HashMap structure (as outlined in class). 
    
    private String firstName;
    private String secondName;
    private Date dateOfBirth;
    private Date startDate;
    private int size;
    private Patient [] data;
    
//    1. A method called size() that takes no parameters & returns the number of Patients currently
    //stored in your Map.
    public int size(){
        return size;
    }
    
//2. A method called hashFunction() that takes one parameter, the data representing the key to be used.    
//the method should calculate the appropriate slot based on the key supplied (an int).
     public int hashFunction(String key){
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
     
     public String put(String key, Patient value){
         int slot = hashFunction(key);
         if(data[slot].)
     }
     
     
     
    private static class Patient {
        private final String key;
        private String value;

        public Patient(String key, String value) {
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
        
        public String updateValue(String newValue){
            String oldValue = value;
            this.value = newValue;
            return oldValue;
        
    }
    }    
}
