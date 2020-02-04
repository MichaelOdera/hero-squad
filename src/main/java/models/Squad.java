package models;

import java.util.ArrayList;

public class Squad {
    private static int total;
    private static int squadStrength;
    private static Hero hero;
    private String squadName;
    private static ArrayList<Squad> instances = new ArrayList<>();



    public Squad(Hero hero){
        this.hero = hero;
        this.total = 0;
        this.squadStrength = getSquadStrength();
        this.squadName = getSquadName();
        instances.add(this);

    }

    public static int getSquadStrength() {
        return total += hero.getPowerMagnitude();
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
