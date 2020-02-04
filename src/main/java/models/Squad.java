package models;

import java.util.ArrayList;

public class Squad {
    private Hero hero;
    private static ArrayList<Squad> instances = new ArrayList<>();



    public Squad(Hero hero){
        this.hero = hero;
        instances.add(this);

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

    public static void setInstances(ArrayList<Squad> instances) {
        Squad.instances = instances;
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
