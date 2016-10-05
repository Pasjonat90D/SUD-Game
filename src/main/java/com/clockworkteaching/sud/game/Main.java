package com.clockworkteaching.sud.game;


import com.clockworkteaching.sud.model.Player;
import com.clockworkteaching.sud.repository.LocationRepository;
import com.clockworkteaching.sud.services.CommandParser;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        LocationRepository locationRepository = new LocationRepository();
        CommandParser parser = new CommandParser();
        Scanner scan = new Scanner(System.in);
        System.out.println("Jak się nazywasz?");

        String namePlayer = scan.nextLine();

        Player player = new Player(namePlayer, locationRepository.getStartLocation(), 100, 10);
        System.out.println("Musisz iść na północ ");

        String command = "";

        while (!command.equals("zakoncz")) {
            command = readPlayerInput(scan);
            parser.actOnCommand(command, player);
        }
        System.out.println("Do zobaczenia! ");
    }

    private static String readPlayerInput(Scanner scan) {
        System.out.print(">");
        String command = scan.nextLine();
        return command;
    }

}
