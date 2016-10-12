
package com.clockworkteaching.sud.services;

import com.clockworkteaching.sud.model.Direction;
import com.clockworkteaching.sud.model.Location;
import com.clockworkteaching.sud.model.NPC;
import com.clockworkteaching.sud.model.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LookCommandTest {
    
    Location mainLocation;
    Location northLocation;
    Player playerTest;
    NPC ork;


    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addDirection(Direction.N, northLocation);
        playerTest = new Player("DzikiKarol", mainLocation);
        playerTest.setActualLocation(mainLocation);
        ork = new NPC("ork");
        mainLocation.addNPC(ork);
    }

    
    
    @Test
    public void testLookIfAllOk(){
        String resoult = "Jesteś na pozycji:\n<Short>\n<Long>>\nNPC na lokacji: ork ";
        LookCommand lookCommand = new LookCommand(playerTest);
        String lookCommandReturn = lookCommand.execute();
        Assert.assertEquals(resoult, lookCommandReturn);
        
        
    }
    
    
}
