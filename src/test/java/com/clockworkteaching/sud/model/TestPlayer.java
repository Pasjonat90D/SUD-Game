
package com.clockworkteaching.sud.model;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPlayer {
    
    Location mainLocation;
    Location northLocation;
    
    @Before
    public void initTest(){
        mainLocation = new Location("Short","Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addDirection(Direction.N,northLocation);
    }
    @Test
    public void testPlayerMove(){
        Player player = new Player("DzikiKarol",mainLocation);
        player.move(Direction.N);
        Assert.assertEquals("Ruch lokacja ta sama", northLocation, player.getActualLocation());
        
    }
}
