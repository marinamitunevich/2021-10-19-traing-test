package main.com.lottery.menu;

import main.com.lottery.api.Lottery;
import main.com.lottery.api.LottoLottery;
import main.com.lottery.api.eurojackpot.EuroJackPotLottery;
import main.com.lottery.exceptions.IncorrectParameterException;

import java.util.Scanner;

public class UnluckyNumbersMenu extends BaseMenu{

    public UnluckyNumbersMenu(Scanner readerFromConsole, ActiveGame activeGame) {

        super(readerFromConsole);
        this.activeGame = activeGame;
    }

    @Override
    public void showMenu() {

        String readConsole = "" ;
        System.out.println("Menu unlucky numbers:");
        System.out.println("1 - add your unlucky numbers");
        System.out.println("2 - delete your unlucky numbers");
        System.out.println("3 - back to Menu");


            readConsole = super.readerFromConsole.nextLine();
            try {
                switch (readConsole) {
                    case "1":
                        addUnluckyNumbers();
                        break;
                    case "2":
                        activeGame.getActiveGame().removeUnluckyNumbers();
                        break;
                    case "3":
                        break;
                    default:
                        throw new IncorrectParameterException("Incorrect data, enter please again: 1 2 or 3");
                }

            } catch (IncorrectParameterException e) {
                System.out.println(e.getMessages());
                showMenu();
            }


    }

    private void addUnluckyNumbers() {

        activeGame.getActiveGame().addUnluckyNumbers();
    }
}
