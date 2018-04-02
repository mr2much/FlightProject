package com.lockward.anubis.travel;

import java.io.IOException;

public class CargoFlight extends Flight {
    float maxCargoSpace = 1000.0f;
    float usedCargoSpace;
    int seats = 12;

    @Override
    public int getSeats() { return 12; }

    public CargoFlight() {}

    public CargoFlight(float maxCargoSpace) {
        this.maxCargoSpace = maxCargoSpace;
    }

    public CargoFlight(int flightNumber) {
        super(flightNumber);
    }

    public CargoFlight(int flightNumber, float maxCargoSpace) {
        this(flightNumber);
        this.maxCargoSpace = maxCargoSpace;
    }

    public void add1Package(float h, float w, float d) {
        float size = h * w * d;

        if(hasCargoSpace(size)) {
            usedCargoSpace += size;
        }
        else {
            handleNoSpace();
        }
    }

    @Override
    public void addPassengers(String filename) throws IOException {

    }

    private boolean hasCargoSpace(float size) {
        return usedCargoSpace + size <= maxCargoSpace;
    }

    private void handleNoSpace() {
        System.out.println("Not enough space");
    }
}
