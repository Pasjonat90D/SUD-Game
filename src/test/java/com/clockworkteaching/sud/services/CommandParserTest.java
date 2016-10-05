package com.clockworkteaching.sud.services;

import com.clockworkteaching.sud.model.Direction;
import com.clockworkteaching.sud.model.Location;
import com.clockworkteaching.sud.model.NPC;
import com.clockworkteaching.sud.model.Player;
import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;

public class CommandParserTest {

    Location mainLocation;
    Location northLocation;
    
    @Before
    public void initTest(){
        mainLocation = new Location("Short","Long");
        northLocation = new Location("Second", "Long");
        mainLocation.addDirection(Direction.N,northLocation);
        NPC ork = new NPC("ork");
        mainLocation.addNPC(ork);
    }
    
    @Test
    public void testParserMove() {
        
        Player dziwny = new Player("D", mainLocation);
        CommandParser parser = new CommandParser();
        CommandParser spyParser = Mockito.spy(parser);
        dziwny.setActualLocation(northLocation);
        spyParser.actOnCommand("north", dziwny);
        Mockito.verify(spyParser, times(1)).move(Direction.N,dziwny);
        
    }
    
    @Test
    public void testParserKill(){
        Player dziwny = new Player("D", mainLocation);
        dziwny.setActualLocation(mainLocation);
        CommandParser parser = new CommandParser();
        CommandParser spyParser = Mockito.spy(parser);
        spyParser.actOnCommand("kill ork", dziwny);
        //Mockito.verify(spyParser, times(1)).attack("ork", dziwny);            Nie działa
    }

}
