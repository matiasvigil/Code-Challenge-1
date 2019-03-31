package com.challenge.pacman;

/**
 * @author Matias Vigil
 * @project pacman
 */
public enum Orientation {

    NORTH,
    SOUTH,
    EAST,
    WEST;

    public static Orientation getOrientation(String orientation) {
        if (NORTH.toString().equalsIgnoreCase(orientation)) {
            return NORTH;
        }
        if (SOUTH.toString().equalsIgnoreCase(orientation)) {
            return SOUTH;
        }
        if (EAST.toString().equalsIgnoreCase(orientation)) {
            return EAST;
        }
        if (WEST.toString().equalsIgnoreCase(orientation)) {
            return WEST;
        }
        return null;
    }
}
