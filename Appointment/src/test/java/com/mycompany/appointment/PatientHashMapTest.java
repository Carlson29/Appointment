/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.appointment;

import java.time.LocalDate;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Frist
 */
public class PatientHashMapTest {

    HashMap<String, Patient> map = new HashMap<>();
   
    Patient patient1 = new Patient();

   
/**

Unit tests for the size() method of the PatientsHashMap class.
*/
    @Test
    public void testSize() {
       
        Assertions.assertEquals(0, map.size());

        map.put("john", patient1);
        Assertions.assertEquals(1, map.size());

        map.remove("john");
        Assertions.assertEquals(0, map.size());
    
       
    }
    /**

Unit tests for the hashFunction() method of the PatientsHashMap class.
*/
@Test
void testHashFunction() {
    PatientsHashMap map = new PatientsHashMap();
    String key1 = "john";
    int expectedSlot1 = Math.abs(key1.hashCode()) % map.getData().length;
    assertEquals(expectedSlot1, map.hashFunction(key1));
    
    String key2 = "jeff";
    int expectedSlot2 = Math.abs(key2.hashCode()) % map.getData().length;
    assertEquals(expectedSlot2, map.hashFunction(key2));
    
    // test for null key
    assertThrows(NullPointerException.class, () -> map.hashFunction(null));
}

/**
 * unit tests for the put() method of the PatientHashMap class.
 */
@Test
void testPut() {
PatientsHashMap map = new PatientsHashMap();
Patient patient1 = new Patient();
Patient patient2 = new Patient();

// add a new entry
assertNull(map.put("john", patient1));
assertEquals(1, map.size());
assertEquals(patient1, map.get("john"));

// update an existing entry
assertEquals(patient1, map.put("john", patient2));
assertEquals(1, map.size());
assertEquals(patient2, map.get("john"));

// add a new entry with a different key
assertNull(map.put("jane", patient2));
assertEquals(2, map.size());
assertEquals(patient2, map.get("jane"));

 assertThrows(NullPointerException.class, () -> map.hashFunction(null));
}
/**
 * junit tests for the get() method of the hashmapclass.
 */
@Test
void testGet() {
    PatientsHashMap map = new PatientsHashMap();
    Patient patient1 = new Patient();
    Patient patient2 = new Patient();

    // Test with no data in map
    assertNull(map.get("john"));

    // Test with one entry in map
    map.put("john", patient1);
    assertEquals(patient1, map.get("john"));

    // Test with multiple entries in map
    map.put("jane", patient2);
    assertEquals(patient2, map.get("jane"));

    // Test with key not in map
    assertNull(map.get("jack"));
}
/**
 * junit tests for the remove() method of the patientHashMap class.
 */
@Test
void testRemove() {
    PatientsHashMap map = new PatientsHashMap();
    Patient patient1 = new Patient();
    Patient patient2 = new Patient();
    Patient patient3 = new Patient();

    
    map.put("john", patient1);
    map.put("jeff", patient2);
    map.put("jed", patient3);

   
    Patient removedPatient1 = map.remove("john");
    assertEquals(patient1, removedPatient1);
    assertNull(map.get("john"));
    assertEquals(2, map.size());

    
    Patient removedPatient2 = map.remove("eve");
    assertNull(removedPatient2);
    assertEquals(2, map.size());
}
/**
 * junit test for the ContainsKey() method of the hashmap class.
 */
@Test
void testContainsKey() {
    PatientsHashMap map = new PatientsHashMap();
    Patient patient1 = new Patient();
    Patient patient2 = new Patient();
    Patient patient3 = new Patient();

    assertFalse(map.containsKey("john"));
    assertFalse(map.containsKey("jane"));
    assertFalse(map.containsKey("bob"));

    map.put("john", patient1);
    assertTrue(map.containsKey("john"));
    assertFalse(map.containsKey("jane"));
    assertFalse(map.containsKey("bob"));

    map.put("jane", patient2);
    assertTrue(map.containsKey("john"));
    assertTrue(map.containsKey("jane"));
    assertFalse(map.containsKey("bob"));

    map.put("bob", patient3);
    assertTrue(map.containsKey("john"));
    assertTrue(map.containsKey("jane"));
    assertTrue(map.containsKey("bob"));

    map.remove("john");
    assertFalse(map.containsKey("john"));
    assertTrue(map.containsKey("jane"));
    assertTrue(map.containsKey("job"));

    map.remove("jane");
    assertFalse(map.containsKey("john"));
    assertFalse(map.containsKey("jane"));
    assertTrue(map.containsKey("bob"));

    map.remove("bob");
    assertFalse(map.containsKey("john"));
    assertFalse(map.containsKey("jane"));
    assertFalse(map.containsKey("bob"));
}
/**
 * junit test for the GetKeys method of the patientHashmap class.
 */
@Test
void testGetKeys() {
    PatientsHashMap map = new PatientsHashMap();
    Patient patient1 = new Patient();
    Patient patient2 = new Patient();
    Patient patient3 = new Patient();
    map.put("john", patient1);
    map.put("jane", patient2);
    map.put("bob", patient3);
    String[] expectedKeys = {"john", "bob", "jane"};
    assertArrayEquals(expectedKeys, map.getKeys());
    
   
    PatientsHashMap emptyMap = new PatientsHashMap();
    String[] emptyKeys = {};
    assertArrayEquals(emptyKeys, emptyMap.getKeys());
}
/**
 * junit test method for the getValues() method of the patient hashmap class.
 */
@Test
void testGetValues() {
    PatientsHashMap map = new PatientsHashMap();
    Patient patient1 = new Patient();
    Patient patient2 = new Patient();
    Patient patient3 = new Patient();

    map.put("John", patient1);
    map.put("Emily", patient2);
    map.put("Mark", patient3);

    Patient[] expectedValues = new Patient[] {patient1, patient2, patient3};
    assertArrayEquals(expectedValues, map.getValues());
}
/**
 * junit test method for the 
 */
@Test
public void testGrowMap() {
    PatientsHashMap map = new PatientsHashMap(4);
    map.put("John", new Patient());
    map.put("Mary", new Patient());
    map.put("David", new Patient());
    map.put("Susan", new Patient());
    map.put("Mike", new Patient());
    map.put("Olivia", new Patient());

   
    
    map.growMap();

  assertTrue(map.size() == 6);
   


}
}