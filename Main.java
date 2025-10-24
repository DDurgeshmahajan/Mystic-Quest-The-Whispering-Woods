/*
Author: Durgesh Mahajan
Date: 2023-10-15
Project: Choose Your Own Adventure
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.initializeStory();
        game.startGame();
    }
}