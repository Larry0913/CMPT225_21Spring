package com.gameass1;

public class NeutralActor extends Actor {
    public NeutralActor(String name, int level) {
        this.setName(name);
        this.setLevel(level);
    }
    public void talk(Actor actor){
        if(actor instanceof PlayerActor || actor instanceof NeutralActor) {
            System.out.println("Hello " + actor.getName() + " I'm a " + this.getClass().getSimpleName() + ", and my name is "
                    + this.getName() + ", and look like you are a "
                    + actor.getClass().getSimpleName());
        }
        else{
            System.out.println("Missing target！");
        }
    }
}

