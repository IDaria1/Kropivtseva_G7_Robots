package gameRobots;

public class Game {
    public static void main(String[] args) {
        final String EXIT_BUTTON = "P";
        String currentButton;
        String tempSecondRobotName;
        String inputString;

        System.out.println("Initialization first robot name:");
        Robot firstRobot = new Robot(GameMenu.getStringFromConsole());

        do {
            System.out.println("Second robot name should not be equals first robot name." +
                    " \nInitialization unique second robot name:");
            tempSecondRobotName = GameMenu.getStringFromConsole();
        } while (firstRobot.getRobotName().equalsIgnoreCase(tempSecondRobotName));

        Robot secondRobot = new Robot(tempSecondRobotName);

        Robot currentRobot = firstRobot;
        do {
            GameMenu.PrintWelcomeMessage(currentRobot);
            System.out.println("Current robot: " + currentRobot.getRobotName());

            inputString = GameMenu.getStringFromConsole().toUpperCase();
            currentButton = GameMenu.checkInputString(inputString);

            if (currentRobot.isInvalidButton(currentButton) && !(currentButton.equals(EXIT_BUTTON))) {
                System.out.println("Wrong button. Try again!");
            } else if (currentButton.equals(EXIT_BUTTON)) {
                System.out.println("Exiting the game");
            } else {
                if (currentRobot.isActionButton(currentButton)) {
                    if (currentRobot.isActualActionButton(currentButton)) {
                        GameMenu.makeChangesWithSuccessfulHit(currentRobot, firstRobot, secondRobot, currentButton);

                        if (firstRobot.getRobotHealth() <= 0 || secondRobot.getRobotHealth() <= 0) {
                            GameMenu.printWinnersRobotName(currentRobot, firstRobot.getRobotHealth() <= 0, firstRobot, secondRobot);
                            currentButton = EXIT_BUTTON;
                            continue;
                        }
                    } else {
                        GameMenu.makeChangesWithUnsuccessfulHit(currentRobot, currentButton);

                    }
                }
                GameMenu.printRobotHealth(firstRobot, secondRobot);
                currentRobot = GameMenu.changeCurrentRobot(currentRobot, firstRobot, secondRobot);
            }

        } while (!(currentButton.equals(EXIT_BUTTON)));
    }
}
