package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hero {

    public LocalDateTime dayCreated;
    private String name;
    private String power;
    private String weakness;
    private String squadName;
    private static ArrayList<Hero> allheros = new ArrayList<>();
    private boolean populatefirst;
    private int powerMagnitude;
    private int weaknessMagnitude;
    private int age;
    private int id;
    private boolean insquad;




    public Hero(String name, Integer age, String power, String weakness, String squadName){
        this.name = name;
        this.power = power;
        this.weakness = weakness;
        this.populatefirst = false;
        this.age = age;
        this.squadName = squadName;
        this.powerMagnitude = getPowerMagnitude();
        this.weaknessMagnitude = getWeaknessMagnitude();
        this.dayCreated = LocalDateTime.now();
        this.insquad = checkInSquad();
        allheros.add(this);
        this.id = allheros.size();

    }

    //Find  a hero by a particular id
    public static Hero findById(int id) {
        return allheros.get(id-1);
    }

    public boolean checkInSquad(){
        if(!squadName.isEmpty()){
            return true;
        }else{
            return false;
        }
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

    //get the id of a particular post
    public int getId() {
        return id;
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


    //function to calculate magnitude of hero's property
    public int getPowerMagnitude(){
        return power.length();
    }

    public int getWeaknessMagnitude(){
        return weakness.length();
    }

    //getters and setters for a squad name
    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public void update(String name,int age, String power, String weakness, String squad) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.squadName = squad;
        this.weakness = weakness;
    }
}