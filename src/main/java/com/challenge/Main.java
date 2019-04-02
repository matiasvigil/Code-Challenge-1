package com.challenge;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.challenge.factories.GameFactory;
import com.challenge.games.Game;

/**
 * @author Matias Vigil
 * @project pacman
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Game.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ERROR_CONFIGURING_GAME = "Error configuring new game with: ";
    private static final Game.Type GAME_TYPE = Game.Type.PACMAN;

    public static void main(String[] args) {
        Game gameInstance = null;

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.startsWith(Constants.PLACE.toLowerCase()) || line.startsWith(Constants.PLACE.toUpperCase())) {
                gameInstance = getGameInstance(line, gameInstance);
                if (gameInstance == null) {
                    LOGGER.log(Level.SEVERE, ERROR_CONFIGURING_GAME + line);
                }
            }
            if (line.equalsIgnoreCase(Constants.MOVE) && gameInstance != null) {
                gameInstance.move();
            }
            if (line.equalsIgnoreCase(Constants.LEFT) && gameInstance != null) {
                gameInstance.left();
            }
            if (line.equalsIgnoreCase(Constants.RIGHT) && gameInstance != null) {
                gameInstance.right();
            }
            if (line.equalsIgnoreCase(Constants.REPORT) && gameInstance != null) {
                LOGGER.info(gameInstance.report());
            }
        }
    }

    private static Game getGameInstance(String line, Game currentGame) {
        Game game = currentGame;
        try {
            String[] values = line.split(" ")[1].split(",");
            Integer x = Integer.parseInt(values[0]);
            Integer y = Integer.parseInt(values[1]);
            Orientation orientation = Orientation.getOrientation(values[2]);
            if (x != null && y != null && orientation != null) {
                if (game == null) {
                    game = GameFactory.getGame(GAME_TYPE);
                }
                game.setPlace(x, y, orientation);
            } else {
                LOGGER.log(Level.SEVERE, ERROR_CONFIGURING_GAME + line);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, ERROR_CONFIGURING_GAME + line, e);
        }
        return game;
    }
}