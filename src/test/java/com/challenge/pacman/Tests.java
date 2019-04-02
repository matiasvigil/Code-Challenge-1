package com.challenge.pacman;

import com.challenge.Orientation;
import com.challenge.factories.GameFactory;
import com.challenge.games.Game;
import org.junit.Test;

/**
 * @author Matias Vigil
 * @project pacman
 */
public class Tests {

    @Test
    public void test1() {
        Game pacman = GameFactory.getGame(Game.Type.PACMAN);
        pacman.setPlace(0, 0, Orientation.NORTH);
        pacman.move();
        assert pacman.report().equalsIgnoreCase("0,1,NORTH");
    }

    @Test
    public void test2() {
        Game pacman = GameFactory.getGame(Game.Type.PACMAN);
        pacman.setPlace(0, 0, Orientation.NORTH);
        pacman.left();
        assert pacman.report().equalsIgnoreCase("0,0,WEST");
    }


    @Test
    public void test3() {
        Game pacman = GameFactory.getGame(Game.Type.PACMAN);
        pacman.setPlace(1, 2, Orientation.EAST);
        pacman.move();
        pacman.move();
        pacman.left();
        pacman.move();
        assert pacman.report().equalsIgnoreCase("3,3,NORTH");
    }


    @Test
    public void testDontMoveOffTheGridEast() {
        Game pacman = GameFactory.getGame(Game.Type.PACMAN);
        pacman.setPlace(1, 2, Orientation.EAST);
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        assert pacman.report().equalsIgnoreCase("5,2,EAST");
    }

    @Test
    public void testDontMoveOffTheGridWest() {
        Game pacman = GameFactory.getGame(Game.Type.PACMAN);
        pacman.setPlace(1, 2, Orientation.WEST);
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        assert pacman.report().equalsIgnoreCase("0,2,WEST");
    }

    @Test
    public void testDontMoveOffTheGridNorth() {
        Game pacman = GameFactory.getGame(Game.Type.PACMAN);
        pacman.setPlace(1, 2, Orientation.NORTH);
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        assert pacman.report().equalsIgnoreCase("1,5,NORTH");
    }

    @Test
    public void testDontMoveOffTheGridSouth() {
        Game pacman = GameFactory.getGame(Game.Type.PACMAN);
        pacman.setPlace(1, 2, Orientation.SOUTH);
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        pacman.move();
        assert pacman.report().equalsIgnoreCase("1,0,SOUTH");
    }


    @Test
    public void testLeftCircle() {
        Game pacman = GameFactory.getGame(Game.Type.PACMAN);
        pacman.setPlace(1, 2, Orientation.SOUTH);
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
        Game pacman = GameFactory.getGame(Game.Type.PACMAN);
        pacman.setPlace(1, 2, Orientation.SOUTH);
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
