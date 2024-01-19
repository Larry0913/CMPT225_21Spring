package com.gameass1;

public class Cast {
    private int size;
    private int currSize;
    private Actor[] actorList;

    public Cast(int size){
        this.size = size;
        this.currSize = 0;
        actorList = new Actor[size];
    }
    public void add(Actor actor){
        if(this.currSize == size) {
            Actor[] temp = new Actor[currSize];
            for (int i = 0; i < currSize; i++) {
                temp[i] = actorList[i];
            }
            this.size *= 2;
            actorList = new Actor[this.size];
            for (int i = 0; i < currSize; i++) {
                actorList[i] = temp[i];
            }
        }
        if(currSize == 0) {
            actorList[0] = actor;
        }
        else{
            for(int i = 0; i < currSize; i++) {
                if (actor.getName().equals(actorList[i].getName())) {
                    System.out.println(actor.getName() + " has been existed in this game, please select another name!");
                    return;
                }
            }
            int targetIndex = 0;
            for(int i = 0; i < currSize; i++){
                if(actor.compareTo(actorList[i]) < 0){
                    targetIndex = i;
                    break;
                }
            }
            if(targetIndex == 0) {
                actorList[currSize] = actor;
            }else{
                Actor[] newActorList = new Actor[this.size];
                for(int i = 0; i < targetIndex; i++){
                    newActorList[i] = actorList[i];
                }
                newActorList[targetIndex] = actor;
                for(int i = targetIndex + 1; i < currSize+1; i++){
                    newActorList[i] = actorList[i-1];
                }
                this.actorList = newActorList;
            }
        }
        currSize++;
    }
    public void remove(String name){
        if(currSize == 0){
            System.out.println("No actor existed now!");
            return;
        }
        boolean result = false;
        int targetIndex = 0;
        Actor[] newActorList = new Actor[this.size];
        for(int i = 0; i < currSize; i++){
            if(name.equals(actorList[i].getName())){
                result = true;
                targetIndex = i;
            }
        }
        if(result){
            for(int i = 0; i < targetIndex; i++){
                newActorList[i] = actorList[i];
            }
            for(int i = targetIndex + 1; i < currSize+1; i++){
                newActorList[i-1] = actorList[i];
            }
            this.actorList = newActorList;
            currSize--;
        }
        else
        {
            System.out.println("Remove failed, didn't find the target!");
        }
    }

    public void print(){
        for(int i = 0; i < currSize; i++){
            System.out.print(i + "\t");
            actorList[i].print();
        }
    }

    public void printTop5(){
        Actor[] temp = new Actor[currSize];
        for(int i = 0; i < currSize; i++){
            temp[i] = actorList[i];
        }

        Actor temp2;
        for (int i = 0; i < temp.length; i++){
            for (int j = i + 1; j<temp.length; j++){
                if(temp[i].getLevel() < temp[j].getLevel()){
                    temp2 = temp[i];
                    temp[i] = temp[j];
                    temp[j] = temp2;
                }
            }
        }
        for(int i = 0; i < temp.length; i++){
            if(i < 5){
                System.out.print(i + "\t");
                temp[i].print();
            }
        }
    }

}

