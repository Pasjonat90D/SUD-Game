package com.clockworkteaching.sud.model;

public class NPC {

    private String name;

    private Statistics stats;

    public NPC(String name) {
        this.name = name;
        this.stats = new Statistics(100, 5, 10);

    }

    public NPC(String name, int health, int strength) {
        this.name = name;
        this.stats = new Statistics(health, strength, 10);
    }

    public NPC(String name, int health, int strength, int agility) {
        this.name = name;
        this.stats = new Statistics(health, strength, agility);
    }

    public String getName() {
        return name;
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

}
