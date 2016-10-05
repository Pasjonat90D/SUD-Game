package com.clockworkteaching.sud.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {

    private String shortDescr;
    private String longDescr;
    private Map<Direction, Location> exits;
    private List<NPC> npcs;

    public Location(String shortDescr, String longDescr) {
        this.longDescr = longDescr;
        this.shortDescr = shortDescr;
        this.exits = new HashMap<>();
        this.npcs = new ArrayList<>();
    }

    public void addDirection(Direction e, Location l) {
        exits.put(e, l);
    }

    public String getShortDescr() {
        return shortDescr;
    }

    public String getLongDescr() {
        return longDescr;
    }

    @Override
    public String toString() {
        return "<" + shortDescr + ">\n"
                + "<" + longDescr + ">"+ ">\n";
                
    }
    
    
    
    public Location getNextLocation(Direction direction) {
        boolean exists = this.exits.containsKey(direction);
        if (exists) {
            return this.exits.get(direction);
        } else {
            return null;
        }
    }
    public void addNPC (NPC npc){
        this.npcs.add(npc);
    }
    public String listingNPC(){
        String temp = "";
        for(NPC npc : npcs){
            temp = npc.getName()+ " " +temp ;
        }
        if (temp == "")
            return "Nikogo nie ma";
        else
            return temp;
    }

    public String getExitString() {
        String exitsString = "Możliwe wyjścia: ";
        for(Direction direction : exits.keySet()){
            exitsString += direction.getDirectionDescription() + "";
        }
        return exitsString;
    }

    public boolean isThereNPC(String npcName) {
        for(NPC npc : npcs){
        if(npc.getName().equalsIgnoreCase(npcName)){
            return true;
        }
    }
        return false;
    }

    public NPC getNPC(String npcName) {
        for(NPC npc : npcs){
        if(npc.getName().equalsIgnoreCase(npcName)){
            return npc;
        }
    }
        return null;
    }
    
    
    
}


