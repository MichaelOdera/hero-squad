package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testIfIsInstanceOfHero(){
        Hero testHero = new Hero("thirty", 23, "slim", "travel", "hurry");
        Squad testSquad = new Squad(testHero);
        assertEquals(true, testSquad instanceof Squad);
    }

    @Test
    public void testIfGetsproperties(){
        Hero testHero = new Hero("thirty", 23, "slim", "travel", "hurry");
        Squad testSquad = new Squad(testHero);
        assertEquals(testHero, testSquad.getHero());
    }

    @Test
    public void checkIfReturnsAge_23(){
        Hero testHero = new Hero("thirty", 23, "slim", "travel", "hurry");
        Squad testSquad = new Squad(testHero);
        assertEquals(23, testSquad.getAge());
    }

    @Test
    public void checkIfCapturesMagnitude_4(){
        Hero testHero = new Hero("thirty", 23, "slim", "travel", "hurry");
        Squad testSquad = new Squad(testHero);
        assertEquals(4, testSquad.getPowerMagnitude());

    }

    @Test
    public void checkIfReturnsNameOfSquad_hurry(){
        Hero testHero = new Hero("thirty", 23, "slim", "travel", "hurry");
        Squad testSquad = new Squad(testHero);
        assertEquals("hurry", testSquad.getSquadName());
    }

    @Test
    public void checkIfReturnsTotalStrength_10(){
        Hero testHero = new Hero("cow", 12,"bonus", "slip", "skiers");
        Hero secondHero = new Hero("cat", 23, "bonus", "sleepy","conan");
        ArrayList<Squad> squads = new ArrayList<>();
        Squad testSquad = new Squad(testHero);
        Squad secondSquad = new Squad(secondHero);
        assertEquals(10, Squad.getSquadStrength());
    }
}