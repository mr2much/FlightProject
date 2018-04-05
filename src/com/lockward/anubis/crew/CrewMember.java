package com.lockward.anubis.crew;

import com.lockward.anubis.Person;

public class CrewMember extends Person {
    FlightCrewJob job;

    public void setJob(FlightCrewJob job) { this.job = job; }

    public void setName(String name) { this.name = name; }
    @Override
    public String getName() { return job.toString() + " " + super.getName(); }

    public CrewMember() { }

    public CrewMember(String name) { super(name); }

    public CrewMember(FlightCrewJob job) { this.job = job; }

    public CrewMember(String name, FlightCrewJob job) {
        this(name);
        this.job = job;
    }
}
