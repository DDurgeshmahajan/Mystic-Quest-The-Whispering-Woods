import java.util.HashMap;
import java.util.Map;

public class Scene {
    private String description;
    private Map<Integer, String> choices = new HashMap<>();
    private Map<Integer, Scene> nextScenes = new HashMap<>();
    private boolean isEnding;

    public Scene(String description, boolean isEnding) {
        this.description = description;
        this.isEnding = isEnding;
    }

    public String getDescription() {
        return description;
    }

    public Map<Integer, String> getChoices() {
        return choices;
    }

    public void addChoice(int choiceNumber, String choiceText, Scene nextScene) {
        choices.put(choiceNumber, choiceText);
        nextScenes.put(choiceNumber, nextScene);
    }

    public void displayScene() {
        System.out.println(description);
        System.out.println("What do you do?");
        choices.forEach((number, text) -> System.out.println(number + ". " + text));
    }

    public Scene getNextScene(int choiceNumber) {
        return nextScenes.getOrDefault(choiceNumber, null);
    }

    public boolean isEnding() {
        return isEnding;
    }
}