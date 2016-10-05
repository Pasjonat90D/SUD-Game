
package com.clockworkteaching.sud.services;

import com.clockworkteaching.sud.game.ClassicFightStrategy;
import com.clockworkteaching.sud.game.FightStrategy;
import com.clockworkteaching.sud.game.FightThread;
import com.clockworkteaching.sud.model.Direction;
import com.clockworkteaching.sud.model.NPC;
import com.clockworkteaching.sud.model.Player;


public class CommandParser {
    
    public void actOnCommand(String command, Player player){
         command = command.toLowerCase();
        
        String [] splitted = command.split(" ");

        switch (splitted[0]) {
            case "n":
            case "north":
                move(Direction.N, player);
                break;
            case "s":
            case "south":
                move(Direction.S, player);
                break;
            case "e":
            case "east":
                move(Direction.E, player);
                break;
            case "w":
            case "west":
                move(Direction.W, player);
                break;
            case "kill":
                attack(splitted[1],player);
                 break;
            default:
                System.out.println("Nieznana komenda.");
                break;
        }
    }
     public static void move(Direction direction, Player player){
        boolean hasMove = player.move(direction);
        if(hasMove){
           
            System.out.println("Poszedłeś w stronę "+direction.getDirectionDescription());
            System.out.println("Lista npc w tej lokacji: "+player.getListNPC());
            System.out.println(player.exitsLocation());
        } else {
            System.out.println("Nie masz wyjścia");
        }
    }

     public static void attack(String target, Player player) {
        NPC targetNPC = player.getNearbyNPC(target);
        if(target != null){
            beginCombat(player,targetNPC);
        } else {
            System.out.println("Nie można zaatakować");
        }
    }
    private static void beginCombat(Player player, NPC targetNPC) {
       
        FightStrategy fs = new ClassicFightStrategy();
        
        FightThread ft = new FightThread(player, targetNPC, fs );
        Thread t = new Thread(ft);
        t.start();
        
    }
}
