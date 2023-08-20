package gameRobots;

import java.util.Random;

public class Robot {
    private String robotName;
    private int robotHealth = 100;
    final String validButtons = "QWEASDZXC";
    private String alphabet = validButtons;
    private String actionButton = setActionButton();
    private String actualActionButtons = actionButton;


    public Robot(String robotName) {
        this.robotName = robotName;
    }

    public String getRobotName() {
        return robotName;
    }

    public int getRobotHealth() {
        return robotHealth;
    }

    char getRandomKey(){
        int randIdx = new Random().nextInt(alphabet.length());
        char randChar = alphabet.charAt(randIdx);
        alphabet = alphabet.replace(String.valueOf(randChar), "");
        return randChar;
    }

    String setActionButton(){
        String tempActionButtons = "";
        for (int i = 0; i < 5; i++) {
            tempActionButtons = tempActionButtons + getRandomKey();
        }
        return tempActionButtons;
    }

    String deleteButtonFromActualActionButtons(String incomButton){
        actualActionButtons = actualActionButtons.replaceFirst(incomButton, "");
        return actualActionButtons;
    }

    public int reduceRobotHealth() {
        return robotHealth = robotHealth - 20;
    }


    public boolean isActionButton(String currentButton) {
        return actionButton.indexOf(currentButton) != -1;
    }

    public boolean isActualActionButton(String currentButton) {
        return actualActionButtons.indexOf(currentButton) != -1;
    }

    public boolean isInvalidButton(String currentButton) {
        return validButtons.indexOf(currentButton) == -1;
    }
}