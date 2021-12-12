package com.ridz;

public class Day {
    private final String[] events;
    private final boolean squirrel;

    public Day(String[] events, boolean squirrel) {
        this.events = events;
        this.squirrel = squirrel;
    }

    public String[] getEvents() {
        return events;
    }

    public boolean isSquirrel() {
        return squirrel;
    }

}
