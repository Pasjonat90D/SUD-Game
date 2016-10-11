package com.clockworkteaching.sud.model;

import org.junit.Before;

public class TestPlayer {

    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addDirection(Direction.N, northLocation);
    }

}
