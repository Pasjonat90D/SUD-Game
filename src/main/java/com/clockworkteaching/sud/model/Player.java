
package com.clockworkteaching.sud.model;


public class Player {
    
    private String name;
    private Location actualLocation;
    private int health;
    private int strength;

    public Player(String name , Location actualLocation) {
        this.name = name;
        this.actualLocation = actualLocation;
        this.health = 100;
        this.strength = 5;
        
    }

    public Player(String name, Location actualLocation, int health, int strength) {
        this.name = name;
        this.actualLocation = actualLocation;
        this.health = health;
        this.strength = strength;
    }
    
    
    public String getName() {
        return name;
    }

    public String getLocationDescription() {
        return ""+actualLocation;
    }

    public void setActualLocation(Location actualLocation) {
        this.actualLocation = actualLocation;
    }

    public boolean move(Direction direction) {
        Location nexLocation = this.actualLocation.getNextLocation(direction);
        if(nexLocation!=null){
            this.actualLocation = nexLocation;
            return true;
        } else{
            return false;
        }
    }
    public String getListNPC(){
        return actualLocation.listingNPC();
    }
    public String exitsLocation(){
        return actualLocation.getExitString();
    }

    public NPC getNearbyNPC(String npcName) {
        return this.actualLocation.getNPC(npcName);
    }

    public boolean isAlive() {
        return health>0;
    }

    public int getStrength() {
        return strength;
    }
    public void damageTaken(int hit) {
        this.health = this.health - hit;
    }

    public Location getActualLocation() {
        return actualLocation;
    }
    
}
