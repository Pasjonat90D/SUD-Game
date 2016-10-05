
package com.clockworkteaching.sud.repository;

import com.clockworkteaching.sud.model.Direction;
import com.clockworkteaching.sud.model.Location;
import com.clockworkteaching.sud.model.NPC;


public class LocationRepository {
    
    private Location locationPlayer;
    
    public LocationRepository(){
        locationPlayer = new Location("Lokacja Startowa",
                "Znajdujesz się w przykładowej lokacji startowej");
        Location nextLocation = new Location("Następna lokacja", "Zrobiłeś krok");
        locationPlayer.addDirection(Direction.N, nextLocation);
        nextLocation.addDirection(Direction.S, locationPlayer);
        NPC jon_sell = new NPC("Jon",50,5);
        locationPlayer.addNPC(jon_sell);
    
}

    public Location getStartLocation() {
        return this.locationPlayer;
    }
    
    
}
