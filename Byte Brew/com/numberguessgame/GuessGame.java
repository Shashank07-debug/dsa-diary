package com.numberguessgame;

public class GuessGame {
    static Player p1;
    static Player p2;
    static Player p3;
    static void startGame(){
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean player1 = false;
        boolean player2 = false;
        boolean player3 = false;

        int targetNumber = (int)(Math.random() * 10);
        System.out.println("You have to guess number betweem 0 to 9 : "  +targetNumber);

        while(true){
            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            guessp2 = p2.number;
            guessp3 = p3.number;

            if(targetNumber == guessp1) player1 = true;
            if(targetNumber == guessp2) player2 = true;
            if(targetNumber == guessp3) player3 = true;

            if(player1 || player2 || player3){
                System.out.println("We have our winner ");
                System.out.println("Player 1 ? "+player1);
                System.out.println("Player 2 ? "+player2);
                System.out.println("Player 3 ? "+player3);
                System.out.println("Game Over");
                break;
            }else{
                System.out.println("Try Again ");
            }
        }
    }
}
