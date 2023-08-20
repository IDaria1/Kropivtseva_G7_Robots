package gameRobots;

import java.util.Scanner;

public class GameMenu {
    public static String getStringFromConsole(){
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.next();
        }catch (Exception e){
            return "P";
        }
    }

    public static void printRobotHealth(Robot firstRobot, Robot secondRobot){
        System.out.println("Health: ");
        System.out.println(firstRobot.getRobotName() + " - " + firstRobot.getRobotHealth() + ";");
        System.out.println(secondRobot.getRobotName() + " - " + secondRobot.getRobotHealth() + ";");
    }

    public static Robot changeCurrentRobot(Robot currentRobot, Robot firstRobot, Robot secondRobot){
        if (currentRobot == firstRobot){
            currentRobot = secondRobot;
        }else {currentRobot = firstRobot;}
        return currentRobot;
    }

    public static void printWinnersRobotName(Robot currentRobot, boolean successfulHit, Robot firstRobot, Robot secondRobot) {
        if (successfulHit) {
            Robot otherRobot = (currentRobot == firstRobot) ? secondRobot : firstRobot;
            System.out.println("Won by " + currentRobot.getRobotName() + " lost by " + otherRobot.getRobotName() + " !");
        }
    }

    public static void makeChangesWithSuccessfulHit(Robot currentRobot, Robot firstRobot, Robot secondRobot, String incomButton){
        System.out.println("The button has done damage to the enemy robot");
        currentRobot.deleteButtonFromActualActionButtons(incomButton);
        if (currentRobot == firstRobot) {
            secondRobot.reduceRobotHealth();
        } else {
            firstRobot.reduceRobotHealth();
        }
    }

    public static void makeChangesWithUnsuccessfulHit(Robot currentRobot, String incomButton){
        System.out.println("The button did not do any damage.");
        currentRobot.deleteButtonFromActualActionButtons(incomButton);
    }

    public static void PrintWelcomeMessage(Robot currentRobot) {
        System.out.println("Start the move " + currentRobot.getRobotName() + ". Press button please: "
                + currentRobot.validButtons);
    }

    public static String checkInputString(String inputString) {
        if (inputString.length() > 1){
            System.out.println("You entered more than one character. Only the first character will be used.");
            inputString = inputString.substring(0,1);
        }
        return inputString;
    }
}