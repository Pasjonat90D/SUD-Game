
package com.clockworkteaching.sud.services;

import com.clockworkteaching.sud.model.Player;

public class LookCommand implements Command {

    private Player player;
    
    public LookCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        String resoult = "Jesteś na pozycji:\n" + player.getLocationDescription() +"NPC na lokacji: "+ player.getListNPC();
        return resoult;
    }
    
}
