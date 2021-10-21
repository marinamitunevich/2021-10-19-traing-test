package main.com.lottery.menu;


import main.com.lottery.ApplicationContext;
import main.com.lottery.api.BaseLottery;
import main.com.lottery.api.Lottery;
import main.com.lottery.api.LottoLottery;
import main.com.lottery.exceptions.IncorrectParameterException;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainMenu extends BaseMenu {

    private static Logger log = Logger.getLogger(BaseLottery.class.getName());

    @Override
    public void showMenu() {

        Scanner readerFromConsole = ApplicationContext.INSTANCE.getReaderFromConsole();

        System.out.println("Menu:");
        System.out.println("1 - choose game and generate numbers");
        System.out.println("2 - unlucky numbers");
        System.out.println("3 - exit");

            String readConsole = readerFromConsole.nextLine();

            Menu nextMenu = null;
                switch (readConsole) {
                    case "1":
                        nextMenu = new GameNamesMenu();
                        nextMenu.showMenu();
                        showMenu();
                        break;
                    case "2":
                        nextMenu = new UnluckyNumbersMenu();
                        nextMenu.showMenu();
                        showMenu();
                        break;
                    case "3":
                        exit();
                        break;
                    default:
                        System.out.println("Incorrect data, enter please again: 1  2 or 3, try again");
                        showMenu();
                }

             if (nextMenu != null) {
                     nextMenu.showMenu();
             }

    }



}
