package main.com.lottery.menu;

import main.com.lottery.api.BaseLottery;
import main.com.lottery.api.Lottery;
import main.com.lottery.api.LottoLottery;

import java.util.Scanner;

public abstract class BaseMenu implements Menu{

    protected ActiveGame activeGame;

    protected Scanner readerFromConsole;
    protected Menu parentMenu;

    public BaseMenu(Scanner readerFromConsole) {

        this.readerFromConsole = readerFromConsole;

    }


}
