package com.gameass1;

public class MonsterActor extends Actor {
    public MonsterActor(String name, int level) {
        this.setName(name);
        this.setLevel(level);
    }
    public void Fight(Actor actor) {
        if(actor instanceof PlayerActor || actor instanceof FriendlyActor) {
            this.print();
            System.out.println("attacked the");
            actor.print();
            if(actor.getLevel() > this.getLevel()){
                System.out.println(actor.getName() + " won!!");
                actor.levelUp();
            }
            else{
                System.out.println(this.getName() + " won!!");
                this.levelUp();
            }
        }
        else {
            System.out.println("Missing target！");
        }
    }
    public void Challenge(Actor actor) {
        if(actor instanceof PlayerActor || actor instanceof FriendlyActor) {
            if(actor.getLevel() > this.getLevel()){
                this.print();
                System.out.println("The monster is afraid of fighting");
            }
            else{
                this.print();
                System.out.println("The monster is confident of fighting");
            }
        }
        else {
            System.out.println("Missing target！");
        }
    }

}

