package com.clockworkteaching.sud.services;

import com.clockworkteaching.sud.game.AgilityFightStrategy;
import com.clockworkteaching.sud.game.FightStrategy;
import com.clockworkteaching.sud.game.FightThread;
import com.clockworkteaching.sud.model.NPC;
import com.clockworkteaching.sud.model.Player;

public class KillCommand implements Command {

    private String targetName;
    private Player player;

    KillCommand(String targetName, Player player) {
        this.player = player;
        this.targetName = targetName;
    }

    @Override
    public String execute() {
        String result = "";
        NPC targetNPC = player.getNearbyNPC(targetName);
        if (targetNPC != null) {
            result = "Atakujesz " + targetName;
            beginCombat(player, targetNPC);
        } else {
            result = "Nie można zaatakować";
        }
        return result;
    }

    static void beginCombat(Player player, NPC targetNPC) {

        FightStrategy fs = new AgilityFightStrategy();

        FightThread ft = new FightThread(player, targetNPC, fs);
        Thread t = new Thread(ft);
        t.start();

    }
}
