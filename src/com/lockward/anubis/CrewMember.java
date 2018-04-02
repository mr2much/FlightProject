package com.lockward.anubis;

public class CrewMember extends Person {
    private FlightCrewJob job;

    public void setJob(FlightCrewJob job) { this.job = job; }

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
