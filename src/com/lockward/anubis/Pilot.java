package com.lockward.anubis;

import com.lockward.anubis.travel.Flight;

public abstract class Pilot {
    private Flight currentFlight;

    public void fly(Flight f) {
        if (canAccept(f)) {
            currentFlight = f;
        }
        else {
            handleCanAccept();
        }
    }

    public abstract boolean canAccept(Flight f);

    private void handleCanAccept() {
        System.out.println("Can't accept");
    }
}
