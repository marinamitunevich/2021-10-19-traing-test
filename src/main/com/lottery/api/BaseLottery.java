package main.com.lottery.api;

public abstract class BaseLottery implements Lottery{

    protected final String lotteryName;

    protected BaseLottery(String lotteryName) {
        this.lotteryName = lotteryName;
    }



    @Override
    public String getLotteryName() {
        return lotteryName;
    }

}
