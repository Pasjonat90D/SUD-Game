
package com.clockworkteaching.sud.model;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestLocation {
    
    Location mainLocation;
    Location northLocation;
    
    @Before
    public void initTest(){
        mainLocation = new Location("Short","Long");
        northLocation = new Location("Second", "Long");
        Location southLocation = new Location("Third", "Long");
        mainLocation.addDirection(Direction.N, northLocation);
        mainLocation.addDirection(Direction.S, southLocation);
        NPC ork = new NPC("ork");
        NPC secondOrk = new NPC("ork2");
        mainLocation.addNPC(ork);
        mainLocation.addNPC(secondOrk);
    }
    
    @Test
    public void testDescription(){
        String description = mainLocation.toString();
        String validDescritpion = "<Short>\n<Long>>\n";
        Assert.assertEquals("Compare Description", validDescritpion, description);
    }
    
    @Test
    public void testGetNextLocation(){
        
        Location nextLocation = mainLocation.getNextLocation(Direction.N);
        Assert.assertEquals("Ten sam obiekt", northLocation,nextLocation);
        
        Location nullLoc = mainLocation.getNextLocation(Direction.E);
        Assert.assertNull(nullLoc);
    }
    @Test
    public void testGetNPC(){
        NPC getOrk = mainLocation.getNPC("ork");
        Assert.assertEquals("Existing npc","ork",getOrk.getName());
        NPC getOrk2 = mainLocation.getNPC("ork4");
        Assert.assertNull("Non-existing npc",getOrk2);
    }
}
