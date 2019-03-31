package com.challenge.pacman;

import org.junit.Test;

/**
 * @author Matias Vigil
 * @project pacman
 */
public class Tests {

    @Test
    public void test1() {
        Pacman pacman = new Pacman(0, 0, Orientation.NORTH);
        pacman.move();
        assert pacman.report().equalsIgnoreCase("0,1,NORTH");
    }

    @Test
    public void test2() {
        Pacman pacman = new Pacman(0, 0, Orientation.NORTH);
        pacman.left();
        assert pacman.report().equalsIgnoreCase("0,0,WEST");
    }


    @Test
    public void test3() {
        Pacman pacman = new Pacman(1, 2, Orientation.EAST);
        pacman.move();
        pacman.move();
        pacman.left();
        pacman.move();
        assert pacman.report().equalsIgnoreCase("3,3,NORTH");
    }


    @Test
    public void testDontMoveOffTheGridEast() {
        Pacman pacman = new Pacman(1, 2, Orientation.EAST);
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        assert pacman.report().equalsIgnoreCase("5,2,EAST");
    }

    @Test
    public void testDontMoveOffTheGridWest() {
        Pacman pacman = new Pacman(1, 2, Orientation.WEST);
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        assert pacman.report().equalsIgnoreCase("0,2,WEST");
    }

    @Test
    public void testDontMoveOffTheGridNorth() {
        Pacman pacman = new Pacman(1, 2, Orientation.NORTH);
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        assert pacman.report().equalsIgnoreCase("1,5,NORTH");
    }

    @Test
    public void testDontMoveOffTheGridSouth() {
        Pacman pacman = new Pacman(1, 2, Orientation.SOUTH);
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        assert pacman.report().equalsIgnoreCase("1,0,SOUTH");
    }


    @Test
    public void testLeftCircle() {
        Pacman pacman = new Pacman(1, 2, Orientation.SOUTH);
        pacman.move();
        pacman.left();
        pacman.move();
        pacman.left();
        pacman.move();
        pacman.left();
        pacman.move();
        pacman.left();
        assert pacman.report().equalsIgnoreCase("1,2,SOUTH");
    }
    @Test
    public void testRightCircle() {
        Pacman pacman = new Pacman(1, 2, Orientation.SOUTH);
        pacman.move();
        pacman.right();
        pacman.move();
        pacman.right();
        pacman.move();
        pacman.right();
        pacman.move();
        pacman.right();
        assert pacman.report().equalsIgnoreCase("1,2,SOUTH");
    }
}
