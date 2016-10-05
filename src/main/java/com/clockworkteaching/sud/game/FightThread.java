
package com.clockworkteaching.sud.game;

import com.clockworkteaching.sud.model.NPC;
import com.clockworkteaching.sud.model.Player;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FightThread implements Runnable {

    private Player player;
    private NPC targetNPC;

    public FightThread(Player player, NPC targetNPC) {
        this.player = player;
        this.targetNPC = targetNPC;
    }
    
    
    
    @Override
    public void run() {
         int hit = 0;
        while(player.isAlive() && targetNPC.isAlive()){
            
            if(!targetNPC.isAlive()){
                System.out.println("Nie ma celu");
                return;
            }
            
            try {
                hit = calculateHitStrength(player.getStrength());
                showHitMessage(targetNPC,hit);
                targetNPC.damageTaken(hit);
                Thread.sleep(200);
                hit = calculateHitStrength(targetNPC.getStrength());
                showHitMessage(hit);
                player.damageTaken(hit);
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println("System padl");
            }
        }
        if(player.isAlive() && !targetNPC.isAlive()){
            System.out.println("Wygrałeś");
            
        } else if(!player.isAlive() && targetNPC.isAlive()) {
            System.out.println("Przegrałeś");
        } else{
            System.out.println("Uciekaj");
        }
    }
    private int calculateHitStrength(int strength) {
        Random r = new Random();
        return strength + r.nextInt(4);
    }

    private void showHitMessage(NPC targetNPC, int hit) {
        System.out.println("Uderzyłeś "+targetNPC.getName() + " i załałeś " + hit + " obrażeń.");
    }

    private void showHitMessage(int hit) {
        System.out.println("Doznałeś " + hit + " obrażeń.");
    }
}
