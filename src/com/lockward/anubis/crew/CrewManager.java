package com.lockward.anubis.crew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CrewManager {

    private static final String filename = "crew.txt";
    private static CrewMember[] pool;

    static {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = null;
            int idx = 0;
            pool = new CrewMember[10];

            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                FlightCrewJob job = FlightCrewJob.valueOf(parts[0]);

                pool[idx] = new CrewMember(job);
                pool[idx].setName(parts[1]);
                idx++;
            }
        } catch (IOException ex) {
            System.out.println("There was an error while reading the file: " + filename);
            System.out.println("    Original Exception: " + ex.getMessage());
        }
    }

    public static CrewMember findAvailable(FlightCrewJob job) {
        CrewMember cm = null;

        for (int i = 0; i < pool.length; i++) {
            if (pool[i] != null && pool[i].job == job) {
                cm = pool[i];
                pool[i] = null;
                break;
            }
        }
        return cm;
    }
}
