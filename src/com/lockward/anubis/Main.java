package com.lockward.anubis;

import com.lockward.anubis.crew.CrewManager;
import com.lockward.anubis.crew.CrewMember;
import com.lockward.anubis.crew.FlightCrewJob;
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

        CrewMember p = CrewManager.findAvailable(FlightCrewJob.FlightAttendant);

        if (p != null)
            System.out.println("Job found for: " + p.getName());

        CrewMember a = CrewManager.findAvailable(FlightCrewJob.CoPilot);

        if (a != null)
            System.out.println("Job found for: " + a.getName());

        CrewMember c = CrewManager.findAvailable(FlightCrewJob.AirMarshal);

        if (c != null)
            System.out.println("Job found for: " + c.getName());

        Passenger josh = new Passenger("Josh");

        josh.getRewardProgram().setMemberLevel(3);
        josh.getRewardProgram().setMemberDays(180);

        Passenger.RewardProgram platinum = new Passenger.RewardProgram();
        platinum.setMemberLevel(3);

        if (josh.getRewardProgram().getLevel() == platinum.getLevel())
            System.out.println("Josh is platinum!");

    }
}
