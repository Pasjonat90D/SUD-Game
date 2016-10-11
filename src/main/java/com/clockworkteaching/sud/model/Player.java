package com.clockworkteaching.sud.model;

public class Player {

    private String name;
    private Location actualLocation;

    private Statistics stats;

    public Player(String name, Location actualLocation) {
        this.name = name;
        this.actualLocation = actualLocation;
        this.stats = new Statistics(100, 5, 10);
    }

    public Player(String name, Location actualLocation, int health, int strength) {
        this.name = name;
        this.actualLocation = actualLocation;
        this.stats = new Statistics(health, strength, 10);
    }

    public Player(String name, Location actualLocation, int health, int strength, int agility) {
        this.name = name;
        this.actualLocation = actualLocation;
        this.stats = new Statistics(health, strength, agility);
    }

    public String getName() {
        return name;
    }

    public String getLocationDescription() {
        return "" + actualLocation;
    }

    public void setActualLocation(Location actualLocation) {
        this.actualLocation = actualLocation;
    }

    public boolean move(Direction direction) {
        Location nexLocation = this.actualLocation.getNextLocation(direction);
        if (nexLocation != null) {
            this.actualLocation = nexLocation;
            return true;
        } else {
            return false;
        }
    }

    public String getListNPC() {
        return actualLocation.listingNPC();
    }

    public String exitsLocation() {
        return actualLocation.getExitString();
    }

    public NPC getNearbyNPC(String npcName) {
        return this.actualLocation.getNPC(npcName);
    }

    public boolean isAlive() {
        return stats.getHealth() > 0;
    }

    public int getStrength() {
        return stats.getStrength();
    }

    public void damageTaken(int hit) {
        stats.setHealth(stats.getHealth() - hit);
    }

    public int getAgility() {
        return stats.getAgility();
    }

    public Location getActualLocation() {
        return actualLocation;
    }

}
