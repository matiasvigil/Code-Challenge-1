package com.challenge.games;

import com.challenge.Orientation;

/**
 * @author Matias Vigil
 * @project pacman
 */
public interface Game {

    void setPlace(Integer x, Integer y, Orientation orientation);

    void move();

    void left();

    void right();

    String report();

    enum Type {
        PACMAN
    }

}
