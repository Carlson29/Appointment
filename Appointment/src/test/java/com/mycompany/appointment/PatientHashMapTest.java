/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.appointment;

import java.time.LocalDate;
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

    private PatientsHashMap map;
   
    Patient patient1 = new Patient();

    public PatientHashMapTest() {
    }

    @BeforeEach
    public void setUp() {
        map = new PatientsHashMap();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSize() {
       
        Assertions.assertEquals(0, map.size());

        map.put("john", patient1);
        Assertions.assertEquals(1, map.size());

        map.remove("john");
        Assertions.assertEquals(0, map.size());
    
       
    }
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

}