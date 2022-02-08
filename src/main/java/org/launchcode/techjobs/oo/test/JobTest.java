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
        assertFalse(j1.equals(j2));
    }

    @Test
    public void testToStringMethodWithAllValues() {
        Job j1 = new Job("Cook", new Employer("Wendy's"), new Location("Atlanta"), new PositionType("culinary"), new CoreCompetency("cooking"));
        assertEquals("\nID: 5\nName: Cook\nEmployer: Wendy's\nLocation: Atlanta\nPosition Type: culinary\nCore Competency: cooking\n", j1.toString());
    }

    @Test
    public void testToStringMethodWithMissingValues() {
        Job j1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: 1\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available", j1.toString());
    }

    @Test
    public void testToStringMethodJobWithOnlyId() {
        Job j = new Job();
        assertEquals("OOPS! This job does not seem to exist.", j.toString());
    }
}
