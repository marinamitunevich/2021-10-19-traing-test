package main.com.lottery.api.eurojackpot;

import main.com.lottery.api.BaseLottery;
import main.com.lottery.exceptions.IncorrectRangeOfUnluckyNumber6from49;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EuroJackPotLottery extends BaseLottery {

    protected EuroJackPot5From50 euroJackPot5From50;
    protected EuroJackPot2From10 euroJackPot2From10;

    public EuroJackPotLottery() {

        super("Eurojackpot");
        euroJackPot5From50 = new EuroJackPot5From50("Eurojackpot5from50");
        euroJackPot2From10 = new EuroJackPot2From10("Eurojackpot2from10");
    }


    @Override
    public List<Integer> generateNumbers() {

      return null;
    }

    @Override
    public List<Integer> getUnluckyNumbers() {
        return null;
    }

    @Override
    public void addUnluckyNumbers() {

        euroJackPot5From50.addUnluckyNumbers();
        euroJackPot2From10.addUnluckyNumbers();
    }

    @Override
    public void removeUnluckyNumbers() {

    }
}
