package org.launchcode.techjobs.oo.test;

import jdk.jfr.Label;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.Locale;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job j1 = new Job("Cook", new Employer("Wendy's"), new Location("Atlanta"), new PositionType("culinary"), new CoreCompetency("cooking"));
        Job j2 = new Job("Cashier", new Employer("Wendy's"), new Location("Atlanta"), new PositionType("retail"), new CoreCompetency("customer service"));
        assertNotEquals(j1, j2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job j3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(6, j3.getId());
        assertEquals("Product tester", j3.getName());
        assertEquals("ACME", j3.getEmployer());
        assertTrue(j3.getName() instanceof String);
        assertTrue(j3.getEmployer() instanceof Employer);
        assertTrue(j3.getLocation() instanceof Location);
        assertTrue(j3.getPositionType() instanceof PositionType);
        assertTrue(j3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job j1 = new Job("Cook", new Employer("Wendy's"), new Location("Atlanta"), new PositionType("culinary"), new CoreCompetency("cooking"));
        Job j2 = new Job("Cook", new Employer("Wendy's"), new Location("Atlanta"), new PositionType("culinary"), new CoreCompetency("cooking"));
        assertFalse(j1.getId()==j2.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job j1 = new Job("Cook", new Employer("Wendy's"), new Location("Atlanta"), new PositionType("culinary"), new CoreCompetency("cooking"));
        assertEquals(j1.toString().toCharArray()[0],'\n');
        assertEquals(j1.toString().toCharArray()[j1.toString().toCharArray().length-1], '\n');
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job j1 = new Job("Cook", new Employer(""), new Location("Atlanta"), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: "+j1.getId()+"\nName: "+j1.getName()+"\nEmployer: Data not available"+"\nLocation: "+j1.getLocation()+"\nPosition Type: Data not available"+"\nCore Competency: Data not available"+"\n", j1.toString());
    }
//1 Create Job object with test values
    //2 Use the values of ID, Name, Employer, etc to build up an expected string
    //job.getId();

    //empty field test with the Data not available
    //job.setName("my job);
    //job.setLocation(...);
   // same result as
   //new Job("my job", null, ...);
   //test string ID: 7 Name: my job Employer: Data not available
   //Compare test string to actual
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job j1 = new Job("Cook", new Employer("Wendy's"), new Location("Atlanta"), new PositionType("culinary"), new CoreCompetency("cooking"));
        assertEquals("\nID: "+j1.getId()+"\nName: "+j1.getName()+"\nEmployer: "+j1.getEmployer()+"\nLocation: "+j1.getLocation()+"\nPosition Type: "+j1.getPositionType()+"\nCore Competency: "+j1.getCoreCompetency()+"\n", j1.toString());
    }

//    @Test
//    public void testToStringMethodWithMissingValues() {
//        Job j1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
//        assertEquals("\nID: 1\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available", j1.toString());
//    }

    @Test
    public void testToStringMethodJobWithOnlyId() {
        Job j = new Job();
        assertEquals("OOPS! This job does not seem to exist.", j.toString());
    }
}
