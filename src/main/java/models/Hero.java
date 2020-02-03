package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hero {

    public LocalDateTime dayCreated;
    private String name;
    private String power;
    private String weakness;
    private static ArrayList<Hero> allheros = new ArrayList<>();
    private boolean populatefirst;
    private int powerMagnitude;
    private int weaknessMagnitude;
    private int age;



    public Hero(String name, int age, String power, String weakness){
        this.name = name;
        this.power = power;
        this.weakness = weakness;
        this.populatefirst = false;
        this.age = age;
        this.powerMagnitude = getPowerMagnitude();
        this.weaknessMagnitude = getWeaknessMagnitude();
        this.dayCreated = LocalDateTime.now();
        allheros.add(this);

    }



    public LocalDateTime getDayCreated(){
        return dayCreated;
    }

    //getter and setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void clearAllHeros() {
        allheros.clear();
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //Create a getter for the power of the hero
    public String getPower() {
        return power;
    }


    //Create a setter to the power that is to be entered
    public void setPower(String power) {
        this.power = power;
    }


    //Create a function that get back all the instances of the heros that have been created

    public static ArrayList<Hero> getAllHeros() {
        return allheros;
    }


    //create a function to ensure that the list is never populated before an entry is done

    public Object populateAtFirst() {
        return this.populatefirst;
    }

    public int getPowerMagnitude(){

        return power.length();
    }

    public int getWeaknessMagnitude(){
        return weakness.length();
    }
}