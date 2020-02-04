package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class HeroTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
            Hero.clearAllHeros();

    }


    //Create a test instance for the hero class
    private Hero setUpNewHero(){
        return new Hero("Calah", 30,"Arrows", "no-shield", "hunter");
    }


    //Create instance to check if all the values will be returned on entry
    @Test
    public void checkForAnInstanceOfTheClassHero(){
        Hero testHero = new Hero("Shinji", 40,"Thunder", "Speed-low", "panther");
        assertEquals("Shinji", testHero.getName());
        assertEquals("Thunder", testHero.getPower());
        assertEquals("Speed-low", testHero.getWeakness());
    }


    //Create a test tto check that the array gets populated as expected

    @Test
    public void AllHerosAreCorrectlyReturned(){
        Hero firstHero = new Hero("Michy", 30,"Flight", "bad-vision" , "lion");
        Hero secondHero = new Hero("brian", 90,"Flight", "short-hands", "goats");
        assertEquals(2, Hero.getAllHeros().size());
    }



    //Create a test to check if the Hero class can show specific instances of the objects created

    @Test
    public void checkIfHeroIsInstanceOfHeroIfAddedToArray(){
        Hero firstHero = new Hero("Michy", 40,"Flight", "bad-vision", "cheese");
        Hero secondHero = new Hero("brian", 60,"Flight", "short-hands", "deezer");
        assertTrue(Hero.getAllHeros().contains(firstHero));
        assertTrue(Hero.getAllHeros().contains(secondHero));
    }


    //Check that at any given point in time the hero squad will not be populated by default and only by entry
    @Test
    public void TheHeroSquadShouldNeverBePopulatedAtInitialization(){
        Hero checkFirst = new Hero("Mouse", 25, "Ninja", "sneaky", "fizzle");
        assertEquals(false, checkFirst.populateAtFirst());
    }


    //Check that the tim in which a field was entered can be captured correctly
    @Test
    public void getTimeWhenHeroWasCreated_instantiateWith_Today(){
        Hero nowHero = new Hero("Ninja1", 17,"Swords", "shieldless", "sides");
        assertEquals(LocalDateTime.now().getDayOfWeek(), nowHero.getDayCreated().getDayOfWeek());

    }

    @Test
    public void check_IfReturnsTheLengthofWeaknessOrPower(){
        Hero newHero = new Hero("Sammy", 29,"big", "funny", "clears");
        assertEquals(3, newHero.getPowerMagnitude());
        assertEquals(5, newHero.getWeaknessMagnitude());
    }

    @Test
    public void checkForAgeGetter(){
        Hero newHero = new Hero("Sammy", 29,"big", "funny", "deers");
        assertEquals(29, newHero.getAge());
    }

    @Test
    public  void checkIfReturnsId(){
        Hero.clearAllHeros();
        Hero testHero = new Hero("tree", 12, "arms", "cunny", "thrones");
        assertEquals(1, testHero.getId());
    }



    //END OF TESTS TO CHECK FOR CREATION AND READING OF INSERTED ITEMS


}