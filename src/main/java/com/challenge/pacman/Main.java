package com.challenge.pacman;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Matias Vigil
 * @project pacman
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Pacman.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ERROR_CONFIGURING_GAME = "Error configuring new game with: ";


    public static void main(String[] args) {
        Pacman pacmanGame = null;
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.startsWith(Constants.PLACE.toLowerCase()) || line.startsWith(Constants.PLACE.toUpperCase())) {
                pacmanGame = getPacmanGame(line, pacmanGame);
                if (pacmanGame == null) {
                    LOGGER.log(Level.SEVERE, ERROR_CONFIGURING_GAME + line);
                }
            }
            if (line.equalsIgnoreCase(Constants.MOVE) && pacmanGame != null) {
                pacmanGame.move();
            }
            if (line.equalsIgnoreCase(Constants.LEFT) && pacmanGame != null) {
                pacmanGame.left();
            }
            if (line.equalsIgnoreCase(Constants.RIGHT) && pacmanGame != null) {
                pacmanGame.right();
            }
            if (line.equalsIgnoreCase(Constants.REPORT) && pacmanGame != null) {
                LOGGER.info(pacmanGame.report());
            }
        }
    }

    private static Pacman getPacmanGame(String line, Pacman currentGame) {
        Pacman game = currentGame;
        try {
            String[] values = line.split(" ")[1].split(",");
            Integer x = Integer.parseInt(values[0]);
            Integer y = Integer.parseInt(values[1]);
            Orientation orientation = Orientation.getOrientation(values[2]);
            if (x != null && y != null && orientation != null) {
                if (game == null) {
                    game = new Pacman(x, y, orientation);
                } else {
                    game.setPlace(x, y, orientation);
                }
            } else {
                LOGGER.log(Level.SEVERE, ERROR_CONFIGURING_GAME + line);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, ERROR_CONFIGURING_GAME + line, e);
        }
        return game;
    }
}