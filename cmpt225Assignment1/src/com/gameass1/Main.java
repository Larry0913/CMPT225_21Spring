package com.gameass1;

public class Main {

    public static void main(String[] args)  {
        Cast actorList = new Cast(5);
        System.out.println("Welcome to my game! ");
        System.out.println("Let's create some players...");
        actorList.add(new PlayerActor("Larry", 3));
        actorList.add(new PlayerActor("Billy", 4));
        actorList.add(new PlayerActor("Erik", 1));
        actorList.add(new PlayerActor("Leif", 6));
        actorList.add(new PlayerActor("Ryan", 5));
        System.out.println("Let's create some Friendly actors...");
        actorList.add(new FriendlyActor("Jay", 2));
        actorList.add(new FriendlyActor("Sophia", 8));
        actorList.add(new FriendlyActor("Mason", 9));
        actorList.add(new FriendlyActor("West", 7));
        actorList.add(new FriendlyActor("Ariana", 2));
        System.out.println("Let's create some Neutral actors...");
        actorList.add(new NeutralActor("Carl",2 ));
        actorList.add(new NeutralActor("Jack", 3));
        actorList.add(new NeutralActor("Jasmine", 4));
        actorList.add(new NeutralActor("Trevor", 5));
        actorList.add(new NeutralActor("Tom", 6));
        System.out.println("Let's create some Monster actors...");
        actorList.add(new MonsterActor("George", 5));
        actorList.add(new MonsterActor("Janice", 4));
        actorList.add(new MonsterActor("Bryan", 3));
        actorList.add(new MonsterActor("Peter", 6));
        actorList.add(new MonsterActor("Stella", 8));

        System.out.println("Actor creating has finished, the Cast is :");
        System.out.println();
        actorList.print();
        System.out.println();
        System.out.println();
        System.out.println("Print top 5 highest level Actors: ");
        System.out.println();
        actorList.printTop5();
        System.out.println();
        System.out.println();

        PlayerActor playerTest = new PlayerActor("playerTest", 5);
        FriendlyActor friendTest = new FriendlyActor("friendTest", 7);
        NeutralActor neutralTest = new NeutralActor("neutralTest", 0);
        MonsterActor MonsterTest1 = new MonsterActor("monsterTest1", 2);
        MonsterActor MonsterTest2 = new MonsterActor("monsterTest2", 9);
        actorList.add(playerTest);

        System.out.println("Let's start fight test");
        System.out.println();
        playerTest.Fight(MonsterTest1);
        System.out.println();
        friendTest.Fight(MonsterTest1);
        System.out.println();
        MonsterTest1.Fight(playerTest);
        System.out.println();

        System.out.println("Let's start the Monster confidence and challenge test...");
        System.out.println();
        MonsterTest2.Challenge(playerTest);
        System.out.println();
        MonsterTest1.Challenge(playerTest);
        System.out.println();

        System.out.println("Let's start the conversation system test...");
        System.out.println();
        playerTest.talk(friendTest);
        System.out.println();
        playerTest.talk(neutralTest);
        System.out.println();
        friendTest.talk(neutralTest);
        System.out.println();
        neutralTest.talk(playerTest);
        System.out.println();

        System.out.println();
        System.out.println("Let's test adding new actor into actor list... ");
        System.out.println();
        actorList.add(new PlayerActor("Amy", 5));
        actorList.print();
        System.out.println();
        System.out.println("Test whether the actor has been existed in actor list...");
        System.out.println();
        actorList.add(new PlayerActor("Amy", 5));
        System.out.println();
        System.out.println("Test removing the actor from actor list...");
        System.out.println();
        actorList.remove("Amy");
        actorList.print();
        System.out.println();
        System.out.println("The actor Amy has been removed from the actor list..." );


        System.out.println();
        System.out.println("After fight, the playerTest reached top 5 in the actor list: ");
        System.out.println();
        for(int i = 0;i<5;i++)
        {
            playerTest.Fight(MonsterTest1);
        }

        System.out.println();
        System.out.println("Print top 5 highest level Actors: ");
        actorList.printTop5();
        System.out.println();
        System.out.println("Print the final edition of actor list :");
        System.out.println();
        actorList.print();
        System.out.println();
        System.out.println("Thank you for checking my game program(cmpt225assignment1)");
    }
}

