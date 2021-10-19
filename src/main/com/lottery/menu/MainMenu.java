package main.com.lottery.menu;


import main.com.lottery.api.BaseLottery;
import main.com.lottery.api.Lottery;
import main.com.lottery.exceptions.IncorrectParameterException;

import java.util.List;
import java.util.Scanner;

public class MainMenu extends BaseMenu {


    public MainMenu(Scanner readerFromConsole, ActiveGame activeGame) {

        super(readerFromConsole);
        this.activeGame = activeGame;

    }

    @Override
    public void showMenu() {

        String readConsole = "" ;

        displayOurMainMenu();

            readConsole = super.readerFromConsole.nextLine();
            try {
                switch (readConsole) {
                    case "1":
                        Menu gameNamesMenu = new GameNamesMenu(super.readerFromConsole, activeGame);
                        gameNamesMenu.showMenu();
                        showMenu();
                        break;
                    case "2":
                        Menu unluckyNumbersMenu = new UnluckyNumbersMenu(super.readerFromConsole, activeGame);
                        unluckyNumbersMenu.showMenu();
                        showMenu();
                        break;
                    case "3":
                        generateNumbers(activeGame.getActiveGame());
                        showMenu();
                        break;
                    case "4":
                        break;
                    default:
                        throw new IncorrectParameterException("Incorrect data, enter please again: 1  2 or 3");
                }

            } catch (IncorrectParameterException e) {
                System.out.println(e.getMessages());
                showMenu();

            }


    }

    private void generateNumbers(Lottery activeGame) {
        List<Integer> generatedNumbers = activeGame.generateNumbers();
        System.out.println(generatedNumbers);
    }

    public static void displayOurMainMenu(){
        System.out.println("Menu:");
        System.out.println("1 - name of the game ");
        System.out.println("2 - unlucky numbers");
        System.out.println("3 - generate a series of numbers");
        System.out.println("4 - exit");
    }
}
