package main.com.lottery;

import main.com.lottery.api.BaseLottery;
import main.com.lottery.api.Lottery;
import main.com.lottery.api.LottoLottery;
import main.com.lottery.menu.ActiveGame;
import main.com.lottery.menu.MainMenu;
import main.com.lottery.menu.Menu;

import java.util.Scanner;

public class LotteryApplication {
    public static void main(String[] args) {

        Scanner readerFromConsole = new Scanner(System.in);
        BaseLottery playedLottery;

        ActiveGame activeGame = new ActiveGame();
        Menu mainMenu = new MainMenu(readerFromConsole, activeGame);
        mainMenu.showMenu();

    }
}
