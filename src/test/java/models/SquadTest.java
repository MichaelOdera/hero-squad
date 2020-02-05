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
        Squad.clearAllinstances();

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
    public void returnInstanceValue_2(){
        Hero testHero = new Hero("thirty", 23, "slim", "travel", "hurry");
        Hero secondHero = new Hero("forty", 60, "tall", "lanky", "pawns");
        Squad secondSquad = new Squad(secondHero);
        Squad testSquad = new Squad(testHero);
        assertEquals(2, Squad.getAllInstances().size());
    }

    @Test
    public void checkIfReturnsTotalStrength_4(){
        Hero testHero = new Hero("thirty", 23, "slim", "travel", "hurry");
        Hero secondHero = new Hero("monty", 35, "huge", "footy", "cow");
        Squad testSquad = new Squad(testHero);
        Squad secondSquad = new Squad(secondHero);
        assertEquals(2, Squad.getSquadStrength());

    }


}