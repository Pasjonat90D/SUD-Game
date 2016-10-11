/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clockworkteaching.sud.services;

import com.clockworkteaching.sud.model.Direction;
import com.clockworkteaching.sud.model.Player;

public class MoveCommand implements Command {

    Direction direction;
    Player player;

    MoveCommand(Direction direction, Player player) {
        this.direction = direction;
        this.player = player;
    }

    @Override
    public String execute() {
        String resoult;
        boolean hasMove = player.move(direction);
        if (hasMove) {
            resoult = "Poszedłeś w stronę " + direction.getDirectionDescription()
                    + "\n\"Lista npc w tej lokacji: \"+player.getListNPC()" + "\n" + player.exitsLocation();

        } else {
            resoult = "Nie masz wyjścia";
        }
        return resoult;
    }

}
