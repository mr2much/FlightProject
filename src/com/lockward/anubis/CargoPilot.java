package com.lockward.anubis;

import com.lockward.anubis.travel.Flight;

public class CargoPilot extends Pilot {
    @Override
    public boolean canAccept(Flight f) {
        return f.getPassengers() == 0;
    }
}
