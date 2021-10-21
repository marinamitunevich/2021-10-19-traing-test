package main.com.lottery;

import main.com.lottery.api.Lottery;
import main.com.lottery.api.LottoLottery;
import main.com.lottery.api.eurojackpot.EuroJackPotLottery;
import main.com.lottery.menu.MainMenu;
import main.com.lottery.menu.Menu;

import java.util.Scanner;

public enum ApplicationContext {

    INSTANCE;

    private Lottery lottoLottery = new LottoLottery();
    private Lottery euroJackPotLottery = new EuroJackPotLottery();
    private Scanner readerFromConsole = new Scanner(System.in);
    private Menu parentMenu = new MainMenu();

    ApplicationContext() {
    }

    public Lottery getLottoLottery() {
        return lottoLottery;
    }

    public Lottery getEuroJackPotLottery() {
        return euroJackPotLottery;
    }

    public Scanner getReaderFromConsole() {
        return readerFromConsole;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }
}
