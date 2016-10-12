package com.clockworkteaching.sud.services;

import com.clockworkteaching.sud.model.Direction;
import com.clockworkteaching.sud.model.Location;
import com.clockworkteaching.sud.model.NPC;
import com.clockworkteaching.sud.model.Player;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;

public class KillCommandTest {

    Location mainLocation;
    NPC ork;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        ork = new NPC("ork");
        mainLocation.addNPC(ork);
    }

    @Test
    public void beginCombatifTargetIsThere() {
        Player playerTest = new Player("DzikiKarol", mainLocation);
        playerTest.setActualLocation(mainLocation);
        KillCommand kill = new KillCommand("ork", playerTest);
        KillCommand killSpy = Mockito.spy(kill);
        killSpy.execute();
        Mockito.verify(killSpy, times(1)).beginCombat(playerTest, ork);
    }

    @Test
    public void returnTargetNotThereInfoIfTargetIsNoLocation() {
        Player playerTest = new Player("DzikiKarol", mainLocation);
        playerTest.setActualLocation(mainLocation);
        KillCommand kill = new KillCommand("goblin", playerTest);
        String resoult = kill.execute();
        Assert.assertEquals("Nie można zaatakować", resoult);
    }
}
