package com.gameass1;

public class PlayerActor extends Actor {
    public PlayerActor(String name, int level) {
        this.setName(name);
        this.setLevel(level);
    }
    public void talk(Actor actor){
        if(actor instanceof FriendlyActor || actor instanceof NeutralActor) {
            System.out.println("Hello " + actor.getName() + " I'm a " + this.getClass().getSimpleName() + ", and my name is "
                    + this.getName() + ", and look like you are a "
                    + actor.getClass().getSimpleName());
        }
        else{
            System.out.println("Missing target！");
        }
    }
    public void Fight(Actor actor) {
        if(actor instanceof MonsterActor) {
            this.print();
            System.out.println("attacked the ");
            actor.print();
            if(actor.getLevel() > this.getLevel()){
                System.out.println(actor.getName() + " won!!");
                actor.levelUp();
            }
            else{
                System.out.println(this.getName() + " won!!");
                this.levelUp();
            }
        } else {
            System.out.println("Missing target！");
        }
    }
}
