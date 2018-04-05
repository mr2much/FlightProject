package com.lockward.anubis.travel;

import com.lockward.anubis.crew.CrewMember;
import com.lockward.anubis.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Flight implements Comparable<Flight>, Iterable<Person> {

    static final int MAX_FAA_SEATS = 550;
    private int seats = 150, passengers;
    private int totalCheckedBags;
    private int maxCarryOns = seats * 2, totalCarryOns;
    private Integer flightNumber;
    private Character flightClass;
    private int flightTime;
    private CrewMember[] crew;
    private Passenger[] roster;

    public int getSeats() { return seats; }
    public void setSeats(int seats) {
        if(seats <= MAX_FAA_SEATS) {
            this.seats = seats;
        }
        else {
            // handle error
        }
    }

    public int getPassengers() { return passengers; }
    public void setFlightTime(int time) { this.flightTime = time; }

    public Flight() {}

    public Flight(int flightNumber) { this.flightNumber = flightNumber; }

    public void add1Passenger() {
        if(hasSeating()) {
            passengers += 1;
        } else {
            handleTooMany();
        }
    }

    public void add1Passenger(int bags) {
        if (hasSeating()) {
            add1Passenger();
            totalCheckedBags += bags;
        }
    }

    public void add1Passenger(Passenger p) {
        add1Passenger(p.getCheckedBags());
    }

    public void add1Passenger(int bags, int carryOns) {
        if(hasSeating() && hasCarryOnSpace(carryOns)) {
            add1Passenger(bags);
            totalCarryOns += carryOns;
        }
    }

    public void add1Passenger(Passenger p, int carryOns) {
        add1Passenger(p.getCheckedBags(), carryOns);
    }

    public void addPassengers(Passenger...list) {
        if(hasSeating(list.length)) {
            for(Passenger p : list) {
                passengers += list.length;
                for(Passenger passenger : list) {
                    totalCheckedBags += passenger.getCheckedBags();
                }
            }
            roster = list;
        }
        else {
            handleTooMany();
        }
    }

    public void addCrewMembers(CrewMember...list) {
        crew = list;
    }

    public void addPassengers(String filename) throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename));

            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                passengers += Integer.valueOf(parts[0]);
            }
        } finally {
            if(reader != null) {
                reader.close();
            }
        }
    }

    private boolean hasSeating(int count) {
        return passengers + count <= getSeats();
    }

    private boolean hasSeating() {
        return passengers < getSeats();
    }

    private void handleTooMany() {

    }

    private boolean hasCarryOnSpace(int carryOns) {
        return totalCarryOns + carryOns <= maxCarryOns;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) { return false; }

        if(super.equals(o)) { return true; }

        if(o instanceof Flight) {
            Flight other = (Flight) o;

            return this.flightNumber == other.flightNumber && this.flightClass == other.flightClass;
        }

        return false;
    }

    @Override
    public String toString() {
        if(flightNumber != null) {
            return "Flight #" + flightNumber;
        }
        else if(flightClass != null){
            return "Flight Class " + flightClass;
        }
        else {
            return "Flight identity not set ";
        }
    }

    @Override
    public int compareTo(Flight f) {
        return flightTime - f.flightTime;
    }

    @Override
    public Iterator<Person> iterator() {
        return new Iterator<Person>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < (crew.length + roster.length);
            }

            @Override
            public Person next() {
                Person p = (index < crew.length) ? crew[index] : roster[index - crew.length];
                index++;

                return p;
            }

            @Override
            public void remove() { }
        };
    }
}
