package com.lockward.anubis;

import com.lockward.anubis.travel.Flight;

public class FullLicensePilot extends Pilot {
    @Override
    public boolean canAccept(Flight f) {
        return true;
    }
}
