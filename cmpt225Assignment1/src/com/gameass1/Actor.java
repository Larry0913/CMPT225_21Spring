package com.gameass1;

public class Actor {

    private String name;
    private int level;

    public Actor() {
        name = " ";
        level = 1;
    }
    public Actor(String name, int level) {
        this.name = name;
        this.level = level;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void levelUp() {
        this.level++;
        System.out.println(this.getClass().getSimpleName() +" " + this.getName()
                + " level up ("+(this.level-1) + "->" + (this.level) + ")");
    }
    public void print() {
        System.out.println("Actor_type: " + this.getClass().getSimpleName() + "\tname: " + this.name + "\tlevel: " + this.level);
    }
    public int compareTo(Actor actor) {
        return this.name.compareTo(actor.name);
    }
}
