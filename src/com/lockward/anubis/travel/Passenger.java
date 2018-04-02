package com.lockward.anubis.travel;

import com.lockward.anubis.Person;

public class Passenger extends Person implements Comparable<Passenger> {
    private int checkedBags;
    private int freeBags;
    private int memberLevel;
    private int memberDays;
    String name;

    public void setLevelAndDays(int level, int days) {
        setMemberLevel(level);
        setMemberDays(days);
    }
    public int getMemberLevel(){ return memberLevel; }
    public void setMemberLevel(int memberLevel) { this.memberLevel = memberLevel; }
    public int getMemberDays() { return memberDays; }
    public void setMemberDays(int memberDays) { this.memberDays = memberDays; }

    public Passenger() { }

    public Passenger(String name) { super(name); }

    public Passenger(int freeBags) {
        this.freeBags = freeBags;
    }

    public Passenger(int freeBags, int bags) {
        this(freeBags);
        checkedBags = bags;
    }

    public int getCheckedBags() {
        return checkedBags;
    }

    @Override
    public int compareTo(Passenger p) {
        if(memberLevel > p.memberLevel ) {
            return -1;
        }
        else if (memberLevel < p.memberLevel) {
            return 1;
        }
        else {
            if (memberDays > p.memberDays) {
                return -1;
            }
            else if (memberDays < p.memberDays) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
