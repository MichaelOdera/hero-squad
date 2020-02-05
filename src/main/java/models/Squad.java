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
    private String heroname;



    public Squad(Hero hero){
        this.hero = hero;
        this.squadStrength = getSquadStrength();
        this.strength = getPowerMagnitude();
        this.squadName = getSquadName();
        this.size = getAllInstances().size();
        instances.add(this);
        this.heroname = getHero();

    }

    public String getHeroname() {
        return heroname;
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


    public String getHero() {
        return hero.getName();

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


    public int getStrength() {
        return strength;
    }

    public int getPowerMagnitude() {
        return hero.getPowerMagnitude();
    }

    public String getSquadName() {
        return hero.getSquadName();
    }


}
