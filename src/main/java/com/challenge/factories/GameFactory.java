package com.challenge.factories;

import com.challenge.games.Game;
import com.challenge.games.impl.Pacman;

/**
 * @author Matias Vigil
 * @project pacman
 */
public class GameFactory {
    public static Game getGame(Game.Type type) {
        if(Game.Type.PACMAN.equals(type)) {
            return new Pacman();
        }
        return null;
    }
}
