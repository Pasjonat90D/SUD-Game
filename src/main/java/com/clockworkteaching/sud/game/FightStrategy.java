package com.clockworkteaching.sud.game;

import com.clockworkteaching.sud.model.NPC;
import com.clockworkteaching.sud.model.Player;

public interface FightStrategy {

    public void fight(Player player, NPC targetNPC);

}
