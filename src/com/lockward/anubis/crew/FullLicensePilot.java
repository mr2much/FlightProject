package com.lockward.anubis.crew;

import com.lockward.anubis.travel.Flight;

public class FullLicensePilot extends Pilot {
    @Override
    public boolean canAccept(Flight f) {
        return true;
    }
}
