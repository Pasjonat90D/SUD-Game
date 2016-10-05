package com.clockworkteaching.sud.game;

import com.clockworkteaching.sud.model.Direction;
import com.clockworkteaching.sud.model.Location;
import com.clockworkteaching.sud.model.NPC;
import com.clockworkteaching.sud.model.Player;
import java.util.Random;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Jak się nazywasz?");
        String namePlayer = scan.nextLine();

        Location locationPlayer = new Location("Lokacja Startowa",
                "Znajdujesz się w przykładowej lokacji startowej");
        Location nextLocation = new Location("Następna lokacja", "Zrobiłeś krok");
        locationPlayer.addDirection(Direction.N, nextLocation);
        nextLocation.addDirection(Direction.S, locationPlayer);
        NPC jon_sell = new NPC("Jon",50,5);
        locationPlayer.addNPC(jon_sell);
        Player player = new Player(namePlayer, nextLocation , 100 , 10);
       

        
        String command = "";
        
        while (!command.equals("zakoncz")) {
            command = readPlayerInput(scan);
            actOnCommand(command, player);
        }
        System.out.println("Do zobaczenia! ");
    }


    private static String readPlayerInput(Scanner scan) {
        System.out.print(">");
        String command = scan.nextLine();
        return command;
    }

    private static void actOnCommand(String command, Player player) {

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
    private static void move(Direction direction, Player player){
        boolean hasMove = player.move(direction);
        if(hasMove){
           
            System.out.println("Poszedłeś w stronę "+direction.getDirectionDescription());
            System.out.println("Lista npc w tej lokacji: "+player.getListNPC());
            System.out.println(player.exitsLocation());
        } else {
            System.out.println("Nie masz wyjścia");
        }
    }

    private static void attack(String target, Player player) {
        NPC targetNPC = player.getNearbyNPC(target);
        if(target != null){
            beginCombat(player,targetNPC);
        } else {
            System.out.println("Nie można zaatakować");
        }
    }

    private static void beginCombat(Player player, NPC targetNPC) {
       
        FightThread ft = new FightThread(player, targetNPC);
        Thread t = new Thread(ft);
        t.start();
        
    }

    
    
}
