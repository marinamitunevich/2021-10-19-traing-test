package main.com.lottery;

import main.com.lottery.api.BaseLottery;
import main.com.lottery.api.Lottery;
import main.com.lottery.api.LottoLottery;
import main.com.lottery.menu.ActiveGame;
import main.com.lottery.menu.MainMenu;
import main.com.lottery.menu.Menu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;

public class LotteryApplication {
    public static void main(String[] args) {


//        try {
//            LogManager.getLogManager().readConfiguration(
//                    LotteryApplication.class.getResourceAsStream("/logging.properties"));
//        } catch (IOException e) {
//            System.err.println("Could not setup logger configuration: " + e.toString());
//        }


        Menu mainMenu = new MainMenu();
        mainMenu.showMenu();

    }
}
