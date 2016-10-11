package com.clockworkteaching.sud.game;

import com.clockworkteaching.sud.model.NPC;
import com.clockworkteaching.sud.model.Player;
import java.util.Random;

public class AgilityFightStrategy implements FightStrategy {

    @Override
    public void fight(Player player, NPC targetNPC) {
        int hit = 0;
        while (player.isAlive() && targetNPC.isAlive()) {

            if (!targetNPC.isAlive()) {
                System.out.println("Nie ma celu");
                return;
            }

            try {
                if (calculateHitChance(player, targetNPC)) {
                    hit = calculateHitStrength(player.getStrength());
                    showHitMessage(targetNPC, hit);
                } else {
                    System.out.println("Your hit misses " + targetNPC.getName());
                }

                targetNPC.damageTaken(hit);
                Thread.sleep(1000);
                if (calculateHitChance(targetNPC, player)) {
                    hit = calculateHitStrength(targetNPC.getStrength());
                    showHitMessage(hit);
                    player.damageTaken(hit);
                } else {
                    System.out.println(targetNPC.getName() + "'s hit misses you");
                }
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println("System padl");
            }
        }

        if (player.isAlive()
                && !targetNPC.isAlive()) {
            System.out.println("Wygrałeś");

        } else if (!player.isAlive()
                && targetNPC.isAlive()) {
            System.out.println("Przegrałeś");
        } else {
            System.out.println("Uciekaj");
        }
    }

    private int calculateHitStrength(int strength) {
        Random r = new Random();
        return strength + r.nextInt(4);
    }

    private void showHitMessage(NPC targetNPC, int hit) {
        System.out.println("Uderzyłeś " + targetNPC.getName() + " i załałeś " + hit + " obrażeń.");
    }

    private void showHitMessage(int hit) {
        System.out.println("Doznałeś " + hit + " obrażeń.");

    }

    private boolean calculateHitChance(NPC targetNPC, Player player) {
        int rand = new Random().nextInt(20);
        return (targetNPC.getAgility() + rand) > player.getAgility();
    }

    private boolean calculateHitChance(Player player, NPC targetNPC) {
        int rand = new Random().nextInt(40);
        return (player.getAgility() + rand) > targetNPC.getAgility();
    }
}
