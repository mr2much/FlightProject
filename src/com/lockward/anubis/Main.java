package com.lockward.anubis;

import com.lockward.anubis.travel.CargoFlight;
import com.lockward.anubis.travel.Flight;
import com.lockward.anubis.travel.Passenger;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Passenger bob = new Passenger("Bob");
        bob.setLevelAndDays(1, 180);

        Passenger jane = new Passenger("Jane");
        jane.setLevelAndDays(1, 90);

        Passenger steve = new Passenger("Steve");
        steve.setLevelAndDays(2, 180);

        Passenger lisa = new Passenger("Lisa");
        lisa.setLevelAndDays(3, 730);

        Passenger[] passengers = { bob, jane, steve, lisa };

        Arrays.sort(passengers);

        CrewMember patty = new CrewMember("Patty", FlightCrewJob.Pilot);

        CrewMember karl = new CrewMember("Karl", FlightCrewJob.CoPilot);

        CrewMember mary = new CrewMember("Mary", FlightCrewJob.AirMarshal);

        CrewMember[] crew = { patty, karl, mary};

        Flight lax045 = new Flight(45);
        lax045.setFlightTime(45);

        lax045.addCrewMembers(crew);
        lax045.addPassengers(passengers);

        for (Person p : lax045) {
            System.out.println(p.getName());
        }
    }
}
