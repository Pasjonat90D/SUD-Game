package com.clockworkteaching.sud.services;

import com.clockworkteaching.sud.model.Direction;
import com.clockworkteaching.sud.model.Location;
import com.clockworkteaching.sud.model.Player;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoveCommandTest {

    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addDirection(Direction.N, northLocation);
    }

    @Test
    public void testMoveIfProperDirectionIsSend() {
        Player p = new Player("TestPlayer", mainLocation);
        MoveCommand move = new MoveCommand(Direction.N, p);
        move.execute();
        Assert.assertEquals(northLocation, p.getActualLocation());
    }
    @Test
    public void returnInfoIfThereIsNoLocationInGivenDirection(){
        Player p = new Player("TestPlayer", mainLocation);
        MoveCommand move = new MoveCommand(Direction.S, p);
        String resoult = move.execute();
        Assert.assertEquals("Nie masz wyjścia", resoult);
    }
}
