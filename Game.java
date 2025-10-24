import java.util.Map;
import java.util.Scanner;

public class Game {
    private Scene currentScene;
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Scene> allScenes;

    public void initializeStory() {
        // Define scenes
        Scene forestEdge = new Scene("You stand at the edge of a dark forest. The trees loom over you, and the path ahead splits into two directions.", false);
        Scene darkPath = new Scene("The path is overgrown and eerie. You can hear rustling in the bushes.", false);
        Scene safeReturn = new Scene("You decide to turn back. The path is familiar and safe, and you return home unharmed.", true);
        Scene mysteriousCave = new Scene("You see a mysterious cave entrance. It's dark and foreboding, but your curiosity gets the best of you.", false);
        Scene treasureRoom = new Scene("You enter the cave and find a room filled with treasure. You've found the legendary treasure of the dark forest!", true);
        Scene monsterLair = new Scene("You enter the cave, but it's a monster's lair. It leaps at you, and you are not prepared. Game over.", true);

        // Add choices and link scenes
        forestEdge.addChoice(1, "Take the dark path.", darkPath);
        forestEdge.addChoice(2, "Turn back and go home.", safeReturn);

        darkPath.addChoice(1, "Investigate the cave entrance.", mysteriousCave);
        darkPath.addChoice(2, "Run away and return home.", safeReturn);

        mysteriousCave.addChoice(1, "Enter the cave.", treasureRoom);
        mysteriousCave.addChoice(2, "Enter the cave.", monsterLair);

        // Store scenes
        allScenes = Map.of(
            "forest_edge", forestEdge,
            "dark_path", darkPath,
            "safe_return", safeReturn,
            "mysterious_cave", mysteriousCave,
            "treasure_room", treasureRoom,
            "monster_lair", monsterLair
        );

        // Set initial scene
        currentScene = forestEdge;
    }

    public void startGame() {
        while (!currentScene.isEnding()) {
            currentScene.displayScene();
            int playerChoice = readPlayerChoice();
            currentScene = currentScene.getNextScene(playerChoice);
        }
        System.out.println(currentScene.getDescription());
    }

    private int readPlayerChoice() {
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (currentScene.getChoices().containsKey(choice)) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}