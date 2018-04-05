package com.lockward.anubis.travel;

import com.lockward.anubis.Person;

public class Passenger extends Person implements Comparable<Passenger> {
    private int checkedBags;
    private int freeBags;

    public static class RewardProgram {
        private int memberLevel;
        private int memberDays;

        public int getLevel() { return memberLevel; }
        public void setMemberLevel(int level) { memberLevel = level; }

        public int getDays() { return memberDays; }
        public void setMemberDays(int days) { memberDays = days; }
    }

    private RewardProgram rewardProgram = new RewardProgram();

    public void setLevelAndDays(int level, int days) {
        rewardProgram.setMemberLevel(level);
        rewardProgram.setMemberDays(days);
    }

    public RewardProgram getRewardProgram() { return rewardProgram; }

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
        if(rewardProgram.getLevel() > p.rewardProgram.getLevel()) {
            return -1;
        }
        else if (rewardProgram.getLevel() < p.rewardProgram.getLevel()) {
            return 1;
        }
        else {
            if (rewardProgram.getDays() > p.rewardProgram.getDays()) {
                return -1;
            }
            else if (rewardProgram.getDays() < p.rewardProgram.getDays()) {
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
