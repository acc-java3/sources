package edu.acc.java3.craps;

import java.io.Serializable;
    
public class Player implements Serializable {
    public static final int START = 1;
    public static final int WIN = START + 1;
    public static final int LOSE = WIN + 1;
    public static final int POINT = LOSE + 1;
    
    private int die1;
    private int die2;
    private int sum;
    private int point;
    private int wins;
    private int losses;
    private int bank = 100;
    private int bet;
    private int state;
    private int rolls;
    private int runningBet;

    public int getDie1() {
        return die1;
    }

    public void setDie1(int die1) {
        this.die1 = die1;
    }

    public int getDie2() {
        return die2;
    }

    public void setDie2(int die2) {
        this.die2 = die2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getRolls() {
        return rolls;
    }

    public void setRolls(int rolls) {
        this.rolls = rolls;
    }
    
    public int getRunningBet() {
        return runningBet;
    }
    
    public void setRunningBet(int runningBet) {
        this.runningBet = runningBet;
    }
    
    public int roll() {
        rolls++;
        die1 = 1 + (int)(Math.random() * 6);
        die2 = 1 + (int)(Math.random() * 6);
        return sum = die1 + die2;
    }
    
    public void start() {
        state = START;
        die1 = die2 = sum = point = bet = runningBet = rolls = 0;
    }
    
    public void reset() {
        wins = losses = 0;
        bank = 100;
        start();
    }
    
    public void play() {
        int roll = roll();
        if (state == POINT) {
            if (roll == 7) lose();
            else if (roll == point) win();
        }
        else if (roll == 2 || roll == 3 || roll == 12) lose();
        else if (roll == 7 || roll == 11) win();
        else {
            state = POINT;
            point = roll;
        }
    }
    
    public void win() {
        bank += (runningBet * 2);
        wins++;
        state = WIN;
    }
    
    public void lose() {
        state = LOSE;
        losses++;
    }
    
    public void updateBet(int bet) {
        if (bet < 0)
            throw new IllegalArgumentException("Bet cannot be negative");
        if (bank < bet)
            throw new IllegalArgumentException("Bet cannot exceed bank");
        this.bet = bet;
        bank -= bet;
        runningBet += bet;
    }
}
