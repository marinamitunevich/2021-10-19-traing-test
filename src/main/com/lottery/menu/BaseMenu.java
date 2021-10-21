package main.com.lottery.menu;

import main.com.lottery.api.BaseLottery;
import main.com.lottery.api.Lottery;
import main.com.lottery.api.LottoLottery;

import java.util.Scanner;

public abstract class BaseMenu implements Menu{


    protected Menu parentMenu;


    protected void exit() {
        System.exit(0);
    }


}
