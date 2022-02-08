package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.


    @Override
    public String toString() {
        String result = null;
        String error = "Data not available";
       // && this.getEmployer().getValue().equals(null) && this.getLocation().getValue().equals(null) && this.getPositionType().getValue().equals(null) && this.getCoreCompetency().getValue().equals(null)
        if (this.getName()==null) {
            result = "OOPS! This job does not seem to exist.";
        } else {
            if (this.getId() != (0)) {
                result = "ID: _" + this.getId() + "_";
            }
            if (!this.getName().equals("")) {
                result += "\nName: _" + this.getName() + "_";
            } else {
                result += "\nName: " + error;
            }
            if (!this.getEmployer().getValue().equals("")) {
                result += "\nEmployer: _" + this.getEmployer() + "_";
            } else {
                result += "\nEmployer: " + error;
            }
            if (!this.getLocation().getValue().equals("")) {
                result += "\nLocation: _" + this.getLocation() + "_";
            } else {
                result += "\nLocation: " + error;
            }
            if (!this.getPositionType().getValue().equals("")) {
                result += "\nPosition Type: _" + this.getPositionType() + "_";
            } else {
                result += "\nPosition Type: " + error;
            }
            if (!this.getCoreCompetency().getValue().equals("")) {
                result += "\nCore Competency: _" + this.getCoreCompetency() + "_";
            } else {
                result += "\nCore Competency: " + error;
            }
        }
        return result;
//        return "ID: _" +this.getId()+"_"+
//        "\nName: _" +this.getName()+"_"+
//        "\nEmployer: _" +this.getEmployer()+"_"+
//        "\nLocation: _" +this.getLocation()+"_"+
//        "\nPosition Type: _" +this.getPositionType()+"_"+
//        "\nCore Competency: _" +this.getCoreCompetency()+"_";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
