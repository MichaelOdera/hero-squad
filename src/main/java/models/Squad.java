package models;

import java.util.ArrayList;

public class Squad {
    private static int total = 0;
    private static int squadStrength;
    private Hero hero;
    private int strength;
    private String squadName;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int size;


    public Squad(Hero hero){
        this.hero = hero;
        this.squadStrength = getSquadStrength();
        this.strength = getPowerMagnitude();
        this.squadName = getSquadName();
        this.size = getAllInstances().size();
        instances.add(this);

    }

    public static int getSquadStrength() {
        return total+instances.size();
    }

    public static void clearAllinstances() {
        instances.clear();
    }


    //Creating setters and getters for hero squad assignments
    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;

    }
    public static ArrayList<Squad> getAllInstances() {
        return instances;
    }

    public void setInstances(ArrayList<Squad> instances) {
        this.instances = instances;
    }


    public int getAge() {
        return hero.getAge();
    }



    public int getPowerMagnitude() {
        return hero.getPowerMagnitude();
    }

    public String getSquadName() {
        return hero.getSquadName();
    }


}
