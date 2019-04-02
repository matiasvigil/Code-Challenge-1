package com.challenge.games.impl;

import static com.challenge.Constants.MAX_X;
import static com.challenge.Constants.MAX_Y;
import static com.challenge.Constants.MIN_X;
import static com.challenge.Constants.MIN_Y;

import com.challenge.games.Game;
import com.challenge.Orientation;

/**
 * @author Matias Vigil
 * @project pacman
 */
public class Pacman implements Game {

    private Integer xPosition;
    private Integer yPosition;
    private Orientation facing;

    public void setPlace(Integer x, Integer y, Orientation orientation) {
        this.facing = orientation;
        this.xPosition = x;
        this.yPosition = y;
    }

    public void move() {
        switch (facing) {
            case EAST:
                if (xPosition < MAX_X) {
                    xPosition += 1;
                }
                break;
            case WEST:
                if (xPosition > MIN_X) {
                    xPosition -= 1;
                }
                break;
            case NORTH:
                if (yPosition < MAX_Y) {
                    yPosition += 1;
                }
                break;
            case SOUTH:
                if (yPosition > MIN_Y) {
                    yPosition -= 1;
                }
                break;
        }
    }

    public void left() {
        switch (facing) {
            case EAST:
                facing = Orientation.NORTH;
                break;
            case WEST:
                facing = Orientation.SOUTH;
                break;
            case NORTH:
                facing = Orientation.WEST;
                break;
            case SOUTH:
                facing = Orientation.EAST;
                break;
        }
    }

    public void right() {
        switch (facing) {
            case EAST:
                facing = Orientation.SOUTH;
                break;
            case WEST:
                facing = Orientation.NORTH;
                break;
            case NORTH:
                facing = Orientation.EAST;
                break;
            case SOUTH:
                facing = Orientation.WEST;
                break;
        }
    }

    public String report() {
        return xPosition + "," + yPosition + "," + facing.toString();
    }

}
