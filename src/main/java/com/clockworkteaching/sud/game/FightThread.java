package com.clockworkteaching.sud.game;

import com.clockworkteaching.sud.model.NPC;
import com.clockworkteaching.sud.model.Player;
import java.util.Random;

public class FightThread implements Runnable {

    private Player player;
    private NPC targetNPC;
    FightStrategy fightStrategy;

    public FightThread(Player player, NPC targetNPC, FightStrategy fightStrategy) {
        this.player = player;
        this.targetNPC = targetNPC;
        this.fightStrategy = fightStrategy;
    }

    @Override
    public void run() {
        fightStrategy.fight(player, targetNPC);

    }
}
