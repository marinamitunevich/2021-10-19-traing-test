package main.com.lottery.menu;

import main.com.lottery.api.Lottery;
import main.com.lottery.api.LottoLottery;

public class ActiveGame {

    protected Lottery activeGame;

    public ActiveGame() {
        this.activeGame = new LottoLottery();
    }

    public Lottery getActiveGame() {
        return activeGame;
    }

    public void setActiveGame(Lottery activeGame) {
        this.activeGame = activeGame;
    }
}
